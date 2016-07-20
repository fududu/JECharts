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
 * The base implementation of the {@code Size}
 *
 * @author Fuchun
 * @since 1.0
 */
public abstract class BaseSize<S extends BaseSize<S>> implements Size<S>, Serializable {

    private static final long serialVersionUID = 1L;

    private Object width;
    private Object height;

    protected BaseSize() {
        super();
    }

    protected BaseSize(int width, int height) {
        this.width = width;
        this.height = height;
    }

    protected BaseSize(String width, String height) {
        this.width = width;
        this.height = height;
    }

    @SuppressWarnings("unchecked")
    protected S me() {
        return (S) this;
    }

    public Object getWidth() {
        return width;
    }

    public void setWidth(Object width) {
        this.width = width;
    }

    public Object getHeight() {
        return height;
    }

    public void setHeight(Object height) {
        this.height = height;
    }

    @Override
    public S autoWidth() {
        return width("auto");
    }

    @Override
    public S autoHeight() {
        return height("auto");
    }

    @Override
    public S width(int width) {
        this.width = width;
        return me();
    }

    @Override
    public S width(String width) {
        this.width = width;
        return me();
    }

    @Override
    public S height(int height) {
        this.height = height;
        return me();
    }

    @Override
    public S height(String height) {
        this.height = height;
        return me();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof BaseSize)) return false;
        BaseSize size = (BaseSize) o;
        return Objects.equals(width, size.width) &&
                Objects.equals(height, size.height);
    }

    @Override
    public int hashCode() {
        return Objects.hash(width, height);
    }

    @Override
    public String toString() {
        return String.format("%s{width=%s, height=%s}", getClass(), width, height);
    }
}
