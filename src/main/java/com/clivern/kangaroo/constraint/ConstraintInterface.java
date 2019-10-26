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

import java.util.ArrayList;

/** Constraint Interface */
public interface ConstraintInterface<T, V> {

    /**
     * Set Value
     *
     * @param value the value
     */
    public void setValue(T value);

    /**
     * Set Field Name
     *
     * @param fieldName the field name
     */
    public void setFieldName(String fieldName);

    /**
     * Get Value
     *
     * @return the value
     */
    public V getValue();

    /**
     * Get Field Name
     *
     * @return the field name
     */
    public String getFieldName();

    /**
     * Is Valid
     *
     * @return If value is valid
     */
    public Boolean isValidType();

    /**
     * Validate field value
     *
     * @return whether field value is valid or not
     */
    public Boolean validate();

    /**
     * Get Errors List
     *
     * @return the errors list
     */
    public ArrayList<String> getErrors();

    /**
     * If validation has errors
     *
     * @return whether there is errors
     */
    public Boolean hasErrors();
}
