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

package org.aying.echarts.axis;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import org.aying.echarts.style.AreaStyle;
import org.aying.echarts.style.DefaultAreaStyle;

import java.io.Serializable;

/**
 * 坐标轴在 grid 区域中的分隔区域
 *
 * @author Fuchun
 * @since 1.0
 */
public class SplitArea implements Serializable {

    private static final long serialVersionUID = 6896512610727255610L;

    private Boolean show;
    private Object interval;
    private AreaStyle areaStyle;

    @JsonProperty(required = false)
    public Boolean getShow() {
        return show;
    }

    public void setShow(Boolean show) {
        this.show = show;
    }

    @JsonProperty(required = false)
    public Object getInterval() {
        return interval;
    }

    public void setInterval(Object interval) {
        this.interval = interval;
    }

    @JsonProperty(required = false)
    @JsonDeserialize(as = DefaultAreaStyle.class)
    public AreaStyle getAreaStyle() {
        return areaStyle;
    }

    public void setAreaStyle(AreaStyle areaStyle) {
        this.areaStyle = areaStyle;
    }
}
