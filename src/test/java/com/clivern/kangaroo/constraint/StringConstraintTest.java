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

import com.clivern.kangaroo.constraint.StringConstraint;
import java.util.ArrayList;
import org.junit.Test;

/** StringConstraintTest Class */
public class StringConstraintTest {

    @Test
    public void testStringValidation() {
        StringConstraint stringConstraint = new StringConstraint();

        stringConstraint.setValue("Hello");
        assertEquals(stringConstraint.getValue(), "Hello");
        assertEquals(stringConstraint.isValidType(), true);

        stringConstraint.setValue("");
        assertEquals(stringConstraint.getValue(), "");
        assertEquals(stringConstraint.isValidType(), true);

        stringConstraint.setValue(null);
        assertEquals(stringConstraint.getValue(), "");
        assertEquals(stringConstraint.isValidType(), false);

        ArrayList<String> list = new ArrayList<String>();
        list.add("A");
        list.add("B");
        list.add("C");
        stringConstraint.setValue(list);
        assertEquals(stringConstraint.getValue(), "");
        assertEquals(stringConstraint.isValidType(), false);
    }
}
