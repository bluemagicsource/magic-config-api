package org.bluemagic.config.api.service;

import java.util.Collection;

import org.bluemagic.config.api.tag.Tag;

public class TagDetails {

	private Tag tag;
	private Collection<Tag> attributes;
	
	public TagDetails(Tag tag, Collection<Tag> attributes) {
		this.tag = tag;
		this.attributes = attributes;
	}

	public Tag getTag() {
		return tag;
	}

	public void setTag(Tag tag) {
		this.tag = tag;
	}

	public Collection<Tag> getAttributes() {
		return attributes;
	}

	public void setAttributes(Collection<Tag> attributes) {
		this.attributes = attributes;
	}

}
