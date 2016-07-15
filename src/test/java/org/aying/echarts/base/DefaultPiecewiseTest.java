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

package org.aying.echarts.base;

import org.aying.echarts.BaseTest;
import org.hamcrest.core.Is;
import org.junit.Test;

import static org.hamcrest.core.IsNull.notNullValue;
import static org.hamcrest.core.IsNull.nullValue;
import static org.junit.Assert.assertThat;

/**
 * @author Fuchun
 * @since 1.0
 */
public class DefaultPiecewiseTest extends BaseTest {

    @Test
    public void testOf() throws Exception {
        String json0 = "{gt: 1500}";
        String json1 = "{min:900, max:1500}";
        String json2 = "{min: 10, max: 200, label: '10 到 200（自定义label）'}";
        String json3 = "{gt: 900, lte: 1500}";
        String json4 = "{gt: 10, lte: 200, label: '10 到 200（自定义label）'}";
        String json5 = "{value: 123, label: '123（自定义特殊颜色）', color: 'grey'}";

        DefaultPiecewise p0 = objectMapper.readValue(json0, DefaultPiecewise.class);
        DefaultPiecewise p1 = objectMapper.readValue(json1, DefaultPiecewise.class);
        DefaultPiecewise p2 = objectMapper.readValue(json2, DefaultPiecewise.class);
        DefaultPiecewise p3 = objectMapper.readValue(json3, DefaultPiecewise.class);
        DefaultPiecewise p4 = objectMapper.readValue(json4, DefaultPiecewise.class);
        DefaultPiecewise p5 = objectMapper.readValue(json5, DefaultPiecewise.class);

        assertThat(p0, notNullValue());
        assertThat(p1, notNullValue());
        assertThat(p2, notNullValue());
        assertThat(p3, notNullValue());
        assertThat(p4, notNullValue());
        assertThat(p5, notNullValue());

        System.out.printf("ToString=%s, %nJSON=%s%n", p0, objectMapper.writeValueAsString(p0));
        System.out.printf("ToString=%s, %nJSON=%s%n", p1, objectMapper.writeValueAsString(p1));
        System.out.printf("ToString=%s, %nJSON=%s%n", p2, objectMapper.writeValueAsString(p2));
        System.out.printf("ToString=%s, %nJSON=%s%n", p3, objectMapper.writeValueAsString(p3));
        System.out.printf("ToString=%s, %nJSON=%s%n", p4, objectMapper.writeValueAsString(p4));
        System.out.printf("ToString=%s, %nJSON=%s%n", p5, objectMapper.writeValueAsString(p5));
    }

    @Test
    public void testFactories() throws Exception {
        Piecewise p1 = Piecewise.atLeast(100, null, null);
        Piecewise p2 = Piecewise.atMost(100, null, null);

        assertThat(p1.getGte(), Is.is(100L));
        assertThat(p1.getLte(), nullValue());
        assertThat(p2.getLte(), Is.is(100L));
        assertThat(p2.getGte(), nullValue());

        assertThat("{\"gte\":100}", Is.is(objectMapper.writeValueAsString(p1)));
        assertThat("{\"lte\":100}", Is.is(objectMapper.writeValueAsString(p2)));

        Piecewise p3 = Piecewise.lessThan(800, null, null);
        Piecewise p4 = Piecewise.greaterThan(300, null, null);

        assertThat("{\"lt\":800}", Is.is(objectMapper.writeValueAsString(p3)));
        assertThat("{\"gt\":300}", Is.is(objectMapper.writeValueAsString(p4)));

        assertThat(p3.getGt(), nullValue());
        assertThat(p3.getGte(), nullValue());
        assertThat(p3.getLte(), nullValue());
        assertThat(p3.getLt(), Is.is(800L));
        assertThat(p4.getGte(), nullValue());
        assertThat(p4.getLt(), nullValue());
        assertThat(p4.getLte(), nullValue());
        assertThat(p4.getGt(), Is.is(300L));

        Piecewise p5 = Piecewise.closed(900, 1500, null, "900-1500 自定义 label");
        Piecewise p6 = Piecewise.open(900, 1500, null, "900-1500 自定义 label");
        DefaultPiecewise defP5 = (DefaultPiecewise) p5;
        DefaultPiecewise defP6 = (DefaultPiecewise) p6;

        String p5JsonTarget = "{\"gte\":900,\"lte\":1500,\"label\":\"900-1500 自定义 label\"}";
        String p6JsonTarget = "{\"gt\":900,\"lt\":1500,\"label\":\"900-1500 自定义 label\"}";

        assertThat(p5JsonTarget, Is.is(objectMapper.writeValueAsString(p5)));
        assertThat(p6JsonTarget, Is.is(objectMapper.writeValueAsString(p6)));

        assertThat(defP5.getLower(), notNullValue());
        assertThat(defP5.getUpper(), notNullValue());
        assertThat(defP6.getLower(), notNullValue());
        assertThat(defP6.getUpper(), notNullValue());

        assertThat(p5.getGt(), nullValue());
        assertThat(p5.getGte(), Is.is(900L));
        assertThat(p5.getLt(), nullValue());
        assertThat(p5.getLte(), Is.is(1500L));

        assertThat(p6.getGte(), nullValue());
        assertThat(p6.getGt(), Is.is(900L));
        assertThat(p6.getLte(), nullValue());
        assertThat(p6.getLt(), Is.is(1500L));
        assertThat(p5.getLabel(), Is.is(p6.getLabel()));

        Piecewise p7 = Piecewise.fixed(123, "gray", null);
        DefaultPiecewise defP7 = (DefaultPiecewise) p7;

        assertThat(defP7.getLower(), nullValue());
        assertThat(defP7.getUpper(), nullValue());
        assertThat(p7.getLte(), nullValue());
        assertThat(p7.getLt(), nullValue());
        assertThat(p7.getGt(), nullValue());
        assertThat(p7.getGte(), nullValue());
        assertThat(p7.getMin(), nullValue());
        assertThat(p7.getMax(), nullValue());
        assertThat(p7.getValue(), Is.is(123L));

        Piecewise p8 = Piecewise.closedOpen(210, 500, "red", null);
        Piecewise p9 = Piecewise.openClosed(210, 500, "green", null);

        DefaultPiecewise defP8 = (DefaultPiecewise) p8;
        DefaultPiecewise defP9 = (DefaultPiecewise) p9;

        assertThat(defP8.getLower(), notNullValue());
        assertThat(defP8.getUpper(), notNullValue());
        assertThat(defP9.getLower(), notNullValue());
        assertThat(defP9.getUpper(), notNullValue());

        assertThat(p8.getGte(), Is.is(210L));
        assertThat(p8.getLt(), Is.is(500L));
        assertThat(p9.getGt(), Is.is(210L));
        assertThat(p9.getLte(), Is.is(500L));
    }
}