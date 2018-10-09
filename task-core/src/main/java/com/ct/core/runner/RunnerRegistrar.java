package com.ct.core.runner;

import com.ct.core.annotation.Runner;
import com.ct.core.annotation.RunnerClients;
import com.ct.core.client.RunnerInvokerDef;
import com.ct.core.rpc.JettyServer;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanClassLoaderAware;
import org.springframework.beans.factory.annotation.AnnotatedBeanDefinition;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.AbstractBeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.EnvironmentAware;
import org.springframework.context.ResourceLoaderAware;
import org.springframework.context.annotation.ClassPathScanningCandidateComponentProvider;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.env.Environment;
import org.springframework.core.io.ResourceLoader;
import org.springframework.core.type.AnnotationMetadata;
import org.springframework.core.type.filter.AnnotationTypeFilter;
import org.springframework.util.Assert;
import org.springframework.util.ClassUtils;
import org.springframework.util.StringUtils;

import java.lang.annotation.Annotation;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @ Author     ：libin
 * @ Date       ：Created in 19:09 2018/9/13
 * @ Description：执行器初始化服务
 * @ Modified By：
 * @Version: $version$
 */
public class RunnerRegistrar implements ImportBeanDefinitionRegistrar, ApplicationContextAware, EnvironmentAware, BeanClassLoaderAware, ResourceLoaderAware {

    private Environment environment;

    private ClassLoader classLoader;

    private ResourceLoader resourceLoader;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {

    }

    @Override
    public void registerBeanDefinitions(AnnotationMetadata importingClassMetadata, BeanDefinitionRegistry beanDefinitionRegistry) {
        //初始化rpc server
        Map<String, Object> attrs = importingClassMetadata.getAnnotationAttributes(RunnerClients.class.getName());
        String port = (String) attrs.get("port");
        String appkey = (String) attrs.get("appkey");
        JettyServer.start(Integer.parseInt(port), null, null);
        //初始化rpc server 完成
        //初始化 runner
        ClassPathScanningCandidateComponentProvider scanner = getScanner();
        scanner.setResourceLoader(this.resourceLoader);
        //设置过滤条件 Runner 注解
        AnnotationTypeFilter annotationTypeFilter = new AnnotationTypeFilter(Runner.class);
        scanner.addIncludeFilter(annotationTypeFilter);
        //读取RunnerClients 的包设置
        Set<String> basePackages = getBasePackages(importingClassMetadata);
        //遍历包
        for (String basePackage : basePackages) {
            Set<BeanDefinition> candidateComponents = scanner
                    .findCandidateComponents(basePackage);
            for (BeanDefinition candidateComponent : candidateComponents) {
                if (candidateComponent instanceof AnnotatedBeanDefinition) {
                    //验证是否为接口
                    AnnotatedBeanDefinition beanDefinition = (AnnotatedBeanDefinition) candidateComponent;
                    AnnotationMetadata annotationMetadata = beanDefinition.getMetadata();

                    Assert.isTrue(annotationMetadata.isConcrete(), "@Runner can only be specified on an class");

                    Map<String, Object> attributes = annotationMetadata
                            .getAnnotationAttributes(Runner.class.getCanonicalName());
                    String className = annotationMetadata.getClassName();
                    String beanclass = beanDefinition.getBeanClassName();

                    String[] interfaceNames = annotationMetadata.getInterfaceNames();

                    Assert.isTrue(Arrays.asList(interfaceNames).contains(RunnerInvokerDef.class.getName()), "@Runner class must implement interface RunnerInvokerDef ");

                    String appName = (String) attributes.get("appname");

                    //注册到spring
                    BeanDefinitionBuilder beanDefinitionBuilder = BeanDefinitionBuilder.genericBeanDefinition(RunnerBeanDefinition.class);
                    AbstractBeanDefinition rawBeanDefinition = beanDefinitionBuilder.getRawBeanDefinition();
                    rawBeanDefinition.getPropertyValues().addPropertyValue("appKey", appkey);
                    rawBeanDefinition.getPropertyValues().addPropertyValue("appName", appName);
                    rawBeanDefinition.getPropertyValues().addPropertyValue("ref", beanDefinition);
                    registerBean(appkey, rawBeanDefinition, beanDefinitionRegistry);
                }
            }
        }

    }

    /**
     * @param beanName
     * @param beanDefinition
     * @desc 向spring容器注册bean
     */
    private static void registerBean(String beanName, BeanDefinition beanDefinition, BeanDefinitionRegistry registry) {
        registry.registerBeanDefinition(beanName, beanDefinition);
    }


    protected Set<String> getBasePackages(AnnotationMetadata importingClassMetadata) {
        Map<String, Object> attributes = importingClassMetadata
                .getAnnotationAttributes(RunnerClients.class.getCanonicalName());

        Set<String> basePackages = new HashSet<>();
        for (String pkg : (String[]) attributes.get("value")) {
            if (StringUtils.hasText(pkg)) {
                basePackages.add(pkg);
            }
        }

        //读取包配置路径
        for (String pkg : (String[]) attributes.get("basePackages")) {
            if (StringUtils.hasText(pkg)) {
                basePackages.add(pkg);
            }
        }

        if (basePackages.isEmpty()) {
            basePackages.add(
                    ClassUtils.getPackageName(importingClassMetadata.getClassName()));
        }
        return basePackages;
    }


    protected ClassPathScanningCandidateComponentProvider getScanner() {
        return new ClassPathScanningCandidateComponentProvider(false, this.environment) {

            @Override
            protected boolean isCandidateComponent(
                    AnnotatedBeanDefinition beanDefinition) {
                if (beanDefinition.getMetadata().isIndependent()) {
                    if (beanDefinition.getMetadata().isInterface()
                            && beanDefinition.getMetadata()
                            .getInterfaceNames().length == 1
                            && Annotation.class.getName().equals(beanDefinition
                            .getMetadata().getInterfaceNames()[0])) {
                        try {
                            Class<?> target = ClassUtils.forName(
                                    beanDefinition.getMetadata().getClassName(),
                                    RunnerRegistrar.this.classLoader);
                            return !target.isAnnotation();
                        } catch (Exception ex) {
                            this.logger.error(
                                    "Could not load target class: "
                                            + beanDefinition.getMetadata().getClassName(),
                                    ex);

                        }
                    }
                    return true;
                }
                return false;

            }
        };
    }

    @Override
    public void setEnvironment(Environment environment) {
        this.environment = environment;
    }

    @Override
    public void setBeanClassLoader(ClassLoader classLoader) {
        this.classLoader = classLoader;
    }

    @Override
    public void setResourceLoader(ResourceLoader resourceLoader) {
        this.resourceLoader = resourceLoader;
    }
}
