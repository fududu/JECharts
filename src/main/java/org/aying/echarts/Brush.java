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

import org.aying.echarts.base.SelectedMode;
import org.aying.echarts.base.ThrottleType;
import org.aying.echarts.feature.BrushType;

import java.io.Serializable;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/**
 * {@code Brush} 是区域选择组件，用户可以选择图中一部分数据，从而便于向用户展示被选中数据，或者他们的一些统计计算结果。
 *
 * @author Fuchun
 * @since 1.0
 */
public class Brush implements Serializable {

    private static final long serialVersionUID = 7271921867491977471L;

    private List<BrushType> toolbox;
    /* 不同系列间，选中的项可以联动。(String|List<Integer>) */
    private Object brushLink;
    /* 指定哪些 series 可以被刷选 (Integer|String|List<Integer>) */
    private Object seriesIndex;
    /* 指定哪些 geo 可以被刷选。(Integer|String|List<Integer>) */
    private Object geoIndex;
    /* 指定哪些 xAxisIndex 可以被刷选。(Integer|String|List<Integer>) */
    private Object xAxisIndex;
    /* 指定哪些 yAxisIndex 可以被刷选。(Integer|String|List<Integer>) */
    private Object yAxisIndex;
    /* 默认的刷子类型。默认：rect */
    private BrushType brushType;
    /* 默认的刷子的模式。默认：single */
    private SelectedMode brushMode;
    /* 已经选好的选框是否可以被调整形状或平移。默认：true */
    private Boolean transformable;
    /* 选框的默认样式 */
    private Map<String, Object> brushStyle;
    /* 刷选或者移动选区的时候，动画的触发类型，默认：fixRate */
    private ThrottleType throttleType;
    /* 默认为 0 表示不开启 throttle。 */
    private Integer throttleDelay;
    /* 在 brush.brushMode 为 'single' 的情况下，是否支持『单击清除所有选框』。 */
    private Boolean removeOnClick;
    /* 定义 在选中范围中 的视觉元素。 */
    private VisualRange inBrush;
    /* 定义 在选中范围外 的视觉元素。 */
    private VisualRange outOfBrush;

    public Brush() {
        super();
    }

    public List<BrushType> getToolbox() {
        return toolbox;
    }

    public void setToolbox(List<BrushType> toolbox) {
        this.toolbox = toolbox;
    }

    public Object getBrushLink() {
        return brushLink;
    }

    public void setBrushLink(Object brushLink) {
        this.brushLink = brushLink;
    }

    public Object getSeriesIndex() {
        return seriesIndex;
    }

    public void setSeriesIndex(Object seriesIndex) {
        this.seriesIndex = seriesIndex;
    }

    public Object getGeoIndex() {
        return geoIndex;
    }

    public void setGeoIndex(Object geoIndex) {
        this.geoIndex = geoIndex;
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

    public BrushType getBrushType() {
        return brushType;
    }

    public void setBrushType(BrushType brushType) {
        this.brushType = brushType;
    }

    public SelectedMode getBrushMode() {
        return brushMode;
    }

    public void setBrushMode(SelectedMode brushMode) {
        this.brushMode = brushMode;
    }

    public Boolean getTransformable() {
        return transformable;
    }

    public void setTransformable(Boolean transformable) {
        this.transformable = transformable;
    }

    public Map<String, Object> getBrushStyle() {
        return brushStyle;
    }

    public void setBrushStyle(Map<String, Object> brushStyle) {
        this.brushStyle = brushStyle;
    }

    public ThrottleType getThrottleType() {
        return throttleType;
    }

    public void setThrottleType(ThrottleType throttleType) {
        this.throttleType = throttleType;
    }

    public Integer getThrottleDelay() {
        return throttleDelay;
    }

    public void setThrottleDelay(Integer throttleDelay) {
        this.throttleDelay = throttleDelay;
    }

    public Boolean getRemoveOnClick() {
        return removeOnClick;
    }

    public void setRemoveOnClick(Boolean removeOnClick) {
        this.removeOnClick = removeOnClick;
    }

    public VisualRange getInBrush() {
        return inBrush;
    }

    public void setInBrush(VisualRange inBrush) {
        this.inBrush = inBrush;
    }

    public VisualRange getOutOfBrush() {
        return outOfBrush;
    }

    public void setOutOfBrush(VisualRange outOfBrush) {
        this.outOfBrush = outOfBrush;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Brush)) return false;
        Brush brush = (Brush) o;
        return Objects.equals(toolbox, brush.toolbox) &&
                Objects.equals(brushLink, brush.brushLink) &&
                Objects.equals(seriesIndex, brush.seriesIndex) &&
                Objects.equals(geoIndex, brush.geoIndex) &&
                Objects.equals(xAxisIndex, brush.xAxisIndex) &&
                Objects.equals(yAxisIndex, brush.yAxisIndex) &&
                brushType == brush.brushType &&
                brushMode == brush.brushMode &&
                Objects.equals(transformable, brush.transformable) &&
                Objects.equals(brushStyle, brush.brushStyle) &&
                throttleType == brush.throttleType &&
                Objects.equals(throttleDelay, brush.throttleDelay) &&
                Objects.equals(removeOnClick, brush.removeOnClick) &&
                Objects.equals(inBrush, brush.inBrush) &&
                Objects.equals(outOfBrush, brush.outOfBrush);
    }

    @Override
    public int hashCode() {
        return Objects.hash(toolbox, brushLink, seriesIndex, geoIndex, xAxisIndex, yAxisIndex,
                brushType, brushMode, transformable, brushStyle, throttleType, throttleDelay,
                removeOnClick, inBrush, outOfBrush);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder(32)
                .append(getClass()).append("{");
        sb.append("toolbox=").append(toolbox);
        sb.append(", brushLink=").append(brushLink);
        sb.append(", seriesIndex=").append(seriesIndex);
        sb.append(", geoIndex=").append(geoIndex);
        sb.append(", xAxisIndex=").append(xAxisIndex);
        sb.append(", yAxisIndex=").append(yAxisIndex);
        sb.append(", brushType=").append(brushType);
        sb.append(", brushMode=").append(brushMode);
        sb.append(", transformable=").append(transformable);
        sb.append(", brushStyle=").append(brushStyle);
        sb.append(", throttleType=").append(throttleType);
        sb.append(", throttleDelay=").append(throttleDelay);
        sb.append(", removeOnClick=").append(removeOnClick);
        sb.append(", inBrush=").append(inBrush);
        sb.append(", outOfBrush=").append(outOfBrush);
        sb.append('}');
        return sb.toString();
    }


}
