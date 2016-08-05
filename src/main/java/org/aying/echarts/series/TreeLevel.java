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

import org.aying.echarts.base.StateLabel;
import org.aying.echarts.style.StateShapeStyle;

import java.io.Serializable;
import java.util.Objects;

/**
 * 树图层级配置模型。
 *
 * @author Fuchun
 * @since 1.0
 */
public class TreeLevel extends BaseTreeMapCommon<TreeLevel> implements Serializable {

    private static final long serialVersionUID = 8511392221862367043L;

    private StateLabel label;
    private StateShapeStyle itemStyle;

    public StateLabel getLabel() {
        return label;
    }

    public void setLabel(StateLabel label) {
        this.label = label;
    }

    public StateShapeStyle getItemStyle() {
        return itemStyle;
    }

    public void setItemStyle(StateShapeStyle itemStyle) {
        this.itemStyle = itemStyle;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof TreeLevel)) return false;
        if (!super.equals(o)) return false;
        TreeLevel treeLevel = (TreeLevel) o;
        return Objects.equals(label, treeLevel.label) &&
                Objects.equals(itemStyle, treeLevel.itemStyle);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), label, itemStyle);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder(32)
                .append(getClass()).append("{");
        appendTreeMapCommon(sb);
        sb.append(", label=").append(label);
        sb.append(", itemStyle=").append(itemStyle);
        sb.append('}');
        return sb.toString();
    }
}
