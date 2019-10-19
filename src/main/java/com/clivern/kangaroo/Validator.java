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

    private SchemaFactory schemaFactory;
    private String schema = "";
    private SchemaInterface schemaObj;
    private Draft draft = Draft.DRAFT3;
    private String data = "";
    private ArrayList<String> errors = new ArrayList<String>();
    private Boolean isValid = true;

    /** Class Constructor */
    public Validator() {
        this.schemaFactory = new SchemaFactory();
    }

    /**
     * Set JSON Schema
     *
     * @param schema the json schema to validate data against
     * @param draft the draft version
     */
    public void setSchema(String schema, Draft draft) {
        this.schema = schema;
        this.draft = draft;

        if (this.draft.equalsName(Draft.DRAFT3.name())) {
            this.schemaObj = new SchemaDraft3();
            this.schemaObj = this.schemaFactory.unserialize(this.schema, SchemaDraft3.class);
        } else if (this.draft.equalsName(Draft.DRAFT4.name())) {
            this.schemaObj = new SchemaDraft4();
            this.schemaObj = this.schemaFactory.unserialize(this.schema, SchemaDraft4.class);
        } else if (this.draft.equalsName(Draft.DRAFT6.name())) {
            this.schemaObj = new SchemaDraft6();
            this.schemaObj = this.schemaFactory.unserialize(this.schema, SchemaDraft6.class);
        } else if (this.draft.equalsName(Draft.DRAFT7.name())) {
            this.schemaObj = new SchemaDraft7();
            this.schemaObj = this.schemaFactory.unserialize(this.schema, SchemaDraft7.class);
        }
    }

    /**
     * Set JSON Data
     *
     * @param data the data to validate
     */
    public void setData(String data) {
        this.data = data;
    }

    /**
     * Get JSON Schema
     *
     * @return the JSON Schema
     */
    public String getSchema() {
        return this.schema;
    }

    /**
     * Get JSON Data
     *
     * @return the data to validate
     */
    public String getData() {
        return this.data;
    }

    /**
     * Validate the JSON Data against the JSON Schema
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

    /**
     * If validation has errors
     *
     * @return the errors count
     */
    public int hasErrors() {
        return this.errors.size();
    }

    /**
     * Add Error
     *
     * @param error the error
     */
    private void addError(String error) {
        this.errors.add(error);
    }
}
