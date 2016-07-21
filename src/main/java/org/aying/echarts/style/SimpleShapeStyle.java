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
    private String borderColor;
    private Integer borderWidth;
    private LineType borderType;

    public SimpleShapeStyle() {
        super();
    }

    @Override
    public String getBorderColor() {
        return borderColor;
    }

    public void setBorderColor(String borderColor) {
        this.borderColor = borderColor;
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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof SimpleShapeStyle)) return false;
        if (!super.equals(o)) return false;
        SimpleShapeStyle that = (SimpleShapeStyle) o;
        return Objects.equals(borderColor, that.borderColor) &&
                Objects.equals(borderWidth, that.borderWidth) &&
                borderType == that.borderType;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), borderColor, borderWidth, borderType);
    }

    @Override
    protected Map<String, Object> toStringMap() {
        Map<String, Object> map = super.toStringMap();
        map.put("borderColor", getBorderColor());
        map.put("borderWidth", getBorderWidth());
        map.put("borderType", getBorderType());
        return map;
    }
}
