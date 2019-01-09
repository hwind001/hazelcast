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

package com.hazelcast.wan;

import com.hazelcast.config.WanAcknowledgeType;
import com.hazelcast.test.HazelcastParallelClassRunner;
import com.hazelcast.test.annotation.ParallelTest;
import com.hazelcast.test.annotation.QuickTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;

import static com.hazelcast.config.WanAcknowledgeType.ACK_ON_OPERATION_COMPLETE;
import static com.hazelcast.config.WanAcknowledgeType.ACK_ON_RECEIPT;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;

@RunWith(HazelcastParallelClassRunner.class)
@Category({QuickTest.class, ParallelTest.class})
public class WanAcknowledgeTypeTest {

    @Test
    public void test() {
        assertSame(ACK_ON_RECEIPT, WanAcknowledgeType.getById(ACK_ON_RECEIPT.getId()));
        assertSame(ACK_ON_OPERATION_COMPLETE, WanAcknowledgeType.getById(ACK_ON_OPERATION_COMPLETE.getId()));
        assertNull(WanAcknowledgeType.getById(-1));
    }
}
