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
package com.clivern.kangaroo.util;

import java.io.File;
import java.nio.file.*;
import java.util.ArrayList;

/** File Reader Class */
public class FileReader {

    /**
     * Read File as String
     *
     * @param filePath absolute path to file
     * @return String file content as string
     * @throws Exception throws exception if file not exists
     */
    public String readFileAsString(String filePath) throws Exception {
        return new String(Files.readAllBytes(Paths.get(filePath)));
    }

    /**
     * Get Files Abs Path from directory
     *
     * @param directory the dir path
     * @return A list of files abs path
     * @throws Exception throws exception if dir not readable
     */
    public ArrayList<String> getFilesInDir(String directory) throws Exception {
        File folder = new File(directory);
        File[] listOfFiles = folder.listFiles();
        ArrayList<String> files = new ArrayList<String>();

        for (File file : listOfFiles) {
            if (file.isFile()) {
                files.add(file.getAbsolutePath());
            }
        }

        return files;
    }
}
