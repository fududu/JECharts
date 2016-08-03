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

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import org.aying.echarts.base.Graph;
import org.aying.echarts.base.Limit;
import org.aying.echarts.base.SelectedMode;
import org.aying.echarts.base.SimpleLabel;
import org.aying.echarts.style.ShapeStyle;
import org.aying.echarts.style.SimpleShapeStyle;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/**
 * 地理坐标系组件。
 *
 * @author Fuchun
 * @since 1.0
 */
public class Geo extends Graph<Geo> {

    private static final long serialVersionUID = -3482369359758760964L;

    public static Geo geo() {
        return new Geo();
    }

    public static Geo map(String map) {
        return new Geo(map);
    }

    private Boolean show;
    /* 地图类型。 */
    private String map;
    /* 是否开启鼠标缩放和平移漫游。默认：false */
    private Boolean roam;
    /* 当前视角的中心点，用经纬度表示 */
    private List<Double> center;
    /* 当前视角的缩放比例。默认：1*/
    private Integer zoom;
    /* 滚轮缩放的极限控制，通过min, max最小和最大的缩放值，默认的缩放为1。 */
    private Limit.DoubleLimit scaleLimit;
    /* 自定义地区的名称映射 */
    private Map<String, String> nameMap;
    /* 选中模型。支持 SelectedMode 和 Boolean，默认：false */
    private Object selectedMode;
    /* 图形上的文本标签，可用于说明图形的一些数据信息，比如值，名称等 */
    private Map<String, SimpleLabel> label;
    /* 地图区域的多边形 图形样式，有 normal 和 emphasis 两个状态。 */
    private Map<String, ShapeStyle> itemStyle;
    /* layoutCenter 和 layoutSize 提供了除了 left/right/top/bottom/width/height 之外的布局手段。 */
    private List<Object> layoutCenter;
    /* 地图的大小，见 layoutCenter。支持相对于屏幕宽高的百分比或者绝对的像素大小。 String|Integer */
    private Object layoutSize;
    /* 地图指定区域的具体描述，可以用与自定义部分区域的样式，选择指定的区域。 */
    private List<GeoRegion> regions;
    /* 图形是否响应和触发鼠标事件。默认：false */
    private Boolean silent;

    public Geo() {
        super();
    }

    public Geo(String map) {
        this.map = map;
    }

    /**
     * 设置当前视角的中心点位置（经纬度）
     *
     * @param longitude 经度。
     * @param latitude 纬度。
     */
    public Geo center(double longitude, double latitude) {
        this.center = Arrays.asList(longitude, latitude);
        return this;
    }

    /**
     * 鼠标滚轮缩放的限制。
     *
     * @param min 最小缩放值。
     * @param max 最大缩放值。
     */
    public Geo scaleLimit(double min, double max) {
        this.scaleLimit = Limit.doubleLimit(min, max);
        return this;
    }

    /**
     * 设置自定义地区的名称映射。
     * <pre>{@code
     * {
     *     "China": "中国", "Vietnam": "越南"
     * }
     * }</pre>
     *
     * @param nameMap 自定义地区的名称映射
     */
    public Geo nameMap(Map<String, String> nameMap) {
        this.nameMap = nameMap;
        return this;
    }

    /**
     * 设置普通状态下的多边形样式。
     *
     * @param style 多边形样式。
     */
    public Geo normalStyle(ShapeStyle style) {
        return itemStyle("normal", style);
    }

    /**
     * 设置高亮状态下的多边形样式。
     *
     * @param style 多边形样式。
     */
    public Geo emphasisStyle(ShapeStyle style) {
        return itemStyle("emphasis", style);
    }

    /**
     * 设置普通状态下的标签属性及样式。
     *
     * @param label 标签属性及样式。
     */
    public Geo normalLabel(SimpleLabel label) {
        return label("normal", label);
    }

    /**
     * 设置高亮状态下的标签属性及样式。
     *
     * @param label 标签属性及样式。
     */
    public Geo emphasisLabel(SimpleLabel label) {
        return label("emphasis", label);
    }

    /**
     * 设置支持单选模式。
     */
    public Geo singleMode() {
        this.selectedMode = SelectedMode.single;
        return this;
    }

    /**
     * 设置支持选中多个
     */
    public Geo multipleMode() {
        this.selectedMode = SelectedMode.multiple;
        return this;
    }

    public Geo regions(GeoRegion region, GeoRegion... rn) {
        if (regions == null) {
            regions = new ArrayList<>();
        }
        regions.add(0, region);
        if (rn != null && rn.length > 0) {
            int i = 1;
            for (GeoRegion r : rn) {
                regions.add(i++, r);
            }
        }
        return this;
    }

    /**
     * {@code layoutCenter} 和{@code layoutSize} 提供了除了{@code left/right/top/bottom/width/height} 之外的布局手段。
     * <p />
     * 在使用{@code left/right/top/bottom/width/height} 的时候，可能很难在保持地图高宽比的情况下把地图放在某个盒形区域的正中间，
     * 并且保证不超出盒形的范围。此时可以通过{@code layoutCenter} 属性定义地图中心在屏幕中的位置，{@code layoutSize} 定义地图的大小。
     * <pre>{@code
     * layoutCenter: ['30%', '30%'],
     * // 如果宽高比大于 1 则宽度为 100，如果小于 1 则高度为 100，保证了不超过 100x100 的区域
     * layoutSize: 100
     * }</pre>
     *
     * @param center 地图中心在屏幕中的位置。
     * @param size 地图的大小
     */
    public Geo layout(Object[] center, Object size) {
        if (center != null && center.length == 2) {
            this.layoutCenter = new ArrayList<>(center.length);
            for (int i = 0; i < 2; i++) {
                this.layoutCenter.add(i, center[i]);
            }
        } else {
            this.layoutCenter = null;
        }
        this.layoutSize = size;
        return this;
    }

    protected Geo label(String key, SimpleLabel label) {
        if (this.label == null) {
            this.label = new HashMap<>(2);
        }
        this.label.put(key, label);
        return this;
    }

    protected Geo itemStyle(String key, ShapeStyle style) {
        if (itemStyle == null) {
            itemStyle = new HashMap<>(2);
        }
        itemStyle.put(key, style);
        return this;
    }

    public Boolean getShow() {
        return show;
    }

    public void setShow(Boolean show) {
        this.show = show;
    }

    public String getMap() {
        return map;
    }

    public void setMap(String map) {
        this.map = map;
    }

    public Boolean getRoam() {
        return roam;
    }

    public void setRoam(Boolean roam) {
        this.roam = roam;
    }

    public List<Double> getCenter() {
        return center;
    }

    public void setCenter(List<Double> center) {
        this.center = center;
    }

    public Integer getZoom() {
        return zoom;
    }

    public void setZoom(Integer zoom) {
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

    public Map<String, SimpleLabel> getLabel() {
        return label;
    }

    public void setLabel(Map<String, SimpleLabel> label) {
        this.label = label;
    }

    @JsonDeserialize(contentAs = SimpleShapeStyle.class)
    public Map<String, ShapeStyle> getItemStyle() {
        return itemStyle;
    }

    public void setItemStyle(Map<String, ShapeStyle> itemStyle) {
        this.itemStyle = itemStyle;
    }

    public List<Object> getLayoutCenter() {
        return layoutCenter;
    }

    public void setLayoutCenter(List<Object> layoutCenter) {
        this.layoutCenter = layoutCenter;
    }

    public Object getLayoutSize() {
        return layoutSize;
    }

    public void setLayoutSize(Object layoutSize) {
        this.layoutSize = layoutSize;
    }

    public List<GeoRegion> getRegions() {
        return regions;
    }

    public void setRegions(List<GeoRegion> regions) {
        this.regions = regions;
    }

    public Boolean getSilent() {
        return silent;
    }

    public void setSilent(Boolean silent) {
        this.silent = silent;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Geo)) return false;
        if (!super.equals(o)) return false;
        Geo geo = (Geo) o;
        return Objects.equals(show, geo.show) &&
                Objects.equals(map, geo.map) &&
                Objects.equals(roam, geo.roam) &&
                Objects.equals(center, geo.center) &&
                Objects.equals(zoom, geo.zoom) &&
                Objects.equals(scaleLimit, geo.scaleLimit) &&
                Objects.equals(nameMap, geo.nameMap) &&
                Objects.equals(selectedMode, geo.selectedMode) &&
                Objects.equals(label, geo.label) &&
                Objects.equals(itemStyle, geo.itemStyle) &&
                Objects.equals(layoutCenter, geo.layoutCenter) &&
                Objects.equals(layoutSize, geo.layoutSize) &&
                Objects.equals(regions, geo.regions) &&
                Objects.equals(silent, geo.silent);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), show, map, roam, center, zoom, scaleLimit, nameMap,
                selectedMode, label, itemStyle, layoutCenter, layoutSize, regions, silent);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder(32)
                .append(getClass()).append("{");
        sb.append("show=").append(show);
        sb.append(", map='").append(map).append('\'');
        sb.append(", roam=").append(roam);
        sb.append(", center=").append(center);
        sb.append(", zoom=").append(zoom);
        sb.append(", scaleLimit=").append(scaleLimit);
        sb.append(", nameMap=").append(nameMap);
        sb.append(", selectedMode=").append(selectedMode);
        sb.append(", label=").append(label);
        sb.append(", itemStyle=").append(itemStyle);
        sb.append(", layoutCenter=").append(layoutCenter);
        sb.append(", layoutSize=").append(layoutSize);
        sb.append(", regions=").append(regions);
        sb.append(", silent=").append(silent);
        sb.append('}');
        return sb.toString();
    }
}
