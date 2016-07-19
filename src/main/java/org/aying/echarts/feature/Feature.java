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

package org.aying.echarts.feature;

import org.aying.echarts.DataZoomSelect;

import java.io.Serializable;
import java.util.Objects;

/**
 * 各工具配置项。
 *
 * @author Fuchun
 * @since 1.0
 */
public class Feature implements Serializable {

    private static final long serialVersionUID = 7298363466820660730L;

    private SaveAsImage saveAsImage;
    private Restore restore;
    private DataView dataView;
    private DataZoomSelect dataZoom;
    private MagicType magicType;
    private Brush brush;

    public Feature() {
        super();
    }

    public SaveAsImage getSaveAsImage() {
        return saveAsImage;
    }

    public void setSaveAsImage(SaveAsImage saveAsImage) {
        this.saveAsImage = saveAsImage;
    }

    public Restore getRestore() {
        return restore;
    }

    public void setRestore(Restore restore) {
        this.restore = restore;
    }

    public DataView getDataView() {
        return dataView;
    }

    public void setDataView(DataView dataView) {
        this.dataView = dataView;
    }

    public DataZoomSelect getDataZoom() {
        return dataZoom;
    }

    public void setDataZoom(DataZoomSelect dataZoom) {
        this.dataZoom = dataZoom;
    }

    public MagicType getMagicType() {
        return magicType;
    }

    public void setMagicType(MagicType magicType) {
        this.magicType = magicType;
    }

    public Brush getBrush() {
        return brush;
    }

    public void setBrush(Brush brush) {
        this.brush = brush;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Feature)) return false;
        Feature feature = (Feature) o;
        return Objects.equals(saveAsImage, feature.saveAsImage) &&
                Objects.equals(restore, feature.restore) &&
                Objects.equals(dataView, feature.dataView) &&
                Objects.equals(dataZoom, feature.dataZoom) &&
                Objects.equals(magicType, feature.magicType) &&
                Objects.equals(brush, feature.brush);
    }

    @Override
    public int hashCode() {
        return Objects.hash(saveAsImage, restore, dataView, dataZoom, magicType, brush);
    }

    @Override
    public String toString() {
        return "org.aying.echarts.feature.Feature{" +
                "saveAsImage=" + saveAsImage +
                ", restore=" + restore +
                ", dataView=" + dataView +
                ", dataZoom=" + dataZoom +
                ", magicType=" + magicType +
                ", brush=" + brush +
                '}';
    }
}
