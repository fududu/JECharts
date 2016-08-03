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

package org.aying.echarts.base;

import org.aying.echarts.style.LineStyle;
import org.aying.echarts.style.ShadowStyle;

import java.io.Serializable;
import java.util.Objects;

/**
 * 数据阴影的样式。
 *
 * @author Fuchun
 * @since 1.0
 */
public class DataBackground implements Serializable {

    private static final long serialVersionUID = -1094837092391729555L;

    private LineStyle lineStyle;
    private ShadowStyle areaStyle;

    public DataBackground() {
        super();
    }

    public DataBackground(LineStyle lineStyle, ShadowStyle areaStyle) {
        this.lineStyle = lineStyle;
        this.areaStyle = areaStyle;
    }

    public LineStyle getLineStyle() {
        return lineStyle;
    }

    public void setLineStyle(LineStyle lineStyle) {
        this.lineStyle = lineStyle;
    }

    public ShadowStyle getAreaStyle() {
        return areaStyle;
    }

    public void setAreaStyle(ShadowStyle areaStyle) {
        this.areaStyle = areaStyle;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof DataBackground)) return false;
        DataBackground that = (DataBackground) o;
        return Objects.equals(lineStyle, that.lineStyle) &&
                Objects.equals(areaStyle, that.areaStyle);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lineStyle, areaStyle);
    }

    @Override
    public String toString() {
        return "org.aying.echarts.base.DataBackground{" +
                "lineStyle=" + lineStyle +
                ", areaStyle=" + areaStyle +
                '}';
    }
}
