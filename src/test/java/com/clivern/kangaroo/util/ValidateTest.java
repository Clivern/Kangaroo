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

import static org.junit.Assert.*;

import com.clivern.kangaroo.TestUtils;
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
        assertEquals(Validate.isNumber("1"), false);
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
}
