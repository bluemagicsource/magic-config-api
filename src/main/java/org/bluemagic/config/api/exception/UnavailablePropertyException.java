package org.bluemagic.config.api.exception;

import org.bluemagic.config.api.property.UnavailableProperty;

public class UnavailablePropertyException extends RuntimeException {

	private static final long serialVersionUID = -4956531768306541477L;

	private UnavailableProperty property;
	
	public UnavailablePropertyException(UnavailableProperty property) {

		super(property.toString());
		this.setProperty(property);
	}

	public UnavailableProperty getProperty() {
		return property;
	}

	public void setProperty(UnavailableProperty property) {
		this.property = property;
	}
}
