package hegmanns.de.fixcheck.core;

import quickfix.ConfigError;
import quickfix.DataDictionary;

public abstract class AbstractFix {

	private DataDictionary dataDictionary;
	private String xmlDictionaryFile;
	protected AbstractFix(String xmlDictionaryFile){
		this(xmlDictionaryFile, false);
	}
	
	protected AbstractFix(String xmlDictionaryFile, boolean preload){
		this.xmlDictionaryFile = xmlDictionaryFile;
		this.dataDictionary = loadDataDictionary();
	}
	
	protected DataDictionary getDataDictionary(){
		if (dataDictionary == null){
			dataDictionary = loadDataDictionary();
		}
		
		return dataDictionary;
	}
	
	private DataDictionary loadDataDictionary(){
		try {
			return new DataDictionary(xmlDictionaryFile);
		} catch (ConfigError e) {
			throw new RuntimeException("Couldn't load dictionary-file '" + xmlDictionaryFile + "': ", e);
		}
	}
}
