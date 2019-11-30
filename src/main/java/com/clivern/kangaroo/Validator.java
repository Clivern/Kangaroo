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

import com.clivern.kangaroo.constraint.*;
import com.clivern.kangaroo.constraint.ConstraintType;
import java.util.ArrayList;
import java.util.Map;

/** Validator Class */
public class Validator {

    private String data = "{}";
    private ArrayList<String> errors = new ArrayList<String>();
    private Boolean isValid = true;

    /**
     * Validate the JSON Data against the JSON Schema draft 3
     *
     * @param schema the draft Object
     * @param data the data
     * @return whether data is valid or not
     */
    public Boolean validate(SchemaDraft3 schema, String data) {
        this.data = data;
        for (Map.Entry item : schema.properties.entrySet()) {
            ArrayList<String> parents = new ArrayList<String>();
            parents.add((String) item.getKey());
            this.isValid &= this.validateNode(parents, (NodeDraft3) item.getValue());
        }

        return this.isValid;
    }

    /**
     * Validate the JSON Data against the JSON Schema draft 4
     *
     * @param schema the draft Object
     * @param data the data
     * @return whether data is valid or not
     */
    public Boolean validate(SchemaDraft4 schema, String data) {
        this.data = data;
        for (Map.Entry item : schema.properties.entrySet()) {
            ArrayList<String> parents = new ArrayList<String>();
            parents.add((String) item.getKey());
            this.isValid &= this.validateNode(parents, (NodeDraft4) item.getValue());
        }

        return this.isValid;
    }

    /**
     * Validate the JSON Data against the JSON Schema draft 6
     *
     * @param schema the draft Object
     * @param data the data
     * @return whether data is valid or not
     */
    public Boolean validate(SchemaDraft6 schema, String data) {
        this.data = data;
        for (Map.Entry item : schema.properties.entrySet()) {
            ArrayList<String> parents = new ArrayList<String>();
            parents.add((String) item.getKey());
            this.isValid &= this.validateNode(parents, (NodeDraft6) item.getValue());
        }

        return this.isValid;
    }

    /**
     * Validate the JSON Data against the JSON Schema draft 7
     *
     * @param schema the draft Object
     * @param data the data
     * @return whether data is valid or not
     */
    public Boolean validate(SchemaDraft7 schema, String data) {
        this.data = data;
        for (Map.Entry item : schema.properties.entrySet()) {
            ArrayList<String> parents = new ArrayList<String>();
            parents.add((String) item.getKey());
            this.isValid &= this.validateNode(parents, (NodeDraft7) item.getValue());
        }

        return this.isValid;
    }

    /**
     * Validate a Draft3 Node
     *
     * @param parents node parents
     * @param node draft3 node
     * @return whether node is valid or not
     */
    public Boolean validateNode(ArrayList<String> parents, NodeDraft3 node) {
        Boolean status = false;

        // Validate node
        Type type = new Type(node.type);

        if (type.inTypes(ConstraintType.STRING.name().toLowerCase())) {}

        if (type.inTypes(ConstraintType.INTEGER.name().toLowerCase())) {}

        if (type.inTypes(ConstraintType.NUMBER.name().toLowerCase())) {}

        if (type.inTypes(ConstraintType.BOOLEAN.name().toLowerCase())) {}

        if (type.inTypes(ConstraintType.NULL.name().toLowerCase())) {}

        if (type.inTypes(ConstraintType.ENUM.name().toLowerCase())) {}

        if (type.inTypes(ConstraintType.ARRAY.name().toLowerCase())) {}

        // Skip if node not object
        if (!type.inTypes(ConstraintType.OBJECT.name().toLowerCase())) {
            return status;
        }

        // Validate sub-nodes
        for (Map.Entry item : node.properties.entrySet()) {
            ArrayList<String> nodeParents = new ArrayList<>(parents);
            nodeParents.add((String) item.getKey());
            status &= this.validateNode(nodeParents, (NodeDraft3) item.getValue());
        }

        return status;
    }

    /**
     * Validate a Draft4 Node
     *
     * @param parents node parents
     * @param node draft4 node
     * @return whether node is valid or not
     */
    public Boolean validateNode(ArrayList<String> parents, NodeDraft4 node) {
        Boolean status = false;

        // Validate node
        Type type = new Type(node.type);

        if (type.inTypes(ConstraintType.STRING.name().toLowerCase())) {}

        if (type.inTypes(ConstraintType.INTEGER.name().toLowerCase())) {}

        if (type.inTypes(ConstraintType.NUMBER.name().toLowerCase())) {}

        if (type.inTypes(ConstraintType.BOOLEAN.name().toLowerCase())) {}

        if (type.inTypes(ConstraintType.NULL.name().toLowerCase())) {}

        if (type.inTypes(ConstraintType.ENUM.name().toLowerCase())) {}

        if (type.inTypes(ConstraintType.ARRAY.name().toLowerCase())) {}

        // Skip if node not object
        if (!type.inTypes(ConstraintType.OBJECT.name().toLowerCase())) {
            return status;
        }

        // Validate sub-nodes
        for (Map.Entry item : node.properties.entrySet()) {
            ArrayList<String> nodeParents = new ArrayList<>(parents);
            nodeParents.add((String) item.getKey());
            status &= this.validateNode(nodeParents, (NodeDraft4) item.getValue());
        }

        return status;
    }

    /**
     * Validate a Draft6 Node
     *
     * @param parents node parents
     * @param node draft6 node
     * @return whether node is valid or not
     */
    public Boolean validateNode(ArrayList<String> parents, NodeDraft6 node) {
        Boolean status = false;

        // Validate node
        Type type = new Type(node.type);

        if (type.inTypes(ConstraintType.STRING.name().toLowerCase())) {}

        if (type.inTypes(ConstraintType.INTEGER.name().toLowerCase())) {}

        if (type.inTypes(ConstraintType.NUMBER.name().toLowerCase())) {}

        if (type.inTypes(ConstraintType.BOOLEAN.name().toLowerCase())) {}

        if (type.inTypes(ConstraintType.NULL.name().toLowerCase())) {}

        if (type.inTypes(ConstraintType.ENUM.name().toLowerCase())) {}

        if (type.inTypes(ConstraintType.ARRAY.name().toLowerCase())) {}

        // Skip if node not object
        if (!type.inTypes(ConstraintType.OBJECT.name().toLowerCase())) {
            return status;
        }

        // Validate sub-nodes
        for (Map.Entry item : node.properties.entrySet()) {
            ArrayList<String> nodeParents = new ArrayList<>(parents);
            nodeParents.add((String) item.getKey());
            status &= this.validateNode(nodeParents, (NodeDraft6) item.getValue());
        }

        return status;
    }

    /**
     * Validate a Draft7 Node
     *
     * @param parents node parents
     * @param node draft7 node
     * @return whether node is valid or not
     */
    public Boolean validateNode(ArrayList<String> parents, NodeDraft7 node) {
        Boolean status = false;

        // Validate node
        Type type = new Type(node.type);

        if (type.inTypes(ConstraintType.STRING.name().toLowerCase())) {}

        if (type.inTypes(ConstraintType.INTEGER.name().toLowerCase())) {}

        if (type.inTypes(ConstraintType.NUMBER.name().toLowerCase())) {}

        if (type.inTypes(ConstraintType.BOOLEAN.name().toLowerCase())) {}

        if (type.inTypes(ConstraintType.NULL.name().toLowerCase())) {}

        if (type.inTypes(ConstraintType.ENUM.name().toLowerCase())) {}

        if (type.inTypes(ConstraintType.ARRAY.name().toLowerCase())) {}

        // Skip if node not object
        if (!type.inTypes(ConstraintType.OBJECT.name().toLowerCase())) {
            return status;
        }

        // Validate sub-nodes
        for (Map.Entry item : node.properties.entrySet()) {
            ArrayList<String> nodeParents = new ArrayList<>(parents);
            nodeParents.add((String) item.getKey());
            status &= this.validateNode(nodeParents, (NodeDraft7) item.getValue());
        }

        return status;
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

    /**
     * Add Errors
     *
     * @param errors the errors
     */
    private void addErrors(ArrayList<String> errors) {
        this.errors.addAll(errors);
    }
}
