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
 * 数据过滤模式。
 * <p>
 * 如何设置，由用户根据场景和需求自己决定。经验来说：
 * <ul>
 * <li>当『只有 X 轴 或 只有 Y 轴受 dataZoom 组件控制』时，常使用 filterMode: 'filter'，这样能使另一个轴自适应过滤后的数值范围。</li>
 * <li>当『X 轴 Y 轴分别受 dataZoom 组件控制』时：
 * <ul>
 * <li>如果 X 轴和 Y 轴是『同等地位的、不应互相影响的』，比如在『双数值轴散点图』中，那么两个轴可都设为 fiterMode: 'empty'。</li>
 * <li>如果 X 轴为主，Y 轴为辅，比如在『柱状图』中，需要『拖动 dataZoomX 改变 X 轴过滤柱子时，Y 轴的范围也自适应剩余柱子的高度』，
 * 『拖动 dataZoomY 改变 Y 轴过滤柱子时，X 轴范围不受影响』，那么就 X轴设为 fiterMode: 'filter'，Y 轴设为
 * fiterMode: 'empty'，即主轴 'filter'，辅轴 'empty'。</li>
 * </ul>
 * </li>
 * </ul>
 *
 * @author Fuchun
 * @since 1.0
 */
public enum FilterMode {

    /**
     * 当前数据窗口外的数据，被 <b>过滤掉</b>。即会影响其他轴的数据范围。
     */
    filter,

    /**
     * 当前数据窗口外的数据，被 <b>设置为空</b>。即不会影响其他轴的数据范围。
     */
    empty
}
