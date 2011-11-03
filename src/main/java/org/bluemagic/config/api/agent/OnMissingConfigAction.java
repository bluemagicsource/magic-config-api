package org.bluemagic.config.api.agent;

import java.net.URI;
import java.util.List;
import java.util.Map;

/**
 * When the org.bluemagic.config.api.ConfigManager implementations
 * fail to find a value for a specified URI then zero, one, or
 * more of these action(s) are executed by the underlying implementation
 * (in some cases a missing configuration setting might warrant an 
 *  exception, log, warning, or be ok... let our end developers determine
 *  what it means to them).
 **/
public interface OnMissingConfigAction {

    /**
     * @param  uri - Required, the URI requested from the user 
     *         that did not resulted in a value.
     * @param  parameters - Required, any parameters associated with 
     *         the initial request
     * @param  errors - Required, (can be empty) a list of any and all
     *         exceptions that occurred during the process of trying
     *         to retrieve a value. These may or may not be relevant
     *         to the cause of the problem; however, we would like to
     *         centralize the logging of these to better facilitate
     *         debugging (typically we only care about these in cases
     *         where a value was not found.
     **/
    void performAction(URI uri, 
		       Map<ConfigKey, Object> parameters, 
		       List<Throwable> errors);
}