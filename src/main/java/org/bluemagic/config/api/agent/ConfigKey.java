package org.bluemagic.config.api.agent;

public enum ConfigKey {

    /**
     * The original URI is the undecorated URI that the configuration agent first receives
     * and then attempts to find the associated configuration data. This version of the URI
     * still contains all of the original parameters. Added in the original URI decorator.
     *
     * Value: String
     **/
    ORIGINAL_URI,
	
    /** 
     * The uri that returned valid data
     */
    RESOLVED_URI,
    
	/**
	 * The query parameters associated with the current uri placed in a map<String, String>
	 * Value: Map<String, String>
	 **/
	QUERY_PARAMETERS;
}