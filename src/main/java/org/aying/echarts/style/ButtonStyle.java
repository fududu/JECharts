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

import java.util.Objects;

/**
 * @author Fuchun
 * @since 1.0
 */
public class ButtonStyle extends BaseStyle<ButtonStyle> {

    private static final long serialVersionUID = 8009804514416898946L;

    private String borderColor;
    private Integer borderWidth;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ButtonStyle)) return false;
        if (!super.equals(o)) return false;
        ButtonStyle that = (ButtonStyle) o;
        return Objects.equals(borderColor, that.borderColor) &&
                Objects.equals(borderWidth, that.borderWidth);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), borderColor, borderWidth);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder(32)
                .append(getClass()).append("{");
        sb.append("color='").append(getColor()).append("'");
        sb.append(", borderColor='").append(borderColor).append("'");
        sb.append(", borderWidth=").append(borderWidth);
        sb.append('}');
        return sb.toString();
    }
}
