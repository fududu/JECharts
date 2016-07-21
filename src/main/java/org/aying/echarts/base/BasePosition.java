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

import com.fasterxml.jackson.annotation.JsonProperty;
import org.aying.echarts.util.Validators;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;

/**
 * The base implementation of the {@code Position}.
 *
 * @author Fuchun
 * @since 1.0
 */
public abstract class BasePosition<P extends BasePosition<P>> implements Position<P> {

    private Object left;
    private Object right;
    private Object top;
    private Object bottom;

    protected BasePosition() {
        super();
    }

    protected BasePosition(Object top, Object right, Object bottom, Object left) {
        this.top = top;
        this.right = right;
        this.bottom = bottom;
        this.left = left;
    }

    @SuppressWarnings("unchecked")
    protected P me() {
        return (P) this;
    }

    @Override
    @JsonProperty(required = false)
    public Object getLeft() {
        return left;
    }

    public void setLeft(Object left) {
        if (left == null) {
            this.left = null;
        } else if (left instanceof Number) {
            this.left = ((Number) left).intValue();
        } else if (left instanceof String) {
            Align align = Align.of((String) left, null);
            if (align == null) {
                this.left = left;
            } else {
                this.left = align;
            }
        } else if (left instanceof Align) {
            this.left = left;
        } else {
            throw new IllegalArgumentException(String.format(
                    "Unsupported value(%s[%s]) for `left` option",
                    left.getClass(), left));
        }
    }

    @Override
    @JsonProperty(required = false)
    public Object getRight() {
        return right;
    }

    public void setRight(Object right) {
        if (right == null) {
            this.right = null;
        } else if (right instanceof Number) {
            this.right = ((Number) right).intValue();
        } else if (right instanceof String) {
            this.right = right;
        } else {
            throw new IllegalArgumentException(String.format(
                    "Unsupported value(%s[%s]) for `right` option",
                    right.getClass(), right));
        }
    }

    @Override
    @JsonProperty(required = false)
    public Object getTop() {
        return top;
    }

    public void setTop(Object top) {
        if (top == null) {
            this.top = null;
        } else if (top instanceof Number) {
            this.top = ((Number) top).intValue();
        } else if (top instanceof String) {
            Baseline b = Baseline.of((String) top, null);
            if (b == null) {
                this.top = top;
            } else {
                this.top = b;
            }
        } else if (top instanceof Baseline) {
            this.top = top;
        } else {
            throw new IllegalArgumentException(String.format(
                    "Unsupported value(%s[%s]) for `top` option",
                    top.getClass(), top));
        }
    }

    @Override
    @JsonProperty(required = false)
    public Object getBottom() {
        return bottom;
    }

    public void setBottom(Object bottom) {
        if (bottom == null) {
            this.bottom = null;
        } else if (bottom instanceof Number) {
            this.bottom = ((Number) bottom).intValue();
        } else if (bottom instanceof String) {
            this.bottom = bottom;
        } else {
            throw new IllegalArgumentException(String.format(
                    "Unsupported value(%s[%s]) for `bottom` option",
                    bottom.getClass(), bottom));
        }
    }

    @Override
    public P left(Object left) {
        if (left == null) {
            this.left = null; return me();
        }
        if (left instanceof Number) {
            this.left = ((Number) left).intValue();
        } else if (left instanceof String) {
            this.left = Validators.checkPercent((String) left);
        } else if (left instanceof Align) {
            this.left = left;
        } else {
            throw new IllegalArgumentException(
                    String.format("The left value is invalid (%s)", left));
        }
        return me();
    }

    @Override
    public P right(Object right) {
        if (right == null) {
            this.right = null; return me();
        }
        if (right instanceof Number) {
            this.right = ((Number) right).intValue();
        } else if (right instanceof String) {
            this.right = Validators.checkPercent((String) right);
        } else {
            throw new IllegalArgumentException(
                    String.format("The right value is invalid (%s)", right));
        }
        return me();
    }

    @Override
    public P top(Object top) {
        if (top == null) {
            this.top = null; return me();
        }
        if (top instanceof Number) {
            this.top = ((Number) top).intValue();
        } else if (top instanceof String) {
            this.top = Validators.checkPercent((String) top);
        } else if (top instanceof Baseline) {
            this.top = top;
        } else {
            throw new IllegalArgumentException(
                    String.format("The top value is invalid (%s)", top));
        }
        return me();
    }

    @Override
    public P bottom(Object bottom) {
        if (bottom == null) {
            this.bottom = null; return me();
        }
        if (bottom instanceof Number) {
            this.bottom = ((Number) bottom).intValue();
        } else if (bottom instanceof String) {
            this.bottom = Validators.checkPercent((String) bottom);
        } else {
            throw new IllegalArgumentException(
                    String.format("The bottom value is invalid (%s)", bottom));
        }
        return me();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof BasePosition)) return false;
        BasePosition<?> that = (BasePosition<?>) o;
        return Objects.equals(left, that.left) &&
                Objects.equals(right, that.right) &&
                Objects.equals(top, that.top) &&
                Objects.equals(bottom, that.bottom);
    }

    @Override
    public int hashCode() {
        return Objects.hash(left, right, top, bottom);
    }

    @Override
    public String toString() {
        return String.format("%s{left=%s, right=%s, top=%s, bottom=%s}",
                getClass(), left, right, top, bottom);
    }

    protected Map<String, Object> propsMap() {
        Map<String, Object> map = new LinkedHashMap<>();
        map.put("top", getTop());
        map.put("right", getRight());
        map.put("bottom", getBottom());
        map.put("left", getLeft());
        return map;
    }
}
