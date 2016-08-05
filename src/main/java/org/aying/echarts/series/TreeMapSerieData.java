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

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

/**
 * @author Fuchun
 * @since 1.0
 */
public class TreeMapSerieData extends SerieData {

    private static final long serialVersionUID = 6874560193210562590L;

    private String id;
    /*treemap 中支持对数据其他维度进行视觉映射。*/
    private Integer visualDimension;
    /* 表示同一层级的节点的 颜色 选取列表。默认为空时，选取系统color列表。 */
    private List<Object> color;
    /*表示同一层级的节点的 颜色透明度 选取范围。数值范围 0 ~ 1。*/
    private Object[] colorAlpha;

    /*表示同一层级的节点的 颜色饱和度 选取范围。数值范围 0 ~ 1。*/
    private Double colorSaturation;
    /*表示同一层级节点，在颜色列表中（参见 color 属性）选择时，按照什么来选择。*/
    private ColorMappingBy colorMappingBy;
    /*如果某个节点的矩形的面积，小于这个数值（单位：px平方），这个节点就不显示。*/
    private Integer visibleMin;
    /*如果某个节点的矩形面积，小于这个数值（单位：px平方），则不显示这个节点的子节点。*/
    private Integer childrenVisibleMin;

    private List<TreeMapSerieData> children;

    public TreeMapSerieData() {
        super();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Integer getVisualDimension() {
        return visualDimension;
    }

    public void setVisualDimension(Integer visualDimension) {
        this.visualDimension = visualDimension;
    }

    public List<Object> getColor() {
        return color;
    }

    public void setColor(List<Object> color) {
        this.color = color;
    }

    public Object[] getColorAlpha() {
        return colorAlpha;
    }

    public void setColorAlpha(Object[] colorAlpha) {
        this.colorAlpha = colorAlpha;
    }

    public Double getColorSaturation() {
        return colorSaturation;
    }

    public void setColorSaturation(Double colorSaturation) {
        this.colorSaturation = colorSaturation;
    }

    public ColorMappingBy getColorMappingBy() {
        return colorMappingBy;
    }

    public void setColorMappingBy(ColorMappingBy colorMappingBy) {
        this.colorMappingBy = colorMappingBy;
    }

    public Integer getVisibleMin() {
        return visibleMin;
    }

    public void setVisibleMin(Integer visibleMin) {
        this.visibleMin = visibleMin;
    }

    public Integer getChildrenVisibleMin() {
        return childrenVisibleMin;
    }

    public void setChildrenVisibleMin(Integer childrenVisibleMin) {
        this.childrenVisibleMin = childrenVisibleMin;
    }

    public List<TreeMapSerieData> getChildren() {
        return children;
    }

    public void setChildren(List<TreeMapSerieData> children) {
        this.children = children;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof TreeMapSerieData)) return false;
        if (!super.equals(o)) return false;
        TreeMapSerieData that = (TreeMapSerieData) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(visualDimension, that.visualDimension) &&
                Objects.equals(color, that.color) &&
                Arrays.equals(colorAlpha, that.colorAlpha) &&
                Objects.equals(colorSaturation, that.colorSaturation) &&
                colorMappingBy == that.colorMappingBy &&
                Objects.equals(visibleMin, that.visibleMin) &&
                Objects.equals(childrenVisibleMin, that.childrenVisibleMin) &&
                Objects.equals(children, that.children);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), id, visualDimension, color, colorAlpha, colorSaturation,
                colorMappingBy, visibleMin, childrenVisibleMin, children);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder(32)
                .append(getClass()).append("{");
        appendSimpleData(sb);
        sb.append(", id='").append(id).append('\'');
        sb.append(", visualDimension=").append(visualDimension);
        sb.append(", color=").append(color);
        sb.append(", colorAlpha=").append(Arrays.toString(colorAlpha));
        sb.append(", colorSaturation=").append(colorSaturation);
        sb.append(", colorMappingBy=").append(colorMappingBy);
        sb.append(", visibleMin=").append(visibleMin);
        sb.append(", childrenVisibleMin=").append(childrenVisibleMin);
        sb.append(", children=").append(children);
        sb.append(", label=").append(getLabel());
        sb.append(", itemStyle=").append(getItemStyle());
        sb.append('}');
        return sb.toString();
    }
}
