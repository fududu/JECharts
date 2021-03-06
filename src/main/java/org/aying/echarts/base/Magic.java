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
 * 动态切换的类型枚举。
 *
 * @author Fuchun
 * @since 1.0
 */
public enum Magic {

    /**
     * 折线图
     */
    line,

    /**
     * 柱状图
     */
    bar,

    /**
     * 堆叠模式
     */
    stack,

    /**
     * 平铺模式
     */
    tiled;

    public static Magic of(String v) {
        if (v == null || (v = v.trim()).isEmpty()) {
            return null;
        }
        String n = v.toLowerCase();
        for (Magic magic : values()) {
            if (magic.name().equals(n)) {
                return magic;
            }
        }
        return null;
    }
}
