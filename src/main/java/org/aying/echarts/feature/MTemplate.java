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

package org.aying.echarts.feature;

import java.io.Serializable;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/**
 * {@code MagicType} 通用属性模板接口。
 *
 * @author Fuchun
 * @since 1.0
 */
public abstract class MTemplate<V> implements Serializable {

    private static final long serialVersionUID = 1L;

    public static ObjectMTemplate object() {
        return new ObjectMTemplate();
    }

    public static ObjectMTemplate object(Serializable line, Serializable bar, Serializable stack, Serializable tiled) {
        return new ObjectMTemplate(line, bar, stack, tiled);
    }

    public static StringMTemplate string() {
        return new StringMTemplate();
    }

    public static StringMTemplate string(String line, String bar, String stack, String tiled) {
        return new StringMTemplate(line, bar, stack, tiled);
    }

    public static MapMTemplate map() {
        return new MapMTemplate();
    }

    public static MapMTemplate map(
            Map<String, Object> line, Map<String, Object> bar,
            Map<String, Object> stack, Map<String, Object> tiled) {
        return new MapMTemplate(line, bar, stack, tiled);
    }

    public static ListMTemplate list() {
        return new ListMTemplate();
    }

    public static ListMTemplate list(List<Object> line, List<Object> bar, List<Object> stack, List<Object> tiled) {
        return new ListMTemplate(line, bar, stack, tiled);
    }

    public static final String KEY_LINE = "line";
    public static final String KEY_BAR = "bar";
    public static final String KEY_STACK = "stack";
    public static final String KEY_TILED = "tiled";

    private V line;
    private V bar;
    private V stack;
    private V tiled;

    protected MTemplate() {
        super();
    }

    protected MTemplate(V line, V bar, V stack, V tiled) {
        super();
        this.line = line;
        this.bar = bar;
        this.stack = stack;
        this.tiled = tiled;
    }

    public V getLine() {
        return line;
    }

    public void setLine(V line) {
        this.line = line;
    }

    public V getBar() {
        return bar;
    }

    public void setBar(V bar) {
        this.bar = bar;
    }

    public V getStack() {
        return stack;
    }

    public void setStack(V stack) {
        this.stack = stack;
    }

    public V getTiled() {
        return tiled;
    }

    public void setTiled(V tiled) {
        this.tiled = tiled;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof MTemplate)) return false;
        MTemplate<?> mTemplate = (MTemplate<?>) o;
        return Objects.equals(line, mTemplate.line) &&
                Objects.equals(bar, mTemplate.bar) &&
                Objects.equals(stack, mTemplate.stack) &&
                Objects.equals(tiled, mTemplate.tiled);
    }

    @Override
    public int hashCode() {
        return Objects.hash(line, bar, stack, tiled);
    }

    @Override
    public String toString() {
        return String.format("%s{line=%s, bar=%s, stack=%s, tiled=%s}",
                getClass(), line, bar, stack, tiled);
    }
}
