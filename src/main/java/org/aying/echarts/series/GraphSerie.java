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

import org.aying.echarts.ChartType;
import org.aying.echarts.base.*;
import org.aying.echarts.style.StateLineStyle;

import java.util.List;
import java.util.Objects;

/**
 * 关系图系列配置。
 *
 * @author Fuchun
 * @since 1.0
 */
public class GraphSerie extends BaseSerie<GraphSerie, SerieData>
        implements Symbol<GraphSerie>, Position<GraphSerie>, Size<GraphSerie> {

    private static final long serialVersionUID = 5838063241099847182L;

    private final transient SimplePosition sp;
    private final transient SimpleSize sSize;
    private final transient SimpleSymbol sSymbol;

    private Boolean legendHoverLink;
    private Integer xAxisIndex;
    private Integer yAxisIndex;
    private Integer polarIndex;
    private Integer geoIndex;
    private Boolean hoverAnimation;
    private String layout;
    private Force force;
    /* 是否开启鼠标缩放和平移漫游。默认不开启。 */
    private Object roam;
    /*鼠标漫游缩放时节点的相应缩放比例，当设为0时节点不随着鼠标的缩放而缩放。默认：0.6*/
    private Double nodeScaleRatio;
    /*节点是否可拖拽，只在使用力引导布局的时候有用。默认：false */
    private Boolean draggable;
    /*是否在鼠标移到节点上的时候突出显示节点以及节点的边和邻接节点。*/
    private Boolean focusNodeAdjacency;
    /*边两端的标记类型，可以是一个数组分别指定两端，也可以是单个统一指定。默认不显示标记，常见的可以设置为箭头*/
    private Object edgeSymbol;
    /*边两端的标记大小，可以是一个数组分别指定两端，也可以是单个统一指定。*/
    private Object edgeSymbolSize;
    /*关系边的公用线条样式。其中 lineStyle.normal.color 支持设置为'source'或者'target'特殊值，
    此时边会自动取源节点或目标节点的颜色作为自己的颜色。*/
    private StateLineStyle lineStyle;
    /*边缘标签样式*/
    private StateLabel edgeLabel;
    /*节点分类的类目，可选。*/
    private List<Category> categories;
    /*节点间的关系数据。*/
    private List<Link> links;
    /*调色盘颜色列表。如果节点类型没有设置颜色，则会依次循环从该列表中取颜色作为系列颜色。*/
    private List<String> color;

    public GraphSerie() {
        super(ChartType.graph);
        sp = new SimplePosition();
        sSize = new SimpleSize();
        sSymbol = new SimpleSymbol();
    }

    @Override
    public GraphSerie symbol(SymbolType symbolType) {
        sSymbol.symbol(symbolType);
        return this;
    }

    @Override
    public GraphSerie symbolSize(Integer size) {
        sSymbol.symbolSize(size);
        return this;
    }

    @Override
    public GraphSerie symbolSize(int w, int h) {
        sSymbol.symbolSize(w, h);
        return this;
    }

    @Override
    public GraphSerie symbolRotate(Integer rotate) {
        sSymbol.symbolRotate(rotate);
        return this;
    }

    @Override
    public GraphSerie offset(Object x, Object y) {
        sSymbol.offset(x, y);
        return this;
    }

    public Boolean getLegendHoverLink() {
        return legendHoverLink;
    }

    public void setLegendHoverLink(Boolean legendHoverLink) {
        this.legendHoverLink = legendHoverLink;
    }

    public Integer getxAxisIndex() {
        return xAxisIndex;
    }

    public void setxAxisIndex(Integer xAxisIndex) {
        this.xAxisIndex = xAxisIndex;
    }

    public Integer getyAxisIndex() {
        return yAxisIndex;
    }

    public void setyAxisIndex(Integer yAxisIndex) {
        this.yAxisIndex = yAxisIndex;
    }

    public Integer getPolarIndex() {
        return polarIndex;
    }

    public void setPolarIndex(Integer polarIndex) {
        this.polarIndex = polarIndex;
    }

    public Integer getGeoIndex() {
        return geoIndex;
    }

    public void setGeoIndex(Integer geoIndex) {
        this.geoIndex = geoIndex;
    }

    public Boolean getHoverAnimation() {
        return hoverAnimation;
    }

    public void setHoverAnimation(Boolean hoverAnimation) {
        this.hoverAnimation = hoverAnimation;
    }

    public String getLayout() {
        return layout;
    }

    public void setLayout(String layout) {
        this.layout = layout;
    }

    public Force getForce() {
        return force;
    }

    public void setForce(Force force) {
        this.force = force;
    }

    public Object getRoam() {
        return roam;
    }

    public void setRoam(Object roam) {
        this.roam = roam;
    }

    public Double getNodeScaleRatio() {
        return nodeScaleRatio;
    }

    public void setNodeScaleRatio(Double nodeScaleRatio) {
        this.nodeScaleRatio = nodeScaleRatio;
    }

    public Boolean getDraggable() {
        return draggable;
    }

    public void setDraggable(Boolean draggable) {
        this.draggable = draggable;
    }

    public Boolean getFocusNodeAdjacency() {
        return focusNodeAdjacency;
    }

    public void setFocusNodeAdjacency(Boolean focusNodeAdjacency) {
        this.focusNodeAdjacency = focusNodeAdjacency;
    }

    @Override
    public SymbolType getSymbol() {
        return sSymbol.getSymbol();
    }

    public void setSymbol(SymbolType symbol) {
        sSymbol.setSymbol(symbol);
    }

    @Override
    public Object getSymbolSize() {
        return sSymbol.getSymbolSize();
    }

    public void setSymbolSize(Object symbolSize) {
        sSymbol.setSymbolSize(symbolSize);
    }

    @Override
    public Integer getSymbolRotate() {
        return sSymbol.getSymbolRotate();
    }

    public void setSymbolRotate(Integer symbolRotate) {
        sSymbol.setSymbolRotate(symbolRotate);
    }

    @Override
    public Object[] getSymbolOffset() {
        return sSymbol.getSymbolOffset();
    }

    public void setSymbolOffset(Object[] symbolOffset) {
        sSymbol.setSymbolOffset(symbolOffset);
    }

    public Object getEdgeSymbol() {
        return edgeSymbol;
    }

    public void setEdgeSymbol(Object edgeSymbol) {
        this.edgeSymbol = edgeSymbol;
    }

    public Object getEdgeSymbolSize() {
        return edgeSymbolSize;
    }

    public void setEdgeSymbolSize(Object edgeSymbolSize) {
        this.edgeSymbolSize = edgeSymbolSize;
    }

    public StateLineStyle getLineStyle() {
        return lineStyle;
    }

    public void setLineStyle(StateLineStyle lineStyle) {
        this.lineStyle = lineStyle;
    }

    public StateLabel getEdgeLabel() {
        return edgeLabel;
    }

    public void setEdgeLabel(StateLabel edgeLabel) {
        this.edgeLabel = edgeLabel;
    }

    public List<Category> getCategories() {
        return categories;
    }

    public void setCategories(List<Category> categories) {
        this.categories = categories;
    }

    public List<Link> getLinks() {
        return links;
    }

    public void setLinks(List<Link> links) {
        this.links = links;
    }

    public void setNodes(List<SerieData> nodes) {
        setData(nodes);
    }

    public void setEdges(List<Link> edges) {
        this.links = edges;
    }

    public List<String> getColor() {
        return color;
    }

    public void setColor(List<String> color) {
        this.color = color;
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
    public GraphSerie left(Object left) {
        sp.left(left);
        return this;
    }

    @Override
    public GraphSerie right(Object right) {
        sp.right(right);
        return this;
    }

    @Override
    public GraphSerie top(Object top) {
        sp.top(top);
        return this;
    }

    @Override
    public GraphSerie bottom(Object bottom) {
        sp.bottom(bottom);
        return this;
    }

    @Override
    public Object getWidth() {
        return sSize.getWidth();
    }

    @Override
    public void setWidth(Object width) {
        sSize.setWidth(width);
    }

    @Override
    public Object getHeight() {
        return sSize.getHeight();
    }

    @Override
    public void setHeight(Object height) {
        sSize.setHeight(height);
    }

    @Override
    public GraphSerie autoWidth() {
        sSize.autoWidth();
        return this;
    }

    @Override
    public GraphSerie autoHeight() {
        sSize.autoHeight();
        return this;
    }

    @Override
    public GraphSerie width(int width) {
        sSize.width(width);
        return this;
    }

    @Override
    public GraphSerie width(String width) {
        sSize.width(width);
        return this;
    }

    @Override
    public GraphSerie height(int height) {
        sSize.height(height);
        return this;
    }

    @Override
    public GraphSerie height(String height) {
        sSize.height(height);
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof GraphSerie)) return false;
        if (!super.equals(o)) return false;
        GraphSerie that = (GraphSerie) o;
        return Objects.equals(sp, that.sp) &&
                Objects.equals(sSize, that.sSize) &&
                Objects.equals(legendHoverLink, that.legendHoverLink) &&
                Objects.equals(xAxisIndex, that.xAxisIndex) &&
                Objects.equals(yAxisIndex, that.yAxisIndex) &&
                Objects.equals(polarIndex, that.polarIndex) &&
                Objects.equals(geoIndex, that.geoIndex) &&
                Objects.equals(hoverAnimation, that.hoverAnimation) &&
                Objects.equals(layout, that.layout) &&
                Objects.equals(force, that.force) &&
                Objects.equals(roam, that.roam) &&
                Objects.equals(nodeScaleRatio, that.nodeScaleRatio) &&
                Objects.equals(draggable, that.draggable) &&
                Objects.equals(focusNodeAdjacency, that.focusNodeAdjacency) &&
                Objects.equals(edgeSymbol, that.edgeSymbol) &&
                Objects.equals(edgeSymbolSize, that.edgeSymbolSize) &&
                Objects.equals(lineStyle, that.lineStyle) &&
                Objects.equals(edgeLabel, that.edgeLabel) &&
                Objects.equals(categories, that.categories) &&
                Objects.equals(links, that.links) &&
                Objects.equals(color, that.color);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), sp, sSize, legendHoverLink, xAxisIndex, yAxisIndex,
                polarIndex, geoIndex, hoverAnimation, layout, force, roam, nodeScaleRatio,
                draggable, focusNodeAdjacency, edgeSymbol, edgeSymbolSize, lineStyle, edgeLabel,
                categories, links, color);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder(32)
                .append(getClass()).append("{");
        appendPrefix(sb);
        sb.append(", legendHoverLink=").append(legendHoverLink);
        sb.append(", xAxisIndex=").append(xAxisIndex);
        sb.append(", yAxisIndex=").append(yAxisIndex);
        sb.append(", polarIndex=").append(polarIndex);
        sb.append(", geoIndex=").append(geoIndex);
        sb.append(", hoverAnimation=").append(hoverAnimation);
        sb.append(", layout='").append(layout).append('\'');
        sb.append(", force=").append(force);
        sb.append(", roam=").append(roam);
        sb.append(", nodeScaleRatio=").append(nodeScaleRatio);
        sb.append(", draggable=").append(draggable);
        sb.append(", focusNodeAdjacency=").append(focusNodeAdjacency);
        sSymbol.appendSymbol(sb);
        sb.append(", edgeSymbol=").append(edgeSymbol);
        sb.append(", edgeSymbolSize=").append(edgeSymbolSize);
        sb.append(", itemStyle=").append(getItemStyle());
        sb.append(", lineStyle=").append(lineStyle);
        sb.append(", label=").append(getLabel());
        sb.append(", edgeLabel=").append(edgeLabel);
        sb.append(", categories=").append(categories);
        sb.append(", data=").append(getData());
        sb.append(", links=").append(links);
        appendMarks(sb);
        appendCanvasZ(sb);
        sp.appendPosition(sb);
        sSize.appendSize(sb);
        sb.append(", color=").append(color);
        appendAnimation(sb);
        sb.append('}');
        return sb.toString();
    }
}
