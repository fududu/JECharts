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

package org.aying.echarts.data;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.aying.echarts.Tooltip;
import org.aying.echarts.base.SimpleSymbol;
import org.aying.echarts.base.Symbol;
import org.aying.echarts.base.SymbolType;

import java.util.Arrays;
import java.util.Map;
import java.util.Objects;

/**
 * @author Fuchun
 * @since 1.0
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class TimelineData extends SimpleData
        implements Symbol<TimelineData> {

    private static final long serialVersionUID = 6590901595613250109L;

    public static TimelineData convert(Map<String, Object> map) {
        if (map == null || map.isEmpty()) return null;
        TimelineData td = new TimelineData();
        SimpleData.copyProps(td, map);
        SimpleSymbol.copyProps(td, map);

        Object oTooltip = map.get("tooltip");
        if (oTooltip != null) {
            if (oTooltip instanceof Tooltip) {
                td.setTooltip((Tooltip) oTooltip);
            } else if (oTooltip instanceof Map) {
                @SuppressWarnings("unchecked")
                Map<String, Object> ttMap = (Map<String, Object>) oTooltip;
                td.setTooltip(Tooltip.convert(ttMap));
            }
        }
        return td;
    }

    private final SimpleSymbol ss;

    private Tooltip tooltip;

    public TimelineData() {
        this(null);
    }

    public TimelineData(Object value) {
        super(null, value);
        this.ss = new SimpleSymbol();
    }

    @Override
    @JsonIgnore
    public String getName() {
        return null;
    }

    @Override
    public Object toSingleValue() {
        if (textStyle == null && tooltip == null &&
                ss.isEmptyProps() && value != null) {
            return getValue();
        }
        return this;
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

    public void setSymbolSize(Object symbolSize) {
        ss.setSymbolSize(symbolSize);
    }

    @Override
    public Integer getSymbolRotate() {
        return ss.getSymbolRotate();
    }

    public void setSymbolRotate(Integer symbolRotate) {
        ss.setSymbolRotate(symbolRotate);
    }

    @Override
    public Object[] getSymbolOffset() {
        return ss.getSymbolOffset();
    }

    public void setSymbolOffset(Object[] offset) {
        ss.setSymbolOffset(offset);
    }

    public Tooltip getTooltip() {
        return tooltip;
    }

    public void setTooltip(Tooltip tooltip) {
        this.tooltip = tooltip;
    }

    @Override
    public TimelineData symbol(SymbolType symbolType) {
        ss.symbol(symbolType);
        return this;
    }

    @Override
    public TimelineData symbolSize(Integer size) {
        ss.symbolSize(size);
        return this;
    }

    @Override
    public TimelineData symbolSize(int w, int h) {
        ss.symbolSize(w, h);
        return this;
    }

    @Override
    public TimelineData symbolRotate(Integer rotate) {
        ss.symbolRotate(rotate);
        return this;
    }

    @Override
    public TimelineData offset(Object x, Object y) {
        ss.offset(x, y);
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof TimelineData)) return false;
        if (!super.equals(o)) return false;
        TimelineData that = (TimelineData) o;
        return Objects.equals(ss, that.ss) &&
                Objects.equals(tooltip, that.tooltip);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), ss, tooltip);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder(32)
                .append(getClass()).append("{");
        sb.append("ss=").append(ss);
        sb.append(", tooltip=").append(tooltip);
        sb.append(", symbol=").append(getSymbol());
        sb.append(", symbolSize=").append(getSymbolSize());
        sb.append(", symbolRotate=").append(getSymbolRotate());
        sb.append(", symbolOffset=").append(Arrays.toString(getSymbolOffset()));
        sb.append('}');
        return sb.toString();
    }
}
