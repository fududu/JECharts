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

import org.jetbrains.annotations.NotNull;

import java.util.List;
import java.util.Map;

/**
 * The simple {@code Symbol} implementation.
 *
 * @author Fuchun
 * @since 1.0
 */
public class SimpleSymbol extends BaseSymbol<SimpleSymbol> {

    private static final long serialVersionUID = -2642219352442662667L;

    public static <S extends Symbol<S>> void copyProps(
            @NotNull S s, Map<String, Object> map) {
        Object oSymbol = map.get("symbol");
        Integer oSymbolRotate = (Integer) map.get("symbolRotate");
        Object oSymbolOffset = map.get("symbolOffset");
        Object oSymbolSize = map.get("symbolSize");

        s.symbol(SymbolType.of(oSymbol, null))
                .symbolRotate(oSymbolRotate);

        if (oSymbolOffset != null) {
            if (oSymbolOffset instanceof Object[]) {
                s.offset((Object[]) oSymbolOffset);
            } else if (oSymbolOffset instanceof List) {
                s.offset(((List) oSymbolOffset).toArray());
            }
        }
        if (oSymbolSize != null) {
            if (oSymbolSize instanceof Number) {
                s.symbolSize(((Number) oSymbolSize).intValue());
            } else if (oSymbolSize instanceof Object[]) {
                Object[] size = (Object[]) oSymbolSize;
                if (size.length != 2) {
                    throw new IllegalArgumentException("The symbolSize must be number or [width, height]");
                }
                s.symbolSize(((Number) size[0]).intValue(), ((Number) size[1]).intValue());
            } else if (oSymbolSize instanceof List) {
                @SuppressWarnings("unchecked")
                List<Object> sizeList = (List<Object>) oSymbolSize;
                if (sizeList.size() != 2) {
                    throw new IllegalArgumentException("The symbolSize must be number or [width, height]");
                }
                s.symbolSize(((Number) sizeList.get(0)).intValue(),
                        ((Number) sizeList.get(1)).intValue());
            }
        }
    }

    public SimpleSymbol() {
        super();
    }

    public void appendSymbol(StringBuilder sb) {
        sb.append(", ");
        super.appendToString(sb);
    }

    @Override
    public void appendToString(StringBuilder builder) {
        super.appendToString(builder);
    }
}
