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

    public static BarSerie bar() {
        return new BarSerie();
    }

    public static PieSerie pie() {
        return new PieSerie();
    }

    public static ScatterSerie scatter() {
        return new ScatterSerie();
    }

    public static EffectScatterSerie effectScatter() {
        return new EffectScatterSerie();
    }

    public static RadarSerie radar() {
        return new RadarSerie();
    }

    public static TreeMapSerie treeMap() {
        return new TreeMapSerie();
    }

    public static BoxPlotSerie boxPlot() {
        return new BoxPlotSerie();
    }

    public static CandlestickSerie candlestick() {
        return new CandlestickSerie();
    }

    public static HeatMapSerie heatMap() {
        return new HeatMapSerie();
    }

    private Series() {}
}
