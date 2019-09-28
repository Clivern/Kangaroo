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

/** SchemaDraft7Test Class */
public class SchemaDraft7Test {

    @Test
    public void testSchemaDraft7_01() {
        SchemaDraft7 schema = new SchemaDraft7();
        schema.schema = "http://json-schema.org/draft-07/schema#";
        schema.id = "SchemaId";
        schema.title = "Schema Title";
        schema.type = "object";

        Gson gson = new Gson();
        String json = gson.toJson(schema);
        assertEquals("{\"$schema\":\"http://json-schema.org/draft-07/schema#\",\"$id\":\"SchemaId\",\"title\":\"Schema Title\",\"type\":\"object\",\"required\":[],\"properties\":{}}", json);
    }

    @Test
    public void testSchemaDraft7_02() {
        SchemaDraft7 schema = new SchemaDraft7();
        schema.schema = "http://json-schema.org/draft-07/schema#";
        schema.id = "SchemaId";
        schema.title = "Schema Title";
        schema.type = "object";
        schema.required.add("itemOne");
        schema.required.add("itemTwo");
        schema.required.add("itemThree");

        Gson gson = new Gson();
        String json = gson.toJson(schema);

        assertEquals("{\"$schema\":\"http://json-schema.org/draft-07/schema#\",\"$id\":\"SchemaId\",\"title\":\"Schema Title\",\"type\":\"object\",\"required\":[\"itemOne\",\"itemTwo\",\"itemThree\"],\"properties\":{}}", json);
    }
}