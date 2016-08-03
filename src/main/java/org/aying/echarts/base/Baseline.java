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
 * 垂直对齐方式。
 *
 * @author Fuchun
 * @since 1.0
 */
public enum Baseline {

    auto,

    /**
     * 顶部对齐。
     */
    top,

    /**
     * 垂直居中对齐。
     */
    middle,

    /**
     * 底部对齐。
     */
    bottom;

    @Contract("_, !null -> !null")
    public static Baseline of(Object v, Baseline b) {
        if (v == null) {
            return b;
        }
        if (v instanceof Baseline) {
            return (Baseline) v;
        }
        String s = ((String) v).trim().toLowerCase();
        for (Baseline bl : values()) {
            if (bl.name().equals(s)) {
                return bl;
            }
        }
        return b;
    }
}
