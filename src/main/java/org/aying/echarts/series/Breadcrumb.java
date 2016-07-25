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

import org.aying.echarts.base.BasePosition;
import org.aying.echarts.base.SimpleSize;
import org.aying.echarts.base.Size;
import org.aying.echarts.style.StateShadowStyle;

import java.io.Serializable;
import java.util.Objects;

/**
 * 面包屑设置。
 *
 * @author Fuchun
 * @since 1.0
 */
public class Breadcrumb extends BasePosition<Breadcrumb>
        implements Size<Breadcrumb>, Serializable {

    private static final long serialVersionUID = -5497975345491925310L;

    public static Breadcrumb show() {
        return new Breadcrumb();
    }

    public static Breadcrumb hide() {
        Breadcrumb b = new Breadcrumb();
        b.setShow(Boolean.FALSE);
        return b;
    }

    private final SimpleSize ss;
    private Boolean show;
    private Integer emptyItemWidth;
    private StateShadowStyle itemStyle;

    public Breadcrumb() {
        super();
        this.ss = new SimpleSize();
    }

    public Boolean getShow() {
        return show;
    }

    public void setShow(Boolean show) {
        this.show = show;
    }

    public Integer getEmptyItemWidth() {
        return emptyItemWidth;
    }

    public void setEmptyItemWidth(Integer emptyItemWidth) {
        this.emptyItemWidth = emptyItemWidth;
    }

    public StateShadowStyle getItemStyle() {
        return itemStyle;
    }

    public void setItemStyle(StateShadowStyle itemStyle) {
        this.itemStyle = itemStyle;
    }

    @Override
    public Object getWidth() {
        return null;
    }

    @Override
    public void setWidth(Object width) {
        // not support width
    }

    @Override
    public Object getHeight() {
        return ss.getHeight();
    }

    @Override
    public void setHeight(Object height) {
        ss.setHeight(height);
    }

    @Override
    public Breadcrumb autoWidth() {
        return this;
    }

    @Override
    public Breadcrumb autoHeight() {
        ss.autoHeight();
        return this;
    }

    @Override
    public Breadcrumb width(int width) {
        return this;
    }

    @Override
    public Breadcrumb width(String width) {
        return this;
    }

    @Override
    public Breadcrumb height(int height) {
        ss.height(height);
        return this;
    }

    @Override
    public Breadcrumb height(String height) {
        ss.setHeight(height);
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Breadcrumb)) return false;
        if (!super.equals(o)) return false;
        Breadcrumb that = (Breadcrumb) o;
        return Objects.equals(ss, that.ss) &&
                Objects.equals(show, that.show) &&
                Objects.equals(emptyItemWidth, that.emptyItemWidth) &&
                Objects.equals(itemStyle, that.itemStyle);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), ss, show, emptyItemWidth, itemStyle);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder(32)
                .append(getClass()).append("{");
        sb.append("show=").append(show);
        sb.append(", left=").append(getLeft());
        sb.append(", top=").append(getTop());
        sb.append(", right=").append(getRight());
        sb.append(", bottom=").append(getBottom());
        sb.append(", height=").append(getHeight());
        sb.append(", emptyItemWidth=").append(emptyItemWidth);
        sb.append(", itemStyle=").append(itemStyle);
        sb.append('}');
        return sb.toString();
    }
}
