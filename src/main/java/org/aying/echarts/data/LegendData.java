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

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.aying.echarts.base.SymbolType;

import java.util.Map;
import java.util.Objects;

/**
 * 图列{@link org.aying.echarts.Legend} 的数据项模型。
 *
 * @author Fuchun
 * @since 1.0
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class LegendData extends SimpleData {

    private static final long serialVersionUID = -7052842856768569282L;

    private Object icon;

    public LegendData() {
        super();
    }

    public LegendData(String name) {
        super(name, null);
    }

    public LegendData(Map<String, Object> map) {
        super(map);
        initIcon(map.get("icon"));
    }

    protected void initIcon(Object oIcon) {
        if (oIcon instanceof String) {
            String sIcon = (String) oIcon;
            // 图片路径 或 SVG PathData
            if (sIcon.startsWith("image://") || sIcon.startsWith("path://")) {
                this.icon = sIcon;
            } else {
                this.icon = SymbolType.of(sIcon, null);
            }
        } else if (oIcon instanceof SymbolType) {
            this.icon = oIcon;
        }
    }

    public Object getIcon() {
        return icon;
    }

    public void setIcon(Object icon) {
        this.icon = icon;
    }

    @Override
    @JsonIgnore
    public Object getValue() {
        return super.getValue();
    }

    @Override
    public Object toSingleValue() {
        if (icon == null && textStyle == null && name != null) {
            return name;
        }
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof LegendData)) return false;
        if (!super.equals(o)) return false;
        LegendData that = (LegendData) o;
        return icon == that.icon;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), icon);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder(32)
                .append(getClass()).append("{");
        appendSimpleData(sb);
        sb.append(", icon=").append(icon);
        sb.append('}');
        return sb.toString();
    }
}
