package org.bluemagic.config.api.agent;

import java.util.Map;
import java.net.URI;

/**
 * The data provider is responsible for using the incoming URI and parameters
 * to resolve the requested data. Note that the parameters are optional and 
 * can clearly be ignored by the implementation if they wish.
 **/
public interface DataProvider {

    /**
     * @param  uri - URI a unique identifier for a specific instance of data
     *               or set of data. 
     * @param  parameters - Map<ConfigKey name, String value> name and value pairs
     *                      of data. Note that the Map is required but it may be
     *                      empty. However, the map itself cannot be null.
     * @return Object - Any return data, we are not limited to strings however
     *                  most of the configuration data we return are string values.
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
    Object findData(URI                 uri, 
                    Map<ConfigKey, Object> parameters);

}