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

import org.aying.echarts.base.BaseSymbol;
import org.aying.echarts.base.StateLabel;
import org.aying.echarts.style.StateShapeStyle;

import java.io.Serializable;
import java.util.Objects;

/**
 * 节点分类的类目配置。
 *
 * @author Fuchun
 * @since 1.0
 */
public class Category extends BaseSymbol<Category> implements Serializable {

    private static final long serialVersionUID = 3250415469489551393L;

    public static Category one() {
        return new Category();
    }

    public static Category named(String name) {
        return new Category(name);
    }

    private String name;
    private StateShapeStyle itemStyle;
    private StateLabel label;

    public Category() {
        super();
    }

    public Category(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public StateShapeStyle getItemStyle() {
        return itemStyle;
    }

    public void setItemStyle(StateShapeStyle itemStyle) {
        this.itemStyle = itemStyle;
    }

    public StateLabel getLabel() {
        return label;
    }

    public void setLabel(StateLabel label) {
        this.label = label;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Category)) return false;
        if (!super.equals(o)) return false;
        Category category = (Category) o;
        return Objects.equals(name, category.name) &&
                Objects.equals(itemStyle, category.itemStyle) &&
                Objects.equals(label, category.label);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), name, itemStyle, label);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder(32)
                .append(getClass()).append("{");
        sb.append("name='").append(name).append('\'');
        sb.append(", ");
        appendToString(sb);
        sb.append(", itemStyle=").append(itemStyle);
        sb.append(", label=").append(label);
        sb.append('}');
        return sb.toString();
    }
}
