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

/** Draft Class */
public enum Draft {
    DRAFT3("DRAFT3"),
    DRAFT4("DRAFT4"),
    DRAFT6("DRAFT6"),
    DRAFT7("DRAFT7");

    private final String name;

    /**
     * Class Constructor
     *
     * @param s the string value
     */
    private Draft(String s) {
        name = s;
    }

    /**
     * Compare to string
     *
     * @param otherName the string value to compare against
     * @return whether value equals the argument
     */
    public boolean equalsName(String otherName) {
        return name.equals(otherName);
    }

    /**
     * Change to string
     *
     * @return the string value
     */
    public String toString() {
        return this.name;
    }
}
