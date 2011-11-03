package org.bluemagic.config.api.agent;

import java.net.URI;
import java.util.Map;


/**
 * Implementations of the configuration interface are responsible for
 * resolving the data at the requested url and returning it.
 *
 **/
public interface Config {

    /**
     * @param  uri - This can be any URI, but this includes the concept 
     *               of decorated URI's such that we support hierarchical
     *               overrides.
     * @param  parameters - A local hashmap the we can pass data along
     *               the chain of operation. Primarily this is the incoming
     *               parameters that were part of the URI.
     *
     * @return Object - Any return data, we are not limited to strings however
     *               most of the configuration data we return are string values.
     *               There are two special cases:
     *                 null - Was there an error that caused the null or did
     *                        the application intentionally return a null values?
     *                        or did the configuration just not find any data for
     *                        the requested URI?
     *                        Because it is hard to determine the intent of a null
     *                        return value we have created NullObject and NoDataFound
     *                        objects to differentiate these cases.
     *               Therefore, a null value returned from this method is considered
     *               undefined and an error is logged.
     **/
    Object getConfig(URI uri, Map<ConfigKey, Object> parameters);
}