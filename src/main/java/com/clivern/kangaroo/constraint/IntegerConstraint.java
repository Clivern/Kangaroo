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

package com.clivern.kangaroo.constraint;

/** IntegerConstraint Class */
public class IntegerConstraint implements ConstraintInterface<Object, Integer> {

    public Object value;

    /** {@inheritDoc} */
    public void setValue(Object value) {
        this.value = value;
    }

    /** {@inheritDoc} */
    public Integer getValue() {
        try {
            return ((this.value == null) || !(this.value instanceof Integer))
                    ? 0
                    : (Integer) this.value;
        } catch (Exception e) {
            return 0;
        }
    }

    /** {@inheritDoc} */
    public Boolean isValid() {
        try {
            return ((this.value == null) || !(this.value instanceof Integer)) ? false : true;
        } catch (Exception e) {
            return false;
        }
    }

    /** {@inheritDoc} */
    public Boolean isEmpty() {
        try {
            return ((this.value == null) || !(this.value instanceof Integer))
                    ? (int) this.value == 0
                    : false;
        } catch (Exception e) {
            return true;
        }
    }
}
