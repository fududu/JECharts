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

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;
import java.util.Objects;

/**
 * 范围限制。
 *
 * @author Fuchun
 * @since 1.0
 */
public class Limit<C extends Comparable<C>> implements Serializable {

    public static final String KEY_MIN = "min";
    public static final String KEY_MAX = "max";

    private static final long serialVersionUID = 1L;

    public static IntLimit intLimit(int min, int max) {
        return new IntLimit(min, max);
    }

    public static DoubleLimit doubleLimit(double min, double max) {
        return new DoubleLimit(min, max);
    }

    public static class IntLimit extends Limit<Integer> {

        private static final long serialVersionUID = 8691053282116195136L;

        @JsonCreator
        public IntLimit(
                @JsonProperty(value = KEY_MIN, required = false) Integer min,
                @JsonProperty(value = KEY_MAX, required = false) Integer max) {
            super(min, max);
        }
    }

    public static class DoubleLimit extends Limit<Double> {

        private static final long serialVersionUID = 1534373970835057557L;

        @JsonCreator
        public DoubleLimit(
                @JsonProperty(value = KEY_MIN, required = false) Double min,
                @JsonProperty(value = KEY_MAX, required = false) Double max) {
            super(min, max);
        }
    }

    private final C min;
    private final C max;

    public Limit(C min, C max) {
        this.min = min;
        this.max = max;
    }

    public C getMin() {
        return min;
    }

    public C getMax() {
        return max;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Limit)) return false;
        Limit<?> limit = (Limit<?>) o;
        return Objects.equals(min, limit.min) &&
                Objects.equals(max, limit.max);
    }

    @Override
    public int hashCode() {
        return Objects.hash(min, max);
    }

    @Override
    public String toString() {
        return String.format("%s{min=%s, max=%s}", getClass(), getMin(), getMax());
    }
}
