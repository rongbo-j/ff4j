package org.ff4j.feature.strategy;

import static org.ff4j.utils.Util.inetAddressHostName;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/*
 * #%L
 * ff4j-core
 * %%
 * Copyright (C) 2013 Ff4J
 * %%
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *      http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * #L%
 */

/**
 * This strategy will check hostName and flipped only if it's contained in expected list.
 * 
 * @author Cedrick Lunven (@clunven)
 */
public class ServerFilterToggleStrategy extends AbstractToggleStrategy implements TogglePredicate {

    /** Threshold. */
    private static final String PARAM_SERVERLIST = "grantedServers";

    /** Parameter to be checked in context. */
    public static final String SERVER_HOSTNAME = "serverHostName";

    /** List of client to be accepted. */
    private static final String SPLITTER = ",";

    /** Validate the target client against the available hostname. */
    private final Set<String> setOfTargetServer = new HashSet<String>();

    /** raw client list. */
    private String rawServerList = null;

    /**
     * Default Constructor.
     */
    public ServerFilterToggleStrategy() {}

    /**
     * Parameterized constructor.
     * 
     * @param threshold
     *            threshold
     */
    public ServerFilterToggleStrategy(String targetServers) {
        this.rawServerList = targetServers;
        getInitParams().put(PARAM_SERVERLIST, targetServers);
        for (String server : rawServerList.split(SPLITTER)) {
            setOfTargetServer.add(server.trim());
        }
    }

    /** {@inheritDoc} */
    @Override
    public void init(String featureName, Map<String, String> initParams) {
        super.init(featureName, initParams);
        if (initParams != null && initParams.containsKey(PARAM_SERVERLIST)) {
            this.rawServerList = initParams.get(PARAM_SERVERLIST);
        }
        for (String server : rawServerList.split(SPLITTER)) {
            setOfTargetServer.add(server.trim());
        }
    }

    /** {@inheritDoc} */
    @Override
    public boolean test(ToggleContext ctx) {
        if (null != ctx && ctx.getValue(SERVER_HOSTNAME).isPresent()) {
            return setOfTargetServer.contains(ctx.getString(SERVER_HOSTNAME).get());
        }
        return setOfTargetServer.contains(inetAddressHostName());
    }

}