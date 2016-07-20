/*
 * Copyright 2016 Aying.Org all rights reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.aying.echarts;

import org.aying.echarts.base.Orient;
import org.aying.echarts.base.SizeGraph;
import org.aying.echarts.feature.Feature;
import org.aying.echarts.style.ShapeStyle;

import java.io.Serializable;
import java.util.Map;
import java.util.Objects;

/**
 * 工具栏配置项模型。
 *
 * @author Fuchun
 * @since 1.0
 */
public class Toolbox extends SizeGraph<Toolbox> implements Serializable {

    private static final long serialVersionUID = -8866834044547409240L;

    private Boolean show;
    private Orient orient;
    private Integer itemSize;
    private Integer itemGap;
    private Boolean showTitle;
    private Feature feature;
    private Map<String, ShapeStyle> iconStyle;

    public Toolbox() {
        super();
    }

    public Boolean getShow() {
        return show;
    }

    public void setShow(Boolean show) {
        this.show = show;
    }

    public Orient getOrient() {
        return orient;
    }

    public void setOrient(Orient orient) {
        this.orient = orient;
    }

    public Integer getItemSize() {
        return itemSize;
    }

    public void setItemSize(Integer itemSize) {
        this.itemSize = itemSize;
    }

    public Integer getItemGap() {
        return itemGap;
    }

    public void setItemGap(Integer itemGap) {
        this.itemGap = itemGap;
    }

    public Boolean getShowTitle() {
        return showTitle;
    }

    public void setShowTitle(Boolean showTitle) {
        this.showTitle = showTitle;
    }

    public Feature getFeature() {
        return feature;
    }

    public void setFeature(Feature feature) {
        this.feature = feature;
    }

    public Map<String, ShapeStyle> getIconStyle() {
        return iconStyle;
    }

    public void setIconStyle(Map<String, ShapeStyle> iconStyle) {
        this.iconStyle = iconStyle;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Toolbox)) return false;
        if (!super.equals(o)) return false;
        Toolbox toolbox = (Toolbox) o;
        return Objects.equals(show, toolbox.show) &&
                orient == toolbox.orient &&
                Objects.equals(itemSize, toolbox.itemSize) &&
                Objects.equals(itemGap, toolbox.itemGap) &&
                Objects.equals(showTitle, toolbox.showTitle) &&
                Objects.equals(feature, toolbox.feature) &&
                Objects.equals(iconStyle, toolbox.iconStyle);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), show, orient, itemSize, itemGap, showTitle, feature, iconStyle);
    }

    @Override
    public String toString() {
        return String.format(
                "org.aying.echarts.Toolbox{show=%s, orient=%s, itemSize=%d, itemGap=%d, " +
                        "showTitle=%s, feature=%s, iconStyle=%s} %s",
                show, orient, itemSize, itemGap, showTitle, feature, iconStyle, super.toString());
    }
}
