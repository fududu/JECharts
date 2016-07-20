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
import org.aying.echarts.base.Graph;
import org.aying.echarts.base.Orient;
import org.aying.echarts.util.CollectionUtils;

import java.io.Serializable;
import java.time.format.TextStyle;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 * {@code VisualMap} 是视觉映射组件，用于进行『视觉编码』，也就是将数据映射到视觉元素（视觉通道）。
 *
 * @author Fuchun
 * @since 1.0
 */
public abstract class VisualMap<V extends VisualMap<V>>
        extends Graph<V> implements Serializable {

    private static final long serialVersionUID = 1L;

    public static ContinuousVisualMap continuous() {
        return new ContinuousVisualMap();
    }

    public static PiecewiseVisualMap piecewise() {
        return new PiecewiseVisualMap();
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
    /* 定义 在选中范围中 的视觉元素。 */
    private VisualRange inRange;
    /* 定义 在选中范围外 的视觉元素。 */
    private VisualRange outOfRange;
    /* visualMap 组件中，控制器 的 inRange outOfRange 设置。 */
    private Map<String, VisualRange> controller;

    /* 如何放置 visualMap 组件，水平（'horizontal'）或者竖直（'vertical'）。 */
    private Orient orient;
    /* visualMap 内边距，单位px，默认各方向内边距为5，接受数组分别设定上右下左边距。 */
    private Object padding;

    private String backgroundColor;
    private String borderColor;
    private Integer borderWidth;
    private List<String> color;
    private TextStyle textStyle;
    private Object formatter;

    protected VisualMap(String type) {
        this.type = type;
    }

    @SuppressWarnings("unchecked")
    protected V me() {
        return (V) this;
    }

    public V size(int min, int max) {
        if (min < 0 || max < 0) {
            throw new IllegalArgumentException("The min, max value must be >= 0");
        }
        this.min = min;
        this.max = max;
        return me();
    }

    /**
     * 反转当前{@code VisualMap} 组件。
     * <pre>{@code
     * inverse == false，数据大小的位置规则，和直角坐标系相同，即：
     * orient == vertical 时，数据上大下小。
     * orient == horizontal 时，数据右大左小。
     * }</pre>
     */
    public V inverse() {
        this.inverse = Boolean.TRUE;
        return me();
    }

    /**
     * 设置数据展示的小数精度。
     *
     * @param precision 小数精度。
     * @throws IllegalArgumentException 如果小数精度为负数{@code precision < 0}
     */
    public V precision(int precision) {
        if (precision < 0) {
            throw new IllegalArgumentException(
                    "The precision value must be greater than or equals 0");
        }
        this.precision = precision;
        return me();
    }

    /**
     * 设置图形的宽度和高度。
     *
     * @param width 宽度
     * @param height 高度
     * @throws IllegalArgumentException 如果宽度或高度被设置为负数{@code width < 0 || height < 0}
     */
    public V itemSize(int width, int height) {
        if (width < 0 || height < 0) {
            throw new IllegalArgumentException("The width or height value must be > 0");
        }
        this.itemWidth = width;
        this.itemHeight = height;
        return me();
    }

    /**
     * 设置手柄和{@code label} 在右侧。
     * 调用该方法后，{@code orient} 会被自动设置为{@code horizontal}。
     */
    public V alignLeft() {
        this.orient = Orient.horizontal;
        this.align = Align.left;
        return me();
    }

    /**
     * 设置手柄和{@code label} 在左侧。
     * 调用该方法后，{@code orient} 会被自动设置为{@code horizontal}。
     */
    public V alignRight() {
        this.orient = Orient.horizontal;
        this.align = Align.right;
        return me();
    }

    public V padding(int padding) {
        return padding(padding, padding);
    }

    public V padding(int tb, int lr) {
        this.padding = Arrays.asList(tb, lr);
        return me();
    }

    public V padding(int top, int right, int bottom, int left) {
        this.padding = Arrays.asList(top, right, bottom, left);
        return me();
    }

    public V inRange(VisualRange inRange) {
        this.inRange = inRange;
        return me();
    }

    public V outOfRange(VisualRange outOfRange) {
        this.outOfRange = outOfRange;
        return me();
    }

    /**
     * 水平放置{@code VisualMap} 组件。
     */
    public V horizontal() {
        this.orient = Orient.horizontal;
        return me();
    }

    /**
     * 设置{@code VisualMap} 组件的颜色。
     *
     * @param c1 第一个颜色。
     * @param c2 第二个颜色。
     * @param cn 后续的颜色。
     * @deprecated 该属性在 ECharts3.0 中已不再推荐使用。要设置组件颜色，可设置
     * {@link #getInRange()} 和{@link #getOutOfRange()} 属性。
     */
    @Deprecated
    public V color(String c1, String c2, String... cn) {
        this.color = CollectionUtils.linkedList("color", c1, c2, cn);
        return me();
    }

    public boolean hasLimitedRange() {
        return min != null && max != null &&
                min >= 0 && max > 0;
    }

    // getter and setter
    // ----------------------------------------------------------------------------------

    public String getType() {
        return type;
    }

    public Integer getMin() {
        return min;
    }

    public void setMin(Integer min) {
        this.min = min;
    }

    public Integer getMax() {
        return max;
    }

    public void setMax(Integer max) {
        this.max = max;
    }

    public Boolean getInverse() {
        return inverse;
    }

    public void setInverse(Boolean inverse) {
        this.inverse = inverse;
    }

    public Integer getPrecision() {
        return precision;
    }

    public void setPrecision(Integer precision) {
        this.precision = precision;
    }

    public Integer getItemWidth() {
        return itemWidth;
    }

    public void setItemWidth(Integer itemWidth) {
        this.itemWidth = itemWidth;
    }

    public Integer getItemHeight() {
        return itemHeight;
    }

    public void setItemHeight(Integer itemHeight) {
        this.itemHeight = itemHeight;
    }

    public Align getAlign() {
        return align;
    }

    public void setAlign(Align align) {
        this.align = align;
    }

    public String[] getText() {
        return text;
    }

    public void setText(String[] text) {
        this.text = text;
    }

    public Integer getTextGap() {
        return textGap;
    }

    public void setTextGap(Integer textGap) {
        this.textGap = textGap;
    }

    public Boolean getShow() {
        return show;
    }

    public void setShow(Boolean show) {
        this.show = show;
    }

    public Integer getDimension() {
        return dimension;
    }

    public void setDimension(Integer dimension) {
        this.dimension = dimension;
    }

    public Object getSeriesIndex() {
        return seriesIndex;
    }

    public void setSeriesIndex(Object seriesIndex) {
        this.seriesIndex = seriesIndex;
    }

    public Boolean getHoverLink() {
        return hoverLink;
    }

    public void setHoverLink(Boolean hoverLink) {
        this.hoverLink = hoverLink;
    }

    public VisualRange getInRange() {
        return inRange;
    }

    public void setInRange(VisualRange inRange) {
        this.inRange = inRange;
    }

    public VisualRange getOutOfRange() {
        return outOfRange;
    }

    public void setOutOfRange(VisualRange outOfRange) {
        this.outOfRange = outOfRange;
    }

    public Map<String, VisualRange> getController() {
        return controller;
    }

    public void setController(Map<String, VisualRange> controller) {
        this.controller = controller;
    }

    public Orient getOrient() {
        return orient;
    }

    public void setOrient(Orient orient) {
        this.orient = orient;
    }

    public Object getPadding() {
        return padding;
    }

    public void setPadding(Object padding) {
        this.padding = padding;
    }

    public String getBackgroundColor() {
        return backgroundColor;
    }

    public void setBackgroundColor(String backgroundColor) {
        this.backgroundColor = backgroundColor;
    }

    public String getBorderColor() {
        return borderColor;
    }

    public void setBorderColor(String borderColor) {
        this.borderColor = borderColor;
    }

    public Integer getBorderWidth() {
        return borderWidth;
    }

    public void setBorderWidth(Integer borderWidth) {
        this.borderWidth = borderWidth;
    }

    public List<String> getColor() {
        return color;
    }

    public void setColor(List<String> color) {
        this.color = color;
    }

    public TextStyle getTextStyle() {
        return textStyle;
    }

    public void setTextStyle(TextStyle textStyle) {
        this.textStyle = textStyle;
    }

    public Object getFormatter() {
        return formatter;
    }

    public void setFormatter(Object formatter) {
        this.formatter = formatter;
    }
}
