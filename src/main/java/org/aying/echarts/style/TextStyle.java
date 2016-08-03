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

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import org.aying.echarts.base.Align;
import org.aying.echarts.base.Baseline;
import org.aying.echarts.style.font.FontStyle;
import org.intellij.lang.annotations.MagicConstant;

import static org.aying.echarts.style.font.FontWeight.*;
import static org.aying.echarts.style.font.FontWeight.W700;
import static org.aying.echarts.style.font.FontWeight.W800;
import static org.aying.echarts.style.font.FontWeight.W900;

/**
 * 文本文字样式。
 *
 * @author Fuchun
 * @since 1.0
 */
@JsonDeserialize(as = SimpleTextStyle.class)
public interface TextStyle extends Style {

    /**
     * 文字水平对齐方式。
     */
    default Align getAlign() {
        return null;
    }

    /**
     * 文字垂直对齐方式。
     */
    default Baseline getBaseline() {
        return null;
    }

    /**
     * 文字样式。
     */
    FontStyle getFontStyle();

    /**
     * 字体粗细。{@link org.aying.echarts.style.font.FontWeight} 或者为整型的
     * {@code 100、200、300、400、500、600、700、800、900}
     */
    Object getFontWeight();

    /**
     * 字体名称。
     */
    String getFontFamily();

    /**
     * 字体大小。
     */
    Integer getFontSize();

    /**
     * 文字文本左对齐。
     */
    default TextStyle alignLeft() {
        return this;
    }

    /**
     * 文字文本设置为水平居中对齐。
     */
    default TextStyle alignCenter() {
        return this;
    }

    /**
     * 文字文本设置为右对齐。
     */
    default TextStyle alignRight() {
        return this;
    }

    /**
     * 文字文本设置为顶部对齐。
     */
    default TextStyle alignTop() {
        return this;
    }

    /**
     * 文字文本设置为垂直居中对齐。
     */
    default TextStyle alignMiddle() {
        return this;
    }

    /**
     * 文字文本设置为垂直底部对齐。
     */
    default TextStyle alignBottom() {
        return this;
    }

    @SuppressWarnings("unchecked")
    TextStyle color(String color);

    /**
     * 设置字体样式。
     *
     * @param style 字体样式。
     * @return 此文本样式。
     */
    TextStyle fontStyle(FontStyle style);

    /**
     * 设置字体宽度。
     *
     * @param weight 字体宽度。
     * @return 此文本样式。
     */
    TextStyle fontWeight(
            @MagicConstant(intValues = {W100, W200, W300, W400, W500, W600, W700, W800, W900})
            int weight);

    /**
     * 设置为粗体字。
     */
    TextStyle bold();

    /**
     * 文本使用比粗体更粗的字。
     */
    TextStyle bolder();

    /**
     * 文本使用淡字体。
     */
    TextStyle lighter();

    /**
     * 设置文本的字体样式名称。
     *
     * @param fontFamily 字体名称。
     */
    TextStyle fontFamily(String fontFamily);

    /**
     * 设置文本的字体大小。
     *
     * @param fontSize 字体大小。
     */
    TextStyle fontSize(int fontSize);
}
