package org.bluemagic.config.api.property;

import java.net.URI;

public class CachedProperty extends LocatedProperty {

	public CachedProperty(URI original, URI cached, Object value, Class<?> cachingClass) {
		super(original, cached, value, cachingClass);
	}
	
	@Override
	public String toString() {
		
		StringBuilder b = new StringBuilder();
		
		b.append("Cached property for key: ");
		b.append(getKey());
		b.append(" with value: ");
		b.append(getValue());
		b.append(" from: ");
		b.append(getLocatorClass().getName());
		b.append(" cache");
		
		return b.toString();
	}
}
