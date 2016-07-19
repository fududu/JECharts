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

package org.aying.echarts;

import org.aying.echarts.base.Orient;
import org.aying.echarts.feature.Feature;
import org.aying.echarts.style.BorderStyle;

import java.io.Serializable;
import java.util.Map;

/**
 * 工具栏。
 *
 * @author Fuchun
 * @since 1.0
 */
public class Toolbox implements Serializable {

    private Boolean show;
    private Orient orient;
    private Integer itemSize;
    private Integer itemGap;
    private Boolean showTitle;
    private Feature feature;
    private Map<String, BorderStyle> iconStyle;
    private Integer zlevel;
    private Integer z;
    private Object left;
    private Object right;
    private Object top;
    private Object bottom;
    private Object width;
    private Object height;
}
