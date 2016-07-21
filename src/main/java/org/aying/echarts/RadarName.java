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

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;
import java.time.format.TextStyle;
import java.util.Objects;

/**
 * 雷达图组件名称属性模型。
 *
 * @author Fuchun
 * @since 1.0
 */
public class RadarName implements Serializable {

    private static final long serialVersionUID = -1148495774727852942L;

    private Boolean show;
    private String formatter;
    private TextStyle textStyle;

    public RadarName() {
        super();
    }

    @JsonCreator
    public RadarName(
            @JsonProperty(required = false) Boolean show,
            @JsonProperty(required = false) String formatter,
            @JsonProperty(required = false) TextStyle textStyle) {
        this.show = show;
        this.formatter = formatter;
        this.textStyle = textStyle;
    }

    public Boolean getShow() {
        return show;
    }

    public void setShow(Boolean show) {
        this.show = show;
    }

    public String getFormatter() {
        return formatter;
    }

    public void setFormatter(String formatter) {
        this.formatter = formatter;
    }

    public TextStyle getTextStyle() {
        return textStyle;
    }

    public void setTextStyle(TextStyle textStyle) {
        this.textStyle = textStyle;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof RadarName)) return false;
        RadarName radarName = (RadarName) o;
        return Objects.equals(show, radarName.show) &&
                Objects.equals(formatter, radarName.formatter) &&
                textStyle == radarName.textStyle;
    }

    @Override
    public int hashCode() {
        return Objects.hash(show, formatter, textStyle);
    }

    @Override
    public String toString() {
        return String.format("%s{show=%s, formatter='%s', textStyle=%s}",
                getClass(), show, formatter, textStyle);
    }
}
