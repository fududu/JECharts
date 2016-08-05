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

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * 带有{@code normal} 和{@code emphasis} 两个状态的{@code Label} 配置模型。
 *
 * @author Fuchun
 * @since 1.0
 */
public class StateLabel extends State<StateLabel, Label> {

    private static final long serialVersionUID = 5170274833949878474L;

    @JsonCreator
    public static StateLabel of(
            @JsonProperty(value = "normal", required = false)
            Label normal,
            @JsonProperty(value = "emphasis", required = false)
            Label emphasis) {
        return new StateLabel(normal, emphasis);
    }

    public StateLabel() {
        super();
    }

    public StateLabel(Label normal, Label emphasis) {
        super(normal, emphasis);
    }
}
