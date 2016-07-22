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

package org.aying.echarts.series;

import org.aying.echarts.BaseData;
import org.aying.echarts.ChartType;
import org.aying.echarts.Data;
import org.aying.echarts.base.BaseAnimation;
import org.aying.echarts.base.CanvasZ;
import org.aying.echarts.base.SimpleCanvasZ;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

/**
 * @author Fuchun
 * @since 1.0
 */
public abstract class BaseSerie<S extends BaseSerie<S>> extends BaseAnimation<S>
        implements CanvasZ<S>, Data<S>, Serializable {

    private static final long serialVersionUID = 1L;

    private final ChartType type;
    /* Data proxy delegate */
    private final BaseData<?> data;
    /* CanvasZ proxy delegate */
    private final SimpleCanvasZ simpleCanvasZ;
    private String name;
    private Boolean silent;


    protected BaseSerie(ChartType type) {
        this.type = type;
        this.data = BaseData.delegate();
        this.simpleCanvasZ = new SimpleCanvasZ();
    }

    @SuppressWarnings("unchecked")
    protected S me() {
        return (S) this;
    }

    @Override
    public S add(Data<?> d) {
        data.add(d);
        return me();
    }

    @Override
    public S add(Data<?> d1, Data<?> d2, Data<?>... dn) {
        data.add(d1, d2, dn);
        return me();
    }

    public S name(String name) {
        this.name = name;
        return me();
    }

    /**
     * 设置图形响应和触发鼠标事件。
     */
    public S nonSilent() {
        this.silent = Boolean.TRUE;
        return me();
    }

    @Override
    public List<Data<?>> getData() {
        return data.getData();
    }

    public ChartType getType() {
        return type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public Integer getZlevel() {
        return simpleCanvasZ.getZlevel();
    }

    public void setZlevel(Integer zlevel) {
        simpleCanvasZ.setZlevel(zlevel);
    }

    @Override
    public Integer getZ() {
        return simpleCanvasZ.getZ();
    }

    public void setZ(Integer z) {
        simpleCanvasZ.setZ(z);
    }

    @Override
    public S zLevel(int zLevel) {
        simpleCanvasZ.zLevel(zLevel);
        return me();
    }

    @Override
    public S z(int z) {
        simpleCanvasZ.z(z);
        return me();
    }

    public Boolean getSilent() {
        return silent;
    }

    public void setSilent(Boolean silent) {
        this.silent = silent;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof BaseSerie)) return false;
        if (!super.equals(o)) return false;
        BaseSerie<?> baseSerie = (BaseSerie<?>) o;
        return type == baseSerie.type &&
                Objects.equals(data, baseSerie.data) &&
                Objects.equals(simpleCanvasZ, baseSerie.simpleCanvasZ) &&
                Objects.equals(name, baseSerie.name) &&
                Objects.equals(silent, baseSerie.silent);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), type, data, simpleCanvasZ, name, silent);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder(32)
                .append(getClass()).append("{");
        sb.append("type=").append(type);
        sb.append(", name='").append(name).append('\'');
        sb.append(", silent=").append(silent);
        sb.append(", simpleCanvasZ=").append(simpleCanvasZ);
        sb.append(", data=").append(data);
        sb.append('}');
        return sb.toString();
    }
}
