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

import org.aying.echarts.base.SimpleSymbol;
import org.aying.echarts.base.StateLabel;
import org.aying.echarts.base.Symbol;
import org.aying.echarts.base.SymbolType;
import org.aying.echarts.data.SimpleData;
import org.aying.echarts.style.StateGuideLineStyle;
import org.aying.echarts.style.StateShapeStyle;

import java.util.Objects;

/**
 * {@code serie} 系列配置基础数据模型。
 *
 * @author Fuchun
 * @since 1.0
 */
public class SerieData extends SimpleData implements Symbol<SerieData> {

    private static final long serialVersionUID = 8451075212669521179L;

    /** {@code Symbol<SerieData>} 的委拖（代理） */
    protected final SimpleSymbol ss;
    private Integer category;
    private Boolean selected;
    private StateLabel label;
    private StateGuideLineStyle labelLine;
    private StateShapeStyle itemStyle;

    public SerieData() {
        super();
        ss = new SimpleSymbol();
    }

    @Override
    public SerieData symbol(SymbolType symbolType) {
        ss.symbol(symbolType);
        return this;
    }

    @Override
    public SerieData symbolSize(Integer size) {
        ss.symbolSize(size);
        return this;
    }

    @Override
    public SerieData symbolSize(int w, int h) {
        ss.symbolSize(w, h);
        return this;
    }

    @Override
    public SerieData symbolRotate(Integer rotate) {
        ss.symbolRotate(rotate);
        return this;
    }

    @Override
    public SerieData offset(Object x, Object y) {
        ss.offset(x, y);
        return this;
    }

    public Integer getCategory() {
        return category;
    }

    public void setCategory(Integer category) {
        this.category = category;
    }

    public Boolean getSelected() {
        return selected;
    }

    public void setSelected(Boolean selected) {
        this.selected = selected;
    }

    @Override
    public SymbolType getSymbol() {
        return ss.getSymbol();
    }

    public void setSymbol(SymbolType symbol) {
        ss.setSymbol(symbol);
    }

    @Override
    public Object getSymbolSize() {
        return ss.getSymbolSize();
    }

    public void setSymbolSize(Object size) {
        ss.setSymbolSize(size);
    }

    @Override
    public Integer getSymbolRotate() {
        return ss.getSymbolRotate();
    }

    public void setSymbolRotate(Integer rotate) {
        ss.setSymbolRotate(rotate);
    }

    @Override
    public Object[] getSymbolOffset() {
        return ss.getSymbolOffset();
    }

    public void setSymbolOffset(Object[] offset) {
        ss.setSymbolOffset(offset);
    }

    public StateLabel getLabel() {
        return label;
    }

    public void setLabel(StateLabel label) {
        this.label = label;
    }

    public StateGuideLineStyle getLabelLine() {
        return labelLine;
    }

    public void setLabelLine(StateGuideLineStyle labelLine) {
        this.labelLine = labelLine;
    }

    public StateShapeStyle getItemStyle() {
        return itemStyle;
    }

    public void setItemStyle(StateShapeStyle itemStyle) {
        this.itemStyle = itemStyle;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof SerieData)) return false;
        if (!super.equals(o)) return false;
        SerieData serieData = (SerieData) o;
        return Objects.equals(ss, serieData.ss) &&
                Objects.equals(category, serieData.category) &&
                Objects.equals(selected, serieData.selected) &&
                Objects.equals(label, serieData.label) &&
                Objects.equals(labelLine, serieData.labelLine) &&
                Objects.equals(itemStyle, serieData.itemStyle);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), ss, category, selected, label, labelLine, itemStyle);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder(32)
                .append(getClass()).append("{");
        appendSimpleData(sb);
        sb.append(", category=").append(getCategory());
        sb.append(", selected=").append(getSelected());
        ss.appendSymbol(sb);
        sb.append(", label=").append(label);
        sb.append(", labelLine=").append(labelLine);
        sb.append(", itemStyle=").append(itemStyle);
        sb.append('}');
        return sb.toString();
    }
}
