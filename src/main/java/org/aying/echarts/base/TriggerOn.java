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
 * 提示框触发的条件枚举。
 *
 * @author Fuchun
 * @since 1.0
 */
public enum TriggerOn {

    mousemove,

    click;

    public static TriggerOn ofNullable(Object v) {
        return of(v, null);
    }

    @Contract("_, !null -> !null")
    public static TriggerOn of(Object v, TriggerOn def) {
        if (v == null) return def;
        if (v instanceof TriggerOn) {
            return (TriggerOn) v;
        }
        String n = ((String) v).trim().toLowerCase();
        for (TriggerOn triggerOn : values()) {
            if (triggerOn.name().equals(n)) {
                return triggerOn;
            }
        }
        return def;
    }
}
