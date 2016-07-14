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
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import org.aying.echarts.util.CollectionUtils;

import java.io.Serializable;
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
@JsonPropertyOrder({
        "symbol", "symbolSize", "color", "colorAlpha", "opacity",
        "colorLightness", "colorSaturation", "colorHue"
})
public class VisualRange implements Serializable {

    private static final long serialVersionUID = 2284641276223341394L;

    public static VisualRange start() {
        return new VisualRange();
    }

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

    protected void checkRange(double min, double max, double value) {
        if (value < min || value > max) {
            throw new IllegalArgumentException(String.format(
                    "The value(%s) range must be [%s, %s]", value, min, max));
        }
    }

    public VisualRange symbol(String symbol) {
        this.symbol = CollectionUtils.single("symbol", symbol);
        return this;
    }

    public VisualRange symbol(String s1, String s2, String... sn) {
        this.symbol = CollectionUtils.linkedList("symbol", s1, s2, sn);
        return this;
    }

    public VisualRange symbolSize(int s1, int s2, int... sn) {
        this.symbolSize = CollectionUtils.linkedList("symbolSize",
                s1, s2, CollectionUtils.inbox(sn));
        return this;
    }

    public VisualRange color(String color) {
        return color(color, color);
    }

    public VisualRange color(String c1, String c2, String... cn) {
        this.color = CollectionUtils.linkedList("color", c1, c2, cn);
        return this;
    }

    public VisualRange opacity(double o1, double o2, double... on) {
        checkRange(0, 1, o1);
        checkRange(0, 1, o2);
        this.opacity = CollectionUtils.linkedList("opacity",
                o1, o2, CollectionUtils.inbox(on));
        return this;
    }

    public VisualRange colorLightness(double c1, double c2, double... cn) {
        checkRange(0, 1, c1);
        checkRange(0, 1, c2);
        this.colorLightness = CollectionUtils.linkedList("colorLightness",
                c1, c2, CollectionUtils.inbox(cn));
        return this;
    }

    public VisualRange colorSaturation(double c1, double c2, double... cn) {
        checkRange(0, 1, c1);
        checkRange(0, 1, c2);
        this.colorSaturation = CollectionUtils.linkedList("colorSaturation",
                c1, c2, CollectionUtils.inbox(cn));
        return this;
    }

    public VisualRange colorHue(int h1, int h2, int... hn) {
        checkRange(0, 360, h1);
        checkRange(0, 360, h2);
        this.colorHue = CollectionUtils.linkedList("colorHue",
                h1, h2, CollectionUtils.inbox(hn));
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
        return String.format(
                "org.aying.echarts.VisualRange{symbol=%s, symbolSize=%s, color=%s, colorAlpha=%s, " +
                        "opacity=%s, colorLightness=%s, colorSaturation=%s, colorHue=%s}",
                symbol, symbolSize, color, colorAlpha, opacity, colorLightness, colorSaturation, colorHue);
    }
}
