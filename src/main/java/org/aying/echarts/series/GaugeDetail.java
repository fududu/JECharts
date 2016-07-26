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

import java.io.Serializable;
import java.util.Arrays;
import java.util.Objects;

/**
 * 仪表盘详情，用于显示数据。
 *
 * @author Fuchun
 * @since 1.0
 */
public class GaugeDetail extends GaugePart implements Serializable {

    private static final long serialVersionUID = -3132500083715544360L;

    private Integer height;
    private String backgroundColor;
    private Integer borderWidth;
    private String borderColor;

    public GaugeDetail() {
        super();
    }

    public Integer getHeight() {
        return height;
    }

    public void setHeight(Integer height) {
        this.height = height;
    }

    public String getBackgroundColor() {
        return backgroundColor;
    }

    public void setBackgroundColor(String backgroundColor) {
        this.backgroundColor = backgroundColor;
    }

    public Integer getBorderWidth() {
        return borderWidth;
    }

    public void setBorderWidth(Integer borderWidth) {
        this.borderWidth = borderWidth;
    }

    public String getBorderColor() {
        return borderColor;
    }

    public void setBorderColor(String borderColor) {
        this.borderColor = borderColor;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof GaugeDetail)) return false;
        if (!super.equals(o)) return false;
        GaugeDetail that = (GaugeDetail) o;
        return Objects.equals(height, that.height) &&
                Objects.equals(backgroundColor, that.backgroundColor) &&
                Objects.equals(borderWidth, that.borderWidth) &&
                Objects.equals(borderColor, that.borderColor);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), height, backgroundColor, borderWidth, borderColor);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder(32)
                .append(getClass()).append("{");
        sb.append("show=").append(getShow());
        sb.append(", width=").append(getWidth());
        sb.append(", height=").append(height);
        sb.append(", backgroundColor='").append(backgroundColor).append('\'');
        sb.append(", borderWidth=").append(borderWidth);
        sb.append(", borderColor='").append(borderColor).append('\'');
        sb.append(", offsetCenter=").append(Arrays.toString(getOffsetCenter()));
        sb.append(", textStyle=").append(getTextStyle());
        sb.append('}');
        return sb.toString();
    }
}
