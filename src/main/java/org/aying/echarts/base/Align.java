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
import org.jetbrains.annotations.Nullable;

/**
 * 水平对齐方式枚举。
 *
 * @author Fuchun
 * @since 1.0
 */
public enum Align {

    /**
     * 自动。
     */
    auto,

    /**
     * 居左。
     */
    left,

    /**
     * 居中（水平）
     */
    center,

    /**
     * 居右。
     */
    right;

    @Nullable
    public static Align ofNullable(Object v) {
        return of(v, null);
    }

    @Contract("_, !null -> !null")
    public static Align of(Object v, Align a) {
        if (v == null) return a;
        if (v instanceof Align) {
            return (Align) v;
        }
        String s = ((String) v).trim().toLowerCase();
        for (Align align : values()) {
            if (align.name().equals(s)) {
                return align;
            }
        }
        return a;
    }
}
