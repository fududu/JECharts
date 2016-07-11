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
public class DefaultStyle implements Style {

    private static final long serialVersionUID = 1L;
    /**
     * 字体颜色。
     */
    protected String color;

    public DefaultStyle() {
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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof DefaultStyle)) return false;
        DefaultStyle that = (DefaultStyle) o;
        return Objects.equals(color, that.color);
    }

    @Override
    public int hashCode() {
        return Objects.hash(color);
    }

    @Override
    public String toString() {
        return String.format("org.aying.echarts.style.DefaultStyle{color='%s'}", color);
    }
}
