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

/**
 * 图形阴影样式。
 *
 * @author Fuchun
 * @since 1.0
 */
public interface ShadowStyle extends Style {

    /**
     * 图形阴影的模糊大小。
     */
    Integer getShadowBlur();

    /**
     * 阴影颜色。
     */
    String getShadowColor();

    /**
     * 阴影水平方向上的偏移距离。
     */
    Integer getShadowOffsetX();

    /**
     * 阴影垂直方向上的偏移距离。
     */
    Integer getShadowOffsetY();

    /**
     * 图形透时度。{@code 0..1}
     */
    Double getOpacity();
}
