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
import org.aying.echarts.base.SymbolType;

/**
 * @author Fuchun
 * @since 1.0
 */
public class MarkArea extends Mark<MarkArea> {

    private static final long serialVersionUID = -4049625519115442903L;

    public MarkArea() {
        super();
    }

    @Override
    @JsonIgnore
    public SymbolType getSymbol() {
        return null;
    }

    @Override
    @JsonIgnore
    public Integer getSymbolSize() {
        return null;
    }

    @Override
    @JsonIgnore
    public Integer getSymbolRotate() {
        return null;
    }

    @Override
    @JsonIgnore
    public Object[] getSymbolOffset() {
        return null;
    }

    @Override
    public MarkArea symbol(SymbolType symbolType) {
        return this;
    }

    @Override
    public MarkArea symbolSize(Integer size) {
        return this;
    }

    @Override
    public MarkArea symbolSize(int w, int h) {
        return this;
    }

    @Override
    public MarkArea symbolRotate(Integer rotate) {
        return this;
    }

    @Override
    public MarkArea offset(Object x, Object y) {
        return this;
    }
}
