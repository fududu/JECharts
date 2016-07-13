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

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * 极坐标系的半径轴。
 *
 * @author Fuchun
 * @since 1.0
 */
public class RadiusAxis extends Axis<RadiusAxis> {

    private static final long serialVersionUID = -8090869052014707372L;
    private Integer polarIndex;

    public Integer getPolarIndex() {
        return polarIndex;
    }

    public void setPolarIndex(Integer polarIndex) {
        this.polarIndex = polarIndex;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof RadiusAxis)) return false;
        if (!super.equals(o)) return false;
        RadiusAxis that = (RadiusAxis) o;
        return Objects.equals(polarIndex, that.polarIndex);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), polarIndex);
    }

    public String toString(boolean pretty) {
        Map<String, Object> prev = new HashMap<>();
        prev.put("polarIndex", getPolarIndex());
        return super.toString(prev, null, pretty);
    }

    @Override
    public String toString() {
        return toString(false);
    }
}
