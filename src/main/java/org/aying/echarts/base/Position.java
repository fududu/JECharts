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

package org.aying.echarts.base;

/**
 * 组件（图形）相对于容器的位置。
 * 设置组件相对于容器的位置时，通常只会设置两个属性，例如：{@code left, top}；{@code top, right} ...
 * 大部份时候，{@code left, right, top, bottom} 的默认值会是{@code auto} 或者0。
 *
 * @author Fuchun
 * @since 1.0
 */
public interface Position<P extends Position<P>> {

    /**
     * 组件离容器左侧的距离。
     */
    Object getLeft();

    /**
     * 组件离容器右侧的距离。
     */
    Object getRight();

    /**
     * 组件离容器上侧的距离。
     */
    Object getTop();

    /**
     * 组件离容器下侧的距离。
     */
    Object getBottom();

    /**
     * 设置组件离容器左侧的距离。
     * {@code left} 值可以是像{@code 20} 这样的具体像素值，可以是像{@code '20%'} 这样相对于容器高宽的百分比，
     * 也可以是 {@link Align#left}、{@link Align#center} 或{@link Align#right}。
     *
     * @param left 组件离容器左侧的距离。
     * @return 返回{@code Position} 的实现本身。
     * @throws IllegalArgumentException 如果{@code left} 值不合法。
     */
    P left(Object left);

    /**
     * 设置组件离容器右侧的距离。
     * <p />
     * {@code right} 值可以是像{@code 20} 这样的具体像素值，可以是像{@code '20%'} 这样相对于容器高宽的百分比。
     *
     * @param right 组件离容器右侧的距离。
     * @return 返回{@code Position} 的实现本身。
     * @throws IllegalArgumentException 如果{@code right} 值不合法。
     */
    P right(Object right);

    /**
     * 设置组件离容器上侧的距离。
     * <p />
     * {@code top} 值可以是像{@code 20} 这样的具体像素值，可以是像{@code '20%'} 这样相对于容器高宽的百分比，
     * 也可以是 {@link Baseline#top}、{@link Baseline#middle} 或{@link Baseline#bottom}。
     *
     * @param top 组件离容器上侧的距离。
     * @return 返回{@code Position} 的实现本身。
     * @throws IllegalArgumentException 如果{@code top} 值不合法。
     */
    P top(Object top);

    /**
     * 设置组件离容器下侧的距离。
     * <p />
     * {@code bottom} 值可以是像{@code 20} 这样的具体像素值，可以是像{@code '20%'} 这样相对于容器高宽的百分比。
     *
     * @param bottom 组件离容器下侧的距离。
     * @return 返回{@code Position} 的实现本身。
     * @throws IllegalArgumentException 如果{@code bottom} 值不合法。
     */
    P bottom(Object bottom);

    default P leftTop(Object left, Object top) {
        return left(left).top(top);
    }

    default P leftBottom(Object left, Object bottom) {
        return left(left).bottom(bottom);
    }

    default P topRight(Object top, Object right) {
        return top(top).right(right);
    }

    default P rightBottom(Object right, Object bottom) {
        return right(right).bottom(bottom);
    }
}
