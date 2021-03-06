package org.bluemagic.config.api;

import java.net.URI;

/**
 * The repository interface has been designed to define the interaction between
 * a Blue Magic data repository and the data access layer
 **/
public interface Repository {
	
    /**
     * @param  uri - Requested uri
     * @return boolean - true when the incoming uri is supported
     **/
	public boolean supports(URI uri);
	
    /**
     * The put method inserts a new data record or updates
     * an existing data record's value
     *
     * @param  key - Unique uri (note that our URIs should already
     *         be normalized prior to reaching this interface.
     * @param  value -
     * @return return uri of the located value
     **/
	public Object put(URI key, Object value);
	
    /**
     * @param  key - Unique uri
     * @return Object The current value corresponding to the key or MissingProperty
     *         if the value does not exist in the repository
     **/
	public Object get(URI key);

    /**
     * Removes the item from the repository.
     *
     * @param  key - Unique uri
     * @return Object value removed
     **/
	public Object remove(URI key);
	
    /**
     * Clears the entire repository.
     **/
	public void clear();
	
    /**
     * Returns the total number of properties in the repository
     **/
	public int size();
}
