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

import org.aying.echarts.axis.AxisPointer;
import org.aying.echarts.base.Pos;
import org.aying.echarts.base.Trigger;
import org.aying.echarts.base.TriggerOn;

import java.io.Serializable;
import java.time.format.TextStyle;
import java.util.Objects;

/**
 * 提示框组件。
 *
 * @author Fuchun
 * @since 1.0
 */
public class Tooltip implements Serializable {

    private static final long serialVersionUID = 2124173085714755764L;

    /* 是否显示提示框组件，包括提示框浮层和 axisPointer。 */
    private Boolean show;
    /* 是否显示提示框浮层，默认显示。 */
    private Boolean showContent;
    /* 触发类型。 */
    private Trigger trigger;
    /* 提示框触发的条件 */
    private TriggerOn triggerOn;
    /* 是否永远显示提示框内容，默认情况下在移出可触发提示框区域后 一定时间 后隐藏，设置为 true 可以保证一直显示提示框内容。 */
    private Boolean alwaysShowContent;
    /* 浮层显示的延迟，单位为 ms，默认没有延迟，也不建议设置。在 triggerOn 为 'mousemove' 时有效。默认：0 */
    private Integer showDelay;
    /* 浮层隐藏的延迟，单位为 ms，在 alwaysShowContent 为 true 的时候无效。默认：100 */
    private Integer hideDelay;
    /* 鼠标是否可进入提示框浮层中，默认为false，如需详情内交互，如添加链接，按钮，可设置为 true。 */
    private Boolean enterable;
    /* 提示框浮层的位置，默认不设置时位置会跟随鼠标的位置。 */
    private Object position;
    /* 提示框浮层的移动动画过渡时间，单位是 s，设置为 0 的时候会紧跟着鼠标移动。 */
    private Double transitionDuration;
    /* 提示框浮层内容格式器，支持字符串模板和回调函数两种形式。 */
    private Object formatter;
    /* 提示框浮层的背景颜色。默认：rgba(50,50,50,0.7) */
    private String backgroundColor;
    /* 提示框浮层的边框颜色。默认：#333333 */
    private String borderColor;
    /* 提示框浮层的边框宽。默认：0 */
    private Integer borderWidth;
    /* 提示框浮层内边距，单位px，默认各方向内边距为5，接受数组分别设定上右下左边距。 */
    private Object padding;
    /* 提示框浮层的文本样式。 */
    private TextStyle textStyle;
    /* 额外附加到浮层的 css 样式。如下为浮层添加阴影的示例： */
    private String extraCssText;
    /* 坐标轴指示器配置项，在 trigger 为 'axis' 时有效。 */
    private AxisPointer axisPointer;

    /**
     * 设置提示框的绝对位置。
     *
     * @param left 相对于容器左侧的距离（px）
     * @param top 相对于容器顶部的距离（px）
     * @return current Tooltip instance.
     */
    public Tooltip position(int left, int top) {
        this.position = new int[] { left, top };
        return this;
    }

    /**
     * 设置提示框的相对位置。
     *
     * @param left 容器的左侧位置（%）
     * @param top 容器的顶部位置（%）
     * @return current Tooltip instance.
     */
    public Tooltip position(String left, String top) {
        this.position = new String[] { left, top };
        return this;
    }

    public Tooltip position(Pos position) {
        this.position = position;
        return this;
    }

    /**
     * 设置提示框的统一内边距。
     *
     * @param padding 内边距的值。
     * @return current Tooltip instance.
     */
    public Tooltip padding(int padding) {
        this.padding = padding;
        return this;
    }

    /**
     * 设置提示框的上下内边距和左右内边距。
     *
     * @param tb 上下内边距
     * @param lr 左右内边距
     * @return current Tooltip instance.
     */
    public Tooltip padding(int tb, int lr) {
        this.padding = new int[] { tb, lr };
        return this;
    }

    /**
     * 设置提示框的内边距。
     *
     * @param top 上内边距。
     * @param right 右内边距。
     * @param bottom 下内边距。
     * @param left 左内边距。
     * @return current Tooltip instance.
     */
    public Tooltip padding(int top, int right, int bottom, int left) {
        this.padding = new int[]{top, right, bottom, left};
        return this;
    }

    public Boolean getShow() {
        return show;
    }

    public void setShow(Boolean show) {
        this.show = show;
    }

    public Boolean getShowContent() {
        return showContent;
    }

    public void setShowContent(Boolean showContent) {
        this.showContent = showContent;
    }

    public Trigger getTrigger() {
        return trigger;
    }

    public void setTrigger(Trigger trigger) {
        this.trigger = trigger;
    }

    public TriggerOn getTriggerOn() {
        return triggerOn;
    }

    public void setTriggerOn(TriggerOn triggerOn) {
        this.triggerOn = triggerOn;
    }

    public Boolean getAlwaysShowContent() {
        return alwaysShowContent;
    }

    public void setAlwaysShowContent(Boolean alwaysShowContent) {
        this.alwaysShowContent = alwaysShowContent;
    }

    public Integer getShowDelay() {
        return showDelay;
    }

    public void setShowDelay(Integer showDelay) {
        this.showDelay = showDelay;
    }

    public Integer getHideDelay() {
        return hideDelay;
    }

    public void setHideDelay(Integer hideDelay) {
        this.hideDelay = hideDelay;
    }

    public Boolean getEnterable() {
        return enterable;
    }

    public void setEnterable(Boolean enterable) {
        this.enterable = enterable;
    }

    public Object getPosition() {
        return position;
    }

    public void setPosition(Object position) {
        this.position = position;
    }

    public Double getTransitionDuration() {
        return transitionDuration;
    }

    public void setTransitionDuration(Double transitionDuration) {
        this.transitionDuration = transitionDuration;
    }

    public Object getFormatter() {
        return formatter;
    }

    public void setFormatter(Object formatter) {
        this.formatter = formatter;
    }

    public String getBackgroundColor() {
        return backgroundColor;
    }

    public void setBackgroundColor(String backgroundColor) {
        this.backgroundColor = backgroundColor;
    }

    public String getBorderColor() {
        return borderColor;
    }

    public void setBorderColor(String borderColor) {
        this.borderColor = borderColor;
    }

    public Integer getBorderWidth() {
        return borderWidth;
    }

    public void setBorderWidth(Integer borderWidth) {
        this.borderWidth = borderWidth;
    }

    public Object getPadding() {
        return padding;
    }

    public void setPadding(Object padding) {
        this.padding = padding;
    }

    public TextStyle getTextStyle() {
        return textStyle;
    }

    public void setTextStyle(TextStyle textStyle) {
        this.textStyle = textStyle;
    }

    public String getExtraCssText() {
        return extraCssText;
    }

    public void setExtraCssText(String extraCssText) {
        this.extraCssText = extraCssText;
    }

    public AxisPointer getAxisPointer() {
        return axisPointer;
    }

    public void setAxisPointer(AxisPointer axisPointer) {
        this.axisPointer = axisPointer;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Tooltip)) return false;
        Tooltip tooltip = (Tooltip) o;
        return Objects.equals(show, tooltip.show) &&
                Objects.equals(showContent, tooltip.showContent) &&
                trigger == tooltip.trigger &&
                triggerOn == tooltip.triggerOn &&
                Objects.equals(alwaysShowContent, tooltip.alwaysShowContent) &&
                Objects.equals(showDelay, tooltip.showDelay) &&
                Objects.equals(hideDelay, tooltip.hideDelay) &&
                Objects.equals(enterable, tooltip.enterable) &&
                Objects.equals(position, tooltip.position) &&
                Objects.equals(transitionDuration, tooltip.transitionDuration) &&
                Objects.equals(formatter, tooltip.formatter) &&
                Objects.equals(backgroundColor, tooltip.backgroundColor) &&
                Objects.equals(borderColor, tooltip.borderColor) &&
                Objects.equals(borderWidth, tooltip.borderWidth) &&
                Objects.equals(padding, tooltip.padding) &&
                textStyle == tooltip.textStyle &&
                Objects.equals(extraCssText, tooltip.extraCssText) &&
                Objects.equals(axisPointer, tooltip.axisPointer);
    }

    @Override
    public int hashCode() {
        return Objects.hash(show, showContent, trigger, triggerOn, alwaysShowContent, showDelay,
                hideDelay, enterable, position, transitionDuration, formatter, backgroundColor,
                borderColor, borderWidth, padding, textStyle, extraCssText, axisPointer);
    }
}
