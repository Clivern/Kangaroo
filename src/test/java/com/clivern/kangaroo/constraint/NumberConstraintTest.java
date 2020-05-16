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

import com.clivern.kangaroo.constraint.NumberConstraint;
import java.util.ArrayList;
import org.junit.Test;

/** Number Constraint Test Cases */
public class NumberConstraintTest {

    @Test
    public void test_a_valid_float_number() {
        TestUtils.print("Test a Valid Float Number");
        NumberConstraint numberConstraint = new NumberConstraint();
        numberConstraint.setValue(new Float("1.2"));
        numberConstraint.setFieldName("fieldName");
        assertEquals(numberConstraint.getFieldName(), "fieldName");
        assertEquals(numberConstraint.getValue(), "1.2");
        assertEquals(numberConstraint.validate(), true);
        assertEquals(numberConstraint.hasErrors(), false);
        assertEquals(numberConstraint.getNumberType(), NumberConstraint.FLOAT);
        assertEquals(numberConstraint.getErrors(), new ArrayList<String>());
    }

    @Test
    public void test_a_valid_number_with_exclusive_minimum_set() {
        TestUtils.print("Test a Valid Number With Exclusive Minimum Set");
        NumberConstraint numberConstraint2 = new NumberConstraint();
        numberConstraint2.setValue(new Integer("11"));
        numberConstraint2.setFieldName("fieldName");
        numberConstraint2.setExclusiveMinimum("10.2");
        assertEquals(numberConstraint2.getExclusiveMinimum(), "10.2");
        assertEquals(numberConstraint2.getFieldName(), "fieldName");
        assertEquals(numberConstraint2.getValue(), "11");
        assertEquals(numberConstraint2.validate(), true);
        assertEquals(numberConstraint2.hasErrors(), false);
        assertEquals(numberConstraint2.getNumberType(), NumberConstraint.INTEGER);
        assertEquals(numberConstraint2.getErrors(), new ArrayList<String>());
    }

    @Test
    public void test_invalid_number_with_exclusive_minimum_set() {
        TestUtils.print("Test Invalid Number With Exclusive Minimum Set");
        ArrayList<String> errors1 = new ArrayList<String>();
        NumberConstraint numberConstraint1 = new NumberConstraint();
        numberConstraint1.setValue(new Float("10.2"));
        numberConstraint1.setFieldName("fieldName");
        numberConstraint1.setExclusiveMinimum("10.2");
        assertEquals(numberConstraint1.getExclusiveMinimum(), "10.2");
        assertEquals(numberConstraint1.getFieldName(), "fieldName");
        assertEquals(numberConstraint1.getValue(), "10.2");
        assertEquals(numberConstraint1.validate(), false);
        assertEquals(numberConstraint1.hasErrors(), true);
        errors1.add(
                String.format(
                        "Error! Field %s must be greater than %s.",
                        numberConstraint1.getFieldName(), numberConstraint1.getExclusiveMinimum()));
        assertEquals(numberConstraint1.getNumberType(), NumberConstraint.FLOAT);
        assertEquals(numberConstraint1.getErrors(), errors1);

        ArrayList<String> errors2 = new ArrayList<String>();
        NumberConstraint numberConstraint2 = new NumberConstraint();
        numberConstraint2.setValue(new Integer("9"));
        numberConstraint2.setFieldName("fieldName");
        numberConstraint2.setExclusiveMinimum("10");
        assertEquals(numberConstraint2.getExclusiveMinimum(), "10");
        assertEquals(numberConstraint2.getFieldName(), "fieldName");
        assertEquals(numberConstraint2.getValue(), "9");
        assertEquals(numberConstraint2.validate(), false);
        assertEquals(numberConstraint2.hasErrors(), true);
        errors2.add(
                String.format(
                        "Error! Field %s must be greater than %s.",
                        numberConstraint2.getFieldName(), numberConstraint2.getExclusiveMinimum()));
        assertEquals(numberConstraint2.getNumberType(), NumberConstraint.INTEGER);
        assertEquals(numberConstraint2.getErrors(), errors2);
    }

    @Test
    public void test_a_valid_number_with_exclusive_maximum_set() {
        TestUtils.print("Test a Valid Number With Exclusive Maximum Set");
        NumberConstraint numberConstraint2 = new NumberConstraint();
        numberConstraint2.setValue(new Integer("9"));
        numberConstraint2.setFieldName("fieldName");
        numberConstraint2.setExclusiveMaximum("10.2");
        assertEquals(numberConstraint2.getExclusiveMaximum(), "10.2");
        assertEquals(numberConstraint2.getFieldName(), "fieldName");
        assertEquals(numberConstraint2.getValue(), "9");
        assertEquals(numberConstraint2.validate(), true);
        assertEquals(numberConstraint2.hasErrors(), false);
        assertEquals(numberConstraint2.getNumberType(), NumberConstraint.INTEGER);
        assertEquals(numberConstraint2.getErrors(), new ArrayList<String>());
    }

    @Test
    public void test_invalid_number_with_exclusive_maximum_set() {
        TestUtils.print("Test Invalid Number With Exclusive Maximum Set");
        ArrayList<String> errors1 = new ArrayList<String>();
        NumberConstraint numberConstraint1 = new NumberConstraint();
        numberConstraint1.setValue(new Float("10.2"));
        numberConstraint1.setFieldName("fieldName");
        numberConstraint1.setExclusiveMaximum("10.2");
        assertEquals(numberConstraint1.getExclusiveMaximum(), "10.2");
        assertEquals(numberConstraint1.getFieldName(), "fieldName");
        assertEquals(numberConstraint1.getValue(), "10.2");
        assertEquals(numberConstraint1.validate(), false);
        assertEquals(numberConstraint1.hasErrors(), true);
        errors1.add(
                String.format(
                        "Error! Field %s must be less than %s.",
                        numberConstraint1.getFieldName(), numberConstraint1.getExclusiveMaximum()));
        assertEquals(numberConstraint1.getNumberType(), NumberConstraint.FLOAT);
        assertEquals(numberConstraint1.getErrors(), errors1);

        ArrayList<String> errors2 = new ArrayList<String>();
        NumberConstraint numberConstraint2 = new NumberConstraint();
        numberConstraint2.setValue(new Integer("11"));
        numberConstraint2.setFieldName("fieldName");
        numberConstraint2.setExclusiveMaximum("10");
        assertEquals(numberConstraint2.getExclusiveMaximum(), "10");
        assertEquals(numberConstraint2.getFieldName(), "fieldName");
        assertEquals(numberConstraint2.getValue(), "11");
        assertEquals(numberConstraint2.validate(), false);
        assertEquals(numberConstraint2.hasErrors(), true);
        errors2.add(
                String.format(
                        "Error! Field %s must be less than %s.",
                        numberConstraint2.getFieldName(), numberConstraint2.getExclusiveMaximum()));
        assertEquals(numberConstraint2.getNumberType(), NumberConstraint.INTEGER);
        assertEquals(numberConstraint2.getErrors(), errors2);
    }

    @Test
    public void test_a_valid_number_with_maximum_set() {
        TestUtils.print("Test a Valid Number With Maximum Set");
        NumberConstraint numberConstraint1 = new NumberConstraint();
        numberConstraint1.setValue(new Float("10.2"));
        numberConstraint1.setFieldName("fieldName");
        numberConstraint1.setMaximum("10.2");
        assertEquals(numberConstraint1.getMaximum(), "10.2");
        assertEquals(numberConstraint1.getFieldName(), "fieldName");
        assertEquals(numberConstraint1.getValue(), "10.2");
        assertEquals(numberConstraint1.validate(), true);
        assertEquals(numberConstraint1.hasErrors(), false);
        assertEquals(numberConstraint1.getNumberType(), NumberConstraint.FLOAT);
        assertEquals(numberConstraint1.getErrors(), new ArrayList<String>());

        NumberConstraint numberConstraint2 = new NumberConstraint();
        numberConstraint2.setValue(new Integer("9"));
        numberConstraint2.setFieldName("fieldName");
        numberConstraint2.setMaximum("10.2");
        assertEquals(numberConstraint2.getMaximum(), "10.2");
        assertEquals(numberConstraint2.getFieldName(), "fieldName");
        assertEquals(numberConstraint2.getValue(), "9");
        assertEquals(numberConstraint2.validate(), true);
        assertEquals(numberConstraint2.hasErrors(), false);
        assertEquals(numberConstraint2.getNumberType(), NumberConstraint.INTEGER);
        assertEquals(numberConstraint2.getErrors(), new ArrayList<String>());
    }

    @Test
    public void test_invalid_number_with_maximum_set() {
        TestUtils.print("Test Invalid Number With Maximum Set");
        ArrayList<String> errors = new ArrayList<String>();
        NumberConstraint numberConstraint = new NumberConstraint();
        numberConstraint.setValue(new Integer("11"));
        numberConstraint.setFieldName("fieldName");
        numberConstraint.setMaximum("10");
        assertEquals(numberConstraint.getMaximum(), "10");
        assertEquals(numberConstraint.getFieldName(), "fieldName");
        assertEquals(numberConstraint.getValue(), "11");
        assertEquals(numberConstraint.validate(), false);
        assertEquals(numberConstraint.hasErrors(), true);
        errors.add(
                String.format(
                        "Error! Field %s must be less than or equal %s.",
                        numberConstraint.getFieldName(), numberConstraint.getMaximum()));
        assertEquals(numberConstraint.getNumberType(), NumberConstraint.INTEGER);
        assertEquals(numberConstraint.getErrors(), errors);
    }

    @Test
    public void test_a_valid_number_with_minimum_set() {
        TestUtils.print("Test a Valid Number With Minimum Set");
        NumberConstraint numberConstraint1 = new NumberConstraint();
        numberConstraint1.setValue(new Float("10.2"));
        numberConstraint1.setFieldName("fieldName");
        numberConstraint1.setMinimum("10.2");
        assertEquals(numberConstraint1.getMinimum(), "10.2");
        assertEquals(numberConstraint1.getFieldName(), "fieldName");
        assertEquals(numberConstraint1.getValue(), "10.2");
        assertEquals(numberConstraint1.validate(), true);
        assertEquals(numberConstraint1.hasErrors(), false);
        assertEquals(numberConstraint1.getNumberType(), NumberConstraint.FLOAT);
        assertEquals(numberConstraint1.getErrors(), new ArrayList<String>());

        NumberConstraint numberConstraint2 = new NumberConstraint();
        numberConstraint2.setValue(new Integer("11"));
        numberConstraint2.setFieldName("fieldName");
        numberConstraint2.setMinimum("10.2");
        assertEquals(numberConstraint2.getMinimum(), "10.2");
        assertEquals(numberConstraint2.getFieldName(), "fieldName");
        assertEquals(numberConstraint2.getValue(), "11");
        assertEquals(numberConstraint2.validate(), true);
        assertEquals(numberConstraint2.hasErrors(), false);
        assertEquals(numberConstraint2.getNumberType(), NumberConstraint.INTEGER);
        assertEquals(numberConstraint2.getErrors(), new ArrayList<String>());
    }

    @Test
    public void test_invalid_number_with_minimum_set() {
        TestUtils.print("Test Invalid Number With Minimum Set");
        ArrayList<String> errors = new ArrayList<String>();
        NumberConstraint numberConstraint = new NumberConstraint();
        numberConstraint.setValue(new Integer("9"));
        numberConstraint.setFieldName("fieldName");
        numberConstraint.setMinimum("10");
        assertEquals(numberConstraint.getMinimum(), "10");
        assertEquals(numberConstraint.getFieldName(), "fieldName");
        assertEquals(numberConstraint.getValue(), "9");
        assertEquals(numberConstraint.validate(), false);
        assertEquals(numberConstraint.hasErrors(), true);
        errors.add(
                String.format(
                        "Error! Field %s must be greater than or equal %s.",
                        numberConstraint.getFieldName(), numberConstraint.getMinimum()));
        assertEquals(numberConstraint.getNumberType(), NumberConstraint.INTEGER);
        assertEquals(numberConstraint.getErrors(), errors);
    }

    @Test
    public void test_a_valid_number_with_multipleof_set() {
        TestUtils.print("Test a Valid Number With MultipleOf Set");
        NumberConstraint numberConstraint = new NumberConstraint();
        numberConstraint.setValue(new Integer("10"));
        numberConstraint.setFieldName("fieldName");
        numberConstraint.setMultipleOf("10");
        assertEquals(numberConstraint.getMultipleOf(), "10");
        assertEquals(numberConstraint.getFieldName(), "fieldName");
        assertEquals(numberConstraint.getValue(), "10");
        assertEquals(numberConstraint.validate(), true);
        assertEquals(numberConstraint.hasErrors(), false);
        assertEquals(numberConstraint.getNumberType(), NumberConstraint.INTEGER);
        assertEquals(numberConstraint.getErrors(), new ArrayList<String>());
    }

    @Test
    public void test_invalid_number_with_multipleof_set() {
        TestUtils.print("Test Invalid Number With MultipleOf Set");
        ArrayList<String> errors = new ArrayList<String>();
        NumberConstraint numberConstraint = new NumberConstraint();
        numberConstraint.setValue(new Integer("11"));
        numberConstraint.setFieldName("fieldName");
        numberConstraint.setMultipleOf("10");
        assertEquals(numberConstraint.getMultipleOf(), "10");
        assertEquals(numberConstraint.getFieldName(), "fieldName");
        assertEquals(numberConstraint.getValue(), "11");
        assertEquals(numberConstraint.validate(), false);
        assertEquals(numberConstraint.hasErrors(), true);
        errors.add(
                String.format(
                        "Error! Field %s must be multiple of %s.",
                        numberConstraint.getFieldName(), numberConstraint.getMultipleOf()));
        assertEquals(numberConstraint.getNumberType(), NumberConstraint.INTEGER);
        assertEquals(numberConstraint.getErrors(), errors);
    }

    @Test
    public void test_a_valid_integer_number() {
        TestUtils.print("Test a Valid Integer Number");
        NumberConstraint numberConstraint = new NumberConstraint();
        numberConstraint.setValue(new Integer("1"));
        numberConstraint.setFieldName("fieldName");
        assertEquals(numberConstraint.getFieldName(), "fieldName");
        assertEquals(numberConstraint.getValue(), "1");
        assertEquals(numberConstraint.validate(), true);
        assertEquals(numberConstraint.hasErrors(), false);
        assertEquals(numberConstraint.getNumberType(), NumberConstraint.INTEGER);
        assertEquals(numberConstraint.getErrors(), new ArrayList<String>());
    }

    @Test
    public void test_invalid_number() {
        TestUtils.print("Test Invalid Number");
        ArrayList<String> errors = new ArrayList<String>();
        NumberConstraint numberConstraint = new NumberConstraint();
        numberConstraint.setValue("H");
        numberConstraint.setFieldName("fieldName");
        assertEquals(numberConstraint.getFieldName(), "fieldName");
        assertEquals(numberConstraint.getValue(), "0");
        assertEquals(numberConstraint.validate(), false);
        assertEquals(numberConstraint.hasErrors(), true);
        errors.add(
                String.format(
                        "Error! Field %s must be a number.", numberConstraint.getFieldName()));
        assertEquals(numberConstraint.getNumberType(), NumberConstraint.IN_VALID);
        assertEquals(numberConstraint.getErrors(), errors);
    }

    @Test
    public void test_a_valid_integer_number_with_all_conditions() {
        TestUtils.print("Test a Valid Integer Number With All Conditions");
        NumberConstraint numberConstraint = new NumberConstraint();
        numberConstraint.setValue(new Integer("10"));
        numberConstraint.setFieldName("fieldName");
        numberConstraint.setMultipleOf("10");
        numberConstraint.setMinimum("10");
        numberConstraint.setMaximum("11");
        numberConstraint.setExclusiveMinimum("9");
        numberConstraint.setExclusiveMaximum("11");
        assertEquals(numberConstraint.getFieldName(), "fieldName");
        assertEquals(numberConstraint.getMultipleOf(), "10");
        assertEquals(numberConstraint.getMinimum(), "10");
        assertEquals(numberConstraint.getMaximum(), "11");
        assertEquals(numberConstraint.getExclusiveMinimum(), "9");
        assertEquals(numberConstraint.getExclusiveMaximum(), "11");
        assertEquals(numberConstraint.getValue(), "10");
        assertEquals(numberConstraint.validate(), true);
        assertEquals(numberConstraint.hasErrors(), false);
        assertEquals(numberConstraint.getNumberType(), NumberConstraint.INTEGER);
        assertEquals(numberConstraint.getErrors(), new ArrayList<String>());
    }

    @Test
    public void test_invalid_integer_number_with_all_conditions() {
        TestUtils.print("Test Invalid Integer Number With All Conditions");
        ArrayList<String> errors = new ArrayList<String>();
        NumberConstraint numberConstraint = new NumberConstraint();
        numberConstraint.setValue(new Integer("19"));
        numberConstraint.setFieldName("fieldName");
        numberConstraint.setMultipleOf("10");
        numberConstraint.setMinimum("10");
        numberConstraint.setMaximum("11");
        numberConstraint.setExclusiveMinimum("9");
        numberConstraint.setExclusiveMaximum("11");
        assertEquals(numberConstraint.getFieldName(), "fieldName");
        assertEquals(numberConstraint.getMultipleOf(), "10");
        assertEquals(numberConstraint.getMinimum(), "10");
        assertEquals(numberConstraint.getMaximum(), "11");
        assertEquals(numberConstraint.getExclusiveMinimum(), "9");
        assertEquals(numberConstraint.getExclusiveMaximum(), "11");
        assertEquals(numberConstraint.getValue(), "19");
        assertEquals(numberConstraint.validate(), false);
        assertEquals(numberConstraint.hasErrors(), true);
        errors.add(
                String.format(
                        "Error! Field %s must be multiple of %s.",
                        numberConstraint.getFieldName(), numberConstraint.getMultipleOf()));
        errors.add(
                String.format(
                        "Error! Field %s must be less than or equal %s.",
                        numberConstraint.getFieldName(), numberConstraint.getMaximum()));
        errors.add(
                String.format(
                        "Error! Field %s must be less than %s.",
                        numberConstraint.getFieldName(), numberConstraint.getExclusiveMaximum()));
        assertEquals(numberConstraint.getNumberType(), NumberConstraint.INTEGER);
        assertEquals(numberConstraint.getErrors(), errors);
    }
}
