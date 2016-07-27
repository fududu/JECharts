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

import com.fasterxml.jackson.annotation.JsonProperty;
import org.aying.echarts.BaseComponent;
import org.aying.echarts.style.LineStyle;

import java.io.Serializable;
import java.util.Objects;

/**
 * 坐标轴刻度相关设置。
 * <pre>{@code
 * AxisTick t1 = AxisTick.showed().alignWithLabel()
 *                     inside().style(LineStyle...);
 * AxisTick t2 = AxisTick.hidden();
 * }</pre>
 *
 * @author Fuchun
 * @since 1.0
 */
public class AxisTick extends BaseComponent<AxisTick> implements Serializable {

    private static final long serialVersionUID = -6972915907508973832L;

    /**
     * 获取一个新的 <strong>显示刻度</strong> 的坐标轴刻度设置模型。
     */
    public static AxisTick showed() {
        return new AxisTick();
    }

    /**
     * 获取一个新的 <strong>不显示刻度</strong> 的坐标轴刻度设置模型。
     */
    public static AxisTick hidden() {
        return new AxisTick(Boolean.FALSE);
    }

    private Object interval;
    /* 类目轴中在 boundaryGap 为 true 的时候有效，可以保证刻度线和标签对齐。 */
    private Boolean alignWithLabel;
    /* 坐标轴刻度是否朝内，默认朝外。 */
    private Boolean inside;
    /*分隔线之间分割的刻度数。*/
    private Integer splitNumber;
    /* 坐标轴刻度的长度。 */
    private Integer length;
    private LineStyle lineStyle;

    public AxisTick() {
        super();
    }

    public AxisTick(Boolean show) {
        super(show);
    }

    /**
     * 保证刻度线和标签对齐。
     * 类目轴中在{@code boundaryGap == true} 的时候有效。
     *
     * @return 当前轴刻度设置模型。
     */
    public AxisTick alignWithLabel() {
        this.alignWithLabel = Boolean.TRUE;
        return this;
    }

    /**
     * 设置坐标轴刻度朝内。
     *
     * @return 当前轴刻度设置模型。
     */
    public AxisTick inside() {
        this.inside = Boolean.TRUE;
        return this;
    }

    /**
     * 设置坐标轴刻度的长度。
     *
     * @param length 坐标轴刻度的长度。
     * @return 当前轴刻度设置模型。
     * @throws IllegalArgumentException 如果坐标轴刻度的长度{@code length <= 0}
     */
    public AxisTick length(int length) {
        if (length <= 0) {
            throw new IllegalArgumentException("The AxisTick.length must be greater than 0");
        }
        this.length = length;
        return this;
    }

    /**
     * 设置分隔线之间分割的刻度数。
     * <p />
     * NOTE：通常此属性仅用于{@code Serie} 设置，其他组件的{@code axisTick} 中不使用此参数。
     *
     * @param splitNumber 分隔线之间分割的刻度数。
     * @return 当前轴刻度设置模型。
     */
    public AxisTick splitNumber(int splitNumber) {
        this.splitNumber = splitNumber;
        return this;
    }

    /**
     * 设置刻度线条的样式。
     *
     * @param lineStyle 刻度线条的样式。
     * @return 当前轴刻度设置模型。
     */
    public AxisTick style(LineStyle lineStyle) {
        this.lineStyle = lineStyle;
        return this;
    }

    /**
     * 设置坐标轴刻度的显示间隔，在类目轴中有效。默认同{@code axisLabel.interval} 一样。
     * <p />
     * 默认会采用标签不重叠的策略间隔显示标签。可以设置成{@code 0} 强制显示所有标签。
     * <p />
     * 如果设置为{@code 1}，表示『隔一个标签显示一个标签』，如果值为{@code 2}，表示隔两个标签显示一个标签，以此类推。
     *
     * @param interval 坐标轴刻度的显示间隔。
     * @return 当前轴刻度设置模型。
     */
    public AxisTick interval(int interval) {
        this.interval = interval;
        return this;
    }

    public Object getInterval() {
        return interval;
    }

    public void setInterval(Object interval) {
        this.interval = interval;
    }

    public Boolean getAlignWithLabel() {
        return alignWithLabel;
    }

    public void setAlignWithLabel(Boolean alignWithLabel) {
        this.alignWithLabel = alignWithLabel;
    }

    public Boolean getInside() {
        return inside;
    }

    public void setInside(Boolean inside) {
        this.inside = inside;
    }

    @JsonProperty(required = false)
    public Integer getSplitNumber() {
        return splitNumber;
    }

    public void setSplitNumber(Integer splitNumber) {
        this.splitNumber = splitNumber;
    }

    public Integer getLength() {
        return length;
    }

    public void setLength(Integer length) {
        this.length = length;
    }

    public LineStyle getLineStyle() {
        return lineStyle;
    }

    public void setLineStyle(LineStyle lineStyle) {
        this.lineStyle = lineStyle;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof AxisTick)) return false;
        if (!super.equals(o)) return false;
        AxisTick axisTick = (AxisTick) o;
        return Objects.equals(interval, axisTick.interval) &&
                Objects.equals(alignWithLabel, axisTick.alignWithLabel) &&
                Objects.equals(inside, axisTick.inside) &&
                Objects.equals(splitNumber, axisTick.splitNumber) &&
                Objects.equals(length, axisTick.length) &&
                Objects.equals(lineStyle, axisTick.lineStyle);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), interval, alignWithLabel, inside, splitNumber, length, lineStyle);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder(32)
                .append(getClass()).append("{");
        sb.append("show=").append(getShow());
        sb.append(", alignWithLabel=").append(alignWithLabel);
        sb.append(", interval=").append(interval);
        sb.append(", inside=").append(inside);
        sb.append(", splitNumber=").append(splitNumber);
        sb.append(", length=").append(length);
        sb.append(", lineStyle=").append(lineStyle);
        sb.append('}');
        return sb.toString();
    }
}
