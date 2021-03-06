package org.bluemagic.config.api.service;
import java.net.URI;

/**
 * The service is the interface that all implementations can use including
 * but not limited to the restful service, command line client, thick client....
 **/
public interface PropertyService {
    
    /**
     * Creates a new property and value combination
     *
     * @param  uri Contains private and public visibility as well as the optional or required status.
     * @param  value new data to be persisted
     * @return boolean TRUE when the value is successfully persisted false failure to create
     **/
    public boolean create(URI uri,
                          String value);

    /**
     * @param  uri Contains private and public visibility as well as the optional or required status.
     * @return value new data to be updated (assumed it already exists)
     **/
    public String read(URI uri);

    /**
     * @param  uri Contains private and public visibility as well as the optional or required status.
     * @param  value new data to be updated (assumed it already exists)
     * @return boolean TRUE when the value is successfully persisted false failure to update
     **/
    public boolean update(URI uri,
                          String value);

    /**
     * @param  uri Contains private and public visibility as well as the optional or required status.
     * @return boolean TRUE when the value is successfully removed
     **/
    public boolean delete(URI uri);
}
