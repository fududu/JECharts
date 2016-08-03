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

package org.aying.echarts.data;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import org.aying.echarts.style.SimpleTextStyle;
import org.aying.echarts.style.TextStyle;
import org.jetbrains.annotations.NotNull;

import java.util.Map;
import java.util.Objects;

/**
 * {@link Data} 数据模型的简单实现。
 *
 * @author Fuchun
 * @since 1.0
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class SimpleData implements Data {

    private static final long serialVersionUID = 1L;

    public static SimpleData convert(Map<String, Object> map) {
        if (map == null || map.isEmpty()) return null;
        SimpleData sd = new SimpleData();
        copyProps(sd, map);
        return sd;
    }

    public static <D extends SimpleData> void copyProps(
            @NotNull D d, Map<String, Object> map) {
        Object value = map.get("value");
        String name = (String) map.get("name");
        Object oTextStyle = map.get("textStyle");
        d.setName(name);
        d.setValue(value);
        if (oTextStyle == null) {
            return;
        }
        if (oTextStyle instanceof TextStyle) {
            d.setTextStyle((TextStyle) oTextStyle);
        } else if (oTextStyle instanceof Map) {
            @SuppressWarnings("unchecked")
            Map<String, Object> tsMap = (Map<String, Object>) oTextStyle;
            d.setTextStyle(new SimpleTextStyle(tsMap));
        } else {
            throw new IllegalArgumentException("The data[i].textStyle is invalid: " + oTextStyle.toString());
        }
    }

    /** 数据项名称。 */
    protected String name;
    /** 数据项值（Number|String|Boolean）。 */
    protected Object value;
    /** 数据项文本样式。*/
    protected TextStyle textStyle;

    public SimpleData() {
        super();
    }

    public SimpleData(String name, Object value) {
        super();
        this.name = name;
        this.value = value;
    }

    public SimpleData(Map<String, Object> map) {
        super();
        initFromMap(map);
    }

    protected void initFromMap(Map<String, Object> map) {
        String name = (String) map.get("name");
        Object value = map.get("value");
        Object oTextStyle = map.get("textStyle");
        this.name = name;
        this.value = value;

        if (oTextStyle != null && oTextStyle instanceof Map) {
            @SuppressWarnings("unchecked")
            Map<String, Object> tsMap = (Map<String, Object>) oTextStyle;
            this.textStyle = new SimpleTextStyle(tsMap);
        }
    }

    @Override
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public Object getValue() {
        return value;
    }

    public void setValue(Object value) {
        this.value = value;
    }

    @Override
    @JsonDeserialize(as = SimpleTextStyle.class)
    public TextStyle getTextStyle() {
        return textStyle;
    }

    public void setTextStyle(TextStyle textStyle) {
        this.textStyle = textStyle;
    }

    @Override
    public Object toSingleValue() {
        if (textStyle == null && name == null && value != null) {
            return getValue();
        }
        return this;
    }

    protected void appendSimpleData(StringBuilder sb) {
        sb.append("name='").append(getName()).append("'");
        sb.append(", value=").append(getValue());
        sb.append(", textStyle=").append(getTextStyle());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof SimpleData)) return false;
        SimpleData that = (SimpleData) o;
        return Objects.equals(name, that.name) &&
                Objects.equals(value, that.value) &&
                Objects.equals(textStyle, that.textStyle);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, value, textStyle);
    }

    @Override
    public String toString() {
        return String.format("org.aying.echarts.data.SimpleData{name='%s', value=%s, textStyle=%s}",
                name, value, textStyle);
    }
}
