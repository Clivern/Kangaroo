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

import com.clivern.kangaroo.util.Validate;

/** IntegerConstraint Class */
public class IntegerConstraint implements ConstraintInterface<Object, Integer> {

    public Object value;

    /** {@inheritDoc} */
    public void setValue(Object value) {
        this.value = value;
    }

    /** {@inheritDoc} */
    public Integer getValue() {
        return Validate.isInteger(this.value) ? (Integer) this.value : 0;
    }

    /** {@inheritDoc} */
    public Boolean isValidType() {
        return Validate.isInteger(this.value);
    }
}
