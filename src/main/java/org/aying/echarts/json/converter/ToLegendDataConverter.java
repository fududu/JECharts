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

import org.aying.echarts.data.LegendData;
import org.jetbrains.annotations.NotNull;

import java.util.Map;

/**
 * @author Fuchun
 * @since 1.0
 */
public class ToLegendDataConverter extends ObjectToDataConverter<Object, LegendData> {

    private static final ToLegendDataConverter CONVERTER = new ToLegendDataConverter();

    public static ToLegendDataConverter converter() {
        return CONVERTER;
    }

    public ToLegendDataConverter() {
        super(Object.class, LegendData.class);
    }

    @Override
    protected LegendData convertData(@NotNull Object value) {
        if (value instanceof LegendData) {
            return (LegendData) value;
        } else if (value instanceof String) {
            return new LegendData((String) value);
        } else if (value instanceof Map) {
            @SuppressWarnings("unchecked")
            Map<String, Object> map = (Map<String, Object>) value;
            return new LegendData(map);
        }
        return null;
    }
}
