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
import org.aying.echarts.style.StateLineStyle;

import java.util.Objects;

/**
 * 图表标线
 *
 * @author Fuchun
 * @since 1.0
 */
public class MarkLine extends Mark<MarkLine> {

    private static final long serialVersionUID = 2380788691012243815L;

    private Integer precision;
    private StateLineStyle lineStyle;

    public MarkLine() {
        super();
    }

    @Override
    @JsonIgnore
    public Integer getSymbolRotate() {
        return null;
    }

    @Override
    @JsonIgnore
    public Object[] getSymbolOffset() {
        return null;
    }

    @Override
    public MarkLine symbolRotate(Integer rotate) {
        return this;
    }

    @Override
    public MarkLine offset(Object x, Object y) {
        return this;
    }

    public Integer getPrecision() {
        return precision;
    }

    public void setPrecision(Integer precision) {
        this.precision = precision;
    }

    public StateLineStyle getLineStyle() {
        return lineStyle;
    }

    public void setLineStyle(StateLineStyle lineStyle) {
        this.lineStyle = lineStyle;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof MarkLine)) return false;
        if (!super.equals(o)) return false;
        MarkLine markLine = (MarkLine) o;
        return Objects.equals(precision, markLine.precision) &&
                Objects.equals(lineStyle, markLine.lineStyle);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), precision, lineStyle);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder(32)
                .append(getClass()).append("{");
        sb.append("precision=").append(precision);
        sb.append(", lineStyle=").append(lineStyle);
        sb.append("} ").append(super.toString());
        return sb.toString();
    }
}
