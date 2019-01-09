/*
 * Copyright (c) 2008-2019, Hazelcast, Inc. All Rights Reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.hazelcast.spi.impl.eventservice.impl.operations;

import com.hazelcast.internal.cluster.ClusterService;
import com.hazelcast.spi.Operation;
import com.hazelcast.spi.impl.eventservice.impl.Registration;
import com.hazelcast.util.function.Supplier;

/**
 * Supplier that creates {@link RegistrationOperation}s for a listener registration.
 */
public class RegistrationOperationSupplier implements Supplier<Operation> {
    private final Registration reg;
    private final ClusterService clusterService;

    public RegistrationOperationSupplier(Registration reg, ClusterService clusterService) {
        this.reg = reg;
        this.clusterService = clusterService;
    }

    @Override
    public Operation get() {
        return new RegistrationOperation(reg, clusterService.getMemberListVersion());
    }
}
