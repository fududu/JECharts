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
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import java.math.BigDecimal;

/**
 * @author Fuchun
 * @since 1.0
 */
@JsonPropertyOrder(value = {
        Piecewise.KEY_MIN, Piecewise.KEY_MAX, Piecewise.KEY_GTE, Piecewise.KEY_GT,
        Piecewise.KEY_LT, Piecewise.KEY_LTE, Piecewise.KEY_VALUE,
        Piecewise.KEY_LABEL, Piecewise.KEY_COLOR
})
public class DefaultPiecewise implements Piecewise {

    @JsonCreator
    public static DefaultPiecewise of(
            @JsonProperty(value = KEY_MIN, required = false) BigDecimal inputMin,
            @JsonProperty(value = KEY_MAX, required = false) BigDecimal inputMax,
            @JsonProperty(value = KEY_LT, required = false) BigDecimal inputLt,
            @JsonProperty(value = KEY_LTE, required = false) BigDecimal inputLte,
            @JsonProperty(value = KEY_GT, required = false) BigDecimal inputGt,
            @JsonProperty(value = KEY_GTE, required = false) BigDecimal inputGte,
            @JsonProperty(value = KEY_VALUE, required = false) BigDecimal inputVal,
            @JsonProperty(value = KEY_COLOR, required = false) String inputColor,
            @JsonProperty(value = KEY_LABEL, required = false) String inputLabel) {

        String color = (inputColor != null) ? inputColor.trim() : null;
        String label = (inputLabel != null) ? inputLabel.trim() : null;

        // 当有 value 值时优先解析
        if (inputVal != null) {
            Long value = inputVal.longValue();
            return new DefaultPiecewise(value, value, color, label);
        }

        // 解析 min、max
        if (inputMin != null || inputMax != null) {
            Long min = (inputMin == null) ? null : inputMin.longValue();
            Long max = (inputMax == null) ? null : inputMax.longValue();
            return new DefaultPiecewise(min, max, color, label);
        }

        // 解析顺序 lte > lt, gte > gt
        Long lower = null, upper = null;
        BoundType lowerBoundType = null, upperBoundType = null;
        if (inputLte != null) {
            upper = inputLte.longValue();
            upperBoundType = BoundType.CLOSED;
        } else if (inputLt != null) {
            upper = inputLt.longValue();
            upperBoundType = BoundType.OPEN;
        }

        if (inputGte != null) {
            lower = inputGte.longValue();
            lowerBoundType = BoundType.CLOSED;
        } else if (inputGt != null) {
            lower = inputGt.longValue();
            lowerBoundType = BoundType.OPEN;
        }

        if (lower == null && upper == null) {
            throw new IllegalArgumentException(
                    "Invalid piece range. At least contains `min, max, lt, lte, gt or gte`");
        }
        return new DefaultPiecewise(lower, lowerBoundType, upper, upperBoundType, color, label);
    }

    // legacy option
    private final Long min;
    private final Long max;

    private final Long lower;
    private final Long upper;
    private final BoundType lowerBoundType;
    private final BoundType upperBoundType;

    private final String color;
    private final String label;

    private final transient Long value;

    protected DefaultPiecewise(Long min, Long max, String color, String label) {
        if (min != null && max != null) {
            if (min > max) {
                throw new IllegalArgumentException(String.format(
                        "Invalid range: [%d, %d]", min, max));
            } else if (min.equals(max)) {
                this.value = min;
            } else {
                this.value = null;
            }
        } else {
            this.value = null;
        }

        this.min = min;
        this.max = max;
        this.color = color;
        this.label = label;

        this.lower = null;
        this.upper = null;
        this.lowerBoundType = null;
        this.upperBoundType = null;
    }

    protected DefaultPiecewise(
            Long lower, BoundType lowerBoundType, Long upper, BoundType upperBoundType,
            String color, String label) {
        this.min = null;
        this.max = null;
        this.lower = lower;
        this.upper = upper;
        this.lowerBoundType = lowerBoundType;
        this.upperBoundType = upperBoundType;
        this.color = color;
        this.label = label;

        if (lower != null && upper != null &&
                lowerBoundType == BoundType.CLOSED && upperBoundType == BoundType.CLOSED &&
                lower.equals(upper)) {
            this.value = lower;
        } else {
            this.value = null;
        }
    }

    @Override
    public Long getMin() {
        if (value != null) {
            return null;
        }
        return min;
    }

    @Override
    public Long getMax() {
        if (value != null) {
            return null;
        }
        return max;
    }

    @Override
    public Long getLt() {
        if (upper == null || upperBoundType == null ||
                upperBoundType == BoundType.CLOSED) {
            return null;
        }
        return upper;
    }

    @Override
    public Long getLte() {
        if (upper == null || upperBoundType == null ||
                upperBoundType == BoundType.OPEN) {
            return null;
        }
        return upper;
    }

    @Override
    public Long getGt() {
        if (lower == null || lowerBoundType == null ||
                lowerBoundType == BoundType.CLOSED) {
            return null;
        }
        return lower;
    }

    @Override
    public Long getGte() {
        if (lower == null || lowerBoundType == null ||
                lowerBoundType == BoundType.OPEN) {
            return null;
        }
        return lower;
    }

    @Override
    public Long getValue() {
        return value;
    }

    @JsonIgnore
    public Long getLower() {
        return lower;
    }

    @JsonIgnore
    public Long getUpper() {
        return upper;
    }

    @Override
    public String getColor() {
        return color;
    }

    @Override
    public String getLabel() {
        return label;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder(getClass().getSimpleName());
        builder.append("{");
        if (value != null) {
            builder.append("value=").append(value).append(", ");
        } else if (min != null || max != null) {
            if (min != null)
                builder.append(KEY_MIN).append("=").append(min).append(", ");
            if (max != null)
                builder.append(KEY_MAX).append("=").append(max).append(", ");
        } else {
            builder.append("range=");
            if (lower == null) {
                builder.append("(").append("-\u221e");
            } else {
                if (lowerBoundType == BoundType.CLOSED) {
                    builder.append("[");
                } else {
                    builder.append("(");
                }
                builder.append(lower);
            }
            builder.append(", ");
            if (upper == null) {
                builder.append("+\u221e").append(")");
            } else {
                builder.append(upper);
                if (upperBoundType == BoundType.CLOSED) {
                    builder.append("]");
                } else {
                    builder.append(")");
                }
            }
            builder.append(", ");
        }

        builder.append(KEY_COLOR).append("=").append(color).append(", ");
        builder.append(KEY_LABEL).append("=").append(label);
        builder.append("}");
        return builder.toString();
    }
}
