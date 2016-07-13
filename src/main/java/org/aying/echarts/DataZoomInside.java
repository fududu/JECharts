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

import org.aying.echarts.base.FilterMode;
import org.aying.echarts.base.Orient;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;

/**
 * 内置型数据区域缩放组件配置。所谓『内置』，即内置在坐标系中。
 * <ul>
 * <li>平移：在坐标系中滑动拖拽进行数据区域平移。</li>
 * <li>缩放：
 * <ul>
 * <li>PC端：鼠标在坐标系范围内滚轮滚动（MAC触控板类同）</li>
 * <li>移动端：在移动端触屏上，支持两指滑动缩放。</li>
 * </ul>
 * </li>
 * </ul>
 *
 * @author Fuchun
 * @since 1.0
 */
public class DataZoomInside extends DataZoom {

    private static final long serialVersionUID = -2382724220047595212L;

    private Object angleAxisIndex;
    private Object radiusAxisIndex;
    private FilterMode filterMode;
    /* 数据窗口范围的起始百分比。范围是：0 ~ 100。表示 0% ~ 100%。默认：0 */
    private Integer start;
    /* 数据窗口范围的结束百分比。范围是：0 ~ 100。默认：100 */
    private Integer end;
    /* 数据窗口范围的起始数值。如果设置了 dataZoom-inside.start 则 startValue 失效。 */
    private Object startValue;
    /* 数据窗口范围的结束数值。如果设置了 dataZoom-inside.end 则 endValue 失效。 */
    private Object endValue;
    /* 数据窗口范围的结束数值。如果设置了 dataZoom-inside.end 则 endValue 失效。 */
    private Orient orient;
    /* 是否锁定选择区域（或叫做数据窗口）的大小。默认：false */
    private Boolean zoomLock;
    /* 设置触发视图刷新的频率。单位为毫秒（ms）。默认：100 */
    private Integer throttle;

    public DataZoomInside() {
        this(DataZoomType.inside);
    }

    protected DataZoomInside(DataZoomType type) {
        super(type);
    }

    public Object getAngleAxisIndex() {
        return angleAxisIndex;
    }

    public void setAngleAxisIndex(Object angleAxisIndex) {
        this.angleAxisIndex = angleAxisIndex;
    }

    public Object getRadiusAxisIndex() {
        return radiusAxisIndex;
    }

    public void setRadiusAxisIndex(Object radiusAxisIndex) {
        this.radiusAxisIndex = radiusAxisIndex;
    }

    public FilterMode getFilterMode() {
        return filterMode;
    }

    public void setFilterMode(FilterMode filterMode) {
        this.filterMode = filterMode;
    }

    public Integer getStart() {
        return start;
    }

    public void setStart(Integer start) {
        this.start = start;
    }

    public Integer getEnd() {
        return end;
    }

    public void setEnd(Integer end) {
        this.end = end;
    }

    public Object getStartValue() {
        return startValue;
    }

    public void setStartValue(Object startValue) {
        this.startValue = startValue;
    }

    public Object getEndValue() {
        return endValue;
    }

    public void setEndValue(Object endValue) {
        this.endValue = endValue;
    }

    public Orient getOrient() {
        return orient;
    }

    public void setOrient(Orient orient) {
        this.orient = orient;
    }

    public Boolean getZoomLock() {
        return zoomLock;
    }

    public void setZoomLock(Boolean zoomLock) {
        this.zoomLock = zoomLock;
    }

    public Integer getThrottle() {
        return throttle;
    }

    public void setThrottle(Integer throttle) {
        this.throttle = throttle;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof DataZoomInside)) return false;
        if (!super.equals(o)) return false;
        DataZoomInside that = (DataZoomInside) o;
        return Objects.equals(angleAxisIndex, that.angleAxisIndex) &&
                Objects.equals(radiusAxisIndex, that.radiusAxisIndex) &&
                filterMode == that.filterMode &&
                Objects.equals(start, that.start) &&
                Objects.equals(end, that.end) &&
                Objects.equals(startValue, that.startValue) &&
                Objects.equals(endValue, that.endValue) &&
                orient == that.orient &&
                Objects.equals(zoomLock, that.zoomLock) &&
                Objects.equals(throttle, that.throttle);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), angleAxisIndex, radiusAxisIndex, filterMode, start, end,
                startValue, endValue, orient, zoomLock, throttle);
    }

    protected Map<String, Object> asMapInner() {
        Map<String, Object> last = new LinkedHashMap<>();
        last.put("angleAxisIndex", getAngleAxisIndex());
        last.put("radiusAxisIndex", getRadiusAxisIndex());
        last.put("filterMode", getFilterMode());
        last.put("start", getStart());
        last.put("end", getEnd());
        last.put("startValue", getStartValue());
        last.put("endValue", getEndValue());
        last.put("orient", getOrient());
        last.put("zoomLock", getZoomLock());
        last.put("throttle", getThrottle());
        return last;
    }

    public String toString(boolean pretty) {
        return toString(null, asMapInner(), pretty);
    }

    @Override
    public String toString() {
        return toString(false);
    }
}
