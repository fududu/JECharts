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

import org.aying.echarts.base.Magic;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/**
 * 动态类型切换配置模型。
 *
 * @author Fuchun
 * @since 1.0
 */
public class MagicType extends BaseFeature<MagicType> {

    private static final Map<Magic, String> DEFAULT_TITLE_MAP;
    private static final List<Magic> DEFAULT_TYPE;

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

    public MagicType() {
        super();
        type(Magic.line, Magic.bar, Magic.stack, Magic.tiled);
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

    public MagicType title(Map<Magic, String> titleMap) {
        if (titleMap == null || titleMap.isEmpty()) {
            setTitle(null);
            return this;
        }
        Map<Magic, String> defTitleMap = new HashMap<>(DEFAULT_TITLE_MAP);
        titleMap.forEach((k, v) -> {
            if (v != null && (v = v.trim()).length() > 0) {
                defTitleMap.put(k, v);
            }
        });
        return super.title(titleMap);
    }

    public MagicType icon(Map<Magic, String> iconMap) {
        if (iconMap == null || iconMap.isEmpty()) {
            setIcon(null);
            return this;
        }
        Map<Magic, String> rs = new HashMap<>(4);
        for (Map.Entry<Magic, String> i : iconMap.entrySet()) {
            String v = (i.getValue() == null) ? "" : i.getValue().trim();
            if (!v.isEmpty()) {
                rs.put(i.getKey(), v);
            }
        }
        setIcon(rs);
        return this;
    }
}
