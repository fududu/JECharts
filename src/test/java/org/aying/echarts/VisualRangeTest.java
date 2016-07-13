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

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.hamcrest.core.IsInstanceOf.instanceOf;
import static org.hamcrest.core.IsNull.notNullValue;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.fail;

/**
 * @author Fuchun
 * @since 1.0
 */
public class VisualRangeTest {

    private ObjectMapper objectMapper;

    @Before
    public void setUp() throws Exception {
        objectMapper = new ObjectMapper();
        objectMapper.findAndRegisterModules();
        objectMapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
        objectMapper.enable(JsonParser.Feature.ALLOW_SINGLE_QUOTES);
        objectMapper.enable(JsonParser.Feature.ALLOW_UNQUOTED_FIELD_NAMES);
        objectMapper.enable(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY);
    }

    @Test
    public void testFromJSON1() throws Exception {
        String json = "{" +
                "symbol: [ 'circle', 'rect', 'diamond' ], " +
                "color: [ '#333', '#78ab23', 'blue' ]" +
                "}";

        testFromJson(json);
    }

    @Test
    public void testFromJSON2() throws Exception {
        String json = "{" +
                "symbol: [ 'circle', 'rect', 'diamond' ], " +
                "color: '#333'" +
                "}";
        testFromJson(json);
    }

    protected void testFromJson(String json) {
        VisualRange range = null;
        try {
            range = objectMapper.readValue(json, VisualRange.class);

            System.out.println(objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(range));
        } catch (Exception ex) {
            fail(ex.getMessage());
            ex.printStackTrace();
        }

        assertThat(range, notNullValue());
        assertThat(range.getColor(), instanceOf(List.class));
    }
}