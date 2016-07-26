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

import java.util.Objects;

/**
 * The base implementation of the {@code Component}
 *
 * @author Fuchun
 * @since 1.0
 */
public abstract class BaseComponent<C extends BaseComponent<C>> implements Component<C> {

    private static final long serialVersionUID = 1L;

    /** 是否显示组件（标签、文本、图形、线条等） */
    protected Boolean show;

    protected BaseComponent() {
        super();
    }

    protected BaseComponent(Boolean show) {
        this.show = show;
    }

    @Override
    public Boolean getShow() {
        return show;
    }

    @Override
    public void setShow(Boolean show) {
        this.show = show;
    }

    @SuppressWarnings("unchecked")
    protected C me() {
        return (C) this;
    }

    @Override
    public C hide() {
        this.show = Boolean.FALSE;
        return  me();
    }

    @Override
    public C show() {
        this.show = Boolean.TRUE;
        return  me();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof BaseComponent)) return false;
        BaseComponent that = (BaseComponent) o;
        return Objects.equals(show, that.show);
    }

    @Override
    public int hashCode() {
        return Objects.hash(show);
    }

    @Override
    public String toString() {
        return String.format("org.aying.echarts.BaseComponent{show=%s}", show);
    }
}
