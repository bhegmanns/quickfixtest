package hegmanns.de.fixcheck.core;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class LoadingDictionaryOverSpecificationUnitTest {
	
	static class AbstractFixImpl extends AbstractFix{

		protected AbstractFixImpl(String xmlDictionaryFile) {
			super(xmlDictionaryFile, true);
		}
	}

	@Parameters(name = "{0}")
	public static List<Object[]> params(){
		 List<Object[]> liste = null;
		 Object[] oneArray = null;
		 liste = new ArrayList<>();
		 for (FixSpecification spec : FixSpecification.values()){
			 oneArray = new Object[1];
			 oneArray[0] = spec;
			 liste.add(oneArray);
		 }
		 
//		 Function<FixSpecification, Object[]> ff = new Function<FixSpecification, Object[]>() {
//
//			@Override
//			public Object[] apply(FixSpecification t) {
//				Object[] o = new Object[1];
//				o[0] = t;
//				return o;
//			}
//		};
		 
//		 liste = Arrays.stream(FixSpecification.values())
//		 	.flatMap((f) -> {Object[] o = new Object[1]; o[0] = f}).collect(Collectors.toList());
		 
//		Object[] array = Arrays.asList(FixSpecification.FIX50).toArray(new Object[1]);
//		
//		 liste = Arrays.stream(FixSpecification.values())
//				 .flatMap((s) -> Arrays.asList(s).toArray(new Object[1])).collect(Collectors.toList());
		
		 return liste;
	}
	
	private FixSpecification fixSpecification;
	public LoadingDictionaryOverSpecificationUnitTest(FixSpecification fixSpecification){
		this.fixSpecification = fixSpecification;
	}
	
	@Test
	public void specificationContainsXmlFile(){
		MatcherAssert.assertThat(this.fixSpecification.getXmlDatadictionaryFile(), Matchers.not(Matchers.isEmptyOrNullString()));
	}
	
	@Test
	public void loadOverSpecification(){
		new AbstractFixImpl(this.fixSpecification.getXmlDatadictionaryFile());
	}
}
