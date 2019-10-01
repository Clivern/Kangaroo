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

import java.util.ArrayList;

/** Validator Class */
public class Validator {

    private String schema = "";
    private String data = "";
    private ArrayList<String> errors = new ArrayList<String>();
    private Boolean isValid = true;

    /**
     * Set Schema
     *
     * @param schema the json schema to validate data against
     */
    public void setSchema(String schema) {
        this.schema = schema;
    }

    /**
     * Set Data
     *
     * @param data the data to validate
     */
    public void setData(String data) {
        this.data = data;
    }

    /**
     * Get Schema
     *
     * @return the JSON Schema
     */
    public String getSchema() {
        return this.schema;
    }

    /**
     * Get Data
     *
     * @return the data to validate
     */
    public String getData() {
        return this.data;
    }

    /**
     * Validate the Data against the JSON Schema
     *
     * @return whether data is valid or not
     */
    public Boolean validate() {
        return this.isValid;
    }

    /**
     * Get Errors List
     *
     * @return the errors list
     */
    public ArrayList<String> getErrors() {
        return this.errors;
    }
}
