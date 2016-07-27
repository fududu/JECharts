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

import org.aying.echarts.BaseComponent;
import org.aying.echarts.style.LineStyle;
import org.aying.echarts.util.Validators;

import java.io.Serializable;
import java.util.Objects;

/**
 * 坐标轴在{@code grid} 区域中的分隔线，默认显示。
 *
 * @author Fuchun
 * @since 1.0
 */
public class SplitLine extends BaseComponent<SplitLine> implements Serializable {

    private static final long serialVersionUID = 3450169892286658700L;

    public static SplitLine showed() {
        return new SplitLine();
    }

    public static SplitLine hidden() {
        return new SplitLine(Boolean.FALSE);
    }

    private Object interval;
    private Object length;
    private LineStyle lineStyle;

    public SplitLine() {
        super();
    }

    public SplitLine(Boolean show) {
        super(show);
    }

    /**
     * 设置坐标轴分隔线的显示间隔。
     *
     * @param interval 坐标轴分隔线的显示间隔。
     * @return 当前分隔线模型。
     */
    public SplitLine interval(int interval) {
        this.interval = interval;
        return this;
    }

    /**
     * 设置分隔线样式。
     *
     * @param lineStyle 分隔线样式。
     * @return 当前分隔线模型。
     */
    public SplitLine style(LineStyle lineStyle) {
        this.lineStyle = lineStyle;
        return this;
    }

    /**
     * 设置分隔线线长。支持相对半径的百分比。
     *
     * @param length 分隔线线长（数值或百分比字符串）。
     * @return 当前分隔线模型。
     * @throws IllegalArgumentException 如果分隔线线长格式错误。
     */
    public SplitLine length(Object length) {
        this.length = Validators.checkNumber(length, "splitLine.length");
        return this;
    }

    public Object getInterval() {
        return interval;
    }

    public void setInterval(Object interval) {
        this.interval = interval;
    }

    public Object getLength() {
        return length;
    }

    public void setLength(Object length) {
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
        if (!(o instanceof SplitLine)) return false;
        if (!super.equals(o)) return false;
        SplitLine splitLine = (SplitLine) o;
        return Objects.equals(interval, splitLine.interval) &&
                Objects.equals(length, splitLine.length) &&
                Objects.equals(lineStyle, splitLine.lineStyle);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), interval, length, lineStyle);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder(32)
                .append(getClass()).append("{");
        sb.append("show=").append(getShow());
        sb.append(", interval=").append(interval);
        sb.append(", length=").append(length);
        sb.append(", lineStyle=").append(lineStyle);
        sb.append('}');
        return sb.toString();
    }
}
