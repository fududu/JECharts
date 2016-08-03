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

import org.aying.echarts.style.TextStyle;

import java.io.Serializable;

/**
 * ECharts data 模型接口。
 *
 * @author Fuchun
 * @since 1.0
 */
public interface Data extends Serializable {

    /**
     * 数据项名称。
     */
    String getName();

    /**
     * 数据项值。
     */
    Object getValue();

    /**
     * 数据项的文本样式。
     */
    TextStyle getTextStyle();

    default Object toSingleValue() {
        return null;
    }
}
