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

import org.junit.Test;

/** ValidatorTest Class */
public class ValidatorTest {

    @Test
    public void testValidatorHasAGreeting() {
        Validator validator = new Validator();

        SchemaFactory schemaFactory = new SchemaFactory();
        SchemaDraft7 draft =
                schemaFactory.unserialize(
                        "{\"$id\":\"https://example.com/address.schema.json\",\"$schema\":\"http://json-schema.org/draft-07/schema#\",\"description\":\"An address similar to http://microformats.org/wiki/h-card\",\"type\":\"object\",\"properties\":{\"post-office-box\":{\"description\":\"post-office-box\",\"type\":\"object\",\"properties\":{\"street-address\":{\"type\":\"string\",\"description\":\"post-office-box.street-address\"},\"locality\":{\"type\":\"string\",\"description\":\"post-office-box.locality\"},\"region\":{\"type\":\"object\",\"description\":\"post-office-box.region\",\"properties\":{\"postal-code\":{\"type\":\"string\",\"description\":\"post-office-box.region.postal-code\"},\"country-name\":{\"type\":\"string\",\"description\":\"post-office-box.region.country-name\"}}}}},\"extended-address\":{\"description\":\"extended-address\",\"type\":\"string\"}}}",
                        SchemaDraft7.class);
        assertEquals(true, validator.validate(draft, "{}"));
    }
}
