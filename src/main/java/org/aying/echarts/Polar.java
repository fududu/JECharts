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

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Objects;

/**
 * 极坐标系，可以用于散点图和折线图。每个极坐标系拥有一个角度轴和一个半径轴。
 *
 * @author Fuchun
 * @since 1.0
 */
public class Polar implements Serializable {

    private static final long serialVersionUID = 5412105993067282426L;

    private Integer zLevel;
    private Integer z;
    private Object[] center;
    private Object[] radius;

    @JsonProperty(value = "zlevel", required = false)
    public Integer getzLevel() {
        return zLevel;
    }

    public void setzLevel(Integer zLevel) {
        this.zLevel = zLevel;
    }

    @JsonProperty(required = false)
    public Integer getZ() {
        return z;
    }

    public void setZ(Integer z) {
        this.z = z;
    }

    @JsonProperty(required = false)
    public Object[] getCenter() {
        return center;
    }

    public void setCenter(Object[] center) {
        this.center = center;
    }

    @JsonProperty(required = false)
    public Object[] getRadius() {
        return radius;
    }

    public void setRadius(Object[] radius) {
        this.radius = radius;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Polar)) return false;
        Polar polar = (Polar) o;
        return Objects.equals(zLevel, polar.zLevel) &&
                Objects.equals(z, polar.z) &&
                Arrays.equals(center, polar.center) &&
                Arrays.equals(radius, polar.radius);
    }

    @Override
    public int hashCode() {
        return Objects.hash(zLevel, z, center, radius);
    }

    @Override
    public String toString() {
        return String.format("org.aying.echarts.Polar{zLevel=%d, z=%d, center=%s, radius=%s}",
                zLevel, z, Arrays.toString(center), Arrays.toString(radius));
    }
}
