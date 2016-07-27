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

package org.aying.echarts.axis;

import org.aying.echarts.BaseData;
import org.aying.echarts.util.Validators;
import org.jetbrains.annotations.Contract;

import java.time.format.TextStyle;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;

/**
 * 基础坐标铀模型。
 *
 * @author Fuchun
 * @since 1.0
 */
public abstract class Axis<A extends Axis<A>> extends BaseData<A> {

    private static final long serialVersionUID = 1L;

    public static SimpleAxis simple() {
        return new SimpleAxis();
    }

    /*坐标轴类型。*/
    private AxisType type;
    /*坐标轴名称。String |*/
    private Object name;
    /*坐标轴名称显示位置。*/
    private NameLocation nameLocation;
    /*坐标轴名称的文字样式。*/
    private TextStyle nameTextStyle;
    /*坐标轴名称与轴线之间的距离。*/
    private Integer nameGap;
    /*坐标轴名字旋转，角度值。*/
    private Integer nameRotate;
    /*是否是反向坐标轴。ECharts 3 中新加。*/
    private Boolean inverse;
    /*坐标轴两边留白策略，类目轴和非类目轴的设置和表现不一样。Boolean|Array */
    private Object boundaryGap;
    /* 坐标轴刻度最小值，在类目轴中无效。 */
    private Object min;
    /* 坐标轴刻度最大值，在类目轴中无效。 */
    private Object max;
    /* 只在数值轴中（type: 'value'）有效。 */
    private Boolean scale;
    /* 坐标轴的分割段数 */
    private Integer splitNumber;
    /* 自动计算的坐标轴最小间隔大小。 */
    private Integer minInterval;
    /* 强制设置坐标轴分割间隔。 */
    private Integer interval;
    /* 坐标轴的标签是否响应和触发鼠标事件，默认不响应。 */
    private Boolean silent;
    /* 坐标轴的标签是否响应和触发鼠标事件，默认不响应。 */
    private Boolean triggerEvent;
    /* 坐标轴轴线相关设置。 */
    private AxisLine axisLine;
    /* 坐标轴刻度相关设置。 */
    private AxisTick axisTick;
    /* 坐标轴刻度标签的相关设置。 */
    private AxisLabel axisLabel;
    /* 坐标轴在 grid 区域中的分隔线，默认显示。 */
    private SplitLine splitLine;
    /* 坐标轴在 grid 区域中的分隔区域，默认不显示。 */
    private SplitArea splitArea;

    protected Axis() {
        super();
    }

    protected Axis(AxisType type) {
        this.type = type;
    }

    @SuppressWarnings("unchecked")
    protected A me() {
        return (A) this;
    }

    /**
     * 设置轴类型。
     *
     * @param type 轴类型。
     */
    public A typeOf(AxisType type) {
        this.type = type;

        if (this.type == AxisType.category) {
            this.min = null;
            this.max = null;
            this.interval = null;
        }
        if (this.type != AxisType.value) {
            this.minInterval = null;
        }
        return me();
    }

    /**
     * 设置坐标轴名称。
     *
     * @param name 坐标轴名称。
     */
    public A named(String name) {
        this.name = name;
        return me();
    }

    /**
     * 设置坐标轴名称显示在中间。
     */
    public A nameInMiddle() {
        setNameLocation(NameLocation.middle);
        return me();
    }

    /**
     * 设置坐标轴名称显示在结尾处。
     */
    public A nameAtTheEnd() {
        setNameLocation(NameLocation.end);
        return me();
    }

    /**
     * 设置坐标轴名称的文字样式。
     *
     * @param textStyle 坐标轴名称的文字样式。
     */
    public A nameTextStyle(TextStyle textStyle) {
        setNameTextStyle(textStyle);
        return me();
    }

    /**
     * 设置坐标轴名称与轴线之间的距离。
     *
     * @param nameGap 坐标轴名称与轴线之间的距离。
     */
    public A nameGap(int nameGap) {
        setNameGap(nameGap);
        return me();
    }

    /**
     * 设置坐标轴名字旋转，角度值。
     *
     * @param nameRotate 坐标轴名字旋转，角度值。
     */
    public A nameRotate(int nameRotate) {
        setNameRotate(nameRotate);
        return me();
    }

    /**
     * 设置为反向坐标轴。
     */
    public A inverse() {
        setInverse(Boolean.TRUE);
        return me();
    }

    /**
     * 坐标轴两边不留白（此方法必须在设置类目轴类型后才能被调用）。
     * <pre>{@code
     * axis.typeOf(AxisType.category).noBoundaryGap()...   // it worked
     * axis.typeOf(AxisType.value).noBoundaryGap()...      // it not work.
     * axis.noBoundaryGap().typeOf(AxisType.category)...   // it not work.
     * }</pre>
     *
     * @return 当前轴模型。
     * @throws IllegalArgumentException 如果轴类型{@code type != AxisType.category}。
     */
    public A noBoundaryGap() {
        if (type != AxisType.category) {
            throw new IllegalArgumentException(
                    "The Axis.type value must be `category` when boundaryGap is true or false");
        }
        this.boundaryGap = Boolean.FALSE;
        return me();
    }

    /**
     * 设置轴的两边留白策略。最小值和最大值可以直接设置数值或者相对的百分比。
     * <pre>{@code
     * axis.typeOf(AxisType.value).boundaryGap("20%", "20%")...    // it worked.
     * axis.typeOf(AxisType.value).boundaryGap(10, "20%")...       // it worked.
     * axis.boundaryGap("20%", "20%").typeOf(AxisType.value)...    // it not work
     * axis.typeOf(AxisType.category).boundaryGap("20%", "20%")... // it not work
     * }</pre>
     *
     * @param min 最小值的延伸范围（数值或百分比字符串）。
     * @param max 最大值的延伸范围（数值或百分比字符串）。
     * @return 当前轴模型。
     * @throws NullPointerException 如果参数为{@code null}。
     * @throws IllegalArgumentException 如果轴类型{@code type == AxisType.category}。
     */
    @Contract("null, _ -> fail; _, null -> fail")
    public A boundaryGap(Object min, Object max) {
        if (type == AxisType.category) {
            throw new IllegalArgumentException(
                    "The Axis.type value must not be `category`");
        }
        this.boundaryGap = new Object[]{
                Validators.checkNumber(min, "Axis.boundaryGap -> min"),
                Validators.checkNumber(max, "Axis.boundaryGap -> max")
        };
        return me();
    }

    /**
     * 设置坐标轴刻度最小值。在类目轴中无效（{@code type == AxisType.category}）。
     * <p />
     * 不设置时会自动计算最小值保证坐标轴刻度的均匀分布。
     * 可以设置成特殊值{@code "dataMin"}，此时取数据在该轴上的最小值作为最小刻度。
     *
     * @param min 坐标轴刻度最小值（数值或字符串：{@code "auto" or "dataMin"}）
     * @return 当前轴模型。
     * @throws NullPointerException 如果参数值有{@code min == null}。
     * @throws IllegalArgumentException 如果坐标轴刻度最小值类型或格式错误。
     */
    @Contract("null -> fail")
    public A min(Object min) {
        Objects.requireNonNull(min, "Axis.min");
        if (min instanceof String) {
            if (!"auto".equals(min) && !"dataMin".equals(min)) {
                throw new IllegalArgumentException("Axis.min value (String) only `auto` or `dataMin`");
            }
            this.min = min;
        } else if (min instanceof Number) {
            this.min = ((Number) min).intValue();
        } else {
            throw new IllegalArgumentException("Axis.min value type is 'string' or 'number'");
        }
        // 设置了 min 或者 max 后， scale, boundaryGap 参数将无效
        this.boundaryGap = null;
        this.scale = null;
        return me();
    }

    /**
     * 设置坐标轴刻度最大值。在类目轴中无效（{@code type == AxisType.category}）。
     * <p />
     * 不设置时会自动计算最大值保证坐标轴刻度的均匀分布。
     * 可以设置成特殊值{@code "dataMax"}，此时取数据在该轴上的最大值作为最大刻度。
     *
     * @param max 坐标轴刻度最大值（数值或字符串：{@code "auto" or "dataMax"}）
     * @return 当前轴模型。
     * @throws NullPointerException 如果参数值有{@code max == null}。
     * @throws IllegalArgumentException 如果坐标轴刻度最大值类型或格式错误。
     */
    @Contract("null -> fail")
    public A max(Object max) {
        Objects.requireNonNull(max, "Axis.max");
        if (max instanceof String) {
            if (!"auto".equals(max) && !"dataMax".equals(max)) {
                throw new IllegalArgumentException("Axis.max value (String) only `auto` or `dataMax`");
            }
            this.max = max;
        } else if (max instanceof Number) {
            this.max = ((Number) max).intValue();
        } else {
            throw new IllegalArgumentException("Axis.max value type is 'string' or 'number'");
        }
        // 设置了 min 或者 max 后， scale, boundaryGap 参数将无效
        this.boundaryGap = null;
        this.scale = null;
        return me();
    }

    /**
     * 是否是脱离 0 值比例。设置后坐标刻度不会强制包含零刻度。在双数值轴的散点图中比较有用。
     * <p />
     * 只在数值轴中（{@code type == AxisType.value}）有效。
     * <p />
     * 在设置{@code min} 和{@code max} 之后该配置项无效。
     *
     * @return 当前轴模型。
     */
    public A scaled() {
        if (type != AxisType.value) {
            throw new IllegalArgumentException("The Axis.type value must not be `value`");
        }
        this.scale = Boolean.TRUE;
        return me();
    }

    /**
     * 设置坐标轴的分割段数，需要注意的是这个分割段数只是个预估值，
     * 最后实际显示的段数会在这个基础上根据分割后坐标轴刻度显示的易读程度作调整。
     *
     * @param splitNumber 坐标轴的分割段数。
     * @return 当前轴模型。
     * @throws IllegalArgumentException 如果坐标轴的分割段数{@code splitNumber <= 0}
     */
    public A splitNumber(int splitNumber) {
        if (splitNumber <= 0) {
            throw new IllegalArgumentException("Axis.splitNumber must be greater than 0");
        }
        this.splitNumber = splitNumber;
        return me();
    }

    /**
     * 自动计算的坐标轴最小间隔大小。例如可以设置成1保证坐标轴分割刻度显示成整数。
     * <p />
     * 只在数值轴中（{@code type == AxisType.value}）有效。
     *
     * @param minInterval 最小间隔大小。
     * @return 当前轴模型。
     */
    public A minInterval(int minInterval) {
        this.minInterval = minInterval;
        return me();
    }

    /**
     * 强制设置坐标轴分割间隔。
     * <p />
     * 因为{@code splitNumber} 是预估的值，实际根据策略计算出来的刻度可能无法达到想要的效果，
     * 这时候可以使用{@code interval} 配合{@code min, max} 强制设定刻度划分，一般不建议使用。
     * <p />
     * 无法在类目轴中使用。在时间轴（{@code type == AxisType.time}）中需要传时间戳，
     * 在对数轴（{@code type == AxisType.log}）中需要传指数值。
     *
     * @param interval 坐标轴分割间隔。
     * @return 当前轴模型。
     */
    public A interval(int interval) {
        this.interval = interval;
        return me();
    }

    /**
     * 坐标轴设置为静态无法交互。
     *
     * @return 当前轴模型。
     */
    public A silent() {
        this.silent = Boolean.TRUE;
        return me();
    }

    /**
     * 坐标轴的标签响应和触发鼠标事件。不调用时不响应。
     *
     * @return 当前轴模型。
     */
    public A triggerEvent() {
        this.triggerEvent = Boolean.TRUE;
        return me();
    }

    /**
     * 设置坐标轴轴线。
     *
     * @param axisLine 坐标轴轴线设置。
     * @return 当前轴模型。
     */
    public A axisLine(AxisLine axisLine) {
        this.axisLine = axisLine;
        return me();
    }

    /**
     * 设置坐标轴刻度。
     *
     * @param axisTick 坐标轴刻度。
     * @return 当前轴模型。
     */
    public A axisTick(AxisTick axisTick) {
        this.axisTick = axisTick;
        return me();
    }

    /**
     *设置坐标轴刻度标签。
     *
     * @param axisLabel 坐标轴刻度标签的相关设置。
     * @return 当前轴模型。
     */
    public A axisLabel(AxisLabel axisLabel) {
        this.axisLabel = axisLabel;
        return me();
    }

    /**
     * 设置坐标轴在 grid 区域中的分隔线。
     *
     * @param splitLine 坐标轴在 grid 区域中的分隔线。
     * @return 当前轴模型。
     */
    public A splitLine(SplitLine splitLine) {
        this.splitLine = splitLine;
        return me();
    }

    /**
     * 设置坐标轴在 grid 区域中的分隔区域。
     *
     * @param splitArea 坐标轴在 grid 区域中的分隔区域。
     * @return 当前轴模型。
     */
    public A splitArea(SplitArea splitArea) {
        this.splitArea = splitArea;
        return me();
    }

    public AxisType getType() {
        return type;
    }

    public void setType(AxisType type) {
        this.type = type;
    }

    public Object getName() {
        return name;
    }

    public void setName(Object name) {
        this.name = name;
    }

    public NameLocation getNameLocation() {
        return nameLocation;
    }

    public void setNameLocation(NameLocation nameLocation) {
        this.nameLocation = nameLocation;
    }

    public TextStyle getNameTextStyle() {
        return nameTextStyle;
    }

    public void setNameTextStyle(TextStyle nameTextStyle) {
        this.nameTextStyle = nameTextStyle;
    }

    public Integer getNameGap() {
        return nameGap;
    }

    public void setNameGap(Integer nameGap) {
        this.nameGap = nameGap;
    }

    public Integer getNameRotate() {
        return nameRotate;
    }

    public void setNameRotate(Integer nameRotate) {
        this.nameRotate = nameRotate;
    }

    public Boolean getInverse() {
        return inverse;
    }

    public void setInverse(Boolean inverse) {
        this.inverse = inverse;
    }

    public Object getBoundaryGap() {
        return boundaryGap;
    }

    public void setBoundaryGap(Object boundaryGap) {
        this.boundaryGap = boundaryGap;
    }

    public Object getMin() {
        return min;
    }

    public void setMin(Object min) {
        this.min = min;
    }

    public Object getMax() {
        return max;
    }

    public void setMax(Object max) {
        this.max = max;
    }

    public Boolean getScale() {
        return scale;
    }

    public void setScale(Boolean scale) {
        this.scale = scale;
    }

    public Integer getSplitNumber() {
        return splitNumber;
    }

    public void setSplitNumber(Integer splitNumber) {
        this.splitNumber = splitNumber;
    }

    public Integer getMinInterval() {
        return minInterval;
    }

    public void setMinInterval(Integer minInterval) {
        this.minInterval = minInterval;
    }

    public Integer getInterval() {
        return interval;
    }

    public void setInterval(Integer interval) {
        this.interval = interval;
    }

    public Boolean getSilent() {
        return silent;
    }

    public void setSilent(Boolean silent) {
        this.silent = silent;
    }

    public Boolean getTriggerEvent() {
        return triggerEvent;
    }

    public void setTriggerEvent(Boolean triggerEvent) {
        this.triggerEvent = triggerEvent;
    }

    public AxisLine getAxisLine() {
        return axisLine;
    }

    public void setAxisLine(AxisLine axisLine) {
        this.axisLine = axisLine;
    }

    public AxisTick getAxisTick() {
        return axisTick;
    }

    public void setAxisTick(AxisTick axisTick) {
        this.axisTick = axisTick;
    }

    public AxisLabel getAxisLabel() {
        return axisLabel;
    }

    public void setAxisLabel(AxisLabel axisLabel) {
        this.axisLabel = axisLabel;
    }

    public SplitLine getSplitLine() {
        return splitLine;
    }

    public void setSplitLine(SplitLine splitLine) {
        this.splitLine = splitLine;
    }

    public SplitArea getSplitArea() {
        return splitArea;
    }

    public void setSplitArea(SplitArea splitArea) {
        this.splitArea = splitArea;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Axis)) return false;
        Axis<?> axis = (Axis<?>) o;
        return type == axis.type &&
                Objects.equals(name, axis.name) &&
                nameLocation == axis.nameLocation &&
                nameTextStyle == axis.nameTextStyle &&
                Objects.equals(nameGap, axis.nameGap) &&
                Objects.equals(nameRotate, axis.nameRotate) &&
                Objects.equals(inverse, axis.inverse) &&
                Objects.equals(boundaryGap, axis.boundaryGap) &&
                Objects.equals(min, axis.min) &&
                Objects.equals(max, axis.max) &&
                Objects.equals(scale, axis.scale) &&
                Objects.equals(splitNumber, axis.splitNumber) &&
                Objects.equals(minInterval, axis.minInterval) &&
                Objects.equals(interval, axis.interval) &&
                Objects.equals(silent, axis.silent) &&
                Objects.equals(triggerEvent, axis.triggerEvent) &&
                Objects.equals(axisLine, axis.axisLine) &&
                Objects.equals(axisTick, axis.axisTick) &&
                Objects.equals(axisLabel, axis.axisLabel) &&
                Objects.equals(splitLine, axis.splitLine) &&
                Objects.equals(splitArea, axis.splitArea);
    }

    @Override
    public int hashCode() {
        return Objects.hash(
                type, name, nameLocation, nameTextStyle, nameGap, nameRotate, inverse, boundaryGap,
                min, max, scale, splitNumber, minInterval, interval, silent, triggerEvent, axisLine,
                axisTick, axisLabel, splitLine, splitArea);
    }

    protected Map<String, Object> toStringMap() {
        Map<String, Object> map = new LinkedHashMap<>();
        map.put("type", getType());
        map.put("name", getName());
        map.put("nameLocation", getNameLocation());
        map.put("nameTextStyle", getNameTextStyle());
        map.put("nameGap", getNameGap());
        map.put("nameRotate", getNameRotate());
        map.put("inverse", getInverse());
        map.put("boundaryGap", getBoundaryGap());
        map.put("min", getMin());
        map.put("max", getMax());
        map.put("scale", getScale());
        map.put("splitNumber", getSplitNumber());
        map.put("minInterval", getMinInterval());
        map.put("interval", getInterval());
        map.put("silent", getSilent());
        map.put("triggerEvent", getTriggerEvent());
        map.put("axisLine", getAxisLine());
        map.put("axisTick", getAxisTick());
        map.put("axisLabel", getAxisLabel());
        map.put("splitLine", getSplitLine());
        map.put("splitArea", getSplitArea());
        return map;
    }

    protected String toString(Map<String, Object> prev, Map<String, Object> last, boolean pretty) {
        Map<String, Object> map = new LinkedHashMap<>();
        if (prev != null && prev.size() > 0) {
            map.putAll(prev);
        }
        map.putAll(toStringMap());
        if (last != null && last.size() > 0) {
            map.putAll(last);
        }
        StringBuilder builder = new StringBuilder(getClass().getName());
        builder.append("{");
        if (pretty) {
            builder.append("\n");
        }

        int i = 0, size = map.size();
        for (Map.Entry<String, Object> entry : map.entrySet()) {
            String k = entry.getKey();
            Object v = entry.getValue();
            if (pretty) builder.append("  ");
            builder.append(k).append("=").append(String.valueOf(v));
            if (i != size - 1) {
                builder.append(", ");
            }
            if (pretty) builder.append("\n");
            i++;
        }
        builder.append("}");
        return builder.toString();
    }

    @Override
    public String toString() {
        return toString(null, null, false);
    }
}
