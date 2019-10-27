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

/** String Constraint Class */
public class StringConstraint implements ConstraintInterface<Object, String> {

    private String fieldName;

    private Object value;

    private Integer minLength;

    private Integer maxLength;

    private String pattern;

    private String format;

    private ArrayList<String> errors = new ArrayList<String>();

    /** {@inheritDoc} */
    public void setFieldName(String fieldName) {
        this.fieldName = fieldName;
    }

    /**
     * Set Min Length
     *
     * @param minLength the min length
     */
    public void setMinLength(Integer minLength) {
        this.minLength = minLength;
    }

    /**
     * Set Max Length
     *
     * @param maxLength the max length
     */
    public void setMaxLength(Integer maxLength) {
        this.maxLength = maxLength;
    }

    /**
     * Set Pattern
     *
     * @param pattern the pattern
     */
    public void setPattern(String pattern) {
        this.pattern = pattern;
    }

    /**
     * Set Format
     *
     * @param format the format
     */
    public void setFormat(String format) {
        this.format = format;
    }

    /**
     * Get Min Length
     *
     * @return the min length
     */
    public Integer getMinLength() {
        return this.minLength;
    }

    /**
     * Get Max Length
     *
     * @return the max length
     */
    public Integer getMaxLength() {
        return this.maxLength;
    }

    /**
     * Get Pattern
     *
     * @return the pattern
     */
    public String getPattern() {
        return this.pattern;
    }

    /**
     * Get Format
     *
     * @return the format
     */
    public String getFormat() {
        return this.format;
    }

    /** {@inheritDoc} */
    public void setValue(Object value) {
        this.value = value;
    }

    /** {@inheritDoc} */
    public String getValue() {
        return Validate.isString(this.value) ? (String) this.value : "";
    }

    /** {@inheritDoc} */
    public String getFieldName() {
        return this.fieldName;
    }

    /** {@inheritDoc} */
    public Boolean isValidType() {
        return Validate.isString(this.value);
    }

    /** {@inheritDoc} */
    public Boolean validate() {
        return false;
    }

    /** {@inheritDoc} */
    public ArrayList<String> getErrors() {
        return this.errors;
    }

    /** {@inheritDoc} */
    public Boolean hasErrors() {
        return this.errors.size() > 0;
    }
}
