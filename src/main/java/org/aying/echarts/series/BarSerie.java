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

import java.util.Objects;

/**
 * 柱状/条形图系列配置模型。
 *
 * @author Fuchun
 * @since 1.0
 */
public class BarSerie extends BaseSerie<BarSerie> {

    private static final long serialVersionUID = 8162458174781724980L;

    /* 是否启用图例 hover 时的联动高亮。 */
    private Boolean legendHoverLink;
    /* 使用的 x 轴的 index，在单个图表实例中存在多个 x 轴的时候有用。 */
    private Integer xAxisIndex;
    /* 使用的 y 轴的 index，在单个图表实例中存在多个 y轴的时候有用。 */
    private Integer yAxisIndex;
    /* 数据堆叠 */
    private String stack;
    /*柱条的宽度，不设时自适应。*/
    private Object barWidth;
    /*柱条的最大宽度，不设时自适应。*/
    private Object barMaxWidth;
    /*柱条最小高度，可用于防止某数据项的值过小而影响交互。*/
    private Object barMinHeight;
    /*柱间距离，默认为柱形宽度的30%，可设固定值*/
    private String barGap;
    /*类目间柱形距离，默认为类目间距的20%，可设固定值*/
    private String barCategoryGap;

    public BarSerie() {
        super(ChartType.bar);
    }

    public Boolean getLegendHoverLink() {
        return legendHoverLink;
    }

    public void setLegendHoverLink(Boolean legendHoverLink) {
        this.legendHoverLink = legendHoverLink;
    }

    public Integer getxAxisIndex() {
        return xAxisIndex;
    }

    public void setxAxisIndex(Integer xAxisIndex) {
        this.xAxisIndex = xAxisIndex;
    }

    public Integer getyAxisIndex() {
        return yAxisIndex;
    }

    public void setyAxisIndex(Integer yAxisIndex) {
        this.yAxisIndex = yAxisIndex;
    }

    public String getStack() {
        return stack;
    }

    public void setStack(String stack) {
        this.stack = stack;
    }

    public Object getBarWidth() {
        return barWidth;
    }

    public void setBarWidth(Object barWidth) {
        this.barWidth = barWidth;
    }

    public Object getBarMaxWidth() {
        return barMaxWidth;
    }

    public void setBarMaxWidth(Object barMaxWidth) {
        this.barMaxWidth = barMaxWidth;
    }

    public Object getBarMinHeight() {
        return barMinHeight;
    }

    public void setBarMinHeight(Object barMinHeight) {
        this.barMinHeight = barMinHeight;
    }

    public String getBarGap() {
        return barGap;
    }

    public void setBarGap(String barGap) {
        this.barGap = barGap;
    }

    public String getBarCategoryGap() {
        return barCategoryGap;
    }

    public void setBarCategoryGap(String barCategoryGap) {
        this.barCategoryGap = barCategoryGap;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof BarSerie)) return false;
        if (!super.equals(o)) return false;
        BarSerie barSerie = (BarSerie) o;
        return Objects.equals(legendHoverLink, barSerie.legendHoverLink) &&
                Objects.equals(xAxisIndex, barSerie.xAxisIndex) &&
                Objects.equals(yAxisIndex, barSerie.yAxisIndex) &&
                Objects.equals(stack, barSerie.stack) &&
                Objects.equals(barWidth, barSerie.barWidth) &&
                Objects.equals(barMaxWidth, barSerie.barMaxWidth) &&
                Objects.equals(barMinHeight, barSerie.barMinHeight) &&
                Objects.equals(barGap, barSerie.barGap) &&
                Objects.equals(barCategoryGap, barSerie.barCategoryGap);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), legendHoverLink, xAxisIndex,
                yAxisIndex, stack, barWidth, barMaxWidth, barMinHeight, barGap, barCategoryGap);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder(32)
                .append(getClass()).append("{");
        appendPrefix(sb);
        sb.append(", legendHoverLink=").append(legendHoverLink);
        sb.append(", coordinateSystem=").append(getCoordinateSystem());
        sb.append(", xAxisIndex=").append(xAxisIndex);
        sb.append(", yAxisIndex=").append(yAxisIndex);
        sb.append(", label=").append(getLabel());
        sb.append(", itemStyle=").append(getItemStyle());
        sb.append(", stack='").append(stack).append('\'');
        sb.append(", barWidth=").append(barWidth);
        sb.append(", barMaxWidth=").append(barMaxWidth);
        sb.append(", barMinHeight=").append(barMinHeight);
        sb.append(", barGap='").append(barGap).append('\'');
        sb.append(", barCategoryGap='").append(barCategoryGap).append('\'');
        sb.append(", data=").append(getData());
        appendMarks(sb);
        appendCanvasZ(sb);
        appendAnimation(sb);
        sb.append('}');
        return sb.toString();
    }
}
