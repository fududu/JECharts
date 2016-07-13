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

import org.aying.echarts.base.Align;

import java.io.Serializable;

/**
 * {@code VisualMap} 是视觉映射组件，用于进行『视觉编码』，也就是将数据映射到视觉元素（视觉通道）。
 *
 * @author Fuchun
 * @since 1.0
 */
public abstract class VisualMap implements Serializable {

    public enum InRange {
        /** 图元的图形类别。 */
        symbol,
        /** 图元的大小。*/
        symbolSize,
        /** 图元的颜色。*/
        color,
        /** 图元的颜色的透明度。*/
        colorAlpha,
        /** 图元以及其附属物（如文字标签）的透明度。*/
        opacity,
        /** 颜色的明暗度，参见 HSL。 */
        colorLightness,
        /** 颜色的饱和度，参见 HSL。 */
        colorSaturation,
        /** 颜色的色调，参见 HSL。*/
        colorHue
    }

    private final String type;
    /* 组件的允许的最小值。'min' 必须用户指定。[visualMap.min, visualMap.max] 形成了视觉映射的『定义域』。 */
    private Integer min;
    /* 组件的允许的最大值。'max' 必须用户指定。[visualMap.min, visualMap.max] 形成了视觉映射的『定义域』。 */
    private Integer max;
    /* 是否反转 visualMap 组件。默认：false */
    private Boolean inverse;
    /* 数据展示的小数精度。 */
    private Integer precision;
    /* 图形的宽度，连续型为 长条的宽度；分段型为 每个小块的宽度。 */
    private Integer itemWidth;
    /* 图形的高度，连续型为 长条的高度；分段型为 每个小块的高度。 */
    private Integer itemHeight;
    /* 指定组件中图形和文字的摆放关系。类型不同，取值不同 */
    private Align align;
    /* 两端的文本，如['High', 'Low'] */
    private String[] text;
    /* 两端文字主体之间的距离，单位为px。默认：10 */
    private Integer textGap;
    /* 是否显示 visualMap 组件。如果设置为 false，不会显示，但是数据映射的功能还存在。 */
    private Boolean show;
    /* 指定用数据的『哪个维度』，映射到视觉元素上。默认：0 */
    private Integer dimension;
    /* 指定取哪个系列的数据，即哪个系列的 series.data。默认取所有系列。 */
    private Object seriesIndex;
    /* 打开 hoverLink 功能时，鼠标悬浮到 visualMap 组件上时，鼠标位置对应的数值 在 图表中对应的图形元素，会高亮。默认：true */
    private Boolean hoverLink;


    protected VisualMap(String type) {
        this.type = type;
    }
}
