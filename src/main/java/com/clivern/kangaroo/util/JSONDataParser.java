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

import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/** JSONDataParser Class */
public class JSONDataParser {

    private JSONParser jsonParser;

    /** Class Constructor */
    public JSONDataParser() {
        this.jsonParser = new JSONParser();
    }

    /**
     * Parse Data
     *
     * @param data the JSON data
     * @return the JSON Object
     * @throws ParseException unable to parse JSON string
     */
    public Object parseData(String data) throws ParseException {
        return (Object) this.jsonParser.parse(data);
    }
}
