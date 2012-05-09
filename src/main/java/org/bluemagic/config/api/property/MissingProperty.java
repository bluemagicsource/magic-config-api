package org.bluemagic.config.api.property;

import java.net.URI;
import java.util.Map.Entry;

import org.bluemagic.config.api.Location;
import org.bluemagic.config.api.exception.MissingPropertyException;

public class MissingProperty implements Entry<URI,Object> {

	private URI original;
	
	private URI missing;
	
	private Class<? extends Location> locatorClass;
	
	public MissingProperty(URI original, URI missing, Class<? extends Location> locatorClass) {
		this.original = original;
		this.missing = missing;
		this.locatorClass = locatorClass;
	}

	@Override
	public String toString() {
		
		StringBuilder b = new StringBuilder();
		
		b.append("Missing property for key: ");
		b.append(original);
		b.append(" at ");
		b.append(missing);
		b.append(" using: ");
		b.append(locatorClass.getName());
		
		return b.toString();
	}
	
	public URI getMissing() {
		return missing;
	}

	public void setMissing(URI missing) {
		this.missing = missing;
	}

	public Class<? extends Location> getLocatorClass() {
		return locatorClass;
	}

	public void setLocatorClass(Class<? extends Location> locatorClass) {
		this.locatorClass = locatorClass;
	}

	public URI getKey() {
		return missing;
	}

	public void setKey(URI key) {
		this.missing = key;
	}
	
	
	public Object getValue() { 
		throw new MissingPropertyException(this);
	}
	
	public Object setValue(Object value) {
		throw new UnsupportedOperationException("There is no value for a Missing Property!");
	}

	public URI getOriginal() {
		return original;
	}

	public void setOriginal(URI original) {
		this.original = original;
	}
}
