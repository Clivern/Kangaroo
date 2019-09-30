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

import org.junit.Test;

/** DraftTest Class */
public class DraftTest {

    @Test
    public void testDraftEnum() {
        assertEquals(Draft.DRAFT3.name(), "DRAFT3");
        assertTrue(Draft.DRAFT3.equalsName("DRAFT3"));

        assertEquals(Draft.DRAFT4.name(), "DRAFT4");
        assertTrue(Draft.DRAFT4.equalsName("DRAFT4"));

        assertEquals(Draft.DRAFT6.name(), "DRAFT6");
        assertTrue(Draft.DRAFT6.equalsName("DRAFT6"));

        assertEquals(Draft.DRAFT7.name(), "DRAFT7");
        assertTrue(Draft.DRAFT7.equalsName("DRAFT7"));
    }
}
