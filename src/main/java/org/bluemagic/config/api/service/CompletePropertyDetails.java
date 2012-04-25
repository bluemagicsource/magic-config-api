package org.bluemagic.config.api.service;

import java.net.URI;
import java.util.Collection;

import org.bluemagic.config.api.property.MagicProperty;
import org.bluemagic.config.api.tag.Tag;

public class CompletePropertyDetails extends PropertyDetails {

	private Collection<Tag> attributes;
	
	public CompletePropertyDetails(MagicProperty property, 
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