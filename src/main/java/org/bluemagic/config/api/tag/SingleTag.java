package org.bluemagic.config.api.tag;


/**
 * This class is a Java representation of a singletag, also known as a meta-tag.
 * Optional prefix and suffix can be applied as a convieniece to modifying the tag value
 * to different types
 */
public class SingleTag implements Tag {
	
	protected String value = "";
	
	private Visibility visibility = Tag.Visibility.PUBLIC;
	
	private Obligation obligation = Tag.Obligation.MANDATORY;
	
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
	public int hashCode() {
		return value.hashCode();
	}

	public void setValue(String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}

	@Override
	public Obligation getObligation() {
		return obligation;
	}

	public void setObligation(Obligation obligation) {
		this.obligation = obligation;
	}

	@Override
	public Visibility getVisibility() {
		return visibility;
	}

	public void setVisibility(Visibility visibility) {
		this.visibility = visibility;
	}
}
