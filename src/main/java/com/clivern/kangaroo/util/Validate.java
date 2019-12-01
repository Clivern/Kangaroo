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

import org.apache.commons.validator.GenericValidator;
import org.apache.commons.validator.routines.InetAddressValidator;
import org.apache.commons.validator.routines.RegexValidator;
import org.apache.commons.validator.routines.UrlValidator;

/** Validate Class */
public class Validate {

    public static final String DEFAULT_DATE_FORMAT = "yyyy-MM-dd";

    public static final String DEFAULT_TIME_FORMAT = "HH:mm:ss";

    public static final String DEFAULT_DATE_TIME_FORMAT = "yyyy-MM-dd HH:mm:ss";

    /**
     * Validate if a value is string
     *
     * @param value field value
     * @return whether field is string or not
     */
    public static Boolean isString(Object value) {
        try {
            return ((value == null) || !(value instanceof String)) ? false : true;
        } catch (Exception e) {
            return false;
        }
    }

    /**
     * Validate if a value is integer
     *
     * @param value field value
     * @return whether field is integer or not
     */
    public static Boolean isInteger(Object value) {
        try {
            return ((value == null) || !(value instanceof Integer)) ? false : true;
        } catch (Exception e) {
            return false;
        }
    }

    /**
     * Validate if a value is number
     *
     * @param value field value
     * @return whether field is number or not
     */
    public static Boolean isNumber(Object value) {
        try {
            return ((value == null) || (!(value instanceof Integer) && !(value instanceof Float)))
                    ? false
                    : true;
        } catch (Exception e) {
            return false;
        }
    }

    /**
     * Validate if a value is boolean
     *
     * @param value field value
     * @return whether field is boolean or not
     */
    public static Boolean isBoolean(Object value) {
        try {
            return ((value == null) || !(value instanceof Boolean)) ? false : true;
        } catch (Exception e) {
            return false;
        }
    }

    /**
     * Validate if a value is null
     *
     * @param value field value
     * @return whether field is null or not
     */
    public static Boolean isNull(Object value) {
        try {
            return (value == null) ? true : false;
        } catch (Exception e) {
            return false;
        }
    }

    /**
     * Validate if a string is empty or not
     *
     * @param value field value
     * @return whether field is empty or nor
     */
    public static Boolean isEmpty(String value) {
        if (value == null) {
            return true;
        }
        value = value.trim();
        return value.equals("");
    }

    /**
     * Validate String Length equals a specific value
     *
     * @param value field value
     * @param length string length
     * @return whether field is valid or not
     */
    public static Boolean lengthEq(String value, int length) {
        value = value.trim();
        return value.length() == length;
    }

    /**
     * Validate String Length is between two values
     *
     * @param value field value
     * @param minLength minimum string length
     * @param maxLength maximum string length
     * @return whether field is valid or not
     */
    public static Boolean lengthBetween(String value, int minLength, int maxLength) {
        value = value.trim();
        return (value.length() >= minLength) && (value.length() <= maxLength);
    }

    /**
     * Validate String Length less than a specific value
     *
     * @param value field value
     * @param maxLength maximum string length
     * @return whether field is valid or not
     */
    public static Boolean lengthLessThanEq(String value, int maxLength) {
        value = value.trim();
        return (value.length() <= maxLength);
    }

    /**
     * Validate String Length more than a specific value
     *
     * @param value field value
     * @param minLength minimum string length
     * @return whether field is valid or not
     */
    public static Boolean lengthMoreThanEq(String value, int minLength) {
        value = value.trim();
        return (value.length() >= minLength);
    }

    /**
     * Validate Against a Regex
     *
     * @param value field value
     * @param regex the regex to validate against
     * @return whether field is valid or not
     */
    public static Boolean regex(String value, String regex) {
        RegexValidator validator = new RegexValidator(new String[] {regex});
        return validator.isValid(value);
    }

    /**
     * Validate Datetime
     *
     * @param value field value
     * @param format the date format
     * @param strict whether a strict validation
     * @return whether field is valid or not
     */
    public static Boolean isDatetime(String value, String format, Boolean strict) {
        return GenericValidator.isDate(value, format, strict);
    }

    /**
     * Validate Datetime
     *
     * @param value field value
     * @param format the date format
     * @return whether field is valid or not
     */
    public static Boolean isDatetime(String value, String format) {
        return GenericValidator.isDate(value, format, true);
    }

    /**
     * Validate Datetime
     *
     * @param value field value
     * @return whether field is valid or not
     */
    public static Boolean isDatetime(String value) {
        return GenericValidator.isDate(value, Validate.DEFAULT_DATE_TIME_FORMAT, true);
    }

    /**
     * Validate Date
     *
     * @param value field value
     * @param format the date format
     * @param strict whether a strict validation
     * @return whether field is valid or not
     */
    public static Boolean isDate(String value, String format, Boolean strict) {
        return GenericValidator.isDate(value, format, strict);
    }

    /**
     * Validate Date
     *
     * @param value field value
     * @param format the date format
     * @return whether field is valid or not
     */
    public static Boolean isDate(String value, String format) {
        return GenericValidator.isDate(value, format, true);
    }

    /**
     * Validate Date
     *
     * @param value field value
     * @return whether field is valid or not
     */
    public static Boolean isDate(String value) {
        return GenericValidator.isDate(value, Validate.DEFAULT_DATE_FORMAT, true);
    }

    /**
     * Validate Time
     *
     * @param value field value
     * @param format the date format
     * @param strict whether a strict validation
     * @return whether field is valid or not
     */
    public static Boolean isTime(String value, String format, Boolean strict) {
        return GenericValidator.isDate(value, format, strict);
    }

    /**
     * Validate Time
     *
     * @param value field value
     * @param format the date format
     * @return whether field is valid or not
     */
    public static Boolean isTime(String value, String format) {
        return GenericValidator.isDate(value, format, true);
    }

    /**
     * Validate Time
     *
     * @param value field value
     * @return whether field is valid or not
     */
    public static Boolean isTime(String value) {
        return GenericValidator.isDate(value, Validate.DEFAULT_TIME_FORMAT, true);
    }

    /**
     * Validate Email
     *
     * @param value field value
     * @return whether field is valid or not
     */
    public static Boolean isEmail(String value) {
        return GenericValidator.isEmail(value);
    }

    /**
     * Validate ipv4
     *
     * @param value field value
     * @return whether field is valid or not
     */
    public static Boolean isIpv4(String value) {
        InetAddressValidator validator = InetAddressValidator.getInstance();
        return validator.isValidInet4Address(value);
    }

    /**
     * Validate ipv6
     *
     * @param value field value
     * @return whether field is valid or not
     */
    public static Boolean isIpv6(String value) {
        InetAddressValidator validator = InetAddressValidator.getInstance();
        return validator.isValidInet6Address(value);
    }

    /**
     * Validate URL
     *
     * @param value field value
     * @param schemes the url scheme
     * @return whether field is valid or not
     */
    public static Boolean isURL(String value, String[] schemes) {
        UrlValidator urlValidator = new UrlValidator(schemes);
        return urlValidator.isValid(value);
    }

    /**
     * Validate URL
     *
     * @param value field value
     * @return whether field is valid or not
     */
    public static Boolean isURL(String value) {
        return GenericValidator.isUrl(value);
    }

    /**
     * Validate if number is greater than another
     *
     * @param value field value
     * @param minimum the minimum value
     * @return whether value is greater than the minimum
     */
    public static Boolean greaterThan(Float value, Float minimum) {
        return (Float.compare(minimum, value) < 0);
    }

    /**
     * Validate if number is greater than or equal another
     *
     * @param value field value
     * @param minimum the minimum value
     * @return whether value is greater than or equal the minimum
     */
    public static Boolean greaterThanEq(Float value, Float minimum) {
        if (Float.compare(value, minimum) == 0) {
            return true;
        }

        return (Float.compare(minimum, value) < 0);
    }

    /**
     * Validate if number is less than another
     *
     * @param value field value
     * @param maximum the maximum value
     * @return whether value is less than the maximum
     */
    public static Boolean lessThan(Float value, Float maximum) {
        return (Float.compare(value, maximum) < 0);
    }

    /**
     * Validate if number is less than or equal another
     *
     * @param value field value
     * @param maximum the maximum value
     * @return whether value is less than or equal the maximum
     */
    public static Boolean lessThanEq(Float value, Float maximum) {
        if (Float.compare(value, maximum) == 0) {
            return true;
        }

        return (Float.compare(value, maximum) < 0);
    }

    /**
     * Validate if number is multipleOf a provided factor
     *
     * @param value field value
     * @param factor the factor
     * @return whether number is multipleOf a provided factor
     */
    public static Boolean multipleOf(Float value, Float factor) {
        if (Float.compare(value, new Float("0")) == 0) {
            return true;
        }

        return (Float.compare(value % factor, new Float("0")) == 0);
    }
}
