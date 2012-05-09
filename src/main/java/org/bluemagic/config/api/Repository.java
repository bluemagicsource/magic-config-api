package org.bluemagic.config.api;

import java.net.URI;


public interface Repository {
	
	public boolean supports(URI uri);
	
	public Object put(URI key, Object value);
	
	public Object get(URI key);
	
	public Object remove(URI key);
	
	public void clear();
	
	public int size();
}
