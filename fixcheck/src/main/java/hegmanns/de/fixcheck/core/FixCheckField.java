package hegmanns.de.fixcheck.core;

import quickfix.DataDictionary;

public class FixCheckField {

	private long tagNumber;
	private String description;
	private String originalValue;
	private String convertedValue;
	private String valueDescription;
	
	private DataDictionary dictionary;
	public static FixCheckField instance(long tagNumber, DataDictionary dictionary){
		FixCheckField field = new FixCheckField();
		field.tagNumber = tagNumber;
		field.dictionary = dictionary;
		return field;
	}
	
	public FixCheckField build(){
		description = dictionary.getValueName((int)this.tagNumber, "UNKNOWN:" + this.tagNumber);
		return this;
	}
	
	public static FixCheckField instance(long tagNumber){
		FixCheckField field = new FixCheckField();
		field.tagNumber = tagNumber;
		return field;
	}
	
	public FixCheckField description(String description){
		this.description = description;
		return this;
	}
	
	public FixCheckField originalValue(String originalValue){
		this.originalValue = originalValue;
		return this;
	}
	
	public FixCheckField convertedValue(String convertedValue){
		this.convertedValue = convertedValue;
		return this;
	}
	
	public FixCheckField valueDescription(String valueDescription){
		this.valueDescription = valueDescription;
		return this;
	}

	public long getTagNumber() {
		return tagNumber;
	}

	public String getDescription() {
		return description;
	}

	public String getOriginalValue() {
		return originalValue;
	}

	public String getConvertedValue() {
		return convertedValue;
	}

	public String getValueDescription() {
		return valueDescription;
	}
	
	
	
	
}
