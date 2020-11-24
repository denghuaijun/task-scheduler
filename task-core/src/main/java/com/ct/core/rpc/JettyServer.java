package com.ct.core.rpc;

import lombok.extern.slf4j.Slf4j;
import org.eclipse.jetty.server.Connector;
import org.eclipse.jetty.server.Handler;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.ServerConnector;
import org.eclipse.jetty.server.handler.HandlerCollection;
import org.eclipse.jetty.util.thread.ExecutorThreadPool;

import java.util.HashMap;
import java.util.Map;

/**
 * @ Author     ：libin
 * @ Date       ：Created in 19:09 2018/9/13
 * @ Description：${description}
 * @ Modified By：
 * @Version: $version$
 */
@Slf4j
public class JettyServer {

    private static Server server;
    private static Thread thread;

    public static void start(final int port, final String ip, final String appName) {
        // 开启线程 初始换Jetty容器,注册handler,
        thread = new Thread(new Runnable() {
            @Override
            public void run() {
                // The Server
                server = new Server(new ExecutorThreadPool());
                // HTTP connector
                ServerConnector connector = new ServerConnector(server);
                if (ip!=null && ip.trim().length()>0) {
                    connector.setHost(ip);	// The network interface this connector binds to as an IP address or a hostname.  If null or 0.0.0.0, then bind to all interfaces.
                }
                connector.setPort(port);
                server.setConnectors(new Connector[]{connector});

                // Set a handler
                HandlerCollection handlerc =new HandlerCollection();
                handlerc.setHandlers(new Handler[]{new ServerInvokeHandler()});
                server.setHandler(handlerc);
                try {
                    // Start server
                    server.start();
                    log.info("server start success at port:{}.", port);
                    server.join();	// block until thread stopped
                    log.info("server join success, server:{}, port:{}", JettyServer.class.getName(), port);
                } catch (Exception e) {
                    log.error(e.getMessage(), e);
                } finally {
                    //destroy();
                }
            }
        });
        thread.setDaemon(true);
        thread.start();
    }

    public void destroy() {

        // destroy server
        if (server != null) {
            try {
                server.stop();
                server.destroy();
            } catch (Exception e) {
                log.error(e.getMessage(), e);
            }
        }
        if (thread.isAlive()) {
            thread.interrupt();
        }

        log.info("server destroy success, server:{}", JettyServer.class.getName());
    }

    public static void main(String[] args) {
        Map map = new HashMap<>();
    }

}
