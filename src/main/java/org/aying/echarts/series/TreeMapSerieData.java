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

import java.util.List;
import java.util.Objects;

/**
 * @author Fuchun
 * @since 1.0
 */
public class TreeMapSerieData extends SerieData implements TreeMapCommon<TreeMapSerieData> {

    private static final long serialVersionUID = 6874560193210562590L;

    private final SimpleTreeMapCommon stm;

    private String id;
    private List<TreeMapSerieData> children;

    public TreeMapSerieData() {
        super();
        this.stm = new SimpleTreeMapCommon();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Integer getVisualDimension() {
        return stm.getVisualDimension();
    }

    public void setVisualDimension(Integer visualDimension) {
        stm.setVisualDimension(visualDimension);
    }

    public Object[] getColorAlpha() {
        return stm.getColorAlpha();
    }

    public void setColorAlpha(Object[] colorAlpha) {
        stm.setColorAlpha(colorAlpha);
    }

    public Object getColorSaturation() {
        return stm.getColorSaturation();
    }

    public void setColorSaturation(Object colorSaturation) {
        stm.setColorSaturation(colorSaturation);
    }

    public ColorMappingBy getColorMappingBy() {
        return stm.getColorMappingBy();
    }

    public void setColorMappingBy(ColorMappingBy colorMappingBy) {
        stm.setColorMappingBy(colorMappingBy);
    }

    public Integer getVisibleMin() {
        return stm.getVisibleMin();
    }

    public void setVisibleMin(Integer visibleMin) {
        stm.setVisibleMin(visibleMin);
    }

    public Double getChildrenVisibleMin() {
        return stm.getChildrenVisibleMin();
    }

    public void setChildrenVisibleMin(Double childrenVisibleMin) {
        stm.setChildrenVisibleMin(childrenVisibleMin);
    }

    public List<TreeMapSerieData> getChildren() {
        return children;
    }

    public void setChildren(List<TreeMapSerieData> children) {
        this.children = children;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof TreeMapSerieData)) return false;
        if (!super.equals(o)) return false;
        TreeMapSerieData that = (TreeMapSerieData) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(stm, that.stm) &&
                Objects.equals(children, that.children);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), id, stm, children);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder(32)
                .append(getClass()).append("{");
        appendSimpleData(sb);
        sb.append(", id='").append(id).append('\'');
        stm.appendTreeMapCommon(sb);
        sb.append(", children=").append(children);
        sb.append(", label=").append(getLabel());
        sb.append(", itemStyle=").append(getItemStyle());
        sb.append('}');
        return sb.toString();
    }
}
