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

package org.aying.echarts.axis;

import org.aying.echarts.BaseTest;
import org.junit.Test;

import static org.hamcrest.core.IsNull.notNullValue;
import static org.junit.Assert.assertThat;

/**
 * @author Aying
 * @since 1.0
 */
public class CartesianAxisTest extends BaseTest {

    String testJson1 = "" +
            "{" +
            "type : 'category'," +
            "data : ['周一','周二','周三','周四','周五','周六','周日']" +
            "}";
    String testJson2 = "" +
            "{" +
            "type : 'category'," +
            "data : ['周一','周二','周三','周四','周五','周六',{value:'周日',textStyle:{color:'red'}}]" +
            "}";

    @Test
    public void testData() throws Exception {
        CartesianAxis xAxis = objectMapper.readValue(testJson1, CartesianAxis.class);

        assertThat(xAxis, notNullValue());
        System.out.println(objectMapper.writeValueAsString(xAxis));

        CartesianAxis xAxis2 = objectMapper.readValue(testJson2, CartesianAxis.class);

        assertThat(xAxis2, notNullValue());
        System.out.println(objectMapper.writeValueAsString(xAxis2));
    }
}