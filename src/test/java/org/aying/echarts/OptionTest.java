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

import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.hamcrest.core.IsNull.notNullValue;
import static org.junit.Assert.assertThat;

/**
 * @author Aying
 * @since 1.0
 */
public class OptionTest extends BaseTest {

    List<String> titleTests;

    @Override
    @Before
    public void setUp() throws Exception {
        super.setUp();
        titleTests = JsonReader.readJsonList("/option_test_01.data");
    }

    @Test
    public void testTitle() throws Exception {
        for (String json : titleTests) {
            Option option = objectMapper.readValue(json, Option.class);

            assertThat(option, notNullValue());
            assertThat(option.getTitles(), notNullValue());

            System.out.println(objectMapper.writeValueAsString(option.getTitles()));
        }
    }
}