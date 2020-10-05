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

import com.clivern.kangaroo.util.*;
import java.util.ArrayList;
import org.junit.Test;

/** Validator Test Cases */
public class ValidatorTest {

    @Test
    public void testValidator() throws Exception {
        FileReader fileReader = new FileReader();

        ArrayList<String> cases = new ArrayList<String>();
        cases.add("src/test/resources/test_case01.txt");
        cases.add("src/test/resources/test_case02.txt");
        cases.add("src/test/resources/test_case03.txt");

        for (int i = 0; i < cases.size(); i++) {
            String[] parts =
                    fileReader.readFileAsString(cases.get(i)).split("---------------------");

            SchemaFactory schemaFactory = new SchemaFactory();
            Validator validator = new Validator();
            SchemaDraft7 schemaDraft7 = new SchemaDraft7();

            if (parts[0].contains("draft7")) {
                schemaDraft7 = schemaFactory.unserialize(parts[1], SchemaDraft7.class);

                Boolean result = validator.validate(schemaDraft7, parts[2]);

                if (validator.getErrors().size() > 0) {
                    assertEquals(result, false);
                } else {
                    assertEquals(result, true);
                }

                System.out.printf(
                        "Actual Errors for %s: %s \n", cases.get(i), validator.getErrors());

                for (int k = 0; k < validator.getErrors().size(); k++) {
                    assertEquals(parts[3].contains(validator.getErrors().get(k)), true);
                }
            }
        }
    }
}
