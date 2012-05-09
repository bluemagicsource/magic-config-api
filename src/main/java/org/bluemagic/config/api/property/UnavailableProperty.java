package org.bluemagic.config.api.property;

import java.net.URI;
import java.util.Map.Entry;

import org.bluemagic.config.api.Location;
import org.bluemagic.config.api.exception.UnavailablePropertyException;

public class UnavailableProperty implements Entry<URI,Object> {

	private URI key;
	
	private URI unavailableUri;
	
	private Class<? extends Location> locatorClass;
	
	private Throwable reason;
	
	public UnavailableProperty(URI key, URI unavailableUri, Class<? extends Location> locatorClass, Throwable reason) {
		this.key = key;
		this.setUnavailableUri(unavailableUri);
		this.locatorClass = locatorClass;
		this.reason = reason;
	}

	@Override
	public String toString() {
		
		StringBuilder b = new StringBuilder();
		
		b.append("Unavailable property for key: ");
		b.append(key);
		b.append(" at ");
		b.append(unavailableUri);
		b.append(" using: ");
		b.append(locatorClass.getName());
		b.append(" because: ");
		b.append(reason.getMessage());
		
		return b.toString();
	}

	public URI getKey() {
		return key;
	}

	public void setKey(URI key) {
		this.key = key;
	}

	public Class<? extends Location> getLocatorClass() {
		return locatorClass;
	}

	public void setLocatorClass(Class<? extends Location> locatorClass) {
		this.locatorClass = locatorClass;
	}

	public Throwable getReason() {
		return reason;
	}

	public void setReason(Throwable reason) {
		this.reason = reason;
	}

	public URI getUnavailableUri() {
		return unavailableUri;
	}

	public void setUnavailableUri(URI unavailableUri) {
		this.unavailableUri = unavailableUri;
	}
	
	public Object getValue() { 
		throw new UnavailablePropertyException(this);
	}
	
	public Object setValue(Object value) {
		throw new UnsupportedOperationException("There is no value for an Unavailable Property!");
	}
}
