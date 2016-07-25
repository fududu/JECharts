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
import org.aying.echarts.base.CoordinateSystem;
import org.aying.echarts.base.Position;
import org.aying.echarts.base.SimplePosition;
import org.aying.echarts.base.SimpleSize;
import org.aying.echarts.base.Size;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

/**
 * 树图系列样式。
 *
 * @author Fuchun
 * @since 1.0
 */
public class TreeMapSerie extends BaseSerie<TreeMapSerie>
        implements Position<TreeMapSerie>, Size<TreeMapSerie> {

    private static final long serialVersionUID = -6989958138682423400L;

    private final SimplePosition sp;
    private final SimpleSize ss;

    /*期望矩形长宽比率。默认为黄金比：0.5 * (1 + Math.sqrt(5))。 */
    private Double squareRatio;
    private Integer leafDepth;
    /*是否开启拖拽漫游（移动和缩放）。 boolean|Roam */
    private Object roam;
    private Object nodeClick;
    /*点击某个节点，会自动放大那个节点到合适的比例（节点占可视区域的面积比例），这个配置项就是这个比例。*/
    private Double zoomToNodeRatio;
    private List<TreeLevel> levels;
    /*treemap 中支持对数据其他维度进行视觉映射。*/
    private Integer visualDimension;
    /*本系列默认的 颜色透明度 选取范围。数值范围 0 ~ 1。*/
    private Object[] colorAlpha;
    /*本系列默认的 颜色饱和度 选取范围。数值范围 0 ~ 1。*/
    private Double colorSaturation;
    /*表示同一层级节点，在颜色列表中（参见 color 属性）选择时，按照什么来选择。*/
    private ColorMappingBy colorMappingBy;
    /*如果某个节点的矩形的面积，小于这个数值（单位：px平方），这个节点就不显示。*/
    private Integer visibleMin;
    /*如果某个节点的矩形面积，小于这个数值（单位：px平方），则不显示这个节点的子节点。*/
    private Double childrenVisibleMin;
    private Breadcrumb breadcrumb;

    public TreeMapSerie() {
        super(ChartType.treemap, false);
        sp = new SimplePosition();
        ss = new SimpleSize();
    }

    @Override
    @JsonIgnore
    public CoordinateSystem getCoordinateSystem() {
        return super.getCoordinateSystem();
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
    public TreeMapSerie left(Object left) {
        sp.left(left);
        return this;
    }

    @Override
    public TreeMapSerie right(Object right) {
        sp.right(right);
        return this;
    }

    @Override
    public TreeMapSerie top(Object top) {
        sp.top(top);
        return this;
    }

    @Override
    public TreeMapSerie bottom(Object bottom) {
        sp.bottom(bottom);
        return this;
    }

    @Override
    public Object getWidth() {
        return ss.getWidth();
    }

    @Override
    public void setWidth(Object width) {
        ss.setWidth(width);
    }

    @Override
    public Object getHeight() {
        return ss.getHeight();
    }

    @Override
    public void setHeight(Object height) {
        ss.setHeight(height);
    }

    @Override
    public TreeMapSerie autoWidth() {
        ss.autoWidth();
        return this;
    }

    @Override
    public TreeMapSerie autoHeight() {
        ss.autoHeight();
        return this;
    }

    @Override
    public TreeMapSerie width(int width) {
        ss.width(width);
        return this;
    }

    @Override
    public TreeMapSerie width(String width) {
        ss.width(width);
        return this;
    }

    @Override
    public TreeMapSerie height(int height) {
        ss.height(height);
        return this;
    }

    @Override
    public TreeMapSerie height(String height) {
        ss.height(height);
        return this;
    }

    public Double getSquareRatio() {
        return squareRatio;
    }

    public void setSquareRatio(Double squareRatio) {
        this.squareRatio = squareRatio;
    }

    public Integer getLeafDepth() {
        return leafDepth;
    }

    public void setLeafDepth(Integer leafDepth) {
        this.leafDepth = leafDepth;
    }

    public Object getRoam() {
        return roam;
    }

    public void setRoam(Object roam) {
        this.roam = roam;
    }

    public Object getNodeClick() {
        return nodeClick;
    }

    public void setNodeClick(Object nodeClick) {
        this.nodeClick = nodeClick;
    }

    public Double getZoomToNodeRatio() {
        return zoomToNodeRatio;
    }

    public void setZoomToNodeRatio(Double zoomToNodeRatio) {
        this.zoomToNodeRatio = zoomToNodeRatio;
    }

    public List<TreeLevel> getLevels() {
        return levels;
    }

    public void setLevels(List<TreeLevel> levels) {
        this.levels = levels;
    }

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

    public Double getColorSaturation() {
        return colorSaturation;
    }

    public void setColorSaturation(Double colorSaturation) {
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

    public Breadcrumb getBreadcrumb() {
        return breadcrumb;
    }

    public void setBreadcrumb(Breadcrumb breadcrumb) {
        this.breadcrumb = breadcrumb;
    }

    @Override
    @JsonIgnore
    public MarkPoint getMarkPoint() {
        return super.getMarkPoint();
    }

    @Override
    @JsonIgnore
    public MarkLine getMarkLine() {
        return super.getMarkLine();
    }

    @Override
    @JsonIgnore
    public MarkArea getMarkArea() {
        return super.getMarkArea();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof TreeMapSerie)) return false;
        if (!super.equals(o)) return false;
        TreeMapSerie that = (TreeMapSerie) o;
        return Objects.equals(sp, that.sp) &&
                Objects.equals(ss, that.ss) &&
                Objects.equals(squareRatio, that.squareRatio) &&
                Objects.equals(leafDepth, that.leafDepth) &&
                Objects.equals(roam, that.roam) &&
                Objects.equals(nodeClick, that.nodeClick) &&
                Objects.equals(zoomToNodeRatio, that.zoomToNodeRatio) &&
                Objects.equals(levels, that.levels) &&
                Objects.equals(visualDimension, that.visualDimension) &&
                Arrays.equals(colorAlpha, that.colorAlpha) &&
                Objects.equals(colorSaturation, that.colorSaturation) &&
                colorMappingBy == that.colorMappingBy &&
                Objects.equals(visibleMin, that.visibleMin) &&
                Objects.equals(childrenVisibleMin, that.childrenVisibleMin) &&
                Objects.equals(breadcrumb, that.breadcrumb);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), sp, ss, squareRatio, leafDepth, roam, nodeClick,
                zoomToNodeRatio, levels, visualDimension, colorAlpha, colorSaturation, colorMappingBy,
                visibleMin, childrenVisibleMin, breadcrumb);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("org.aying.echarts.series.TreeMapSerie{");
        appendPrefix(sb);
        appendCanvasZ(sb);
        sp.appendPosition(sb);
        ss.appendSize(sb);
        sb.append(", squareRatio=").append(squareRatio);
        sb.append(", leafDepth=").append(leafDepth);
        sb.append(", roam=").append(roam);
        sb.append(", nodeClick=").append(nodeClick);
        sb.append(", zoomToNodeRatio=").append(zoomToNodeRatio);
        sb.append(", levels=").append(levels);
        sb.append(", visualDimension=").append(visualDimension);
        sb.append(", colorAlpha=").append(Arrays.toString(colorAlpha));
        sb.append(", colorSaturation=").append(colorSaturation);
        sb.append(", colorMappingBy=").append(colorMappingBy);
        sb.append(", visibleMin=").append(visibleMin);
        sb.append(", childrenVisibleMin=").append(childrenVisibleMin);
        sb.append(", label=").append(getLabel());
        sb.append(", itemStyle=").append(getItemStyle());
        sb.append(", breadcrumb=").append(breadcrumb);
        sb.append(", data=").append(getData());
        appendAnimation(sb);
        sb.append('}');
        return sb.toString();
    }
}
