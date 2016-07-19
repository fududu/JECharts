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

package org.aying.echarts.feature;

import java.util.Map;

/**
 * @author Fuchun
 * @since 1.0
 */
public class MapMTemplate extends MTemplate<Map<String, Object>> {

    private static final long serialVersionUID = 7969221465862324826L;

    public MapMTemplate() {
        super();
    }

    public MapMTemplate(
            Map<String, Object> line, Map<String, Object> bar,
            Map<String, Object> stack, Map<String, Object> tiled) {
        super(line, bar, stack, tiled);
    }
}
