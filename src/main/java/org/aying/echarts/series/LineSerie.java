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
import org.aying.echarts.base.Sampling;
import org.aying.echarts.base.SimpleSymbol;
import org.aying.echarts.base.Symbol;
import org.aying.echarts.base.SymbolType;
import org.aying.echarts.style.StateLineStyle;
import org.aying.echarts.style.StateShadowStyle;

import java.util.Objects;

/**
 * 折线/面积图系列配置。
 *
 * @author Fuchun
 * @since 1.0
 */
public class LineSerie extends BaseSerie<LineSerie> implements Symbol<LineSerie> {

    private static final long serialVersionUID = -7764877237401130022L;

    private final transient SimpleSymbol simpleSymbol;

    /* 使用的 x 轴的 index，默认：0 */
    private Integer xAxisIndex;
    /* 使用的 y 轴的 index，默认：0 */
    private Integer yAxisIndex;
    /* 使用的极坐标系的 index，默认：0 */
    private Integer polarIndex;
    /* 是否显示 symbol, 只有在 tooltip hover 的时候显示。默认：true */
    private Boolean showSymbol;
    /* 标志图形默认只有主轴显示（随主轴标签间隔隐藏策略），如需全部显示可把 showAllSymbol 设为 true。 默认：false */
    private Boolean showAllSymbol;
    /* 是否开启 hover 在拐点标志上的提示动画效果。默认：true */
    private Boolean hoverAnimation;
    /* 是否启用图例 hover 时的联动高亮。默认：true */
    private Boolean legendHoverLink;
    /* 数据堆叠 */
    private String stack;
    /* 是否连接空数据。默认：false */
    private Boolean connectNulls;
    /* 是否对超出部分裁剪，默认裁剪。默认：true */
    private Boolean clipOverflow;
    /* 是否是阶梯线图。默认：false */
    private Boolean step;
    /* 线条样式。 */
    private StateLineStyle lineStyle;
    /* 区域填充样式。 */
    private StateShadowStyle areaStyle;
    /* 是否平滑曲线显示。默认：false */
    private Boolean smooth;
    /* 折线平滑后是否在一个维度上保持单调性，可以设置成'x', 'y'来指明是在 x 轴或者 y 轴上保持单调性。 */
    private String smoothMonotone;
    /* 采样策略 */
    private Sampling sampling;

    public LineSerie() {
        super(ChartType.line);
        simpleSymbol = new SimpleSymbol();
    }

    @Override
    public LineSerie symbol(SymbolType symbolType) {
        simpleSymbol.symbol(symbolType);
        return this;
    }

    @Override
    public LineSerie symbolSize(Integer size) {
        simpleSymbol.symbolSize(size);
        return this;
    }

    @Override
    public LineSerie symbolRotate(Integer rotate) {
        simpleSymbol.symbolRotate(rotate);
        return this;
    }

    @Override
    public LineSerie offset(Object x, Object y) {
        simpleSymbol.offset(x, y);
        return this;
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

    public void setSymbolOffset(Object[] symbolOffset) {
        simpleSymbol.setSymbolOffset(symbolOffset);
    }

    public Boolean getShowSymbol() {
        return showSymbol;
    }

    public void setShowSymbol(Boolean showSymbol) {
        this.showSymbol = showSymbol;
    }

    public Boolean getShowAllSymbol() {
        return showAllSymbol;
    }

    public void setShowAllSymbol(Boolean showAllSymbol) {
        this.showAllSymbol = showAllSymbol;
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

    public String getStack() {
        return stack;
    }

    public void setStack(String stack) {
        this.stack = stack;
    }

    public Boolean getConnectNulls() {
        return connectNulls;
    }

    public void setConnectNulls(Boolean connectNulls) {
        this.connectNulls = connectNulls;
    }

    public Boolean getClipOverflow() {
        return clipOverflow;
    }

    public void setClipOverflow(Boolean clipOverflow) {
        this.clipOverflow = clipOverflow;
    }

    public Boolean getStep() {
        return step;
    }

    public void setStep(Boolean step) {
        this.step = step;
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

    public Boolean getSmooth() {
        return smooth;
    }

    public void setSmooth(Boolean smooth) {
        this.smooth = smooth;
    }

    public String getSmoothMonotone() {
        return smoothMonotone;
    }

    public void setSmoothMonotone(String smoothMonotone) {
        this.smoothMonotone = smoothMonotone;
    }

    public Sampling getSampling() {
        return sampling;
    }

    public void setSampling(Sampling sampling) {
        this.sampling = sampling;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof LineSerie)) return false;
        if (!super.equals(o)) return false;
        LineSerie lineSerie = (LineSerie) o;
        return Objects.equals(simpleSymbol, lineSerie.simpleSymbol) &&
                Objects.equals(xAxisIndex, lineSerie.xAxisIndex) &&
                Objects.equals(yAxisIndex, lineSerie.yAxisIndex) &&
                Objects.equals(polarIndex, lineSerie.polarIndex) &&
                Objects.equals(showSymbol, lineSerie.showSymbol) &&
                Objects.equals(showAllSymbol, lineSerie.showAllSymbol) &&
                Objects.equals(hoverAnimation, lineSerie.hoverAnimation) &&
                Objects.equals(legendHoverLink, lineSerie.legendHoverLink) &&
                Objects.equals(stack, lineSerie.stack) &&
                Objects.equals(connectNulls, lineSerie.connectNulls) &&
                Objects.equals(clipOverflow, lineSerie.clipOverflow) &&
                Objects.equals(step, lineSerie.step) &&
                Objects.equals(lineStyle, lineSerie.lineStyle) &&
                Objects.equals(areaStyle, lineSerie.areaStyle) &&
                Objects.equals(smooth, lineSerie.smooth) &&
                Objects.equals(smoothMonotone, lineSerie.smoothMonotone) &&
                sampling == lineSerie.sampling;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), simpleSymbol, xAxisIndex, yAxisIndex,
                polarIndex, showSymbol, showAllSymbol, hoverAnimation, legendHoverLink, stack,
                connectNulls, clipOverflow, step, lineStyle, areaStyle, smooth,
                smoothMonotone, sampling);
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
        simpleSymbol.appendSymbol(sb);
        sb.append(", showSymbol=").append(showSymbol);
        sb.append(", showAllSymbol=").append(showAllSymbol);
        sb.append(", hoverAnimation=").append(hoverAnimation);
        sb.append(", legendHoverLink=").append(legendHoverLink);
        sb.append(", stack='").append(stack).append('\'');
        sb.append(", connectNulls=").append(connectNulls);
        sb.append(", clipOverflow=").append(clipOverflow);
        sb.append(", step=").append(step);
        sb.append(", label=").append(getLabel());
        sb.append(", itemStyle=").append(getItemStyle());
        sb.append(", lineStyle=").append(lineStyle);
        sb.append(", areaStyle=").append(areaStyle);
        sb.append(", smooth=").append(smooth);
        sb.append(", smoothMonotone='").append(smoothMonotone).append('\'');
        sb.append(", sampling=").append(sampling);
        sb.append(", data=").append(getData());
        appendMarks(sb);
        appendCanvasZ(sb);
        appendAnimation(sb);
        sb.append('}');
        return sb.toString();
    }
}
