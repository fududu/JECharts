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
 * 图表系列配置模型的简单工厂。
 *
 * @author Fuchun
 * @since 1.0
 */
public abstract class Series {

    /**
     * 折线/面积图系列配置。
     */
    public static LineSerie line() {
        return new LineSerie();
    }

    /**
     * 线图系列配置。
     */
    public static LinesSerie lines() {
        return new LinesSerie();
    }

    /**
     * 柱状/条形图系列配置。
     */
    public static BarSerie bar() {
        return new BarSerie();
    }

    /**
     * 饼图系列配置。
     */
    public static PieSerie pie() {
        return new PieSerie();
    }

    /**
     * 散点（气泡）图系列配置。
     */
    public static ScatterSerie scatter() {
        return new ScatterSerie();
    }

    /**
     * 带有涟漪特效动画的散点（气泡）图系列配置。
     */
    public static EffectScatterSerie effectScatter() {
        return new EffectScatterSerie();
    }

    /**
     * 雷达图系列配置。
     */
    public static RadarSerie radar() {
        return new RadarSerie();
    }

    /**
     * 树状图系列配置。
     */
    public static TreeMapSerie treeMap() {
        return new TreeMapSerie();
    }

    /**
     * 箱形图系列配置。
     */
    public static BoxPlotSerie boxPlot() {
        return new BoxPlotSerie();
    }

    /**
     * K线图系列配置。
     */
    public static CandlestickSerie candlestick() {
        return new CandlestickSerie();
    }

    /**
     * 热力图系列配置。
     */
    public static HeatMapSerie heatMap() {
        return new HeatMapSerie();
    }

    /**
     * 地图系列配置。
     */
    public static MapSerie map() {
        return new MapSerie();
    }

    /**
     * 平行坐标系的系列配置。
     */
    public static ParallelSerie parallel() {
        return new ParallelSerie();
    }

    /**
     * 平行坐标系的系列配置。
     */
    public static GraphSerie graph() {
        return new GraphSerie();
    }

    /**
     * 桑基图系列配置。
     */
    public static SankeySerie sankey() {
        return new SankeySerie();
    }

    /**
     * 漏斗图系列配置。
     */
    public static FunnelSerie funnel() {
        return new FunnelSerie();
    }

    /**
     * 仪表盘系列配置。
     */
    public static GaugeSerie gauge() {
        return new GaugeSerie();
    }

    private Series() {}
}
