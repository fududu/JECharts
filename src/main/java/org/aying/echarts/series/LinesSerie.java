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
import org.aying.echarts.style.StateShapeStyle;

import java.util.Objects;

/**
 * 线图系列配置。
 *
 * @author Fuchun
 * @since 1.0
 */
public class LinesSerie extends BaseSerie<LinesSerie> {

    private static final long serialVersionUID = 42758664974614680L;

    private Integer xAxisIndex;
    private Integer yAxisIndex;
    private Integer geoIndex;
    private Boolean polyline;
    private LineEffect effect;
    private Boolean large;
    private Integer largeThreshold;
    private StateLineStyle lineStyle;

    public LinesSerie() {
        super(ChartType.lines);
    }

    public Integer getxAxisIndex() {
        return xAxisIndex;
    }

    public void setxAxisIndex(Integer xAxisIndex) {
        this.xAxisIndex = xAxisIndex;
    }

    public Integer getyAxisIndex() {
        return yAxisIndex;
    }

    public void setyAxisIndex(Integer yAxisIndex) {
        this.yAxisIndex = yAxisIndex;
    }

    public Integer getGeoIndex() {
        return geoIndex;
    }

    public void setGeoIndex(Integer geoIndex) {
        this.geoIndex = geoIndex;
    }

    public Boolean getPolyline() {
        return polyline;
    }

    public void setPolyline(Boolean polyline) {
        this.polyline = polyline;
    }

    public LineEffect getEffect() {
        return effect;
    }

    public void setEffect(LineEffect effect) {
        this.effect = effect;
    }

    public Boolean getLarge() {
        return large;
    }

    public void setLarge(Boolean large) {
        this.large = large;
    }

    public Integer getLargeThreshold() {
        return largeThreshold;
    }

    public void setLargeThreshold(Integer largeThreshold) {
        this.largeThreshold = largeThreshold;
    }

    public StateLineStyle getLineStyle() {
        return lineStyle;
    }

    public void setLineStyle(StateLineStyle lineStyle) {
        this.lineStyle = lineStyle;
    }

    @Override
    @JsonIgnore
    public StateShapeStyle getItemStyle() {
        return super.getItemStyle();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof LinesSerie)) return false;
        if (!super.equals(o)) return false;
        LinesSerie that = (LinesSerie) o;
        return Objects.equals(xAxisIndex, that.xAxisIndex) &&
                Objects.equals(yAxisIndex, that.yAxisIndex) &&
                Objects.equals(geoIndex, that.geoIndex) &&
                Objects.equals(polyline, that.polyline) &&
                Objects.equals(effect, that.effect) &&
                Objects.equals(large, that.large) &&
                Objects.equals(largeThreshold, that.largeThreshold) &&
                Objects.equals(lineStyle, that.lineStyle);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), xAxisIndex, yAxisIndex, geoIndex, polyline, effect, large, largeThreshold, lineStyle);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder(32)
                .append(getClass()).append("{");
        appendPrefix(sb);
        sb.append(", xAxisIndex=").append(xAxisIndex);
        sb.append(", yAxisIndex=").append(yAxisIndex);
        sb.append(", geoIndex=").append(geoIndex);
        sb.append(", polyline=").append(polyline);
        sb.append(", effect=").append(effect);
        sb.append(", large=").append(large);
        sb.append(", largeThreshold=").append(largeThreshold);
        sb.append(", lineStyle=").append(lineStyle);
        sb.append(", label=").append(getLabel());
        sb.append(", data=").append(getData());
        appendMarks(sb);
        appendCanvasZ(sb);
        appendAnimation(sb);
        sb.append('}');
        return sb.toString();
    }
}
