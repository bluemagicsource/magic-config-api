package org.bluemagic.config.api.tag;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

/**
 * This class is a Java representation of a singletag, also known as a meta-tag.
 * Optional prefix and suffix can be applied as a convieniece to modifying the tag value
 * to different types
 */
public class SingleTag implements Tag {
	
	protected String prefix = "";
	
	protected String suffix = "";
	
	protected String value = "";
	
	public SingleTag() { }
	
	public SingleTag(String value) {
		this.value = value;
	}
	
	public SingleTag(String prefix, String value, String suffix) {
		
		setPrefix(prefix);
		this.value = value;
		setSuffix(suffix);
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
		return prefix.hashCode() + value.hashCode() + suffix.hashCode();
	}
	
	public String getPrefix() {
		return prefix;
	}
	
	public String getSuffix() {
		return suffix;
	}
	
	public String getValue() {
		return prefix + value + suffix;
	}

	public void setValue(String value) {
		
		if ((prefix.length() > 0) && (value.startsWith(prefix))) {
			value = value.replaceFirst(prefix, "");
		}
		if ((suffix.length() > 0) && (value.endsWith(suffix))) {
			value = value.substring(0, value.length() - suffix.length());
		}
		this.value = value;
	}
	
	public void setSuffix(String suffix) {
		if (suffix != null) {
			this.suffix = suffix;
		}
	}
	
	public void setPrefix(String prefix) {
		if (prefix != null) {
			this.prefix = prefix;
		}
	}
}
