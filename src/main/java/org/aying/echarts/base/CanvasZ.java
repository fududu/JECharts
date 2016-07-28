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
 * {@code CanvasZ} 接口表示图形分层或前后叠加顺序。
 *
 * @author Fuchun
 * @since 1.0
 */
public interface CanvasZ<Z extends CanvasZ<Z>> {

    String KEY_Z_LEVEL = "zlevel";
    String KEY_Z = "z";

    /**
     * 所有图形的{@code zlevel} 值。
     */
    Integer getZlevel();

    void setZlevel(Integer zlevel);

    /**
     * 组件的所有图形的{@code z} 值。
     */
    Integer getZ();

    void setZ(Integer z);

    /**
     * 设置所有图形的{@code zlevel} 值。
     * <p />
     * {@code zlevel} 用于 Canvas 分层，不同{@code zlevel} 值的图形会放置在不同的 Canvas 中，Canvas 分层是一种常见的优化手段。
     * 我们可以把一些图形变化频繁（例如有动画）的组件设置成一个单独的{@code zlevel}。
     *
     * @param zLevel 所有图形的{@code zlevel} 值。
     * @return  返回{@code CanvasZ} 的实现本身。
     */
    Z zLevel(int zLevel);

    /**
     * 设置组件的所有图形的{@code z} 值。
     * <p />
     * 控制图形的前后顺序。{@code z} 值小的图形会被{@code z} 值大的图形覆盖。
     * {@code z} 相比{@code zlevel} 优先级更低，而且不会创建新的 Canvas。
     *
     * @param z 组件的所有图形的{@code z} 值。
     * @return  返回{@code CanvasZ} 的实现本身。
     */
    Z z(int z);
}
