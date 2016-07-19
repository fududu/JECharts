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

import org.aying.echarts.base.Pos;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;

/**
 * 直角坐标系（笛卡尔坐标系）轴配置模型。
 *
 * @author Fuchun
 * @since 1.0
 */
public class CartesianAxis extends Axis<CartesianAxis> {

    private static final long serialVersionUID = -4594591698952048841L;

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
        super();
    }

    public CartesianAxis(AxisType type) {
        super(type);
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
