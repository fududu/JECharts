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

import org.aying.echarts.base.BaseAnimation;
import org.aying.echarts.style.LineStyle;
import org.aying.echarts.style.ShadowStyle;
import org.aying.echarts.style.SimpleLineStyle;
import org.aying.echarts.style.SimpleShadowStyle;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.Nullable;

import java.io.Serializable;
import java.util.Map;
import java.util.Objects;

/**
 * 坐标轴指示器配置项，在{@code trigger} 为{@link org.aying.echarts.base.Trigger#axis axis} 时有效。
 *
 * @author Fuchun
 * @since 1.0
 */
public class AxisPointer extends BaseAnimation<AxisPointer> implements Serializable {

    private static final long serialVersionUID = 3909748157637044400L;

    public enum APType {
        /** 直线指示器 */
        line,

        /** 十字准星指示器 */
        cross,

        /** 阴影指示器 */
        shadow;

        @Nullable
        public static APType ofNullable(Object v) {
            return of(v, null);
        }

        @Contract("_, !null -> !null")
        public static APType of(Object v, APType def) {
            if (v == null) return def;
            if (v instanceof APType) {
                return (APType) v;
            }
            String n = ((String) v).trim().toLowerCase();
            for (APType type : values()) {
                if (type.name().equals(n)) {
                    return type;
                }
            }
            return def;
        }
    }

    public static AxisPointer line() {
        return new AxisPointer(APType.line);
    }

    public static AxisPointer cross() {
        return new AxisPointer(APType.cross);
    }

    public static AxisPointer shadow() {
        return new AxisPointer(APType.shadow);
    }

    @SuppressWarnings("unchecked")
    public static AxisPointer convert(Map<String, Object> map) {
        if (map == null || map.isEmpty()) return null;
        Object oType = map.get("type");
        APType type = APType.ofNullable(oType);
        if (oType != null && type == null) {
            throw new IllegalArgumentException("Unsupported axisPointer.type (" + oType + ")");
        }
        AxisPointer ap = new AxisPointer(type);
        ap.axis = AxisType.ofNullable(map.get("axis"));
        BaseAnimation.transform(ap, map);
        Object oLineStyle = map.get("lineStyle");
        Object oCrossStyle = map.get("crossStyle");
        Object oShadowStyle = map.get("shadowStyle");
        if (oLineStyle != null && oLineStyle instanceof Map) {
            Map<String, Object> lsMap = (Map<String, Object>) oLineStyle;
            ap.lineStyle = SimpleLineStyle.convert(lsMap);
        }
        if (oCrossStyle != null && oCrossStyle instanceof Map) {
            Map<String, Object> csMap = (Map<String, Object>) oCrossStyle;
            ap.crossStyle = SimpleLineStyle.convert(csMap);
        }
        if (oShadowStyle != null && oShadowStyle instanceof Map) {
            Map<String, Object> ssMap = (Map<String, Object>) oShadowStyle;
            ap.shadowStyle = SimpleShadowStyle.convert(ssMap);
        }
        return ap;
    }

    private APType type;
    /* 指示器的坐标轴。可以是 'x', 'y', 'radius', 'angle'。默认取类目轴或者时间轴。 */
    private AxisType axis;
    /* 直线指示器线条样式。axisPointer.type 为 'line' 时有效。 */
    private LineStyle lineStyle;
    /* 十字准星指示器线条样式。axisPointer.type 为 'cross' 时有效。 */
    private LineStyle crossStyle;
    /* 阴影指示器样式。axisPointer.type 为 'shadow' 时有效。 */
    private ShadowStyle shadowStyle;

    public AxisPointer() {
        super();
    }

    public AxisPointer(APType type) {
        super();
        this.type = type;
    }

    public APType getType() {
        return type;
    }

    public void setType(APType type) {
        this.type = type;
    }

    public AxisType getAxis() {
        return axis;
    }

    public void setAxis(AxisType axis) {
        this.axis = axis;
    }

    public LineStyle getLineStyle() {
        return lineStyle;
    }

    public void setLineStyle(LineStyle lineStyle) {
        this.lineStyle = lineStyle;
    }

    public LineStyle getCrossStyle() {
        return crossStyle;
    }

    public void setCrossStyle(LineStyle crossStyle) {
        this.crossStyle = crossStyle;
    }

    public ShadowStyle getShadowStyle() {
        return shadowStyle;
    }

    public void setShadowStyle(ShadowStyle shadowStyle) {
        this.shadowStyle = shadowStyle;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof AxisPointer)) return false;
        if (!super.equals(o)) return false;
        AxisPointer that = (AxisPointer) o;
        return type == that.type &&
                axis == that.axis &&
                Objects.equals(lineStyle, that.lineStyle) &&
                Objects.equals(crossStyle, that.crossStyle) &&
                Objects.equals(shadowStyle, that.shadowStyle);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), type, axis, lineStyle, crossStyle, shadowStyle);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder(32)
                .append(getClass()).append("{");
        sb.append("type=").append(type);
        sb.append(", axis=").append(axis);
        appendAnimation(sb);
        sb.append(", lineStyle=").append(lineStyle);
        sb.append(", crossStyle=").append(crossStyle);
        sb.append(", shadowStyle=").append(shadowStyle);
        sb.append('}');
        return sb.toString();
    }
}
