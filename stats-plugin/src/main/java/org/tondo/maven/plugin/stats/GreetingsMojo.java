package org.tondo.maven.plugin.stats;

import org.apache.maven.execution.MavenSession;
import org.apache.maven.plugin.AbstractMojo;
import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.plugin.MojoFailureException;
import org.apache.maven.plugins.annotations.Mojo;
import org.apache.maven.plugins.annotations.Parameter;

@Mojo(name = "hello")
public class GreetingsMojo extends AbstractMojo {

	@Parameter(property = "hello.userName", defaultValue = "${prject.version}")
	private String userName;

	@Parameter(defaultValue = "${session}", readonly = true, required = true)
	protected MavenSession session;

	public void execute() throws MojoExecutionException, MojoFailureException {

		for (Object object : getPluginContext().entrySet()) {
			getLog().info(object.toString());
		}
		getLog().info("Ahoj " + session);
		getLog().info("***** " + session.getRequest().getBaseDirectory());
	}

}
