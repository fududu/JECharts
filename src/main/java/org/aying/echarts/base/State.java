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

import java.io.Serializable;
import java.util.Objects;

/**
 * 表示组件的状态。
 *
 * @author Fuchun
 * @since 1.0
 */
public class State<S1 extends State<S1, S2>, S2 extends Serializable> implements Serializable {

    public static final String KEY_NORMAL = "normal";
    public static final String KEY_EMPHASIS = "emphasis";

    private static final long serialVersionUID = 5435371366379198168L;

    private S2 normal;
    private S2 emphasis;

    public State() {
        super();
    }

    public State(S2 normal, S2 emphasis) {
        this.normal = normal;
        this.emphasis = emphasis;
    }

    @SuppressWarnings("unchecked")
    public S1 normal(S2 normal) {
        this.normal = normal;
        return (S1) this;
    }

    @SuppressWarnings("unchecked")
    public S1 emphasis(S2 emphasis) {
        this.emphasis = emphasis;
        return (S1) this;
    }

    public S2 getNormal() {
        return normal;
    }

    public void setNormal(S2 normal) {
        this.normal = normal;
    }

    public S2 getEmphasis() {
        return emphasis;
    }

    public void setEmphasis(S2 emphasis) {
        this.emphasis = emphasis;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof State)) return false;
        @SuppressWarnings("unchecked")
        State<S1, S2> state = (State<S1, S2>) o;
        return Objects.equals(normal, state.normal) &&
                Objects.equals(emphasis, state.emphasis);
    }

    @Override
    public int hashCode() {
        return Objects.hash(normal, emphasis);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder(32)
                .append(getClass()).append("{");
        sb.append(KEY_NORMAL).append("=").append(normal);
        sb.append(", ").append(KEY_EMPHASIS).append("=").append(emphasis);
        sb.append('}');
        return sb.toString();
    }
}
