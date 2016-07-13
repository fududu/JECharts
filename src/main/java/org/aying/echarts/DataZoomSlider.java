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

import org.aying.echarts.base.DataBackground;
import org.aying.echarts.style.BorderStyle;

import java.time.format.TextStyle;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;

/**
 * 滑动条型数据区域缩放组件。
 *
 * @author Fuchun
 * @since 1.0
 */
public class DataZoomSlider extends DataZoomInside {

    private static final long serialVersionUID = 2369457355287996613L;

    /* 组件的背景颜色。默认：rgba(47,69,84,0) */
    private String backgroundColor;
    /* 数据阴影的样式。 */
    private DataBackground dataBackground;
    /* 选中范围的填充颜色。默认：rgba(167,183,204,0.4) */
    private String fillerColor;
    /* 边框颜色。默认：#DDDDDD */
    private String borderColor;
    /* 手柄的 icon 形状，支持路径字符串。
     * 默认：M8.2,13.6V3.9H6.3v9.7H3.1v14.9h3.3v9.7h1.8v-9.7h3.3V13.6H8.2z M9.7,24.4H4.8v-1.4h4.9V24.4z M9.7,19.1H4.8v-1.4h4.9V19.1z */
    private String handleIcon;
    /* 控制手柄的尺寸，可以是像素大小，也可以是相对于 dataZoom 组件宽度的百分比，默认跟 dataZoom 宽度相同。 */
    private Object handleSize;
    /* 手柄的样式配置。 */
    private BorderStyle handleStyle;
    /* 显示label的小数精度。默认根据数据自动决定。 */
    private Object labelPrecision;
    /* 显示的label的格式化器。*/
    private Object labelFormatter;
    /* 是否显示label，即拖拽时候显示详细数值信息。默认：true */
    private Boolean showDetail;
    /* 是否在 dataZoom-slider 组件中显示数据阴影。数据阴影可以简单得反应数据走势。默认："auto" */
    private String showDataShadow;
    /* 拖动时，是否实时更新系列的视图。如果设置为 false，则只在拖拽结束的时候更新。默认：true */
    private Boolean realtime;
    private TextStyle textStyle;

    private Integer zlevel;
    private Integer z;
    private Object left;
    private Object right;
    private Object top;
    private Object bottom;

    public DataZoomSlider() {
        super(DataZoomType.slider);
    }

    public String getBackgroundColor() {
        return backgroundColor;
    }

    public void setBackgroundColor(String backgroundColor) {
        this.backgroundColor = backgroundColor;
    }

    public DataBackground getDataBackground() {
        return dataBackground;
    }

    public void setDataBackground(DataBackground dataBackground) {
        this.dataBackground = dataBackground;
    }

    public String getFillerColor() {
        return fillerColor;
    }

    public void setFillerColor(String fillerColor) {
        this.fillerColor = fillerColor;
    }

    public String getBorderColor() {
        return borderColor;
    }

    public void setBorderColor(String borderColor) {
        this.borderColor = borderColor;
    }

    public String getHandleIcon() {
        return handleIcon;
    }

    public void setHandleIcon(String handleIcon) {
        this.handleIcon = handleIcon;
    }

    public Object getHandleSize() {
        return handleSize;
    }

    public void setHandleSize(Object handleSize) {
        this.handleSize = handleSize;
    }

    public BorderStyle getHandleStyle() {
        return handleStyle;
    }

    public void setHandleStyle(BorderStyle handleStyle) {
        this.handleStyle = handleStyle;
    }

    public Object getLabelPrecision() {
        return labelPrecision;
    }

    public void setLabelPrecision(Object labelPrecision) {
        this.labelPrecision = labelPrecision;
    }

    public Object getLabelFormatter() {
        return labelFormatter;
    }

    public void setLabelFormatter(Object labelFormatter) {
        this.labelFormatter = labelFormatter;
    }

    public Boolean getShowDetail() {
        return showDetail;
    }

    public void setShowDetail(Boolean showDetail) {
        this.showDetail = showDetail;
    }

    public String getShowDataShadow() {
        return showDataShadow;
    }

    public void setShowDataShadow(String showDataShadow) {
        this.showDataShadow = showDataShadow;
    }

    public Boolean getRealtime() {
        return realtime;
    }

    public void setRealtime(Boolean realtime) {
        this.realtime = realtime;
    }

    public TextStyle getTextStyle() {
        return textStyle;
    }

    public void setTextStyle(TextStyle textStyle) {
        this.textStyle = textStyle;
    }

    public Integer getZlevel() {
        return zlevel;
    }

    public void setZlevel(Integer zlevel) {
        this.zlevel = zlevel;
    }

    public Integer getZ() {
        return z;
    }

    public void setZ(Integer z) {
        this.z = z;
    }

    public Object getLeft() {
        return left;
    }

    public void setLeft(Object left) {
        this.left = left;
    }

    public Object getRight() {
        return right;
    }

    public void setRight(Object right) {
        this.right = right;
    }

    public Object getTop() {
        return top;
    }

    public void setTop(Object top) {
        this.top = top;
    }

    public Object getBottom() {
        return bottom;
    }

    public void setBottom(Object bottom) {
        this.bottom = bottom;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof DataZoomSlider)) return false;
        if (!super.equals(o)) return false;
        DataZoomSlider that = (DataZoomSlider) o;
        return Objects.equals(backgroundColor, that.backgroundColor) &&
                Objects.equals(dataBackground, that.dataBackground) &&
                Objects.equals(fillerColor, that.fillerColor) &&
                Objects.equals(borderColor, that.borderColor) &&
                Objects.equals(handleIcon, that.handleIcon) &&
                Objects.equals(handleSize, that.handleSize) &&
                Objects.equals(handleStyle, that.handleStyle) &&
                Objects.equals(labelPrecision, that.labelPrecision) &&
                Objects.equals(labelFormatter, that.labelFormatter) &&
                Objects.equals(showDetail, that.showDetail) &&
                Objects.equals(showDataShadow, that.showDataShadow) &&
                Objects.equals(realtime, that.realtime) &&
                textStyle == that.textStyle &&
                Objects.equals(zlevel, that.zlevel) &&
                Objects.equals(z, that.z) &&
                Objects.equals(left, that.left) &&
                Objects.equals(right, that.right) &&
                Objects.equals(top, that.top) &&
                Objects.equals(bottom, that.bottom);
    }

    @Override
    public int hashCode() {
        return Objects.hash(
                super.hashCode(), backgroundColor, dataBackground, fillerColor, borderColor,
                handleIcon, handleSize, handleStyle, labelPrecision, labelFormatter, showDetail,
                showDataShadow, realtime, textStyle, zlevel, z, left, right, top, bottom);
    }

    @Override
    public String toString(boolean pretty) {
        Map<String, Object> last = new LinkedHashMap<>();
        last.put("backgroundColor", backgroundColor);
        last.put("dataBackground", dataBackground);
        last.put("fillerColor", fillerColor);
        last.put("borderColor", borderColor);
        last.put("handleIcon", handleIcon);
        last.put("handleSize", handleSize);
        last.put("handleStyle", handleStyle);
        last.put("labelPrecision", labelPrecision);
        last.put("labelFormatter", labelFormatter);
        last.put("showDetail", showDetail);
        last.put("showDataShadow", showDataShadow);
        last.put("realtime", realtime);
        last.put("textStyle", textStyle);
        last.putAll(asMapInner());
        last.put("zlevel", zlevel);
        last.put("z", z);
        last.put("left", left);
        last.put("right", right);
        last.put("top", top);
        last.put("bottom", bottom);
        return toString(null, last, pretty);
    }

    @Override
    public String toString() {
        return toString(false);
    }
}
