package com.vito16.shop.test;

import java.io.File;

import org.apache.catalina.Context;
import org.apache.catalina.LifecycleException;
import org.apache.catalina.startup.Tomcat;

/**
 * @author 木鱼 muyu@yiji.com
 * @version 2014/11/26
 */
public class TomcatEmbeddedRunner {
    public void startServer() throws LifecycleException {
        Tomcat tomcat = new Tomcat();
        tomcat.setPort(8080);
        File base = new File(System.getProperty("java.io.tmpdir"));
        Context rootCtx = tomcat.addContext("/app", base.getAbsolutePath());
        rootCtx.addServletMapping("/date", "dateServlet");
        tomcat.start();
        tomcat.getServer().await();
    }
}
