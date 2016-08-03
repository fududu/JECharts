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

import java.io.Serializable;
import java.util.Objects;

/**
 * 视觉引导线样式。
 *
 * @author Fuchun
 * @since 1.0
 */
public class GuideLineStyle implements Serializable {

    private static final long serialVersionUID = -972618293166197798L;

    /*是否显示视觉引导线。*/
    private Boolean show;
    /*视觉引导线第一段的长度。*/
    private Integer length;
    /*视觉引导项第二段的长度。*/
    private Integer length2;
    /*是否平滑视觉引导线，默认不平滑*/
    private Object smooth;
    /*线条样式*/
    private LineStyle lineStyle;

    public GuideLineStyle() {
        super();
        this.show = Boolean.TRUE;
    }

    public GuideLineStyle length(int length, int... length2) {
        this.length = length;
        if (length2 != null && length2.length > 0) {
            this.length2 = length2[0];
        } else {
            this.length2 = null;
        }
        return this;
    }

    public GuideLineStyle hide() {
        this.show = Boolean.FALSE;
        return this;
    }

    public GuideLineStyle smooth() {
        this.smooth = Boolean.TRUE;
        return this;
    }

    public GuideLineStyle lineStyle(LineStyle lineStyle) {
        this.lineStyle = lineStyle;
        return this;
    }

    public Boolean getShow() {
        return show;
    }

    public void setShow(Boolean show) {
        this.show = show;
    }

    public Integer getLength() {
        return length;
    }

    public void setLength(Integer length) {
        this.length = length;
    }

    public Integer getLength2() {
        return length2;
    }

    public void setLength2(Integer length2) {
        this.length2 = length2;
    }

    public Object getSmooth() {
        return smooth;
    }

    public void setSmooth(Object smooth) {
        this.smooth = smooth;
    }

    public LineStyle getLineStyle() {
        return lineStyle;
    }

    public void setLineStyle(LineStyle lineStyle) {
        this.lineStyle = lineStyle;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof GuideLineStyle)) return false;
        GuideLineStyle that = (GuideLineStyle) o;
        return Objects.equals(show, that.show) &&
                Objects.equals(length, that.length) &&
                Objects.equals(length2, that.length2) &&
                Objects.equals(smooth, that.smooth) &&
                Objects.equals(lineStyle, that.lineStyle);
    }

    @Override
    public int hashCode() {
        return Objects.hash(show, length, length2, smooth, lineStyle);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder(32)
                .append(getClass()).append("{");
        sb.append("show=").append(show);
        sb.append(", length=").append(length);
        sb.append(", length2=").append(length2);
        sb.append(", smooth=").append(smooth);
        sb.append(", lineStyle=").append(lineStyle);
        sb.append('}');
        return sb.toString();
    }
}
