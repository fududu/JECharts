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

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author Fuchun
 * @since 1.0
 */
public class StringMTemplate extends MTemplate<String> {

    private static final long serialVersionUID = -8430668980140405582L;

    public StringMTemplate() {
        super();
    }

    @JsonCreator
    public StringMTemplate(
            @JsonProperty(value = KEY_LINE, required = false) String line,
            @JsonProperty(value = KEY_BAR, required = false) String bar,
            @JsonProperty(value = KEY_STACK, required = false) String stack,
            @JsonProperty(value = KEY_TILED, required = false) String tiled) {
        super(line, bar, stack, tiled);
    }
}
