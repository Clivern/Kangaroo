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

import com.google.common.base.Strings;

/** Validate Class */
public class Validate {

    /**
     * Validate if a value is string
     *
     * @param value input value
     * @return whether input is string or not
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
     * @param value input value
     * @return whether input is integer or not
     */
    public static Boolean isInteger(Object value) {
        try {
            return ((value == null) || !(value instanceof Integer)) ? false : true;
        } catch (Exception e) {
            return false;
        }
    }

    /**
     * Validate if a string is empty or not
     *
     * @param value input value
     * @return whether input is empty or nor
     */
    public static Boolean isEmpty(String value) {
        return Strings.isNullOrEmpty(value);
    }

    /**
     * Validate String Length
     *
     * @param value input value
     * @param length string length
     * @return whether input is valid or not
     */
    public static Boolean lengthEq(String value, int length) {
        return false;
    }

    /**
     * Validate String Length
     *
     * @param value input value
     * @param minLength minimum string length
     * @param maxLength maximum string length
     * @return whether input is valid or not
     */
    public static Boolean lengthBetween(String value, int minLength, int maxLength) {
        return false;
    }

    /**
     * Validate Against a Regex
     *
     * @param value input value
     * @param regex the regex to validate against
     * @return whether input is valid or not
     */
    public static Boolean regex(String value, String regex) {
        return false;
    }

    /**
     * Validate Datetime
     *
     * @param value input value
     * @return whether input is valid or not
     */
    public static Boolean datetime(String value) {
        return false;
    }

    /**
     * Validate Date
     *
     * @param value input value
     * @return whether input is valid or not
     */
    public static Boolean date(String value) {
        return false;
    }

    /**
     * Validate Time
     *
     * @param value input value
     * @return whether input is valid or not
     */
    public static Boolean time(String value) {
        return false;
    }

    /**
     * Validate Email
     *
     * @param value input value
     * @return whether input is valid or not
     */
    public static Boolean email(String value) {
        return false;
    }

    /**
     * Validate ipv4
     *
     * @param value input value
     * @return whether input is valid or not
     */
    public static Boolean ipv4(String value) {
        return false;
    }

    /**
     * Validate ipv6
     *
     * @param value input value
     * @return whether input is valid or not
     */
    public static Boolean ipv6(String value) {
        return false;
    }
}
