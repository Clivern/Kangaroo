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

import com.clivern.kangaroo.constraint.StringConstraint;
import java.util.ArrayList;
import org.junit.Test;

/** String Constraint Test Cases */
public class StringConstraintTest {

    @Test
    public void test_a_valid_string() {
        TestUtils.print("Test a Valid String");
        StringConstraint stringConstraint = new StringConstraint();
        stringConstraint.setFieldName("fieldName");
        stringConstraint.setValue("Hello");
        assertEquals(stringConstraint.getFieldName(), "fieldName");
        assertEquals(stringConstraint.getValue(), "Hello");
        assertEquals(stringConstraint.validate(), true);
        assertEquals(stringConstraint.hasErrors(), false);
        assertEquals(stringConstraint.getErrors(), new ArrayList<String>());
    }

    @Test
    public void test_a_valid_empty_string() {
        TestUtils.print("Test a Valid Empty String");
        StringConstraint stringConstraint = new StringConstraint();
        stringConstraint.setFieldName("fieldName");
        stringConstraint.setValue("");
        assertEquals(stringConstraint.getFieldName(), "fieldName");
        assertEquals(stringConstraint.getValue(), "");
        assertEquals(stringConstraint.validate(), true);
        assertEquals(stringConstraint.hasErrors(), false);
        assertEquals(stringConstraint.getErrors(), new ArrayList<String>());
    }

    @Test
    public void test_invalid_null_string_type() {
        TestUtils.print("Test a Null String");
        ArrayList<String> errors = new ArrayList<String>();
        StringConstraint stringConstraint = new StringConstraint();
        stringConstraint.setFieldName("fieldName");
        stringConstraint.setValue(null);
        assertEquals(stringConstraint.getFieldName(), "fieldName");
        assertEquals(stringConstraint.getValue(), "");
        assertEquals(stringConstraint.validate(), false);
        assertEquals(stringConstraint.hasErrors(), true);
        errors.add(
                String.format(
                        "Error! Field %s must be a string.", stringConstraint.getFieldName()));
        assertEquals(stringConstraint.getErrors(), errors);
    }

    @Test
    public void test_invalid_list_string_type() {
        TestUtils.print("Test a List String");
        ArrayList<String> errors = new ArrayList<String>();
        StringConstraint stringConstraint = new StringConstraint();
        ArrayList<String> list = new ArrayList<String>();
        list.add("A");
        list.add("B");
        list.add("C");
        stringConstraint.setFieldName("fieldName");
        stringConstraint.setValue(list);
        assertEquals(stringConstraint.getFieldName(), "fieldName");
        assertEquals(stringConstraint.getValue(), "");
        assertEquals(stringConstraint.validate(), false);
        assertEquals(stringConstraint.hasErrors(), true);
        errors.add(
                String.format(
                        "Error! Field %s must be a string.", stringConstraint.getFieldName()));
        assertEquals(stringConstraint.getErrors(), errors);
    }

    @Test
    public void test_a_valid_string_with_min_length_set1() {
        TestUtils.print("Test a Valid String With minLength Set");
        StringConstraint stringConstraint = new StringConstraint();
        stringConstraint.setFieldName("fieldName");
        stringConstraint.setValue("Hello");
        stringConstraint.setMinLength(new Integer(5));
        assertEquals(stringConstraint.getFieldName(), "fieldName");
        assertEquals(stringConstraint.getValue(), "Hello");
        assertEquals(stringConstraint.getMinLength(), new Integer(5));
        assertEquals(stringConstraint.validate(), true);
        assertEquals(stringConstraint.hasErrors(), false);
        assertEquals(stringConstraint.getErrors(), new ArrayList<String>());
    }

    @Test
    public void test_a_valid_string_with_min_length_set2() {
        TestUtils.print("Test a Valid String With minLength Set");
        StringConstraint stringConstraint = new StringConstraint();
        stringConstraint.setFieldName("fieldName");
        stringConstraint.setValue("Hello");
        stringConstraint.setMinLength(new Integer(4));
        assertEquals(stringConstraint.getFieldName(), "fieldName");
        assertEquals(stringConstraint.getValue(), "Hello");
        assertEquals(stringConstraint.getMinLength(), new Integer(4));
        assertEquals(stringConstraint.validate(), true);
        assertEquals(stringConstraint.hasErrors(), false);
        assertEquals(stringConstraint.getErrors(), new ArrayList<String>());
    }

    @Test
    public void test_invalid_string_with_min_length_set() {
        TestUtils.print("Test Invalid String With minLength Set");
        ArrayList<String> errors = new ArrayList<String>();
        StringConstraint stringConstraint = new StringConstraint();
        stringConstraint.setFieldName("fieldName");
        stringConstraint.setValue("Hello");
        stringConstraint.setMinLength(new Integer(6));
        assertEquals(stringConstraint.getFieldName(), "fieldName");
        assertEquals(stringConstraint.getValue(), "Hello");
        assertEquals(stringConstraint.getMinLength(), new Integer(6));
        assertEquals(stringConstraint.validate(), false);
        assertEquals(stringConstraint.hasErrors(), true);
        errors.add(
                String.format(
                        "Error! Field %s length must be more than or equal %d.",
                        stringConstraint.getFieldName(), stringConstraint.getMinLength()));
        assertEquals(stringConstraint.getErrors(), errors);
    }

    @Test
    public void test_a_valid_string_with_max_length_set1() {
        TestUtils.print("Test a Valid String With maxLength Set");
        StringConstraint stringConstraint = new StringConstraint();
        stringConstraint.setFieldName("fieldName");
        stringConstraint.setValue("Hello");
        stringConstraint.setMaxLength(new Integer(5));
        assertEquals(stringConstraint.getFieldName(), "fieldName");
        assertEquals(stringConstraint.getValue(), "Hello");
        assertEquals(stringConstraint.getMaxLength(), new Integer(5));
        assertEquals(stringConstraint.validate(), true);
        assertEquals(stringConstraint.hasErrors(), false);
        assertEquals(stringConstraint.getErrors(), new ArrayList<String>());
    }

    @Test
    public void test_a_valid_string_with_max_length_set2() {
        TestUtils.print("Test a Valid String With maxLength Set");
        StringConstraint stringConstraint = new StringConstraint();
        stringConstraint.setFieldName("fieldName");
        stringConstraint.setValue("Hello");
        stringConstraint.setMaxLength(new Integer(6));
        assertEquals(stringConstraint.getFieldName(), "fieldName");
        assertEquals(stringConstraint.getValue(), "Hello");
        assertEquals(stringConstraint.getMaxLength(), new Integer(6));
        assertEquals(stringConstraint.validate(), true);
        assertEquals(stringConstraint.hasErrors(), false);
        assertEquals(stringConstraint.getErrors(), new ArrayList<String>());
    }

    @Test
    public void test_invalid_string_with_max_length_set() {
        TestUtils.print("Test a Valid String With maxLength Set");
        ArrayList<String> errors = new ArrayList<String>();
        StringConstraint stringConstraint = new StringConstraint();
        stringConstraint.setFieldName("fieldName");
        stringConstraint.setValue("Hello");
        stringConstraint.setMaxLength(new Integer(4));
        assertEquals(stringConstraint.getFieldName(), "fieldName");
        assertEquals(stringConstraint.getValue(), "Hello");
        assertEquals(stringConstraint.getMaxLength(), new Integer(4));
        assertEquals(stringConstraint.validate(), false);
        assertEquals(stringConstraint.hasErrors(), true);
        errors.add(
                String.format(
                        "Error! Field %s length must be less than or equal %d.",
                        stringConstraint.getFieldName(), stringConstraint.getMaxLength()));
        assertEquals(stringConstraint.getErrors(), errors);
    }
}
