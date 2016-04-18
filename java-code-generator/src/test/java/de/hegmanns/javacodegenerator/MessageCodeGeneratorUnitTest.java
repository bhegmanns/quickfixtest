package de.hegmanns.javacodegenerator;

import org.apache.maven.plugin.logging.SystemStreamLog;
import org.junit.Test;

import de.hegmanns.javacodegenerator.MessageCodeGenerator.Task;

public class MessageCodeGeneratorUnitTest {

	MessageCodeGenerator messageCodeGenerator = new MessageCodeGenerator(new SystemStreamLog());
	
	private Task erstelleTask(){
		Task task = new Task();
		task.setDecimalGenerated(true);
		task.setFieldPackage("quickfix.fix.fields");
		task.setMessagePackage("quickfix.fix.messages");
		task.setName("Task -1-");
		task.setOrderedFields(false);
		task.setOutputBaseDirectory("target/generated-sources/quickfixout");
		task.setOverwrite(false);
		task.setSpecification("src/test/resources/FIX50SP2.xml"); // eigentlich die Datei
		task.setTransformDirectory("src/test/resources/transform");
		return task;
	}
	@Test
	public void foo(){
		Task task = erstelleTask();
		messageCodeGenerator.generate(task);
	}
}
