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

import java.util.Objects;

/**
 * @author Fuchun
 * @since 1.0
 */
public abstract class SizeGraph<T extends SizeGraph<T>> extends Graph<T>
        implements Position<T>, CanvasZ<T>, Size<T> {

    private final SimpleSize simpleSize;

    protected SizeGraph() {
        super();
        simpleSize = new SimpleSize();
    }

    @SuppressWarnings("unchecked")
    protected T me() {
        return (T) this;
    }

    @Override
    public Object getWidth() {
        return simpleSize.getWidth();
    }

    @Override
    public void setWidth(Object width) {
        simpleSize.setWidth(width);
    }

    @Override
    public Object getHeight() {
        return simpleSize.getHeight();
    }

    @Override
    public void setHeight(Object height) {
        simpleSize.setHeight(height);
    }

    @Override
    public T autoWidth() {
        simpleSize.autoWidth();
        return me();
    }

    @Override
    public T autoHeight() {
        simpleSize.autoHeight();
        return me();
    }

    @Override
    public T width(int width) {
        simpleSize.width(width);
        return me();
    }

    @Override
    public T width(String width) {
        simpleSize.width(width);
        return me();
    }

    @Override
    public T height(int height) {
        simpleSize.height(height);
        return me();
    }

    @Override
    public T height(String height) {
        simpleSize.height(height);
        return me();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof SizeGraph)) return false;
        if (!super.equals(o)) return false;
        SizeGraph<?> sizeGraph = (SizeGraph<?>) o;
        return Objects.equals(simpleSize, sizeGraph.simpleSize);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), simpleSize);
    }

    @Override
    public String toString() {
        return "org.aying.echarts.base.SizeGraph{" +
                "simpleSize=" + simpleSize +
                "} " + super.toString();
    }
}
