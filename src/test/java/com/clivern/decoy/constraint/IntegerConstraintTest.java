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
package com.clivern.decoy;

import static org.junit.Assert.*;

import com.clivern.decoy.constraint.IntegerConstraint;
import java.util.ArrayList;
import org.junit.Test;

/** Integer Constraint Test Cases */
public class IntegerConstraintTest {

    @Test
    public void testIntegerValidation() {
        TestUtils.print("Test Integer Constraint");

        IntegerConstraint integerConstraint1 = new IntegerConstraint();
        integerConstraint1.setFieldName("fieldName");
        assertEquals(integerConstraint1.getFieldName(), "fieldName");
        integerConstraint1.setValue(1);
        assertEquals(integerConstraint1.getValue(), new Integer("1"));
        assertEquals(integerConstraint1.validate(), true);
        assertEquals(integerConstraint1.hasErrors(), false);
        assertEquals(integerConstraint1.getErrors(), new ArrayList<String>());

        IntegerConstraint integerConstraint2 = new IntegerConstraint();
        integerConstraint2.setFieldName("fieldName");
        assertEquals(integerConstraint2.getFieldName(), "fieldName");
        integerConstraint2.setValue(-1);
        assertEquals(integerConstraint2.getValue(), new Integer("-1"));
        assertEquals(integerConstraint2.validate(), true);
        assertEquals(integerConstraint2.hasErrors(), false);
        assertEquals(integerConstraint2.getErrors(), new ArrayList<String>());

        IntegerConstraint integerConstraint3 = new IntegerConstraint();
        integerConstraint3.setFieldName("fieldName");
        assertEquals(integerConstraint3.getFieldName(), "fieldName");
        integerConstraint3.setValue(1.2);
        assertEquals(integerConstraint3.getValue(), new Integer("0"));
        assertEquals(integerConstraint3.validate(), false);
        assertEquals(integerConstraint3.hasErrors(), true);
        ArrayList<String> errors = new ArrayList<String>();
        errors.add(
                String.format(
                        "Error! Field %s must be an integer.", integerConstraint3.getFieldName()));
        assertEquals(integerConstraint3.getErrors(), errors);

        ArrayList<String> list = new ArrayList<String>();
        list.add("A");
        IntegerConstraint integerConstraint4 = new IntegerConstraint();
        integerConstraint4.setFieldName("fieldName");
        assertEquals(integerConstraint4.getFieldName(), "fieldName");
        integerConstraint4.setValue(list);
        assertEquals(integerConstraint4.getValue(), new Integer("0"));
        assertEquals(integerConstraint4.validate(), false);
        assertEquals(integerConstraint4.hasErrors(), true);
        assertEquals(integerConstraint4.getErrors(), errors);

        IntegerConstraint integerConstraint5 = new IntegerConstraint();
        integerConstraint5.setFieldName("fieldName");
        assertEquals(integerConstraint5.getFieldName(), "fieldName");
        integerConstraint5.setValue(0);
        assertEquals(integerConstraint5.getValue(), new Integer("0"));
        assertEquals(integerConstraint5.validate(), true);
        assertEquals(integerConstraint5.hasErrors(), false);
        assertEquals(integerConstraint5.getErrors(), new ArrayList<String>());

        IntegerConstraint integerConstraint6 = new IntegerConstraint();
        integerConstraint6.setFieldName("fieldName");
        assertEquals(integerConstraint6.getFieldName(), "fieldName");
        integerConstraint6.setValue(100);
        assertEquals(integerConstraint6.getValue(), new Integer("100"));
        assertEquals(integerConstraint6.validate(), true);
        assertEquals(integerConstraint6.hasErrors(), false);
        assertEquals(integerConstraint6.getErrors(), new ArrayList<String>());

        IntegerConstraint integerConstraint7 = new IntegerConstraint();
        integerConstraint7.setFieldName("fieldName");
        assertEquals(integerConstraint7.getFieldName(), "fieldName");
        integerConstraint7.setValue("10");
        assertEquals(integerConstraint7.getValue(), new Integer("0"));
        assertEquals(integerConstraint7.validate(), false);
        assertEquals(integerConstraint7.hasErrors(), true);
        assertEquals(integerConstraint7.getErrors(), errors);
    }
}
