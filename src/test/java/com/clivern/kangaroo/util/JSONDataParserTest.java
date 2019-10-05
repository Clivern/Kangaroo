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
package com.clivern.kangaroo.util;

import static org.junit.Assert.*;

import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.junit.Test;

/** JSONDataParserTest Class */
public class JSONDataParserTest {

    @Test
    public void testJSONDataParser() throws ParseException {
        JSONDataParser dataParser = new JSONDataParser();
        JSONObject jsonObj = (JSONObject) dataParser.parseData("{\"id\": \"Hello\"}");
        assertEquals("Hello", (String) jsonObj.get("id"));
    }

    @Test(expected = ParseException.class)
    public void whenExceptionThrown_JSONDataParser() throws ParseException {
        JSONDataParser dataParser = new JSONDataParser();
        JSONObject jsonObj = (JSONObject) dataParser.parseData("{\"id: \"Hello\"}");
        assertEquals("Hello", (String) jsonObj.get("id"));
    }
}
