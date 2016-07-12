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

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.aying.echarts.style.LineStyle;

import java.io.Serializable;
import java.util.Objects;

/**
 * 坐标轴轴线相关设置。
 *
 * @author Fuchun
 * @since 1.0
 */
public class AxisLine implements Serializable {

    private static final long serialVersionUID = -7822103350520035007L;

    private Boolean show;
    private LineStyle lineStyle;

    public AxisLine() {
        super();
    }

    @JsonCreator
    public AxisLine(
            @JsonProperty(value = "show", required = false) Boolean show,
            @JsonProperty(value = "lineStyle", required = false) LineStyle lineStyle) {
        this.show = show;
        this.lineStyle = lineStyle;
    }

    public Boolean getShow() {
        return show;
    }

    public void setShow(Boolean show) {
        this.show = show;
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
        AxisLine axisLine = (AxisLine) o;
        return Objects.equals(show, axisLine.show) &&
                Objects.equals(lineStyle, axisLine.lineStyle);
    }

    @Override
    public int hashCode() {
        return Objects.hash(show, lineStyle);
    }

    @Override
    public String toString() {
        return String.format("org.aying.echarts.axis.AxisLine{show=%s, lineStyle=%s}",
                getShow(), getLineStyle());
    }
}
