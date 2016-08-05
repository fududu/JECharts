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

import org.aying.echarts.base.LineType;
import org.jetbrains.annotations.Contract;

import java.util.Map;
import java.util.Objects;

/**
 * The simple implementation of the {@code LineStyle}.
 *
 * @author Fuchun
 * @since 1.0
 */
public class SimpleLineStyle extends BaseShadowStyle<SimpleLineStyle> implements LineStyle {

    private static final long serialVersionUID = -7035070045694988070L;

    @Contract("null -> null")
    public static SimpleLineStyle convert(Map<String, Object> map) {
        if (map == null || map.isEmpty()) return null;
        SimpleLineStyle sls = new SimpleLineStyle();
        BaseShadowStyle.transform(sls, map);
        sls.width = (Integer) map.get("width");
        sls.type = LineType.ofNullable(map.get("type"));
        return sls;
    }

    private Integer width;
    private LineType type;

    public SimpleLineStyle() {
        super();
    }

    @Override
    public Integer getWidth() {
        return width;
    }

    public void setWidth(Integer width) {
        this.width = width;
    }

    public LineType getType() {
        return type;
    }

    public void setType(LineType type) {
        this.type = type;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof SimpleLineStyle)) return false;
        if (!super.equals(o)) return false;
        SimpleLineStyle that = (SimpleLineStyle) o;
        return Objects.equals(width, that.width) &&
                type == that.type;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), width, type);
    }

    @Override
    protected Map<String, Object> toStringMap() {
        Map<String, Object> map = super.toStringMap();
        map.put("width", getWidth());
        map.put("type", getType());
        return map;
    }
}
