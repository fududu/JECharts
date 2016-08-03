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

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import org.aying.echarts.base.Align;
import org.aying.echarts.base.LineType;
import org.aying.echarts.base.Orient;
import org.aying.echarts.base.SelectedMode;
import org.aying.echarts.base.SizeGraph;
import org.aying.echarts.data.DataAware;
import org.aying.echarts.data.LegendData;
import org.aying.echarts.data.SimpleDataAware;
import org.aying.echarts.json.converter.LegendDataConverter;
import org.aying.echarts.json.converter.ToLegendDataConverter;
import org.aying.echarts.json.ser.JsFunctionSerializer;
import org.aying.echarts.style.ShapeStyle;
import org.aying.echarts.style.SimpleShapeStyle;
import org.aying.echarts.style.TextStyle;

import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.TreeMap;

/**
 * 图例组件模型。
 *
 * @author Fuchun
 * @since 1.0
 */
public class Legend extends SizeGraph<Legend>
        implements Component<Legend>, ShapeStyle, DataAware<LegendData, Legend> {

    private static final long serialVersionUID = -4466736220215040561L;

    private final SimpleShapeStyle sss;
    private final SimpleData sd;
    private final SimpleDataAware<LegendData> sda;

    private Boolean show;
    private Orient orient;
    private Align align;
    private Object padding;
    private Integer itemGap;
    private Integer itemWidth;
    private Integer itemHeight;
    private Object formatter;
    private Object selectedMode;
    private String inactiveColor;
    private Map<String, Boolean> selected;
    private Tooltip tooltip;

    public Legend() {
        super();
        sd = SimpleData.simple();
        sss = new SimpleShapeStyle();
        sda = new SimpleDataAware<>();
    }

    @Override
    public Boolean getShow() {
        return show;
    }

    @Override
    public void setShow(Boolean show) {
        this.show = show;
    }

    @Override
    public Legend hide() {
        this.show = Boolean.FALSE;
        return this;
    }

    @Override
    public Legend show() {
        this.show = Boolean.TRUE;
        return this;
    }

    public Orient getOrient() {
        return orient;
    }

    public void setOrient(Orient orient) {
        this.orient = orient;
    }

    public Align getAlign() {
        return align;
    }

    public void setAlign(Align align) {
        this.align = align;
    }

    public Object getPadding() {
        return padding;
    }

    public void setPadding(Object padding) {
        this.padding = padding;
    }

    public Integer getItemGap() {
        return itemGap;
    }

    public void setItemGap(Integer itemGap) {
        this.itemGap = itemGap;
    }

    public Legend itemWidth(int itemWidth) {
        this.itemWidth = itemWidth;
        return this;
    }

    public Legend itemHeight(int itemHeight) {
        this.itemHeight = itemHeight;
        return this;
    }

    public Legend formatter(String formatter) {
        this.formatter = formatter;
        return this;
    }

    public Legend selectedMode(SelectedMode mode) {
        this.selectedMode = mode;
        return this;
    }

    public Legend closeSelectedMode() {
        this.selectedMode = false;
        return this;
    }

    public Legend inactiveColor(String color) {
        this.inactiveColor = color;
        return this;
    }

    public Legend selected(String name, Boolean selected) {
        Objects.requireNonNull(name, "selected name");
        if (this.selected == null) {
            this.selected = new TreeMap<>();
        }
        if (selected == null) {
            this.selected.remove(name);
        } else {
            this.selected.put(name, selected);
        }
        return this;
    }

    public Legend selected(Map<String, Boolean> selected) {
        if (selected == null || selected.isEmpty()) {
            this.selected = null;
        } else {
            this.selected = new TreeMap<>(selected);
        }
        return this;
    }

    public Integer getItemWidth() {
        return itemWidth;
    }

    public void setItemWidth(Integer itemWidth) {
        this.itemWidth = itemWidth;
    }

    public Integer getItemHeight() {
        return itemHeight;
    }

    public void setItemHeight(Integer itemHeight) {
        this.itemHeight = itemHeight;
    }

    @JsonSerialize(using = JsFunctionSerializer.class)
    public Object getFormatter() {
        return formatter;
    }

    public void setFormatter(Object formatter) {
        this.formatter = formatter;
    }

    public Object getSelectedMode() {
        return selectedMode;
    }

    public void setSelectedMode(Object selectedMode) {
        this.selectedMode = selectedMode;
    }

    public String getInactiveColor() {
        return inactiveColor;
    }

    public void setInactiveColor(String inactiveColor) {
        this.inactiveColor = inactiveColor;
    }

    public Map<String, Boolean> getSelected() {
        return selected;
    }

    public void setSelected(Map<String, Boolean> selected) {
        this.selected = selected;
    }

    @Override
    public TextStyle getTextStyle() {
        return sss.getTextStyle();
    }

    public void setTextStyle(TextStyle textStyle) {
        sss.setTextStyle(textStyle);
    }

    public Tooltip getTooltip() {
        return tooltip;
    }

    public void setTooltip(Tooltip tooltip) {
        this.tooltip = tooltip;
    }

    @Override
    public Legend addData(LegendData d) {
        sda.addData(d);
        return this;
    }

    @Override
    public Legend addData(LegendData d1, LegendData d2, LegendData... dn) {
        sda.addData(d1, d2, dn);
        return this;
    }

    @Override
    @JsonSerialize(contentConverter = LegendDataConverter.class)
    public List<LegendData> getData() {
        return sda.getData();
    }

    @JsonDeserialize(contentConverter = ToLegendDataConverter.class)
    public void setData(List<LegendData> dataList) {
        sda.setData(dataList);
    }

    @Override
    @JsonIgnore
    public String getColor() {
        return null;
    }

    @Override
    @SuppressWarnings("unchecked")
    public Legend color(String color) {
        return this;
    }

    @JsonProperty(required = false)
    public String getBackgroundColor() {
        return sss.getBackgroundColor();
    }

    public void setBackgroundColor(String backgroundColor) {
        sss.setBackgroundColor(backgroundColor);
    }

    @JsonProperty(required = false)
    public String getBorderColor() {
        return sss.getBorderColor();
    }

    public void setBorderColor(String borderColor) {
        sss.setBorderColor(borderColor);
    }

    @JsonProperty(required = false)
    public Integer getBorderWidth() {
        return sss.getBorderWidth();
    }

    public void setBorderWidth(Integer borderWidth) {
        sss.setBorderWidth(borderWidth);
    }

    @Override
    @JsonIgnore
    public LineType getBorderType() {
        return null;
    }

    @JsonProperty(required = false)
    public Integer getShadowBlur() {
        return sss.getShadowBlur();
    }

    public void setShadowBlur(Integer shadowBlur) {
        sss.setShadowBlur(shadowBlur);
    }

    @JsonProperty(required = false)
    public String getShadowColor() {
        return sss.getShadowColor();
    }

    public void setShadowColor(String shadowColor) {
        sss.setShadowColor(shadowColor);
    }

    @JsonProperty(required = false)
    public Integer getShadowOffsetX() {
        return sss.getShadowOffsetX();
    }

    public void setShadowOffsetX(Integer shadowOffsetX) {
        sss.setShadowOffsetX(shadowOffsetX);
    }

    @JsonProperty(required = false)
    public Integer getShadowOffsetY() {
        return sss.getShadowOffsetY();
    }

    public void setShadowOffsetY(Integer shadowOffsetY) {
        sss.setShadowOffsetY(shadowOffsetY);
    }

    @Override
    @JsonIgnore
    public Double getOpacity() {
        return null;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Legend)) return false;
        if (!super.equals(o)) return false;
        Legend legend = (Legend) o;
        return Objects.equals(sss, legend.sss) &&
                Objects.equals(show, legend.show) &&
                orient == legend.orient &&
                align == legend.align &&
                Objects.equals(padding, legend.padding) &&
                Objects.equals(itemGap, legend.itemGap) &&
                Objects.equals(itemWidth, legend.itemWidth) &&
                Objects.equals(itemHeight, legend.itemHeight) &&
                Objects.equals(formatter, legend.formatter) &&
                Objects.equals(selectedMode, legend.selectedMode) &&
                Objects.equals(inactiveColor, legend.inactiveColor) &&
                Objects.equals(selected, legend.selected) &&
                Objects.equals(tooltip, legend.tooltip) &&
                Objects.equals(sd, legend.sd);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), sss, show, orient, align, padding, itemGap, itemWidth,
                itemHeight, formatter, selectedMode, inactiveColor, selected, tooltip, sd);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder(32)
                .append(getClass()).append("{");
        sb.append("show=").append(show);
        appendSizeGraph(sb);
        sb.append(", orient=").append(orient);
        sb.append(", align=").append(align);
        sb.append(", padding=").append(padding);
        sb.append(", itemGap=").append(itemGap);
        sb.append(", itemWidth=").append(itemWidth);
        sb.append(", itemHeight=").append(itemHeight);
        sb.append(", formatter=").append(formatter);
        sb.append(", selectedMode=").append(selectedMode);
        sb.append(", inactiveColor='").append(inactiveColor).append('\'');
        sb.append(", selected=").append(selected);
        sb.append(", textStyle=").append(getTextStyle());
        sb.append(", tooltip=").append(tooltip);
        sb.append(", data=").append(getData());
        sb.append(", backgroundColor='").append(getBackgroundColor()).append('\'');
        sb.append(", borderColor='").append(getBorderColor()).append('\'');
        sb.append(", borderWidth=").append(getBorderWidth());
        sb.append(", shadowBlur=").append(getShadowBlur());
        sb.append(", shadowColor='").append(getShadowColor()).append('\'');
        sb.append(", shadowOffsetX=").append(getShadowOffsetX());
        sb.append(", shadowOffsetY=").append(getShadowOffsetY());
        sb.append('}');
        return sb.toString();
    }
}
