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
import org.aying.echarts.base.Align;
import org.aying.echarts.style.StateGuideLineStyle;

import java.util.Objects;

/**
 * 漏斗图系列配置。
 *
 * @author Fuchun
 * @since 1.0
 */
public class FunnelSerie extends BaseSerie<FunnelSerie, SerieData> {

    public static final String ASCENDING = "ascending";
    public static final String DESCENDING = "descending";

    private static final long serialVersionUID = -4532192015654744771L;

    private Integer min;
    private Integer max;
    private Object minSize;
    private Object maxSize;
    private String sort;
    /*数据图形间距。默认：0*/
    private Integer gap;
    /*是否启用图例 hover 时的联动高亮。*/
    private Boolean legendHoverLink;
    /*水平方向对齐布局类型，默认居中对齐*/
    private Align funnelAlign;
    /*标签的视觉引导线样式*/
    private StateGuideLineStyle labelLine;

    public FunnelSerie() {
        super(ChartType.funnel);
    }

    public FunnelSerie asc() {
        this.sort = ASCENDING;
        return this;
    }

    public FunnelSerie desc() {
        this.sort = DESCENDING;
        return this;
    }

    public Integer getMin() {
        return min;
    }

    public void setMin(Integer min) {
        this.min = min;
    }

    public Integer getMax() {
        return max;
    }

    public void setMax(Integer max) {
        this.max = max;
    }

    public Object getMinSize() {
        return minSize;
    }

    public void setMinSize(Object minSize) {
        this.minSize = minSize;
    }

    public Object getMaxSize() {
        return maxSize;
    }

    public void setMaxSize(Object maxSize) {
        this.maxSize = maxSize;
    }

    public String getSort() {
        return sort;
    }

    public void setSort(String sort) {
        this.sort = sort;
    }

    public Integer getGap() {
        return gap;
    }

    public void setGap(Integer gap) {
        this.gap = gap;
    }

    public Boolean getLegendHoverLink() {
        return legendHoverLink;
    }

    public void setLegendHoverLink(Boolean legendHoverLink) {
        this.legendHoverLink = legendHoverLink;
    }

    public Align getFunnelAlign() {
        return funnelAlign;
    }

    public void setFunnelAlign(Align funnelAlign) {
        this.funnelAlign = funnelAlign;
    }

    public StateGuideLineStyle getLabelLine() {
        return labelLine;
    }

    public void setLabelLine(StateGuideLineStyle labelLine) {
        this.labelLine = labelLine;
    }

    @Override
    @JsonIgnore
    public Integer getZlevel() {
        return super.getZlevel();
    }

    @Override
    @JsonIgnore
    public Integer getZ() {
        return super.getZ();
    }

    @Override
    public FunnelSerie zLevel(int zLevel) {
        return this;
    }

    @Override
    public FunnelSerie z(int z) {
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof FunnelSerie)) return false;
        if (!super.equals(o)) return false;
        FunnelSerie that = (FunnelSerie) o;
        return Objects.equals(min, that.min) &&
                Objects.equals(max, that.max) &&
                Objects.equals(minSize, that.minSize) &&
                Objects.equals(maxSize, that.maxSize) &&
                Objects.equals(sort, that.sort) &&
                Objects.equals(gap, that.gap) &&
                Objects.equals(legendHoverLink, that.legendHoverLink) &&
                funnelAlign == that.funnelAlign &&
                Objects.equals(labelLine, that.labelLine);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), min, max, minSize, maxSize, sort, gap,
                legendHoverLink, funnelAlign, labelLine);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder(32)
                .append(getClass()).append("{");
        appendPrefix(sb);
        sb.append(", min=").append(min);
        sb.append(", max=").append(max);
        sb.append(", minSize=").append(minSize);
        sb.append(", maxSize=").append(maxSize);
        sb.append(", sort='").append(sort).append('\'');
        sb.append(", gap=").append(gap);
        sb.append(", legendHoverLink=").append(legendHoverLink);
        sb.append(", funnelAlign=").append(funnelAlign);
        sb.append(", label=").append(getLabel());
        sb.append(", labelLine=").append(labelLine);
        sb.append(", itemStyle=").append(getItemStyle());
        sb.append(", data=").append(getData());
        appendMarks(sb);
        appendAnimation(sb);
        sb.append('}');
        return sb.toString();
    }
}
