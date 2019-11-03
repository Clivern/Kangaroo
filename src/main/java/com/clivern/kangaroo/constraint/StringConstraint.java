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

import com.clivern.kangaroo.exception.SchemaError;
import com.clivern.kangaroo.util.Validate;
import java.util.ArrayList;
import java.util.stream.Stream;

/**
 * String Constraint Class
 *
 * @see <a href="https://json-schema.org/understanding-json-schema/reference/string.html">String
 *     types</a>
 */
public class StringConstraint implements ConstraintInterface<Object, String> {

    private String fieldName;

    private Object value;

    private String minLength;

    private String maxLength;

    private String pattern;

    private String format;

    private ArrayList<String> errors = new ArrayList<String>();

    public static final String DATE_TIME = "date-time";

    public static final String TIME = "time";

    public static final String DATE = "date";

    public static final String EMAIL = "email";

    public static final String IDN_EMAIL = "idn-email";

    public static final String HOSTNAME = "hostname";

    public static final String IDN_HOSTNAME = "idn-hostname";

    public static final String IPV4 = "ipv4";

    public static final String IPV6 = "ipv6";

    public static final String URI = "uri";

    public static final String URI_REFERENCE = "uri-reference";

    public static final String IRI = "iri";

    public static final String IRI_REFERENCE = "iri-reference";

    public static final String URI_TEMPLATE = "uri-template";

    public static final String JSON_POINTER = "json-pointer";

    public static final String RELATIVE_JSON_POINTER = "relative-json-pointer";

    public static final String REGEX = "regex";

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
        this.minLength = String.valueOf(minLength);
    }

    /**
     * Set Max Length
     *
     * @param maxLength the max length
     */
    public void setMaxLength(Integer maxLength) {
        this.maxLength = String.valueOf(maxLength);
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
     * @throws SchemaError schema error
     */
    public void setFormat(String format) throws SchemaError {
        String[] formats = {
            StringConstraint.DATE_TIME,
            StringConstraint.TIME,
            StringConstraint.DATE,
            StringConstraint.EMAIL,
            StringConstraint.IDN_EMAIL,
            StringConstraint.HOSTNAME,
            StringConstraint.IDN_HOSTNAME,
            StringConstraint.IPV4,
            StringConstraint.IPV6,
            StringConstraint.URI,
            StringConstraint.URI_REFERENCE,
            StringConstraint.IRI,
            StringConstraint.IRI_REFERENCE,
            StringConstraint.URI_TEMPLATE,
            StringConstraint.JSON_POINTER,
            StringConstraint.RELATIVE_JSON_POINTER,
            StringConstraint.REGEX
        };

        if (!Stream.of(formats).anyMatch(x -> x.equals(format))) {
            throw new SchemaError(String.format("Invalid string constraint format %s.", format));
        }

        this.format = format;
    }

    /**
     * Get Min Length
     *
     * @return the min length
     */
    public Integer getMinLength() {
        return (this.minLength != null) ? Integer.valueOf(this.minLength) : 0;
    }

    /**
     * Get Max Length
     *
     * @return the max length
     */
    public Integer getMaxLength() {
        return (this.maxLength != null) ? Integer.valueOf(this.maxLength) : 0;
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
        Boolean status = true;

        if (!this.isValidType()) {
            status &= false;
            this.errors.add(String.format("Error! Field %s must be a string.", this.fieldName));
        }

        if ((this.minLength != null)
                && !Validate.lengthMoreThanEq(this.getValue(), this.getMinLength())) {
            status &= false;
            this.errors.add(
                    String.format(
                            "Error! Field %s length must be more than or equal %d.",
                            this.fieldName, this.getMinLength()));
        }

        if ((this.maxLength != null)
                && !Validate.lengthLessThanEq(this.getValue(), this.getMaxLength())) {
            status &= false;
            this.errors.add(
                    String.format(
                            "Error! Field %s length must be less than or equal %d.",
                            this.fieldName, this.getMaxLength()));
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
}
