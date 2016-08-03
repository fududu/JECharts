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

package org.aying.echarts.data;

import com.fasterxml.jackson.databind.util.Converter;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

/**
 * @author Fuchun
 * @since 1.0
 */
public abstract class BaseDataAware<D, T extends BaseDataAware<D, T>>
        implements DataAware<D, T>, Serializable {

    private static final long serialVersionUID = 1L;
    /**
     * ECharts component data property.
     */
    protected List<D> dataList;

    @SuppressWarnings("unchecked")
    protected T me() {
        return (T) this;
    }

    protected List<D> getOrInitData() {
        if (dataList == null) {
            dataList = new LinkedList<>();
        }
        return dataList;
    }

    @Override
    public T addData(D d) {
        Objects.requireNonNull(d, "Add data");
        getOrInitData().add(d);
        return me();
    }

    @Override
    @SuppressWarnings("all")
    public T addData(D d1, D d2, D... dn) {
        Objects.requireNonNull(d1, "First data");
        Objects.requireNonNull(d2, "Second data");
        getOrInitData().add(d1);
        dataList.add(d2);
        if (dn != null && dn.length > 0) {
            Collections.addAll(dataList, dn);
        }
        return me();
    }

    @Override
    public List<D> getData() {
        return dataList;
    }

    public void setData(List<D> data) {
        this.dataList = data;
    }

    public void setData(List<Object> dataList, Converter<Object, D> converter) {
        if (dataList == null || dataList.isEmpty()) return;
        Objects.requireNonNull(converter, "converter");
        List<D> list = new ArrayList<>(dataList.size());
        int i = 0;
        for (Object s : dataList) {
            D ld = converter.convert(s);
            if (ld != null) {
                list.add(i++, ld);
            }
        }
        this.dataList = list;
    }

    public void appendData(StringBuilder sb) {
        sb.append(", data=").append(getData());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof BaseDataAware)) return false;
        BaseDataAware<?, ?> that = (BaseDataAware<?, ?>) o;
        return Objects.equals(dataList, that.dataList);
    }

    @Override
    public int hashCode() {
        return Objects.hash(dataList);
    }

    @Override
    public String toString() {
        return String.format("org.aying.echarts.data.BaseDataAware{dataList=%s, data=%s}", dataList, getData());
    }
}
