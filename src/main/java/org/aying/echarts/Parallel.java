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

import org.aying.echarts.axis.SimpleAxis;
import org.aying.echarts.base.Orient;
import org.aying.echarts.base.SizeGraph;

import java.util.Objects;

/**
 * 平行坐标系配置项模型。
 *
 * @author Fuchun
 * @since 1.0
 */
public class Parallel extends SizeGraph<Parallel> {

    private static final long serialVersionUID = 3630022152727320490L;

    private Orient layout;
    private Boolean axisExpandable;
    private Integer axisExpandCenter;
    private Integer axisExpandCount;
    private Integer axisExpandWidth;
    /* 默认的 parallelAxis 配置项 */
    private SimpleAxis parallelAxisDefault;

    public Parallel() {
        super();
    }

    /**
     * 竖直排布各个坐标轴（不调用该方法时默认为横向排布）。
     */
    public Parallel vertical() {
        this.layout = Orient.vertical;
        return this;
    }

    /**
     * 设置展开状态（初始）的轴的属性。
     * <pre>{@code
     * Equals:
     * expandable().expandCenter(index).expandCount(count).expandWidth(width);
     * }</pre>
     *
     * @param index 轴展开的中心的轴索引(from 0)。
     * @param count 展开的轴的数量。
     * @param width 展开状态的轴的间隔，单位：像素。
     */
    public Parallel axisExpand(int index, int count, int width) {
        return expandable().expandCenter(index)
                .expandCount(count).expandWidth(width);
    }

    /**
     * 设置点击可以展开折叠多轴（Axis）。
     */
    public Parallel expandable() {
        this.axisExpandable = Boolean.TRUE;
        return this;
    }

    /**
     * 设置初始状态时以哪个轴为中心展开，即轴的索引值。
     *
     * @param index 展开的轴的索引值。
     */
    public Parallel expandCenter(int index) {
        this.axisExpandCenter = index;
        return this;
    }

    /**
     * 设置初始状态时有多少轴处于展开状态。
     *
     * @param count 处于展开状态的轴数量。
     */
    public Parallel expandCount(int count) {
        this.axisExpandCount = count;
        return this;
    }

    /**
     * 设置轴的间距是多少，单位为像素。
     *
     * @param width 轴的间距，单位为像素。
     */
    public Parallel expandWidth(int width) {
        this.axisExpandWidth = width;
        return this;
    }

    /**
     * 设置默认（公用）的直角坐标系的坐标轴配置。
     *
     * @param axis 坐标轴配置。
     */
    public Parallel axisDefault(SimpleAxis axis) {
        this.parallelAxisDefault = axis;
        return this;
    }

    public Orient getLayout() {
        return layout;
    }

    public void setLayout(Orient layout) {
        this.layout = layout;
    }

    public Boolean getAxisExpandable() {
        return axisExpandable;
    }

    public void setAxisExpandable(Boolean axisExpandable) {
        this.axisExpandable = axisExpandable;
    }

    public Integer getAxisExpandCenter() {
        return axisExpandCenter;
    }

    public void setAxisExpandCenter(Integer axisExpandCenter) {
        this.axisExpandCenter = axisExpandCenter;
    }

    public Integer getAxisExpandCount() {
        return axisExpandCount;
    }

    public void setAxisExpandCount(Integer axisExpandCount) {
        this.axisExpandCount = axisExpandCount;
    }

    public Integer getAxisExpandWidth() {
        return axisExpandWidth;
    }

    public void setAxisExpandWidth(Integer axisExpandWidth) {
        this.axisExpandWidth = axisExpandWidth;
    }

    public SimpleAxis getParallelAxisDefault() {
        return parallelAxisDefault;
    }

    public void setParallelAxisDefault(SimpleAxis parallelAxisDefault) {
        this.parallelAxisDefault = parallelAxisDefault;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Parallel)) return false;
        if (!super.equals(o)) return false;
        Parallel parallel = (Parallel) o;
        return layout == parallel.layout &&
                Objects.equals(axisExpandable, parallel.axisExpandable) &&
                Objects.equals(axisExpandCenter, parallel.axisExpandCenter) &&
                Objects.equals(axisExpandCount, parallel.axisExpandCount) &&
                Objects.equals(axisExpandWidth, parallel.axisExpandWidth) &&
                Objects.equals(parallelAxisDefault, parallel.parallelAxisDefault);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), layout, axisExpandable, axisExpandCenter,
                axisExpandCount, axisExpandWidth, parallelAxisDefault);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder(32)
                .append(getClass()).append("{");
        sb.append("layout=").append(layout);
        sb.append(", axisExpandable=").append(axisExpandable);
        sb.append(", axisExpandCenter=").append(axisExpandCenter);
        sb.append(", axisExpandCount=").append(axisExpandCount);
        sb.append(", axisExpandWidth=").append(axisExpandWidth);
        sb.append(", parallelAxisDefault=").append(parallelAxisDefault);
        sb.append("} ").append(super.toString());
        return sb.toString();
    }
}
