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

import org.aying.echarts.base.StateLabel;
import org.aying.echarts.style.StateLineStyle;

import java.io.Serializable;
import java.util.Objects;

/**
 * 节点间的关系数据模型。
 *
 * @author Fuchun
 * @since 1.0
 */
public class Link implements Serializable {

    private static final long serialVersionUID = 9198762531446897977L;

    /*边的源节点名称的字符串，也支持使用数字表示源节点的索引。*/
    private Object source;
    /*边的目标节点名称的字符串，也支持使用数字表示源节点的索引。*/
    private Object target;
    /*边的数值，决定边的宽度。*/
    private Object value;
    /*关系边的线条样式。*/
    private StateLineStyle lineStyle;
    /*关系标签*/
    private StateLabel label;
    /*边两端的标记类型，可以是一个数组分别指定两端，也可以是单个统一指定。*/
    private Object edgeSymbol;
    /*边两端的标记大小，可以是一个数组分别指定两端，也可以是单个统一指定。*/
    private Object edgeSymbolSize;

    public Link() {
        super();
    }

    public Object getSource() {
        return source;
    }

    public void setSource(Object source) {
        this.source = source;
    }

    public Object getTarget() {
        return target;
    }

    public void setTarget(Object target) {
        this.target = target;
    }

    public Object getValue() {
        return value;
    }

    public void setValue(Object value) {
        this.value = value;
    }

    public StateLineStyle getLineStyle() {
        return lineStyle;
    }

    public void setLineStyle(StateLineStyle lineStyle) {
        this.lineStyle = lineStyle;
    }

    public StateLabel getLabel() {
        return label;
    }

    public void setLabel(StateLabel label) {
        this.label = label;
    }

    public Object getEdgeSymbol() {
        return edgeSymbol;
    }

    public void setEdgeSymbol(Object edgeSymbol) {
        this.edgeSymbol = edgeSymbol;
    }

    public Object getEdgeSymbolSize() {
        return edgeSymbolSize;
    }

    public void setEdgeSymbolSize(Object edgeSymbolSize) {
        this.edgeSymbolSize = edgeSymbolSize;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Link)) return false;
        Link link = (Link) o;
        return Objects.equals(source, link.source) &&
                Objects.equals(target, link.target) &&
                Objects.equals(value, link.value) &&
                Objects.equals(lineStyle, link.lineStyle) &&
                Objects.equals(label, link.label) &&
                Objects.equals(edgeSymbol, link.edgeSymbol) &&
                Objects.equals(edgeSymbolSize, link.edgeSymbolSize);
    }

    @Override
    public int hashCode() {
        return Objects.hash(source, target, value, lineStyle, label, edgeSymbol, edgeSymbolSize);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder(32)
                .append(getClass()).append("{");
        sb.append("source=").append(source);
        sb.append(", target=").append(target);
        sb.append(", value=").append(value);
        sb.append(", lineStyle=").append(lineStyle);
        sb.append(", label=").append(label);
        sb.append(", edgeSymbol=").append(edgeSymbol);
        sb.append(", edgeSymbolSize=").append(edgeSymbolSize);
        sb.append('}');
        return sb.toString();
    }
}
