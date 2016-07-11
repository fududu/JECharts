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

import org.aying.echarts.base.LineType;

import java.util.Objects;

/**
 * @author Fuchun
 * @since 1.0
 */
public class DefaultLineStyle extends DefaultStyle implements LineStyle {

    private static final long serialVersionUID = -7035070045694988070L;

    private Integer width;
    private LineType type;
    private Integer shadowBlur;
    private String shadowColor;
    private Integer shadowOffsetX;
    private Integer shadowOffsetY;
    private Double opacity;

    @Override
    public Integer getWidth() {
        return width;
    }

    public void setWidth(Integer width) {
        this.width = width;
    }

    public LineType getType() {
        return type;
    }

    public void setType(LineType type) {
        this.type = type;
    }

    @Override
    public Integer getShadowBlur() {
        return shadowBlur;
    }

    public void setShadowBlur(Integer shadowBlur) {
        this.shadowBlur = shadowBlur;
    }

    @Override
    public String getShadowColor() {
        return shadowColor;
    }

    public void setShadowColor(String shadowColor) {
        this.shadowColor = shadowColor;
    }

    @Override
    public Integer getShadowOffsetX() {
        return shadowOffsetX;
    }

    public void setShadowOffsetX(Integer shadowOffsetX) {
        this.shadowOffsetX = shadowOffsetX;
    }

    @Override
    public Integer getShadowOffsetY() {
        return shadowOffsetY;
    }

    public void setShadowOffsetY(Integer shadowOffsetY) {
        this.shadowOffsetY = shadowOffsetY;
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
        if (!(o instanceof DefaultLineStyle)) return false;
        if (!super.equals(o)) return false;
        DefaultLineStyle that = (DefaultLineStyle) o;
        return Objects.equals(width, that.width) &&
                type == that.type &&
                Objects.equals(shadowBlur, that.shadowBlur) &&
                Objects.equals(shadowColor, that.shadowColor) &&
                Objects.equals(shadowOffsetX, that.shadowOffsetX) &&
                Objects.equals(shadowOffsetY, that.shadowOffsetY) &&
                Objects.equals(opacity, that.opacity);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), width, type, shadowBlur, shadowColor, shadowOffsetX, shadowOffsetY, opacity);
    }

    @Override
    public String toString() {
        return String.format("org.aying.echarts.style.DefaultLineStyle{width=%s, type=%s, shadowBlur=%s, " +
                "shadowColor='%s', shadowOffsetX=%s, shadowOffsetY=%s, opacity=%s}",
                width, type, shadowBlur, shadowColor, shadowOffsetX, shadowOffsetY, opacity);
    }


}
