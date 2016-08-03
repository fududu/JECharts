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

package org.aying.echarts.style.font;

import org.jetbrains.annotations.Contract;

/**
 * ECharts style font enumeration.
 *
 * @author Fuchun
 * @since 1.0
 */
public enum FontStyle {

    /**
     * 正常字体。
     */
    normal,

    /**
     * 斜体文字（字体本身自带的斜体）。
     */
    italic,

    /**
     * 使正常文字倾斜（使用没有斜体字时，使用该选项，可使字体倾斜）。
     */
    oblique;

    @Contract("_, !null -> !null")
    public static FontStyle of(Object v, FontStyle def) {
        if (v == null) {
            return def;
        }
        if (v instanceof FontStyle) {
            return (FontStyle) v;
        }

        String n = ((String) v).trim().toLowerCase();
        for (FontStyle fs : values()) {
            if (fs.name().equals(n)) {
                return fs;
            }
        }
        return def;
    }
}
