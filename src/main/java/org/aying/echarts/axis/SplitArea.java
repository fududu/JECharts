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
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import org.aying.echarts.style.ShadowStyle;
import org.aying.echarts.style.SimpleShadowStyle;

import java.io.Serializable;
import java.util.Objects;

/**
 * 坐标轴在 grid 区域中的分隔区域。
 *
 * @author Fuchun
 * @since 1.0
 */
public class SplitArea implements Serializable {

    private static final long serialVersionUID = 6896512610727255610L;

    /*是否显示分隔区域。*/
    private Boolean show;
    /* 坐标轴分隔区域的显示间隔，在类目轴中有效。默认同 axisLabel.interval 一样。
     * 默认会采用标签不重叠的策略间隔显示标签。类型：Integer | Function
     */
    private Object interval;
    /*区域填充样式。*/
    private ShadowStyle areaStyle;

    @JsonProperty(required = false)
    public Boolean getShow() {
        return show;
    }

    public void setShow(Boolean show) {
        this.show = show;
    }

    @JsonProperty(required = false)
    public Object getInterval() {
        return interval;
    }

    public void setInterval(Object interval) {
        this.interval = interval;
    }

    @JsonProperty(required = false)
    @JsonSerialize
    @JsonDeserialize(as = SimpleShadowStyle.class)
    public ShadowStyle getAreaStyle() {
        return areaStyle;
    }

    public void setAreaStyle(ShadowStyle areaStyle) {
        this.areaStyle = areaStyle;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof SplitArea)) return false;
        SplitArea splitArea = (SplitArea) o;
        return Objects.equals(show, splitArea.show) &&
                Objects.equals(interval, splitArea.interval) &&
                Objects.equals(areaStyle, splitArea.areaStyle);
    }

    @Override
    public int hashCode() {
        return Objects.hash(show, interval, areaStyle);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder(32)
                .append(getClass()).append("{");
        sb.append("show=").append(show);
        sb.append(", interval=").append(interval);
        sb.append(", areaStyle=").append(areaStyle);
        sb.append('}');
        return sb.toString();
    }
}
