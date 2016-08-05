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

import org.jetbrains.annotations.NotNull;

import java.io.Serializable;
import java.util.Map;
import java.util.Objects;

/**
 * The base implementation of the {@code ShadowStyle}.
 *
 * @author Fuchun
 * @since 1.0
 */
public class BaseShadowStyle<S extends BaseShadowStyle<S>> extends BaseStyle<S>
        implements ShadowStyle, Serializable {

    private static final long serialVersionUID = 1L;

    protected static <S extends BaseShadowStyle<S>> void transform(
            @NotNull S s, @NotNull Map<String, Object> map) {
        s.setColor(map.get("color"));
        s.setShadowBlur((Integer) map.get("shadowBlur"));
        s.setShadowColor((String) map.get("shadowColor"));
        s.setShadowOffsetX((Integer) map.get("shadowOffsetX"));
        s.setShadowOffsetY((Integer) map.get("shadowOffsetY"));
        s.setOpacity((Double) map.get("opacity"));
    }

    private Integer shadowBlur;
    private String shadowColor;
    private Integer shadowOffsetX;
    private Integer shadowOffsetY;
    private Double opacity;

    protected BaseShadowStyle() {
        super();
    }

    @Override
    @SuppressWarnings("unchecked")
    protected S me() {
        return (S) this;
    }

    public S shadowColor(String color) {
        this.shadowColor = color;
        return me();
    }

    public S shadowBlur(int blur) {
        this.shadowBlur = blur;
        return me();
    }

    /**
     * 设置阴影水平和垂直方向上的偏移距离。如果不需偏移，则设置为0。
     *
     * @param offsetX 阴影水平方向上的偏移距离
     * @param offsetY 阴影垂直方向上的偏移距离
     */
    public S shadowOffset(int offsetX, int offsetY) {
        this.shadowOffsetX = offsetX;
        this.shadowOffsetY = offsetY;
        return me();
    }

    public S opacity(double opacity) {
        if (Double.isInfinite(opacity)) {
            throw new IllegalArgumentException("The shape opacity value range is [0, 1]");
        }
        this.opacity = opacity;
        return me();
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
        if (!(o instanceof BaseShadowStyle)) return false;
        if (!super.equals(o)) return false;
        BaseShadowStyle that = (BaseShadowStyle) o;
        return Objects.equals(shadowBlur, that.shadowBlur) &&
                Objects.equals(shadowColor, that.shadowColor) &&
                Objects.equals(shadowOffsetX, that.shadowOffsetX) &&
                Objects.equals(shadowOffsetY, that.shadowOffsetY) &&
                Objects.equals(opacity, that.opacity);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), shadowBlur, shadowColor, shadowOffsetX, shadowOffsetY, opacity);
    }

    @Override
    protected Map<String, Object> toStringMap() {
        Map<String, Object> map = super.toStringMap();
        map.put("shadowBlur", getShadowBlur());
        map.put("shadowColor", getShadowColor());
        map.put("shadowOffsetX", getShadowOffsetX());
        map.put("shadowOffsetY", getShadowOffsetY());
        map.put("opacity", getOpacity());
        return map;
    }

    @Override
    public String toString() {
        Map<String, Object> map = toStringMap();
        StringBuilder builder = new StringBuilder(32)
                .append(getClass()).append("{");

        map.forEach((k, v) -> builder.append(k).append("=")
                .append(String.valueOf(v))
                .append(","));
        builder.deleteCharAt(builder.length() - 1);
        builder.append("}");
        return builder.toString();
    }
}
