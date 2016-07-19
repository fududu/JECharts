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

import org.aying.echarts.base.ImageType;
import org.jetbrains.annotations.Contract;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

/**
 * 保存为图片（工具栏）。
 *
 * @author Fuchun
 * @since 1.0
 */
public class SaveAsImage extends BaseFeature<SaveAsImage> {

    private static final long serialVersionUID = 2614123159951287553L;

    public static SaveAsImage png() {
        return new SaveAsImage();
    }

    public static SaveAsImage jpeg() {
        return new SaveAsImage().toJpeg();
    }

    private ImageType type;
    /* 保存的文件名称。不设置时，默认使用 title.text 作为名称 */
    private String name;
    /* 保存的图片背景色，默认使用 backgroundColor，如果backgroundColor不存在的话会取白色。 */
    private String backgroundColor;
    /* 保存为图片时忽略的组件列表，默认忽略工具栏。 */
    private List<String> excludeComponents;

    /* 保存图片的分辨率比例，默认跟容器相同大小，如果需要保存更高分辨率的，可以设置为大于 1 的值，例如 2。 */
    private Integer pixelRatio;

    public SaveAsImage() {
        super();
    }

    /**
     * 设置保存图片格式为{@code jpeg}，不设置时保存为{@code png}。
     */
    public SaveAsImage toJpeg() {
        this.type = ImageType.jpeg;
        return this;
    }

    public SaveAsImage name(String name) {
        this.name = name;
        return this;
    }

    public SaveAsImage bgColor(String bgColor) {
        this.backgroundColor = bgColor;
        return this;
    }

    public SaveAsImage excludes(String c1, String... cn) {
        Objects.requireNonNull(c1, "component");
        if (excludeComponents == null) {
            excludeComponents = new ArrayList<>();
        }
        excludeComponents.add(c1);
        if (cn != null && cn.length > 0)
        Collections.addAll(excludeComponents, cn);
        return this;
    }

    @Contract("null -> fail")
    public SaveAsImage title(String title) {
        Objects.requireNonNull(title, "title");
        return super.title(title);
    }

    public SaveAsImage pixelRatio(int pixelRatio) {
        this.pixelRatio = pixelRatio;
        return this;
    }

    public ImageType getType() {
        return type;
    }

    public void setType(ImageType type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBackgroundColor() {
        return backgroundColor;
    }

    public void setBackgroundColor(String backgroundColor) {
        this.backgroundColor = backgroundColor;
    }

    public List<String> getExcludeComponents() {
        return excludeComponents;
    }

    public void setExcludeComponents(List<String> excludeComponents) {
        this.excludeComponents = excludeComponents;
    }

    public Integer getPixelRatio() {
        return pixelRatio;
    }

    public void setPixelRatio(Integer pixelRatio) {
        this.pixelRatio = pixelRatio;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof SaveAsImage)) return false;
        if (!super.equals(o)) return false;
        SaveAsImage that = (SaveAsImage) o;
        return type == that.type &&
                Objects.equals(name, that.name) &&
                Objects.equals(backgroundColor, that.backgroundColor) &&
                Objects.equals(excludeComponents, that.excludeComponents) &&
                Objects.equals(pixelRatio, that.pixelRatio);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), type, name, backgroundColor, excludeComponents, pixelRatio);
    }

    @Override
    public String toString() {
        return "SaveAsImage{" +
                "type=" + type +
                ", name='" + name + '\'' +
                ", backgroundColor='" + backgroundColor + '\'' +
                ", excludeComponents=" + excludeComponents +
                ", pixelRatio=" + pixelRatio +
                "} " + super.toString();
    }
}
