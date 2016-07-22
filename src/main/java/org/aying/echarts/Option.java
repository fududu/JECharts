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

import org.aying.echarts.axis.AngleAxis;
import org.aying.echarts.axis.CartesianAxis;
import org.aying.echarts.axis.ParallelAxis;
import org.aying.echarts.axis.RadiusAxis;
import org.aying.echarts.axis.SingleAxis;
import org.aying.echarts.base.BaseAnimation;

import java.io.Serializable;
import java.time.format.TextStyle;
import java.util.List;

/**
 * ECharts option model.
 *
 * @author Fuchun
 * @since 1.0
 */
public class Option extends BaseAnimation<Option> implements Serializable {

    /* 标题组件配置。 */
    private Title title;
    /* 图例组件配置。 */
    private Legend legend;
    /* 绘图网格配置。 */
    private Grid grid;
    /* 直角坐标系 grid 中的 x 轴配置 */
    private CartesianAxis xAxis;
    /* 直角坐标系 grid 中的 y 轴配置 */
    private CartesianAxis yAxis;
    /* 极坐标系配置 */
    private Polar polar;
    /* 极坐标系的半径轴配置 */
    private RadiusAxis radiusAxis;
    /* 极坐标系的角度轴配置。 */
    private AngleAxis angleAxis;
    /* 雷达图坐标系配置 */
    private Radar radar;
    /* 区域缩放组件配置 */
    private List<DataZoom> dataZooms;
    /* 视觉映射组件配置 */
    private List<VisualMap<?>> visualMaps;
    /* 提示框组件配置 */
    private Tooltip tooltip;
    /* 工具栏配置 */
    private Toolbox toolbox;
    /* 区域选择组件配置 */
    private Brush brush;
    /* 地理坐标系组件配置。 */
    private Geo geo;
    /* 平行坐标系配置 */
    private Parallel parallel;
    /* 平行坐标系中的坐标轴配置 */
    private ParallelAxis parallelAxis;
    /* 单轴配置 */
    private SingleAxis singleAxis;
    /* timeline 配置 */
    private Timeline timeline;

    /* 调色盘颜色列表。如果系列没有设置颜色，则会依次循环从该列表中取颜色作为系列颜色。 */
    private List<String> color;
    /* 背景色，默认无背景。transparent */
    private String backgroundColor;
    /* 全局的字体样式。 */
    private TextStyle textStyle;

    /* 这里是 Animation 的属性区，继承自 BaseAnimation */

    /* 渐进式渲染时每一帧绘制图形数量，设为 0 时不启用渐进式渲染，支持每个系列单独配置。 */
    private Boolean progressive;
    /* 启用渐进式渲染的图形数量阈值，在单个系列的图形数量超过该阈值时启用渐进式渲染。 */
    private Integer progressiveThreshold;
    /* 图形混合模式。 */
    private String blendMode;
    /* 图形数量阈值，决定是否开启单独的 hover 层，在整个图表的图形数量大于该阈值时开启单独的 hover 层。 */
    private Integer hoverLayerThreshold;
}
