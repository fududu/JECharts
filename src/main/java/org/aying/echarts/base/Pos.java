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

import java.util.Arrays;
import java.util.List;

/**
 * 位置枚举。
 *
 * @author Fuchun
 * @since 1.0
 */
public enum Pos {

    /**
     * 所在图形的内部中心位置。
     */
    inside,

    insideLeft(inside),

    insideRight(inside),

    insideTop(inside),

    insideBottom(inside),

    insideTopLeft(inside),

    insideBottomLeft(inside),

    insideTopRight(inside),

    insideBottomRight(inside),

    left,

    right,

    top,

    bottom;

    private static final Pos[] MAIN_POSITIONS =
            new Pos[] { inside, left, right, top, bottom };

    public static Pos[] main() {
        return Arrays.copyOf(MAIN_POSITIONS, MAIN_POSITIONS.length);
    }

    final Pos parent;

    Pos() {
        this.parent = null;
    }

    Pos(Pos parent) {
        this.parent = parent;
    }

    public Pos getParent() {
        return parent;
    }

    public static Object parse(Object p) {
        if (p == null) return null;
        if (p instanceof Pos || p instanceof Object[]) {
            // Pos or [top, left]
            return p;
        } else if (p instanceof List) {
            return ((List) p).toArray();
        } else if (p instanceof String) {
            Pos pos = of((String) p, null);
            if (pos == null) {
                return p;
            }
            return pos;
        }
        throw new IllegalArgumentException("The position value is invalid " + p);
    }

    public static Pos of(String v, Pos def) {
        if (v == null || (v = v.trim()).isEmpty()) {
            return def;
        }
        for (Pos p : values()) {
            if (p.name().equals(v)) {
                return p;
            }
        }
        return def;
    }
}
