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

import org.aying.echarts.style.StateShadowStyle;

import java.util.Objects;

/**
 * @author Fuchun
 * @since 1.0
 */
public class RadarSerieData extends SerieData {

    private static final long serialVersionUID = 4174566153728782412L;
    private StateShadowStyle areaStyle;

    public RadarSerieData() {
        super();
    }

    public StateShadowStyle getAreaStyle() {
        return areaStyle;
    }

    public void setAreaStyle(StateShadowStyle areaStyle) {
        this.areaStyle = areaStyle;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof RadarSerieData)) return false;
        if (!super.equals(o)) return false;
        RadarSerieData that = (RadarSerieData) o;
        return Objects.equals(areaStyle, that.areaStyle);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), areaStyle);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder(32)
                .append(getClass()).append("{");
        sb.append("areaStyle=").append(areaStyle);
        sb.append("} ").append(super.toString());
        return sb.toString();
    }
}
