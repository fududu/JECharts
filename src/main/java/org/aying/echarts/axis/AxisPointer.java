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

import org.aying.echarts.style.LineStyle;
import org.aying.echarts.style.ShadowStyle;

import java.io.Serializable;
import java.util.Objects;

/**
 * 坐标轴指示器配置项，在 trigger 为 'axis' 时有效。
 *
 * @author Fuchun
 * @since 1.0
 */
public class AxisPointer implements Serializable {

    private static final long serialVersionUID = 3909748157637044400L;

    public enum APType {
        /** 直线指示器 */
        line,

        /** 十字准星指示器 */
        cross,

        /** 阴影指示器 */
        shadow
    }

    private APType type;
    /* 指示器的坐标轴。可以是 'x', 'y', 'radius', 'angle'。默认取类目轴或者时间轴。 */
    private AxisType axis;
    /* 是否开启动画，默认开启。 */
    private Boolean animation;
    /* 是否开启动画的阈值，当单个系列显示的图形数量大于这个阈值时会关闭动画。默认：2000 */
    private Integer animationThreshold;
    /* 初始动画的时长。默认：1000 */
    private Integer animationDuration;
    /* 初始动画的缓动效果。 */
    private String animationEasing;
    /* 初始动画的延迟，支持回调函数，可以通过每个数据返回不同的 delay 时间实现更戏剧的初始动画效果。默认：0 */
    private Object animationDelay;
    /* 数据更新动画的时长。默认：300 */
    private Integer animationDurationUpdate;
    /* 数据更新动画的缓动效果。默认：cubicOut */
    private String animationEasingUpdate;
    /* 数据更新动画的延迟，支持回调函数，可以通过每个数据返回不同的 delay 时间实现更戏剧的更新动画效果。默认：0 */
    private Integer animationDelayUpdate;
    /* 直线指示器线条样式。axisPointer.type 为 'line' 时有效。 */
    private LineStyle lineStyle;
    /* 十字准星指示器线条样式。axisPointer.type 为 'cross' 时有效。 */
    private LineStyle crossStyle;
    /* 阴影指示器样式。axisPointer.type 为 'shadow' 时有效。 */
    private ShadowStyle shadowStyle;

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

    public Boolean getAnimation() {
        return animation;
    }

    public void setAnimation(Boolean animation) {
        this.animation = animation;
    }

    public Integer getAnimationThreshold() {
        return animationThreshold;
    }

    public void setAnimationThreshold(Integer animationThreshold) {
        this.animationThreshold = animationThreshold;
    }

    public Integer getAnimationDuration() {
        return animationDuration;
    }

    public void setAnimationDuration(Integer animationDuration) {
        this.animationDuration = animationDuration;
    }

    public String getAnimationEasing() {
        return animationEasing;
    }

    public void setAnimationEasing(String animationEasing) {
        this.animationEasing = animationEasing;
    }

    public Object getAnimationDelay() {
        return animationDelay;
    }

    public void setAnimationDelay(Object animationDelay) {
        this.animationDelay = animationDelay;
    }

    public Integer getAnimationDurationUpdate() {
        return animationDurationUpdate;
    }

    public void setAnimationDurationUpdate(Integer animationDurationUpdate) {
        this.animationDurationUpdate = animationDurationUpdate;
    }

    public String getAnimationEasingUpdate() {
        return animationEasingUpdate;
    }

    public void setAnimationEasingUpdate(String animationEasingUpdate) {
        this.animationEasingUpdate = animationEasingUpdate;
    }

    public Integer getAnimationDelayUpdate() {
        return animationDelayUpdate;
    }

    public void setAnimationDelayUpdate(Integer animationDelayUpdate) {
        this.animationDelayUpdate = animationDelayUpdate;
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
        AxisPointer that = (AxisPointer) o;
        return type == that.type &&
                Objects.equals(axis, that.axis) &&
                Objects.equals(animation, that.animation) &&
                Objects.equals(animationThreshold, that.animationThreshold) &&
                Objects.equals(animationDuration, that.animationDuration) &&
                Objects.equals(animationEasing, that.animationEasing) &&
                Objects.equals(animationDelay, that.animationDelay) &&
                Objects.equals(animationDurationUpdate, that.animationDurationUpdate) &&
                Objects.equals(animationEasingUpdate, that.animationEasingUpdate) &&
                Objects.equals(animationDelayUpdate, that.animationDelayUpdate) &&
                Objects.equals(lineStyle, that.lineStyle) &&
                Objects.equals(crossStyle, that.crossStyle) &&
                Objects.equals(shadowStyle, that.shadowStyle);
    }

    @Override
    public int hashCode() {
        return Objects.hash(type, axis, animation, animationThreshold, animationDuration,
                animationEasing, animationDelay, animationDurationUpdate, animationEasingUpdate,
                animationDelayUpdate, lineStyle, crossStyle, shadowStyle);
    }
}
