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
package com.clivern.kangaroo;

import static org.junit.Assert.*;

import com.clivern.kangaroo.constraint.IntegerConstraint;
import java.util.ArrayList;
import org.junit.Test;

/** IntegerConstraintTest Class */
public class IntegerConstraintTest {

    @Test
    public void testStringValidation() {
        IntegerConstraint intConstraint = new IntegerConstraint();

        intConstraint.setValue(1);
        assertEquals((int) intConstraint.getValue(), 1);
        assertEquals(intConstraint.isEmpty(), false);
        assertEquals(intConstraint.isValid(), true);

        intConstraint.setValue("");
        assertEquals((int) intConstraint.getValue(), 0);
        assertEquals(intConstraint.isEmpty(), true);
        assertEquals(intConstraint.isValid(), false);

        intConstraint.setValue(null);
        assertEquals((int) intConstraint.getValue(), 0);
        assertEquals(intConstraint.isEmpty(), true);
        assertEquals(intConstraint.isValid(), false);

        ArrayList<String> list = new ArrayList<String>();
        list.add("A");
        list.add("B");
        list.add("C");
        intConstraint.setValue(list);
        assertEquals(intConstraint.isEmpty(), true);
        assertEquals((int) intConstraint.getValue(), 0);
        assertEquals(intConstraint.isValid(), false);
    }
}
