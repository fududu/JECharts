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

import java.time.format.TextStyle;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;

/**
 * 坐标铀。
 *
 * @author Fuchun
 * @since 1.0
 */
public abstract class Axis<A extends Axis<A>> extends BaseData<A> {

    private static final long serialVersionUID = 1L;

    private AxisType type;
    private String name;
    private NameLocation nameLocation;
    private TextStyle nameTextStyle;
    private Integer nameGap;
    private Integer nameRotate;
    private Integer nameTruncateLength;
    private String nameTruncateEllipsis;
    private Boolean inverse;
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

    public AxisType getType() {
        return type;
    }

    public void setType(AxisType type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
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

    public Integer getNameTruncateLength() {
        return nameTruncateLength;
    }

    public void setNameTruncateLength(Integer nameTruncateLength) {
        this.nameTruncateLength = nameTruncateLength;
    }

    public String getNameTruncateEllipsis() {
        return nameTruncateEllipsis;
    }

    public void setNameTruncateEllipsis(String nameTruncateEllipsis) {
        this.nameTruncateEllipsis = nameTruncateEllipsis;
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
                Objects.equals(nameTruncateLength, axis.nameTruncateLength) &&
                Objects.equals(nameTruncateEllipsis, axis.nameTruncateEllipsis) &&
                Objects.equals(inverse, axis.inverse) &&
                Objects.equals(boundaryGap, axis.boundaryGap) &&
                Objects.equals(min, axis.min) &&
                Objects.equals(max, axis.max) &&
                Objects.equals(scale, axis.scale) &&
                Objects.equals(splitNumber, axis.splitNumber) &&
                Objects.equals(minInterval, axis.minInterval) &&
                Objects.equals(interval, axis.interval) &&
                Objects.equals(silent, axis.silent) &&
                Objects.equals(axisLine, axis.axisLine) &&
                Objects.equals(axisTick, axis.axisTick) &&
                Objects.equals(axisLabel, axis.axisLabel) &&
                Objects.equals(splitLine, axis.splitLine) &&
                Objects.equals(splitArea, axis.splitArea);
    }

    @Override
    public int hashCode() {
        return Objects.hash(
                type, name, nameLocation, nameTextStyle, nameGap, nameRotate, nameTruncateLength,
                nameTruncateEllipsis, inverse, boundaryGap, min, max, scale, splitNumber, minInterval,
                interval, silent, axisLine, axisTick, axisLabel, splitLine, splitArea);
    }

    protected Map<String, Object> toStringMap() {
        Map<String, Object> map = new LinkedHashMap<>();
        map.put("type", getType());
        map.put("name", getName());
        map.put("nameLocation", getNameLocation());
        map.put("nameTextStyle", getNameTextStyle());
        map.put("nameGap", getNameGap());
        map.put("nameRotate", getNameRotate());
        map.put("nameTruncateLength", getNameTruncateLength());
        map.put("nameTruncateEllipsis", getNameTruncateEllipsis());
        map.put("inverse", getInverse());
        map.put("boundaryGap", getBoundaryGap());
        map.put("min", getMin());
        map.put("max", getMax());
        map.put("scale", getScale());
        map.put("splitNumber", getSplitNumber());
        map.put("minInterval", getMinInterval());
        map.put("interval", getInterval());
        map.put("silent", getSilent());
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
