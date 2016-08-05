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

import org.aying.echarts.data.TimelineData;
import org.hamcrest.core.Is;
import org.junit.Test;

import java.util.List;

import static org.hamcrest.core.IsNull.notNullValue;
import static org.junit.Assert.assertThat;

/**
 * @author Aying
 * @since 1.0
 */
public class TimelineTest extends BaseTest {

    String testJson1 = "{" +
            "data: [" +
            "  '2002-01-01',\n" +
            "  '2003-01-01',\n" +
            "  '2004-01-01',\n" +
            "  {\n" +
            "    value: '2005-01-01',\n" +
            "    tooltip: {\n" +
            "      formatter: '{b} xxxx'\n" +
            "    },\n" +
            "    symbol: 'diamond',\n" +
            "    symbolSize: 16\n" +
            "  },\n" +
            "  '2006-01-01',\n" +
            "  '2007-01-01'" +
            "]" +
            "}";

    @Test
    public void testParseData() throws Exception {
        Timeline tl = objectMapper.readValue(testJson1, Timeline.class);

        assertThat(tl, notNullValue());

        List<TimelineData> dataList = tl.getData();

        assertThat(dataList, notNullValue());
        assertThat(dataList.isEmpty(), Is.is(false));

        System.out.println(objectMapper.writerWithDefaultPrettyPrinter()
        .writeValueAsString(tl));
    }
}