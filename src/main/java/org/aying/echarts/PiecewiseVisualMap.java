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

import org.aying.echarts.base.Piecewise;
import org.aying.echarts.base.SelectedMode;
import org.aying.echarts.base.Symbol;
import org.jetbrains.annotations.Contract;

import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

/**
 * 分段型视觉映射组件实现。
 *
 * @author Fuchun
 * @since 1.0
 */
public class PiecewiseVisualMap extends VisualMap<PiecewiseVisualMap> {

    private static final long serialVersionUID = 5044523589706406824L;

    /* 对于连续型数据，自动平均切分成几段。默认为5段。 连续数据的范围需要 max 和 min 来指定。 */
    private Integer splitNumber;
    /* 自定义『分段式视觉映射组件（visualMap）』的每一段的范围，以及每一段的文字，以及每一段的特别的样式。 */
    private List<Piecewise> pieces;
    /* 用于表示离散型数据（或可以称为类别型数据、枚举型数据）的全集。 */
    private List<String> categories;
    /* 选择模式 */
    private SelectedMode selectedMode;
    /* 每两个图元之间的间隔距离，单位为px。默认：10 */
    private Integer itemGap;
    /* 项的图形。默认：Symbol.roundRect */
    private Symbol itemSymbol;

    public PiecewiseVisualMap() {
        super("piecewise");
    }

    protected void initPieces() {
        if (pieces == null) {
            pieces = new LinkedList<>();
        }
    }

    protected void initCategories() {
        if (categories == null) {
            categories = new LinkedList<>();
        }
    }

    /**
     * 设置连续型数据的自动分段数。
     * <p />
     * NOTE: 如果后续调用中设置了{@code pieces} 或者{@code categories}，则该设置会失效。
     *
     * @param sn 分段数。
     * @throws IllegalArgumentException 如果分段数{@code cn <= 0}
     */
    public PiecewiseVisualMap splitNumber(int sn) {
        if (sn <= 0) {
            throw new IllegalArgumentException("The splitNumber value must be greater than 0");
        }
        this.splitNumber = sn;
        return this;
    }

    /**
     * 设置分段样式。如果该方法被调用两次以上，则以只计算最后一次的调用。
     *
     * @param p0 要添加的分段样式。
     * @param pn 更多的分段样式（顺序加入）。
     */
    @Contract("null, _ -> fail")
    public PiecewiseVisualMap pieces(Piecewise p0, Piecewise... pn) {
        Objects.requireNonNull(p0, "piece");
        initPieces();
        if (!pieces.isEmpty()) {
            pieces.clear();
        }
        pieces.add(p0);
        if (pn != null && pn.length > 0) {
            for (Piecewise p : pn) {
                if (p == null) continue;
                pieces.add(p);
            }
        }
        return this;
    }

    /**
     * 设置此视觉组件的表示离散型数据（或可以称为类别型数据、枚举型数据）的全集。
     * <p>
     * NOTE：如果要设置此值，其长度必须与{@code series.data} 中的数据长度相同。
     * 此设置被调用后，{@code splitNumber} 设置无效。
     *
     * @param c1 数据的分类名称。
     * @param cn 更多的数据的分类名称。
     * @throws NullPointerException 如果{@code c1 == null}
     */
    @Contract("null, _ -> fail")
    public PiecewiseVisualMap categories(String c1, String... cn) {
        Objects.requireNonNull(c1, "category");
        initCategories();
        if (!categories.isEmpty()) {
            categories.clear();
        }
        categories.add(c1);
        if (cn != null && cn.length > 0) {
            for (String c : cn) {
                if (c == null) continue;
                categories.add(c);
            }
        }
        return this;
    }

    public PiecewiseVisualMap categories(List<String> categories) {
        if (categories == null || categories.isEmpty()) {
            return this;
        }
        initCategories();
        if (!this.categories.isEmpty()) {
            this.categories.clear();
        }
        this.categories.addAll(categories);
        return this;
    }

    /**
     * 当前视觉组件设置为单选模式。
     * 没有设置或不进行手动调用时，ECharts默认为多选模式。
     */
    public PiecewiseVisualMap single() {
        this.selectedMode = SelectedMode.single;
        return this;
    }

    /**
     * 设置每两个图元之间的间隔距离，单位为px。
     *
     * @param itemGap 间隔距离。
     * @throws IllegalArgumentException 如果间隔距离设置为负数{@code itemGap < 0}。
     */
    public PiecewiseVisualMap itemGap(int itemGap) {
        if (itemGap < 0) {
            throw new IllegalArgumentException("The itemGap value must be greater or equals 0");
        }
        this.itemGap = itemGap;
        return this;
    }

    /**
     * 设置{@code VisualMap} 的图元的默认图形。
     *
     * @param symbol 图无图形。
     */
    public PiecewiseVisualMap itemSymbol(Symbol symbol) {
        if (symbol == null) return this;
        this.itemSymbol = symbol;
        return this;
    }

    public Integer getSplitNumber() {
        return splitNumber;
    }

    public void setSplitNumber(Integer splitNumber) {
        this.splitNumber = splitNumber;
    }

    public List<Piecewise> getPieces() {
        return pieces;
    }

    public void setPieces(List<Piecewise> pieces) {
        this.pieces = pieces;
    }

    public List<String> getCategories() {
        return categories;
    }

    public void setCategories(List<String> categories) {
        this.categories = categories;
    }

    public SelectedMode getSelectedMode() {
        return selectedMode;
    }

    public void setSelectedMode(SelectedMode selectedMode) {
        this.selectedMode = selectedMode;
    }

    public Integer getItemGap() {
        return itemGap;
    }

    public void setItemGap(Integer itemGap) {
        this.itemGap = itemGap;
    }

    public Symbol getItemSymbol() {
        return itemSymbol;
    }

    public void setItemSymbol(Symbol itemSymbol) {
        this.itemSymbol = itemSymbol;
    }
}
