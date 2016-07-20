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
import org.aying.echarts.style.ShapeStyle;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;

/**
 * @author Fuchun
 * @since 1.0
 */
public class DataZoomSelect extends DataZoom {

    private static final long serialVersionUID = -1784906978413316044L;

    private Map<String, String> title;
    private Map<String, String> icon;
    private Map<String, ShapeStyle> iconStyle;

    public DataZoomSelect() {
        super(DataZoomType.select);
    }

    protected void initTitleMap() {
        if (title == null) {
            title = new HashMap<>(4);
        }
    }

    protected void initIconMap() {
        if (icon == null) {
            icon = new HashMap<>(4);
        }
    }

    protected void initIconStyleMap() {
        if (iconStyle == null) {
            iconStyle = new HashMap<>(4);
        }
    }

    public DataZoomSelect titleZoom(String zoom) {
        initTitleMap();
        title.put("zoom", zoom);
        return this;
    }

    public DataZoomSelect titleBack(String back) {
        initTitleMap();
        title.put("back", back);
        return this;
    }

    public DataZoomSelect iconZoom(String zoom) {
        initIconMap();
        icon.put("zoom", zoom);
        return this;
    }

    public DataZoomSelect iconBack(String back) {
        initIconMap();
        icon.put("back", back);
        return this;
    }

    public DataZoomSelect normalStyle(ShapeStyle normal) {
        initIconStyleMap();
        iconStyle.put("normal", normal);
        return this;
    }

    public DataZoomSelect emphasisStyle(ShapeStyle emphasis) {
        initIconStyleMap();
        iconStyle.put("emphasis", emphasis);
        return this;
    }

    @Override
    @JsonIgnore
    public DataZoomType getType() {
        return super.getType();
    }

    public Map<String, String> getTitle() {
        return title;
    }

    public void setTitle(Map<String, String> title) {
        this.title = title;
    }

    public Map<String, String> getIcon() {
        return icon;
    }

    public void setIcon(Map<String, String> icon) {
        this.icon = icon;
    }

    public Map<String, ShapeStyle> getIconStyle() {
        return iconStyle;
    }

    public void setIconStyle(Map<String, ShapeStyle> iconStyle) {
        this.iconStyle = iconStyle;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof DataZoomSelect)) return false;
        if (!super.equals(o)) return false;
        DataZoomSelect that = (DataZoomSelect) o;
        return Objects.equals(title, that.title) &&
                Objects.equals(icon, that.icon) &&
                Objects.equals(iconStyle, that.iconStyle);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), title, icon, iconStyle);
    }

    public String toString(boolean pretty) {
        Map<String, Object> last = new LinkedHashMap<>();
        last.put("title", getTitle());
        last.put("icon", getIcon());
        last.put("iconStyle", getIconStyle());
        return super.toString(null, last, pretty);
    }

    @Override
    public String toString() {
        return toString(false);
    }
}
