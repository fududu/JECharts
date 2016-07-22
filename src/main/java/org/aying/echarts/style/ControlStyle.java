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

package org.aying.echarts.style;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.aying.echarts.base.Pos;

import java.util.Objects;

/**
 * @author Fuchun
 * @since 1.0
 */
public class ControlStyle extends BaseStyle<ControlStyle> {

    private static final long serialVersionUID = -1990500762755305705L;

    private Boolean show;
    private Boolean showPlayBtn;
    private Boolean showPrevBtn;
    private Boolean showNextBtn;
    private Integer itemSize;
    private Integer itemGap;
    private Pos position;
    private String playIcon;
    private String stopIcon;
    private String prevIcon;
    private String nextIcon;
    /* 控制按钮的『正常状态』的样式。 */
    private ButtonStyle normal;
    /* 控制按钮的『高亮状态』的样式（hover时）。 */
    private ButtonStyle emphasis;

    @Override
    @JsonIgnore
    public String getColor() {
        return null;
    }

    @Override
    public void setColor(String color) {
        // controlStyle not support color property
    }

    public Boolean getShow() {
        return show;
    }

    public void setShow(Boolean show) {
        this.show = show;
    }

    public Boolean getShowPlayBtn() {
        return showPlayBtn;
    }

    public void setShowPlayBtn(Boolean showPlayBtn) {
        this.showPlayBtn = showPlayBtn;
    }

    public Boolean getShowPrevBtn() {
        return showPrevBtn;
    }

    public void setShowPrevBtn(Boolean showPrevBtn) {
        this.showPrevBtn = showPrevBtn;
    }

    public Boolean getShowNextBtn() {
        return showNextBtn;
    }

    public void setShowNextBtn(Boolean showNextBtn) {
        this.showNextBtn = showNextBtn;
    }

    public Integer getItemSize() {
        return itemSize;
    }

    public void setItemSize(Integer itemSize) {
        this.itemSize = itemSize;
    }

    public Integer getItemGap() {
        return itemGap;
    }

    public void setItemGap(Integer itemGap) {
        this.itemGap = itemGap;
    }

    public Pos getPosition() {
        return position;
    }

    public void setPosition(Pos position) {
        this.position = position;
    }

    public String getPlayIcon() {
        return playIcon;
    }

    public void setPlayIcon(String playIcon) {
        this.playIcon = playIcon;
    }

    public String getStopIcon() {
        return stopIcon;
    }

    public void setStopIcon(String stopIcon) {
        this.stopIcon = stopIcon;
    }

    public String getPrevIcon() {
        return prevIcon;
    }

    public void setPrevIcon(String prevIcon) {
        this.prevIcon = prevIcon;
    }

    public String getNextIcon() {
        return nextIcon;
    }

    public void setNextIcon(String nextIcon) {
        this.nextIcon = nextIcon;
    }

    public ButtonStyle getNormal() {
        return normal;
    }

    public void setNormal(ButtonStyle normal) {
        this.normal = normal;
    }

    public ButtonStyle getEmphasis() {
        return emphasis;
    }

    public void setEmphasis(ButtonStyle emphasis) {
        this.emphasis = emphasis;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ControlStyle)) return false;
        if (!super.equals(o)) return false;
        ControlStyle that = (ControlStyle) o;
        return Objects.equals(show, that.show) &&
                Objects.equals(showPlayBtn, that.showPlayBtn) &&
                Objects.equals(showPrevBtn, that.showPrevBtn) &&
                Objects.equals(showNextBtn, that.showNextBtn) &&
                Objects.equals(itemSize, that.itemSize) &&
                Objects.equals(itemGap, that.itemGap) &&
                position == that.position &&
                Objects.equals(playIcon, that.playIcon) &&
                Objects.equals(stopIcon, that.stopIcon) &&
                Objects.equals(prevIcon, that.prevIcon) &&
                Objects.equals(nextIcon, that.nextIcon) &&
                Objects.equals(normal, that.normal) &&
                Objects.equals(emphasis, that.emphasis);
    }

    @Override
    public int hashCode() {
        return Objects.hash(
                super.hashCode(), show, showPlayBtn, showPrevBtn, showNextBtn, itemSize,
                itemGap, position, playIcon, stopIcon, prevIcon, nextIcon, normal, emphasis);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder(64)
                .append(getClass()).append("{");
        sb.append("show=").append(show);
        sb.append(", showPlayBtn=").append(showPlayBtn);
        sb.append(", showPrevBtn=").append(showPrevBtn);
        sb.append(", showNextBtn=").append(showNextBtn);
        sb.append(", itemSize=").append(itemSize);
        sb.append(", itemGap=").append(itemGap);
        sb.append(", position=").append(position);
        sb.append(", playIcon='").append(playIcon).append('\'');
        sb.append(", stopIcon='").append(stopIcon).append('\'');
        sb.append(", prevIcon='").append(prevIcon).append('\'');
        sb.append(", nextIcon='").append(nextIcon).append('\'');
        sb.append(", normal=").append(normal);
        sb.append(", emphasis=").append(emphasis);
        sb.append('}');
        return sb.toString();
    }
}
