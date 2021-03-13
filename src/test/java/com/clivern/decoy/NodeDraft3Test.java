/*
 * Copyright (C) 2020 Clivern <http://clivern.com>
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License
 * is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express
 * or implied. See the License for the specific language governing permissions and limitations under
 * the License.
 */
package com.clivern.decoy;

import static org.junit.Assert.*;

import org.junit.Test;

/** Node Draft3 Test Cases */
public class NodeDraft3Test {

    @Test
    public void testNodeDraft3_01() {
        SchemaFactory schemaFactory = new SchemaFactory();
        NodeDraft3 node = new NodeDraft3();
        node.description = "Node Description";
        node.type = "string";
        node.required.add("item01");
        node.enumerated.add("enum01");

        String json = schemaFactory.serialize(node);

        assertEquals(
                "{\"description\":\"Node Description\",\"type\":\"string\",\"enum\":[\"enum01\"],\"required\":[\"item01\"],\"properties\":{}}",
                json);
    }
}
