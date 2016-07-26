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
import org.aying.echarts.base.SimpleSymbol;
import org.aying.echarts.base.Symbol;
import org.aying.echarts.base.SymbolType;
import org.aying.echarts.style.StateLineStyle;
import org.aying.echarts.style.StateShadowStyle;

import java.util.Objects;

/**
 * 雷达图系列配置。
 * <p />
 * 雷达图主要用于表现多变量的数据，例如球员的各个属性分析。依赖{@code radar} 组件。
 *
 * @author Fuchun
 * @since 1.0
 */
public class RadarSerie extends BaseSerie<RadarSerie>
        implements Symbol<RadarSerie> {

    private static final long serialVersionUID = -761601048686030067L;

    private final SimpleSymbol simpleSymbol;
    /*雷达图所使用的 radar 组件的 index。*/
    private Integer radarIndex;
    /*线条样式*/
    private StateLineStyle lineStyle;
    /*区域填充样式。*/
    private StateShadowStyle areaStyle;

    public RadarSerie() {
        super(ChartType.radar);
        simpleSymbol = new SimpleSymbol();
    }

    @Override
    @JsonIgnore
    public CoordinateSystem getCoordinateSystem() {
        return super.getCoordinateSystem();
    }

    public Integer getRadarIndex() {
        return radarIndex;
    }

    public void setRadarIndex(Integer radarIndex) {
        this.radarIndex = radarIndex;
    }

    public StateLineStyle getLineStyle() {
        return lineStyle;
    }

    public void setLineStyle(StateLineStyle lineStyle) {
        this.lineStyle = lineStyle;
    }

    public StateShadowStyle getAreaStyle() {
        return areaStyle;
    }

    public void setAreaStyle(StateShadowStyle areaStyle) {
        this.areaStyle = areaStyle;
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
    public RadarSerie symbol(SymbolType symbolType) {
        simpleSymbol.symbol(symbolType);
        return this;
    }

    @Override
    public RadarSerie symbolSize(Integer size) {
        simpleSymbol.symbolSize(size);
        return this;
    }

    @Override
    public RadarSerie symbolRotate(Integer rotate) {
        simpleSymbol.symbolRotate(rotate);
        return this;
    }

    @Override
    public RadarSerie offset(Object x, Object y) {
        simpleSymbol.offset(x, y);
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof RadarSerie)) return false;
        if (!super.equals(o)) return false;
        RadarSerie that = (RadarSerie) o;
        return Objects.equals(simpleSymbol, that.simpleSymbol) &&
                Objects.equals(radarIndex, that.radarIndex) &&
                Objects.equals(lineStyle, that.lineStyle) &&
                Objects.equals(areaStyle, that.areaStyle);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), simpleSymbol, radarIndex, lineStyle, areaStyle);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder(32)
                .append(getClass()).append("{");
        appendPrefix(sb);
        sb.append(", radarIndex=").append(radarIndex);
        simpleSymbol.appendSymbol(sb);
        sb.append(", label=").append(getLabel());
        sb.append(", itemStyle=").append(getItemStyle());
        sb.append(", lineStyle=").append(lineStyle);
        sb.append(", areaStyle=").append(areaStyle);
        sb.append(", data=").append(getData());
        appendCanvasZ(sb);
        appendAnimation(sb);
        sb.append('}');
        return sb.toString();
    }
}
