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

package org.aying.echarts.style;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import org.aying.echarts.style.font.FontStyle;

/**
 * 文本文字样式。
 *
 * @author Fuchun
 * @since 1.0
 */
@JsonDeserialize(as = DefaultTextStyle.class)
public interface TextStyle extends Style {

    static DefaultTextStyle newStyle() {
        return new DefaultTextStyle();
    }

    static TextStyle font(FontStyle fontStyle, Object fontWeight, Integer fontSize, String fontFamily) {
        return new DefaultTextStyle(fontStyle, fontWeight, fontSize, fontFamily);
    }

    /**
     * 文字样式。
     */
    FontStyle getFontStyle();

    /**
     * 字体粗细。{@link org.aying.echarts.style.font.FontWeight} 或者为整型的
     * {@code 100、200、300、400、500、600、700、800、900}
     */
    Object getFontWeight();

    /**
     * 字体名称。
     */
    String getFontFamily();

    /**
     * 字体大小。
     */
    Integer getFontSize();
}
