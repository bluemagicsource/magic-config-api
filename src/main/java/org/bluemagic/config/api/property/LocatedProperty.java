package org.bluemagic.config.api.property;

import java.net.URI;
import java.util.Map.Entry;

public class LocatedProperty implements Entry<URI,Object> {

	private URI original;
	
	private URI located;

	private Object value;
	
	private Class<?> locatorClass;

	public LocatedProperty(URI original, URI located, Object value, Class<?> locatorClass) {
		this.original = original;
		this.located = located;
		this.value = value;
		this.locatorClass = locatorClass;
	}
	
	@Override
	public String toString() {
		
		StringBuilder b = new StringBuilder();
		
		b.append("Property for key: ");
		b.append(original);
		b.append(" with value: ");
		b.append(value);
		b.append(" at ");
		b.append(located);
		b.append(" using: ");
		b.append(locatorClass.getName());
		
		return b.toString();
	}

	public URI getKey() {
		return located;
	}

	public void setKey(URI key) {
		this.located = key;
	}

	public URI getLocation() {
		return located;
	}

	public void setLocation(URI located) {
		this.located = located;
	}

	public Object getValue() {
		return value;
	}

	public Object setValue(Object value) {
		this.value = value;		
		return value;
	}

	public Class<?> getLocatorClass() {
		return locatorClass;
	}

	public void setLocatorClass(Class<?> locatorClass) {
		this.locatorClass = locatorClass;
	}

	public URI getOriginal() {
		return original;
	}

	public void setOriginal(URI original) {
		this.original = original;
	}
}
