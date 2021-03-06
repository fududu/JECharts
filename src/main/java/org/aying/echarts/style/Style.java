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

package org.aying.echarts.style;

import java.io.Serializable;

/**
 * ECharts 样式顶级接口。
 *
 * @author Fuchun
 * @since 1.0
 */
public interface Style extends Serializable {

    /**
     * 字体颜色（16进制表示，或{@code rgba(...)}）。
     */
    String getColor();

    /**
     * 设置样式的颜色。
     *
     * @param color 样式颜色。
     */
    <S extends Style> S color(String color);
}
