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
package com.clivern.decoy.constraint;

import com.clivern.decoy.util.Validate;
import java.util.ArrayList;

/**
 * Integer Constraint Class
 *
 * @see <a href="https://json-schema.org/understanding-json-schema/reference/numeric.html">Numeric
 *     types</a>
 */
public class IntegerConstraint implements ConstraintInterface<Object, Integer> {

    private String fieldName;

    private String multipleOf;

    private String minimum;

    private String maximum;

    private String exclusiveMinimum;

    private String exclusiveMaximum;

    private Object value;

    private Boolean required;

    private ArrayList<String> errors = new ArrayList<String>();

    /** {@inheritDoc} */
    public void setValue(Object value) {
        this.value = value;
    }

    /** {@inheritDoc} */
    public void setFieldName(String fieldName) {
        this.fieldName = fieldName;
    }

    /** {@inheritDoc} */
    public Integer getValue() {
        return Validate.isInteger(this.value) ? Integer.valueOf((int) this.value) : 0;
    }

    /** {@inheritDoc} */
    public String getFieldName() {
        return this.fieldName;
    }

    /** {@inheritDoc} */
    public Boolean isValidType() {
        return Validate.isInteger(this.value);
    }

    /** {@inheritDoc} */
    public Boolean validate() {
        Boolean status = true;

        if (!this.isValidType()) {
            status &= false;
            this.errors.add(String.format("Error! Field %s must be an integer.", this.fieldName));
        }

        if (this.required != null && this.required && this.value == null) {
            status &= false;
            this.errors.add(String.format("Error! Field %s is required.", this.fieldName));
        }

        if (!this.getMultipleOf().equals("")
                && !Validate.multipleOf(
                        Integer.valueOf(this.getValue()), Integer.valueOf(this.getMultipleOf()))) {
            status &= false;
            this.errors.add(
                    String.format(
                            "Error! Field %s must be multiple of %s.",
                            this.fieldName, this.getMultipleOf()));
        }

        if (!this.getMinimum().equals("")
                && !Validate.greaterThanEq(
                        Integer.valueOf(this.getValue()), Integer.valueOf(this.getMinimum()))) {
            status &= false;
            this.errors.add(
                    String.format(
                            "Error! Field %s must be greater than or equal %s.",
                            this.fieldName, this.getMinimum()));
        }

        if (!this.getMaximum().equals("")
                && !Validate.lessThanEq(
                        Integer.valueOf(this.getValue()), Integer.valueOf(this.getMaximum()))) {
            status &= false;
            this.errors.add(
                    String.format(
                            "Error! Field %s must be less than or equal %s.",
                            this.fieldName, this.getMaximum()));
        }

        if (!this.getExclusiveMinimum().equals("")
                && !Validate.greaterThan(
                        Integer.valueOf(this.getValue()),
                        Integer.valueOf(this.getExclusiveMinimum()))) {
            status &= false;
            this.errors.add(
                    String.format(
                            "Error! Field %s must be greater than %s.",
                            this.fieldName, this.getExclusiveMinimum()));
        }

        if (!this.getExclusiveMaximum().equals("")
                && !Validate.lessThan(
                        Integer.valueOf(this.getValue()),
                        Integer.valueOf(this.getExclusiveMaximum()))) {
            status &= false;
            this.errors.add(
                    String.format(
                            "Error! Field %s must be less than %s.",
                            this.fieldName, this.getExclusiveMaximum()));
        }

        return status;
    }

    /** {@inheritDoc} */
    public ArrayList<String> getErrors() {
        return this.errors;
    }

    /** {@inheritDoc} */
    public Boolean hasErrors() {
        return this.errors.size() > 0;
    }

    /**
     * Set Required
     *
     * @param required whether required or not
     */
    public void setRequired(Boolean required) {
        this.required = required;
    }

    /**
     * Get Required
     *
     * @return whether required or not
     */
    public Boolean getRequired() {
        return this.required;
    }

    /**
     * Set multipleOf value
     *
     * @param multipleOf the multipleOf value
     */
    public void setMultipleOf(String multipleOf) {
        this.multipleOf = multipleOf;
    }

    /**
     * Get multipleOf value
     *
     * @return the multipleOf value
     */
    public String getMultipleOf() {
        return (this.multipleOf != null) ? this.multipleOf : "";
    }

    /**
     * Set minimum
     *
     * @param minimum the minimum value
     */
    public void setMinimum(String minimum) {
        this.minimum = minimum;
    }

    /**
     * Get minimum
     *
     * @return the minimum value
     */
    public String getMinimum() {
        return (this.minimum != null) ? this.minimum : "";
    }

    /**
     * Set maximum
     *
     * @param maximum the maximum value
     */
    public void setMaximum(String maximum) {
        this.maximum = maximum;
    }

    /**
     * Get maximum
     *
     * @return the maximum value
     */
    public String getMaximum() {
        return (this.maximum != null) ? this.maximum : "";
    }

    /**
     * Set exclusive minimum
     *
     * @param exclusiveMinimum the exclusive minimum value
     */
    public void setExclusiveMinimum(String exclusiveMinimum) {
        this.exclusiveMinimum = exclusiveMinimum;
    }

    /**
     * Get exclusive minimum
     *
     * @return the exclusiveMinimum value
     */
    public String getExclusiveMinimum() {
        return (this.exclusiveMinimum != null) ? this.exclusiveMinimum : "";
    }

    /**
     * Set exclusive maximum
     *
     * @param exclusiveMaximum the exclusiveMaximum value
     */
    public void setExclusiveMaximum(String exclusiveMaximum) {
        this.exclusiveMaximum = exclusiveMaximum;
    }

    /**
     * Get exclusive maximum
     *
     * @return the exclusiveMaximum value
     */
    public String getExclusiveMaximum() {
        return (this.exclusiveMaximum != null) ? this.exclusiveMaximum : "";
    }
}
