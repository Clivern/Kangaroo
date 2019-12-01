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

import java.util.ArrayList;
import org.json.JSONObject;

/** Json Class */
public class Json {

    /**
     * Get JSON Item
     *
     * @param data the JSON
     * @param keys the keys
     * @return the key value
     */
    public static Object get(String data, ArrayList<String> keys) {
        int i = 0;
        int size = keys.size();
        JSONObject jsonObj = new JSONObject(data);

        for (String key : keys) {
            if (i == (size - 1)) {
                return jsonObj.get(key);
            }
            jsonObj = jsonObj.getJSONObject(key);
            i += 1;
        }

        return null;
    }

    /**
     * Get JSON Item
     *
     * @param data the JSON
     * @param keys the keys
     * @return the key value
     */
    public static Object get(String data, String[] keys) {
        int i = 0;
        int size = keys.length;
        JSONObject jsonObj = new JSONObject(data);

        for (String key : keys) {
            if (i == (size - 1)) {
                return jsonObj.get(key);
            }
            jsonObj = jsonObj.getJSONObject(key);
            i += 1;
        }

        return null;
    }
}
