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

package org.aying.echarts.style.font;

/**
 * 字体粗细样式。
 *
 * @author Fuchun
 * @since 1.0
 */
public enum FontWeight {

    /**
     * 正常大小。
     */
    normal,

    /**
     * 粗体字。
     */
    bold,

    /**
     * 比粗体更粗。
     */
    bolder,

    /**
     * 比正常字体细。
     */
    lighter;

    public static final int W100 = 100;
    public static final int W200 = 200;
    public static final int W300 = 300;
    public static final int W400 = 400;
    public static final int W500 = 500;
    public static final int W600 = 600;
    public static final int W700 = 700;
    public static final int W800 = 800;
    public static final int W900 = 900;

    protected static final int[] NUM_WEIGHTS = {
            W100, W200, W300, W400, W500, W600, W700, W800, W900
    };

    public static int[] weights() {
        int[] weights = new int[NUM_WEIGHTS.length];
        System.arraycopy(NUM_WEIGHTS, 0, weights, 0, NUM_WEIGHTS.length);
        return weights;
    }
}
