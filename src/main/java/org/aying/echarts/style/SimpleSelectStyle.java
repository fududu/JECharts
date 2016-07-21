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

package org.aying.echarts.style;

import java.io.Serializable;
import java.util.Objects;

/**
 * The simple implementation of the {@code SelectStyle}
 *
 * @author Fuchun
 * @since 1.0
 */
public class SimpleSelectStyle extends BaseStyle<SimpleSelectStyle>
        implements SelectStyle, Serializable {

    private static final long serialVersionUID = -652359339433224779L;

    private Integer width;
    private Integer borderWidth;
    private String borderColor;
    private Double opacity;

    public SimpleSelectStyle() {
        super();
    }

    public SimpleSelectStyle width(int width) {
        this.width = width;
        return this;
    }

    public SimpleSelectStyle borderColor(String color) {
        this.borderColor = color;
        return this;
    }

    public SimpleSelectStyle borderWidth(int width) {
        this.borderWidth = width;
        return this;
    }

    public SimpleSelectStyle opacity(double opacity) {
        this.opacity = opacity;
        return this;
    }

    @Override
    public Integer getWidth() {
        return width;
    }

    public void setWidth(Integer width) {
        this.width = width;
    }

    @Override
    public Integer getBorderWidth() {
        return borderWidth;
    }

    public void setBorderWidth(Integer borderWidth) {
        this.borderWidth = borderWidth;
    }

    @Override
    public String getBorderColor() {
        return borderColor;
    }

    public void setBorderColor(String borderColor) {
        this.borderColor = borderColor;
    }

    @Override
    public Double getOpacity() {
        return opacity;
    }

    public void setOpacity(Double opacity) {
        this.opacity = opacity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof SimpleSelectStyle)) return false;
        if (!super.equals(o)) return false;
        SimpleSelectStyle that = (SimpleSelectStyle) o;
        return Objects.equals(width, that.width) &&
                Objects.equals(borderWidth, that.borderWidth) &&
                Objects.equals(borderColor, that.borderColor) &&
                Objects.equals(opacity, that.opacity);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), width, borderWidth, borderColor, opacity);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder(32)
                .append(getClass()).append("{");
        sb.append("width=").append(width);
        sb.append(", borderWidth=").append(borderWidth);
        sb.append(", borderColor='").append(borderColor).append('\'');
        sb.append(", color=").append(getColor());
        sb.append(", opacity=").append(opacity);
        sb.append("}");
        return sb.toString();
    }
}
