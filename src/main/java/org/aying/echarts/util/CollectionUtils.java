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
import org.jetbrains.annotations.NotNull;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

/**
 * The collection utility class.
 *
 * @author Fuchun
 * @since 1.0
 */
public abstract class CollectionUtils {

    private static final Integer[] EMPTY_INTEGERS = new Integer[0];
    private static final Double[] EMPTY_DOUBLES = new Double[0];

    @NotNull
    public static Double[] inbox(double[] args) {
        if (args == null || args.length == 0) {
            return EMPTY_DOUBLES;
        }
        Double[] result = new Double[args.length];
        for (int i = 0; i < args.length; i++) {
            result[i] = args[i];
        }
        return result;
    }

    @NotNull
    public static Integer[] inbox(int[] args) {
        if (args == null || args.length == 0) {
            return EMPTY_INTEGERS;
        }
        Integer[] result = new Integer[args.length];
        for (int i = 0; i < args.length; i++) {
            result[i] = args[i];
        }
        return result;
    }

    @Contract("_, null -> fail")
    public static <T> List<T> single(String elName, T t) {
        Objects.requireNonNull(t, elName);
        LinkedList<T> list = new LinkedList<>();
        list.add(t);
        return list;
    }

    @SafeVarargs
    @Contract("_, null, _, _ -> fail; _, _, null, _ -> fail")
    public static <T> List<T> linkedList(String elName, T t1, T t2, T... tn) {
        Objects.requireNonNull(t1, String.format("First %s", elName));
        Objects.requireNonNull(t2, String.format("Second %s", elName));
        LinkedList<T> list = new LinkedList<>();
        list.add(t1);
        list.add(t2);
        if (tn != null && tn.length > 0) {
            Collections.addAll(list, tn);
        }
        return list;
    }

    private CollectionUtils() {}
}
