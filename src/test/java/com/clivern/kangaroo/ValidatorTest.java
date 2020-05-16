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
package com.clivern.kangaroo;

import static org.junit.Assert.*;

import com.clivern.kangaroo.util.*;
import java.util.ArrayList;
import org.junit.Test;

/** Validator Test Cases */
public class ValidatorTest {

    @Test
    public void testValidator() throws Exception {
        FileReader fileReader = new FileReader();
        SchemaFactory schemaFactory = new SchemaFactory();
        Validator validator = new Validator();

        SchemaDraft7 schemaDraft7 =
                schemaFactory.unserialize(
                        fileReader.readFileAsString("src/test/resources/schema01.json"),
                        SchemaDraft7.class);

        assertEquals(validator.validate(schemaDraft7, "{\"id\":\"1\"}"), true);
        assertEquals(validator.getErrors(), new ArrayList<String>());
    }
}
