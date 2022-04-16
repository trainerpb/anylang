package anylang.scriptrunner.factory;

import anylang.scriptrunner.ScriptRunner;
import anylang.scriptrunner.ScriptType;
import anylang.scriptrunner.exceptions.UnsupportedScriptTypeException;
import anylang.scriptrunner.factory.impl.JavaSEScriptRunner;
import anylang.scriptrunner.factory.impl.JavaScriptRunner;
import anylang.scriptrunner.factory.impl.PythonScriptRunner;

public class ScriptRunnerFactory {

	public static ScriptRunner getScriptRunner(ScriptType scriptType) {
		switch (scriptType) {
		case JAVASCRIPT:
			return new JavaScriptRunner();
		case PYTHON:
			return new PythonScriptRunner();
		case JAVA:
			return new JavaSEScriptRunner();
		case NODE:
			throw new UnsupportedScriptTypeException(scriptType.name() + " is not suppored");
		
		case SCALA: // We are on it already to provide support for Scala
			throw new UnsupportedScriptTypeException(scriptType.name() + " is not suppored");
		default:
			throw new UnsupportedScriptTypeException(scriptType.name() + " is not suppored");
		}
		

	}
}
