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

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.aying.echarts.ChartType;
import org.aying.echarts.base.AnimationEasing;
import org.aying.echarts.base.CoordinateSystem;
import org.aying.echarts.base.Limit;
import org.aying.echarts.base.Position;
import org.aying.echarts.base.Sampling;
import org.aying.echarts.base.SimplePosition;

import java.util.Arrays;
import java.util.Map;
import java.util.Objects;

/**
 * 地图系列配置。
 * <p />
 * 地图主要用于地理区域数据的可视化，配合 visualMap 组件用于展示不同区域的人口分布密度等数据。
 * 多个地图类型相同的系列会在同一地图上显示，这时候使用第一个系列的配置项作为地图绘制的配置。
 * <p />
 * Tip: 在 ECharts 3 中不再建议在地图类型的图表使用 markLine 和 markPoint。
 * 如果要实现点数据或者线数据的可视化，可以使用在地理坐标系组件上的散点图和线图。
 *
 * @author Fuchun
 * @since 1.0
 */
public class MapSerie extends BaseSerie<MapSerie>
        implements Position<MapSerie> {

    private static final long serialVersionUID = -5523803918487404105L;

    private final SimplePosition sp;

    private String map;
    /* 是否开启鼠标缩放和平移漫游。默认不开启。 */
    private Object roam;
    /* 当前视角的中心点，用经纬度表示 */
    private Double[] center;
    /* 当前视角的缩放比例。 */
    private Double zoom;
    /* 滚轮缩放的极限控制，通过min, max最小和最大的缩放值，默认的缩放为1。 */
    private Limit.DoubleLimit scaleLimit;
    /* 自定义地区的名称映射 */
    private Map<String, String> nameMap;
    /* 选中模式 Boolean|SelectedMode */
    private Object selectedMode;

    private Object[] layoutCenter;
    private Object layoutSize;
    private Sampling mapValueCalculation;
    /*在图例相应区域显示图例的颜色标识（系列标识的小圆点），存在 legend 组件时生效。*/
    private Boolean showLegendSymbol;

    public MapSerie() {
        super(ChartType.map);
        sp = new SimplePosition();
    }

    @Override
    public Object getLeft() {
        return sp.getLeft();
    }

    public void setLeft(Object left) {
        sp.setLeft(left);
    }

    @Override
    public Object getRight() {
        return sp.getRight();
    }

    public void setRight(Object right) {
        sp.setRight(right);
    }

    @Override
    public Object getTop() {
        return sp.getTop();
    }

    public void setTop(Object top) {
        sp.setTop(top);
    }

    @Override
    public Object getBottom() {
        return sp.getBottom();
    }

    public void setBottom(Object bottom) {
        sp.setBottom(bottom);
    }

    @Override
    public MapSerie left(Object left) {
        sp.left(left);
        return this;
    }

    @Override
    public MapSerie right(Object right) {
        sp.right(right);
        return this;
    }

    @Override
    public MapSerie top(Object top) {
        sp.top(top);
        return this;
    }

    @Override
    public MapSerie bottom(Object bottom) {
        sp.bottom(bottom);
        return this;
    }

    public String getMap() {
        return map;
    }

    public void setMap(String map) {
        this.map = map;
    }

    public Object getRoam() {
        return roam;
    }

    public void setRoam(Object roam) {
        this.roam = roam;
    }

    public Double[] getCenter() {
        return center;
    }

    public void setCenter(Double[] center) {
        this.center = center;
    }

    public Double getZoom() {
        return zoom;
    }

    public void setZoom(Double zoom) {
        this.zoom = zoom;
    }

    public Limit.DoubleLimit getScaleLimit() {
        return scaleLimit;
    }

    public void setScaleLimit(Limit.DoubleLimit scaleLimit) {
        this.scaleLimit = scaleLimit;
    }

    public Map<String, String> getNameMap() {
        return nameMap;
    }

    public void setNameMap(Map<String, String> nameMap) {
        this.nameMap = nameMap;
    }

    public Object getSelectedMode() {
        return selectedMode;
    }

    public void setSelectedMode(Object selectedMode) {
        this.selectedMode = selectedMode;
    }

    public Object[] getLayoutCenter() {
        return layoutCenter;
    }

    public void setLayoutCenter(Object[] layoutCenter) {
        this.layoutCenter = layoutCenter;
    }

    public Object getLayoutSize() {
        return layoutSize;
    }

    public void setLayoutSize(Object layoutSize) {
        this.layoutSize = layoutSize;
    }

    public Sampling getMapValueCalculation() {
        return mapValueCalculation;
    }

    public void setMapValueCalculation(Sampling mapValueCalculation) {
        this.mapValueCalculation = mapValueCalculation;
    }

    public Boolean getShowLegendSymbol() {
        return showLegendSymbol;
    }

    public void setShowLegendSymbol(Boolean showLegendSymbol) {
        this.showLegendSymbol = showLegendSymbol;
    }

    @Override
    @JsonIgnore
    public CoordinateSystem getCoordinateSystem() {
        return super.getCoordinateSystem();
    }

    @Override
    @JsonIgnore
    public Boolean getAnimation() {
        return super.getAnimation();
    }

    @Override
    @JsonIgnore
    public Integer getAnimationThreshold() {
        return super.getAnimationThreshold();
    }

    @Override
    @JsonIgnore
    public Integer getAnimationDuration() {
        return super.getAnimationDuration();
    }

    @Override
    @JsonIgnore
    public AnimationEasing getAnimationEasing() {
        return super.getAnimationEasing();
    }

    @Override
    @JsonIgnore
    public Object getAnimationDelay() {
        return super.getAnimationDelay();
    }

    @Override
    @JsonIgnore
    public Integer getAnimationDurationUpdate() {
        return super.getAnimationDurationUpdate();
    }

    @Override
    @JsonIgnore
    public AnimationEasing getAnimationEasingUpdate() {
        return super.getAnimationEasingUpdate();
    }

    @Override
    @JsonIgnore
    public Object getAnimationDelayUpdate() {
        return super.getAnimationDelayUpdate();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof MapSerie)) return false;
        if (!super.equals(o)) return false;
        MapSerie mapSerie = (MapSerie) o;
        return Objects.equals(sp, mapSerie.sp) &&
                Objects.equals(map, mapSerie.map) &&
                Objects.equals(roam, mapSerie.roam) &&
                Arrays.equals(center, mapSerie.center) &&
                Objects.equals(zoom, mapSerie.zoom) &&
                Objects.equals(scaleLimit, mapSerie.scaleLimit) &&
                Objects.equals(nameMap, mapSerie.nameMap) &&
                Objects.equals(selectedMode, mapSerie.selectedMode) &&
                Arrays.equals(layoutCenter, mapSerie.layoutCenter) &&
                Objects.equals(layoutSize, mapSerie.layoutSize) &&
                mapValueCalculation == mapSerie.mapValueCalculation &&
                Objects.equals(showLegendSymbol, mapSerie.showLegendSymbol);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), sp, map, roam, center, zoom, scaleLimit, nameMap,
                selectedMode, layoutCenter, layoutSize, mapValueCalculation, showLegendSymbol);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder(32)
                .append(getClass()).append("{");
        appendPrefix(sb);
        sb.append(", map='").append(map).append('\'');
        sb.append(", roam=").append(roam);
        sb.append(", center=").append(Arrays.toString(center));
        sb.append(", zoom=").append(zoom);
        sb.append(", scaleLimit=").append(scaleLimit);
        sb.append(", nameMap=").append(nameMap);
        sb.append(", selectedMode=").append(selectedMode);
        sb.append(", label=").append(getLabel());
        sb.append(", itemStyle=").append(getItemStyle());
        appendCanvasZ(sb);
        sp.appendPosition(sb);
        sb.append(", layoutCenter=").append(Arrays.toString(layoutCenter));
        sb.append(", layoutSize=").append(layoutSize);
        sb.append(", mapValueCalculation=").append(mapValueCalculation);
        sb.append(", showLegendSymbol=").append(showLegendSymbol);
        sb.append(", data=").append(getData());
        appendMarks(sb);
        sb.append('}');
        return sb.toString();
    }
}
