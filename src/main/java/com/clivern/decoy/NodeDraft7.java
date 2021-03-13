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

import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import java.util.HashMap;

/** Node Draft7 Class */
public class NodeDraft7 {

    private class ContainsType {
        @SerializedName("type")
        public String type;
    }

    @SerializedName("description")
    public String description;

    @SerializedName("type")
    public Object type;

    @SerializedName("enum")
    public ArrayList<String> enumerated = new ArrayList<String>();

    @SerializedName("required")
    public ArrayList<String> required = new ArrayList<String>();

    // String Specific Properties
    @SerializedName("minLength")
    public Integer minLength;

    @SerializedName("maxLength")
    public Integer maxLength;

    @SerializedName("pattern")
    public String pattern;

    @SerializedName("format")
    public String format;

    // Number Specific Properties
    @SerializedName("multipleOf")
    public String multipleOf;

    @SerializedName("minimum")
    public String minimum;

    @SerializedName("maximum")
    public String maximum;

    @SerializedName("exclusiveMinimum")
    public String exclusiveMinimum;

    @SerializedName("exclusiveMaximum")
    public String exclusiveMaximum;

    @SerializedName("uniqueItems")
    public Boolean uniqueItems;

    @SerializedName("minItems")
    public Integer minItems;

    @SerializedName("maxItems")
    public Integer maxItems;

    @SerializedName("contains")
    public ContainsType contains;

    // When type is object
    @SerializedName("properties")
    public HashMap<String, NodeDraft7> properties = new HashMap<String, NodeDraft7>();
}
