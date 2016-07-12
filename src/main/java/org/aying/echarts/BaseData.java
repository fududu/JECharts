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

package org.aying.echarts;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

/**
 * @author Fuchun
 * @since 1.0
 */
public abstract class BaseData<T extends Data<T> & Serializable>
        implements Data<T>, Serializable {

    private static final long serialVersionUID = 1L;

    public static <T extends Data<T> & Serializable> BaseData<T> delegate() {
        return new BaseData<T>() {
            private static final long serialVersionUID = 1469927142676858646L;
        };
    }

    public static <T extends Data<T> & Serializable> BaseData<T> delegate(Collection<Data<?>> data) {
        return new BaseData<T>(data) {
            private static final long serialVersionUID = 1469927142676858646L;
        };
    }

    /**
     * 相关统计数据。
     */
    protected List<Data<?>> data;

    public BaseData() {
        super();
    }

    public BaseData(Collection<Data<?>> data) {
        super();
        if (data == null || data.isEmpty()) {
            this.data = null;
        } else {
            this.data = new LinkedList<>(data);
        }
    }

    @Override
    @SuppressWarnings("unchecked")
    public T add(Data<?> d) {
        Objects.requireNonNull(d, "data");
        initData();
        data.add(d);
        return (T) this;
    }

    @Override
    @SuppressWarnings("unchecked")
    public T add(Data<?> d1, Data<?> d2, Data<?>... dn) {
        Objects.requireNonNull(d1, "First data");
        Objects.requireNonNull(d2, "Second data");
        initData();
        data.add(d1);
        data.add(d2);
        if (dn != null && dn.length > 0) {
            data.addAll(Arrays.asList(dn));
        }
        return (T) this;
    }

    private void initData() {
        if (data == null) {
            data = new LinkedList<>();
        }
    }

    @Override
    public List<Data<?>> getData() {
        return data;
    }

    public void setData(List<Data<?>> data) {
        this.data = data;
    }
}
