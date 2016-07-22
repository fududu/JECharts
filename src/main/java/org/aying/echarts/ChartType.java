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

/**
 * ECharts 支持的图表类型。
 *
 * @author Fuchun
 * @since 1.0
 */
public enum ChartType {

    /** 折线/面积图 */
    line,

    /** 柱状/条形图 */
    bar,

    /** 饼图 */
    pie,

    /** 散点（气泡）图 */
    scatter,

    /** 带有涟漪特效动画的散点（气泡）图 */
    effectScatter,

    /** 雷达图 */
    radar,

    /** 树面积图 */
    treemap,

    /** 『箱形图』、『盒须图』、『盒式图』、『盒状图』、『箱线图』*/
    boxplot,

    /** k线图 */
    candlestick,

    /** 热力图 */
    heatmap,

    /** 地图。*/
    map,

    /** 平行坐标系的系列 */
    parallel,

    /** 线图 */
    lines,

    /** 关系图 */
    graph,

    /** 桑基图 */
    sankey,

    /** 漏斗图 */
    funnel,

    /** 仪表盘 */
    gauge
}
