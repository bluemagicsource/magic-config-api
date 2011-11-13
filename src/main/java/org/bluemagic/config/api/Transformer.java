package org.bluemagic.config.api;

import java.util.Map;

/**
 * The transformer typically translates one output format to another output
 * format. Note that it should be smart enough to filter for only the data
 * that it wishes to filter and ignore all others. And by ignore that means
 * return the same thing that was input.
 **/
public interface Transformer {

    /**
     * @param value String value that will be transformed
     * @param  parameters Map<MagicKey name, String value> name and value pairs
     *                      of data. Note that the Map is required but it may be
     *                      empty. However, the map itself cannot be null.
     * @return Object The translated data or incoming data if no translation is
     *         performed.
     **/
    String transform(String value, Map<MagicKey, Object> parameters);
}