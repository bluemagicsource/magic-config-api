package org.bluemagic.config.api;

import java.net.URI;
import java.util.Map;
import java.util.Map.Entry;

import org.bluemagic.config.api.tag.Tag;

/**
 * The data provider is responsible for using the incoming URI and parameters
 * to resolve the requested data. Note that the parameters are optional and 
 * can clearly be ignored by the implementation if they wish.
 **/
public interface Location {
	
	/**
	 * 
	 * @param key URI used to determine if a location can support it
	 * @return true if supports, false if no support
	 */
	public boolean supports(URI key);

	/**
     * @param  key URI a unique identifier for a specific instance of data
     *               or set of data. 
     * @param  parameters Map<MagicKey name, String value> name and value pairs
     *                      of data. Note that the Map is required but it may be
     *                      empty. However, the map itself cannot be null.
     **/
	public Entry<URI, Object> locate(URI key, Map<MagicKey, Object> parameters);
	
	/**
	 * 
	 * @return Encoding type required for this location
	 */
	public Tag.Encoding getEncoding();
}
