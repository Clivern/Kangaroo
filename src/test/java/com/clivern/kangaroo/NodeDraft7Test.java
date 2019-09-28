/*
 * Copyright (C) 2019 Clivern <http://clivern.com>
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
package com.clivern.kangaroo;

import static org.junit.Assert.*;

import com.google.gson.Gson;
import org.junit.Test;

/** NodeDraft7Test Class */
public class NodeDraft7Test {

    @Test
    public void testNodeDraft7_01() {

        NodeDraft7 node = new NodeDraft7();
        node.description = "Node Description";
        node.type = "string";
        node.required.add("item01");
        node.enumerated.add("enum01");

        Gson gson = new Gson();
        String json = gson.toJson(node);

        assertEquals("{\"description\":\"Node Description\",\"type\":\"string\",\"enum\":[\"enum01\"],\"required\":[\"item01\"],\"properties\":{}}", json);
    }
}