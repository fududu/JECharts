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

package org.aying.echarts.base;

import java.io.Serializable;
import java.util.Objects;

/**
 * @author Fuchun
 * @since 1.0
 */
public abstract class BaseAnimation<A extends BaseAnimation<A>>
        implements Animation, Serializable {

    private static final long serialVersionUID = 1L;

    /* 是否开启动画，默认开启。 */
    private Boolean animation;
    /* 是否开启动画的阈值，当单个系列显示的图形数量大于这个阈值时会关闭动画。默认：2000 */
    private Integer animationThreshold;
    /* 初始动画的时长。默认：1000 */
    private Integer animationDuration;
    /* 初始动画的缓动效果。 */
    private AnimationEasing animationEasing;
    /* 初始动画的延迟，支持回调函数，可以通过每个数据返回不同的 delay 时间实现更戏剧的初始动画效果。默认：0 */
    private Object animationDelay;
    /* 数据更新动画的时长。默认：300 */
    private Integer animationDurationUpdate;
    /* 数据更新动画的缓动效果。默认：cubicOut */
    private AnimationEasing animationEasingUpdate;
    /* 数据更新动画的延迟，支持回调函数，可以通过每个数据返回不同的 delay 时间实现更戏剧的更新动画效果。默认：0 */
    private Object animationDelayUpdate;

    protected BaseAnimation() {
        super();
    }

    @SuppressWarnings("unchecked")
    protected A me() {
        return (A) this;
    }

    public A closeAnimation() {
        this.animation = Boolean.FALSE;
        return me();
    }

    public A threshold(int threshold) {
        this.animationThreshold = threshold;
        return me();
    }

    public A duration(int duration) {
        this.animationDuration = duration;
        return me();
    }

    public A easing(AnimationEasing easing) {
        this.animationEasing = easing;
        return me();
    }

    @Override
    public Boolean getAnimation() {
        return animation;
    }

    public void setAnimation(Boolean animation) {
        this.animation = animation;
    }

    @Override
    public Integer getAnimationThreshold() {
        return animationThreshold;
    }

    public void setAnimationThreshold(Integer animationThreshold) {
        this.animationThreshold = animationThreshold;
    }

    @Override
    public Integer getAnimationDuration() {
        return animationDuration;
    }

    public void setAnimationDuration(Integer animationDuration) {
        this.animationDuration = animationDuration;
    }

    @Override
    public AnimationEasing getAnimationEasing() {
        return animationEasing;
    }

    public void setAnimationEasing(AnimationEasing animationEasing) {
        this.animationEasing = animationEasing;
    }

    @Override
    public Object getAnimationDelay() {
        return animationDelay;
    }

    public void setAnimationDelay(Object animationDelay) {
        this.animationDelay = animationDelay;
    }

    @Override
    public Integer getAnimationDurationUpdate() {
        return animationDurationUpdate;
    }

    public void setAnimationDurationUpdate(Integer animationDurationUpdate) {
        this.animationDurationUpdate = animationDurationUpdate;
    }

    @Override
    public AnimationEasing getAnimationEasingUpdate() {
        return animationEasingUpdate;
    }

    public void setAnimationEasingUpdate(AnimationEasing animationEasingUpdate) {
        this.animationEasingUpdate = animationEasingUpdate;
    }

    @Override
    public Object getAnimationDelayUpdate() {
        return animationDelayUpdate;
    }

    public void setAnimationDelayUpdate(Object animationDelayUpdate) {
        this.animationDelayUpdate = animationDelayUpdate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof BaseAnimation)) return false;
        BaseAnimation<?> that = (BaseAnimation<?>) o;
        return Objects.equals(animation, that.animation) &&
                Objects.equals(animationThreshold, that.animationThreshold) &&
                Objects.equals(animationDuration, that.animationDuration) &&
                animationEasing == that.animationEasing &&
                Objects.equals(animationDelay, that.animationDelay) &&
                Objects.equals(animationDurationUpdate, that.animationDurationUpdate) &&
                animationEasingUpdate == that.animationEasingUpdate &&
                Objects.equals(animationDelayUpdate, that.animationDelayUpdate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(animation, animationThreshold, animationDuration, animationEasing,
                animationDelay, animationDurationUpdate, animationEasingUpdate, animationDelayUpdate);
    }

    protected void appendAnimation(StringBuilder builder) {
        builder.append(", ");
        appendToString(builder);
    }

    protected void appendToString(StringBuilder builder) {
        builder.append("animation=").append(animation);
        builder.append(", animationThreshold=").append(animationThreshold);
        builder.append(", animationDuration=").append(animationDuration);
        builder.append(", animationEasing=").append(animationEasing);
        builder.append(", animationDelay=").append(animationDelay);
        builder.append(", animationDurationUpdate=").append(animationDurationUpdate);
        builder.append(", animationEasingUpdate=").append(animationEasingUpdate);
        builder.append(", animationDelayUpdate=").append(animationDelayUpdate);
//        builder.append(", oseAnimation=").append(closeAnimation());
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder(32)
                .append(getClass()).append("{");
        appendToString(sb);
        sb.append('}');
        return sb.toString();
    }
}
