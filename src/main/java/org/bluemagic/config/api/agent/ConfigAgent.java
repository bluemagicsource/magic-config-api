package org.bluemagic.config.api.agent;

import java.net.URI;
import java.util.Map;

/**
 * Please refer to our wiki for the latest documentation. The configuration agent
 * provides a hierarchical (linked data) model for retreiving application settings/data.
 * 
 * The application data is typically data that is used at startup to configure
 * software for a specific enviornment. This is not meant to be a database where the
 * data changes as the application is running (use a database). The configuration
 * agent has been designed to replace the typical properties, xml file, and build
 * search and replace mechanisms most project currently use to configure applications
 * for multiple environments.
 **/
public interface ConfigAgent {
	
	public static String SCHEME = "agent";

    /**
     * @param  uri - Required, cannot be null. Please try to follow
     *               existing URI conventions because that allows the
     *               configuration agent to use existing protocols
     *               and conventional means to retieve data. However,
     *               feel free to create new protocols to fit emerging
     *               needs and add support to them to the configuration
     *               agent.
     *
     *               URI's were choosen as the main input because the
     *               configuration agent uses a linked data model
     *               in which each URI resolves to an actual data set
     *               in the browser. Please search for Linked-Data for
     *               a more detailed explaination.
     *     
     *               Some suggested URIs would be:
     *               https://bluemagicsource.org/magic/applicationX/database/url
     *               https://bluemagicsource.org/magic/applicationX/database/username
     *               https://bluemagicsource.org/magic/applicationX/database/password
     **/
    Object getConfig(URI uri);

    /**
     * @param  uri - Required, cannot be null. Please try to follow
     *               existing URI conventions because that allows the
     *               configuration agent to use existing protocols
     *               and conventional means to retieve data. However,
     *               feel free to create new protocols to fit emerging
     *               needs and add support to them to the configuration
     *               agent.
     *
     *               URI's were choosen as the main input because the
     *               configuration agent uses a linked data model
     *               in which each URI resolves to an actual data set
     *               in the browser. Please search for Linked-Data for
     *               a more detailed explaination.
     *
     * @param  parameters - Used internally to pass information around
     *               containing state regarding the current request
     *               but this has been exposed to provide other developers
     *               with the ability to pass additional information
     *               to the configuration agent via other software means. 
     *               Please refer to the ConfigKey class for a full listing
     *               of all of the parameters supported (either automatically
     *               or as input parameters).
     *
     * @return  Object - 99% of the time the configuration agent returns string
     *               values; however, we have the api returning an Object to allow
     *               the extra flexibility. The value returned is the hierarchically
     *               resolved value associated with the incoming URI. Note the
     *               architecture is extremely flexible allowing an infinite number
     *               of hierarchical algorithms; however, we have tried to supply 
     *               a default implementation that is close to what most end users
     *               require.
     **/
    Object getConfig(URI uri, Map<ConfigKey, Object> parameters);
}