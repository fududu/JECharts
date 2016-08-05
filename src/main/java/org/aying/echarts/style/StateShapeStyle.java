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

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import org.aying.echarts.base.State;

/**
 * 带有{@code normal} 和{@code emphasis} 两个状态的{@code ShapeStyle} 配置模型。
 *
 * @author Fuchun
 * @since 1.0
 */
public class StateShapeStyle extends State<StateShapeStyle, ShapeStyle> {

    private static final long serialVersionUID = 8417504858904299064L;

    @JsonCreator
    public static StateShapeStyle of(
            @JsonProperty(value = KEY_NORMAL, required = false)
            @JsonDeserialize(as = SimpleShapeStyle.class)
            ShapeStyle normal,
            @JsonProperty(value = KEY_EMPHASIS, required = false)
            @JsonDeserialize(as = SimpleShapeStyle.class)
            ShapeStyle emphasis) {
        return new StateShapeStyle(normal, emphasis);
    }

    public StateShapeStyle() {
        super();
    }

    public StateShapeStyle(ShapeStyle normal, ShapeStyle emphasis) {
        super(normal, emphasis);
    }
}
