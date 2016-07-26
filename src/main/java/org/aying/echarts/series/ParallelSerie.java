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
import org.aying.echarts.style.StateLineStyle;

import java.util.Objects;

/**
 * 平行坐标系的系列配置。用于展现节点以及节点之间的关系数据。
 *
 * @author Fuchun
 * @since 1.0
 */
public class ParallelSerie extends BaseSerie<ParallelSerie> {

    private static final long serialVersionUID = -6174500811812587862L;

    /*使用的平行坐标系的 index，在单个图表实例中存在多个平行坐标系的时候有用。*/
    private Integer parallelIndex;
    /*线条样式。*/
    private StateLineStyle lineStyle;
    /*框选时，未被选中的条线会设置成这个『透明度』（从而可以达到变暗的效果）。*/
    private Double inactiveOpacity;
    /*框选时，选中的条线会设置成这个『透明度』（从而可以达到高亮的效果）。*/
    private Double activeOpacity;
    /*是否实时更新*/
    private Boolean realtime;

    public ParallelSerie() {
        super(ChartType.parallel);
    }

    public ParallelSerie parallelIndex(int index) {
        this.parallelIndex = index;
        return this;
    }

    public ParallelSerie lineStyle(StateLineStyle lineStyle) {
        this.lineStyle = lineStyle;
        return this;
    }

    public ParallelSerie notRealTime() {
        this.realtime = Boolean.FALSE;
        return this;
    }

    public Integer getParallelIndex() {
        return parallelIndex;
    }

    public void setParallelIndex(Integer parallelIndex) {
        this.parallelIndex = parallelIndex;
    }

    public StateLineStyle getLineStyle() {
        return lineStyle;
    }

    public void setLineStyle(StateLineStyle lineStyle) {
        this.lineStyle = lineStyle;
    }

    public Double getInactiveOpacity() {
        return inactiveOpacity;
    }

    public void setInactiveOpacity(Double inactiveOpacity) {
        this.inactiveOpacity = inactiveOpacity;
    }

    public Double getActiveOpacity() {
        return activeOpacity;
    }

    public void setActiveOpacity(Double activeOpacity) {
        this.activeOpacity = activeOpacity;
    }

    public Boolean getRealtime() {
        return realtime;
    }

    public void setRealtime(Boolean realtime) {
        this.realtime = realtime;
    }

    @Override
    @JsonIgnore
    public MarkPoint getMarkPoint() {
        return super.getMarkPoint();
    }

    @Override
    @JsonIgnore
    public MarkLine getMarkLine() {
        return super.getMarkLine();
    }

    @Override
    @JsonIgnore
    public MarkArea getMarkArea() {
        return super.getMarkArea();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ParallelSerie)) return false;
        if (!super.equals(o)) return false;
        ParallelSerie that = (ParallelSerie) o;
        return Objects.equals(parallelIndex, that.parallelIndex) &&
                Objects.equals(lineStyle, that.lineStyle) &&
                Objects.equals(inactiveOpacity, that.inactiveOpacity) &&
                Objects.equals(activeOpacity, that.activeOpacity) &&
                Objects.equals(realtime, that.realtime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), parallelIndex, lineStyle, inactiveOpacity, activeOpacity, realtime);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder(32)
                .append(getClass()).append("{");
        appendPrefix(sb);
        sb.append(", parallelIndex=").append(parallelIndex);
        sb.append(", lineStyle=").append(lineStyle);
        sb.append(", inactiveOpacity=").append(inactiveOpacity);
        sb.append(", activeOpacity=").append(activeOpacity);
        sb.append(", realtime=").append(realtime);
        sb.append(", data=").append(getData());
        appendCanvasZ(sb);
        appendAnimation(sb);
        sb.append('}');
        return sb.toString();
    }
}
