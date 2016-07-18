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

import org.aying.echarts.feature.Brush;
import org.aying.echarts.feature.DataView;
import org.aying.echarts.feature.Restore;
import org.aying.echarts.feature.SaveAsImage;

import java.io.Serializable;

/**
 * 各工具配置项。
 *
 * @author Fuchun
 * @since 1.0
 */
public class Feature implements Serializable {

    private SaveAsImage saveAsImage;
    private Restore restore;
    private DataView dataView;
    private DataZoomSelect dataZoom;
    private Object magicType;
    private Brush brush;
}
