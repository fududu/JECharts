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
 * 分段信息（数据、样式等）模型。
 *
 * @author Fuchun
 * @since 1.0
 */
public interface Piecewise {

    String KEY_MIN = "min";
    String KEY_MAX = "max";
    String KEY_LT = "lt";
    String KEY_LTE = "lte";
    String KEY_GT = "gt";
    String KEY_GTE = "gte";
    String KEY_COLOR = "color";
    String KEY_LABEL = "label";
    String KEY_VALUE = "value";

    enum BoundType {
        CLOSED,

        OPEN
    }

    static Piecewise fixed(long value, String color, String label) {
        return fixed(value, value, color, label);
    }

    static Piecewise fixed(Long min, Long max, String color, String label) {
        return new DefaultPiecewise(min, max, color, label);
    }

    static Piecewise fixedMin(long min, String color, String label) {
        return fixed(min, null, color, label);
    }

    static Piecewise fixedMax(long max, String color, String label) {
        return fixed(null, max, color, label);
    }

    static Piecewise closed(
            long lower, long upper, String color, String label) {
        return new DefaultPiecewise(lower, BoundType.CLOSED, upper, BoundType.CLOSED, color, label);
    }

    static Piecewise open(
            long lower, long upper, String color, String label) {
        return new DefaultPiecewise(lower, BoundType.OPEN, upper, BoundType.OPEN, color, label);
    }

    static Piecewise openClosed(
            long lower, long upper, String color, String label) {
        return new DefaultPiecewise(lower, BoundType.OPEN, upper, BoundType.CLOSED, color, label);
    }

    static Piecewise closedOpen(
            long lower, long upper, String color, String label) {
        return new DefaultPiecewise(lower, BoundType.CLOSED, upper, BoundType.OPEN, color, label);
    }

    static Piecewise lessThan(long endpoint, String color, String label) {
        return new DefaultPiecewise(null, BoundType.OPEN, endpoint, BoundType.OPEN, color, label);
    }

    static Piecewise atMost(long endpoint, String color, String label) {
        return new DefaultPiecewise(null, BoundType.OPEN, endpoint, BoundType.CLOSED, color, label);
    }

    static Piecewise greaterThan(long endpoint, String color, String label) {
        return new DefaultPiecewise(endpoint, BoundType.OPEN, null, BoundType.OPEN, color, label);
    }

    static Piecewise atLeast(long endpoint, String color, String label) {
        return new DefaultPiecewise(endpoint, BoundType.CLOSED, null, BoundType.OPEN, color, label);
    }

    Long getMin();

    Long getMax();

    Long getLt();

    Long getLte();

    Long getGt();

    Long getGte();

    Long getValue();

    String getColor();

    String getLabel();
}
