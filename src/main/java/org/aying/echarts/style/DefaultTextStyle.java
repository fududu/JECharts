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

import org.aying.echarts.style.font.FontStyle;
import org.aying.echarts.style.font.FontWeight;
import org.intellij.lang.annotations.MagicConstant;

import java.util.Objects;

import static org.aying.echarts.style.font.FontWeight.*;

/**
 * @author Fuchun
 * @since 1.0
 */
public class DefaultTextStyle extends DefaultStyle implements TextStyle {

    private static final long serialVersionUID = -7037742340818566884L;

    private FontStyle fontStyle;
    private Object fontWeight;
    private String fontFamily;
    private Integer fontSize;

    public DefaultTextStyle() {
        super();
    }

    public DefaultTextStyle fontStyle(FontStyle style) {
        this.fontStyle = style;
        return this;
    }

    public DefaultTextStyle fontWeight(
            @MagicConstant(intValues = {W100, W200, W300, W400, W500, W600, W700, W800, W900,})
            int weight) {
        this.fontWeight = weight;
        return this;
    }

    public DefaultTextStyle fontWeight(FontWeight weight) {
        this.fontWeight = weight;
        return this;
    }

    public DefaultTextStyle fontFamily(String fontFamily) {
        this.fontFamily = fontFamily;
        return this;
    }

    public DefaultTextStyle fontSize(int fontSize) {
        this.fontSize = fontSize;
        return this;
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

    public void setFontWeight(Object fontWeight) {
        this.fontWeight = fontWeight;
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
        if (!(o instanceof DefaultTextStyle)) return false;
        if (!super.equals(o)) return false;
        DefaultTextStyle that = (DefaultTextStyle) o;
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
        return "org.aying.echarts.style.DefaultTextStyle{" +
                "color=" + color +
                "fontStyle=" + fontStyle +
                ", fontWeight=" + fontWeight +
                ", fontFamily='" + fontFamily + '\'' +
                ", fontSize=" + fontSize +
                '}';
    }
}
