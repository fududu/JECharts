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

import java.util.Objects;

/**
 * Base implementation for {@code CanvasZ} interface.
 *
 * @author Fuchun
 * @since 1.0
 */
public abstract class BaseCanvasZ<Z extends BaseCanvasZ<Z>> implements CanvasZ<Z> {

    private Integer zlevel;
    private Integer z;

    protected BaseCanvasZ() {
        super();
    }

    protected BaseCanvasZ(Integer zlevel, Integer z) {
        this.zlevel = zlevel;
        this.z = z;
    }

    @Override
    @JsonProperty(required = false)
    public Integer getZlevel() {
        return zlevel;
    }

    @Override
    public void setZlevel(Integer zlevel) {
        this.zlevel = zlevel;
    }

    @Override
    @JsonProperty(required = false)
    public Integer getZ() {
        return z;
    }

    @Override
    public void setZ(Integer z) {
        this.z = z;
    }

    @Override
    @SuppressWarnings("unchecked")
    public Z zLevel(int zLevel) {
        this.zlevel = zLevel;
        return (Z) this;
    }

    @Override
    @SuppressWarnings("unchecked")
    public Z z(int z) {
        this.z = z;
        return (Z) this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof BaseCanvasZ)) return false;
        BaseCanvasZ that = (BaseCanvasZ) o;
        return Objects.equals(zlevel, that.zlevel) &&
                Objects.equals(z, that.z);
    }

    @Override
    public int hashCode() {
        return Objects.hash(zlevel, z);
    }

    @Override
    public String toString() {
        return String.format("%s{zlevel=%d, z=%d}", getClass(), zlevel, z);
    }
}
