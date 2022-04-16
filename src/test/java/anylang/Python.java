package anylang;

import static org.junit.Assert.assertEquals;

import java.io.IOException;
import java.io.StringWriter;

import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

import org.junit.jupiter.api.Test;
import org.python.core.PyObject;
import org.python.util.PythonInterpreter;

import anylang.example.MainClass_Example.Student;
import anylang.scriptloader.ScriptSource;
import anylang.scriptloader.factory.ScriptLoaderFactory;
import anylang.scriptrunner.ScriptType;
import anylang.scriptrunner.factory.ScriptRunnerFactory;
import anylang.scriptrunner.factory.impl.PythonScriptRunner;
import anylang.scriptrunner.models.AbstractTextScript;

class Python {

	@Test
	void test() {
		new ScriptEngineManager().getEngineFactories().forEach(System.out::println);
		try (PythonInterpreter pyInterp = new PythonInterpreter()) {
			execfile("D:\\boka\\a.py", pyInterp);
			
			
		}
	}

	@Test
	public void givenPythonInterpreter_whenPrintExecuted_thenOutputDisplayed() {
		try (PythonInterpreter pyInterp = new PythonInterpreter()) {
			StringWriter output = new StringWriter();
			pyInterp.setOut(output);

			pyInterp.exec("print('Hello Baeldung Readers!!')");
			assertEquals("Should contain script output: ", "Hello Baeldung Readers!!", output.toString().trim());
			System.out.println(output.toString());
		}
	}

	void execfile(final String fileName, PythonInterpreter interpreter) {
		interpreter.execfile(fileName);
		PyObject obj= interpreter.eval("my_function(21)");
		System.out.println(obj);
		System.out.println(interpreter.get("x"));
	}
	@Test
	public void calculateDiscount() throws IOException, ScriptException {
		
		Object x=calculateDiscount("Female");
		System.err.println("calculateDiscount"+x);
		
	}
	private static Object calculateDiscount(final String sex) throws IOException, ScriptException {
		
		final String ruleId="sistersDayDiscount";
		
		AbstractTextScript script=(AbstractTextScript) ScriptLoaderFactory.getScriptLoader(ScriptSource.FILE).load("D:\\python\\a.py");
		script.setScriptName(ruleId);
		PythonScriptRunner jsr = (PythonScriptRunner) ScriptRunnerFactory.getScriptRunner(ScriptType.PYTHON);
		Object result=jsr.execute(script, sex);								
		return result;
	}

}
