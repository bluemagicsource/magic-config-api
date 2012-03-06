package org.bluemagic.config.api.exception;

import org.bluemagic.config.api.property.MissingProperty;

public class MissingPropertyException extends RuntimeException {

	private static final long serialVersionUID = -4956531768306541487L;

	private MissingProperty property;
	
	public MissingPropertyException(MissingProperty property) {

		super(property.toString());
		this.setProperty(property);
	}

	public MissingProperty getProperty() {
		return property;
	}

	public void setProperty(MissingProperty property) {
		this.property = property;
	}
}
