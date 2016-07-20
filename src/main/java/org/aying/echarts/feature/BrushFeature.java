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

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/**
 * 选框组件的控制按钮。
 *
 * @author Fuchun
 * @since 1.0
 */
public class BrushFeature implements Serializable {

    private static final long serialVersionUID = 1994298680153137218L;

    public static BrushFeature me() {
        return new BrushFeature();
    }

    @JsonCreator
    public static BrushFeature of(
            @JsonProperty(value = "type", required = false) List<BrushType> typeList,
            @JsonProperty(value = "icon", required = false) Map<BrushType, String> iconMap,
            @JsonProperty(value = "title", required = false) Map<BrushType, String> titleMap) {
        return new BrushFeature(typeList, iconMap, titleMap);
    }

    /* 使用的按钮类型 */
    private List<BrushType> typeList;

    /* 每个按钮的 icon path。 */
    private Map<BrushType, String> iconMap;

    /* 标题文本。 */
    private Map<BrushType, String> titleMap;

    public BrushFeature() {
        super();
    }

    public BrushFeature(List<BrushType> typeList, Map<BrushType, String> iconMap, Map<BrushType, String> titleMap) {
        this.typeList = typeList;
        this.iconMap = iconMap;
        this.titleMap = titleMap;
    }

    public BrushFeature type(BrushType t1, BrushType... tn) {
        Objects.requireNonNull(t1, "brush type");
        if (typeList == null) {
            typeList = new LinkedList<>();
        }
        typeList.add(t1);
        if (tn != null && tn.length > 0) {
            Collections.addAll(typeList, tn);
        }
        return this;
    }

    public BrushFeature icon(BrushType t1, String ip1, Object... type2IconPaths) {
        Objects.requireNonNull(t1, "First type");
        Objects.requireNonNull(ip1, "First icon path");
        if (iconMap == null) {
            iconMap = new HashMap<>();
        }
        iconMap.put(t1, ip1);
        if (type2IconPaths != null && type2IconPaths.length > 0) {
            if (type2IconPaths.length % 2 != 0) {
                throw new IllegalArgumentException(
                        "The type to icon path must be pair.");
            }
            putAllArgs(iconMap, type2IconPaths);
        }
        return this;
    }

    public BrushFeature title(BrushType t1, String t1Title, Object... type2Titles) {
        Objects.requireNonNull(t1, "First type");
        Objects.requireNonNull(t1Title, "First title");
        if (titleMap == null) {
            titleMap = new HashMap<>();
        }
        titleMap.put(t1, t1Title);
        if (type2Titles != null && type2Titles.length > 0) {
            if (type2Titles.length % 2 != 0) {
                throw new IllegalArgumentException(
                        "The type to title must be pair.");
            }
            putAllArgs(titleMap, type2Titles);
        }
        return this;
    }

    private void putAllArgs(final Map<BrushType, String> map, Object[] args) {
        for (int i = 0; i < args.length; i++) {
            Object type = args[i];
            Object title = args[i + 1];
            if (!(type instanceof BrushType) || !(title instanceof String)) {
                throw new IllegalArgumentException(
                        "The brush type must be BrushType, value mapping must be String");
            }
            map.put((BrushType) type, (String) title);
            i = i + 2;
        }
    }

    @JsonProperty(value = "type", required = false)
    public List<BrushType> getTypeList() {
        return typeList;
    }

    public void setTypeList(List<BrushType> typeList) {
        this.typeList = typeList;
    }

    @JsonProperty(value = "icon", required = false)
    public Map<BrushType, String> getIconMap() {
        return iconMap;
    }

    public void setIconMap(Map<BrushType, String> iconMap) {
        this.iconMap = iconMap;
    }

    @JsonProperty(value = "title", required = false)
    public Map<BrushType, String> getTitleMap() {
        return titleMap;
    }

    public void setTitleMap(Map<BrushType, String> titleMap) {
        this.titleMap = titleMap;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof BrushFeature)) return false;
        BrushFeature brush = (BrushFeature) o;
        return Objects.equals(typeList, brush.typeList) &&
                Objects.equals(iconMap, brush.iconMap) &&
                Objects.equals(titleMap, brush.titleMap);
    }

    @Override
    public int hashCode() {
        return Objects.hash(typeList, iconMap, titleMap);
    }

    @Override
    public String toString() {
        return "BrushFeature{" +
                "typeList=" + typeList +
                ", iconMap=" + iconMap +
                ", titleMap=" + titleMap +
                '}';
    }
}
