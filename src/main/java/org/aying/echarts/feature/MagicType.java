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

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import org.aying.echarts.base.Magic;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.function.Consumer;
import java.util.function.Function;

/**
 * 动态类型切换配置模型。
 *
 * @author Fuchun
 * @since 1.0
 */
public class MagicType extends BaseFeature<MagicType> {

    private static final Map<Magic, String> DEFAULT_TITLE_MAP;
    private static final List<Magic> DEFAULT_TYPE;

    private static final long serialVersionUID = -3053630107150755977L;

    private static final Function<Map<Object, Object>, MTemplate<?>> MAP_TO_MT_FUNCTION = map -> {
        if (map == null || map.isEmpty()) return null;
        return new StringMTemplate(
                (String) map.get(MTemplate.KEY_LINE), (String) map.get(MTemplate.KEY_BAR),
                (String) map.get(MTemplate.KEY_STACK), (String) map.get(MTemplate.KEY_TILED));
    };

    static {
        HashMap<Magic, String> builder = new HashMap<>();
        builder.put(Magic.line, "切换为折线图");
        builder.put(Magic.bar, "切换为柱状图");
        builder.put(Magic.stack, "切换为堆叠");
        builder.put(Magic.tiled, "切换为平铺");

        ArrayList<Magic> typeList = new ArrayList<>(4);
        typeList.add(0, Magic.line);
        typeList.add(1, Magic.bar);
        typeList.add(2, Magic.stack);
        typeList.add(3, Magic.tiled);
        DEFAULT_TITLE_MAP = Collections.unmodifiableMap(builder);
        DEFAULT_TYPE = Collections.unmodifiableList(typeList);
    }

    private List<Magic> type;
    private ListMTemplate seriesIndex;
    private ObjectMTemplate option;

    public MagicType() {
        super();
        setType(new ArrayList<>(DEFAULT_TYPE));
    }

    public MagicType type(Magic m1, Magic... mn) {
        Objects.requireNonNull(m1, "magic");
        if (type == null) {
            type = new ArrayList<>(4);
        }
        type.add(m1);
        if (mn != null && mn.length > 0) {
            Collections.addAll(type, mn);
        }
        return this;
    }

    public MagicType title(StringMTemplate title) {
        super.setTitle(title);
        return this;
    }

    public MagicType icon(StringMTemplate icon) {
        super.setIcon(icon);
        return this;
    }

    public MagicType seriesIndex(ListMTemplate seriesIndex) {
        this.seriesIndex = seriesIndex;
        return this;
    }

    public MagicType option(ObjectMTemplate option) {
        this.option = option;
        return this;
    }

    @Override
    @JsonDeserialize(as = StringMTemplate.class)
    public void setTitle(Object title) {
        handleMTSetter("title", title, super::setTitle, MAP_TO_MT_FUNCTION);
    }

    @Override
    @JsonDeserialize(as = StringMTemplate.class)
    public void setIcon(Object icon) {
        handleMTSetter("icon", icon, super::setIcon, MAP_TO_MT_FUNCTION);
    }

    private void handleMTSetter(
            String propName, Object obj, Consumer<Object> consumer,
            Function<Map<Object, Object>, MTemplate<?>> func) {
        if (obj == null) {
            consumer.accept(null);
            return;
        }
        if (obj instanceof Map) {
            @SuppressWarnings("unchecked")
            Map<Object, Object> objMap = (Map<Object, Object>) obj;
            if (objMap.isEmpty()) {
                consumer.accept(null); return;
            }
            consumer.accept(func.apply(objMap));
        } else if (obj instanceof MTemplate) {
            consumer.accept(obj);
        } else {
            throw new IllegalArgumentException(
                    String.format("Unsupported %s type: %s, value: %s",
                            propName, obj.getClass(), obj));
        }
    }

    public List<Magic> getType() {
        return type;
    }

    public void setType(List<Magic> type) {
        this.type = type;
    }

    public ListMTemplate getSeriesIndex() {
        return seriesIndex;
    }

    public void setSeriesIndex(ListMTemplate seriesIndex) {
        this.seriesIndex = seriesIndex;
    }

    public ObjectMTemplate getOption() {
        return option;
    }

    public void setOption(ObjectMTemplate option) {
        this.option = option;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof MagicType)) return false;
        if (!super.equals(o)) return false;
        MagicType magicType = (MagicType) o;
        return Objects.equals(type, magicType.type) &&
                Objects.equals(seriesIndex, magicType.seriesIndex) &&
                Objects.equals(option, magicType.option);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), type, seriesIndex, option);
    }

    @Override
    public String toString() {
        return "org.aying.echarts.feature.MagicType{" +
                "type=" + type +
                ", seriesIndex=" + seriesIndex +
                ", option=" + option +
                "} " + super.toString();
    }

}
