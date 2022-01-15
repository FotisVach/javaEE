package com.javaee.fotis;

import java.io.FileReader;
import java.io.IOException;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import org.apache.maven.model.Model;
import org.apache.maven.model.io.xpp3.MavenXpp3Reader;
import org.codehaus.plexus.util.xml.pull.XmlPullParserException;

/**
 * PoC Servlet Context Listener
 */
@SuppressWarnings("nls")
@WebListener
public class MyContextListener implements ServletContextListener {

	/**
	 * Current System time when app start running
	 */
	Long startTime;
	
	@Override
	public void contextInitialized(ServletContextEvent sce) {
		startTime = System.currentTimeMillis();
		sce.getServletContext().log(">>>Custom Servlet Context Listener");
		sce.getServletContext().setSessionTimeout(1);
		// Get pom version from pom xml - we display this in navbar
		MavenXpp3Reader reader = new MavenXpp3Reader();
		String version;
        try {
			Model model = reader.read(new FileReader("pom.xml"));
			version = model.getVersion();
		} catch (IOException | XmlPullParserException e) {
			version = "Unknown version";
		}
		sce.getServletContext().setAttribute("projectVersion", version);
	}

	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		System.out.println("\n>>>Stopping server"); //$NON-NLS-1$
		Long secondsPassed = (System.currentTimeMillis() - startTime) / 1000;
		System.out.println(">>>Custom Servlet Context Listener Destroyed. App was running for: " + secondsPassed);
	}

}
