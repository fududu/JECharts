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

package org.aying.echarts.series;

import java.io.Serializable;
import java.util.Objects;

/**
 * 涟漪特效配置。
 *
 * @author Fuchun
 * @since 1.0
 */
public class RippleEffect implements Serializable {

    private static final long serialVersionUID = 7321295347482432047L;

    public static RippleEffect stroke() {
        return new RippleEffect(BrushType.stroke);
    }

    public static RippleEffect fill() {
        return new RippleEffect(BrushType.fill);
    }

    public enum BrushType {
        stroke, fill
    }

    /*动画的时间。*/
    private Integer period;
    /*动画中波纹的最大缩放比例。*/
    private Double scale;
    /*波纹的绘制方式*/
    private BrushType brushType;

    public RippleEffect() {
        super();
    }

    public RippleEffect(BrushType brushType) {
        this.brushType = brushType;
    }

    public RippleEffect(Integer period, Double scale, BrushType brushType) {
        this.period = period;
        this.scale = scale;
        this.brushType = brushType;
    }

    public Integer getPeriod() {
        return period;
    }

    public void setPeriod(Integer period) {
        this.period = period;
    }

    public Double getScale() {
        return scale;
    }

    public void setScale(Double scale) {
        this.scale = scale;
    }

    public BrushType getBrushType() {
        return brushType;
    }

    public void setBrushType(BrushType brushType) {
        this.brushType = brushType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof RippleEffect)) return false;
        RippleEffect that = (RippleEffect) o;
        return Objects.equals(period, that.period) &&
                Objects.equals(scale, that.scale) &&
                brushType == that.brushType;
    }

    @Override
    public int hashCode() {
        return Objects.hash(period, scale, brushType);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder(32)
                .append(getClass()).append("{");
        sb.append("period=").append(period);
        sb.append(", scale=").append(scale);
        sb.append(", brushType=").append(brushType);
        sb.append('}');
        return sb.toString();
    }
}
