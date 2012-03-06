package org.bluemagic.config.api.property;

import java.net.URI;

public class DefaultProperty extends LocatedProperty {

	public DefaultProperty(URI key, Object value, Class<?> storageClass) {
		super(key, null, value, storageClass);
	}
	
	@Override
	public String toString() {
		
		StringBuilder b = new StringBuilder();
		
		b.append("Retrieved default property for key: ");
		b.append(getKey());
		b.append(" with value: ");
		b.append(getValue());
		b.append(" from: ");
		b.append(getLocatorClass().getName());
		
		return b.toString();
	}
}
