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
 * A abstract {@code Converter} implementation from {@code Object} to {@code Data}.
 *
 * @author Fuchun
 * @since 1.0
 */
public abstract class ObjectToDataConverter<IN, D extends Data> implements Converter<IN, D> {

    protected final Class<IN> inputClass;
    protected final Class<D> dataClass;

    public ObjectToDataConverter(Class<IN> inputClass, Class<D> dataClass) {
        this.inputClass = inputClass;
        this.dataClass = dataClass;
    }

    @Override
    public D convert(IN value) {
        if (value == null) {
            return null;
        }
        if (value.getClass() == dataClass) {
            return dataClass.cast(value);
        }
        return convertData(value);
    }

    protected abstract D convertData(@NotNull Object value);

    @Override
    public JavaType getInputType(TypeFactory typeFactory) {
        return typeFactory.constructType(inputClass);
    }

    @Override
    public JavaType getOutputType(TypeFactory typeFactory) {
        return typeFactory.constructType(dataClass);
    }
}
