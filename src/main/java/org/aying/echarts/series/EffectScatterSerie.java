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
import org.aying.echarts.base.SimpleSymbol;
import org.aying.echarts.base.Symbol;
import org.aying.echarts.base.SymbolType;

import java.util.Objects;

/**
 * 带有涟漪特效动画的散点（气泡）图系列配置。利用动画特效可以将某些想要突出的数据进行视觉突出。
 * <p />
 * Tip: ECharts 2.x 中在地图上通过 markPoint 实现地图特效在 ECharts 3 中建议通过地理坐标系上的 effectScatter 实现。
 *
 * @author Fuchun
 * @since 1.0
 */
public class EffectScatterSerie extends BaseSerie<EffectScatterSerie, SerieData>
        implements Symbol<EffectScatterSerie> {

    private static final long serialVersionUID = 6367722045266896974L;

    public enum EffectType {
        /** 涟漪特效 */
        ripple
    }

    public enum ShowEffectOn {
        /** 绘制完成后显示特效。*/
        render,

        /** 高亮（hover）的时候显示特效。*/
        emphasis
    }

    private final SimpleSymbol simpleSymbol;
    private Boolean legendHoverLink;
    private EffectType effectType;
    private ShowEffectOn showEffectOn;
    private RippleEffect rippleEffect;
    private Integer xAxisIndex;
    private Integer yAxisIndex;
    private Integer polarIndex;
    private Integer geoIndex;

    public EffectScatterSerie() {
        super(ChartType.effectScatter);
        effectType = EffectType.ripple;
        simpleSymbol = new SimpleSymbol();
    }

    @JsonIgnore
    protected SimpleSymbol getSimpleSymbol() {
        return simpleSymbol;
    }

    public Boolean getLegendHoverLink() {
        return legendHoverLink;
    }

    public void setLegendHoverLink(Boolean legendHoverLink) {
        this.legendHoverLink = legendHoverLink;
    }

    public EffectType getEffectType() {
        return effectType;
    }

    public void setEffectType(EffectType effectType) {
        this.effectType = effectType;
    }

    public ShowEffectOn getShowEffectOn() {
        return showEffectOn;
    }

    public void setShowEffectOn(ShowEffectOn showEffectOn) {
        this.showEffectOn = showEffectOn;
    }

    public RippleEffect getRippleEffect() {
        return rippleEffect;
    }

    public void setRippleEffect(RippleEffect rippleEffect) {
        this.rippleEffect = rippleEffect;
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

    @Override
    public SymbolType getSymbol() {
        return simpleSymbol.getSymbol();
    }

    public void setSymbol(SymbolType symbol) {
        simpleSymbol.setSymbol(symbol);
    }

    @Override
    public Object getSymbolSize() {
        return simpleSymbol.getSymbolSize();
    }

    public void setSymbolSize(Object symbolSize) {
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
    public EffectScatterSerie symbol(SymbolType symbolType) {
        simpleSymbol.symbol(symbolType);
        return this;
    }

    @Override
    public EffectScatterSerie symbolSize(Integer size) {
        simpleSymbol.symbolSize(size);
        return this;
    }

    @Override
    public EffectScatterSerie symbolSize(int w, int h) {
        simpleSymbol.symbolSize(w, h);
        return this;
    }

    @Override
    public EffectScatterSerie symbolRotate(Integer rotate) {
        simpleSymbol.symbolRotate(rotate);
        return this;
    }

    @Override
    public EffectScatterSerie offset(Object x, Object y) {
        simpleSymbol.offset(x, y);
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof EffectScatterSerie)) return false;
        if (!super.equals(o)) return false;
        EffectScatterSerie that = (EffectScatterSerie) o;
        return Objects.equals(simpleSymbol, that.simpleSymbol) &&
                Objects.equals(legendHoverLink, that.legendHoverLink) &&
                effectType == that.effectType &&
                showEffectOn == that.showEffectOn &&
                Objects.equals(rippleEffect, that.rippleEffect) &&
                Objects.equals(xAxisIndex, that.xAxisIndex) &&
                Objects.equals(yAxisIndex, that.yAxisIndex) &&
                Objects.equals(polarIndex, that.polarIndex) &&
                Objects.equals(geoIndex, that.geoIndex);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), simpleSymbol, legendHoverLink, effectType, showEffectOn,
                rippleEffect, xAxisIndex, yAxisIndex, polarIndex, geoIndex);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder(32)
                .append(getClass()).append("{");
        appendPrefix(sb);
        sb.append(", legendHoverLink=").append(legendHoverLink);
        sb.append(", effectType=").append(effectType);
        sb.append(", showEffectOn=").append(showEffectOn);
        sb.append(", rippleEffect=").append(rippleEffect);
        sb.append(", coordinateSystem=").append(getCoordinateSystem());
        sb.append(", xAxisIndex=").append(xAxisIndex);
        sb.append(", yAxisIndex=").append(yAxisIndex);
        sb.append(", polarIndex=").append(polarIndex);
        sb.append(", geoIndex=").append(geoIndex);
        simpleSymbol.appendSymbol(sb);
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
