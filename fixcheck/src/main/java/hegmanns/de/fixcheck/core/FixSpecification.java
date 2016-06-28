package hegmanns.de.fixcheck.core;

public enum FixSpecification {

	FIX50("FIX50.xml"), FIX50SP2("FIX50SP2.xml"), FIX41("FIX41.xml"), FIX_CD_PAKET1(""), FIX_CD_PAKET2("");
	
	private String xmlDatadictionaryFile;
	private FixSpecification(){}
	
	private FixSpecification(String xmlDatadictionaryFile){
		this.xmlDatadictionaryFile = xmlDatadictionaryFile;
	}
	
	public String getXmlDatadictionaryFile(){
		return new String(xmlDatadictionaryFile);
	}
}
