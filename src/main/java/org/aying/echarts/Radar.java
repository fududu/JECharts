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

import com.alibaba.fastjson.annotation.JSONCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.aying.echarts.axis.Axis;
import org.aying.echarts.axis.AxisType;

import java.io.Serializable;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/**
 * 雷达图坐标系组件，只适用于雷达图。
 *
 * @author Fuchun
 * @since 1.0
 */
@JsonIgnoreProperties(ignoreUnknown = true, value = {
        "type", "nameLocation", "nameTextStyle", "nameRotate", "nameTruncateLength", "nameTruncateEllipsis",
        "inverse", "boundaryGap", "min", "max", "minInterval", "interval"
})
public class Radar extends Axis<Radar> {

    private static final long serialVersionUID = -2805439631327081933L;

    /**
     * 雷达图绘制类型枚举。
     */
    public enum Shape {
        /** 多边形（默认） */
        polygon,
        /** 圆形 */
        circle
    }

    public static class Indicator implements Serializable {

        private static final long serialVersionUID = 1L;

        /* 指示器名称。 */
        private final String name;
        /* 指示器的最大值 */
        private final Integer max;
        /* 指示器的最小值，可选，默认为 0。 */
        private final Integer min;

        @JSONCreator
        public Indicator(
                @JsonProperty String name,
                @JsonProperty(required = false) Integer max,
                @JsonProperty(required = false) Integer min) {
            this.name = name;
            this.max = max;
            this.min = min;
        }

        public String getName() {
            return name;
        }

        public Integer getMax() {
            return max;
        }

        public Integer getMin() {
            return min;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof Indicator)) return false;
            Indicator indicator = (Indicator) o;
            return Objects.equals(name, indicator.name) &&
                    Objects.equals(max, indicator.max) &&
                    Objects.equals(min, indicator.min);
        }

        @Override
        public int hashCode() {
            return Objects.hash(name, max, min);
        }

        @Override
        public String toString() {
            return String.format("org.aying.echarts.Radar.Indicator{name='%s', max=%s, min=%s}",
                    name, String.valueOf(max), String.valueOf(min));
        }
    }

    private Integer zlevel;
    private Integer z;
    private Object[] center;
    private Object radius;
    /* 坐标系起始角度，也就是第一个指示器轴的角度。 */
    private Integer startAngle;
    private Shape shape;
    private List<Indicator> indicators;

    public Radar() {
        super();
    }

    private Radar(AxisType type) {
        super(type);
    }

    public Radar name(RadarName radarName) {
        setName(radarName);
        return this;
    }

    public Integer getZlevel() {
        return zlevel;
    }

    public void setZlevel(Integer zlevel) {
        this.zlevel = zlevel;
    }

    public Integer getZ() {
        return z;
    }

    public void setZ(Integer z) {
        this.z = z;
    }

    public Object[] getCenter() {
        return center;
    }

    public void setCenter(Object[] center) {
        this.center = center;
    }

    public Object getRadius() {
        return radius;
    }

    public void setRadius(Object radius) {
        this.radius = radius;
    }

    public Integer getStartAngle() {
        return startAngle;
    }

    public void setStartAngle(Integer startAngle) {
        this.startAngle = startAngle;
    }

    public Shape getShape() {
        return shape;
    }

    public void setShape(Shape shape) {
        this.shape = shape;
    }

    public List<Indicator> getIndicators() {
        return indicators;
    }

    public void setIndicators(List<Indicator> indicators) {
        this.indicators = indicators;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Radar)) return false;
        if (!super.equals(o)) return false;
        Radar radar = (Radar) o;
        return Objects.equals(zlevel, radar.zlevel) &&
                Objects.equals(z, radar.z) &&
                Arrays.equals(center, radar.center) &&
                Objects.equals(radius, radar.radius) &&
                Objects.equals(startAngle, radar.startAngle) &&
                shape == radar.shape &&
                Objects.equals(indicators, radar.indicators);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), zlevel, z, center, radius, startAngle, shape, indicators);
    }

    public String toString(boolean pretty) {
        Map<String, Object> prev = new LinkedHashMap<>();
        prev.put("zlevel", String.valueOf(zlevel));
        prev.put("z", String.valueOf(z));
        prev.put("radius", String.valueOf(radius));
        prev.put("startAngle", String.valueOf(startAngle));
        prev.put("shape", String.valueOf(shape));
        Map<String, Object> last = new HashMap<>(1);
        last.put("indicators", indicators);
        return super.toString(prev, last, pretty);
    }

    @Override
    public String toString() {
        return toString(false);
    }
}
