package org.bluemagic.config.api;

import java.net.URI;
import java.util.Collection;
import java.util.Map;


/**
 * The URI decorator takes incoming URI(s) and produces zero, one, or
 * more "decorated" URI(s) which should not be the same as the original URI.
 * The URI(s) produced from the incoming URI(s) are the hierarchical override
 * representations.
 * 
 * The order of the decorated URIs is very important because it is the order
 * in which the decorated URIs should be "used" by the calling routine.
 **/
public interface Decorator {
	
	public enum Method { PREFIX, PLACEHOLDER, SUFFIX }
	
	public Method getMethod();

    /**
     * @param  keyList  Required to have a valid list of zero, one, or more
     *               keys (a null value is invalid).
     * @param  parameters - Used internally to pass information around
     *               containing state regarding the current request
     *               but this has been exposed to provide other developers
     *               with the ability to pass additional information
     *               to the configuration agent via other software means. 
     *               Please refer to the MagicKey class for a full listing
     *               of all of the parameters supported (either automatically
     *               or as input parameters).
     *
     * @return keyList A list (never null) of zero, one, or more decorated
     *               URIs which are not the same as the input URIs
     **/
    public Collection<URI> decorate(Collection<URI> keyList, Map<MagicKey, Object> parameters);
}