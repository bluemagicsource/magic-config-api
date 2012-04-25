package org.bluemagic.config.api.service;

import java.net.URI;
import java.util.Collection;
import java.util.Collections;

import org.bluemagic.config.api.property.MagicProperty;

public class PropertyDetails {

	/**
	 * The Property these details are associated with.
	 */
	private MagicProperty property;
	
	/**
	 * A collection of URI's that link to the details of each tag.
	 */
	private Collection<URI> tagDetails;

	public PropertyDetails(MagicProperty property, Collection<URI> tagDetails) {
		this.property = property;
		this.tagDetails = tagDetails;
	}

	public MagicProperty getProperty() {
		return property;
	}

	public void setProperty(MagicProperty property) {
		this.property = property;
	}

	public Collection<URI> getTagDetails() {
		if (tagDetails == null) {
			return Collections.emptyList();
		}
		
		return tagDetails;
	}

	public void setTagDetails(Collection<URI> tagDetails) {
		this.tagDetails = tagDetails;
	}
}
