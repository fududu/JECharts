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
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import org.aying.echarts.axis.Axis;
import org.aying.echarts.axis.AxisType;
import org.aying.echarts.base.CanvasZ;
import org.aying.echarts.base.SimpleCanvasZ;
import org.aying.echarts.style.TextStyle;
import org.aying.echarts.util.Validators;
import org.jetbrains.annotations.Contract;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.*;

/**
 * 雷达图坐标系组件，只适用于雷达图。
 *
 * @author Fuchun
 * @since 1.0
 */
@JsonIgnoreProperties(ignoreUnknown = true, value = {
        "type", "nameLocation", "nameTextStyle", "nameRotate", "inverse",
        "boundaryGap", "min", "max", "minInterval", "interval"
})
public class Radar extends Axis<Radar> implements CanvasZ<Radar> {

    public static final String KEY_INDICATOR = "indicator";

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

    /**
     * 雷达图的指示器配置，用来指定雷达图中的多个变量（维度）。
     */
    public static class Indicator implements Serializable {

        private static final long serialVersionUID = 1L;

        public static Indicator withMax(String name, Integer max) {
            return new Indicator(name, max, null);
        }

        public static Indicator withMin(String name, Integer min) {
            return new Indicator(name, null, min);
        }

        @JsonCreator
        public static Indicator of(
                @JsonProperty(value = "name", required = false) String name,
                @JsonProperty(value = "max", required = false) Integer max,
                @JsonProperty(value = "min", required = false) Integer min) {
            return new Indicator(name, max, min);
        }

        /* 指示器名称。 */
        private final String name;
        /* 指示器的最大值 */
        private final Integer max;
        /* 指示器的最小值，可选，默认为 0。 */
        private final Integer min;

        protected Indicator(String name, Integer max, Integer min) {
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

    /**
     * 获取一个新的多边形雷达图配置。
     */
    public static Radar polygon() {
        return new Radar();
    }

    /**
     * 获取一个新的圆形雷达图配置。
     */
    public static Radar circle() {
        return new Radar(Shape.circle);
    }

    private final transient SimpleCanvasZ canvasZ;

    private Object[] center;
    private Object radius;
    /* 坐标系起始角度，也就是第一个指示器轴的角度。 */
    private Integer startAngle;
    /* 雷达图每个指示器名称的配置项。*/
    private RadarName radarName;
    private Shape shape;
    private List<Indicator> indicators;

    public Radar() {
        this(Shape.polygon);
    }

    public Radar(Shape shape) {
        super();
        this.shape = shape;
        canvasZ = new SimpleCanvasZ();
    }

    public Radar name(RadarName radarName) {
        setName(radarName);
        return this;
    }

    protected RadarName getRadarName() {
        if (radarName == null) {
            radarName = new RadarName();
        }
        return radarName;
    }

    @Override
    public Integer getZlevel() {
        return canvasZ.getZlevel();
    }

    @Override
    public void setZlevel(Integer zlevel) {
        canvasZ.setZlevel(zlevel);
    }

    @Override
    public Integer getZ() {
        return canvasZ.getZ();
    }

    @Override
    public void setZ(Integer z) {
        canvasZ.setZ(z);
    }

    @Override
    public Radar zLevel(int zLevel) {
        canvasZ.zLevel(zLevel);
        return this;
    }

    @Override
    public Radar z(int z) {
        canvasZ.z(z);
        return this;
    }

    /**
     * {@code Radar} 不支持{@code type} 属性，调用该方法将不起任何作用，同时也不会错误与异常。
     */
    @Override
    public Radar typeOf(AxisType type) {
        // Not support type property
        return this;
    }

    /**
     * {@code Radar} 不支持{@code nameLocation} 属性，调用该方法将不起任何作用，同时也不会错误与异常。
     */
    @Override
    public Radar nameInMiddle() {
        // Not support nameLocation property
        return this;
    }

    /**
     * {@code Radar} 不支持{@code nameLocation} 属性，调用该方法将不起任何作用，同时也不会错误与异常。
     */
    @Override
    public Radar nameAtTheEnd() {
        // Not support nameLocation property
        return this;
    }

    @Override
    public Radar nameTextStyle(TextStyle textStyle) {
        Objects.requireNonNull(textStyle, "radar.name.textStyle");
        getRadarName().setTextStyle(textStyle);
        return this;
    }

    /**
     * 配置指示器名称显示的格式器。
     *
     * @param name 指示器名称显示的格式器。
     * @return 当前雷达图模型。
     */
    @Override
    @Contract("null -> fail")
    public Radar named(String name) {
        Objects.requireNonNull(name, "radar.name.formatter");
        getRadarName().setFormatter(name);
        return this;
    }

    /**
     * 配置雷达图指示器名称。
     *
     * @param radarName 雷达图指示器名称配置。
     * @return 当前雷达图模型。
     */
    @Contract("null -> fail")
    public Radar named(RadarName radarName) {
        Objects.requireNonNull(radarName, "radar.name");
        this.radarName = radarName;
        return this;
    }

    /**
     * {@code Radar} 不支持{@code nameRotate} 属性，调用该方法将不起任何作用，同时也不会错误与异常。
     */
    @Override
    public Radar nameRotate(int nameRotate) {
        // Not support nameRotate property
        return this;
    }

    /**
     * {@code Radar} 不支持{@code min} 属性，调用该方法将不起任何作用，同时也不会错误与异常。
     */
    @Override
    public Radar min(Object min) {
        // Not support min property
        return this;
    }

    /**
     * {@code Radar} 不支持{@code max} 属性，调用该方法将不起任何作用，同时也不会错误与异常。
     */
    @Override
    public Radar max(Object max) {
        // Not support max property
        return this;
    }

    /**
     * {@code Radar} 不支持{@code minInterval} 属性，调用该方法将不起任何作用，同时也不会错误与异常。
     */
    @Override
    public Radar minInterval(int minInterval) {
        // Not support minInterval property
        return this;
    }

    /**
     * {@code Radar} 不支持{@code interval} 属性，调用该方法将不起任何作用，同时也不会错误与异常。
     */
    @Override
    public Radar interval(int interval) {
        // Not support interval property
        return this;
    }

    /**
     * {@code Radar} 不支持{@code inverse} 属性，调用该方法将不起任何作用，同时也不会错误与异常。
     */
    @Override
    public Radar inverse() {
        return this;
    }

    /**
     * {@code Radar} 不支持{@code boundaryGap} 属性，调用该方法将不起任何作用，同时也不会错误与异常。
     */
    @Override
    public Radar noBoundaryGap() {
        // Not support boundaryGap property
        return this;
    }

    /**
     * {@code Radar} 不支持{@code boundaryGap} 属性，调用该方法将不起任何作用，同时也不会错误与异常。
     */
    @Override
    public Radar boundaryGap(Object min, Object max) {
        return this;
    }

    /**
     * 设置坐标系起始角度，也就是第一个指示器轴的角度。
     *
     * @param startAngle 坐标系起始角度，也就是第一个指示器轴的角度。
     * @return 当前雷达图模型。
     */
    public Radar startAngle(int startAngle) {
        this.startAngle = startAngle;
        return this;
    }

    /**
     * 设置雷达图的中心（圆心）坐标。
     * <p />
     * 支持设置成百分比，设置成百分比时第一项是相对于容器宽度，第二项是相对于容器高度。
     * <pre>{@code Example:
     * // 设置成绝对的像素值
     * radar.center(400, 300)
     * // 设置成相对的百分比
     * radar.center("50%", "50%")
     * }</pre>
     *
     * @param x 横坐标
     * @param y 纵坐标
     * @return 当前雷达图模型。
     */
    public Radar center(Object x, Object y) {
        this.center = new Object[]{
                Validators.checkNumber(x, "radar.center.x"),
                Validators.checkNumber(y, "radar.center.y")
        };
        return this;
    }

    /**
     * 设置雷达图的指示器配置。用来指定雷达图中的多个变量（维度）。
     * <pre>{@code Examples:
     * radar.indicators(
     *     Radar.Indicator.withMax("销售（sales）", 6500),
     *     Radar.Indicator.withMax("管理（Administration）", 16000),
     *     Radar.Indicator.withMax("信息技术（Information Techology）", 30000),
     *     Radar.Indicator.withMax("客服（Customer Support）", 38000),
     *     Radar.Indicator.withMax("研发（Development）", 52000),
     *     Radar.Indicator.withMax("市场（Marketing）", 25000)
     * );
     * }</pre>
     *
     * @param indicators 一组雷达图的指示器配置。
     * @return 当前雷达图模型。
     */
    public Radar indicators(Indicator... indicators) {
        if (indicators == null || indicators.length == 0) {
            return this;
        }
        if (this.indicators == null) {
            this.indicators = new ArrayList<>(indicators.length + 6);
        }
        Collections.addAll(this.indicators, indicators);
        return this;
    }

    /**
     * 设置雷达图的半径。
     *
     * @param radius 雷达图的半径。
     * @return 当前雷达图模型。
     */
    public Radar radius(int radius) {
        this.radius = radius;
        return this;
    }

    /**
     * 设置雷达图的半径（百分比）。
     *
     * @param percent 雷达图的半径（百分比）。
     * @return 当前雷达图模型。
     */
    public Radar radius(double percent) {
        BigDecimal decimal = BigDecimal.valueOf(percent).setScale(0, RoundingMode.HALF_UP);
        this.radius = String.format("%s%%", decimal);
        return this;
    }

    /**
     * 设置雷达图的半径。
     *
     * @param inner 内半径（数值或百分比字符串）。
     * @param outer 外半径（数值或百分比字符串）。
     * @return 当前雷达图模型。
     */
    public Radar radius(Object inner, Object outer) {
        this.radius = new Object[]{
                Validators.checkNumber(inner, "radar.radius[0]"),
                Validators.checkNumber(outer, "radar.radius[1]")
        };
        return this;
    }

    @Override
    public Object getName() {
        return radarName;
    }

    @Override
    @JsonDeserialize(as = RadarName.class)
    public void setName(Object name) {
        this.radarName = (RadarName) name;
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
        if (radius == null) return;
        if (radius instanceof Number) {
            this.radius = ((Number) radius).intValue();
        } else if (radius instanceof String) {
            this.radius = Validators.checkPercent((String) radius);
        } else if (radius instanceof Object[]) {
            this.radius = radius;
        } else if (radius instanceof List) {
            @SuppressWarnings("unchecked")
            List<Object> list = (List<Object>) radius;
            this.radius = list.toArray();
        } else {
            throw new IllegalArgumentException(String.format(
                    "radar.radius is not support `%s` type", radius.getClass()));
        }
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

    @JsonProperty(value = KEY_INDICATOR, required = false)
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
        return Objects.equals(canvasZ, radar.canvasZ) &&
                Arrays.equals(center, radar.center) &&
                Objects.equals(radius, radar.radius) &&
                Objects.equals(startAngle, radar.startAngle) &&
                shape == radar.shape &&
                Objects.equals(indicators, radar.indicators);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), canvasZ, center, radius, startAngle, shape, indicators);
    }

    public String toString(boolean pretty) {
        Map<String, Object> prev = new LinkedHashMap<>();
        prev.put("zlevel", String.valueOf(canvasZ.getZlevel()));
        prev.put("z", String.valueOf(canvasZ.getZ()));
        prev.put("center", Arrays.toString(getCenter()));
        if (radius != null) {
            if (radius.getClass().isArray()) {
                prev.put("radius", Arrays.toString((Object[]) radius));
            } else {
                prev.put("radius", String.valueOf(radius));
            }
        } else {
            prev.put("radius", "null");
        }

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
