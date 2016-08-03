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

import com.fasterxml.jackson.core.type.TypeReference;
import org.junit.Test;

import java.util.List;

/**
 * @author Aying
 * @since 1.0
 */
public class DataZoomTest extends BaseTest {

    @Test
    public void testPolymorphicJson() throws Exception {
        String json = "[" +
                "{\n" +
                "  type: 'slider',\n" +
                "  show: true,\n" +
                "  xAxisIndex: [0],\n" +
                "  start: 1,\n" +
                "  end: 35\n" +
                "},\n" +
                "{\n" +
                "  type: 'slider',\n" +
                "  how: true,\n" +
                "  yAxisIndex: [0],\n" +
                "  left: '93%',\n" +
                "  start: 29,\n" +
                "  end: 36\n" +
                "},\n" +
                "{\n" +
                "  type: 'inside',\n" +
                "  xAxisIndex: [0],\n" +
                "  start: 1,\n" +
                "  end: 35\n" +
                "},\n" +
                "{\n" +
                "  type: 'inside',\n" +
                "  yAxisIndex: [0],\n" +
                "  start: 29,\n" +
                "  end: 36\n" +
                "}]";
        List<DataZoom> dzList = objectMapper.readValue(json,
                new TypeReference<List<DataZoom>>(){});
        System.out.println(dzList);
    }
}