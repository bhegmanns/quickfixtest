package de.hegmanns.javacodegenerator;

import java.io.File;
import java.util.List;

import org.apache.maven.plugin.AbstractMojo;
import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.plugin.MojoFailureException;
import org.apache.maven.plugins.annotations.LifecyclePhase;
import org.apache.maven.plugins.annotations.Mojo;
import org.apache.maven.plugins.annotations.Parameter;
import org.apache.maven.project.MavenProject;

import de.hegmanns.javacodegenerator.MessageCodeGenerator.Task;

/**
 * 
 * @author B. Hegmanns
 */
@Mojo(name = "fix-metamodell-builder", defaultPhase = LifecyclePhase.GENERATE_SOURCES)
public class JavaCodeGenerator extends AbstractMojo{
	public static final String BASE_PACKAGE = "quickfix";
	public static final String FIELD_PACKAGE_PART = "field";
	public static final String MESSAGE_PACKAGE_PART = "message";
	
	@Parameter( defaultValue = "target/generated-sources/java-code-generator", property = "outputDir", required = false )
    private File outputDirectory;
	
	@Parameter( property = "inputDir", required = true)
	private File inputDirectory;
	
	@Parameter( defaultValue = "xml", property = "basePackage", required = false)
	private String basePackage;
	
	@Parameter( defaultValue = "FIX-GEN", property = "taskname", required = false)
	private String taskname;
	
	@Parameter(property = "filename", required = true)
	private List<String> files;
	
	@Parameter(defaultValue = "${project}", required = true)
	private MavenProject project;

	/**
	 * 
	 */
	public void execute() throws MojoExecutionException, MojoFailureException {
		getLog().info("**** >>>> start generating FIX-code <<<< ****");
		for (String filename : files){
			getLog().info("**** generate for file '" + filename + "' ****");
			MessageCodeGenerator messageCodeGenerator = new MessageCodeGenerator(getLog());
		
			Task task = setDefaultValues(new Task());
			setCommonValues(task, filename);
		
			messageCodeGenerator.generate(task);
			this.project.addCompileSourceRoot(this.outputDirectory.getAbsolutePath());
			getLog().info("add '" + this.outputDirectory.getAbsolutePath() + "' as additional compile source directory");
		}
	}
	
	private Task setDefaultValues(Task task){
		task.setDecimalGenerated(true);
		task.setOverwrite(false);
		task.setOrderedFields(false);
		
		task.setFieldPackage(BASE_PACKAGE + "." + FIELD_PACKAGE_PART);
		task.setMessagePackage(BASE_PACKAGE + "." + MESSAGE_PACKAGE_PART);
		task.setTransformDirectory("src/main/resources/transform");
		task.setOutputBaseDirectory("target/generated-sources/java-code-generator");
		
		return task;
	}
	
	private Task setCommonValues(Task task, String filename){
		task.setName(taskname);
		task.setSpecification(inputDirectory.getPath() + filename);
		
		return task;
	}
	

}
