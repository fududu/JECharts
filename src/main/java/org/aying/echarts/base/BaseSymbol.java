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

package org.aying.echarts.base;

import java.io.Serializable;
import java.util.Objects;

/**
 * The abstract base implementation of the {@code Symbol}.
 *
 * @author Fuchun
 * @since 1.0
 */
public abstract class BaseSymbol<S extends BaseSymbol<S>> implements Symbol<S>, Serializable {

    private static final long serialVersionUID = 1L;

    private SymbolType symbol;
    private Object symbolSize;
    /* 标记的旋转角度。 */
    private Integer symbolRotate;
    private transient Offset _symbolOffset;

    protected BaseSymbol() {
        super();
    }

    @SuppressWarnings("unchecked")
    protected S me() {
        return (S) this;
    }

    @Override
    public SymbolType getSymbol() {
        return symbol;
    }

    public void setSymbol(SymbolType symbol) {
        this.symbol = symbol;
    }

    @Override
    public Object getSymbolSize() {
        return symbolSize;
    }

    public void setSymbolSize(Object symbolSize) {
        this.symbolSize = symbolSize;
    }

    @Override
    public Integer getSymbolRotate() {
        return symbolRotate;
    }

    public void setSymbolRotate(Integer symbolRotate) {
        this.symbolRotate = symbolRotate;
    }

    @Override
    public Object[] getSymbolOffset() {
        return _symbolOffset == null ? null :
                _symbolOffset.toArray();
    }

    public void setSymbolOffset(Object[] symbolOffset) {
        if (symbolOffset == null || symbolOffset.length == 0) return;
        if (symbolOffset.length != 2) {
            throw new IllegalArgumentException("symbolOffset value must be [x, y]");
        }
        this._symbolOffset = Offset.of(symbolOffset);
    }

    @Override
    public S symbol(SymbolType symbolType) {
        this.symbol = symbolType;
        return me();
    }

    @Override
    public S symbolSize(Integer size) {
        this.symbolSize = size;
        return me();
    }

    @Override
    public S symbolSize(int w, int h) {
        this.symbolSize = new int[] { w, h };
        return me();
    }

    @Override
    public S symbolRotate(Integer rotate) {
        this.symbolRotate = rotate;
        return me();
    }

    @Override
    public S offset(Object x, Object y) {
        this._symbolOffset = Offset.of(x, y);
        return me();
    }

    public boolean isEmptyProps() {
        return symbol == null && symbolSize == null &&
                symbolRotate == null && _symbolOffset == null;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof BaseSymbol)) return false;
        BaseSymbol<?> that = (BaseSymbol<?>) o;
        return symbol == that.symbol &&
                Objects.equals(symbolSize, that.symbolSize) &&
                Objects.equals(symbolRotate, that.symbolRotate) &&
                Objects.equals(_symbolOffset, that._symbolOffset);
    }

    @Override
    public int hashCode() {
        return Objects.hash(symbol, symbolSize, symbolRotate, _symbolOffset);
    }

    protected void appendToString(StringBuilder builder) {
        builder.append("symbol=").append(symbol);
        builder.append(", symbolSize=").append(symbolSize);
        builder.append(", symbolRotate=").append(symbolRotate);
        builder.append(", _symbolOffset=").append(_symbolOffset);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder(32)
                .append(getClass()).append("{");
        appendToString(sb);
        sb.append('}');
        return sb.toString();
    }
}
