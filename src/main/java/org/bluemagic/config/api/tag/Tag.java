package org.bluemagic.config.api.tag;

/**
 * This interface encapsulates a Tag
 *
 * @see http://en.wikipedia.org/wiki/Tag_(metadata)
 */
public interface Tag {
	
	public char[] INVALID_WINDOWS_CHARACTERS = { ':', '*', '\\', '<', '>', '|', '?' };
	
	public char[] INVALID_LINUX_CHARACTERS = { '/' };
	
	public enum Encoding { NONE, WEB, FILE }
	
	/**
	 * This gets the representation of a Tag
	 * 
	 * @return String version of the Tag
	 */
	public String toString();
	
	/**
	 * This gets the representation of a Tag with a particular encoding
	 * 
	 * @param Encoding type to convert the tag to
	 * 
	 * @return String version of the Tag
	 */
	public String toString(Encoding encoding);
}
