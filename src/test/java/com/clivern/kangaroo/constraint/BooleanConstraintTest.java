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
package com.clivern.kangaroo;

import static org.junit.Assert.*;

import com.clivern.kangaroo.constraint.BooleanConstraint;
import java.util.ArrayList;
import org.junit.Test;

/** Boolean Constraint Test Cases */
public class BooleanConstraintTest {

    @Test
    public void testBooleanValidation() {
        TestUtils.print("Test Boolean Constraint");

        BooleanConstraint booleanConstraint1 = new BooleanConstraint();
        booleanConstraint1.setFieldName("fieldName");
        assertEquals(booleanConstraint1.getFieldName(), "fieldName");
        booleanConstraint1.setValue(true);
        assertEquals(booleanConstraint1.getValue(), true);
        assertEquals(booleanConstraint1.validate(), true);
        assertEquals(booleanConstraint1.hasErrors(), false);
        assertEquals(booleanConstraint1.getErrors(), new ArrayList<String>());

        BooleanConstraint booleanConstraint2 = new BooleanConstraint();
        booleanConstraint2.setFieldName("fieldName");
        assertEquals(booleanConstraint2.getFieldName(), "fieldName");
        booleanConstraint2.setValue(false);
        assertEquals(booleanConstraint2.getValue(), false);
        assertEquals(booleanConstraint2.validate(), true);
        assertEquals(booleanConstraint2.hasErrors(), false);
        assertEquals(booleanConstraint2.getErrors(), new ArrayList<String>());

        BooleanConstraint booleanConstraint3 = new BooleanConstraint();
        booleanConstraint3.setFieldName("fieldName");
        assertEquals(booleanConstraint3.getFieldName(), "fieldName");
        ArrayList<String> errors = new ArrayList<String>();
        errors.add(
                String.format(
                        "Error! Field %s must be boolean.", booleanConstraint3.getFieldName()));

        booleanConstraint3.setValue("true");
        assertEquals(booleanConstraint3.getValue(), false);
        assertEquals(booleanConstraint3.validate(), false);
        assertEquals(booleanConstraint3.hasErrors(), true);
        assertEquals(booleanConstraint3.getErrors(), errors);

        BooleanConstraint booleanConstraint4 = new BooleanConstraint();
        booleanConstraint4.setFieldName("fieldName");
        assertEquals(booleanConstraint4.getFieldName(), "fieldName");
        booleanConstraint4.setValue("false");
        assertEquals(booleanConstraint4.getValue(), false);
        assertEquals(booleanConstraint4.validate(), false);
        assertEquals(booleanConstraint4.hasErrors(), true);
        assertEquals(booleanConstraint4.getErrors(), errors);
    }
}
