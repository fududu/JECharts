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

package org.aying.echarts.series;

import java.util.List;
import java.util.Objects;

/**
 * @author Fuchun
 * @since 1.0
 */
public class LinesSerieData extends SerieData {

    private static final long serialVersionUID = 7622363659612498355L;
    private List<Object[]> coords;

    public LinesSerieData() {
        super();
    }

    public List<Object[]> getCoords() {
        return coords;
    }

    public void setCoords(List<Object[]> coords) {
        this.coords = coords;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof LinesSerieData)) return false;
        if (!super.equals(o)) return false;
        LinesSerieData that = (LinesSerieData) o;
        return Objects.equals(coords, that.coords);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), coords);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder(32)
                .append(getClass()).append("{");
        sb.append("coords=").append(coords);
        sb.append("} ").append(super.toString());
        return sb.toString();
    }
}
