package org.bluemagic.config.api.property;

import java.net.URI;

public interface MagicProperty {
	
	public URI getKey();
	
	public Object getValue();
}
