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

import org.aying.echarts.base.LineType;

/**
 * 图形样式。
 *
 * @author Fuchun
 * @since 1.0
 */
public interface ShapeStyle extends ShadowStyle {

    /**
     * 图形（组件）背景颜色。
     */
    String getBackgroundColor();

    /**
     * 图形的边框颜色。支持的格式同 color。
     */
    String getBorderColor();

    /**
     * 图形的边框颜色的饱和度。取值范围是{@code 0 ~ 1} 之间的浮点数。
     * <p />
     * 支持的类型：{@code Double}、{@code Object[]} 或{@code List}；
     * 类型为数组或列表时，长度只能为{@code 2} 或者{@code 4}。
     */
    default Object getBorderColorSaturation() {
        return null;
    }

    /**
     * 边框线宽度。为 0 时无描边。
     */
    Integer getBorderWidth();

    /**
     * 图形的描边类型。
     */
    LineType getBorderType();

    /**
     * 图形的内部图形（子节点）的间隔距离。
     * NOTE：此属性只用于{@code TreeMap} 系列的配置中，矩形内部子矩形（子节点）的间隔距离。
     */
    default Integer getGapWidth() {
        return null;
    }

    /**
     * 文本样式（极少数会用到）
     */
    TextStyle getTextStyle();

    default ShapeStyle bgColor(String bgColor) {
        return this;
    }

    default ShapeStyle borderWidth(int borderWidth) {
        return this;
    }

    default ShapeStyle borderColor(String color) {
        return this;
    }

    default ShapeStyle textStyle(TextStyle textStyle) {
        return this;
    }
}
