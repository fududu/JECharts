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

import org.jetbrains.annotations.Contract;

/**
 * ECharts 内置的图元（标记）枚举。
 *
 * @author Fuchun
 * @since 1.0
 */
public enum SymbolType {

    /**
     * 空心圆。
     */
    emptyCircle,

    /**
     * 圆形。
     */
    circle,

    /**
     * 矩形。
     */
    rect,

    /**
     * 圆角矩形
     */
    roundRect,

    /**
     * 三角形
     */
    triangle,

    /**
     * 方块（钻石）
     */
    diamond,

    /**
     * 针形
     */
    pin,

    /**
     * 箭头。
     */
    arrow;

    @Contract("_, !null -> !null")
    public static SymbolType of(Object v, SymbolType def) {
        if (v == null) return def;
        if (v instanceof SymbolType) {
            return (SymbolType) v;
        }
        String n = ((String) v).trim().toLowerCase();
        for (SymbolType type : values()) {
            if (type.name().equalsIgnoreCase(n)) {
                return type;
            }
        }
        return def;
    }
}
