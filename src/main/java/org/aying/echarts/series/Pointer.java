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

package org.aying.echarts.series;

import java.io.Serializable;
import java.util.Objects;

/**
 * 仪表盘指针。
 *
 * @author Fuchun
 * @since 1.0
 */
public class Pointer implements Serializable {

    private static final long serialVersionUID = -2217575664949281862L;

    /*是否显示指针。默认：true */
    private Boolean show;
    /*指针长度，可以是绝对数值，也可以是相对于半径的半分比。*/
    private Object length;
    /*指针宽度。默认：8 */
    private Integer width;

    public Pointer() {
        super();
    }

    public Pointer(Boolean show, Object length, Integer width) {
        this.show = show;
        this.length = length;
        this.width = width;
    }

    public Boolean getShow() {
        return show;
    }

    public void setShow(Boolean show) {
        this.show = show;
    }

    public Object getLength() {
        return length;
    }

    public void setLength(Object length) {
        this.length = length;
    }

    public Integer getWidth() {
        return width;
    }

    public void setWidth(Integer width) {
        this.width = width;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Pointer)) return false;
        Pointer pointer = (Pointer) o;
        return Objects.equals(show, pointer.show) &&
                Objects.equals(length, pointer.length) &&
                Objects.equals(width, pointer.width);
    }

    @Override
    public int hashCode() {
        return Objects.hash(show, length, width);
    }

    @Override
    public String toString() {
        return String.format("org.aying.echarts.series.Pointer{show=%s, length=%s, width=%d}", show, length, width);
    }
}
