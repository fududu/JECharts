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

import org.aying.echarts.style.BorderStyle;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * @author Fuchun
 * @since 1.0
 */
public abstract class BaseFeature<F extends BaseFeature<F>> implements Serializable {

    private static final long serialVersionUID = 1L;

    /* 是否显示该工具。默认：true */
    private Boolean show;
    /* 工具栏提示标题。 */
    private Object title;
    /* Icon 的 path */
    private Object icon;
    /* 保存为图片 icon 样式设置。 */
    private Map<String, BorderStyle> iconStyle;

    protected BaseFeature() {
        super();
    }

    @SuppressWarnings("unchecked")
    protected F me() {
        return (F) this;
    }

    public <T> F title(T title) {
        this.title = title;
        return me();
    }

    /**
     * 不显示该工具。
     */
    public F hide() {
        this.show = Boolean.FALSE;
        return me();
    }

    public F normalStyle(BorderStyle normal) {
        Objects.requireNonNull(normal, "iconStyle.normal");
        if (iconStyle == null) {
            iconStyle = new HashMap<>(2);
        }
        iconStyle.put("normal", normal);
        return me();
    }

    public F emphasisStyle(BorderStyle emphasis) {
        Objects.requireNonNull(emphasis, "iconStyle.emphasis");
        if (iconStyle == null) {
            iconStyle = new HashMap<>(2);
        }
        iconStyle.put("emphasis", emphasis);
        return me();
    }

    public Boolean getShow() {
        return show;
    }

    public void setShow(Boolean show) {
        this.show = show;
    }

    public Object getTitle() {
        return title;
    }

    public void setTitle(Object title) {
        this.title = title;
    }

    public Object getIcon() {
        return icon;
    }

    public void setIcon(Object icon) {
        this.icon = icon;
    }

    public Map<String, BorderStyle> getIconStyle() {
        return iconStyle;
    }

    public void setIconStyle(Map<String, BorderStyle> iconStyle) {
        this.iconStyle = iconStyle;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof BaseFeature)) return false;
        BaseFeature<?> that = (BaseFeature<?>) o;
        return Objects.equals(show, that.show) &&
                Objects.equals(title, that.title) &&
                Objects.equals(icon, that.icon) &&
                Objects.equals(iconStyle, that.iconStyle);
    }

    @Override
    public int hashCode() {
        return Objects.hash(show, title, icon, iconStyle);
    }
}
