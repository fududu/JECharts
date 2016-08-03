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
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import org.aying.echarts.style.SimpleTextStyle;
import org.aying.echarts.style.TextStyle;

import java.io.Serializable;
import java.util.Objects;

/**
 * 雷达图组件名称属性模型。
 *
 * @author Fuchun
 * @since 1.0
 */
public class RadarName implements Serializable {

    private static final long serialVersionUID = -1148495774727852942L;

    /**
     * 直接指定雷达图组件名称的样式。
     *
     * @param textStyle 雷达图组件名称的样式。
     * @return 雷达图组件名称属性模型。
     */
    public static RadarName styled(TextStyle textStyle) {
        RadarName radarName = new RadarName();
        radarName.setTextStyle(textStyle);
        return radarName;
    }

    /**
     * 指示器名称显示的格式器。支持字符串模版（暂时不支持回调函数）。
     *
     * @param formatter 指示器名称显示的格式器。
     * @return 雷达图组件名称属性模型。
     */
    public static RadarName named(String formatter) {
        RadarName radarName = new RadarName();
        radarName.setFormatter(formatter);
        return radarName;
    }

    private Boolean show;
    private String formatter;
    private TextStyle textStyle;

    public RadarName() {
        super();
    }

    @JsonCreator
    public RadarName(
            @JsonProperty(value = "show", required = false) Boolean show,
            @JsonProperty(value = "formatter", required = false) String formatter,
            @JsonProperty(value = "textStyle", required = false)
            @JsonDeserialize(as = SimpleTextStyle.class) TextStyle textStyle) {
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
