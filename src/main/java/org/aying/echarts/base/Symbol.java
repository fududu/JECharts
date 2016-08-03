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

/**
 * @author Fuchun
 * @since 1.0
 */
public interface Symbol<S extends Symbol<S>> {

    SymbolType getSymbol();

    Object getSymbolSize();

    Integer getSymbolRotate();

    Object[] getSymbolOffset();

    S symbol(SymbolType symbolType);

    S symbolSize(Integer size);

    S symbolSize(int w, int h);

    S symbolRotate(Integer rotate);

    S offset(Object x, Object y);

    default S offset(Object[] offset) {
        if (offset == null || offset.length != 2) {
            throw new IllegalArgumentException("The symbolOffset must be array [x, y]");
        }
        return offset(offset[0], offset[1]);
    }
}
