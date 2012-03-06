package org.bluemagic.config.api.property;

import java.net.URI;

public class LocatedProperty implements MagicProperty {

	private URI key;
	
	private URI location;

	private Object value;
	
	private Class<?> locatorClass;

	public LocatedProperty(URI key, URI location, Object value, Class<?> locatorClass) {
		this.key = key;
		this.location = location;
		this.value = value;
		this.locatorClass = locatorClass;
	}
	
	@Override
	public String toString() {
		
		StringBuilder b = new StringBuilder();
		
		b.append("Located property for key: ");
		b.append(key);
		b.append(" with value: ");
		b.append(value);
		b.append(" at ");
		b.append(location);
		b.append(" using: ");
		b.append(locatorClass.getName());
		
		return b.toString();
	}

	public URI getKey() {
		return key;
	}

	public void setKey(URI key) {
		this.key = key;
	}

	public URI getLocation() {
		return location;
	}

	public void setLocation(URI location) {
		this.location = location;
	}

	public Object getValue() {
		return value;
	}

	public void setValue(Object value) {
		this.value = value;
	}

	public Class<?> getLocatorClass() {
		return locatorClass;
	}

	public void setLocatorClass(Class<?> locatorClass) {
		this.locatorClass = locatorClass;
	}
}
