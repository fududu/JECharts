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

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import org.aying.echarts.base.Align;
import org.aying.echarts.base.Baseline;
import org.aying.echarts.base.Graph;
import org.aying.echarts.base.LineType;
import org.aying.echarts.base.LinkTarget;
import org.aying.echarts.style.ShapeStyle;
import org.aying.echarts.style.SimpleShapeStyle;
import org.aying.echarts.style.SimpleTextStyle;
import org.aying.echarts.style.TextStyle;

import java.util.Objects;

/**
 * 标题组件，包含主标题和副标题。
 *
 * @author Fuchun
 * @since 1.0
 */
public class Title extends Graph<Title>
        implements Component<Title>, ShapeStyle {

    private static final long serialVersionUID = 3099511802052607152L;

    public static Title one(String text) {
        return new Title().text(text);
    }

    private final SimpleShapeStyle sss;

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

    public Title() {
        super();
        sss = new SimpleShapeStyle();
    }

    @Override
    public Boolean getShow() {
        return show;
    }

    @Override
    public void setShow(Boolean show) {
        this.show = show;
    }

    @Override
    public Title hide() {
        this.show = Boolean.FALSE;
        return this;
    }

    @Override
    public Title show() {
        this.show = Boolean.TRUE;
        return this;
    }

    public Title text(String text) {
        return text(text, null);
    }

    public Title text(String text, TextStyle style) {
        this.text = text;
        this.textStyle = style;
        return this;
    }

    public Title subText(String subText) {
        return subText(subText, null);
    }

    public Title subText(String subText, TextStyle subTextStyle) {
        this.subText= subText;
        this.subTextStyle = subTextStyle;
        return this;
    }

    public Title link(String link) {
        // target == null => "blank"
        return link(link, null);
    }

    public Title link(String linkUrl, LinkTarget target) {
        this.link = linkUrl;
        this.target = target;
        return this;
    }

    public Title subLink(String subLink) {
        return subLink(subLink, null);
    }

    public Title subLink(String subLink, LinkTarget target) {
        this.subLink = subLink;
        this.subTarget = target;
        return this;
    }

    public Title align(Align align) {
        this.textAlign = align;
        return this;
    }

    public Title baseline(Baseline baseline) {
        this.textBaseline = baseline;
        return this;
    }

    public Title padding(int padding) {
        this.padding = padding;
        return this;
    }

    public Title padding(int tb, int lr) {
        this.padding = new int[] { tb, lr };
        return this;
    }

    public Title padding(int top, int right, int bottom, int left) {
        this.padding = new int[]{top, right, bottom, left};
        return this;
    }

    public Title itemGap(int itemGap) {
        this.itemGap = itemGap;
        return this;
    }

    @Override
    public Title bgColor(String bgColor) {
        sss.bgColor(bgColor);
        return this;
    }

    @Override
    public Title borderWidth(int borderWidth) {
        sss.borderWidth(borderWidth);
        return this;
    }

    @Override
    public ShapeStyle borderColor(String color) {
        sss.borderColor(color);
        return this;
    }

    @Override
    public Title textStyle(TextStyle textStyle) {
        this.textStyle = textStyle;
        return this;
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
    @JsonDeserialize(as = SimpleTextStyle.class)
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
    @JsonDeserialize(as = SimpleTextStyle.class)
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

    @Override
    @JsonIgnore
    public String getColor() {
        return null;
    }

    @Override
    @SuppressWarnings("unchecked")
    public Title color(String color) {
        return this;
    }

    @JsonProperty(required = false)
    public String getBackgroundColor() {
        return sss.getBackgroundColor();
    }

    public void setBackgroundColor(String backgroundColor) {
        sss.setBackgroundColor(backgroundColor);
    }

    @JsonProperty(required = false)
    public String getBorderColor() {
        return sss.getBorderColor();
    }

    public void setBorderColor(String borderColor) {
        sss.setBorderColor(borderColor);
    }

    @JsonProperty(required = false)
    public Integer getBorderWidth() {
        return sss.getBorderWidth();
    }

    public void setBorderWidth(Integer borderWidth) {
        sss.setBorderWidth(borderWidth);
    }

    @Override
    @JsonIgnore
    public LineType getBorderType() {
        return null;
    }

    @JsonProperty(required = false)
    public Integer getShadowBlur() {
        return sss.getShadowBlur();
    }

    public void setShadowBlur(Integer shadowBlur) {
        sss.setShadowBlur(shadowBlur);
    }

    @JsonProperty(required = false)
    public String getShadowColor() {
        return sss.getShadowColor();
    }

    public void setShadowColor(String shadowColor) {
        sss.setShadowColor(shadowColor);
    }

    @JsonProperty(required = false)
    public Integer getShadowOffsetX() {
        return sss.getShadowOffsetX();
    }

    public void setShadowOffsetX(Integer shadowOffsetX) {
        sss.setShadowOffsetX(shadowOffsetX);
    }

    @JsonProperty(required = false)
    public Integer getShadowOffsetY() {
        return sss.getShadowOffsetY();
    }

    public void setShadowOffsetY(Integer shadowOffsetY) {
        sss.setShadowOffsetY(shadowOffsetY);
    }

    @Override
    @JsonIgnore
    public Double getOpacity() {
        return null;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Title)) return false;
        if (!super.equals(o)) return false;
        Title title = (Title) o;
        return Objects.equals(sss, title.sss) &&
                Objects.equals(show, title.show) &&
                Objects.equals(text, title.text) &&
                Objects.equals(link, title.link) &&
                target == title.target &&
                Objects.equals(textStyle, title.textStyle) &&
                textAlign == title.textAlign &&
                textBaseline == title.textBaseline &&
                Objects.equals(subText, title.subText) &&
                Objects.equals(subLink, title.subLink) &&
                subTarget == title.subTarget &&
                Objects.equals(subTextStyle, title.subTextStyle) &&
                Objects.equals(padding, title.padding) &&
                Objects.equals(itemGap, title.itemGap);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), sss, show, text, link, target, textStyle, textAlign,
                textBaseline, subText, subLink, subTarget, subTextStyle, padding, itemGap);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder(32)
                .append(getClass()).append("{");
        sb.append("show=").append(show);
        sb.append(", text='").append(text).append('\'');
        sb.append(", link='").append(link).append('\'');
        sb.append(", target=").append(target);
        sb.append(", textStyle=").append(textStyle);
        sb.append(", textAlign=").append(textAlign);
        sb.append(", textBaseline=").append(textBaseline);
        sb.append(", subText='").append(subText).append('\'');
        sb.append(", subLink='").append(subLink).append('\'');
        sb.append(", subTarget=").append(subTarget);
        sb.append(", subTextStyle=").append(subTextStyle);
        sb.append(", padding=").append(padding);
        sb.append(", itemGap=").append(itemGap);
        appendToString(sb);
        sb.append(", backgroundColor='").append(getBackgroundColor()).append('\'');
        sb.append(", borderColor='").append(getBorderColor()).append('\'');
        sb.append(", borderWidth=").append(getBorderWidth());
        sb.append(", shadowBlur=").append(getShadowBlur());
        sb.append(", shadowColor='").append(getShadowColor()).append('\'');
        sb.append(", shadowOffsetX=").append(getShadowOffsetX());
        sb.append(", shadowOffsetY=").append(getShadowOffsetY());
        sb.append('}');
        return sb.toString();
    }
}
