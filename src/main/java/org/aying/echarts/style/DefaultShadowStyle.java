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

import java.util.Map;
import java.util.Objects;

/**
 * @author Fuchun
 * @since 1.0
 */
public class DefaultShadowStyle extends DefaultStyle implements ShadowStyle {

    private static final long serialVersionUID = 7983712349271386828L;

    private Integer shadowBlur;
    private String shadowColor;
    private Integer shadowOffsetX;
    private Integer shadowOffsetY;
    private Double opacity;

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
        if (!(o instanceof DefaultShadowStyle)) return false;
        if (!super.equals(o)) return false;
        DefaultShadowStyle that = (DefaultShadowStyle) o;
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
        StringBuilder builder = new StringBuilder(getClass().getName());
        builder.append("{");
        map.forEach((k, v) -> builder.append(k).append("=")
                .append(String.valueOf(v))
                .append(","));
        builder.deleteCharAt(builder.length() - 1);
        builder.append("}");
        return builder.toString();
    }
}
