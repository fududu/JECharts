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

/**
 * ECharts 网络选项模型。
 * 直角坐标系内绘图网格，单个 grid 内最多可以放置上下两个 X 轴，左右两个 Y 轴。
 *
 * @author Fuchun
 * @since 1.0
 */
public class Grid extends BaseProp<Grid> {

    private static final long serialVersionUID = 7959187036320536290L;

    private Object width;
    private Object height;
    private Boolean containLabel;

    public Grid() {
        super();
    }

    public Grid width(int width) {
        this.width = width;
        return this;
    }

    public Grid autoWidth() {
        this.width = "auto";
        return this;
    }

    public Grid height(int height) {
        this.height = height;
        return this;
    }

    public Grid autoHeight() {
        this.height = "auto";
        return this;
    }

    public Grid containLabel() {
        this.containLabel = true;
        return this;
    }

    public Object getWidth() {
        return width;
    }

    public void setWidth(Object width) {
        this.width = width;
    }

    public Object getHeight() {
        return height;
    }

    public void setHeight(Object height) {
        this.height = height;
    }

    public Boolean getContainLabel() {
        return containLabel;
    }

    public void setContainLabel(Boolean containLabel) {
        this.containLabel = containLabel;
    }
}
