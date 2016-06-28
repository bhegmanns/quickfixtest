package hegmanns.de.fixcheck.core;

public class FixEncoder extends AbstractFix{
	public FixEncoder(String xmlDefinition){
		super(xmlDefinition, true);
	}
	
	public FixEncoder(FixSpecification fixSpecification){
		this(fixSpecification.getXmlDatadictionaryFile());
	}
}
