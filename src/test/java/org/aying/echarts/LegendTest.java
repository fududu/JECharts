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

import org.junit.Test;

/**
 * @author Aying
 * @since 1.0
 */
public class LegendTest extends BaseTest {

    String testJson1 = "{\n" +
            "  formatter: 'function(name) { return \"Legend \" + name; }',\n" +
            "  right: 10,\n" +
            "  data: ['1990', '2015']\n" +
            "}";
    String testJson2 = "{\n" +
            "  formatter: 'function(name) { return \"Legend \" + name; }',\n" +
            "  right: 10,\n" +
            "  data: [{name:'1990'}, {name:'2015',textStyle:{color:'red'}}]\n" +
            "}";
    String testJson3 = "{\n" +
            "  formatter: 'function(name) { return \"Legend \" + name; }',\n" +
            "  right: 10,\n" +
            "  data: ['1990', {name:'2015',textStyle:{color:'red'}}]\n" +
            "}";

    @Test
    public void testFormatter() throws Exception {
        Legend legend1 = objectMapper.readValue(testJson1, Legend.class);

        System.out.println(objectMapper.writeValueAsString(legend1));

        Legend legend2 = objectMapper.readValue(testJson2, Legend.class);

        System.out.println(objectMapper.writeValueAsString(legend2));

        Legend legend3 = objectMapper.readValue(testJson3, Legend.class);

        System.out.println(objectMapper.writeValueAsString(legend3));
    }
}