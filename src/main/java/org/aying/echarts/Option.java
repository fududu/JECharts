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
import org.aying.echarts.series.Serie;
import org.jetbrains.annotations.Contract;

import java.io.Serializable;
import java.time.format.TextStyle;
import java.util.Collection;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import java.util.Set;

/**
 * ECharts 选项配置模型。
 *
 * @author Fuchun
 * @since 1.0
 */
public class Option extends BaseAnimation<Option> implements Serializable {

    private static final long serialVersionUID = -2913905133593279045L;

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
    private Set<DataZoom> dataZooms;
    /* 视觉映射组件配置 */
    private Set<VisualMap<?>> visualMaps;
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
    /* 系列列表。 */
    private Set<Serie> series;

    /* 调色盘颜色列表。如果系列没有设置颜色，则会依次循环从该列表中取颜色作为系列颜色。 */
    private List<String> color;
    /* 背景色，默认无背景。transparent */
    private String backgroundColor;
    /* 全局的字体样式。 */
    private TextStyle textStyle;

    /* 这里是 Animation 的属性区，继承自 BaseAnimation */

    /* 渐进式渲染时每一帧绘制图形数量，设为 0 时不启用渐进式渲染，支持每个系列单独配置。 */
    private Integer progressive;
    /* 启用渐进式渲染的图形数量阈值，在单个系列的图形数量超过该阈值时启用渐进式渲染。 */
    private Integer progressiveThreshold;
    /* 图形混合模式。 */
    private String blendMode;
    /* 图形数量阈值，决定是否开启单独的 hover 层，在整个图表的图形数量大于该阈值时开启单独的 hover 层。 */
    private Integer hoverLayerThreshold;

    public Option() {
        super();
    }

    public Option title(Title title) {
        this.title = title;
        return this;
    }

    public Option legend(Legend legend) {
        this.legend = legend;
        return this;
    }

    public Option grid(Grid grid) {
        this.grid = grid;
        return this;
    }

    public Option xAxis(CartesianAxis xAxis) {
        this.xAxis = xAxis;
        return this;
    }

    public Option yAxis(CartesianAxis yAxis) {
        this.yAxis = yAxis;
        return this;
    }

    public Option polar(Polar polar) {
        this.polar = polar;
        return this;
    }

    public Option radiusAxis(RadiusAxis radiusAxis) {
        this.radiusAxis = radiusAxis;
        return this;
    }

    public Option angleAxis(AngleAxis angleAxis) {
        this.angleAxis = angleAxis;
        return this;
    }

    public Option radar(Radar radar) {
        this.radar = radar;
        return this;
    }

    @Contract("null -> fail")
    public Option dataZoom(DataZoomInside inside) {
        return addDataZoom(inside);
    }

    @Contract("null -> fail")
    public Option dataZoom(DataZoomSelect select) {
        return addDataZoom(select);
    }

    @Contract("null -> fail")
    public Option dataZoom(DataZoomSlider slider) {
        return addDataZoom(slider);
    }

    protected Option addDataZoom(DataZoom dz) {
        Objects.requireNonNull(dz, "dataZoom");
        if (dataZooms == null) {
            dataZooms = new HashSet<>();
        }
        dataZooms.add(dz);
        return this;
    }

    public Option continuous(ContinuousVisualMap vm) {
        return addVisualMap(vm);
    }

    public Option piecewise(PiecewiseVisualMap vm) {
        return addVisualMap(vm);
    }

    protected Option addVisualMap(VisualMap<?> vm) {
        Objects.requireNonNull(vm, "visualMap");
        if (visualMaps == null) {
            visualMaps = new HashSet<>(2);
        }
        visualMaps.add(vm);
        return this;
    }

    public Option tooltip(Tooltip tooltip) {
        this.tooltip = tooltip;
        return this;
    }

    public Option toolbox(Toolbox toolbox) {
        this.toolbox = toolbox;
        return this;
    }

    public Option brush(Brush brush) {
        this.brush = brush;
        return this;
    }

    public Option geo(Geo geo) {
        this.geo = geo;
        return this;
    }

    public Option parallel(Parallel parallel) {
        this.parallel = parallel;
        return this;
    }

    public Option parallelAxis(ParallelAxis parallelAxis) {
        this.parallelAxis = parallelAxis;
        return this;
    }

    public Option singleAxis(SingleAxis singleAxis) {
        this.singleAxis = singleAxis;
        return this;
    }

    public Option timeline(Timeline timeline) {
        this.timeline = timeline;
        return this;
    }

    public Option addSerie(Serie serie) {
        if (series == null) {
            series = new HashSet<>(18);
        }
        series.add(serie);
        return this;
    }

    public Option color(Collection<String> colors) {
        if (colors == null || colors.isEmpty()) {
            this.color = null;
        } else {
            this.color = new LinkedList<>(colors);
        }
        return this;
    }

    public Option bgColor(String bgColor) {
        this.backgroundColor = bgColor;
        return this;
    }

    public Option textStyle(TextStyle textStyle) {
        this.textStyle = textStyle;
        return this;
    }

    public Option progressive(Integer progressive) {
        this.progressive = progressive;
        return this;
    }

    public Option progressiveThreshold(Integer progressiveThreshold) {
        this.progressiveThreshold = progressiveThreshold;
        return this;
    }

    public Option blendMode(String blendMode) {
        this.blendMode = blendMode;
        return this;
    }

    public Option hoverLayerThreshold(Integer hoverLayerThreshold) {
        this.hoverLayerThreshold = hoverLayerThreshold;
        return this;
    }

    public Title getTitle() {
        return title;
    }

    public void setTitle(Title title) {
        this.title = title;
    }

    public Legend getLegend() {
        return legend;
    }

    public void setLegend(Legend legend) {
        this.legend = legend;
    }

    public Grid getGrid() {
        return grid;
    }

    public void setGrid(Grid grid) {
        this.grid = grid;
    }

    public CartesianAxis getxAxis() {
        return xAxis;
    }

    public void setxAxis(CartesianAxis xAxis) {
        this.xAxis = xAxis;
    }

    public CartesianAxis getyAxis() {
        return yAxis;
    }

    public void setyAxis(CartesianAxis yAxis) {
        this.yAxis = yAxis;
    }

    public Polar getPolar() {
        return polar;
    }

    public void setPolar(Polar polar) {
        this.polar = polar;
    }

    public RadiusAxis getRadiusAxis() {
        return radiusAxis;
    }

    public void setRadiusAxis(RadiusAxis radiusAxis) {
        this.radiusAxis = radiusAxis;
    }

    public AngleAxis getAngleAxis() {
        return angleAxis;
    }

    public void setAngleAxis(AngleAxis angleAxis) {
        this.angleAxis = angleAxis;
    }

    public Radar getRadar() {
        return radar;
    }

    public void setRadar(Radar radar) {
        this.radar = radar;
    }

    public Set<DataZoom> getDataZooms() {
        return dataZooms;
    }

    public void setDataZooms(Set<DataZoom> dataZooms) {
        this.dataZooms = dataZooms;
    }

    public Set<VisualMap<?>> getVisualMaps() {
        return visualMaps;
    }

    public void setVisualMaps(Set<VisualMap<?>> visualMaps) {
        this.visualMaps = visualMaps;
    }

    public Tooltip getTooltip() {
        return tooltip;
    }

    public void setTooltip(Tooltip tooltip) {
        this.tooltip = tooltip;
    }

    public Toolbox getToolbox() {
        return toolbox;
    }

    public void setToolbox(Toolbox toolbox) {
        this.toolbox = toolbox;
    }

    public Brush getBrush() {
        return brush;
    }

    public void setBrush(Brush brush) {
        this.brush = brush;
    }

    public Geo getGeo() {
        return geo;
    }

    public void setGeo(Geo geo) {
        this.geo = geo;
    }

    public Parallel getParallel() {
        return parallel;
    }

    public void setParallel(Parallel parallel) {
        this.parallel = parallel;
    }

    public ParallelAxis getParallelAxis() {
        return parallelAxis;
    }

    public void setParallelAxis(ParallelAxis parallelAxis) {
        this.parallelAxis = parallelAxis;
    }

    public SingleAxis getSingleAxis() {
        return singleAxis;
    }

    public void setSingleAxis(SingleAxis singleAxis) {
        this.singleAxis = singleAxis;
    }

    public Timeline getTimeline() {
        return timeline;
    }

    public void setTimeline(Timeline timeline) {
        this.timeline = timeline;
    }

    public Set<Serie> getSeries() {
        return series;
    }

    public void setSeries(Set<Serie> series) {
        this.series = series;
    }

    public List<String> getColor() {
        return color;
    }

    public void setColor(List<String> color) {
        this.color = color;
    }

    public String getBackgroundColor() {
        return backgroundColor;
    }

    public void setBackgroundColor(String backgroundColor) {
        this.backgroundColor = backgroundColor;
    }

    public TextStyle getTextStyle() {
        return textStyle;
    }

    public void setTextStyle(TextStyle textStyle) {
        this.textStyle = textStyle;
    }

    public Integer getProgressive() {
        return progressive;
    }

    public void setProgressive(Integer progressive) {
        this.progressive = progressive;
    }

    public Integer getProgressiveThreshold() {
        return progressiveThreshold;
    }

    public void setProgressiveThreshold(Integer progressiveThreshold) {
        this.progressiveThreshold = progressiveThreshold;
    }

    public String getBlendMode() {
        return blendMode;
    }

    public void setBlendMode(String blendMode) {
        this.blendMode = blendMode;
    }

    public Integer getHoverLayerThreshold() {
        return hoverLayerThreshold;
    }

    public void setHoverLayerThreshold(Integer hoverLayerThreshold) {
        this.hoverLayerThreshold = hoverLayerThreshold;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Option)) return false;
        if (!super.equals(o)) return false;
        Option option = (Option) o;
        return Objects.equals(title, option.title) &&
                Objects.equals(legend, option.legend) &&
                Objects.equals(grid, option.grid) &&
                Objects.equals(xAxis, option.xAxis) &&
                Objects.equals(yAxis, option.yAxis) &&
                Objects.equals(polar, option.polar) &&
                Objects.equals(radiusAxis, option.radiusAxis) &&
                Objects.equals(angleAxis, option.angleAxis) &&
                Objects.equals(radar, option.radar) &&
                Objects.equals(dataZooms, option.dataZooms) &&
                Objects.equals(visualMaps, option.visualMaps) &&
                Objects.equals(tooltip, option.tooltip) &&
                Objects.equals(toolbox, option.toolbox) &&
                Objects.equals(brush, option.brush) &&
                Objects.equals(geo, option.geo) &&
                Objects.equals(parallel, option.parallel) &&
                Objects.equals(parallelAxis, option.parallelAxis) &&
                Objects.equals(singleAxis, option.singleAxis) &&
                Objects.equals(timeline, option.timeline) &&
                Objects.equals(series, option.series) &&
                Objects.equals(color, option.color) &&
                Objects.equals(backgroundColor, option.backgroundColor) &&
                textStyle == option.textStyle &&
                Objects.equals(progressive, option.progressive) &&
                Objects.equals(progressiveThreshold, option.progressiveThreshold) &&
                Objects.equals(blendMode, option.blendMode) &&
                Objects.equals(hoverLayerThreshold, option.hoverLayerThreshold);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), title, legend, grid, xAxis, yAxis, polar, radiusAxis,
                angleAxis, radar, dataZooms, visualMaps, tooltip, toolbox, brush, geo, parallel,
                parallelAxis, singleAxis, timeline, series, color, backgroundColor, textStyle,
                progressive, progressiveThreshold, blendMode, hoverLayerThreshold);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder(32)
                .append(getClass()).append("{");
        sb.append("title=").append(title);
        sb.append(", legend=").append(legend);
        sb.append(", grid=").append(grid);
        sb.append(", xAxis=").append(xAxis);
        sb.append(", yAxis=").append(yAxis);
        sb.append(", polar=").append(polar);
        sb.append(", radiusAxis=").append(radiusAxis);
        sb.append(", angleAxis=").append(angleAxis);
        sb.append(", radar=").append(radar);
        sb.append(", dataZooms=").append(dataZooms);
        sb.append(", visualMaps=").append(visualMaps);
        sb.append(", tooltip=").append(tooltip);
        sb.append(", toolbox=").append(toolbox);
        sb.append(", brush=").append(brush);
        sb.append(", geo=").append(geo);
        sb.append(", parallel=").append(parallel);
        sb.append(", parallelAxis=").append(parallelAxis);
        sb.append(", singleAxis=").append(singleAxis);
        sb.append(", timeline=").append(timeline);
        sb.append(", series=").append(series);
        sb.append(", color=").append(color);
        sb.append(", backgroundColor='").append(backgroundColor).append('\'');
        sb.append(", textStyle=").append(textStyle);
        appendAnimation(sb);
        sb.append(", progressive=").append(progressive);
        sb.append(", progressiveThreshold=").append(progressiveThreshold);
        sb.append(", blendMode='").append(blendMode).append('\'');
        sb.append(", hoverLayerThreshold=").append(hoverLayerThreshold);
        sb.append('}');
        return sb.toString();
    }
}
