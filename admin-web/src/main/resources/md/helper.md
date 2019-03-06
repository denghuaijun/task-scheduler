# 帮助文档  

#### 一、项目介绍

&emsp;&emsp;本项目作为互联网开发不大健康团队独立搭建的分布式调度项目，项目工程名为（**task_scheduler**），此项目旨在将调度系统独立于业务系统，可以独立维护，不影响正常业务流程及功能。  

#### 二、软件架构  

&emsp;&emsp;架构主要基于springboot+springCloud技术实现，分为3大模块：  
&emsp;&emsp;1. **task-core** ：调度核心模块：  
&emsp;&emsp;此模块主要进行对RPC技术的封装及Eureka的实现，作为此架构的核心底层，后面2各模块均需要依赖此模块。  

&emsp;&emsp; 2. **可视化服务端（admin-web）**：  
&emsp;&emsp;此模块主要作为调度任务的服务端，进行任务的管理，后台可视化界面的展示，可以用于新建任务，对定时任务的管理；主要以下功能：  
&emsp;&emsp;任务管理、任务运行器管理、任务日志查看、告警信息管理等。  

&emsp;&emsp; 3. **运行器客户端（task-client）**：  
&emsp;&emsp;此模块主要作为调度任务的客户端，主要进行调度任务的具体执行业务逻辑，然后可以在服务端进行对具体任务进行管理。

#### 三、访问地址

 &emsp;&emsp;分布式调度系统可视化界面生产地址：<http://healthcareadmin.tk.cn/tasklist>
 
 &emsp;&emsp;分布式调度系统可视化界面测试地址：<http://10.130.215.190:8086/tasklist>

#### 四、分布式调度系统后端使用说明

&emsp;&emsp;\* 任务管理  

 &emsp;&emsp;&emsp; 通过任务管理菜单中的 _新增任务_进行添加需要执行的定时任务，包括任务名称，cron表达式，关联的任务运行器即具体的任务名称，  
               及关联告警账号，当任务服务端执行任务出现异常报500时将会想该账号发送报警信息。  
 
&emsp;&emsp;\* 任务运行器管理

 &emsp;&emsp;&emsp; 任务运行器管理，主要用于查看当前的已经有的定时任务，及新增任务运行器的功能，这个模块是与后端具体调度任务有紧密联系，    
                当有新的调度任务需求时，可以将调度任务根据各自的appname及appkey来进行新增运行器，同时可以在任务管理模块进行对该任务的执行进行管理。
 
&emsp;&emsp;\* 任务日志查看

 &emsp;&emsp;&emsp; 主要用来查看任务运行的日志，及返回信息，用来跟踪和定位任务的执行情况。
 
 &emsp;&emsp;\* 告警信息管理
 
   &emsp;&emsp;&emsp; 主要用管理任务服务端出现异常时发送报警的用户信息管理，可以查看当前配置的告警账户及新增新的告警账户。
  

#### 五、参与贡献

1. 分布式调度系统
2. 参考markdown官网<http://markdownpad.com>
3. 系统由泰康在线互联网开发部进行维护
4. 项目路径 <http://gitlab.it.taikang.com/zx_basearchitecture/task_scheduler.git>


#### 六、码云特技

1. 使用 Readme\_XXX.md 来支持不同的语言，例如 Readme\_en.md, Readme\_zh.md
2. 码云官方博客 [blog.gitee.com](https://blog.gitee.com)
3. 你可以 [https://gitee.com/explore](https://gitee.com/explore) 这个地址来了解码云上的优秀开源项目
4. [GVP](https://gitee.com/gvp) 全称是码云最有价值开源项目，是码云综合评定出的优秀开源项目
5. 码云官方提供的使用手册 [http://git.mydoc.io/](http://git.mydoc.io/)
6. 码云封面人物是一档用来展示码云会员风采的栏目 [https://gitee.com/gitee-stars/](https://gitee.com/gitee-stars/)