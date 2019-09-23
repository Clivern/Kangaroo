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
package com.clivern.kangaroo.util;

import static org.junit.Assert.*;

import org.junit.Test;

public class FileReaderTest {

    @Test
    public void testReadFileAsString() throws Exception {
        FileReader fileReader = new FileReader();
        assertEquals(
                "{\"id\": \"Hello\"}",
                fileReader.readFileAsString("src/test/resources/scheme.json"));
    }

    @Test(expected = Exception.class)
    public void whenExceptionThrown_ReadFileAsString() throws Exception {
        FileReader fileReader = new FileReader();
        fileReader.readFileAsString("src/test/resources/non_existent_file.json");
    }
}
