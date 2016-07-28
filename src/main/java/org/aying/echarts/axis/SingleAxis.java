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

package org.aying.echarts.axis;

import org.aying.echarts.base.CanvasZ;
import org.aying.echarts.base.Orient;
import org.aying.echarts.base.Position;
import org.aying.echarts.base.SimpleSizeGraph;
import org.aying.echarts.base.Size;

import java.util.Objects;

/**
 * 单轴配置模型。
 *
 * @author Fuchun
 * @since 1.0
 */
public class SingleAxis extends Axis<SingleAxis>
        implements Position<SingleAxis>, CanvasZ<SingleAxis>, Size<SingleAxis> {

    private static final long serialVersionUID = -3748727798687360756L;

    private Orient orient;
    private transient SimpleSizeGraph sizeGraph;

    public SingleAxis() {
        super();
        this.sizeGraph = new SimpleSizeGraph();
    }

    public SingleAxis(AxisType type) {
        super(type);
        this.sizeGraph = new SimpleSizeGraph();
    }

    @Override
    public Integer getZlevel() {
        return sizeGraph.getZlevel();
    }

    @Override
    public void setZlevel(Integer zlevel) {
        sizeGraph.setZlevel(zlevel);
    }

    @Override
    public Integer getZ() {
        return sizeGraph.getZ();
    }

    @Override
    public void setZ(Integer z) {
        sizeGraph.setZ(z);
    }

    @Override
    public SingleAxis zLevel(int zLevel) {
        sizeGraph.zLevel(zLevel);
        return this;
    }

    @Override
    public SingleAxis z(int z) {
        sizeGraph.z(z);
        return this;
    }

    @Override
    public Object getLeft() {
        return sizeGraph.getLeft();
    }

    @Override
    public Object getRight() {
        return sizeGraph.getRight();
    }

    @Override
    public Object getTop() {
        return sizeGraph.getTop();
    }

    @Override
    public Object getBottom() {
        return sizeGraph.getBottom();
    }

    @Override
    public SingleAxis left(Object left) {
        sizeGraph.left(left);
        return this;
    }

    @Override
    public SingleAxis right(Object right) {
        sizeGraph.right(right);
        return this;
    }

    @Override
    public SingleAxis top(Object top) {
        sizeGraph.top(top);
        return this;
    }

    @Override
    public SingleAxis bottom(Object bottom) {
        sizeGraph.bottom(bottom);
        return this;
    }

    @Override
    public Object getWidth() {
        return sizeGraph.getWidth();
    }

    @Override
    public void setWidth(Object width) {
        sizeGraph.setWidth(width);
    }

    @Override
    public Object getHeight() {
        return sizeGraph.getHeight();
    }

    @Override
    public void setHeight(Object height) {
        sizeGraph.setHeight(height);
    }

    public Orient getOrient() {
        return orient;
    }

    public void setOrient(Orient orient) {
        this.orient = orient;
    }

    @Override
    public SingleAxis autoWidth() {
        sizeGraph.autoWidth();
        return this;
    }

    @Override
    public SingleAxis autoHeight() {
        sizeGraph.autoHeight();
        return this;
    }

    @Override
    public SingleAxis width(int width) {
        sizeGraph.width(width);
        return this;
    }

    @Override
    public SingleAxis width(String width) {
        sizeGraph.width(width);
        return this;
    }

    @Override
    public SingleAxis height(int height) {
        sizeGraph.height(height);
        return this;
    }

    @Override
    public SingleAxis height(String height) {
        sizeGraph.height(height);
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof SingleAxis)) return false;
        if (!super.equals(o)) return false;
        SingleAxis that = (SingleAxis) o;
        return orient == that.orient &&
                Objects.equals(sizeGraph, that.sizeGraph);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), orient, sizeGraph);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder(32)
                .append(getClass()).append("{");
        sb.append("orient=").append(orient);
        sb.append(", sizeGraph=").append(sizeGraph);
        sb.append("} ").append(super.toString());
        return sb.toString();
    }
}
