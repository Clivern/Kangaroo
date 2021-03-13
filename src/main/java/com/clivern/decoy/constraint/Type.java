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
package com.clivern.decoy.constraint;

import com.google.gson.internal.LinkedTreeMap;
import java.util.ArrayList;

/** Type Class */
public class Type {

    private ArrayList<String> types = new ArrayList<String>();
    private ArrayList<String> enumValues = new ArrayList<String>();

    /**
     * Class Constructor
     *
     * @param type the schema type object
     */
    public Type(Object type) {
        if (type.getClass() == String.class) {
            this.types.add((String) type);
            return;
        }

        if (type.getClass() == ArrayList.class) {
            this.types.addAll((ArrayList<String>) type);
            return;
        }

        if (type.getClass() == LinkedTreeMap.class) {
            LinkedTreeMap<String, ArrayList<String>> newType =
                    (LinkedTreeMap<String, ArrayList<String>>) type;

            if (newType.containsKey(ConstraintType.ENUM.name().toLowerCase())) {
                this.types.add(ConstraintType.ENUM.name().toLowerCase());
                this.enumValues.addAll(newType.get(ConstraintType.ENUM.name().toLowerCase()));
                return;
            }
        }
    }

    /**
     * Get Types
     *
     * @return The types list
     */
    public ArrayList<String> getTypes() {
        return this.types;
    }

    /**
     * Check if type on the types list
     *
     * @param type the type
     * @return Whether type on the types list
     */
    public Boolean inTypes(String type) {
        return this.types.contains(type);
    }

    /**
     * Get Enum Values
     *
     * @return the list of values allowed
     */
    public ArrayList<String> getEnumValues() {
        return this.enumValues;
    }
}
