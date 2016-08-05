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

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import org.aying.echarts.axis.AxisType;
import org.aying.echarts.base.*;
import org.aying.echarts.data.DataAware;
import org.aying.echarts.data.SimpleDataAware;
import org.aying.echarts.data.TimelineData;
import org.aying.echarts.json.converter.TimelineDataConverter;
import org.aying.echarts.json.converter.ToTimelineDataConverter;
import org.aying.echarts.style.CheckpointStyle;
import org.aying.echarts.style.ControlStyle;
import org.aying.echarts.style.LineStyle;
import org.aying.echarts.style.StateShapeStyle;

import java.util.List;
import java.util.Objects;

/**
 * {@code Timeline} 组件，提供了在多个 ECharts option 间进行切换、播放等操作的功能。
 *
 * @author Fuchun
 * @since 1.0
 */
public class Timeline extends Graph<Timeline>
        implements Symbol<Timeline>, DataAware<TimelineData, Timeline> {

    private static final long serialVersionUID = 642119678303367107L;

    private final SimpleDataAware<TimelineData> sda;
    @JsonIgnore
    private final SimpleSymbol simpleSymbol;

    private final String type;
    /* 是否显示组件。默认：true */
    private Boolean show;
    private AxisType axisType;
    /* 表示当前选中项是哪项。 */
    private Integer currentIndex;
    /* 表示是否自动播放。默认：false */
    private Boolean autoPlay;
    /* 表示是否反向播放。默认：false */
    private Boolean rewind;
    /* 表示是否循环播放。默认：true */
    private Boolean loop;
    /* 表示播放的速度（跳动的间隔），单位毫秒（ms）。默认：2000 */
    private Integer playInterval;
    /* 拖动圆点的时候，是否实时更新视图。默认：true */
    private Boolean realtime;
    /* 表示『播放』按钮的位置。仅支持：left, right */
    private Align controlPosition;
    /* timeline内边距，单位px，默认各方向内边距为5，接受数组分别设定上右下左边距。 */
    private Object padding;
    /* 摆放方式。默认：horizontal */
    private Orient orient;
    /* 是否反向放置 timeline，反向则首位颠倒过来。默认：false */
    private Boolean inverse;
    /* 轴线样式。 */
    private LineStyle lineStyle;
    /* 轴的文本标签。 */
    private TimelineLabel label;
    /* Timeline 图形样式，有 normal 和 emphasis 两个状态。 */
    private StateShapeStyle itemStyle;
    /* 当前项』（checkpoint）的图形样式。 */
    private CheckpointStyle checkpointStyle;
    /* 『控制按钮』的样式。『控制按钮』包括：『播放按钮』、『前进按钮』、『后退按钮』。 */
    private ControlStyle controlStyle;

    public Timeline() {
        this.sda = new SimpleDataAware<>();
        this.simpleSymbol = new SimpleSymbol();
        // 目前只支持一个单独的值。
        this.type = "slider";
    }

    public String getType() {
        return type;
    }

    public Boolean getShow() {
        return show;
    }

    public void setShow(Boolean show) {
        this.show = show;
    }

    public AxisType getAxisType() {
        return axisType;
    }

    public void setAxisType(AxisType axisType) {
        this.axisType = axisType;
    }

    public Integer getCurrentIndex() {
        return currentIndex;
    }

    public void setCurrentIndex(Integer currentIndex) {
        this.currentIndex = currentIndex;
    }

    public Boolean getAutoPlay() {
        return autoPlay;
    }

    public void setAutoPlay(Boolean autoPlay) {
        this.autoPlay = autoPlay;
    }

    public Boolean getRewind() {
        return rewind;
    }

    public void setRewind(Boolean rewind) {
        this.rewind = rewind;
    }

    public Boolean getLoop() {
        return loop;
    }

    public void setLoop(Boolean loop) {
        this.loop = loop;
    }

    public Integer getPlayInterval() {
        return playInterval;
    }

    public void setPlayInterval(Integer playInterval) {
        this.playInterval = playInterval;
    }

    public Boolean getRealtime() {
        return realtime;
    }

    public void setRealtime(Boolean realtime) {
        this.realtime = realtime;
    }

    public Align getControlPosition() {
        return controlPosition;
    }

    public void setControlPosition(Align controlPosition) {
        this.controlPosition = controlPosition;
    }

    public Object getPadding() {
        return padding;
    }

    public void setPadding(Object padding) {
        this.padding = padding;
    }

    public Orient getOrient() {
        return orient;
    }

    public void setOrient(Orient orient) {
        this.orient = orient;
    }

    public Boolean getInverse() {
        return inverse;
    }

    public void setInverse(Boolean inverse) {
        this.inverse = inverse;
    }

    @Override
    public SymbolType getSymbol() {
        return simpleSymbol.getSymbol();
    }

    public void setSymbol(SymbolType symbol) {
        simpleSymbol.setSymbol(symbol);
    }

    @Override
    public Object getSymbolSize() {
        return simpleSymbol.getSymbolSize();
    }

    public void setSymbolSize(Object symbolSize) {
        simpleSymbol.setSymbolSize(symbolSize);
    }

    @Override
    public Integer getSymbolRotate() {
        return simpleSymbol.getSymbolRotate();
    }

    public void setSymbolRotate(Integer symbolRotate) {
        simpleSymbol.setSymbolRotate(symbolRotate);
    }

    @Override
    public Object[] getSymbolOffset() {
        return simpleSymbol.getSymbolOffset();
    }

    public void setSymbolOffset(Object[] offset) {
        simpleSymbol.setSymbolOffset(offset);
    }

    public LineStyle getLineStyle() {
        return lineStyle;
    }

    public void setLineStyle(LineStyle lineStyle) {
        this.lineStyle = lineStyle;
    }

    public TimelineLabel getLabel() {
        return label;
    }

    public void setLabel(TimelineLabel label) {
        this.label = label;
    }

    public StateShapeStyle getItemStyle() {
        return itemStyle;
    }

    public void setItemStyle(StateShapeStyle itemStyle) {
        this.itemStyle = itemStyle;
    }

    public CheckpointStyle getCheckpointStyle() {
        return checkpointStyle;
    }

    public void setCheckpointStyle(CheckpointStyle checkpointStyle) {
        this.checkpointStyle = checkpointStyle;
    }

    public ControlStyle getControlStyle() {
        return controlStyle;
    }

    public void setControlStyle(ControlStyle controlStyle) {
        this.controlStyle = controlStyle;
    }

    @Override
    public Timeline symbol(SymbolType symbolType) {
        simpleSymbol.symbol(symbolType);
        return this;
    }

    @Override
    public Timeline symbolSize(Integer size) {
        simpleSymbol.symbolSize(size);
        return this;
    }

    @Override
    public Timeline symbolSize(int w, int h) {
        simpleSymbol.symbolSize(w, h);
        return this;
    }

    @Override
    public Timeline symbolRotate(Integer rotate) {
        simpleSymbol.setSymbolRotate(rotate);
        return this;
    }

    @Override
    public Timeline offset(Object x, Object y) {
        simpleSymbol.offset(x, y);
        return this;
    }

    @Override
    public Timeline addData(TimelineData data) {
        sda.addData(data);
        return this;
    }

    @Override
    public Timeline addData(TimelineData d1, TimelineData d2, TimelineData... dn) {
        sda.addData(d1, d2, dn);
        return this;
    }

    @Override
    @JsonSerialize(contentConverter = TimelineDataConverter.class)
    public List<TimelineData> getData() {
        return sda.getData();
    }

    @JsonDeserialize(contentConverter = ToTimelineDataConverter.class)
    public void setData(List<TimelineData> data) {
        sda.setData(data);
    }

    public static class TimelineLabel extends State<TimelineLabel, SimpleLabel> {

        private static final long serialVersionUID = -1569691190499663962L;
        private Object position;

        public TimelineLabel() {
            super();
        }

        public Object getPosition() {
            return position;
        }

        public void setPosition(Object position) {
            this.position = position;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof TimelineLabel)) return false;
            if (!super.equals(o)) return false;
            TimelineLabel that = (TimelineLabel) o;
            return Objects.equals(position, that.position);
        }

        @Override
        public int hashCode() {
            return Objects.hash(super.hashCode(), position);
        }

        @Override
        public String toString() {
            final StringBuilder sb = new StringBuilder(32)
                    .append(getClass()).append("{");
            sb.append("position=").append(position);
            sb.append("} ").append(super.toString());
            return sb.toString();
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Timeline)) return false;
        if (!super.equals(o)) return false;
        Timeline timeline = (Timeline) o;
        return Objects.equals(sda, timeline.sda) &&
                Objects.equals(type, timeline.type) &&
                Objects.equals(simpleSymbol, timeline.simpleSymbol) &&
                Objects.equals(show, timeline.show) &&
                axisType == timeline.axisType &&
                Objects.equals(currentIndex, timeline.currentIndex) &&
                Objects.equals(autoPlay, timeline.autoPlay) &&
                Objects.equals(rewind, timeline.rewind) &&
                Objects.equals(loop, timeline.loop) &&
                Objects.equals(playInterval, timeline.playInterval) &&
                Objects.equals(realtime, timeline.realtime) &&
                controlPosition == timeline.controlPosition &&
                Objects.equals(padding, timeline.padding) &&
                orient == timeline.orient &&
                Objects.equals(inverse, timeline.inverse) &&
                Objects.equals(lineStyle, timeline.lineStyle) &&
                Objects.equals(label, timeline.label) &&
                Objects.equals(itemStyle, timeline.itemStyle) &&
                Objects.equals(checkpointStyle, timeline.checkpointStyle) &&
                Objects.equals(controlStyle, timeline.controlStyle);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), sda, type, simpleSymbol, show, axisType,
                currentIndex, autoPlay, rewind, loop, playInterval, realtime, controlPosition, padding,
                orient, inverse, lineStyle, label, itemStyle, checkpointStyle, controlStyle);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder(64)
                .append(getClass()).append("{");
        sb.append("show=").append(show);
        sb.append(", type='").append(type).append('\'');
        sb.append(", axisType=").append(axisType);
        sb.append(", currentIndex=").append(currentIndex);
        sb.append(", autoPlay=").append(autoPlay);
        sb.append(", rewind=").append(rewind);
        sb.append(", loop=").append(loop);
        sb.append(", playInterval=").append(playInterval);
        sb.append(", realtime=").append(realtime);
        sb.append(", controlPosition=").append(controlPosition);
        appendToString(sb);
        sb.append(", padding=").append(padding);
        sb.append(", orient=").append(orient);
        sb.append(", inverse=").append(inverse);
        sb.append(", ");
        simpleSymbol.appendToString(sb);
        sb.append(", lineStyle=").append(lineStyle);
        sb.append(", label=").append(label);
        sb.append(", itemStyle=").append(itemStyle);
        sb.append(", checkpointStyle=").append(checkpointStyle);
        sb.append(", controlStyle=").append(controlStyle);
        sb.append(", data=").append(getData());
        sb.append('}');
        return sb.toString();
    }
}
