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
package com.clivern.decoy.util;

import static org.junit.Assert.*;

import com.clivern.decoy.TestUtils;
import org.junit.Test;

/** Validate Test Cases */
public class ValidateTest {

    @Test
    public void testIsString() {
        TestUtils.print("Test Validate::isString");
        assertEquals(Validate.isString(null), false);
        assertEquals(Validate.isString("Hello"), true);
        assertEquals(Validate.isString(""), true);
        assertEquals(Validate.isString(1), false);
    }

    @Test
    public void testIsInteger() {
        TestUtils.print("Test Validate::isInteger");
        assertEquals(Validate.isInteger(0), true);
        assertEquals(Validate.isInteger(1), true);
        assertEquals(Validate.isInteger(-1), true);
        assertEquals(Validate.isInteger("1"), false);
        assertEquals(Validate.isInteger(null), false);
        assertEquals(Validate.isInteger(1.2), false);
        assertEquals(Validate.isInteger(-1.2), false);
        assertEquals(Validate.isInteger(new Float(1.2)), false);
        assertEquals(Validate.isInteger(new Float(-1.2)), false);
    }

    @Test
    public void testIsNumber() {
        TestUtils.print("Test Validate::isNumber");
        assertEquals(Validate.isNumber(0), true);
        assertEquals(Validate.isNumber(1), true);
        assertEquals(Validate.isNumber(-1), true);
        assertEquals(Validate.isNumber(new Float(1.2)), true);
        assertEquals(Validate.isNumber(new Float(-1.2)), true);
        assertEquals(Validate.isNumber("1"), true);
        assertEquals(Validate.isNumber(null), false);
        assertEquals(Validate.isNumber(new Float(2.99792458e8)), true);
        assertEquals(Validate.isNumber(new Float(-2.99792458e8)), true);
    }

    @Test
    public void testIsNull() {
        TestUtils.print("Test Validate::isNull");
        assertEquals(Validate.isNull(null), true);
        assertEquals(Validate.isNull("1"), false);
        assertEquals(Validate.isNull(false), false);
        assertEquals(Validate.isNull(true), false);
    }

    @Test
    public void testIsEmpty() {
        TestUtils.print("Test Validate::isEmpty");
        assertEquals(Validate.isEmpty(""), true);
        assertEquals(Validate.isEmpty(" "), true);
    }

    @Test
    public void testLengthEq() {
        TestUtils.print("Test Validate::lengthEq");
        assertEquals(Validate.lengthEq("H ", 1), true);
    }

    @Test
    public void testLengthBetween() {
        TestUtils.print("Test Validate::lengthBetween");
        assertEquals(Validate.lengthBetween("A B", 3, 4), true);
    }

    @Test
    public void testLengthLessThanEq() {
        TestUtils.print("Test Validate::lengthLessThanEq");
        assertEquals(Validate.lengthLessThanEq("A B ", 3), true);
    }

    @Test
    public void testLengthMoreThanEq() {
        TestUtils.print("Test Validate::lengthMoreThanEq");
        assertEquals(Validate.lengthMoreThanEq(" AB", 2), true);
    }

    @Test
    public void testIsEmail() {
        TestUtils.print("Test Validate::isEmail");
        assertEquals(Validate.isEmail("hello@clivern.com"), true);
        assertEquals(Validate.isEmail("hello@clivern"), false);
        assertEquals(Validate.isEmail("clivern"), false);
    }

    @Test
    public void testIsURL() {
        TestUtils.print("Test Validate::isURL");
        assertEquals(Validate.isURL("http://clivern.com", new String[] {"http", "https"}), true);
        assertEquals(Validate.isURL("https://clivern.com", new String[] {"http", "https"}), true);
        assertEquals(Validate.isURL("ftp://clivern.com", new String[] {"http", "https"}), false);
        assertEquals(
                Validate.isURL("ftp://clivern.com", new String[] {"ftp", "http", "https"}), true);
        assertEquals(Validate.isURL("clivern.com", new String[] {"http", "https"}), false);
        assertEquals(Validate.isURL("http://clivern.com", new String[] {}), false);
    }

    @Test
    public void testRegex() {
        TestUtils.print("Test Validate::regex");
        assertEquals(Validate.regex("clivern", "\\w+"), true);
        assertEquals(Validate.regex("cliv ern", "\\w+\\s\\w+"), true);
        assertEquals(Validate.regex("hello@clivern.com", "\\w+@\\w+.\\w+"), true);
    }

    @Test
    public void testIsIpv4() {
        TestUtils.print("Test Validate::isIpv4");
        assertEquals(Validate.isIpv4("127.0.0.1"), true);
        assertEquals(Validate.isIpv4("208.98.192.170"), true);
        assertEquals(Validate.isIpv4("128.9.2"), false);
    }

    @Test
    public void testIsIpv6() {
        TestUtils.print("Test Validate::isIpv6");
        assertEquals(Validate.isIpv6("2001:0db8:85a3:0000:0000:8a2e:0370:7334"), true);
        assertEquals(Validate.isIpv6("2001:0db8:85a3:0000:0000:8a2e:03707334"), false);
        assertEquals(Validate.isIpv6("208.98.192.170"), false);
        assertEquals(Validate.isIpv6("128.9.2"), false);
    }

    @Test
    public void testIsDate() {
        TestUtils.print("Test Validate::isDate");
        assertEquals(Validate.isDate("2019-02-28", "yyyy-MM-dd", true), true);
        assertEquals(Validate.isDate("2019-02-2", "yyyy-MM-dd", true), false);
        assertEquals(Validate.isDate("2019-10-29 11:34:14", "yyyy-MM-dd HH:mm:ss", true), true);
    }

    @Test
    public void testIsTime() {
        TestUtils.print("Test Validate::isTime");
        assertEquals(Validate.isDate("20:34:12", "HH:mm:ss", true), true);
        assertEquals(Validate.isDate("11:34", "HH:mm:ss", true), false);
        assertEquals(Validate.isDate("11:34:14", "HH:mm:ss", true), true);
    }

    @Test
    public void testIsDateTime() {
        TestUtils.print("Test Validate::isDateTime");
        assertEquals(Validate.isDate("2019-02-28 11:34:14", "yyyy-MM-dd HH:mm:ss", true), true);
        assertEquals(Validate.isDate("2019-02-2 20:34:12", "yyyy-MM-dd HH:mm:ss", true), false);
        assertEquals(Validate.isDate("2019-10-29 11:34:14", "yyyy-MM-dd HH:mm:ss", true), true);
        assertEquals(Validate.isDate("2019-10-29-11:34:14", "yyyy-MM-dd HH:mm:ss", true), false);
    }

    @Test
    public void testGreaterThan() {
        TestUtils.print("Test Validate::greaterThan");

        assertEquals(Validate.greaterThan(new Float("1"), new Float("2")), false);
        assertEquals(Validate.greaterThan(new Float("1"), new Float("1")), false);
        assertEquals(Validate.greaterThan(new Float("0"), new Float("0")), false);
        assertEquals(Validate.greaterThan(new Float("1.2"), new Float("1.2")), false);
        assertEquals(Validate.greaterThan(new Float("10.2"), new Float("10.103")), true);
        assertEquals(Validate.greaterThan(new Float("39"), new Float("10")), true);
    }

    @Test
    public void testGreaterThanEq() {
        TestUtils.print("Test Validate::greaterThanEq");
        assertEquals(Validate.greaterThanEq(new Float("1"), new Float("2")), false);
        assertEquals(Validate.greaterThanEq(new Float("1"), new Float("1")), true);
        assertEquals(Validate.greaterThanEq(new Float("0"), new Float("0")), true);
        assertEquals(Validate.greaterThanEq(new Float("1.2"), new Float("1.2")), true);
        assertEquals(Validate.greaterThanEq(new Float("10.2"), new Float("10.103")), true);
        assertEquals(Validate.greaterThanEq(new Float("39"), new Float("10")), true);
    }

    @Test
    public void testLessThan() {
        TestUtils.print("Test Validate::lessThan");
        assertEquals(Validate.lessThan(new Float("1"), new Float("2")), true);
        assertEquals(Validate.lessThan(new Float("1"), new Float("1")), false);
        assertEquals(Validate.lessThan(new Float("0"), new Float("0")), false);
        assertEquals(Validate.lessThan(new Float("1.2"), new Float("1.2")), false);
        assertEquals(Validate.lessThan(new Float("10.102"), new Float("10.2")), true);
        assertEquals(Validate.lessThan(new Float("39"), new Float("10")), false);
    }

    @Test
    public void testLessThanEq() {
        TestUtils.print("Test Validate::lessThanEq");
        assertEquals(Validate.lessThanEq(new Float("1"), new Float("2")), true);
        assertEquals(Validate.lessThanEq(new Float("1"), new Float("1")), true);
        assertEquals(Validate.lessThanEq(new Float("0"), new Float("0")), true);
        assertEquals(Validate.lessThanEq(new Float("20"), new Float("10.2")), false);
        assertEquals(Validate.lessThanEq(new Float("39"), new Float("10")), false);
    }

    @Test
    public void testMultipleOf() {
        TestUtils.print("Test Validate::multipleOf");
        assertEquals(Validate.multipleOf(new Float("0"), new Float("10")), true);
        assertEquals(Validate.multipleOf(new Float("10"), new Float("10")), true);
        assertEquals(Validate.multipleOf(new Float("20"), new Float("10")), true);
        assertEquals(Validate.multipleOf(new Float("21"), new Float("10")), false);
        assertEquals(Validate.multipleOf(new Float("39"), new Float("10")), false);
    }
}
