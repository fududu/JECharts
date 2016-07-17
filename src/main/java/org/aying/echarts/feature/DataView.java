/*
 * Copyright 2016 Aying.Org all rights reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.aying.echarts.feature;

import java.util.Arrays;
import java.util.Objects;

/**
 * 数据视图工具，可以展现当前图表所用的数据，编辑后可以动态更新。
 *
 * @author Fuchun
 * @since 1.0
 */
public class DataView extends BaseFeature<DataView> {

    private static final long serialVersionUID = -2261208026786238918L;

    public static DataView view() {
        return new DataView();
    }

    /* 是否不可编辑（只读）。默认：false */
    private Boolean readOnly;
    private Object optionToContent;
    private Object contentToOption;
    /* 数据视图上有三个话术，默认是['数据视图', '关闭', '刷新']。 */
    private String[] lang;
    /* 数据视图浮层背景色。 */
    private String backgroundColor;
    /* 数据视图浮层文本输入区背景色。默认：#FFF */
    private String textareaColor;
    /* 数据视图浮层文本输入区边框颜色。默认：#333 */
    private String textareaBorderColor;
    /* 文本颜色。默认：#000 */
    private String textColor;
    /* 按钮颜色。默认：#c23531 */
    private String buttonColor;
    /* 按钮文本颜色。默认：#FFF */
    private String buttonTextColor;

    public DataView() {
        super();
    }

    /**
     * 将数据视图中的数据项设置为只读状态（不可动态编辑）
     */
    public DataView readOnly() {
        this.readOnly = true;
        return this;
    }

    public DataView lang(String l1, String l2, String... ln) {
        Objects.requireNonNull(l1, "First lang");
        Objects.requireNonNull(l2, "Second lang");
        int more = (ln != null) ? ln.length : 0;
        String[] rs = new String[2 + more];
        rs[0] = l1;
        rs[1] = l2;
        if (ln != null && ln.length > 0) {
            int i = 2;
            for (String l : ln) {
                rs[i++] = l;
            }
        }
        this.lang = rs;
        return this;
    }

    public DataView bgColor(String bgColor) {
        this.backgroundColor = bgColor;
        return this;
    }

    public DataView textColor(String color) {
        this.textColor = color;
        return this;
    }

    /**
     * 设置 数据视图浮层文本输入区的样式。
     * <p />
     * 不调用该设置时，或设置为{@code null} 时，
     * 默认数据视图浮层文本输入区的样式为：textareaColor=#FFF textareaBorderColor=#333
     *
     * @param color 数据视图浮层文本输入区背景色。(maybe null)
     * @param borderColor 数据视图浮层文本输入区边框颜色。(maybe null)
     */
    public DataView textarea(String color, String borderColor) {
        String textareaColor = null, textareaBorderColor = null;
        if (color != null && !(color = color.trim()).isEmpty()) {
            textareaColor = color;
        }
        if (borderColor != null && !(borderColor = borderColor.trim()).isEmpty()) {
            textareaBorderColor = borderColor;
        }
        this.textareaColor = textareaColor;
        this.textareaBorderColor = textareaBorderColor;
        return this;
    }

    /**
     * 设置按钮的样式。
     * <p />
     * 不调用该设置时，或设置为{@code null} 时，
     * 默认按钮样式为：buttonColor=#C23531 buttonTextColor=#FFF
     *
     * @param color 按钮的颜色（背景颜色）(maybe null)
     * @param textColor 按钮的字体颜色。(maybe null)
     */
    public DataView button(String color, String textColor) {
        String buttonColor = null, buttonTextColor = null;
        if (color != null && !(color = color.trim()).isEmpty()) {
            buttonColor = color;
        }
        if (textColor != null && !(textColor = textColor.trim()).isEmpty()) {
            buttonTextColor = textColor;
        }

        this.buttonColor = buttonColor;
        this.buttonTextColor = buttonTextColor;
        return this;
    }

    public Boolean getReadOnly() {
        return readOnly;
    }

    public void setReadOnly(Boolean readOnly) {
        this.readOnly = readOnly;
    }

    public Object getOptionToContent() {
        return optionToContent;
    }

    public void setOptionToContent(Object optionToContent) {
        this.optionToContent = optionToContent;
    }

    public Object getContentToOption() {
        return contentToOption;
    }

    public void setContentToOption(Object contentToOption) {
        this.contentToOption = contentToOption;
    }

    public String[] getLang() {
        return lang;
    }

    public void setLang(String[] lang) {
        this.lang = lang;
    }

    public String getBackgroundColor() {
        return backgroundColor;
    }

    public void setBackgroundColor(String backgroundColor) {
        this.backgroundColor = backgroundColor;
    }

    public String getTextareaColor() {
        return textareaColor;
    }

    public void setTextareaColor(String textareaColor) {
        this.textareaColor = textareaColor;
    }

    public String getTextareaBorderColor() {
        return textareaBorderColor;
    }

    public void setTextareaBorderColor(String textareaBorderColor) {
        this.textareaBorderColor = textareaBorderColor;
    }

    public String getTextColor() {
        return textColor;
    }

    public void setTextColor(String textColor) {
        this.textColor = textColor;
    }

    public String getButtonColor() {
        return buttonColor;
    }

    public void setButtonColor(String buttonColor) {
        this.buttonColor = buttonColor;
    }

    public String getButtonTextColor() {
        return buttonTextColor;
    }

    public void setButtonTextColor(String buttonTextColor) {
        this.buttonTextColor = buttonTextColor;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof DataView)) return false;
        if (!super.equals(o)) return false;
        DataView dataView = (DataView) o;
        return Objects.equals(readOnly, dataView.readOnly) &&
                Objects.equals(optionToContent, dataView.optionToContent) &&
                Objects.equals(contentToOption, dataView.contentToOption) &&
                Arrays.equals(lang, dataView.lang) &&
                Objects.equals(backgroundColor, dataView.backgroundColor) &&
                Objects.equals(textareaColor, dataView.textareaColor) &&
                Objects.equals(textareaBorderColor, dataView.textareaBorderColor) &&
                Objects.equals(textColor, dataView.textColor) &&
                Objects.equals(buttonColor, dataView.buttonColor) &&
                Objects.equals(buttonTextColor, dataView.buttonTextColor);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), readOnly, optionToContent, contentToOption, lang,
                backgroundColor, textareaColor, textareaBorderColor, textColor, buttonColor, buttonTextColor);
    }

    @Override
    public String toString() {
        return "DataView{" +
                "readOnly=" + readOnly +
                ", optionToContent=" + optionToContent +
                ", contentToOption=" + contentToOption +
                ", lang=" + Arrays.toString(lang) +
                ", backgroundColor='" + backgroundColor + '\'' +
                ", textareaColor='" + textareaColor + '\'' +
                ", textareaBorderColor='" + textareaBorderColor + '\'' +
                ", textColor='" + textColor + '\'' +
                ", buttonColor='" + buttonColor + '\'' +
                ", buttonTextColor='" + buttonTextColor + '\'' +
                "} " + super.toString();
    }
}
