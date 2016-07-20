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
import org.aying.echarts.base.SelectedMode;

import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.TreeMap;

/**
 * 图例组件模型。
 *
 * @author Fuchun
 * @since 1.0
 */
public class Legend extends BaseProp<Legend> implements Data<Legend> {

    private static final long serialVersionUID = -4466736220215040561L;

    private Integer itemWidth;
    private Integer itemHeight;
    private Object formatter;
    private Object selectedMode;
    private String inactiveColor;
    private Map<String, Boolean> selected;
    private Tooltip tooltip;

    @JsonIgnore
    private Data<?> delegateData;

    public Legend() {
        super();
        delegateData = BaseData.delegate();
    }

    public Legend itemWidth(int itemWidth) {
        this.itemWidth = itemWidth;
        return this;
    }

    public Legend itemHeight(int itemHeight) {
        this.itemHeight = itemHeight;
        return this;
    }

    public Legend formatter(String formatter) {
        this.formatter = formatter;
        return this;
    }

    public Legend selectedMode(SelectedMode mode) {
        this.selectedMode = mode;
        return this;
    }

    public Legend closeSelectedMode() {
        this.selectedMode = false;
        return this;
    }

    public Legend inactiveColor(String color) {
        this.inactiveColor = color;
        return this;
    }

    public Legend selected(String name, Boolean selected) {
        Objects.requireNonNull(name, "selected name");
        if (this.selected == null) {
            this.selected = new TreeMap<>();
        }
        if (selected == null) {
            this.selected.remove(name);
        } else {
            this.selected.put(name, selected);
        }
        return this;
    }

    public Legend selected(Map<String, Boolean> selected) {
        if (selected == null || selected.isEmpty()) {
            this.selected = null;
        } else {
            this.selected = new TreeMap<>(selected);
        }
        return this;
    }

    public Integer getItemWidth() {
        return itemWidth;
    }

    public void setItemWidth(Integer itemWidth) {
        this.itemWidth = itemWidth;
    }

    public Integer getItemHeight() {
        return itemHeight;
    }

    public void setItemHeight(Integer itemHeight) {
        this.itemHeight = itemHeight;
    }

    public Object getFormatter() {
        return formatter;
    }

    public void setFormatter(Object formatter) {
        this.formatter = formatter;
    }

    public Object getSelectedMode() {
        return selectedMode;
    }

    public void setSelectedMode(Object selectedMode) {
        this.selectedMode = selectedMode;
    }

    public String getInactiveColor() {
        return inactiveColor;
    }

    public void setInactiveColor(String inactiveColor) {
        this.inactiveColor = inactiveColor;
    }

    public Map<String, Boolean> getSelected() {
        return selected;
    }

    public void setSelected(Map<String, Boolean> selected) {
        this.selected = selected;
    }

    public Tooltip getTooltip() {
        return tooltip;
    }

    public void setTooltip(Tooltip tooltip) {
        this.tooltip = tooltip;
    }

    public List<Data<?>> getData() {
        return delegateData.getData();
    }

    public void setData(List<Data<?>> data) {
        this.delegateData = BaseData.delegate(data);
    }

    @Override
    @SuppressWarnings("unchecked")
    public Legend add(Data<?> d) {
        delegateData.add(d);
        return this;
    }

    @Override
    @SuppressWarnings("unchecked")
    public Legend add(Data<?> d1, Data<?> d2, Data<?>... dn) {
        delegateData.add(d1, d2, dn);
        return this;
    }
}
