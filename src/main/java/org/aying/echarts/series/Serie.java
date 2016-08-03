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

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import org.aying.echarts.ChartType;
import org.jetbrains.annotations.NotNull;

/**
 * ECharts 系列(series)配置模型接口。
 *
 * @author Fuchun
 * @since 1.0
 */
@JsonTypeInfo(
        use = JsonTypeInfo.Id.NAME,
        include = JsonTypeInfo.As.EXISTING_PROPERTY,
        property = "type"
)
@JsonSubTypes({
        @JsonSubTypes.Type(value = BarSerie.class, name = "bar"),
        @JsonSubTypes.Type(value = BoxPlotSerie.class, name = "boxplot"),
        @JsonSubTypes.Type(value = CandlestickSerie.class, name = "candlestick"),
        @JsonSubTypes.Type(value = EffectScatterSerie.class, name = "effectscatter"),
        @JsonSubTypes.Type(value = FunnelSerie.class, name = "funnel"),
        @JsonSubTypes.Type(value = GaugeSerie.class, name = "gauge"),
        @JsonSubTypes.Type(value = GraphSerie.class, name = "graph"),
        @JsonSubTypes.Type(value = HeatMapSerie.class, name = "heatmap"),
        @JsonSubTypes.Type(value = LineSerie.class, name = "line"),
        @JsonSubTypes.Type(value = LinesSerie.class, name = "lines"),
        @JsonSubTypes.Type(value = MapSerie.class, name = "map"),
        @JsonSubTypes.Type(value = ParallelSerie.class, name = "parallel"),
        @JsonSubTypes.Type(value = PieSerie.class, name = "pie"),
        @JsonSubTypes.Type(value = RadarSerie.class, name = "radar"),
        @JsonSubTypes.Type(value = SankeySerie.class, name = "sankey"),
        @JsonSubTypes.Type(value = ScatterSerie.class, name = "scatter"),
        @JsonSubTypes.Type(value = TreeMapSerie.class, name = "treemap")
})
@JsonIgnoreProperties(ignoreUnknown = true)
public interface Serie {

    /**
     * 系列（图表）类型。
     */
    @NotNull
    ChartType getType();

    /**
     * 返回系列配置的名称。某些图表不支此属性，返回{@code null}。
     */
    String getName();

    /**
     * 图形是否响应和触发鼠标事件。个别图表不支持此属性，返回{@code null}。
     * <p />
     * 大部份图表系列配置中，此属性为{@code Boolean}，只有个别为其他对象。
     */
    Object getSilent();
}
