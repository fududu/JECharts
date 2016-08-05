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

import java.util.Map;
import java.util.Objects;

/**
 * The simple implementation of the {@code ShapeStyle}.
 *
 * @author Fuchun
 * @since 1.0
 */
public class SimpleShapeStyle extends BaseShadowStyle<SimpleShapeStyle> implements ShapeStyle {

    private static final long serialVersionUID = -4421399723447580397L;

    private String backgroundColor;
    private String borderColor;
    private Object borderColorSaturation;
    private Integer borderWidth;
    private LineType borderType;
    private Integer gapWidth;
    // 文本样式（极少数会用到）
    private TextStyle textStyle;

    public SimpleShapeStyle() {
        super();
    }

    @Override
    public String getBackgroundColor() {
        return backgroundColor;
    }

    public void setBackgroundColor(String backgroundColor) {
        this.backgroundColor = backgroundColor;
    }

    @Override
    public String getBorderColor() {
        return borderColor;
    }

    public void setBorderColor(String borderColor) {
        this.borderColor = borderColor;
    }

    @Override
    public Object getBorderColorSaturation() {
        return borderColorSaturation;
    }

    public void setBorderColorSaturation(Object borderColorSaturation) {
        this.borderColorSaturation = borderColorSaturation;
    }

    @Override
    public Integer getBorderWidth() {
        return borderWidth;
    }

    public void setBorderWidth(Integer borderWidth) {
        this.borderWidth = borderWidth;
    }

    @Override
    public LineType getBorderType() {
        return borderType;
    }

    public void setBorderType(LineType borderType) {
        this.borderType = borderType;
    }

    @Override
    public Integer getGapWidth() {
        return gapWidth;
    }

    public void setGapWidth(Integer gapWidth) {
        this.gapWidth = gapWidth;
    }

    @Override
    public TextStyle getTextStyle() {
        return textStyle;
    }

    public void setTextStyle(TextStyle textStyle) {
        this.textStyle = textStyle;
    }

    @Override
    public ShapeStyle bgColor(String bgColor) {
        this.backgroundColor = bgColor;
        return this;
    }

    @Override
    public ShapeStyle borderWidth(int borderWidth) {
        this.borderWidth = borderWidth;
        return this;
    }

    @Override
    public ShapeStyle borderColor(String color) {
        this.borderColor = color;
        return this;
    }

    @Override
    public ShapeStyle textStyle(TextStyle textStyle) {
        this.textStyle = textStyle;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof SimpleShapeStyle)) return false;
        if (!super.equals(o)) return false;
        SimpleShapeStyle that = (SimpleShapeStyle) o;
        return Objects.equals(backgroundColor, that.backgroundColor) &&
                Objects.equals(borderColor, that.borderColor) &&
                Objects.equals(borderColorSaturation, that.borderColorSaturation) &&
                Objects.equals(borderWidth, that.borderWidth) &&
                borderType == that.borderType &&
                Objects.equals(gapWidth, that.gapWidth) &&
                Objects.equals(textStyle, that.textStyle);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), backgroundColor, borderColor, borderColorSaturation,
                borderWidth, borderType, gapWidth, textStyle);
    }

    @Override
    protected Map<String, Object> toStringMap() {
        Map<String, Object> map = super.toStringMap();
        map.put("backgroundColor", getBackgroundColor());
        map.put("borderColor", getBorderColor());
        map.put("borderColorSaturation", getBorderColorSaturation());
        map.put("borderWidth", getBorderWidth());
        map.put("borderType", getBorderType());
        map.put("gapWidth", getGapWidth());
        map.put("textStyle", getTextStyle());
        return map;
    }
}
