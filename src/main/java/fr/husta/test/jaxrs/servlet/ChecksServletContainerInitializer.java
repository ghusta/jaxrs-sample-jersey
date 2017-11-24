package fr.husta.test.jaxrs.servlet;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.management.MBeanServer;
import javax.servlet.ServletContainerInitializer;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import java.lang.management.ManagementFactory;
import java.util.Set;

public class ChecksServletContainerInitializer implements ServletContainerInitializer
{

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Override
    public void onStartup(Set<Class<?>> c, ServletContext ctx) throws ServletException
    {
        logger.debug("onStartup...");

        MBeanServer mbs = ManagementFactory.getPlatformMBeanServer();
        logger.debug("JMX > MBeanServer : {}", mbs);
        logger.debug("JMX > getMBeanCount : {}", mbs.getMBeanCount());
    }

}
