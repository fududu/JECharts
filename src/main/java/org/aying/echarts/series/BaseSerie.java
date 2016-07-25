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

import org.aying.echarts.BaseData;
import org.aying.echarts.ChartType;
import org.aying.echarts.Data;
import org.aying.echarts.base.BaseAnimation;
import org.aying.echarts.base.CanvasZ;
import org.aying.echarts.base.CoordinateSystem;
import org.aying.echarts.base.SimpleCanvasZ;
import org.aying.echarts.base.StateLabel;
import org.aying.echarts.style.StateShapeStyle;
import org.jetbrains.annotations.NotNull;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

/**
 * The base implementation of the {@code Serie}
 *
 * @author Fuchun
 * @since 1.0
 */
public abstract class BaseSerie<S extends BaseSerie<S>> extends BaseAnimation<S>
        implements Serie, CanvasZ<S>, Data<S>, Serializable {

    private static final long serialVersionUID = 1L;

    private final ChartType type;
    /* Data proxy delegate */
    private final BaseData<?> data;
    /* CanvasZ proxy delegate */
    private final SimpleCanvasZ simpleCanvasZ;
    private final transient boolean hasName;
    private String name;
    /* 该系列使用的坐标系 */
    private CoordinateSystem coordinateSystem;
    private Object silent;
    /* 图形文本标签配置 */
    private StateLabel label;
    /* 折线拐点标志的样式。*/
    private StateShapeStyle itemStyle;
    /* 图表标注配置。 */
    private MarkPoint markPoint;
    /* 图表标线配置。 */
    private MarkLine markLine;
    /* 图表标域配置。 */
    private MarkArea markArea;

    protected BaseSerie(@NotNull ChartType type) {
        this(type, true);
    }

    protected BaseSerie(@NotNull ChartType type, boolean hasName) {
        this.type = type;
        this.data = BaseData.delegate();
        this.simpleCanvasZ = new SimpleCanvasZ();
        this.hasName = hasName;
    }

    @SuppressWarnings("unchecked")
    protected S me() {
        return (S) this;
    }

    @Override
    public S add(Data<?> d) {
        data.add(d);
        return me();
    }

    @Override
    public S add(Data<?> d1, Data<?> d2, Data<?>... dn) {
        data.add(d1, d2, dn);
        return me();
    }

    public S name(String name) {
        this.name = name;
        return me();
    }

    /**
     * 设置图形响应和触发鼠标事件。
     */
    public S nonSilent() {
        this.silent = Boolean.TRUE;
        return me();
    }

    @Override
    public List<Data<?>> getData() {
        return data.getData();
    }

    @NotNull
    public ChartType getType() {
        return type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public CoordinateSystem getCoordinateSystem() {
        return coordinateSystem;
    }

    public void setCoordinateSystem(CoordinateSystem coordinateSystem) {
        this.coordinateSystem = coordinateSystem;
    }

    @Override
    public Integer getZlevel() {
        return simpleCanvasZ.getZlevel();
    }

    public void setZlevel(Integer zlevel) {
        simpleCanvasZ.setZlevel(zlevel);
    }

    @Override
    public Integer getZ() {
        return simpleCanvasZ.getZ();
    }

    public void setZ(Integer z) {
        simpleCanvasZ.setZ(z);
    }

    @Override
    public S zLevel(int zLevel) {
        simpleCanvasZ.zLevel(zLevel);
        return me();
    }

    @Override
    public S z(int z) {
        simpleCanvasZ.z(z);
        return me();
    }

    public Object getSilent() {
        return silent;
    }

    public void setSilent(Object silent) {
        this.silent = silent;
    }

    public StateLabel getLabel() {
        return label;
    }

    public void setLabel(StateLabel label) {
        this.label = label;
    }

    public StateShapeStyle getItemStyle() {
        return itemStyle;
    }

    public void setItemStyle(StateShapeStyle itemStyle) {
        this.itemStyle = itemStyle;
    }

    public MarkPoint getMarkPoint() {
        return markPoint;
    }

    public void setMarkPoint(MarkPoint markPoint) {
        this.markPoint = markPoint;
    }

    public MarkLine getMarkLine() {
        return markLine;
    }

    public void setMarkLine(MarkLine markLine) {
        this.markLine = markLine;
    }

    public MarkArea getMarkArea() {
        return markArea;
    }

    public void setMarkArea(MarkArea markArea) {
        this.markArea = markArea;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof BaseSerie)) return false;
        if (!super.equals(o)) return false;
        BaseSerie<?> baseSerie = (BaseSerie<?>) o;
        return type == baseSerie.type &&
                Objects.equals(name, baseSerie.name) &&
                coordinateSystem == baseSerie.coordinateSystem &&
                Objects.equals(data, baseSerie.data) &&
                Objects.equals(simpleCanvasZ, baseSerie.simpleCanvasZ) &&
                Objects.equals(silent, baseSerie.silent) &&
                Objects.equals(label, baseSerie.label) &&
                Objects.equals(itemStyle, baseSerie.itemStyle) &&
                Objects.equals(markPoint, baseSerie.markPoint) &&
                Objects.equals(markLine, baseSerie.markLine) &&
                Objects.equals(markArea, baseSerie.markArea);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), type, name, coordinateSystem, data, simpleCanvasZ,
                silent, label, itemStyle, markPoint, markLine, markArea);
    }

    protected void appendPrefix(StringBuilder sb) {
        sb.append("type='").append(getType()).append("'");
        if (hasName) {
            sb.append(", name=").append(getName());
        }
        sb.append(", silent=").append(getSilent());
    }

    protected void appendMarks(StringBuilder sb) {
        sb.append(", markPoint=").append(getMarkPoint());
        sb.append(", markLine=").append(getMarkLine());
        sb.append(", markArea=").append(getMarkArea());
    }

    protected void appendCanvasZ(StringBuilder sb) {
        sb.append(", zlevel=").append(getZlevel());
        sb.append(", z=").append(getZ());
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder(32)
                .append(getClass()).append("{");
        appendPrefix(sb);
        sb.append(", coordinateSystem='").append(getCoordinateSystem()).append("'");
        sb.append(", simpleCanvasZ=").append(simpleCanvasZ);
        sb.append(", label=").append(label);
        sb.append(", itemStyle=").append(itemStyle);
        appendMarks(sb);
        sb.append(", data=").append(data);
        sb.append('}');
        return sb.toString();
    }
}
