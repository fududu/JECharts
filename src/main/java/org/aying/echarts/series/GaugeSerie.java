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

package org.aying.echarts.series;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.aying.echarts.ChartType;
import org.aying.echarts.axis.AxisLabel;
import org.aying.echarts.axis.AxisLine;
import org.aying.echarts.axis.AxisTick;
import org.aying.echarts.axis.SplitLine;
import org.aying.echarts.base.StateLabel;

import java.util.Objects;

/**
 * 仪表盘系列配置。
 *
 * @author Fuchun
 * @since 1.0
 */
public class GaugeSerie extends BaseSerie<GaugeSerie> {

    private static final long serialVersionUID = 2412029199165642744L;

    /*仪表盘半径，可以是相对于容器高宽中较小的一项的一半的百分比，也可以是绝对的数值。*/
    private Object radius;
    /*仪表盘起始角度。圆心 正右手侧为0度，正上方为90度，正左手侧为180度。*/
    private Integer startAngle;
    /*仪表盘结束角度。*/
    private Integer endAngle;
    /*仪表盘刻度是否是顺时针增长。*/
    private Boolean clockwise;
    /*最小的数据值，映射到 minAngle。*/
    private Integer min;
    /*最大的数据值，映射到 maxAngle。*/
    private Integer max;
    /*仪表盘刻度的分割段数。*/
    private Integer splitNumber;
    /*仪表盘轴线相关配置。*/
    private AxisLine axisLine;
    /*分隔线样式。*/
    private SplitLine splitLine;
    /*刻度样式。*/
    private AxisTick axisTick;
    /*刻度标签。*/
    private AxisLabel axisLabel;
    /*仪表盘指针。*/
    private Pointer pointer;
    /*仪表盘标题。*/
    private GaugeTitle title;
    /*仪表盘详情，用于显示数据。*/
    private GaugeDetail detail;

    public GaugeSerie() {
        super(ChartType.gauge);
    }

    public Object getRadius() {
        return radius;
    }

    public void setRadius(Object radius) {
        this.radius = radius;
    }

    public Integer getStartAngle() {
        return startAngle;
    }

    public void setStartAngle(Integer startAngle) {
        this.startAngle = startAngle;
    }

    public Integer getEndAngle() {
        return endAngle;
    }

    public void setEndAngle(Integer endAngle) {
        this.endAngle = endAngle;
    }

    public Boolean getClockwise() {
        return clockwise;
    }

    public void setClockwise(Boolean clockwise) {
        this.clockwise = clockwise;
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

    public Integer getSplitNumber() {
        return splitNumber;
    }

    public void setSplitNumber(Integer splitNumber) {
        this.splitNumber = splitNumber;
    }

    public AxisLine getAxisLine() {
        return axisLine;
    }

    public void setAxisLine(AxisLine axisLine) {
        this.axisLine = axisLine;
    }

    public SplitLine getSplitLine() {
        return splitLine;
    }

    public void setSplitLine(SplitLine splitLine) {
        this.splitLine = splitLine;
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

    public Pointer getPointer() {
        return pointer;
    }

    public void setPointer(Pointer pointer) {
        this.pointer = pointer;
    }

    public GaugeTitle getTitle() {
        return title;
    }

    public void setTitle(GaugeTitle title) {
        this.title = title;
    }

    public GaugeDetail getDetail() {
        return detail;
    }

    public void setDetail(GaugeDetail detail) {
        this.detail = detail;
    }

    @Override
    @JsonIgnore
    public StateLabel getLabel() {
        return super.getLabel();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof GaugeSerie)) return false;
        if (!super.equals(o)) return false;
        GaugeSerie that = (GaugeSerie) o;
        return Objects.equals(radius, that.radius) &&
                Objects.equals(startAngle, that.startAngle) &&
                Objects.equals(endAngle, that.endAngle) &&
                Objects.equals(clockwise, that.clockwise) &&
                Objects.equals(min, that.min) &&
                Objects.equals(max, that.max) &&
                Objects.equals(splitNumber, that.splitNumber) &&
                Objects.equals(axisLine, that.axisLine) &&
                Objects.equals(splitLine, that.splitLine) &&
                Objects.equals(axisTick, that.axisTick) &&
                Objects.equals(axisLabel, that.axisLabel) &&
                Objects.equals(pointer, that.pointer) &&
                Objects.equals(title, that.title) &&
                Objects.equals(detail, that.detail);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), radius, startAngle, endAngle, clockwise, min, max,
                splitNumber, axisLine, splitLine, axisTick, axisLabel, pointer, title, detail);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder(32)
                .append(getClass()).append("{");
        appendPrefix(sb);
        sb.append(", radius=").append(radius);
        sb.append(", startAngle=").append(startAngle);
        sb.append(", endAngle=").append(endAngle);
        sb.append(", clockwise=").append(clockwise);
        sb.append(", min=").append(min);
        sb.append(", max=").append(max);
        sb.append(", splitNumber=").append(splitNumber);
        sb.append(", axisLine=").append(axisLine);
        sb.append(", splitLine=").append(splitLine);
        sb.append(", axisTick=").append(axisTick);
        sb.append(", axisLabel=").append(axisLabel);
        sb.append(", pointer=").append(pointer);
        sb.append(", itemStyle=").append(getItemStyle());
        sb.append(", title=").append(title);
        sb.append(", detail=").append(detail);
        appendMarks(sb);
        appendAnimation(sb);
        sb.append('}');
        return sb.toString();
    }
}
