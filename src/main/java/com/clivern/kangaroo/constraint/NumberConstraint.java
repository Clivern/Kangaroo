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
package com.clivern.kangaroo.constraint;

import com.clivern.kangaroo.util.Validate;
import java.util.ArrayList;

/**
 * Number Constraint Class
 *
 * @see <a href="https://json-schema.org/understanding-json-schema/reference/numeric.html">Numeric
 *     types</a>
 */
public class NumberConstraint implements ConstraintInterface<Object, String> {

    private String fieldName;

    private String multipleOf;

    private String minimum;

    private String maximum;

    private String exclusiveMinimum;

    private String exclusiveMaximum;

    private Object value;

    private ArrayList<String> errors = new ArrayList<String>();

    public static final String FLOAT = "FLOAT";

    public static final String INTEGER = "INTEGER";

    public static final String IN_VALID = "IN_VALID";

    /** {@inheritDoc} */
    public void setValue(Object value) {
        this.value = value;
    }

    /** {@inheritDoc} */
    public void setFieldName(String fieldName) {
        this.fieldName = fieldName;
    }

    /** {@inheritDoc} */
    public String getValue() {
        return Validate.isNumber(this.value) ? String.valueOf(this.value) : "0";
    }

    /** {@inheritDoc} */
    public String getFieldName() {
        return this.fieldName;
    }

    /** {@inheritDoc} */
    public Boolean isValidType() {
        return Validate.isNumber(this.value);
    }

    /** {@inheritDoc} */
    public Boolean validate() {
        Boolean status = true;

        if (!this.isValidType()) {
            status &= false;
            this.errors.add(String.format("Error! Field %s must be a number.", this.fieldName));
        }

        if (!this.getMultipleOf().equals("")
                && !Validate.multipleOf(
                        Float.valueOf(this.getValue()), Float.valueOf(this.getMultipleOf()))) {
            status &= false;
            this.errors.add(
                    String.format(
                            "Error! Field %s must be multiple of %s.",
                            this.fieldName, this.getMultipleOf()));
        }

        if (!this.getMinimum().equals("")
                && !Validate.greaterThanEq(
                        Float.valueOf(this.getValue()), Float.valueOf(this.getMinimum()))) {
            status &= false;
            this.errors.add(
                    String.format(
                            "Error! Field %s must be greater than or equal %s.",
                            this.fieldName, this.getMinimum()));
        }

        if (!this.getMaximum().equals("")
                && !Validate.lessThanEq(
                        Float.valueOf(this.getValue()), Float.valueOf(this.getMaximum()))) {
            status &= false;
            this.errors.add(
                    String.format(
                            "Error! Field %s must be less than or equal %s.",
                            this.fieldName, this.getMaximum()));
        }

        if (!this.getExclusiveMinimum().equals("")
                && !Validate.greaterThan(
                        Float.valueOf(this.getValue()),
                        Float.valueOf(this.getExclusiveMinimum()))) {
            status &= false;
            this.errors.add(
                    String.format(
                            "Error! Field %s must be greater than %s.",
                            this.fieldName, this.getExclusiveMinimum()));
        }

        if (!this.getExclusiveMaximum().equals("")
                && !Validate.lessThan(
                        Float.valueOf(this.getValue()),
                        Float.valueOf(this.getExclusiveMaximum()))) {
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
     * Set multipleOf value
     *
     * @param multipleOf the multipleOf value
     */
    public void setMultipleOf(Integer multipleOf) {
        this.multipleOf = String.valueOf(multipleOf);
    }

    /**
     * Set multiple of
     *
     * @param multipleOf the multiple of value
     */
    public void setMultipleOf(Float multipleOf) {
        this.multipleOf = String.valueOf(multipleOf);
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
    public void setMinimum(Integer minimum) {
        this.minimum = String.valueOf(minimum);
    }

    /**
     * Set minimum
     *
     * @param minimum the minimum value
     */
    public void setMinimum(Float minimum) {
        this.minimum = String.valueOf(minimum);
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
    public void setMaximum(Integer maximum) {
        this.maximum = String.valueOf(maximum);
    }

    /**
     * Set maximum
     *
     * @param maximum the maximum value
     */
    public void setMaximum(Float maximum) {
        this.maximum = String.valueOf(maximum);
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
    public void setExclusiveMinimum(Integer exclusiveMinimum) {
        this.exclusiveMinimum = String.valueOf(exclusiveMinimum);
    }

    /**
     * Set exclusive minimum
     *
     * @param exclusiveMinimum the exclusive minimum value
     */
    public void setExclusiveMinimum(Float exclusiveMinimum) {
        this.exclusiveMinimum = String.valueOf(exclusiveMinimum);
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
    public void setExclusiveMaximum(Integer exclusiveMaximum) {
        this.exclusiveMaximum = String.valueOf(exclusiveMaximum);
    }

    /**
     * Set exclusive maximum
     *
     * @param exclusiveMaximum the exclusiveMaximum value
     */
    public void setExclusiveMaximum(Float exclusiveMaximum) {
        this.exclusiveMaximum = String.valueOf(exclusiveMaximum);
    }

    /**
     * Get exclusive maximum
     *
     * @return the exclusiveMaximum value
     */
    public String getExclusiveMaximum() {
        return (this.exclusiveMaximum != null) ? this.exclusiveMaximum : "";
    }

    /**
     * Get number type
     *
     * @return the number type
     */
    public String getNumberType() {
        if (Validate.isInteger(this.value)) {
            return NumberConstraint.INTEGER;
        }
        if (Validate.isNumber(this.value)) {
            return NumberConstraint.FLOAT;
        }

        return NumberConstraint.IN_VALID;
    }
}
