package com.tosuki;

import org.apache.catalina.Context;
import org.apache.catalina.LifecycleException;
import org.apache.catalina.startup.Tomcat;
import org.apache.tomcat.util.descriptor.web.FilterDef;
import org.apache.tomcat.util.descriptor.web.FilterMap;

import java.io.File;

public class HttpServer {
    private String getAppBase() {
        return ".";
    }

    private String getContextDirectory() {
        return new File(System.getProperty("java.io.tmpdir")).getAbsolutePath();
    }

    private void addHttpFilters(Tomcat tomcat, Context tomcatContext) {
        FilterDef filterDef = new FilterDef();

        filterDef.setFilterClass(HttpFilter.class.getName());
        filterDef.setFilterName(HttpFilter.class.getSimpleName());

        tomcatContext.addFilterDef(filterDef);

        FilterMap filterMap = new FilterMap();

        filterMap.setFilterName(HttpFilter.class.getSimpleName());
        filterMap.addURLPattern("/my-servlet/*");

        tomcatContext.addFilterMap(filterMap);
    }

    public void start(int port, String hostname) throws LifecycleException {
        Tomcat tomcat = new Tomcat();

        tomcat.setPort(port);
        tomcat.getConnector();
        tomcat.setHostname(hostname);

        tomcat.getHost().setAppBase(getAppBase());

        Context tomcatContext = tomcat.addContext("", getContextDirectory());

        Tomcat.addServlet(tomcatContext, HttpServletImpl.class.getSimpleName(), HttpServletImpl.class.getName());
        tomcatContext.addServletMappingDecoded("/*", HttpServletImpl.class.getSimpleName());

        addHttpFilters(tomcat, tomcatContext);

        tomcat.start();
        tomcat.getServer().await();
    }
}
