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

import org.aying.echarts.style.BaseStyle;

import java.io.Serializable;
import java.time.format.TextStyle;
import java.util.Objects;

/**
 * 坐标轴刻度标签的相关设置。
 *
 * @author Fuchun
 * @since 1.0
 */
public class AxisLabel extends BaseStyle<AxisLabel> implements Serializable {

    private static final long serialVersionUID = 8861673945986361136L;

    /* 是否显示刻度标签。 */
    private Boolean show;
    /* 坐标轴刻度标签的显示间隔，在类目轴中有效。 */
    private Object interval;
    /*标签与刻度线的距离。*/
    private Integer distance;
    /* 刻度标签是否朝内，默认朝外。 */
    private Boolean inside;
    /* 刻度标签与轴线之间的距离。 */
    private Integer margin;
    /* 刻度标签的内容格式器，支持字符串模板和回调函数两种形式。 */
    private Object formatter;
    /* 刻度标签文字样式 */
    private TextStyle textStyle;

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

    public Integer getDistance() {
        return distance;
    }

    public void setDistance(Integer distance) {
        this.distance = distance;
    }

    public Boolean getInside() {
        return inside;
    }

    public void setInside(Boolean inside) {
        this.inside = inside;
    }

    public Integer getMargin() {
        return margin;
    }

    public void setMargin(Integer margin) {
        this.margin = margin;
    }

    public Object getFormatter() {
        return formatter;
    }

    public void setFormatter(Object formatter) {
        this.formatter = formatter;
    }

    public TextStyle getTextStyle() {
        return textStyle;
    }

    public void setTextStyle(TextStyle textStyle) {
        this.textStyle = textStyle;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof AxisLabel)) return false;
        if (!super.equals(o)) return false;
        AxisLabel axisLabel = (AxisLabel) o;
        return Objects.equals(show, axisLabel.show) &&
                Objects.equals(interval, axisLabel.interval) &&
                Objects.equals(distance, axisLabel.distance) &&
                Objects.equals(inside, axisLabel.inside) &&
                Objects.equals(margin, axisLabel.margin) &&
                Objects.equals(formatter, axisLabel.formatter) &&
                textStyle == axisLabel.textStyle;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), show, interval, distance, inside, margin, formatter, textStyle);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder(32)
                .append(getClass()).append("{");
        sb.append("show=").append(show);
        sb.append(", interval=").append(interval);
        sb.append(", distance=").append(distance);
        sb.append(", inside=").append(inside);
        sb.append(", margin=").append(margin);
        sb.append(", formatter=").append(formatter);
        sb.append(", textStyle=").append(textStyle);
        sb.append('}');
        return sb.toString();
    }
}
