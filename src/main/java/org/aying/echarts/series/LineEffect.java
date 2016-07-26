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

import org.aying.echarts.base.SymbolType;

import java.io.Serializable;
import java.util.Objects;

/**
 * 线特效配置。
 *
 * @author Fuchun
 * @since 1.0
 */
public class LineEffect implements Serializable {

    private static final long serialVersionUID = 3904236249542418124L;

    public static LineEffect show() {
        return new LineEffect(Boolean.TRUE);
    }

    public static LineEffect hide() {
        return new LineEffect();
    }

    /*是否显示特效。不设置时默认：false */
    private Boolean show;
    /*特效动画的时间，单位为 s。*/
    private Integer period;
    /*配置特效图形的移动动画是否是固定速度，单位像素/秒，设置为大于 0 的值后会忽略 period 配置项。*/
    private Integer constantSpeed;
    private SymbolType symbol;
    /*特效标记的大小，可以设置成诸如 10 这样单一的数字，也可以用数组分开表示高和宽，例如 [20, 10] 表示标记宽为20，高为10。*/
    private Object symbolSize;
    /*特效标记的颜色，默认取 lineStyle.normal.color。*/
    private String color;
    /*特效尾迹的长度。取从 0 到 1 的值，数值越大尾迹越长。*/
    private Double trailLength;
    /*是否循环显示特效。不设置时默认为：true */
    private Boolean loop;

    public LineEffect() {
        super();
    }

    public LineEffect(Boolean show) {
        this.show = show;
    }

    public Boolean getShow() {
        return show;
    }

    public void setShow(Boolean show) {
        this.show = show;
    }

    public Integer getPeriod() {
        return period;
    }

    public void setPeriod(Integer period) {
        this.period = period;
    }

    public Integer getConstantSpeed() {
        return constantSpeed;
    }

    public void setConstantSpeed(Integer constantSpeed) {
        this.constantSpeed = constantSpeed;
    }

    public SymbolType getSymbol() {
        return symbol;
    }

    public void setSymbol(SymbolType symbol) {
        this.symbol = symbol;
    }

    public Object getSymbolSize() {
        return symbolSize;
    }

    public void setSymbolSize(Object symbolSize) {
        this.symbolSize = symbolSize;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Double getTrailLength() {
        return trailLength;
    }

    public void setTrailLength(Double trailLength) {
        this.trailLength = trailLength;
    }

    public Boolean getLoop() {
        return loop;
    }

    public void setLoop(Boolean loop) {
        this.loop = loop;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof LineEffect)) return false;
        LineEffect that = (LineEffect) o;
        return Objects.equals(show, that.show) &&
                Objects.equals(period, that.period) &&
                Objects.equals(constantSpeed, that.constantSpeed) &&
                symbol == that.symbol &&
                Objects.equals(symbolSize, that.symbolSize) &&
                Objects.equals(color, that.color) &&
                Objects.equals(trailLength, that.trailLength) &&
                Objects.equals(loop, that.loop);
    }

    @Override
    public int hashCode() {
        return Objects.hash(show, period, constantSpeed, symbol, symbolSize, color, trailLength, loop);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder(32)
                .append(getClass()).append("{");
        sb.append("show=").append(show);
        sb.append(", period=").append(period);
        sb.append(", constantSpeed=").append(constantSpeed);
        sb.append(", symbol=").append(symbol);
        sb.append(", symbolSize=").append(symbolSize);
        sb.append(", color='").append(color).append('\'');
        sb.append(", trailLength=").append(trailLength);
        sb.append(", loop=").append(loop);
        sb.append('}');
        return sb.toString();
    }
}
