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

import com.clivern.decoy.constraint.*;
import com.clivern.decoy.constraint.ConstraintType;
import com.clivern.decoy.exception.SchemaError;
import com.clivern.decoy.util.Json;
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
     * @throws SchemaError schema error
     */
    public Boolean validate(SchemaDraft3 schema, String data) throws SchemaError {
        this.data = data;
        for (Map.Entry item : schema.properties.entrySet()) {
            ArrayList<String> parents = new ArrayList<String>();
            parents.add((String) item.getKey());
            this.isValid &=
                    this.validateNode(parents, (NodeDraft3) item.getValue(), schema.required);
        }

        return this.isValid;
    }

    /**
     * Validate the JSON Data against the JSON Schema draft 4
     *
     * @param schema the draft Object
     * @param data the data
     * @return whether data is valid or not
     * @throws SchemaError schema error
     */
    public Boolean validate(SchemaDraft4 schema, String data) throws SchemaError {
        this.data = data;
        for (Map.Entry item : schema.properties.entrySet()) {
            ArrayList<String> parents = new ArrayList<String>();
            parents.add((String) item.getKey());
            this.isValid &=
                    this.validateNode(parents, (NodeDraft4) item.getValue(), schema.required);
        }

        return this.isValid;
    }

    /**
     * Validate the JSON Data against the JSON Schema draft 6
     *
     * @param schema the draft Object
     * @param data the data
     * @return whether data is valid or not
     * @throws SchemaError schema error
     */
    public Boolean validate(SchemaDraft6 schema, String data) throws SchemaError {
        this.data = data;
        for (Map.Entry item : schema.properties.entrySet()) {
            ArrayList<String> parents = new ArrayList<String>();
            parents.add((String) item.getKey());
            this.isValid &=
                    this.validateNode(parents, (NodeDraft6) item.getValue(), schema.required);
        }

        return this.isValid;
    }

    /**
     * Validate the JSON Data against the JSON Schema draft 7
     *
     * @param schema the draft Object
     * @param data the data
     * @return whether data is valid or not
     * @throws SchemaError schema error
     */
    public Boolean validate(SchemaDraft7 schema, String data) throws SchemaError {
        this.data = data;
        for (Map.Entry item : schema.properties.entrySet()) {
            ArrayList<String> parents = new ArrayList<String>();
            parents.add((String) item.getKey());
            this.isValid &=
                    this.validateNode(parents, (NodeDraft7) item.getValue(), schema.required);
        }

        return this.isValid;
    }

    /**
     * Validate a Draft3 Node
     *
     * @param parents node parents
     * @param node draft3 node
     * @param required the required items from the parent node
     * @return whether node is valid or not
     * @throws SchemaError schema error
     */
    public Boolean validateNode(
            ArrayList<String> parents, NodeDraft3 node, ArrayList<String> required)
            throws SchemaError {
        Boolean status = false;

        // Validate node
        Type type = new Type(node.type);

        if (type.inTypes(ConstraintType.STRING.name().toLowerCase())) {
            StringConstraint stringNode = new StringConstraint();

            stringNode.setFieldName(parents.get(parents.size() - 1));
            stringNode.setValue(Json.get(this.data, parents));

            if (required != null && required.size() > 0) {
                stringNode.setRequired(required.contains(parents.get(parents.size() - 1)));
            }
            if (node.minLength != null) {
                stringNode.setMinLength(node.minLength);
            }
            if (node.maxLength != null) {
                stringNode.setMaxLength(node.maxLength);
            }
            if (node.pattern != null) {
                stringNode.setPattern(node.pattern);
            }
            if (node.format != null) {
                stringNode.setFormat(node.format);
            }

            status |= stringNode.validate();
            this.addErrors(stringNode.getErrors());
        }

        if (type.inTypes(ConstraintType.INTEGER.name().toLowerCase())) {
            IntegerConstraint integerNode = new IntegerConstraint();

            integerNode.setFieldName(parents.get(parents.size() - 1));
            integerNode.setValue(Json.get(this.data, parents));

            if (required != null && required.size() > 0) {
                integerNode.setRequired(required.contains(parents.get(parents.size() - 1)));
            }
            if (node.multipleOf != null) {
                integerNode.setMultipleOf(node.multipleOf);
            }
            if (node.minimum != null) {
                integerNode.setMinimum(node.minimum);
            }
            if (node.maximum != null) {
                integerNode.setMaximum(node.maximum);
            }
            if (node.exclusiveMinimum != null) {
                integerNode.setExclusiveMinimum(node.exclusiveMinimum);
            }
            if (node.exclusiveMaximum != null) {
                integerNode.setExclusiveMaximum(node.exclusiveMaximum);
            }

            status |= integerNode.validate();
            this.addErrors(integerNode.getErrors());
        }

        if (type.inTypes(ConstraintType.NUMBER.name().toLowerCase())) {
            NumberConstraint numberNode = new NumberConstraint();

            numberNode.setFieldName(parents.get(parents.size() - 1));
            numberNode.setValue(Json.get(this.data, parents));

            if (required != null && required.size() > 0) {
                numberNode.setRequired(required.contains(parents.get(parents.size() - 1)));
            }
            if (node.multipleOf != null) {
                numberNode.setMultipleOf(node.multipleOf);
            }
            if (node.minimum != null) {
                numberNode.setMinimum(node.minimum);
            }
            if (node.maximum != null) {
                numberNode.setMaximum(node.maximum);
            }
            if (node.exclusiveMinimum != null) {
                numberNode.setExclusiveMinimum(node.exclusiveMinimum);
            }
            if (node.exclusiveMaximum != null) {
                numberNode.setExclusiveMaximum(node.exclusiveMaximum);
            }

            status |= numberNode.validate();
            this.addErrors(numberNode.getErrors());
        }

        if (type.inTypes(ConstraintType.BOOLEAN.name().toLowerCase())) {
            BooleanConstraint booleanNode = new BooleanConstraint();
            booleanNode.setFieldName(parents.get(parents.size() - 1));

            if (required != null && required.size() > 0) {
                booleanNode.setRequired(required.contains(parents.get(parents.size() - 1)));
            }

            booleanNode.setValue(Json.get(this.data, parents));

            status |= booleanNode.validate();
            this.addErrors(booleanNode.getErrors());
        }

        if (type.inTypes(ConstraintType.NULL.name().toLowerCase())) {
            NullConstraint nullNode = new NullConstraint();
            nullNode.setFieldName(parents.get(parents.size() - 1));
            nullNode.setValue(Json.get(this.data, parents));

            status |= nullNode.validate();
            this.addErrors(nullNode.getErrors());
        }

        if (type.inTypes(ConstraintType.ENUM.name().toLowerCase())) {}

        if (type.inTypes(ConstraintType.ARRAY.name().toLowerCase())) {}

        // Skip if node not object
        if (!type.inTypes(ConstraintType.OBJECT.name().toLowerCase())) {
            return status;
        }

        // Skip if the object node is optional and not part of the incoming data
        if (Json.get(this.data, parents) == null
                && !required.contains(parents.get(parents.size() - 1))) {
            return true;
        }

        // Validate sub-nodes
        for (Map.Entry item : node.properties.entrySet()) {
            ArrayList<String> nodeParents = new ArrayList<>(parents);
            nodeParents.add((String) item.getKey());
            status &= this.validateNode(nodeParents, (NodeDraft3) item.getValue(), node.required);
        }

        return status;
    }

    /**
     * Validate a Draft4 Node
     *
     * @param parents node parents
     * @param node draft4 node
     * @param required the required items from the parent node
     * @return whether node is valid or not
     * @throws SchemaError schema error
     */
    public Boolean validateNode(
            ArrayList<String> parents, NodeDraft4 node, ArrayList<String> required)
            throws SchemaError {
        Boolean status = false;

        // Validate node
        Type type = new Type(node.type);

        if (type.inTypes(ConstraintType.STRING.name().toLowerCase())) {
            StringConstraint stringNode = new StringConstraint();

            stringNode.setFieldName(parents.get(parents.size() - 1));
            stringNode.setValue(Json.get(this.data, parents));

            if (required != null && required.size() > 0) {
                stringNode.setRequired(required.contains(parents.get(parents.size() - 1)));
            }
            if (node.minLength != null) {
                stringNode.setMinLength(node.minLength);
            }
            if (node.maxLength != null) {
                stringNode.setMaxLength(node.maxLength);
            }
            if (node.pattern != null) {
                stringNode.setPattern(node.pattern);
            }
            if (node.format != null) {
                stringNode.setFormat(node.format);
            }

            status |= stringNode.validate();
            this.addErrors(stringNode.getErrors());
        }

        if (type.inTypes(ConstraintType.INTEGER.name().toLowerCase())) {
            IntegerConstraint integerNode = new IntegerConstraint();

            integerNode.setFieldName(parents.get(parents.size() - 1));
            integerNode.setValue(Json.get(this.data, parents));

            if (required != null && required.size() > 0) {
                integerNode.setRequired(required.contains(parents.get(parents.size() - 1)));
            }
            if (node.multipleOf != null) {
                integerNode.setMultipleOf(node.multipleOf);
            }
            if (node.minimum != null) {
                integerNode.setMinimum(node.minimum);
            }
            if (node.maximum != null) {
                integerNode.setMaximum(node.maximum);
            }
            if (node.exclusiveMinimum != null) {
                integerNode.setExclusiveMinimum(node.exclusiveMinimum);
            }
            if (node.exclusiveMaximum != null) {
                integerNode.setExclusiveMaximum(node.exclusiveMaximum);
            }

            status |= integerNode.validate();
            this.addErrors(integerNode.getErrors());
        }

        if (type.inTypes(ConstraintType.NUMBER.name().toLowerCase())) {
            NumberConstraint numberNode = new NumberConstraint();

            numberNode.setFieldName(parents.get(parents.size() - 1));
            numberNode.setValue(Json.get(this.data, parents));

            if (required != null && required.size() > 0) {
                numberNode.setRequired(required.contains(parents.get(parents.size() - 1)));
            }
            if (node.multipleOf != null) {
                numberNode.setMultipleOf(node.multipleOf);
            }
            if (node.minimum != null) {
                numberNode.setMinimum(node.minimum);
            }
            if (node.maximum != null) {
                numberNode.setMaximum(node.maximum);
            }
            if (node.exclusiveMinimum != null) {
                numberNode.setExclusiveMinimum(node.exclusiveMinimum);
            }
            if (node.exclusiveMaximum != null) {
                numberNode.setExclusiveMaximum(node.exclusiveMaximum);
            }

            status |= numberNode.validate();
            this.addErrors(numberNode.getErrors());
        }

        if (type.inTypes(ConstraintType.BOOLEAN.name().toLowerCase())) {
            BooleanConstraint booleanNode = new BooleanConstraint();
            booleanNode.setFieldName(parents.get(parents.size() - 1));

            if (required != null && required.size() > 0) {
                booleanNode.setRequired(required.contains(parents.get(parents.size() - 1)));
            }

            booleanNode.setValue(Json.get(this.data, parents));

            status |= booleanNode.validate();
            this.addErrors(booleanNode.getErrors());
        }

        if (type.inTypes(ConstraintType.NULL.name().toLowerCase())) {
            NullConstraint nullNode = new NullConstraint();
            nullNode.setFieldName(parents.get(parents.size() - 1));
            nullNode.setValue(Json.get(this.data, parents));

            status |= nullNode.validate();
            this.addErrors(nullNode.getErrors());
        }

        if (type.inTypes(ConstraintType.ENUM.name().toLowerCase())) {}

        if (type.inTypes(ConstraintType.ARRAY.name().toLowerCase())) {}

        // Skip if node not object
        if (!type.inTypes(ConstraintType.OBJECT.name().toLowerCase())) {
            return status;
        }

        // Skip if the object node is optional and not part of the incoming data
        if (Json.get(this.data, parents) == null
                && !required.contains(parents.get(parents.size() - 1))) {
            return true;
        }

        // Validate sub-nodes
        for (Map.Entry item : node.properties.entrySet()) {
            ArrayList<String> nodeParents = new ArrayList<>(parents);
            nodeParents.add((String) item.getKey());
            status &= this.validateNode(nodeParents, (NodeDraft4) item.getValue(), node.required);
        }

        return status;
    }

    /**
     * Validate a Draft6 Node
     *
     * @param parents node parents
     * @param node draft6 node
     * @param required the required items from the parent node
     * @return whether node is valid or not
     * @throws SchemaError schema error
     */
    public Boolean validateNode(
            ArrayList<String> parents, NodeDraft6 node, ArrayList<String> required)
            throws SchemaError {
        Boolean status = false;

        // Validate node
        Type type = new Type(node.type);

        if (type.inTypes(ConstraintType.STRING.name().toLowerCase())) {
            StringConstraint stringNode = new StringConstraint();

            stringNode.setFieldName(parents.get(parents.size() - 1));
            stringNode.setValue(Json.get(this.data, parents));

            if (required != null && required.size() > 0) {
                stringNode.setRequired(required.contains(parents.get(parents.size() - 1)));
            }
            if (node.minLength != null) {
                stringNode.setMinLength(node.minLength);
            }
            if (node.maxLength != null) {
                stringNode.setMaxLength(node.maxLength);
            }
            if (node.pattern != null) {
                stringNode.setPattern(node.pattern);
            }
            if (node.format != null) {
                stringNode.setFormat(node.format);
            }

            status |= stringNode.validate();
            this.addErrors(stringNode.getErrors());
        }

        if (type.inTypes(ConstraintType.INTEGER.name().toLowerCase())) {
            IntegerConstraint integerNode = new IntegerConstraint();

            integerNode.setFieldName(parents.get(parents.size() - 1));
            integerNode.setValue(Json.get(this.data, parents));

            if (required != null && required.size() > 0) {
                integerNode.setRequired(required.contains(parents.get(parents.size() - 1)));
            }
            if (node.multipleOf != null) {
                integerNode.setMultipleOf(node.multipleOf);
            }
            if (node.minimum != null) {
                integerNode.setMinimum(node.minimum);
            }
            if (node.maximum != null) {
                integerNode.setMaximum(node.maximum);
            }
            if (node.exclusiveMinimum != null) {
                integerNode.setExclusiveMinimum(node.exclusiveMinimum);
            }
            if (node.exclusiveMaximum != null) {
                integerNode.setExclusiveMaximum(node.exclusiveMaximum);
            }

            status |= integerNode.validate();
            this.addErrors(integerNode.getErrors());
        }

        if (type.inTypes(ConstraintType.NUMBER.name().toLowerCase())) {
            NumberConstraint numberNode = new NumberConstraint();

            numberNode.setFieldName(parents.get(parents.size() - 1));
            numberNode.setValue(Json.get(this.data, parents));

            if (required != null && required.size() > 0) {
                numberNode.setRequired(required.contains(parents.get(parents.size() - 1)));
            }
            if (node.multipleOf != null) {
                numberNode.setMultipleOf(node.multipleOf);
            }
            if (node.minimum != null) {
                numberNode.setMinimum(node.minimum);
            }
            if (node.maximum != null) {
                numberNode.setMaximum(node.maximum);
            }
            if (node.exclusiveMinimum != null) {
                numberNode.setExclusiveMinimum(node.exclusiveMinimum);
            }
            if (node.exclusiveMaximum != null) {
                numberNode.setExclusiveMaximum(node.exclusiveMaximum);
            }

            status |= numberNode.validate();
            this.addErrors(numberNode.getErrors());
        }

        if (type.inTypes(ConstraintType.BOOLEAN.name().toLowerCase())) {
            BooleanConstraint booleanNode = new BooleanConstraint();
            booleanNode.setFieldName(parents.get(parents.size() - 1));

            if (required != null && required.size() > 0) {
                booleanNode.setRequired(required.contains(parents.get(parents.size() - 1)));
            }

            booleanNode.setValue(Json.get(this.data, parents));

            status |= booleanNode.validate();
            this.addErrors(booleanNode.getErrors());
        }

        if (type.inTypes(ConstraintType.NULL.name().toLowerCase())) {
            NullConstraint nullNode = new NullConstraint();
            nullNode.setFieldName(parents.get(parents.size() - 1));
            nullNode.setValue(Json.get(this.data, parents));

            status |= nullNode.validate();
            this.addErrors(nullNode.getErrors());
        }

        if (type.inTypes(ConstraintType.ENUM.name().toLowerCase())) {}

        if (type.inTypes(ConstraintType.ARRAY.name().toLowerCase())) {}

        // Skip if node not object
        if (!type.inTypes(ConstraintType.OBJECT.name().toLowerCase())) {
            return status;
        }

        // Skip if the object node is optional and not part of the incoming data
        if (Json.get(this.data, parents) == null
                && !required.contains(parents.get(parents.size() - 1))) {
            return true;
        }

        // Validate sub-nodes
        for (Map.Entry item : node.properties.entrySet()) {
            ArrayList<String> nodeParents = new ArrayList<>(parents);
            nodeParents.add((String) item.getKey());
            status &= this.validateNode(nodeParents, (NodeDraft6) item.getValue(), node.required);
        }

        return status;
    }

    /**
     * Validate a Draft7 Node
     *
     * @param parents node parents
     * @param node draft7 node
     * @param required the required items from the parent node
     * @return whether node is valid or not
     * @throws SchemaError schema error
     */
    public Boolean validateNode(
            ArrayList<String> parents, NodeDraft7 node, ArrayList<String> required)
            throws SchemaError {
        Boolean status = false;

        // Validate node
        Type type = new Type(node.type);

        if (type.inTypes(ConstraintType.STRING.name().toLowerCase())) {
            StringConstraint stringNode = new StringConstraint();

            stringNode.setFieldName(parents.get(parents.size() - 1));

            stringNode.setValue(Json.get(this.data, parents));

            if (required != null && required.size() > 0) {
                stringNode.setRequired(required.contains(parents.get(parents.size() - 1)));
            }
            if (node.minLength != null) {
                stringNode.setMinLength(node.minLength);
            }
            if (node.maxLength != null) {
                stringNode.setMaxLength(node.maxLength);
            }
            if (node.pattern != null) {
                stringNode.setPattern(node.pattern);
            }
            if (node.format != null) {
                stringNode.setFormat(node.format);
            }

            status |= stringNode.validate();
            this.addErrors(stringNode.getErrors());
        }

        if (type.inTypes(ConstraintType.INTEGER.name().toLowerCase())) {
            IntegerConstraint integerNode = new IntegerConstraint();

            integerNode.setFieldName(parents.get(parents.size() - 1));
            integerNode.setValue(Json.get(this.data, parents));

            if (required != null && required.size() > 0) {
                integerNode.setRequired(required.contains(parents.get(parents.size() - 1)));
            }
            if (node.multipleOf != null) {
                integerNode.setMultipleOf(node.multipleOf);
            }
            if (node.minimum != null) {
                integerNode.setMinimum(node.minimum);
            }
            if (node.maximum != null) {
                integerNode.setMaximum(node.maximum);
            }
            if (node.exclusiveMinimum != null) {
                integerNode.setExclusiveMinimum(node.exclusiveMinimum);
            }
            if (node.exclusiveMaximum != null) {
                integerNode.setExclusiveMaximum(node.exclusiveMaximum);
            }

            status |= integerNode.validate();
            this.addErrors(integerNode.getErrors());
        }

        if (type.inTypes(ConstraintType.NUMBER.name().toLowerCase())) {
            NumberConstraint numberNode = new NumberConstraint();

            numberNode.setFieldName(parents.get(parents.size() - 1));
            numberNode.setValue(Json.get(this.data, parents));

            if (required != null && required.size() > 0) {
                numberNode.setRequired(required.contains(parents.get(parents.size() - 1)));
            }
            if (node.multipleOf != null) {
                numberNode.setMultipleOf(node.multipleOf);
            }
            if (node.minimum != null) {
                numberNode.setMinimum(node.minimum);
            }
            if (node.maximum != null) {
                numberNode.setMaximum(node.maximum);
            }
            if (node.exclusiveMinimum != null) {
                numberNode.setExclusiveMinimum(node.exclusiveMinimum);
            }
            if (node.exclusiveMaximum != null) {
                numberNode.setExclusiveMaximum(node.exclusiveMaximum);
            }

            status |= numberNode.validate();
            this.addErrors(numberNode.getErrors());
        }

        if (type.inTypes(ConstraintType.BOOLEAN.name().toLowerCase())) {
            BooleanConstraint booleanNode = new BooleanConstraint();
            booleanNode.setFieldName(parents.get(parents.size() - 1));

            if (required != null && required.size() > 0) {
                booleanNode.setRequired(required.contains(parents.get(parents.size() - 1)));
            }

            booleanNode.setValue(Json.get(this.data, parents));

            status |= booleanNode.validate();
            this.addErrors(booleanNode.getErrors());
        }

        if (type.inTypes(ConstraintType.NULL.name().toLowerCase())) {
            NullConstraint nullNode = new NullConstraint();
            nullNode.setFieldName(parents.get(parents.size() - 1));
            nullNode.setValue(Json.get(this.data, parents));

            status |= nullNode.validate();
            this.addErrors(nullNode.getErrors());
        }

        if (type.inTypes(ConstraintType.ENUM.name().toLowerCase())) {}

        if (type.inTypes(ConstraintType.ARRAY.name().toLowerCase())) {
            System.out.println("----dddd----");
            System.out.println(node.type);
            System.out.println(Json.get(this.data, parents));
        }

        // Skip if node not object
        if (!type.inTypes(ConstraintType.OBJECT.name().toLowerCase())) {
            return status;
        }

        // Skip if the object node is optional and not part of the incoming data
        if (Json.get(this.data, parents) == null
                && !required.contains(parents.get(parents.size() - 1))) {
            return true;
        }

        // Validate sub-nodes
        for (Map.Entry item : node.properties.entrySet()) {
            ArrayList<String> nodeParents = new ArrayList<>(parents);
            nodeParents.add((String) item.getKey());
            status &= this.validateNode(nodeParents, (NodeDraft7) item.getValue(), node.required);
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
     * @return Whether there is errors or not
     */
    public Boolean hasErrors() {
        return this.errors.size() > 0;
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
