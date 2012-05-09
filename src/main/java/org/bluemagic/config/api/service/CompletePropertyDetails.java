package org.bluemagic.config.api.service;

import java.net.URI;
import java.util.Collection;
import java.util.Map.Entry;

import org.bluemagic.config.api.tag.Tag;

public class CompletePropertyDetails extends PropertyDetails {

	private Collection<Tag> attributes;
	
	public CompletePropertyDetails(Entry<URI,Object> property, 
			                       Collection<URI> tagDetails, 
			                       Collection<Tag> attributes) {
		super(property, tagDetails);
		this.setAttributes(attributes);
	}

	public Collection<Tag> getAttributes() {
		return attributes;
	}

	public void setAttributes(Collection<Tag> attributes) {
		this.attributes = attributes;
	}

}