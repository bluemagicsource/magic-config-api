package org.bluemagic.config.api.agent;

import java.net.URI;
import java.util.Collection;


public class Location {

	protected URI uri;
	
	protected Collection<Decorator> decorators;
	
	protected Collection<Transformer> transformers;
}
