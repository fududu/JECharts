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

import org.jetbrains.annotations.Contract;

import java.util.Objects;

/**
 * 配置项还原。
 *
 * @author Fuchun
 * @since 1.0
 */
public class Restore extends BaseFeature<Restore> {

    private static final long serialVersionUID = 563223472150722285L;

    public Restore() {
        super();
    }

    @Contract("null -> fail")
    public Restore title(String title) {
        Objects.requireNonNull(title, "title");
        return super.title(title);
    }

    @Override
    public String toString() {
        return "Restore{} " + super.toString();
    }
}
