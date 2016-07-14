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
 * 连续型视觉映射组件。
 *
 * @author Fuchun
 * @since 1.0
 */
public class ContinuousVisualMap extends VisualMap<ContinuousVisualMap> {

    private static final long serialVersionUID = 8674389302959997225L;

    /* 指定手柄对应数值的位置。range 应在 min max 范围内。 */
    private int[] range;
    /* 是否显示拖拽用的手柄（手柄能拖拽调整选中范围）。默认：false */
    private Boolean calculable;
    /* 拖拽时，是否实时更新。默认：true */
    private Boolean realtime;

    public ContinuousVisualMap() {
        super("continuous");
    }

    public ContinuousVisualMap initRange(int lower, int upper) {
        if (hasLimitedRange()) {  // min != null && max != null
            if (lower < getMin() || upper > getMax()) {
                throw new IllegalArgumentException(String.format(
                        "The initialized range must be in [%d, %d]", getMin(), getMax()));
            }
        }
        this.range = new int[]{lower, upper};
        return this;
    }

    public int[] getRange() {
        return range;
    }

    public void setRange(int[] range) {
        this.range = range;
    }

    public Boolean getCalculable() {
        return calculable;
    }

    public void setCalculable(Boolean calculable) {
        this.calculable = calculable;
    }

    public Boolean getRealtime() {
        return realtime;
    }

    public void setRealtime(Boolean realtime) {
        this.realtime = realtime;
    }
}
