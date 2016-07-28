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

import java.io.Serializable;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;

/**
 * 表示图形组件的抽象类。
 *
 * @author Fuchun
 * @since 1.0
 */
public abstract class Graph<T extends Graph<T>> extends BasePosition<T>
        implements Position<T>, CanvasZ<T>, Serializable {

    private static final long serialVersionUID = 1L;

    private final SimpleCanvasZ canvasZ;

    protected Graph() {
        super();
        this.canvasZ = new SimpleCanvasZ();
    }

    protected Graph(Object top, Object right, Object bottom, Object left) {
        super(top, right, bottom, left);
        this.canvasZ = new SimpleCanvasZ();
    }

    @SuppressWarnings("unchecked")
    protected T me() {
        return (T) this;
    }

    @Override
    @JsonProperty(required = false)
    public Integer getZlevel() {
        return canvasZ.getZlevel();
    }

    @Override
    public void setZlevel(Integer zlevel) {
        canvasZ.setZlevel(zlevel);
    }

    @Override
    @JsonProperty(required = false)
    public Integer getZ() {
        return canvasZ.getZ();
    }

    @Override
    public void setZ(Integer z) {
        canvasZ.setZ(z);
    }

    @Override
    public T zLevel(int zLevel) {
        canvasZ.zLevel(zLevel);
        return me();
    }

    @Override
    public T z(int z) {
        canvasZ.z(z);
        return me();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Graph)) return false;
        if (!super.equals(o)) return false;
        Graph<?> graph = (Graph<?>) o;
        return Objects.equals(canvasZ, graph.canvasZ);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), canvasZ);
    }

    @Override
    protected Map<String, Object> propsMap() {
        Map<String, Object> posMap = super.propsMap();
        Map<String, Object> map = new LinkedHashMap<>();
        map.put("zlevel", getZlevel());
        map.put("z", getZ());
        map.putAll(posMap);
        return map;
    }

    public final void appendGraph(StringBuilder builder) {
        builder.append(", zlevel=").append(getZlevel());
        builder.append(", z=").append(getZ());
        builder.append(", top=").append(getTop());
        builder.append(", right=").append(getRight());
        builder.append(", bottom=").append(getBottom());
        builder.append(", left=").append(getLeft());
    }

    protected void appendToString(StringBuilder builder) {
        appendGraph(builder);
    }

    @Override
    public String toString() {
        return String.format("%s{canvasZ=%s} %s", getClass(), canvasZ, super.toString());
    }
}
