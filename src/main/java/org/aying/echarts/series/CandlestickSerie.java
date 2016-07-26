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

import org.aying.echarts.ChartType;
import org.aying.echarts.base.Orient;

import java.util.Objects;

/**
 * K线图系列配置。
 * <p />
 * 在 ECharts3 中，同时支持 'candlestick' 和 'k'这两种 'series.type'（'k' 会被自动转为 'candlestick'）。
 *
 * @author Fuchun
 * @since 1.0
 */
public class CandlestickSerie extends BaseSerie<CandlestickSerie> {

    private static final long serialVersionUID = -7415544937744830370L;

    private Integer xAxisIndex;
    private Integer yAxisIndex;
    private Boolean legendHoverLink;
    private Boolean hoverAnimation;
    private Orient layout;

    public CandlestickSerie() {
        super(ChartType.candlestick);
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

    public Orient getLayout() {
        return layout;
    }

    public void setLayout(Orient layout) {
        this.layout = layout;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CandlestickSerie)) return false;
        if (!super.equals(o)) return false;
        CandlestickSerie that = (CandlestickSerie) o;
        return Objects.equals(xAxisIndex, that.xAxisIndex) &&
                Objects.equals(yAxisIndex, that.yAxisIndex) &&
                Objects.equals(legendHoverLink, that.legendHoverLink) &&
                Objects.equals(hoverAnimation, that.hoverAnimation) &&
                layout == that.layout;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), xAxisIndex, yAxisIndex, legendHoverLink, hoverAnimation, layout);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder(32)
                .append(getClass()).append("{");
        appendPrefix(sb);
        sb.append(", coordinateSystem=").append(getCoordinateSystem());
        sb.append(", xAxisIndex=").append(xAxisIndex);
        sb.append(", yAxisIndex=").append(yAxisIndex);
        sb.append(", legendHoverLink=").append(legendHoverLink);
        sb.append(", hoverAnimation=").append(hoverAnimation);
        sb.append(", layout=").append(layout);
        sb.append(", itemStyle=").append(getItemStyle());
        sb.append(", data=").append(getData());
        appendMarks(sb);
        appendCanvasZ(sb);
        appendAnimation(sb);
        sb.append('}');
        return sb.toString();
    }
}
