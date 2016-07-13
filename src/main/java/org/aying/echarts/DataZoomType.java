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

/**
 * {@code DataZoom} type
 *
 * @author Fuchun
 * @since 1.0
 */
public enum DataZoomType {

    /**
     * 内置于坐标系中，使用户可以在坐标系上通过鼠标拖拽、鼠标滚轮、手指滑动（触屏上）来缩放或漫游坐标系。
     */
    inside,

    /**
     * 有单独的滑动条，用户在滑动条上进行缩放或漫游。
     */
    slider,

    /**
     * 提供一个选框进行数据区域缩放。即 toolbox.feature.dataZoom，配置项在 toolbox 中。
     */
    select
}
