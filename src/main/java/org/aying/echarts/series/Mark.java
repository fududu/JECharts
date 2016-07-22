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

import org.aying.echarts.BaseData;
import org.aying.echarts.Data;
import org.aying.echarts.base.BaseAnimation;
import org.aying.echarts.base.SimpleSymbol;
import org.aying.echarts.base.StateLabel;
import org.aying.echarts.base.Symbol;
import org.aying.echarts.base.SymbolType;
import org.aying.echarts.style.StateShapeStyle;

import java.util.List;
import java.util.Objects;

/**
 * 图表标注。
 *
 * @author Fuchun
 * @since 1.0
 */
public abstract class Mark<M extends Mark<M>> extends BaseAnimation<M>
        implements Symbol<M>, Data<M> {

    private static final long serialVersionUID = 1L;

    public static MarkPoint point() {
        return new MarkPoint();
    }

    public static MarkLine line() {
        return new MarkLine();
    }

    public static MarkArea area() {
        return new MarkArea();
    }

    private final SimpleSymbol simpleSymbol;
    /* Data proxy delegate */
    private final BaseData<?> data;

    private Boolean silent;
    private StateLabel label;
    private StateShapeStyle itemStyle;

    protected Mark() {
        super();
        simpleSymbol = new SimpleSymbol();
        data = BaseData.delegate();
    }

    @Override
    public SymbolType getSymbol() {
        return simpleSymbol.getSymbol();
    }

    public void setSymbol(SymbolType symbol) {
        simpleSymbol.setSymbol(symbol);
    }

    @Override
    public Integer getSymbolSize() {
        return simpleSymbol.getSymbolSize();
    }

    public void setSymbolSize(Integer symbolSize) {
        simpleSymbol.setSymbolSize(symbolSize);
    }

    @Override
    public Integer getSymbolRotate() {
        return simpleSymbol.getSymbolRotate();
    }

    public void setSymbolRotate(Integer symbolRotate) {
        simpleSymbol.setSymbolRotate(symbolRotate);
    }

    @Override
    public Object[] getSymbolOffset() {
        return simpleSymbol.getSymbolOffset();
    }

    public void setSymbolOffset(Object[] symbolOffset) {
        simpleSymbol.setSymbolOffset(symbolOffset);
    }

    public Boolean getSilent() {
        return silent;
    }

    public void setSilent(Boolean silent) {
        this.silent = silent;
    }

    public StateLabel getLabel() {
        return label;
    }

    public void setLabel(StateLabel label) {
        this.label = label;
    }

    public StateShapeStyle getItemStyle() {
        return itemStyle;
    }

    public void setItemStyle(StateShapeStyle itemStyle) {
        this.itemStyle = itemStyle;
    }

    @Override
    public M symbol(SymbolType symbolType) {
        simpleSymbol.symbol(symbolType);
        return me();
    }

    @Override
    public M symbolSize(Integer size) {
        simpleSymbol.symbolSize(size);
        return me();
    }

    @Override
    public M symbolRotate(Integer rotate) {
        simpleSymbol.symbolRotate(rotate);
        return me();
    }

    @Override
    public M offset(Object x, Object y) {
        simpleSymbol.offset(x, y);
        return me();
    }

    @Override
    public M add(Data<?> d) {
        data.add(d);
        return me();
    }

    @Override
    public M add(Data<?> d1, Data<?> d2, Data<?>... dn) {
        data.add(d1, d2, dn);
        return me();
    }

    @Override
    public List<Data<?>> getData() {
        return data.getData();
    }

    public void setData(List<Data<?>> data) {
        this.data.setData(data);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Mark)) return false;
        if (!super.equals(o)) return false;
        Mark mark = (Mark) o;
        return Objects.equals(simpleSymbol, mark.simpleSymbol) &&
                Objects.equals(data, mark.data) &&
                Objects.equals(silent, mark.silent) &&
                Objects.equals(label, mark.label) &&
                Objects.equals(itemStyle, mark.itemStyle);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), simpleSymbol, data, silent, label, itemStyle);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder(32)
                .append(getClass()).append("{");
        sb.append("simpleSymbol=").append(simpleSymbol);
        sb.append(", data=").append(data);
        sb.append(", silent=").append(silent);
        sb.append(", label=").append(label);
        sb.append(", itemStyle=").append(itemStyle);
        sb.append("} ").append(super.toString());
        return sb.toString();
    }
}
