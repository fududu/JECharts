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

import java.io.Serializable;
import java.util.Map;
import java.util.Objects;

/**
 * {@code DataZoom} 组件 用于区域缩放，从而能自由关注细节的数据信息，或者概览数据整体，或者去除离群点的影响。
 *
 * @author Fuchun
 * @since 1.0
 */
public abstract class DataZoom implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * {@link DataZoomInside} 的工厂方法。
     */
    public static DataZoomInside inside() {
        return new DataZoomInside();
    }

    /**
     * {@link DataZoomSlider} 的工厂方法。
     */
    public static DataZoomSlider slider() {
        return new DataZoomSlider();
    }

    /**
     * {@link DataZoomSelect} 的工厂方法。
     */
    public static DataZoomSelect select() {
        return new DataZoomSelect();
    }

    private final DataZoomType type;

    private Boolean show;
    /* 设置 dataZoom-inside 组件控制的 x轴（即xAxis，是直角坐标系中的概念，参见 grid）。 */
    private Object xAxisIndex;
    /* 设置 dataZoom-inside 组件控制的 y轴（即yAxis，是直角坐标系中的概念，参见 grid）。 */
    private Object yAxisIndex;

    protected DataZoom(DataZoomType type) {
        this.type = type;
    }

    public DataZoomType getType() {
        return type;
    }

    public Boolean getShow() {
        return show;
    }

    public void setShow(Boolean show) {
        this.show = show;
    }

    public Object getxAxisIndex() {
        return xAxisIndex;
    }

    public void setxAxisIndex(Object xAxisIndex) {
        this.xAxisIndex = xAxisIndex;
    }

    public Object getyAxisIndex() {
        return yAxisIndex;
    }

    public void setyAxisIndex(Object yAxisIndex) {
        this.yAxisIndex = yAxisIndex;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof DataZoom)) return false;
        DataZoom dataZoom = (DataZoom) o;
        return type == dataZoom.type &&
                Objects.equals(show, dataZoom.show) &&
                Objects.equals(xAxisIndex, dataZoom.xAxisIndex) &&
                Objects.equals(yAxisIndex, dataZoom.yAxisIndex);
    }

    @Override
    public int hashCode() {
        return Objects.hash(type, show, xAxisIndex, yAxisIndex);
    }

    protected String toString(Map<String, Object> prev, Map<String, Object> last, boolean pretty) {
        StringBuilder builder = new StringBuilder(getClass().getName());
        builder.append("{");
        String lineSuffix = pretty ? "\n" : "";
        builder.append(lineSuffix);
        appendToBuilder(builder, prev, lineSuffix);
        builder.append("type=").append(String.valueOf(type)).append(", ").append(lineSuffix);
        builder.append("show=").append(String.valueOf(show)).append(", ").append(lineSuffix);
        builder.append("xAxisIndex=").append(String.valueOf(xAxisIndex)).append(", ").append(lineSuffix);
        builder.append("yAxisIndex=").append(String.valueOf(yAxisIndex));
        if (last != null && last.size() > 0) {
            builder.append(", ");
            appendToBuilder(builder, last, lineSuffix);
        } else {
            builder.append(lineSuffix);
        }
        builder.append("}");
        return builder.toString();
    }

    private void appendToBuilder(StringBuilder builder, Map<String, Object> map, String lineSuffix) {
        if (map == null || map.isEmpty()) return;
        int i = 0, size = map.size();
        for (Map.Entry<String, Object> entry : map.entrySet()) {
            if (!lineSuffix.isEmpty()) builder.append("  ");
            builder.append(entry.getKey()).append("=").append(String.valueOf(entry.getValue()));
            if (i != size - 1) {
                builder.append(", ");
            }
            builder.append(lineSuffix);
        }
    }

    @Override
    public String toString() {
        return toString(null, null, false);
    }
}
