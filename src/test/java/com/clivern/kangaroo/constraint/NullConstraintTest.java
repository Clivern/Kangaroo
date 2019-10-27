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

import com.clivern.kangaroo.constraint.NullConstraint;
import java.util.ArrayList;
import org.junit.Test;

/** NullConstraintTest Class */
public class NullConstraintTest {

    @Test
    public void testNullValidation() {
        NullConstraint nullConstraint1 = new NullConstraint();
        nullConstraint1.setFieldName("fieldName");
        assertEquals(nullConstraint1.getFieldName(), "fieldName");
        nullConstraint1.setValue(null);
        assertEquals(nullConstraint1.getValue(), null);
        assertEquals(nullConstraint1.validate(), true);
        assertEquals(nullConstraint1.hasErrors(), false);
        assertEquals(nullConstraint1.getErrors(), new ArrayList<String>());

        NullConstraint nullConstraint2 = new NullConstraint();
        nullConstraint2.setFieldName("fieldName");
        assertEquals(nullConstraint2.getFieldName(), "fieldName");
        ArrayList<String> errors = new ArrayList<String>();
        errors.add(String.format("Error! Field %s must be null.", nullConstraint2.getFieldName()));

        nullConstraint2.setValue("true");
        assertEquals(nullConstraint2.getValue(), false);
        assertEquals(nullConstraint2.validate(), false);
        assertEquals(nullConstraint2.hasErrors(), true);
        assertEquals(nullConstraint2.getErrors(), errors);

        NullConstraint nullConstraint3 = new NullConstraint();
        nullConstraint3.setFieldName("fieldName");
        assertEquals(nullConstraint3.getFieldName(), "fieldName");
        nullConstraint3.setValue("false");
        assertEquals(nullConstraint3.getValue(), false);
        assertEquals(nullConstraint3.validate(), false);
        assertEquals(nullConstraint3.hasErrors(), true);
        assertEquals(nullConstraint3.getErrors(), errors);

        NullConstraint nullConstraint4 = new NullConstraint();
        nullConstraint4.setFieldName("fieldName");
        assertEquals(nullConstraint4.getFieldName(), "fieldName");
        nullConstraint4.setValue(false);
        assertEquals(nullConstraint4.getValue(), false);
        assertEquals(nullConstraint4.validate(), false);
        assertEquals(nullConstraint4.hasErrors(), true);
        assertEquals(nullConstraint4.getErrors(), errors);
    }
}
