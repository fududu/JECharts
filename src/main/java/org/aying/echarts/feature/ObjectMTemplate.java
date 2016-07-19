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

package org.aying.echarts.feature;

import java.io.Serializable;

/**
 * @author Fuchun
 * @since 1.0
 */
public class ObjectMTemplate extends MTemplate<Serializable> {

    private static final long serialVersionUID = -2215144272423407375L;

    public ObjectMTemplate() {
        super();
    }

    public ObjectMTemplate(
            Serializable line, Serializable bar, Serializable stack, Serializable tiled) {
        super(line, bar, stack, tiled);
    }
}
