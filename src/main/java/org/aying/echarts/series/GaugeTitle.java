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

package org.aying.echarts.series;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.io.Serializable;

/**
 * 仪表盘标题设置。
 *
 * @author Fuchun
 * @since 1.0
 */
public class GaugeTitle extends GaugePart implements Serializable {

    private static final String[] EXCLUSIONS = new String[] { "width" };

    private static final long serialVersionUID = -4249102257575124745L;

    public static GaugeTitle title() {
        return new GaugeTitle();
    }

    public static GaugeTitle hide() {
        return new GaugeTitle(Boolean.FALSE);
    }

    public GaugeTitle() {
        super(null, EXCLUSIONS);
    }

    public GaugeTitle(Boolean show) {
        super(show, EXCLUSIONS);
    }

    @Override
    @JsonIgnore
    public Integer getWidth() {
        return super.getWidth();
    }
}
