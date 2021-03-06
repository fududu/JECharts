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

/**
 * 标题组件，包含主标题和副标题。
 *
 * @author Fuchun
 * @since 1.0
 */
public class Title extends BaseProp<Title> {

    private static final long serialVersionUID = 4851252376021617760L;

    public Title() {
        super();
    }

    @Override
    public Title autoWidth() {
        return this;
    }

    @Override
    public Title autoHeight() {
        return this;
    }

    @Override
    public Title width(int width) {
        return this;
    }

    @Override
    public Title width(String width) {
        return this;
    }

    @Override
    public Title height(int height) {
        return this;
    }

    @Override
    public Title height(String height) {
        return this;
    }

    @Override
    @JsonIgnore
    public Object getWidth() {
        // title 不支持设置宽度
        return null;
    }

    @Override
    public void setWidth(Object width) {
        // title 不支持设置宽度
    }

    @Override
    @JsonIgnore
    public Object getHeight() {
        // title 不支持设置高度
        return null;
    }

    @Override
    public void setHeight(Object height) {
        // title 不支持设置高度
    }
}
