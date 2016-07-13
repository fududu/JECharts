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

import org.aying.echarts.style.LineStyle;

import java.io.Serializable;
import java.util.Objects;

/**
 * 坐标轴刻度相关设置。
 *
 * @author Fuchun
 * @since 1.0
 */
public class AxisTick implements Serializable {

    private static final long serialVersionUID = -6972915907508973832L;

    private Boolean show;
    private Object interval;
    /* 类目轴中在 boundaryGap 为 true 的时候有效，可以保证刻度线和标签对齐。 */
    private Boolean alignWithLabel;
    /* 坐标轴刻度是否朝内，默认朝外。 */
    private Boolean inside;
    /* 坐标轴刻度的长度。 */
    private Integer length;
    private LineStyle lineStyle;

    public Boolean getShow() {
        return show;
    }

    public void setShow(Boolean show) {
        this.show = show;
    }

    public Object getInterval() {
        return interval;
    }

    public void setInterval(Object interval) {
        this.interval = interval;
    }

    public Boolean getAlignWithLabel() {
        return alignWithLabel;
    }

    public void setAlignWithLabel(Boolean alignWithLabel) {
        this.alignWithLabel = alignWithLabel;
    }

    public Boolean getInside() {
        return inside;
    }

    public void setInside(Boolean inside) {
        this.inside = inside;
    }

    public Integer getLength() {
        return length;
    }

    public void setLength(Integer length) {
        this.length = length;
    }

    public LineStyle getLineStyle() {
        return lineStyle;
    }

    public void setLineStyle(LineStyle lineStyle) {
        this.lineStyle = lineStyle;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof AxisTick)) return false;
        AxisTick axisTick = (AxisTick) o;
        return Objects.equals(show, axisTick.show) &&
                Objects.equals(interval, axisTick.interval) &&
                Objects.equals(alignWithLabel, axisTick.alignWithLabel) &&
                Objects.equals(inside, axisTick.inside) &&
                Objects.equals(length, axisTick.length) &&
                Objects.equals(lineStyle, axisTick.lineStyle);
    }

    @Override
    public int hashCode() {
        return Objects.hash(show, interval, alignWithLabel, inside, length, lineStyle);
    }

    @Override
    public String toString() {
        return String.format(
                "org.aying.echarts.axis.AxisTick{show=%s, interval=%s, alignWithLabel=%s, " +
                        "inside=%s, length=%s, lineStyle=%s}",
                show, interval, alignWithLabel, inside, length, lineStyle);
    }
}
