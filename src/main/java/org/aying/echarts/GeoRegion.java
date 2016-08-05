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

import org.aying.echarts.base.Label;
import org.aying.echarts.base.StateLabel;
import org.aying.echarts.style.AreaShapeStyle;
import org.aying.echarts.style.StateAreaShapeStyle;
import org.jetbrains.annotations.Contract;

import java.io.Serializable;
import java.util.Objects;

/**
 * 地图指定区域的具体描述模型。
 * <pre>{@code
 * Geo geo = Geo.geo("China")
 *         ... ...
 *         .regions(
 *             GeoRegion.named("广东")
 *         );
 * }</pre>
 *
 * @author Fuchun
 * @since 1.0
 */
public class GeoRegion implements Serializable {

    private static final long serialVersionUID = -3212079129367343670L;

    @Contract("null -> fail")
    public static GeoRegion named(String name) {
        return new GeoRegion(name);
    }

    /* 地图区域的名称，例如 '广东'，'浙江'。 */
    private String name;
    /* 该区域是否选中。默认：false */
    private Boolean selected;
    /* 该区域的多边形样式设置 */
    private StateAreaShapeStyle itemStyle;
    /* 该区域的标签样式设置 */
    private StateLabel label;

    public GeoRegion() {
        super();
    }

    public GeoRegion(String name) {
        Objects.requireNonNull(name, "name");
        this.name = name;
    }

    public GeoRegion selected() {
        this.selected = Boolean.TRUE;
        return this;
    }

    /**
     * 设置普通状态下的标签属性及样式。
     *
     * @param normal 标签属性及样式。
     */
    public GeoRegion normal(Label normal) {
        Objects.requireNonNull(normal, "geo.regions[i].label.normal");
        getOrInitLabel().normal(normal);
        return this;
    }

    /**
     * 设置高亮状态下的标签属性及样式。
     *
     * @param emphasis 标签属性及样式。
     */
    public GeoRegion emphasis(Label emphasis) {
        Objects.requireNonNull(emphasis, "geo.regions[i].label.emphasis");
        getOrInitLabel().emphasis(emphasis);
        return this;
    }

    public GeoRegion normal(AreaShapeStyle normal) {
        Objects.requireNonNull(normal, "geo.regions[i].itemStyle.normal");
        getOrInitItemStyle().normal(normal);
        return this;
    }

    public GeoRegion emphasis(AreaShapeStyle emphasis) {
        Objects.requireNonNull(emphasis, "geo.regions[i].itemStyle.emphasis");
        getOrInitItemStyle().emphasis(emphasis);
        return this;
    }

    protected StateAreaShapeStyle getOrInitItemStyle() {
        if (itemStyle == null) {
            itemStyle = new StateAreaShapeStyle();
        }
        return itemStyle;
    }

    protected StateLabel getOrInitLabel() {
        if (label == null) {
            label = new StateLabel();
        }
        return label;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Boolean getSelected() {
        return selected;
    }

    public void setSelected(Boolean selected) {
        this.selected = selected;
    }

    public StateAreaShapeStyle getItemStyle() {
        return itemStyle;
    }

    public void setItemStyle(StateAreaShapeStyle itemStyle) {
        this.itemStyle = itemStyle;
    }

    public StateLabel getLabel() {
        return label;
    }

    public void setLabel(StateLabel label) {
        this.label = label;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof GeoRegion)) return false;
        GeoRegion geoRegion = (GeoRegion) o;
        return Objects.equals(name, geoRegion.name) &&
                Objects.equals(selected, geoRegion.selected) &&
                Objects.equals(itemStyle, geoRegion.itemStyle) &&
                Objects.equals(label, geoRegion.label);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, selected, itemStyle, label);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder(32)
                .append(getClass()).append("{");
        sb.append("name='").append(name).append('\'');
        sb.append(", selected=").append(selected);
        sb.append(", label=").append(label);
        sb.append(", itemStyle=").append(itemStyle);
        sb.append('}');
        return sb.toString();
    }
}
