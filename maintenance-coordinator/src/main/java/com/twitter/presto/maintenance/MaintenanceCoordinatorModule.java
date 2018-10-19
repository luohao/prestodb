/*
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
package com.twitter.presto.maintenance;

import com.google.inject.Binder;
import com.google.inject.Module;

import static io.airlift.configuration.ConfigBinder.configBinder;
import static io.airlift.http.client.HttpClientBinder.httpClientBinder;
import static io.airlift.jaxrs.JaxrsBinder.jaxrsBinder;

public class MaintenanceCoordinatorModule
        implements Module
{
    @Override
    public void configure(Binder binder)
    {
        httpClientBinder(binder).bindHttpClient("maintenance", ForAurora.class);

        configBinder(binder).bindConfig(MaintenanceCoordinatorConfig.class);

        jaxrsBinder(binder).bind(MaintenanceCoordinatorResource.class);
    }
}
