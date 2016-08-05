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

import java.io.Serializable;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

/**
 * {@code Timeline} 选项配置模型。
 *
 * @author Fuchun
 * @since 1.0
 */
public class TimelineOption implements Serializable {

    private static final long serialVersionUID = -3647901989895839025L;

    private Option baseOption;
    private List<Option> options;

    public TimelineOption() {
        super();
    }

    public TimelineOption base(Option baseOption) {
        this.baseOption = baseOption;
        return this;
    }

    public TimelineOption options(Collection<Option> options) {
        if (options == null || options.isEmpty()) {
            this.options = null;
            return this;
        }
        if (options instanceof List) {
            this.options = (List<Option>) options;
        } else {
            this.options = new LinkedList<>(options);
        }
        return this;
    }

    public Option getBaseOption() {
        return baseOption;
    }

    public void setBaseOption(Option baseOption) {
        this.baseOption = baseOption;
    }

    public List<Option> getOptions() {
        return options;
    }

    public void setOptions(List<Option> options) {
        this.options = options;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof TimelineOption)) return false;
        TimelineOption that = (TimelineOption) o;
        return Objects.equals(baseOption, that.baseOption) &&
                Objects.equals(options, that.options);
    }

    @Override
    public int hashCode() {
        return Objects.hash(baseOption, options);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder(32)
                .append(getClass()).append("{");
        sb.append("baseOption=").append(baseOption);
        sb.append(", options=").append(options);
        sb.append('}');
        return sb.toString();
    }
}
