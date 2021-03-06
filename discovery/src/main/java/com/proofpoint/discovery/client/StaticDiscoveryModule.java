/*
 * Copyright 2010 Proofpoint, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.proofpoint.discovery.client;

import com.google.inject.Binder;
import com.google.inject.Module;
import com.google.inject.Scopes;
import com.proofpoint.discovery.client.announce.Announcer;
import com.proofpoint.discovery.client.balancing.StaticHttpServiceBalancerFactory;
import com.proofpoint.http.client.balancing.BalancingHttpClient;
import com.proofpoint.http.client.balancing.HttpServiceBalancer;

/**
 * A variant of DiscoveryModule which obtains service location from configuration.
 * Does not talk to the discovery service.
 *
 * Can only create {@link BalancingHttpClient} and {@link HttpServiceBalancer}.
 * Cannot create {@link ServiceInventory} or {@link Announcer}.
 * Cannot announce services.
 */
public class StaticDiscoveryModule
        implements Module
{
    @Override
    public void configure(Binder binder)
    {
        binder.bind(StaticHttpServiceBalancerFactory.class).in(Scopes.SINGLETON);
    }
}
