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
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import org.aying.echarts.base.Align;
import org.aying.echarts.base.Baseline;
import org.aying.echarts.base.LinkTarget;
import org.aying.echarts.style.DefaultTextStyle;
import org.aying.echarts.style.TextStyle;

import java.io.Serializable;
import java.util.Objects;

/**
 * ECharts 配置选项基础属性。
 *
 * @author Fuchun
 * @since 1.0
 */
public abstract class BaseProp<T> implements Serializable {

    private static final long serialVersionUID = 1L;

    private Boolean show;
    private String text;
    private String link;
    private LinkTarget target;
    private TextStyle textStyle;
    private Align textAlign;
    private Baseline textBaseline;
    /* 副标题。 */
    private String subText;
    private String subLink;
    private LinkTarget subTarget;
    private TextStyle subTextStyle;
    private Object padding;
    /* 主副标题之间的间距。 */
    private Integer itemGap;
    /* Canvas 分层 */
    private Integer zLevel;
    /* 图形的前后顺序。 */
    private Integer z;

    private Object left;
    private Object right;
    private Object top;
    private Object bottom;

    private String backgroundColor;
    private String borderColor;
    private Integer borderWidth;
    private Integer shadowBlur;
    private String shadowColor;
    private Integer shadowOffsetX;
    private Integer shadowOffsetY;

    protected BaseProp() {
        super();
    }

    @SuppressWarnings("unchecked")
    public T left(Align align) {
        this.left = align;
        return (T) this;
    }

    @SuppressWarnings("unchecked")
    public T left(String left) {
        this.left = left;
        return (T) this;
    }

    @SuppressWarnings("unchecked")
    public T left(int left) {
        this.left = left;
        return (T) this;
    }

    @SuppressWarnings("unchecked")
    public T right(String right) {
        this.right = right;
        return (T) this;
    }

    @SuppressWarnings("unchecked")
    public T right(int right) {
        this.right = right;
        return (T) this;
    }

    @SuppressWarnings("unchecked")
    public T top(Baseline top) {
        this.top = top;
        return (T) this;
    }

    @SuppressWarnings("unchecked")
    public T top(String top) {
        this.top = top;
        return (T) this;
    }

    @SuppressWarnings("unchecked")
    public T top(int top) {
        this.top = top;
        return (T) this;
    }

    @SuppressWarnings("unchecked")
    public T bottom(String bottom) {
        this.bottom = bottom;
        return (T) this;
    }

    @SuppressWarnings("unchecked")
    public T bottom(int bottom) {
        this.bottom = bottom;
        return (T) this;
    }

    @JsonProperty(required = false)
    public Boolean getShow() {
        return show;
    }

    public void setShow(Boolean show) {
        this.show = show;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    @JsonProperty(required = false)
    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    @JsonProperty(required = false)
    public LinkTarget getTarget() {
        return target;
    }

    public void setTarget(LinkTarget target) {
        this.target = target;
    }

    @JsonProperty(required = false)
    @JsonDeserialize(as = DefaultTextStyle.class)
    public TextStyle getTextStyle() {
        return textStyle;
    }

    public void setTextStyle(TextStyle textStyle) {
        this.textStyle = textStyle;
    }

    @JsonProperty(required = false)
    public Align getTextAlign() {
        return textAlign;
    }

    public void setTextAlign(Align textAlign) {
        this.textAlign = textAlign;
    }

    @JsonProperty(required = false)
    public Baseline getTextBaseline() {
        return textBaseline;
    }

    public void setTextBaseline(Baseline textBaseline) {
        this.textBaseline = textBaseline;
    }

    @JsonProperty(value = "subtext", required = false)
    public String getSubText() {
        return subText;
    }

    public void setSubText(String subText) {
        this.subText = subText;
    }

    @JsonProperty(value = "sublink", required = false)
    public String getSubLink() {
        return subLink;
    }

    public void setSubLink(String subLink) {
        this.subLink = subLink;
    }

    @JsonProperty(value = "subtarget", required = false)
    public LinkTarget getSubTarget() {
        return subTarget;
    }

    public void setSubTarget(LinkTarget subTarget) {
        this.subTarget = subTarget;
    }

    @JsonProperty(required = false)
    public TextStyle getSubTextStyle() {
        return subTextStyle;
    }

    @JsonProperty(value = "subtextStyle", required = false)
    @JsonDeserialize(as = DefaultTextStyle.class)
    public void setSubTextStyle(TextStyle subTextStyle) {
        this.subTextStyle = subTextStyle;
    }

    @JsonProperty(required = false)
    public Object getPadding() {
        return padding;
    }

    public void setPadding(Object padding) {
        this.padding = padding;
    }

    @JsonProperty(required = false)
    public Integer getItemGap() {
        return itemGap;
    }

    public void setItemGap(Integer itemGap) {
        this.itemGap = itemGap;
    }

    @JsonProperty(required = false)
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
    public Object getLeft() {
        return left;
    }

    public void setLeft(Object left) {
        this.left = left;
    }

    @JsonProperty(required = false)
    public Object getRight() {
        return right;
    }

    public void setRight(Object right) {
        this.right = right;
    }

    @JsonProperty(required = false)
    public Object getTop() {
        return top;
    }

    public void setTop(Object top) {
        this.top = top;
    }

    @JsonProperty(required = false)
    public Object getBottom() {
        return bottom;
    }

    public void setBottom(Object bottom) {
        this.bottom = bottom;
    }

    @JsonProperty(required = false)
    public String getBackgroundColor() {
        return backgroundColor;
    }

    public void setBackgroundColor(String backgroundColor) {
        this.backgroundColor = backgroundColor;
    }

    @JsonProperty(required = false)
    public String getBorderColor() {
        return borderColor;
    }

    public void setBorderColor(String borderColor) {
        this.borderColor = borderColor;
    }

    @JsonProperty(required = false)
    public Integer getBorderWidth() {
        return borderWidth;
    }

    public void setBorderWidth(Integer borderWidth) {
        this.borderWidth = borderWidth;
    }

    @JsonProperty(required = false)
    public Integer getShadowBlur() {
        return shadowBlur;
    }

    public void setShadowBlur(Integer shadowBlur) {
        this.shadowBlur = shadowBlur;
    }

    @JsonProperty(required = false)
    public String getShadowColor() {
        return shadowColor;
    }

    public void setShadowColor(String shadowColor) {
        this.shadowColor = shadowColor;
    }

    @JsonProperty(required = false)
    public Integer getShadowOffsetX() {
        return shadowOffsetX;
    }

    public void setShadowOffsetX(Integer shadowOffsetX) {
        this.shadowOffsetX = shadowOffsetX;
    }

    @JsonProperty(required = false)
    public Integer getShadowOffsetY() {
        return shadowOffsetY;
    }

    public void setShadowOffsetY(Integer shadowOffsetY) {
        this.shadowOffsetY = shadowOffsetY;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof BaseProp)) return false;
        BaseProp baseProp = (BaseProp) o;
        return Objects.equals(show, baseProp.show) &&
                Objects.equals(text, baseProp.text) &&
                Objects.equals(link, baseProp.link) &&
                target == baseProp.target &&
                Objects.equals(textStyle, baseProp.textStyle) &&
                textAlign == baseProp.textAlign &&
                textBaseline == baseProp.textBaseline &&
                Objects.equals(subText, baseProp.subText) &&
                Objects.equals(subLink, baseProp.subLink) &&
                subTarget == baseProp.subTarget &&
                Objects.equals(subTextStyle, baseProp.subTextStyle) &&
                Objects.equals(padding, baseProp.padding) &&
                Objects.equals(itemGap, baseProp.itemGap) &&
                Objects.equals(zLevel, baseProp.zLevel) &&
                Objects.equals(z, baseProp.z) &&
                Objects.equals(left, baseProp.left) &&
                Objects.equals(right, baseProp.right) &&
                Objects.equals(top, baseProp.top) &&
                Objects.equals(bottom, baseProp.bottom) &&
                Objects.equals(backgroundColor, baseProp.backgroundColor) &&
                Objects.equals(borderColor, baseProp.borderColor) &&
                Objects.equals(borderWidth, baseProp.borderWidth) &&
                Objects.equals(shadowBlur, baseProp.shadowBlur) &&
                Objects.equals(shadowColor, baseProp.shadowColor) &&
                Objects.equals(shadowOffsetX, baseProp.shadowOffsetX) &&
                Objects.equals(shadowOffsetY, baseProp.shadowOffsetY);
    }

    @Override
    public int hashCode() {
        return Objects.hash(show, text, link, target, textStyle, textAlign, textBaseline, subText,
                subLink, subTarget, subTextStyle, padding, itemGap, zLevel, z, left, right, top,
                bottom, backgroundColor, borderColor, borderWidth, shadowBlur, shadowColor,
                shadowOffsetX, shadowOffsetY);
    }

    @Override
    public String toString() {
        return getClass() + "{" +
                "show=" + show +
                ", text='" + text + '\'' +
                ", link='" + link + '\'' +
                ", target=" + target +
                ", textStyle=" + textStyle +
                ", textAlign=" + textAlign +
                ", textBaseline=" + textBaseline +
                ", subText='" + subText + '\'' +
                ", subLink='" + subLink + '\'' +
                ", subTarget=" + subTarget +
                ", subTextStyle=" + subTextStyle +
                ", padding=" + padding +
                ", itemGap=" + itemGap +
                ", zLevel=" + zLevel +
                ", z=" + z +
                ", left=" + left +
                ", right=" + right +
                ", top=" + top +
                ", bottom=" + bottom +
                ", backgroundColor='" + backgroundColor + '\'' +
                ", borderColor='" + borderColor + '\'' +
                ", borderWidth=" + borderWidth +
                ", shadowBlur=" + shadowBlur +
                ", shadowColor='" + shadowColor + '\'' +
                ", shadowOffsetX=" + shadowOffsetX +
                ", shadowOffsetY=" + shadowOffsetY +
                '}';
    }
}
