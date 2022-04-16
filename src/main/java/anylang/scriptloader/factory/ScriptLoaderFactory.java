package anylang.scriptloader.factory;

import anylang.scriptloader.ScriptLoader;
import anylang.scriptloader.ScriptSource;
import anylang.scriptloader.exceptions.UnsupportedScriptSourceException;
import anylang.scriptloader.factory.impl.AwsScriptLoader;
import anylang.scriptloader.factory.impl.FileScriptLoader;
import anylang.scriptloader.factory.impl.HttpScriptLoader;
import anylang.scriptloader.factory.impl.TCPScriptLoader;

public class ScriptLoaderFactory {

	/**
	 * @param scriptSource
	 * @return appropriate script loader
	 * To Add your own SOURCE, add
     * the type in anylang.scriptloader.ScriptSource
	 * and provide implementation here 
	 */
	public static ScriptLoader getScriptLoader(ScriptSource scriptSource) {
		switch(scriptSource) {
		case FILE:
			return new FileScriptLoader();
		case TCP:
			// Provide and return TCP implementation
			return new TCPScriptLoader();
		case HTTP:
			return new HttpScriptLoader();
		case AWS_S3:
			return new AwsScriptLoader();
			
		default:
			throw new UnsupportedScriptSourceException(scriptSource.name()+" is not supported yet!");
		}
		
		
	}
}
