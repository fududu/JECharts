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

import org.aying.echarts.base.AnimationEasing;
import org.aying.echarts.base.BaseSymbol;

import java.util.Objects;

/**
 * 『当前项』（checkpoint）的图形样式配置模型。
 *
 * @author Fuchun
 * @since 1.0
 */
public class CheckpointStyle extends BaseSymbol<CheckpointStyle>
        implements Style {

    private static final long serialVersionUID = 3556993314315560392L;

    private String color;
    private Integer borderWidth;
    private String borderColor;
    private Boolean animation;
    private Integer animationDuration;
    private AnimationEasing animationEasing;

    public CheckpointStyle() {
        super();
    }

    @Override
    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    @SuppressWarnings("unchecked")
    public CheckpointStyle color(String color) {
        this.color = color;
        return this;
    }

    public Integer getBorderWidth() {
        return borderWidth;
    }

    public void setBorderWidth(Integer borderWidth) {
        this.borderWidth = borderWidth;
    }

    public String getBorderColor() {
        return borderColor;
    }

    public void setBorderColor(String borderColor) {
        this.borderColor = borderColor;
    }

    public Boolean getAnimation() {
        return animation;
    }

    public void setAnimation(Boolean animation) {
        this.animation = animation;
    }

    public Integer getAnimationDuration() {
        return animationDuration;
    }

    public void setAnimationDuration(Integer animationDuration) {
        this.animationDuration = animationDuration;
    }

    public AnimationEasing getAnimationEasing() {
        return animationEasing;
    }

    public void setAnimationEasing(AnimationEasing animationEasing) {
        this.animationEasing = animationEasing;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CheckpointStyle)) return false;
        if (!super.equals(o)) return false;
        CheckpointStyle that = (CheckpointStyle) o;
        return Objects.equals(color, that.color) &&
                Objects.equals(borderWidth, that.borderWidth) &&
                Objects.equals(borderColor, that.borderColor) &&
                Objects.equals(animation, that.animation) &&
                Objects.equals(animationDuration, that.animationDuration) &&
                animationEasing == that.animationEasing;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), color, borderWidth, borderColor,
                animation, animationDuration, animationEasing);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder(32)
                .append(getClass()).append("{");
        appendToString(sb);
        sb.append(", color='").append(color).append('\'');
        sb.append(", borderWidth=").append(borderWidth);
        sb.append(", borderColor='").append(borderColor).append('\'');
        sb.append(", animation=").append(animation);
        sb.append(", animationDuration=").append(animationDuration);
        sb.append(", animationEasing=").append(animationEasing);
        sb.append('}');
        return sb.toString();
    }
}
