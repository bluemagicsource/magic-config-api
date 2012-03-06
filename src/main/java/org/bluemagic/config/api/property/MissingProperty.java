package org.bluemagic.config.api.property;

import java.net.URI;

import org.bluemagic.config.api.Location;
import org.bluemagic.config.api.exception.MissingPropertyException;

public class MissingProperty implements MagicProperty {

	private URI key;
	
	private URI missingUri;
	
	private Class<? extends Location> locatorClass;
	
	public MissingProperty(URI key, URI missingUri, Class<? extends Location> locatorClass) {
		this.key = key;
		this.missingUri = missingUri;
		this.locatorClass = locatorClass;
	}

	public Object getValue() { 
		throw new MissingPropertyException(this);
	}
	
	@Override
	public String toString() {
		
		StringBuilder b = new StringBuilder();
		
		b.append("Missing property for key: ");
		b.append(key);
		b.append(" at ");
		b.append(missingUri);
		b.append(" using: ");
		b.append(locatorClass.getName());
		
		return b.toString();
	}
	
	public URI getMissingUri() {
		return missingUri;
	}

	public void setMissingUri(URI missingUri) {
		this.missingUri = missingUri;
	}

	public Class<? extends Location> getLocatorClass() {
		return locatorClass;
	}

	public void setLocatorClass(Class<? extends Location> locatorClass) {
		this.locatorClass = locatorClass;
	}

	public URI getKey() {
		return key;
	}

	public void setKey(URI key) {
		this.key = key;
	}
}
