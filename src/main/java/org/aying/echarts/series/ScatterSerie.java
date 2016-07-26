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
import org.aying.echarts.base.SimpleSymbol;
import org.aying.echarts.base.Symbol;
import org.aying.echarts.base.SymbolType;

import java.util.Objects;

/**
 * 散点（气泡）图系列配置。
 * <p />
 * 直角坐标系上的散点图可以用来展现数据的{@code x，y} 之间的关系，如果数据项有多个维度，其它维度的值可以通过不同大小的
 * {@code symbol} 展现成气泡图，也可以用颜色来表现。这些可以配合{@code visualMap} 组件完成。
 *
 * @author Fuchun
 * @since 1.0
 */
public class ScatterSerie extends BaseSerie<ScatterSerie>
        implements Symbol<ScatterSerie> {

    private static final long serialVersionUID = 153777447599227362L;

    private final SimpleSymbol simpleSymbol;
    private Integer xAxisIndex;
    private Integer yAxisIndex;
    private Integer polarIndex;
    private Integer geoIndex;
    /*是否开启鼠标 hover 的提示动画效果。*/
    private Boolean hoverAnimation;
    /*是否启用图例 hover 时的联动高亮。*/
    private Boolean legendHoverLink;
    /*是否开启大规模散点图的优化*/
    private Boolean large;
    /*开启绘制优化的阈值。*/
    private Integer largeThreshold;

    public ScatterSerie() {
        super(ChartType.scatter);
        this.simpleSymbol = new SimpleSymbol();
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

    public Integer getPolarIndex() {
        return polarIndex;
    }

    public void setPolarIndex(Integer polarIndex) {
        this.polarIndex = polarIndex;
    }

    public Integer getGeoIndex() {
        return geoIndex;
    }

    public void setGeoIndex(Integer geoIndex) {
        this.geoIndex = geoIndex;
    }

    public Boolean getHoverAnimation() {
        return hoverAnimation;
    }

    public void setHoverAnimation(Boolean hoverAnimation) {
        this.hoverAnimation = hoverAnimation;
    }

    public Boolean getLegendHoverLink() {
        return legendHoverLink;
    }

    public void setLegendHoverLink(Boolean legendHoverLink) {
        this.legendHoverLink = legendHoverLink;
    }

    @Override
    public SymbolType getSymbol() {
        return simpleSymbol.getSymbol();
    }

    public void setSymbol(SymbolType symbol) {
        simpleSymbol.setSymbol(symbol);
    }

    @Override
    public Integer getSymbolSize() {
        return simpleSymbol.getSymbolSize();
    }

    public void setSymbolSize(Integer symbolSize) {
        simpleSymbol.setSymbolSize(symbolSize);
    }

    @Override
    public Integer getSymbolRotate() {
        return simpleSymbol.getSymbolRotate();
    }

    public void setSymbolRotate(Integer symbolRotate) {
        simpleSymbol.setSymbolRotate(symbolRotate);
    }

    @Override
    public Object[] getSymbolOffset() {
        return simpleSymbol.getSymbolOffset();
    }

    public void setSymbolOffset(Object[] offset) {
        simpleSymbol.setSymbolOffset(offset);
    }

    @Override
    public ScatterSerie symbol(SymbolType symbolType) {
        simpleSymbol.symbol(symbolType);
        return this;
    }

    @Override
    public ScatterSerie symbolSize(Integer size) {
        simpleSymbol.symbolSize(size);
        return this;
    }

    @Override
    public ScatterSerie symbolRotate(Integer rotate) {
        simpleSymbol.symbolRotate(rotate);
        return this;
    }

    @Override
    public ScatterSerie offset(Object x, Object y) {
        simpleSymbol.offset(x, y);
        return this;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ScatterSerie)) return false;
        if (!super.equals(o)) return false;
        ScatterSerie that = (ScatterSerie) o;
        return Objects.equals(simpleSymbol, that.simpleSymbol) &&
                Objects.equals(xAxisIndex, that.xAxisIndex) &&
                Objects.equals(yAxisIndex, that.yAxisIndex) &&
                Objects.equals(polarIndex, that.polarIndex) &&
                Objects.equals(geoIndex, that.geoIndex) &&
                Objects.equals(hoverAnimation, that.hoverAnimation) &&
                Objects.equals(legendHoverLink, that.legendHoverLink) &&
                Objects.equals(large, that.large) &&
                Objects.equals(largeThreshold, that.largeThreshold);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), simpleSymbol, xAxisIndex, yAxisIndex,
                polarIndex, geoIndex, hoverAnimation, legendHoverLink, large, largeThreshold);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder(32)
                .append(getClass()).append("{");
        appendPrefix(sb);
        sb.append(", coordinateSystem=").append(getCoordinateSystem());
        sb.append(", xAxisIndex=").append(xAxisIndex);
        sb.append(", yAxisIndex=").append(yAxisIndex);
        sb.append(", polarIndex=").append(polarIndex);
        sb.append(", geoIndex=").append(geoIndex);
        sb.append(", hoverAnimation=").append(hoverAnimation);
        sb.append(", legendHoverLink=").append(legendHoverLink);
        simpleSymbol.appendSymbol(sb);
        sb.append(", large=").append(large);
        sb.append(", largeThreshold=").append(largeThreshold);
        sb.append(", label=").append(getLabel());
        sb.append(", itemStyle=").append(getItemStyle());
        sb.append(", data=").append(getData());
        appendMarks(sb);
        appendCanvasZ(sb);
        appendAnimation(sb);
        sb.append('}');
        return sb.toString();
    }
}
