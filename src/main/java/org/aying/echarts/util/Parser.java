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

package org.aying.echarts.util;

import org.jetbrains.annotations.Contract;

import java.util.List;

/**
 * JSON与JAVA类型解析器。
 *
 * @author Fuchun
 * @since 1.0
 */
public abstract class Parser {

    @Contract("null -> null")
    public static Object padding(Object input) {
        if (input == null) return null;
        if (input instanceof Number || input instanceof Object[] ||
                input instanceof int[]) {
            return input;
        } else if (input instanceof List) {
            Object[] arr = ((List) input).toArray();
            if (arr.length != 2 && arr.length != 4) {
                throw new IllegalArgumentException("The padding array length must be 2 or 4");
            }
            return arr;
        }
        throw new IllegalArgumentException("The padding value (" + input + ") is invalid");
    }

    private Parser() {}
}
