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
import org.aying.echarts.base.Pos;
import org.jetbrains.annotations.Contract;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;

/**
 * 直角坐标系（笛卡尔坐标系）轴配置模型。
 * <pre>{@code
 * CartesianAxis xAxis = CartesianAxis.x(AxisType.category)
 *         .name("周").add("周一", "周二", "周三", "周四", "周五", "周六", "周日");
 * CartesianAxis yAxis = CartesianAxis.y(AxisType.value).name("次数");
 * // then set option
 * option.xAxis(xAxis).yAxis(yAxis);
 * // generate json:
 * xAxis: {
 *     "name": "周",
 *     "type": "category",
 *     "data": ["周一", "周二", "周三", "周四", "周五", "周六", "周日"]
 * },
 * yAxis: {
 *     "name": "次数",
 *     "type": "value"
 * }
 * }</pre>
 *
 * @author Fuchun
 * @since 1.0
 */
public class CartesianAxis extends Axis<CartesianAxis> {

    private static final long serialVersionUID = -4594591698952048841L;

    public enum XY {
        x, y
    }

    /**
     * 获取一个新的{@code xAxis} 配置项模型。
     */
    public static CartesianAxis x() {
        return new CartesianAxis(XY.x);
    }

    public static CartesianAxis x(AxisType type) {
        return new CartesianAxis(XY.x, type);
    }

    /**
     * 获取一个新的{@code yAxis} 配置项模型。
     */
    public static CartesianAxis y() {
        return new CartesianAxis(XY.y);
    }

    public static CartesianAxis y(AxisType type) {
        return new CartesianAxis(XY.y, type);
    }

    @JsonIgnore
    private final transient XY xy;

    /* x|y 轴所在的 grid 的索引，默认位于第一个 grid。 */
    private Integer gridIndex;

    /* 轴的位置。x 轴为 'top'|'bottom'，y轴为 'left'|'right' */
    private Pos position;

    /**
     * X 轴相对于默认位置的偏移，在相同的 position 上有多个 X 轴的时候有用。默认：0
     * @since 1.0 ECharts-3.2.2
     */
    private Integer offset;

    public CartesianAxis() {
        this(null, null);
    }

    public CartesianAxis(XY xy) {
        this(xy, null);
    }

    public CartesianAxis(XY xy, AxisType type) {
        super(type);
        this.xy = xy;
    }

    /**
     * 设置{@code x|y} 轴所在的{@code grid} 的索引，默认位于第一个{@code grid}。
     *
     * @param index 索引值。
     * @return 当前坐标轴模型。
     */
    public CartesianAxis gridIndex(int index) {
        this.gridIndex = index;
        return this;
    }

    @Contract("null -> fail")
    public CartesianAxis position(Pos pos) {
        Objects.requireNonNull(pos, "position");
        if (xy == XY.x) {
            if (pos != Pos.top && pos != Pos.bottom) {
                throw new IllegalArgumentException(String.format(
                        "The xAxis.position must be '%s' or '%s'", Pos.top, Pos.bottom));
            }
        } else {
            if (pos != Pos.left && pos != Pos.right) {
                throw new IllegalArgumentException(String.format(
                        "The yAxis.position must be '%s' or '%s'", Pos.left, Pos.right));
            }
        }
        this.position = pos;
        return this;
    }

    public Integer getGridIndex() {
        return gridIndex;
    }

    public void setGridIndex(Integer gridIndex) {
        this.gridIndex = gridIndex;
    }

    public Pos getPosition() {
        return position;
    }

    public void setPosition(Pos position) {
        this.position = position;
    }

    public Integer getOffset() {
        return offset;
    }

    public void setOffset(Integer offset) {
        this.offset = offset;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CartesianAxis)) return false;
        if (!super.equals(o)) return false;
        CartesianAxis that = (CartesianAxis) o;
        return Objects.equals(gridIndex, that.gridIndex) &&
                position == that.position;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), gridIndex, position);
    }

    private Map<String, Object> prevMap() {
        Map<String, Object> prev = new LinkedHashMap<>();
        prev.put("gridIndex", getGridIndex());
        prev.put("position", getPosition());
        return prev;
    }

    public String toString(boolean pretty) {
        return super.toString(prevMap(), null, pretty);
    }

    @Override
    public String toString() {
        return toString(false);
    }
}
