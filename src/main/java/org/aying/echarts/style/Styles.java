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


import org.aying.echarts.style.font.FontStyle;

/**
 * ECharts style model or components factory helper.
 *
 * @author Fuchun
 * @since 1.0
 */
public abstract class Styles {

    /**
     * 获取一个新的文本样式。
     */
    public static TextStyle text() {
        return new SimpleTextStyle();
    }

    /**
     * 获取一个新的指定字体样式、宽度、大小和名称的文本样式。
     *
     * @param fontStyle 字体样式。
     * @param fontWeight 字体宽度。
     * @param fontSize 字体大小。
     * @param fontFamily 字体名称。
     */
    public static TextStyle text(FontStyle fontStyle, Object fontWeight, Integer fontSize, String fontFamily) {
        return new SimpleTextStyle(fontStyle, fontWeight, fontSize, fontFamily);
    }

    /**
     * 获取一个新的图形阴影样式。
     */
    public static SimpleShadowStyle shadow() {
        return new SimpleShadowStyle();
    }

    /**
     * 获取一个新的线条样式。
     */
    public static SimpleLineStyle line() {
        return new SimpleLineStyle();
    }

    /**
     * 获取一个新的图形样式。
     */
    public static SimpleShapeStyle shape() {
        return new SimpleShapeStyle();
    }

    /**
     * 获取一个新的表示区域的图形样式。
     */
    public static SimpleAreaShapeStyle areaShape() {
        return new SimpleAreaShapeStyle();
    }

    public static SimpleSelectStyle select() {
        return new SimpleSelectStyle();
    }

    private Styles() {}
}
