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

import org.aying.echarts.style.LineStyle;

import java.io.Serializable;
import java.util.Objects;

/**
 * 坐标轴在 grid 区域中的分隔线，默认显示。
 *
 * @author Fuchun
 * @since 1.0
 */
public class SplitLine implements Serializable {

    private static final long serialVersionUID = 3450169892286658700L;
    private Boolean show;
    private Object interval;
    private LineStyle lineStyle;

    public Boolean getShow() {
        return show;
    }

    public void setShow(Boolean show) {
        this.show = show;
    }

    public Object getInterval() {
        return interval;
    }

    public void setInterval(Object interval) {
        this.interval = interval;
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
        SplitLine splitLine = (SplitLine) o;
        return Objects.equals(show, splitLine.show) &&
                Objects.equals(interval, splitLine.interval) &&
                Objects.equals(lineStyle, splitLine.lineStyle);
    }

    @Override
    public int hashCode() {
        return Objects.hash(show, interval, lineStyle);
    }

    @Override
    public String toString() {
        return String.format("org.aying.echarts.axis.SplitLine{show=%s, interval=%s, lineStyle=%s}",
                show, interval, lineStyle);
    }
}
