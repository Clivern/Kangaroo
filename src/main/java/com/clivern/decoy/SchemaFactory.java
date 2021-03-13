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

import com.google.gson.Gson;

/** Schema Factory Class */
public class SchemaFactory {

    private Gson gson;

    /** Class Constructor */
    public SchemaFactory() {
        this.gson = new Gson();
    }

    /**
     * Serialize Object
     *
     * @param object the object
     * @return the serialized object
     */
    public String serialize(Object object) {
        return this.gson.toJson(object);
    }

    /**
     * Unserialize JSON
     *
     * @param json the json value
     * @param object the object class
     * @param <T> an object
     * @return the object
     */
    public <T> T unserialize(String json, Class<T> object) {
        return this.gson.fromJson(json, object);
    }
}
