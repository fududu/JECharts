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

import java.util.Objects;

/**
 * @author Fuchun
 * @since 1.0
 */
public class SimpleAreaShapeStyle extends SimpleShapeStyle implements AreaShapeStyle {

    private static final long serialVersionUID = -6066880755877122935L;

    private Object areaColor;

    public SimpleAreaShapeStyle() {
        super();
    }

    public SimpleAreaShapeStyle areaColor(String areaColor) {
        this.areaColor = areaColor;
        return this;
    }

    @Override
    public Object getAreaColor() {
        return areaColor;
    }

    public void setAreaColor(Object areaColor) {
        this.areaColor = areaColor;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof SimpleAreaShapeStyle)) return false;
        if (!super.equals(o)) return false;
        SimpleAreaShapeStyle that = (SimpleAreaShapeStyle) o;
        return Objects.equals(areaColor, that.areaColor);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), areaColor);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder(32)
                .append(getClass()).append("{");
        sb.append("areaColor=").append(areaColor);
        sb.append("} ").append(super.toString());
        return sb.toString();
    }
}
