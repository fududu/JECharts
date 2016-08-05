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

import java.io.Serializable;

/**
 * ECharts 中配置模型或组件的顶级接口。
 *
 * @author Fuchun
 * @since 1.0
 */
public interface Component<C extends Component<C>> extends Serializable {

    /** 组件显示或隐藏属性名称：{@code show}。 */
    String KEY_SHOW = "show";

    /**
     * 是否显示组件（标签、文本、图形、线条等）。
     */
    default Boolean getShow() {
        return null;
    }

    /**
     * 设置是否显示组件（标签、文本、图形、线条等）。
     *
     * @param show 是否显示组件。
     */
    default void setShow(Boolean show) {
        // do anything
    }

    @SuppressWarnings("unchecked")
    default C hide() {
        return (C) this;
    }

    @SuppressWarnings("unchecked")
    default C show() {
        return (C) this;
    }
}
