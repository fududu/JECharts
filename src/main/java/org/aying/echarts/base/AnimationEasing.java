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
 * ECharts 缓动效果枚举。
 *
 * @author Fuchun
 * @since 1.0
 */
public enum AnimationEasing {

    linear,

    quadraticIn,

    quadraticOut,

    quadraticInOut,

    cubicIn,

    cubicOut,

    cubicInOut,

    quarticIn,

    quarticOut,

    quarticInOut,

    quinticIn,

    quinticOut,

    quinticInOut,

    sinusoidalIn,

    sinusoidalOut,

    sinusoidalInOut,

    exponetialIn,

    exponetialOut,

    exponetialInOut,

    circularIn,

    circularOut,

    circularInOut,

    elasticIn,

    elasticOut,

    elasticInOut,

    backIn,

    backOut,

    backInOut,

    bounceIn,

    bounceOut,

    bounceInOut;

    @Nullable
    public static AnimationEasing ofNullable(Object v) {
        return of(v, null);
    }

    @Contract("_, !null -> !null")
    public static AnimationEasing of(Object v, AnimationEasing def) {
        if (v == null) return def;
        if (v instanceof AnimationEasing) {
            return (AnimationEasing) v;
        }
        String n = ((String) v).trim();
        for (AnimationEasing ae : values()) {
            if (ae.name().equalsIgnoreCase(n)) {
                return ae;
            }
        }
        return def;
    }
}
