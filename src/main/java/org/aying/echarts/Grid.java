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

package org.aying.echarts;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.aying.echarts.base.LineType;
import org.aying.echarts.base.SizeGraph;
import org.aying.echarts.style.ShapeStyle;
import org.aying.echarts.style.SimpleShapeStyle;
import org.aying.echarts.style.TextStyle;

import java.util.Objects;

/**
 * ECharts 网络选项模型。
 * 直角坐标系内绘图网格，单个 grid 内最多可以放置上下两个 X 轴，左右两个 Y 轴。
 *
 * @author Fuchun
 * @since 1.0
 */
public class Grid extends SizeGraph<Grid>
        implements Component<Grid>, ShapeStyle {

    private static final long serialVersionUID = 7959187036320536290L;

    private final SimpleShapeStyle sss;

    private Boolean show;
    private Boolean containLabel;

    public Grid() {
        super();
        sss = new SimpleShapeStyle();
    }

    @Override
    public Boolean getShow() {
        return show;
    }

    @Override
    public void setShow(Boolean show) {
        this.show = show;
    }

    @Override
    public Grid hide() {
        this.show = Boolean.FALSE;
        return this;
    }

    @Override
    public Grid show() {
        this.show = Boolean.TRUE;
        return this;
    }

    public Boolean getContainLabel() {
        return containLabel;
    }

    public void setContainLabel(Boolean containLabel) {
        this.containLabel = containLabel;
    }

    @Override
    @JsonIgnore
    public String getColor() {
        return null;
    }

    @Override
    @SuppressWarnings("unchecked")
    public Grid color(String color) {
        return this;
    }

    @JsonProperty(required = false)
    public String getBackgroundColor() {
        return sss.getBackgroundColor();
    }

    public void setBackgroundColor(String backgroundColor) {
        sss.setBackgroundColor(backgroundColor);
    }

    @JsonProperty(required = false)
    public String getBorderColor() {
        return sss.getBorderColor();
    }

    public void setBorderColor(String borderColor) {
        sss.setBorderColor(borderColor);
    }

    @JsonProperty(required = false)
    public Integer getBorderWidth() {
        return sss.getBorderWidth();
    }

    public void setBorderWidth(Integer borderWidth) {
        sss.setBorderWidth(borderWidth);
    }

    @Override
    @JsonIgnore
    public LineType getBorderType() {
        return null;
    }

    @JsonProperty(required = false)
    public Integer getShadowBlur() {
        return sss.getShadowBlur();
    }

    public void setShadowBlur(Integer shadowBlur) {
        sss.setShadowBlur(shadowBlur);
    }

    @JsonProperty(required = false)
    public String getShadowColor() {
        return sss.getShadowColor();
    }

    public void setShadowColor(String shadowColor) {
        sss.setShadowColor(shadowColor);
    }

    @JsonProperty(required = false)
    public Integer getShadowOffsetX() {
        return sss.getShadowOffsetX();
    }

    public void setShadowOffsetX(Integer shadowOffsetX) {
        sss.setShadowOffsetX(shadowOffsetX);
    }

    @JsonProperty(required = false)
    public Integer getShadowOffsetY() {
        return sss.getShadowOffsetY();
    }

    public void setShadowOffsetY(Integer shadowOffsetY) {
        sss.setShadowOffsetY(shadowOffsetY);
    }

    @Override
    @JsonIgnore
    public Double getOpacity() {
        return null;
    }

    @Override
    @JsonIgnore
    public TextStyle getTextStyle() {
        return null;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Grid)) return false;
        if (!super.equals(o)) return false;
        Grid grid = (Grid) o;
        return Objects.equals(sss, grid.sss) &&
                Objects.equals(show, grid.show) &&
                Objects.equals(containLabel, grid.containLabel);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), sss, show, containLabel);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder(32)
                .append(getClass()).append("{");
        sb.append("show=").append(show);
        appendSizeGraph(sb);
        sb.append(", containLabel=").append(getContainLabel());
        sb.append(", backgroundColor='").append(getBackgroundColor()).append('\'');
        sb.append(", borderColor='").append(getBorderColor()).append('\'');
        sb.append(", borderWidth=").append(getBorderWidth());
        sb.append(", shadowBlur=").append(getShadowBlur());
        sb.append(", shadowColor='").append(getShadowColor()).append('\'');
        sb.append(", shadowOffsetX=").append(getShadowOffsetX());
        sb.append(", shadowOffsetY=").append(getShadowOffsetY());
        sb.append('}');
        return sb.toString();
    }
}
