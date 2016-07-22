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

package org.aying.echarts.style;

import java.io.Serializable;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;

/**
 * The base implementation of the {@code Style}.
 *
 * @author Fuchun
 * @since 1.0
 */
public abstract class BaseStyle<T extends BaseStyle<T>> implements Style, Serializable {

    private static final long serialVersionUID = 1L;
    /**
     * 字体颜色。
     */
    protected String color;

    protected BaseStyle() {
        super();
    }

    @SuppressWarnings("unchecked")
    protected T me() {
        return (T) this;
    }

    /**
     * 设置样式的颜色。
     *
     * @param color 样式颜色。
     */
    @Override
    @SuppressWarnings("unchecked")
    public T color(String color) {
        this.color = color;
        return me();
    }

    @Override
    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof BaseStyle)) return false;
        BaseStyle that = (BaseStyle) o;
        return Objects.equals(color, that.color);
    }

    @Override
    public int hashCode() {
        return Objects.hash(color);
    }

    @Override
    public String toString() {
        return String.format("%s{color='%s'}",
                getClass(), color);
    }

    protected Map<String, Object> toStringMap() {
        Map<String, Object> map = new LinkedHashMap<>();
        map.put("color", getColor());
        return map;
    }
}
