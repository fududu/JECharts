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

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;

/**
 * 极坐标系的角度轴。
 *
 * @author Fuchun
 * @since 1.0
 */
public class AngleAxis extends Axis<AngleAxis> {

    private static final long serialVersionUID = -2549764920044678160L;

    private Integer polarIndex;
    private Integer startAngle;
    private Boolean clockwise;

    public Integer getPolarIndex() {
        return polarIndex;
    }

    public void setPolarIndex(Integer polarIndex) {
        this.polarIndex = polarIndex;
    }

    public Integer getStartAngle() {
        return startAngle;
    }

    public void setStartAngle(Integer startAngle) {
        this.startAngle = startAngle;
    }

    public Boolean getClockwise() {
        return clockwise;
    }

    public void setClockwise(Boolean clockwise) {
        this.clockwise = clockwise;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof AngleAxis)) return false;
        if (!super.equals(o)) return false;
        AngleAxis angleAxis = (AngleAxis) o;
        return Objects.equals(polarIndex, angleAxis.polarIndex) &&
                Objects.equals(startAngle, angleAxis.startAngle) &&
                Objects.equals(clockwise, angleAxis.clockwise);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), polarIndex, startAngle, clockwise);
    }

    public String toString(boolean pretty) {
        Map<String, Object> prev = new LinkedHashMap<>();
        prev.put("polarIndex", String.valueOf(polarIndex));
        prev.put("startAngle", String.valueOf(startAngle));
        prev.put("clockwise", String.valueOf(clockwise));
        return super.toString(prev, null, pretty);
    }

    @Override
    public String toString() {
        return toString(false);
    }
}
