/*
 * Copyright 2016 Aying.Org all rights reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.aying.echarts.feature;

/**
 * 选框组件的控制按钮。
 *
 * @author Fuchun
 * @since 1.0
 */
public enum BrushType {

    /**
     * 开启矩形选框选择功能。
     */
    rect,

    /**
     * 开启任意形状选框选择功能。
     */
    polygon,

    /**
     * 开启横向选择功能。
     */
    lineX,

    /**
     * 开启纵向选择功能。
     */
    lineY,

    /**
     * 切换『单选』和『多选』模式。后者可支持同时画多个选框。前者支持单击清除所有选框。
     */
    keep,

    /**
     * 清空所有选框。
     */
    clear
}
