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

/**
 * 位置枚举。
 *
 * @author Fuchun
 * @since 1.0
 */
public enum Position {

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

    private static final Position[] MAIN_POSITIONS =
            new Position[] { inside, left, right, top, bottom };

    public static Position[] main() {
        return Arrays.copyOf(MAIN_POSITIONS, MAIN_POSITIONS.length);
    }

    final Position parent;

    Position() {
        this.parent = null;
    }

    Position(Position parent) {
        this.parent = parent;
    }

    public Position getParent() {
        return parent;
    }

    public static Position of(String v, Position def) {
        if (v == null || (v = v.trim()).isEmpty()) {
            return def;
        }
        for (Position p : values()) {
            if (p.name().equals(v)) {
                return p;
            }
        }
        return def;
    }
}
