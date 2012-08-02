package org.bluemagic.config.api.tag;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

/**
 * This class is a Java representation of a singletag, also known as a meta-tag.
 * Optional prefix and suffix can be applied as a convieniece to modifying the tag value
 * to different types
 */
public class SingleTag implements Tag {
	
	protected String value = "";
	
	public SingleTag() { }
	
	public SingleTag(String value) {
		this.value = value;
	}
	
	@Override
	public boolean equals(Object obj) {
	
		boolean equals = false;
		
		if (obj instanceof SingleTag) {
			SingleTag other = (SingleTag) obj;
			
			if (other.getValue().equals(this.getValue())) {
				equals = true;
			}
		}
		return equals;
	}

	@Override
	public String toString() {
		return getValue();
	}
	
	@Override
	public String toString(Encoding encoding) {
		return encodeString(this.value, encoding);
	}
	
	public String encodeString(String unencoded, Encoding encoding) {
		
		String encoded = "";
		
		if (encoding == Encoding.FILE) {
			
			String property = System.getProperty("os.name");
			if (property.toLowerCase().startsWith("linux") || property.toLowerCase().startsWith("mac")) {
				encoded = unencoded.replaceAll("/", "");
				
			} else {
				encoded = encoded.replaceAll(":", "");
				encoded = encoded.replaceAll("\\*", "");
				encoded = encoded.replaceAll("\\\"", "");
				encoded = encoded.replaceAll("<", "");
				encoded = encoded.replaceAll(">", "");
				encoded = encoded.replaceAll("|", "");
				encoded = encoded.replaceAll("\\\\", "");
				encoded = encoded.replaceAll("\\?", "");
			}
		} else if (encoding == Encoding.WEB) {
			try {
				encoded = URLEncoder.encode(unencoded, "UTF-8");
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			}
			
		} else {
			encoded = unencoded;
		}
		return encoded;
	}
	
	@Override
	public int hashCode() {
		return value.hashCode();
	}

	public void setValue(String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}
}
