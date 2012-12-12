package org.bluemagic.config.api.tag;

/**
 * This interface encapsulates a Tag
 *
 * @see http://en.wikipedia.org/wiki/Tag_(metadata)
 */
public interface Tag {
	
	public enum Visibility { PUBLIC,PRIVATE };
	
	public enum Obligation { MANDATORY,OPTIONAL };
	
	public Visibility getVisibility();
	
	public Obligation getObligation();
	
	/**
	 * This gets the representation of a Tag
	 * 
	 * @return String version of the Tag
	 */
	public String toString();
}
