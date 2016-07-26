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

import java.io.Serializable;
import java.util.Objects;

/**
 * 力引导布局相关的配置项，力引导布局是模拟弹簧电荷模型在每两个节点之间添加一个斥力，每条边的两个节点之间添加一个引力，
 * 每次迭代节点会在各个斥力和引力的作用下移动位置，多次迭代后节点会静止在一个受力平衡的位置，达到整个模型的能量最小化。
 * 力引导布局的结果有良好的对称性和局部聚合性，也比较美观。
 *
 * @author Fuchun
 * @since 1.0
 */
public class Force implements Serializable {

    private static final long serialVersionUID = 3936940426601931246L;

    public static Force one() {
        return new Force();
    }

    public static Force circular() {
        return new Force("circular");
    }

    /*进行力引导布局前的初始化布局，初始化布局会影响到力引导的效果。*/
    private String initLayout;
    /*节点之间的斥力因子。该值越大节点之间的斥力越大，两个节点间的距离也会越远。*/
    private Integer repulsion;
    /*节点受到的向中心的引力因子。该值越大节点越往中心点靠拢。*/
    private Double gravity;
    /*边的两个节点之间的距离，这个距离也会受 repulsion。*/
    private Integer edgeLength;
    /*因为力引导布局会在多次迭代后才会稳定，这个参数决定是否显示布局的迭代动画，在浏览器端节点数据较多（>100）的时候不建议关闭，布局过程会造成浏览器假死。*/
    private Boolean layoutAnimation;

    public Force() {
        super();
    }

    public Force(String initLayout) {
        this.initLayout = initLayout;
    }

    public String getInitLayout() {
        return initLayout;
    }

    public void setInitLayout(String initLayout) {
        this.initLayout = initLayout;
    }

    public Integer getRepulsion() {
        return repulsion;
    }

    public void setRepulsion(Integer repulsion) {
        this.repulsion = repulsion;
    }

    public Double getGravity() {
        return gravity;
    }

    public void setGravity(Double gravity) {
        this.gravity = gravity;
    }

    public Integer getEdgeLength() {
        return edgeLength;
    }

    public void setEdgeLength(Integer edgeLength) {
        this.edgeLength = edgeLength;
    }

    public Boolean getLayoutAnimation() {
        return layoutAnimation;
    }

    public void setLayoutAnimation(Boolean layoutAnimation) {
        this.layoutAnimation = layoutAnimation;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Force)) return false;
        Force force = (Force) o;
        return Objects.equals(initLayout, force.initLayout) &&
                Objects.equals(repulsion, force.repulsion) &&
                Objects.equals(gravity, force.gravity) &&
                Objects.equals(edgeLength, force.edgeLength) &&
                Objects.equals(layoutAnimation, force.layoutAnimation);
    }

    @Override
    public int hashCode() {
        return Objects.hash(initLayout, repulsion, gravity, edgeLength, layoutAnimation);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder(32)
                .append(getClass()).append("{");
        sb.append("initLayout='").append(initLayout).append('\'');
        sb.append(", repulsion=").append(repulsion);
        sb.append(", gravity=").append(gravity);
        sb.append(", edgeLength=").append(edgeLength);
        sb.append(", layoutAnimation=").append(layoutAnimation);
        sb.append('}');
        return sb.toString();
    }
}
