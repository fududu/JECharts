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

import org.aying.echarts.style.TextStyle;

import java.io.Serializable;
import java.lang.reflect.Array;
import java.util.Objects;

/**
 * 图形上的文本标签，可用于说明图形的一些数据信息，比如值，名称等
 *
 * @author Fuchun
 * @since 1.0
 */
public class Label implements Serializable {

    private static final long serialVersionUID = -8850807328172978264L;

    public static Label get() {
        return new Label();
    }

    private Boolean show;
    private Object position;
    private Object formatter;
    private TextStyle textStyle;

    public Label() {
        super();
    }

    public Label show() {
        this.show = Boolean.TRUE;
        return this;
    }

    public Label position(Pos p) {
        this.position = p;
        return this;
    }

    public Label position(Object x, Object y) {
        Objects.requireNonNull(x, "position X");
        Objects.requireNonNull(y, "position Y");
        if (!(x instanceof Number || x instanceof String) ||
                !(y instanceof Number || y instanceof String)) {
            throw new IllegalArgumentException(
                    "The position [x, y] value must be number or string. like [10, 10] or ['50%', '50%']");
        }
        this.position = new Object[] { x, y };
        return this;
    }

    public Label formatter(String formatter) {
        this.formatter = formatter;
        return this;
    }

    public Label textStyle(TextStyle textStyle) {
        this.textStyle = textStyle;
        return this;
    }

    public Boolean getShow() {
        return show;
    }

    public void setShow(Boolean show) {
        this.show = show;
    }

    public Object getPosition() {
        return position;
    }

    public void setPosition(Object position) {
        if (position == null) {
            this.position = null;
            return;
        } else if (position instanceof String) {
            Pos p = Pos.of((String) position, null);
            if (p == null) {
                throw new IllegalArgumentException(
                        "The position value is invalid.");
            }
            this.position = p;
        } else if (position.getClass().isArray()) {
            if (Array.getLength(position) != 2) {
                throw new IllegalArgumentException("The position array must be like [x, y]");
            }
            Object x = Array.get(position, 0),
                    y = Array.get(position, 1);
            if (x == null || y == null) {
                throw new IllegalArgumentException("The position array value must be not null");
            }
            this.position = new Object[] { x, y };
        }
        throw new IllegalArgumentException("Unsupported position value: " + position);
    }

    public Object getFormatter() {
        return formatter;
    }

    public void setFormatter(Object formatter) {
        this.formatter = formatter;
    }

    public TextStyle getTextStyle() {
        return textStyle;
    }

    public void setTextStyle(TextStyle textStyle) {
        this.textStyle = textStyle;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Label)) return false;
        Label label = (Label) o;
        return Objects.equals(show, label.show) &&
                position == label.position &&
                Objects.equals(formatter, label.formatter) &&
                textStyle == label.textStyle;
    }

    @Override
    public int hashCode() {
        return Objects.hash(show, position, formatter, textStyle);
    }

    @Override
    public String toString() {
        return "org.aying.echarts.base.Label{" +
                "show=" + show +
                ", position=" + position +
                ", formatter=" + formatter +
                ", textStyle=" + textStyle +
                '}';
    }
}
