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

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.aying.echarts.style.SelectStyle;

import java.util.Objects;

/**
 * 平行坐标系中的坐标轴。
 *
 * @author Fuchun
 * @since 1.0
 */
public class ParallelAxis extends Axis<ParallelAxis> {

    private static final long serialVersionUID = -2268367552794655072L;

    public static ParallelAxis dim(int dim) {
        ParallelAxis pa = new ParallelAxis();
        pa.setDim(dim);
        return pa;
    }

    /* 坐标轴的维度号。 */
    private Integer dim;
    /* 用于定义『坐标轴』对应到哪个『坐标系』中。 */
    private Integer parallelIndex;
    /* 是否坐标轴刷选的时候，实时刷新视图。如果设为 false，则在刷选动作结束时候，才刷新视图。 */
    private Boolean realtime;
    /* 在坐标轴上可以进行框选，这里是一些框选的设置。 */
    private SelectStyle areaSelectStyle;

    public ParallelAxis() {
        super();
    }

    public ParallelAxis(AxisType type) {
        super(type);
    }

    /**
     * 坐标轴刷选的时候，禁用实时刷新视图（动作结束后刷新视图）。
     */
    public ParallelAxis nonRealTime() {
        this.realtime = Boolean.FALSE;
        return this;
    }

    public Integer getDim() {
        return dim;
    }

    public void setDim(Integer dim) {
        this.dim = dim;
    }

    public Integer getParallelIndex() {
        return parallelIndex;
    }

    public void setParallelIndex(Integer parallelIndex) {
        this.parallelIndex = parallelIndex;
    }

    public Boolean getRealtime() {
        return realtime;
    }

    public void setRealtime(Boolean realtime) {
        this.realtime = realtime;
    }

    public SelectStyle getAreaSelectStyle() {
        return areaSelectStyle;
    }

    public void setAreaSelectStyle(SelectStyle areaSelectStyle) {
        this.areaSelectStyle = areaSelectStyle;
    }

    // parallelAxis 不需要 splitLine 和 splitArea 属性
    // 生成 JSON 时，不需要生成这两个属性

    @Override
    @JsonIgnore
    public SplitLine getSplitLine() {
        return super.getSplitLine();
    }

    @Override
    @JsonIgnore
    public SplitArea getSplitArea() {
        return super.getSplitArea();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ParallelAxis)) return false;
        if (!super.equals(o)) return false;
        ParallelAxis that = (ParallelAxis) o;
        return Objects.equals(dim, that.dim) &&
                Objects.equals(parallelIndex, that.parallelIndex) &&
                Objects.equals(realtime, that.realtime) &&
                Objects.equals(areaSelectStyle, that.areaSelectStyle);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), dim, parallelIndex, realtime, areaSelectStyle);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder(32)
                .append(getClass()).append("{");
        sb.append("dim=").append(dim);
        sb.append(", parallelIndex=").append(parallelIndex);
        sb.append(", realtime=").append(realtime);
        sb.append(", areaSelectStyle=").append(areaSelectStyle);
        sb.append("} ").append(super.toString());
        return sb.toString();
    }
}
