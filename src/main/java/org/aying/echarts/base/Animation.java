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
 * 动画配置接口。
 *
 * @author Fuchun
 * @since 1.0
 */
public interface Animation {

    /***
     * 是否开启动画，默认开启。
     */
    Boolean getAnimation();

    /**
     * 是否开启动画的阈值，当显示的图形数量大于这个阈值时会关闭动画。
     */
    Integer getAnimationThreshold();

    /**
     * 初始动画的时长。
     */
    Integer getAnimationDuration();

    /**
     * 初始动画的缓动效果。
     */
    AnimationEasing getAnimationEasing();

    /**
     * 初始动画的延迟，支持回调函数，可以通过每个数据返回不同的{@code delay} 时间实现更戏剧的初始动画效果。
     */
    Object getAnimationDelay();

    /**
     * 数据更新动画的时长。
     */
    Integer getAnimationDurationUpdate();

    /**
     * 数据更新动画的缓动效果。
     */
    AnimationEasing getAnimationEasingUpdate();

    /**
     * 数据更新动画的延迟，支持回调函数，可以通过每个数据返回不同的{@code delay} 时间实现更戏剧的更新动画效果。
     */
    Object getAnimationDelayUpdate();
}
