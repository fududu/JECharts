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
import org.aying.echarts.Data;
import org.aying.echarts.base.Position;
import org.aying.echarts.base.SimplePosition;
import org.aying.echarts.base.SimpleSize;
import org.aying.echarts.base.Size;
import org.aying.echarts.style.StateLineStyle;

import java.util.List;
import java.util.Objects;

/**
 * 桑基图系列配置。
 * <p>
 * 桑基图是一种特殊的流图, 它主要用来表示原材料、能量等如何从初始形式经过中间过程的加工、转化到达最终形式。
 *
 * @author Fuchun
 * @since 1.0
 */
public class SankeySerie extends BaseSerie<SankeySerie>
        implements Position<SankeySerie>, Size<SankeySerie> {

    private static final long serialVersionUID = 1813174144295445754L;

    private final transient SimplePosition sp;
    private final transient SimpleSize sSize;

    /*图中每个矩形节点的宽度。*/
    private Integer nodeWidth;
    /*图中每一列任意两个矩形节点之间的间隔。*/
    private Integer nodeGap;
    /*布局的迭代次数，用来不断优化图中节点的位置，以减少节点和边之间的相互遮盖。
默认布局迭代次数：32。*/
    private Integer layoutIterations;
    /*桑基图边的样式*/
    private StateLineStyle lineStyle;
    /*节点间的关系数据。*/
    private List<Link> links;

    public SankeySerie() {
        super(ChartType.sankey, false);
        sp = new SimplePosition();
        sSize = new SimpleSize();
    }

    public Integer getNodeWidth() {
        return nodeWidth;
    }

    public void setNodeWidth(Integer nodeWidth) {
        this.nodeWidth = nodeWidth;
    }

    public Integer getNodeGap() {
        return nodeGap;
    }

    public void setNodeGap(Integer nodeGap) {
        this.nodeGap = nodeGap;
    }

    public Integer getLayoutIterations() {
        return layoutIterations;
    }

    public void setLayoutIterations(Integer layoutIterations) {
        this.layoutIterations = layoutIterations;
    }

    public StateLineStyle getLineStyle() {
        return lineStyle;
    }

    public void setLineStyle(StateLineStyle lineStyle) {
        this.lineStyle = lineStyle;
    }

    public List<Link> getLinks() {
        return links;
    }

    public void setLinks(List<Link> links) {
        this.links = links;
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
    public SankeySerie left(Object left) {
        sp.left(left);
        return this;
    }

    @Override
    public SankeySerie right(Object right) {
        sp.right(right);
        return this;
    }

    @Override
    public SankeySerie top(Object top) {
        sp.top(top);
        return this;
    }

    @Override
    public SankeySerie bottom(Object bottom) {
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
    public SankeySerie autoWidth() {
        sSize.autoWidth();
        return this;
    }

    @Override
    public SankeySerie autoHeight() {
        sSize.autoHeight();
        return this;
    }

    @Override
    public SankeySerie width(int width) {
        sSize.width(width);
        return this;
    }

    @Override
    public SankeySerie width(String width) {
        sSize.width(width);
        return this;
    }

    @Override
    public SankeySerie height(int height) {
        sSize.height(height);
        return this;
    }

    @Override
    public SankeySerie height(String height) {
        sSize.height(height);
        return this;
    }

    public void setNodes(List<Data<?>> nodes) {
        setData(nodes);
    }

    public void setEdges(List<Link> edges) {
        this.links = edges;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof SankeySerie)) return false;
        if (!super.equals(o)) return false;
        SankeySerie that = (SankeySerie) o;
        return Objects.equals(sp, that.sp) &&
                Objects.equals(sSize, that.sSize) &&
                Objects.equals(nodeWidth, that.nodeWidth) &&
                Objects.equals(nodeGap, that.nodeGap) &&
                Objects.equals(layoutIterations, that.layoutIterations) &&
                Objects.equals(lineStyle, that.lineStyle) &&
                Objects.equals(links, that.links);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), sp, sSize, nodeWidth, nodeGap, layoutIterations, lineStyle, links);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder(32)
                .append(getClass()).append("{");
        appendPrefix(sb);
        appendCanvasZ(sb);
        sp.appendPosition(sb);
        sSize.appendSize(sb);
        sb.append(", nodeWidth=").append(nodeWidth);
        sb.append(", nodeGap=").append(nodeGap);
        sb.append(", layoutIterations=").append(layoutIterations);
        sb.append(", label=").append(getLabel());
        sb.append(", itemStyle=").append(getItemStyle());
        sb.append(", lineStyle=").append(lineStyle);
        sb.append(", data=").append(getData());
        sb.append(", links=").append(links);
        appendAnimation(sb);
        sb.append('}');
        return sb.toString();
    }
}
