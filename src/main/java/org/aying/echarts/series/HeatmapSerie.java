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
import org.aying.echarts.base.AnimationEasing;

import java.util.Objects;

/**
 * 热力图系列配置。热力图主要通过颜色去表现数值的大小，必须要配合 visualMap 组件使用。
 * <p />
 * 可以应用在直角坐标系以及地理坐标系上，这两个坐标系上的表现形式相差很大，直角坐标系上必须要使用两个类目轴。
 *
 * @author Fuchun
 * @since 1.0
 */
public class HeatMapSerie extends BaseSerie<HeatMapSerie, SerieData> {

    private static final long serialVersionUID = -3322962895956958775L;

    private Integer xAxisIndex;
    private Integer yAxisIndex;
    private Integer geoIndex;
    private Integer blurSize;
    private Double minOpacity;
    private Double maxOpacity;

    public HeatMapSerie() {
        super(ChartType.heatmap);
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

    public Integer getBlurSize() {
        return blurSize;
    }

    public void setBlurSize(Integer blurSize) {
        this.blurSize = blurSize;
    }

    public Double getMinOpacity() {
        return minOpacity;
    }

    public void setMinOpacity(Double minOpacity) {
        this.minOpacity = minOpacity;
    }

    public Double getMaxOpacity() {
        return maxOpacity;
    }

    public void setMaxOpacity(Double maxOpacity) {
        this.maxOpacity = maxOpacity;
    }

    @Override
    @JsonIgnore
    public Boolean getAnimation() {
        return super.getAnimation();
    }

    @Override
    @JsonIgnore
    public Integer getAnimationThreshold() {
        return super.getAnimationThreshold();
    }

    @Override
    @JsonIgnore
    public Integer getAnimationDuration() {
        return super.getAnimationDuration();
    }

    @Override
    @JsonIgnore
    public AnimationEasing getAnimationEasing() {
        return super.getAnimationEasing();
    }

    @Override
    @JsonIgnore
    public Object getAnimationDelay() {
        return super.getAnimationDelay();
    }

    @Override
    @JsonIgnore
    public Integer getAnimationDurationUpdate() {
        return super.getAnimationDurationUpdate();
    }

    @Override
    @JsonIgnore
    public AnimationEasing getAnimationEasingUpdate() {
        return super.getAnimationEasingUpdate();
    }

    @Override
    @JsonIgnore
    public Object getAnimationDelayUpdate() {
        return super.getAnimationDelayUpdate();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof HeatMapSerie)) return false;
        if (!super.equals(o)) return false;
        HeatMapSerie that = (HeatMapSerie) o;
        return Objects.equals(xAxisIndex, that.xAxisIndex) &&
                Objects.equals(yAxisIndex, that.yAxisIndex) &&
                Objects.equals(geoIndex, that.geoIndex) &&
                Objects.equals(blurSize, that.blurSize) &&
                Objects.equals(minOpacity, that.minOpacity) &&
                Objects.equals(maxOpacity, that.maxOpacity);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), xAxisIndex, yAxisIndex, geoIndex, blurSize, minOpacity, maxOpacity);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder(32)
                .append(getClass()).append("{");
        appendPrefix(sb);
        sb.append(", coordinateSystem=").append(getCoordinateSystem());
        sb.append(", xAxisIndex=").append(xAxisIndex);
        sb.append(", yAxisIndex=").append(yAxisIndex);
        sb.append(", geoIndex=").append(geoIndex);
        sb.append(", blurSize=").append(blurSize);
        sb.append(", minOpacity=").append(minOpacity);
        sb.append(", maxOpacity=").append(maxOpacity);
        sb.append(", data=").append(getData());
        appendMarks(sb);
        appendCanvasZ(sb);
        sb.append('}');
        return sb.toString();
    }
}
