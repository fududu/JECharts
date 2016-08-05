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

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.aying.echarts.ChartType;
import org.aying.echarts.base.Orient;
import org.aying.echarts.base.StateLabel;

import java.util.Arrays;
import java.util.Objects;

/**
 * Boxplot 中文可以称为『箱形图』、『盒须图』、『盒式图』、『盒状图』、『箱线图』。
 *
 * @author Fuchun
 * @since 1.0
 */
public class BoxPlotSerie extends BaseSerie<BoxPlotSerie, SerieData> {

    private static final long serialVersionUID = 7694685499829725331L;

    private Integer xAxisIndex;
    private Integer yAxisIndex;
    private Boolean legendHoverLink;
    private Boolean hoverAnimation;
    private Orient layout;
    /*box 的宽度的上下限。数组的意思是：[min, max]。*/
    private Object[] boxWidth;

    public BoxPlotSerie() {
        super(ChartType.boxplot);
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

    public Boolean getLegendHoverLink() {
        return legendHoverLink;
    }

    public void setLegendHoverLink(Boolean legendHoverLink) {
        this.legendHoverLink = legendHoverLink;
    }

    public Boolean getHoverAnimation() {
        return hoverAnimation;
    }

    public void setHoverAnimation(Boolean hoverAnimation) {
        this.hoverAnimation = hoverAnimation;
    }

    public Orient getLayout() {
        return layout;
    }

    public void setLayout(Orient layout) {
        this.layout = layout;
    }

    public Object[] getBoxWidth() {
        return boxWidth;
    }

    public void setBoxWidth(Object[] boxWidth) {
        this.boxWidth = boxWidth;
    }

    @Override
    @JsonIgnore
    public StateLabel getLabel() {
        return super.getLabel();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof BoxPlotSerie)) return false;
        if (!super.equals(o)) return false;
        BoxPlotSerie that = (BoxPlotSerie) o;
        return Objects.equals(xAxisIndex, that.xAxisIndex) &&
                Objects.equals(yAxisIndex, that.yAxisIndex) &&
                Objects.equals(legendHoverLink, that.legendHoverLink) &&
                Objects.equals(hoverAnimation, that.hoverAnimation) &&
                layout == that.layout &&
                Arrays.equals(boxWidth, that.boxWidth);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), xAxisIndex, yAxisIndex, legendHoverLink, hoverAnimation, layout, boxWidth);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder(32)
                .append(getClass()).append("{");
        appendPrefix(sb);
        sb.append(", coordinateSystem=").append(getCoordinateSystem());
        sb.append(", xAxisIndex=").append(xAxisIndex);
        sb.append(", yAxisIndex=").append(yAxisIndex);
        sb.append(", legendHoverLink=").append(legendHoverLink);
        sb.append(", hoverAnimation=").append(hoverAnimation);
        sb.append(", layout=").append(layout);
        sb.append(", boxWidth=").append(Arrays.toString(boxWidth));
        sb.append(", itemStyle=").append(getItemStyle());
        sb.append(", data=").append(getData());
        appendMarks(sb);
        appendCanvasZ(sb);
        appendAnimation(sb);
        sb.append('}');
        return sb.toString();
    }
}
