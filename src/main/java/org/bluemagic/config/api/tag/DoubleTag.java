package org.bluemagic.config.api.tag;

/**
 * This is a Java representation that encapsulates a doubletag.
 * A doubletag consists of a key/value pair
 * A simple example would be something like release=12.0_SNAPSHOT
 * where the key is "release" and the value is "12.0_SNAPSHOT"
 * 
 * This tag will be useful when needing to add some context to a singletag
 *
 */
public class DoubleTag extends SingleTag {

	private String keyValueSeparator = "=";
	
	private String key = "";
	
	
	public DoubleTag() { }
	
	public DoubleTag(String key, String value) {
		this.key = key;
		this.value = value;
	}
	
	@Override
	public boolean equals(Object obj) {
	
		boolean equals = false;
		
		if (obj instanceof DoubleTag) {
			DoubleTag other = (DoubleTag) obj;
			
			String otherKey = other.getKey();
			String otherValue = other.getValue();
			
			if (otherKey.equals(this.getKey()) && otherValue.equals(this.getValue())) {
				equals = true;
			}
		}
		return equals;
	}
	
	@Override
	public String toString() {
		
		StringBuilder b = new StringBuilder();
		
		b.append(this.key);
		b.append(this.keyValueSeparator);
		b.append(getValue());
		
		return b.toString();
	}
	
	@Override
	public int hashCode() {
		return key.hashCode() + value.hashCode();
	}
	
	public void setKey(String key) {
		this.key = key;
	}

	public String getKey() {
		return key;
	}

	public String getKeyValueSeparator() {
		return keyValueSeparator;
	}

	public void setKeyValueSeparator(String keyValueSeparator) {
		this.keyValueSeparator = keyValueSeparator;
	}
}
