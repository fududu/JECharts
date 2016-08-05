/*
 * Copyright 2016 Aying.Org
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.aying.echarts;

import com.google.common.base.Charsets;
import com.google.common.io.CharStreams;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Fuchun
 * @since 1.0
 */
public abstract class JsonReader {

    public static List<String> readJsonList(String resource) {
        InputStream input = JsonReader.class.getResourceAsStream(resource);
        if (input == null) {
            throw new IllegalArgumentException("The resource " + resource + " not found.");
        }
        List<String> lines;
        try {
            lines = CharStreams.readLines(new InputStreamReader(input, Charsets.UTF_8));
        } catch (IOException ex) {
            throw new IllegalArgumentException(ex);
        }
        List<String> jsonList = new ArrayList<>();
        int i = 0;
        StringBuilder jsonBuilder = null;
        for (String line : lines) {
            if (jsonBuilder == null) {
                jsonBuilder = new StringBuilder(32);
            }
            if (line.startsWith("#---")) {
                if (jsonBuilder.length() > 0) {
                    jsonList.add(i++, jsonBuilder.toString());
                    jsonBuilder = new StringBuilder(32);
                }
            } else {
                jsonBuilder.append(line);
            }
        }
        if (jsonBuilder != null && jsonBuilder.length() > 0) {
            jsonList.add(jsonList.size(), jsonBuilder.toString());
        }
        return jsonList;
    }

    private JsonReader() {}
}
