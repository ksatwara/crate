/*
 * Licensed to Crate under one or more contributor license agreements.
 * See the NOTICE file distributed with this work for additional
 * information regarding copyright ownership.  Crate licenses this file
 * to you under the Apache License, Version 2.0 (the "License"); you may
 * not use this file except in compliance with the License.  You may
 * obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or
 * implied.  See the License for the specific language governing
 * permissions and limitations under the License.
 *
 * However, if you have executed another commercial license agreement
 * with Crate these terms will supersede the license and you may use the
 * software solely pursuant to the terms of the relevant commercial
 * agreement.
 */

package io.crate.execution.engine.aggregation.impl;

import java.util.List;

import org.junit.Test;

import io.crate.operation.aggregation.AggregationTest;
import io.crate.types.DataTypes;
import org.hamcrest.Matchers;


public class ArrayAggTest extends AggregationTest {

    @Test
    public void test_array_agg_adds_all_items_to_array() throws Exception {
        var result = executeAggregation("array_agg", DataTypes.INTEGER, new Object[][] {
            new Object[] { 20 },
            new Object[] { null },
            new Object[] { 42 },
            new Object[] { 24 }
        }, List.of(DataTypes.INTEGER));
        assertThat((List<Object>) result, Matchers.contains(20, null, 42, 24));
    }
}