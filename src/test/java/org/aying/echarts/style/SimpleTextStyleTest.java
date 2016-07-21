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

package org.aying.echarts.style;

import org.aying.echarts.BaseTest;
import org.aying.echarts.style.font.FontWeight;
import org.hamcrest.core.Is;
import org.junit.Test;

import java.math.RoundingMode;

import static org.hamcrest.core.IsInstanceOf.instanceOf;
import static org.hamcrest.core.IsNull.notNullValue;
import static org.hamcrest.core.IsNull.nullValue;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.fail;

/**
 * @author Fuchun
 * @since 1.0
 */
public class SimpleTextStyleTest extends BaseTest {

    private static final String TEST_JSON = "{color:'#333',fontWeight:600}";

    @Test
    public void testFromJSON() throws Exception {
        TextStyle textStyle = null;

        try {
            textStyle = objectMapper.readValue(TEST_JSON, TextStyle.class);
        } catch (Exception ex) {
            fail();
        }

        assertThat(textStyle, notNullValue());
        assertThat(textStyle.getColor(), Is.is("#333"));
        assertThat(textStyle.getFontWeight(), Is.is(FontWeight.W600));

        TextStyle style = Styles.text().color("#333")
                .fontWeight(FontWeight.W600);
        assertThat(style, Is.is(textStyle));
    }

    @Test
    public void testSetFontWeight() throws Exception {
        SimpleTextStyle textStyle = new SimpleTextStyle();
        textStyle.setFontWeight(null);

        assertThat(textStyle.getFontWeight(), nullValue());

        textStyle.setFontWeight(FontWeight.W500);

        assertThat(textStyle.getFontWeight(), instanceOf(Integer.class));
        assertThat(textStyle.getFontWeight(), Is.is(FontWeight.W500));

        textStyle.setFontWeight("bold");

        assertThat(textStyle.getFontWeight(), instanceOf(FontWeight.class));
        assertThat(textStyle.getFontWeight(), Is.is(FontWeight.bold));

        try {
            textStyle.setFontWeight(150);
            fail();
        } catch (Exception ex) {
            assertThat(ex, instanceOf(IllegalArgumentException.class));
        }

        try {
            // error enum type
            textStyle.setFontWeight(RoundingMode.HALF_UP);
            fail();
        } catch (Exception ex) {
            assertThat(ex, instanceOf(IllegalArgumentException.class));
        }

        try {
            textStyle.setFontWeight("notExists");
            fail();
        } catch (Exception ex) {
            assertThat(ex, instanceOf(IllegalArgumentException.class));
        }
    }
}