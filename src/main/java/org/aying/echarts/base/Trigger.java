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

/**
 * 触发类型枚举。
 *
 * @author Fuchun
 * @since 1.0
 */
public enum Trigger {

    /**
     * 数据项图形触发，主要在散点图，饼图等无类目轴的图表中使用。
     */
    item,

    /**
     * 坐标轴触发，主要在柱状图，折线图等会使用类目轴的图表中使用。
     */
    axis
}
