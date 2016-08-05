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

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.aying.echarts.base.Align;
import org.aying.echarts.base.Baseline;
import org.aying.echarts.style.font.FontStyle;
import org.aying.echarts.style.font.FontWeight;
import org.intellij.lang.annotations.MagicConstant;

import java.util.Arrays;
import java.util.Map;
import java.util.Objects;

import static org.aying.echarts.style.font.FontWeight.*;

/**
 * {@link TextStyle} 的默认实现。
 *
 * @author Fuchun
 * @since 1.0
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class SimpleTextStyle extends BaseStyle<SimpleTextStyle> implements TextStyle {

    private static final long serialVersionUID = -7037742340818566884L;

    public static SimpleTextStyle convert(Map<String, Object> map) {
        if (map == null || map.isEmpty()) {
            return null;
        }
        return new SimpleTextStyle(map);
    }

    private Align align;
    private Baseline baseline;
    private FontStyle fontStyle;
    private Object fontWeight;
    private String fontFamily;
    private Integer fontSize;

    public SimpleTextStyle() {
        super();
    }

    public SimpleTextStyle(Map<String, Object> map) {
        super();
        initFromMap(map);
    }

    public SimpleTextStyle(FontStyle fontStyle, Object fontWeight, Integer fontSize, String fontFamily) {
        this.fontStyle = fontStyle;
        this.fontWeight = fontWeight;
        this.fontSize = fontSize;
        this.fontFamily = fontFamily;
    }

    protected void initFromMap(Map<String, Object> map) {
        if (map == null || map.isEmpty()) return;
        String color = (String) map.get("color");
        Object oAlign = map.get("align");
        Object oBaseline = map.get("baseline");
        Object oFontStyle = map.get("fontStyle");
        Object oFontWeight = map.get("fontWeight");
        String fontFamily = (String) map.get("fontFamily");
        Integer fontSize = (Integer) map.get("fontSize");

        this.color = color;
        this.align = Align.of(oAlign, null);
        this.baseline = Baseline.of(oBaseline, null);
        this.fontStyle = FontStyle.of(oFontStyle, null);
        if (oFontWeight != null) {
            if (oFontWeight instanceof Number) {
                int fw = ((Number) oFontWeight).intValue();
                if (FontWeight.isValid(fw)) this.fontWeight = fw;
                else {
                    throw new IllegalArgumentException("The textStyle.fontWeight value range is " +
                            Arrays.toString(FontWeight.weights()));
                }
            } else if (oFontWeight instanceof String || oFontWeight instanceof FontWeight) {
                this.fontWeight = FontWeight.of(oFontWeight, null);
            }
        }
        this.fontFamily = fontFamily;
        this.fontSize = fontSize;
    }

    @Override
    public TextStyle alignLeft() {
        this.align = Align.left;
        return this;
    }

    @Override
    public TextStyle alignCenter() {
        this.align = Align.center;
        return this;
    }

    @Override
    public TextStyle alignRight() {
        this.align = Align.right;
        return this;
    }

    @Override
    public TextStyle alignTop() {
        this.baseline = Baseline.top;
        return this;
    }

    @Override
    public TextStyle alignMiddle() {
        this.baseline = Baseline.middle;
        return this;
    }

    @Override
    public TextStyle alignBottom() {
        this.baseline = Baseline.bottom;
        return this;
    }

    @Override
    public SimpleTextStyle fontStyle(FontStyle style) {
        this.fontStyle = style;
        return this;
    }

    @Override
    public SimpleTextStyle fontWeight(
            @MagicConstant(intValues = {W100, W200, W300, W400, W500, W600, W700, W800, W900})
            int weight) {
        this.fontWeight = weight;
        return this;
    }

    /**
     * 文本使用粗体字。
     */
    public SimpleTextStyle bold() {
        this.fontWeight = FontWeight.bold;
        return this;
    }

    /**
     * 文本使用比粗体更粗的字。
     */
    public SimpleTextStyle bolder() {
        this.fontWeight = FontWeight.bolder;
        return this;
    }

    /**
     * 文本使用淡字体。
     */
    public SimpleTextStyle lighter() {
        this.fontWeight = FontWeight.lighter;
        return this;
    }

    /**
     * 设置文本的字体样式名称。
     *
     * @param fontFamily 字体名称。
     */
    public SimpleTextStyle fontFamily(String fontFamily) {
        this.fontFamily = fontFamily;
        return this;
    }

    /**
     * 设置文本的字体大小。
     *
     * @param fontSize 字体大小。
     */
    public SimpleTextStyle fontSize(int fontSize) {
        this.fontSize = fontSize;
        return this;
    }

    @Override
    public Align getAlign() {
        return align;
    }

    public void setAlign(Align align) {
        this.align = align;
    }

    @Override
    public Baseline getBaseline() {
        return baseline;
    }

    public void setBaseline(Baseline baseline) {
        this.baseline = baseline;
    }

    @Override
    public FontStyle getFontStyle() {
        return fontStyle;
    }

    public void setFontStyle(FontStyle fontStyle) {
        this.fontStyle = fontStyle;
    }

    @Override
    public Object getFontWeight() {
        return fontWeight;
    }

    public void setFontWeight(Object fw) {
        if (fw == null) {
            this.fontWeight = null;
        } else if (fw instanceof Number) {
            int v = ((Number) fw).intValue();
            if (!FontWeight.isValid(v)) {
                throw new IllegalArgumentException(String.format(
                        "Unsupported `fontWeight=%d`", v));
            }
            this.fontWeight = v;
        } else if (fw instanceof String) {
            FontWeight weight = FontWeight.of((String) fw, null);
            if (weight != null) {
                this.fontWeight = weight;
            } else {
                throw new IllegalArgumentException(String.format(
                        "Unsupported `fontWeight=%s`", fw));
            }
        } else if (fw instanceof FontWeight) {
            this.fontWeight = fw;
        } else {
            throw new IllegalArgumentException(String.format(
                    "Unsupported `fontWeight=%s(type=%s)`", fw, fw.getClass()));
        }
    }

    @Override
    public String getFontFamily() {
        return fontFamily;
    }

    public void setFontFamily(String fontFamily) {
        this.fontFamily = fontFamily;
    }

    @Override
    public Integer getFontSize() {
        return fontSize;
    }

    public void setFontSize(Integer fontSize) {
        this.fontSize = fontSize;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof SimpleTextStyle)) return false;
        if (!super.equals(o)) return false;
        SimpleTextStyle that = (SimpleTextStyle) o;
        return fontStyle == that.fontStyle &&
                Objects.equals(fontWeight, that.fontWeight) &&
                Objects.equals(fontFamily, that.fontFamily) &&
                Objects.equals(fontSize, that.fontSize);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), fontStyle, fontWeight, fontFamily, fontSize);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder(32)
                .append(getClass()).append("{");
        sb.append("color=").append(getColor());
        sb.append(", align=").append(align);
        sb.append(", baseline=").append(baseline);
        sb.append(", fontStyle=").append(fontStyle);
        sb.append(", fontWeight=").append(fontWeight);
        sb.append(", fontFamily='").append(fontFamily).append('\'');
        sb.append(", fontSize=").append(fontSize);
        sb.append('}');
        return sb.toString();
    }
}
