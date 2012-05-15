package org.bluemagic.config.api;

import java.net.URI;

/**
 * The repository interface has been designed to define the interaction between
 * a Blue Magic data repository and the data access layer
 **/
public interface UserRepository extends Repository {
	
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
     * @param  userIdentifier - Unique identifier of the user requesting
     *         the specified operation.
     * @return return ?
     **/
	public Object put(URI key, 
                      Object value, 
                      String userIdentifier);
	
    /**
     * @param  key - Unique uri
     * @param  userIdentifier - Unique identifier of the user requesting
     *         the specified operation.
     * @return Object The current value corresponding to the key or MissingProperty
     *         if the value does not exist in the repository
     **/
	public Object get(URI key, 
                      String userIdentifier);

    /**
     * Removes the item from the repository.
     *
     * @param  key - Unique uri
     * @param  userIdentifier - Unique identifier of the user requesting
     *         the specified operation.
     * @return Object value removed
     **/
	public Object remove(URI key, 
                         String userIdentifier);
	
    /**
     * Clears the entire repository.
     * @param  userIdentifier - Unique identifier of the user requesting
     *         the specified operation.
     **/
	public void clear(String userIdentifier);
	
    /**
     * Returns the total number of properties in the repository
     **/
	public int size();
}
