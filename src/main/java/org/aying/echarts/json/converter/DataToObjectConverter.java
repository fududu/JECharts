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

package org.aying.echarts.json.converter;

import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.type.TypeFactory;
import com.fasterxml.jackson.databind.util.Converter;
import org.aying.echarts.data.Data;
import org.jetbrains.annotations.NotNull;

/**
 * @author Fuchun
 * @since 1.0
 */
public abstract class DataToObjectConverter<D extends Data> implements Converter<D, Object> {

    private final Class<D> dataClass;

    protected DataToObjectConverter(Class<D> dataClass) {
        this.dataClass = dataClass;
    }

    @Override
    public final Object convert(D data) {
        if (data == null) return null;
        return convertObject(data);
    }

    protected Object convertObject(@NotNull D data) {
        return data.toSingleValue();
    }

    @Override
    public JavaType getInputType(TypeFactory typeFactory) {
        return typeFactory.constructType(dataClass);
    }

    @Override
    public JavaType getOutputType(TypeFactory typeFactory) {
        return typeFactory.constructType(Object.class);
    }
}
