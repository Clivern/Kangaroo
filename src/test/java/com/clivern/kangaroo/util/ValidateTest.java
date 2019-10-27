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

import org.junit.Test;

/** Validate Test Cases */
public class ValidateTest {

    @Test
    public void testIsString() {
        assertEquals(Validate.isString(null), false);
        assertEquals(Validate.isString("Hello"), true);
        assertEquals(Validate.isString(""), true);
        assertEquals(Validate.isString(1), false);
    }

    @Test
    public void testIsInteger() {
        assertEquals(Validate.isInteger(1), true);
        assertEquals(Validate.isInteger("1"), false);
        assertEquals(Validate.isInteger(null), false);
    }

    @Test
    public void testIsNull() {
        assertEquals(Validate.isNull(null), true);
        assertEquals(Validate.isNull("1"), false);
        assertEquals(Validate.isNull(false), false);
        assertEquals(Validate.isNull(true), false);
    }

    @Test
    public void testIsEmpty() {
        assertEquals(Validate.isEmpty(""), true);
        assertEquals(Validate.isEmpty(" "), true);
    }

    @Test
    public void testLengthEq() {
        assertEquals(Validate.lengthEq("H ", 1), true);
    }

    @Test
    public void testLengthBetween() {
        assertEquals(Validate.lengthBetween("A B", 3, 4), true);
    }

    @Test
    public void testLengthLessThanEq() {
        assertEquals(Validate.lengthLessThanEq("A B ", 3), true);
    }

    @Test
    public void testLengthMoreThanEq() {
        assertEquals(Validate.lengthMoreThanEq(" AB", 2), true);
    }
}
