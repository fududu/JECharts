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

import com.fasterxml.jackson.annotation.JsonProperty;
import org.aying.echarts.BaseComponent;
import org.aying.echarts.style.LineStyle;

import java.io.Serializable;
import java.util.Objects;

/**
 * 坐标轴轴线相关设置。
 *
 * @author Fuchun
 * @since 1.0
 */
public class AxisLine extends BaseComponent<AxisLine> implements Serializable {

    private static final long serialVersionUID = -7822103350520035007L;

    public static AxisLine showed() {
        return new AxisLine();
    }

    public static AxisLine showed(LineStyle lineStyle) {
        AxisLine line = new AxisLine();
        line.setLineStyle(lineStyle);
        return line;
    }

    public static AxisLine hidden() {
        return new AxisLine(Boolean.FALSE);
    }

    private Boolean onZero;
    private LineStyle lineStyle;

    public AxisLine() {
        super();
    }

    public AxisLine(Boolean show) {
        super(show);
    }

    @JsonProperty(required = false)
    public Boolean getOnZero() {
        return onZero;
    }

    public void setOnZero(Boolean onZero) {
        this.onZero = onZero;
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
        if (!(o instanceof AxisLine)) return false;
        if (!super.equals(o)) return false;
        AxisLine axisLine = (AxisLine) o;
        return Objects.equals(onZero, axisLine.onZero) &&
                Objects.equals(lineStyle, axisLine.lineStyle);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), onZero, lineStyle);
    }

    @Override
    public String toString() {
        return String.format("org.aying.echarts.axis.AxisLine{show=%s, onZero=%s, lineStyle=%s}",
                getShow(), String.valueOf(onZero), getLineStyle());
    }
}
