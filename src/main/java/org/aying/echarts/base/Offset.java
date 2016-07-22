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
import java.util.Arrays;
import java.util.Objects;

/**
 * 相对位置偏移量的基础模型。
 *
 * @author Fuchun
 * @since 1.0
 */
public class Offset implements Serializable {

    private static final long serialVersionUID = 4646001863808511469L;

    public static Offset of(Object[] objects) {
        Objects.requireNonNull(objects, "offset");
        if (objects.length != 2) {
            throw new IllegalArgumentException("objects values must be [x, y]");
        }
        checkOffset(objects[0], objects[1]);
        return new Offset(objects[0], objects[1]);
    }

    @JsonCreator
    public static Offset of(
            @JsonProperty("x") Object x,
            @JsonProperty("y") Object y) {
        checkOffset(x, y);
        return new Offset(x, y);
    }

    private static void checkOffset(Object x, Object y) {
        Objects.requireNonNull(x, "x");
        Objects.requireNonNull(y, "y");
        if (!(x instanceof Number || x instanceof String) ||
                !(y instanceof Number || y instanceof String)) {
            throw new IllegalArgumentException(
                    "Offset[x, y] value must be Number or String. Like [0, 0], [0, '50%']");
        }
    }

    private final Object x;
    private final Object y;
    private final Object[] array;

    protected Offset(Object x, Object y) {
        this.x = x;
        this.y = y;
        array = new Object[] { this.x, this.y };
    }

    public Object getX() {
        return x;
    }

    public Object getY() {
        return y;
    }

    public Object[] toArray() {
        return Arrays.copyOf(array, 2);
    }

    @Override
    public String toString() {
        return String.format("[%s, %s]", getX(), getY());
    }
}
