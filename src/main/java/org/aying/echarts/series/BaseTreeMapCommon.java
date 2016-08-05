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

import org.aying.echarts.util.ToString;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Objects;

/**
 * @author Fuchun
 * @since 1.0
 */
public abstract class BaseTreeMapCommon<T extends BaseTreeMapCommon<T>>
        implements TreeMapCommon<T>, Serializable {

    private static final long serialVersionUID = -1L;

    /* treemap 中支持对数据其他维度进行视觉映射。*/
    private Integer visualDimension;

    /*本系列默认的 颜色透明度 选取范围。数值范围 0 ~ 1。*/
    private Object[] colorAlpha;
    /*本系列默认的 颜色饱和度 选取范围。数值范围 0 ~ 1。*/
    private Object colorSaturation;
    /*表示同一层级节点，在颜色列表中（参见 color 属性）选择时，按照什么来选择。*/
    private ColorMappingBy colorMappingBy;
    /*如果某个节点的矩形的面积，小于这个数值（单位：px平方），这个节点就不显示。*/
    private Integer visibleMin;
    /*如果某个节点的矩形面积，小于这个数值（单位：px平方），则不显示这个节点的子节点。*/
    private Double childrenVisibleMin;

    @Override
    public Integer getVisualDimension() {
        return visualDimension;
    }

    public void setVisualDimension(Integer visualDimension) {
        this.visualDimension = visualDimension;
    }

    public Object[] getColorAlpha() {
        return colorAlpha;
    }

    public void setColorAlpha(Object[] colorAlpha) {
        this.colorAlpha = colorAlpha;
    }

    public Object getColorSaturation() {
        return colorSaturation;
    }

    public void setColorSaturation(Object colorSaturation) {
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

    public Double getChildrenVisibleMin() {
        return childrenVisibleMin;
    }

    public void setChildrenVisibleMin(Double childrenVisibleMin) {
        this.childrenVisibleMin = childrenVisibleMin;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof BaseTreeMapCommon)) return false;
        BaseTreeMapCommon<?> that = (BaseTreeMapCommon<?>) o;
        return Objects.equals(visualDimension, that.visualDimension) &&
                Arrays.equals(colorAlpha, that.colorAlpha) &&
                Objects.equals(colorSaturation, that.colorSaturation) &&
                colorMappingBy == that.colorMappingBy &&
                Objects.equals(visibleMin, that.visibleMin) &&
                Objects.equals(childrenVisibleMin, that.childrenVisibleMin);
    }

    @Override
    public int hashCode() {
        return Objects.hash(visualDimension, colorAlpha, colorSaturation, colorMappingBy,
                visibleMin, childrenVisibleMin);
    }

    public void appendTreeMapCommon(StringBuilder sb) {
        sb.append(", ");
        appendToString(sb);
    }

    private void appendToString(StringBuilder sb) {
        sb.append("visualDimension=").append(visualDimension);
        sb.append(", colorAlpha=").append(Arrays.toString(colorAlpha));
        sb.append(", colorSaturation=");
        ToString.appendTo(sb, colorSaturation);
        sb.append(", colorMappingBy=").append(colorMappingBy);
        sb.append(", visibleMin=").append(visibleMin);
        sb.append(", childrenVisibleMin=").append(childrenVisibleMin);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder(32)
                .append(getClass()).append("{");
        appendToString(sb);
        sb.append('}');
        return sb.toString();
    }
}
