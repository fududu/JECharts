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

package org.aying.echarts.series;

import org.aying.echarts.style.TextStyle;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

/**
 * 仪表盘零件。
 *
 * @author Fuchun
 * @since 1.0
 */
public abstract class GaugePart implements Serializable {

    private static final long serialVersionUID = 1L;

    private Boolean show;
    private Integer width;
    private Object[] offsetCenter;
    private TextStyle textStyle;

    private final transient List<String> exclusive;

    protected GaugePart() {
        this(null);
    }

    protected GaugePart(Boolean show) {
        this(show, null);
    }

    protected GaugePart(Boolean show, String[] exclusives) {
        super();
        this.show = show;
        exclusive = new ArrayList<>();
        if (exclusives != null && exclusives.length > 0)
            Collections.addAll(exclusive, exclusives);
    }

    public Boolean getShow() {
        return show;
    }

    public void setShow(Boolean show) {
        this.show = show;
    }

    public Integer getWidth() {
        if (exclusive.contains("width")) {
            return null;
        }
        return width;
    }

    public void setWidth(Integer width) {
        this.width = width;
    }

    public Object[] getOffsetCenter() {
        if (exclusive.contains("offsetCenter")) {
            return null;
        }
        return offsetCenter;
    }

    public void setOffsetCenter(Object[] offsetCenter) {
        this.offsetCenter = offsetCenter;
    }

    public TextStyle getTextStyle() {
        return textStyle;
    }

    public void setTextStyle(TextStyle textStyle) {
        this.textStyle = textStyle;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof GaugePart)) return false;
        GaugePart gaugePart = (GaugePart) o;
        return Objects.equals(show, gaugePart.show) &&
                Objects.equals(width, gaugePart.width) &&
                Arrays.equals(offsetCenter, gaugePart.offsetCenter) &&
                Objects.equals(textStyle, gaugePart.textStyle);
    }

    @Override
    public int hashCode() {
        return Objects.hash(show, width, offsetCenter, textStyle);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder(32)
                .append(getClass()).append("{");
        sb.append("show=").append(show);
        sb.append(", width=").append(width);
        sb.append(", offsetCenter=").append(Arrays.toString(offsetCenter));
        sb.append(", textStyle=").append(textStyle);
        sb.append('}');
        return sb.toString();
    }
}
