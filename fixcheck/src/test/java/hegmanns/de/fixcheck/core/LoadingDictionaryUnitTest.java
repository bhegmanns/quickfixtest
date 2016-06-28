package hegmanns.de.fixcheck.core;

import org.junit.Test;

public class LoadingDictionaryUnitTest {
	
	static class AbstractFixImpl extends AbstractFix{

		protected AbstractFixImpl(String xmlDictionaryFile) {
			super(xmlDictionaryFile, true);
		}
	}

	@Test
	public void specLoad55(){
		new AbstractFixImpl("FIX50.xml");
	}
	
	@Test
	public void specLoad50SP2(){
		new AbstractFixImpl("FIX50SP2.xml");
	}
	
	@Test
	public void commonLoad(){
		new AbstractFixImpl("FIX_cd.xml");
	}
	
}
