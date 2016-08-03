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

import com.fasterxml.jackson.core.type.TypeReference;
import com.google.common.base.Charsets;
import com.google.common.io.CharStreams;
import org.aying.echarts.BaseTest;
import org.hamcrest.core.Is;
import org.junit.Before;
import org.junit.Test;

import java.io.InputStreamReader;
import java.util.List;

import static org.hamcrest.core.IsNull.notNullValue;
import static org.junit.Assert.assertThat;

/**
 * @author Fuchun
 * @since 1.0
 */
public class SerieTest extends BaseTest {

    private String testJson;

    @Override
    @Before
    public void setUp() throws Exception {
        super.setUp();
        testJson = CharStreams.toString(
                new InputStreamReader(getClass().getResourceAsStream("/pie_series_test.json"),
                Charsets.UTF_8));
    }

    @Test
    public void testParseJson() throws Exception {
        List<Serie> series = objectMapper.readValue(
                testJson, new TypeReference<List<Serie>>(){});

        assertThat(series, notNullValue());
        assertThat(series.isEmpty(), Is.is(false));

        String json = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(series);
        System.out.println(json);
    }
}