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
import org.aying.echarts.base.CoordinateSystem;
import org.aying.echarts.style.StateGuideLineStyle;

import java.util.Arrays;
import java.util.Objects;

/**
 * 饼图系列配置。
 * <p />
 * 饼图主要用于表现不同类目的数据在总和中的占比。每个的弧度表示数据数量的比例。
 * <p />
 * Tip: 饼图更适合表现数据相对于总数的百分比等关系。如果只是表示不同类目数据间的大小，建议使用柱状图，
 * 人们对于微小的弧度差别相比于微小的长度差别更不敏感，或者也可以通过配置 roseType 显示成南丁格尔图，通过半径大小区分数据的大小。
 *
 * @author Fuchun
 * @since 1.0
 */
public class PieSerie extends BaseSerie<PieSerie> {

    private static final long serialVersionUID = -3019341061363800600L;

    /* 是否启用图例 hover 时的联动高亮。 */
    private Boolean legendHoverLink;
    /*是否开启 hover 在扇区上的放大动画效果。*/
    private Boolean hoverAnimation;
    /*选中模式，表示是否支持多个选中，默认关闭*/
    private Object selectedMode;
    /*选中扇区的偏移距离。*/
    private Integer selectedOffset;
    /*饼图的扇区是否是顺时针排布。*/
    private Boolean clockwise;
    /*起始角度，支持范围[0, 360]。*/
    private Integer startAngle;
    /*最小的扇区角度，用于防止某个值过小导致扇区太小影响交互。*/
    private Integer minAngle;
    /*是否展示成南丁格尔图，通过半径区分数据大小。*/
    private Object roseType;
    /*是否启用防止标签重叠策略，默认开启*/
    private Boolean avoidLabelOverlap;
    /*标签的视觉引导线样式*/
    private StateGuideLineStyle labelLine;
    /*饼图的中心（圆心）坐标，数组的第一项是横坐标，第二项是纵坐标。*/
    private Object[] center;
    /*饼图的半径，数组的第一项是内半径，第二项是外半径。*/
    private Object[] radius;

    public PieSerie() {
        super(ChartType.pie);
    }

    @Override
    @JsonIgnore
    public CoordinateSystem getCoordinateSystem() {
        return super.getCoordinateSystem();
    }

    public Boolean getLegendHoverLink() {
        return legendHoverLink;
    }

    public void setLegendHoverLink(Boolean legendHoverLink) {
        this.legendHoverLink = legendHoverLink;
    }

    public Boolean getHoverAnimation() {
        return hoverAnimation;
    }

    public void setHoverAnimation(Boolean hoverAnimation) {
        this.hoverAnimation = hoverAnimation;
    }

    public Object getSelectedMode() {
        return selectedMode;
    }

    public void setSelectedMode(Object selectedMode) {
        this.selectedMode = selectedMode;
    }

    public Integer getSelectedOffset() {
        return selectedOffset;
    }

    public void setSelectedOffset(Integer selectedOffset) {
        this.selectedOffset = selectedOffset;
    }

    public Boolean getClockwise() {
        return clockwise;
    }

    public void setClockwise(Boolean clockwise) {
        this.clockwise = clockwise;
    }

    public Integer getStartAngle() {
        return startAngle;
    }

    public void setStartAngle(Integer startAngle) {
        this.startAngle = startAngle;
    }

    public Integer getMinAngle() {
        return minAngle;
    }

    public void setMinAngle(Integer minAngle) {
        this.minAngle = minAngle;
    }

    public Object getRoseType() {
        return roseType;
    }

    public void setRoseType(Object roseType) {
        this.roseType = roseType;
    }

    public Boolean getAvoidLabelOverlap() {
        return avoidLabelOverlap;
    }

    public void setAvoidLabelOverlap(Boolean avoidLabelOverlap) {
        this.avoidLabelOverlap = avoidLabelOverlap;
    }

    public StateGuideLineStyle getLabelLine() {
        return labelLine;
    }

    public void setLabelLine(StateGuideLineStyle labelLine) {
        this.labelLine = labelLine;
    }

    public Object[] getCenter() {
        return center;
    }

    public void setCenter(Object[] center) {
        this.center = center;
    }

    public Object[] getRadius() {
        return radius;
    }

    public void setRadius(Object[] radius) {
        this.radius = radius;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PieSerie)) return false;
        if (!super.equals(o)) return false;
        PieSerie pieSerie = (PieSerie) o;
        return Objects.equals(legendHoverLink, pieSerie.legendHoverLink) &&
                Objects.equals(hoverAnimation, pieSerie.hoverAnimation) &&
                Objects.equals(selectedMode, pieSerie.selectedMode) &&
                Objects.equals(selectedOffset, pieSerie.selectedOffset) &&
                Objects.equals(clockwise, pieSerie.clockwise) &&
                Objects.equals(startAngle, pieSerie.startAngle) &&
                Objects.equals(minAngle, pieSerie.minAngle) &&
                Objects.equals(roseType, pieSerie.roseType) &&
                Objects.equals(avoidLabelOverlap, pieSerie.avoidLabelOverlap) &&
                Objects.equals(labelLine, pieSerie.labelLine) &&
                Arrays.equals(center, pieSerie.center) &&
                Arrays.equals(radius, pieSerie.radius);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), legendHoverLink, hoverAnimation, selectedMode,
                selectedOffset, clockwise, startAngle, minAngle, roseType, avoidLabelOverlap,
                labelLine, center, radius);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder(32)
                .append(getClass()).append("{");
        appendPrefix(sb);
        sb.append(", legendHoverLink=").append(legendHoverLink);
        sb.append(", hoverAnimation=").append(hoverAnimation);
        sb.append(", selectedMode=").append(selectedMode);
        sb.append(", selectedOffset=").append(selectedOffset);
        sb.append(", clockwise=").append(clockwise);
        sb.append(", startAngle=").append(startAngle);
        sb.append(", minAngle=").append(minAngle);
        sb.append(", roseType=").append(roseType);
        sb.append(", avoidLabelOverlap=").append(avoidLabelOverlap);
        sb.append(", label=").append(getLabel());
        sb.append(", labelLine=").append(labelLine);
        sb.append(", itemStyle=").append(getItemStyle());
        appendCanvasZ(sb);
        sb.append(", center=").append(Arrays.toString(center));
        sb.append(", radius=").append(Arrays.toString(radius));
        sb.append(", data=").append(getData());
        appendMarks(sb);
        appendAnimation(sb);
        sb.append('}');
        return sb.toString();
    }
}
