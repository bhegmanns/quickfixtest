package hegmanns.de.fixcheck.core;

import java.util.ArrayList;
import java.util.List;

public class FixCheckMessage {

	private List<FixCheckField> field;
	
	public FixCheckMessage(){
		this.field = new ArrayList<>();
	}
	
	public void add(FixCheckField field){
		this.field.add(field);
	}
	
	public void addRepeating(List<FixCheckField> repeatingDefinition, List<FixCheckField> fields){
		this.field.addAll(repeatingDefinition);
		this.field.addAll(fields);
	}
	
	
}
