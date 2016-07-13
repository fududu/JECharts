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

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/**
 * 视觉元素范围定义。
 *
 * @author Fuchun
 * @since 1.0
 */
public class VisualRange implements Serializable {

    private static final long serialVersionUID = 2284641276223341394L;

    /* 图元的图形类别。 */
    private List<String> symbol;
    /* 图元的大小。 */
    private List<Integer> symbolSize;
    /* 图元的颜色。可能的类型：List|Map<String, String> */
    private Object color;
    /* 图元的颜色的透明度。 */
    private List<Double> colorAlpha;
    /* 图元以及其附属物（如文字标签）的透明度。 */
    private List<Double> opacity;
    /* 颜色的明暗度，参见 HSL。 */
    private List<Double> colorLightness;
    /* 颜色的饱和度，参见 HSL。 */
    private List<Double> colorSaturation;
    /*  颜色的色调，参见 HSL。 取值范围：[0, 360] */
    private List<Integer> colorHue;

    public VisualRange() {
        super();
    }

    public VisualRange symbol(String symbol) {
        LinkedList<String> list = new LinkedList<>();
        list.add(symbol);
        this.symbol = list;
        return this;
    }

    public VisualRange symbol(String s1, String s2, String... sn) {
        Objects.requireNonNull(s1, "First symbol");
        Objects.requireNonNull(s2, "second symbol");
        LinkedList<String> list = new LinkedList<>();
        list.add(s1);
        list.add(s2);
        if (sn != null && sn.length > 0) {
            Collections.addAll(list, sn);
        }
        this.symbol = list;
        return this;
    }

    public VisualRange color(String color) {
        Objects.requireNonNull(color, "color");
        LinkedList<String> list = new LinkedList<>();
        list.add(color);
        list.add(color);
        this.color = list;
        return this;
    }

    public VisualRange color(String c1, String c2, String... cn) {
        Objects.requireNonNull(c1, "First color");
        Objects.requireNonNull(c2, "second color");
        LinkedList<String> colorList = new LinkedList<>();
        colorList.add(c1);
        colorList.add(c2);
        if (cn != null && cn.length > 0) {
            Collections.addAll(colorList, cn);
        }
        setColor(colorList);
        return this;
    }

    public List<String> getSymbol() {
        return symbol;
    }

    public void setSymbol(List<String> symbol) {
        this.symbol = symbol;
    }

    public List<Integer> getSymbolSize() {
        return symbolSize;
    }

    public void setSymbolSize(List<Integer> symbolSize) {
        this.symbolSize = symbolSize;
    }

    @JsonProperty(required = false)
    public Object getColor() {
        return color;
    }

    @SuppressWarnings("unchecked")
    public void setColor(Object color) {
        if (color == null) {
            this.color = null;
        } else if (color instanceof String) {
            List<String> list = new LinkedList<>();
            list.add((String) color);
            list.add((String) color);
            this.color = list;
        } else if (color instanceof List) {
            if (((List) color).isEmpty()) {
                this.color = null;
            } else {
                this.color = new LinkedList<>((List<String>) color);
            }
        } else if (color instanceof Map) {
            if (((Map) color).isEmpty()) {
                this.color = null;
            } else {
                this.color = new LinkedHashMap<>((Map<String, String>) color);
            }
        } else {
            throw new IllegalArgumentException("Unsupported color data: " +
                    color.getClass());
        }
    }

    @JsonProperty(required = false)
    public List<Double> getColorAlpha() {
        return colorAlpha;
    }

    public void setColorAlpha(List<Double> colorAlpha) {
        if (colorAlpha == null || colorAlpha.isEmpty()) {
            this.colorAlpha = null;
        } else {
            this.colorAlpha = new LinkedList<>(colorAlpha);
        }
    }

    @JsonProperty(required = false)
    public List<Double> getOpacity() {
        return opacity;
    }

    public void setOpacity(List<Double> opacity) {
        if (opacity == null || opacity.isEmpty()) {
            this.opacity = null;
        } else {
            this.opacity = new LinkedList<>(opacity);
        }
    }

    public List<Double> getColorLightness() {
        return colorLightness;
    }

    public void setColorLightness(List<Double> colorLightness) {
        if (colorLightness == null || colorLightness.isEmpty()) {
            this.colorLightness = null;
        } else {
            this.colorLightness = new LinkedList<>(colorLightness);
        }
    }

    public Object getColorSaturation() {
        return colorSaturation;
    }

    public void setColorSaturation(List<Double> colorSaturation) {
        if (colorSaturation == null || colorSaturation.isEmpty()) {
            this.colorSaturation = null;
        } else {
            this.colorSaturation = new LinkedList<>(colorSaturation);
        }
    }

    public List<Integer> getColorHue() {
        return colorHue;
    }

    public void setColorHue(List<Integer> colorHue) {
        if (colorHue == null || colorHue.isEmpty()) {
            this.colorHue = null;
        } else {
            this.colorHue = new LinkedList<>(colorHue);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof VisualRange)) return false;
        VisualRange that = (VisualRange) o;
        return Objects.equals(symbol, that.symbol) &&
                Objects.equals(symbolSize, that.symbolSize) &&
                Objects.equals(color, that.color) &&
                Objects.equals(colorAlpha, that.colorAlpha) &&
                Objects.equals(opacity, that.opacity) &&
                Objects.equals(colorLightness, that.colorLightness) &&
                Objects.equals(colorSaturation, that.colorSaturation) &&
                Objects.equals(colorHue, that.colorHue);
    }

    @Override
    public int hashCode() {
        return Objects.hash(symbol, symbolSize, color, colorAlpha,
                opacity, colorLightness, colorSaturation, colorHue);
    }

    @Override
    public String toString() {
        return "org.aying.echarts.VisualRange{" +
                "symbol=" + symbol +
                ", symbolSize=" + symbolSize +
                ", color=" + color +
                ", colorAlpha=" + colorAlpha +
                ", opacity=" + opacity +
                ", colorLightness=" + colorLightness +
                ", colorSaturation=" + colorSaturation +
                ", colorHue=" + colorHue +
                '}';
    }
}
