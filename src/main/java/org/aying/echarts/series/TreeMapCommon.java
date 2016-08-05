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

/**
 * {@code TreeMapCommon} 系列共用配置接口。
 * <p />
 * treemap 中采用『series』--『每个层级』--『每个节点』这样的『三级配置』。
 * 即在{@code TreeMapSerie}、{@code TreeMapSerie#level} 和{@code TreeMapSerieData} 中都包含此接口中的配置属性。
 *
 * @author Fuchun
 * @since 1.0
 */
public interface TreeMapCommon<T extends TreeMapCommon<T>> {

    /**
     * {@code TreeMapCommon} 中支持对数据其他维度进行视觉映射。
     * <p />
     * 首先，{@code TreeMapCommon} 的数据格式（{@link TreeMapSerieData}）中，每个节点的{@code value} 都可以是数组。
     * 数组每项是一个『维度』（{@code dimension}）。{@code visualDimension} 指定了额外的『视觉映射』使用的是数组的哪一项。
     * 默认为第{@code 0} 项。
     */
    Integer getVisualDimension();
    void setVisualDimension(Integer visualDimension);

    /**
     * 表示同一层级的节点的 颜色透明度 选取范围。数值范围{@code 0 ~ 1}。
     */
    Object[] getColorAlpha();
    void setColorAlpha(Object[] colorAlpha);

    /**
     * 表示同一层级的节点的 颜色饱和度 选取范围。数值范围{@code 0 ~ 1}。
     */
    Object getColorSaturation();
    void setColorSaturation(Object colorSaturation);

    /**
     * 表示同一层级节点，在颜色列表中（参见{@code color} 属性）选择时，按照什么来选择。
     */
    ColorMappingBy getColorMappingBy();
    void setColorMappingBy(ColorMappingBy colorMappingBy);

    /**
     * 如果某个节点的矩形的面积，小于这个数值（单位：px平方），这个节点就不显示。
     */
    Integer getVisibleMin();
    void setVisibleMin(Integer visibleMin);

    /**
     * 如果某个节点的矩形面积，小于这个数值（单位：px平方），则不显示这个节点的子节点。
     */
    Double getChildrenVisibleMin();
    void setChildrenVisibleMin(Double childrenVisibleMin);
}
