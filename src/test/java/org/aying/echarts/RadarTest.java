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

import org.aying.echarts.axis.AxisLine;
import org.aying.echarts.axis.AxisType;
import org.aying.echarts.axis.SplitArea;
import org.aying.echarts.axis.SplitLine;
import org.aying.echarts.style.LineStyle;
import org.aying.echarts.style.Styles;
import org.hamcrest.core.Is;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;

import static org.hamcrest.core.IsCollectionContaining.hasItem;
import static org.hamcrest.core.IsInstanceOf.instanceOf;
import static org.hamcrest.core.IsNull.notNullValue;
import static org.hamcrest.core.IsNull.nullValue;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.fail;

/**
 * @author Aying
 * @since 1.0
 */
public class RadarTest extends BaseTest {

    private static final String[] LINE_COLORS = new String[] {
            "rgba(238, 197, 102, 0.1)", "rgba(238, 197, 102, 0.2)",
            "rgba(238, 197, 102, 0.4)", "rgba(238, 197, 102, 0.6)",
            "rgba(238, 197, 102, 0.8)", "rgba(238, 197, 102, 1)"
    };
    private static final String TEXT_JSON = "" +
            "{" +
            "  indicator: [\n" +
            "    {name: 'AQI', max: 300},\n" +
            "    {name: 'PM2.5', max: 250},\n" +
            "    {name: 'PM10', max: 300},\n" +
            "    {name: 'CO', max: 5},\n" +
            "    {name: 'NO2', max: 200},\n" +
            "    {name: 'SO2', max: 100}\n" +
            "  ]," +
            "  name: {\n" +
            "    textStyle: {\n" +
            "      color: 'rgb(238, 197, 102)'\n" +
            "    }\n" +
            "  }\n" +
            "}";

    @Test
    public void testReadJson() throws Exception {
        Radar radar = objectMapper.readValue(TEXT_JSON, Radar.class);

        assertThat(radar, notNullValue());

        List<Radar.Indicator> indicators = radar.getIndicators();
        assertThat(indicators, notNullValue());

        assertThat(indicators, hasItem(Radar.Indicator.withMax("AQI", 300)));
        assertThat(indicators, hasItem(Radar.Indicator.withMax("PM2.5", 250)));

        Object name = radar.getName();

        assertThat(name, notNullValue());
        assertThat(name, Is.is(instanceOf(RadarName.class)));

        RadarName radarName = (RadarName) name;
        assertThat(radarName.getShow(), nullValue());
        assertThat(radarName.getTextStyle(), notNullValue());
        assertThat(radarName.getTextStyle().getColor(), Is.is("rgb(238, 197, 102)"));
    }

    @Test
    public void testNotWorkSetters() throws Exception {
        Radar radar = objectMapper.readValue(TEXT_JSON, Radar.class);
        assertThat(radar, notNullValue());

        radar.typeOf(AxisType.category) /* not work */
                .noBoundaryGap()        /* not work */
                .inverse()              /* not work */
                .min(1).max(5)          /* not work */
                .nameRotate(2)          /* not work */
                .nameInMiddle()         /* not work */
                .minInterval(3)         /* not work */
                .interval(10);          /* not work */

        assertThat(radar.getType(), nullValue());
        assertThat(radar.getBoundaryGap(), nullValue());
        assertThat(radar.getInverse(), nullValue());
        assertThat(radar.getMin(), nullValue());
        assertThat(radar.getMax(), nullValue());
        assertThat(radar.getNameRotate(), nullValue());
        assertThat(radar.getNameLocation(), nullValue());
        assertThat(radar.getMinInterval(), nullValue());
        assertThat(radar.getInterval(), nullValue());
    }

    @Test
    public void testItWorkedSetters() throws Exception {
        Radar radar = Radar.circle()
                .splitNumber(5)
                .name(RadarName.styled(
                        Styles.text().color("rgb(238, 197, 102)")
                ))
                .splitLine(SplitLine.showed(
                        Styles.line().color(LINE_COLORS)
                ))
                .splitArea(SplitArea.hidden())
                .axisLine(AxisLine.showed(
                        Styles.line().color("rgba(238, 197, 102, 0.5)")
                ));

        assertThat(radar.getSplitNumber(), Is.is(5));
        assertThat(radar.getShape(), Is.is(Radar.Shape.circle));

        RadarName radarName = (RadarName) radar.getName();

        assertThat(radarName.getTextStyle(), notNullValue());
        assertThat(radarName.getTextStyle().getColor(), Is.is("rgb(238, 197, 102)"));

        SplitLine splitLine = radar.getSplitLine();
        assertThat(splitLine, notNullValue());
        LineStyle splitLineStyle = splitLine.getLineStyle();
        assertThat(splitLineStyle, notNullValue());

        @SuppressWarnings("unchecked")
        List<String> colors = (List<String>) splitLineStyle.getColor();
        for (String color : LINE_COLORS) {
            assertThat(colors, hasItem(color));
        }

        SplitArea splitArea = radar.getSplitArea();
        assertThat(splitArea, notNullValue());
        assertThat(splitArea.getShow(), Is.is(Boolean.FALSE));

        AxisLine axisLine = radar.getAxisLine();
        assertThat(axisLine, notNullValue());
        LineStyle axisLineStyle = axisLine.getLineStyle();
        assertThat(axisLineStyle, notNullValue());
        assertThat(axisLineStyle.getColor(), Is.is("rgba(238, 197, 102, 0.5)"));

        System.out.println(objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(radar));
    }

    @Test
    public void testCenter() throws Exception {
        Radar radar = Radar.circle();

        try {
            radar.center(5, null);
            fail();
        } catch (Exception ex) {
            assertThat(ex, instanceOf(NullPointerException.class));
        }
        assertThat(radar.getCenter(), nullValue());

        try {
            radar.center("50%", "");
            fail();
        } catch (Exception ex) {
            assertThat(ex, instanceOf(IllegalArgumentException.class));
        }
        assertThat(radar.getCenter(), nullValue());

        try {
            radar.center(50, "45%");
        } catch (Exception ex) {
            fail();
        }
        Object[] center = radar.getCenter();
        assertThat(center, notNullValue());
        assertThat(center.length, Is.is(2));
        assertThat(center[0], Is.is(50));
        assertThat(center[1], Is.is("45%"));
    }

    @Test
    public void testRadius() throws Exception {
        Radar radar = Radar.polygon();

        radar.radius(15);

        assertThat(radar.getRadius(), Is.is(15));

        radar.radius(75d);

        assertThat(radar.getRadius(), Is.is("75%"));

        radar.radius(400, 300);

        Object[] radius = (Object[]) radar.getRadius();
        assertThat(radius, notNullValue());
        assertThat(radius.length, Is.is(2));
        assertThat(radius[0], Is.is(400));
        assertThat(radius[1], Is.is(300));

        radar.radius("25%", "40%");

        radius = (Object[]) radar.getRadius();
        assertThat(radius, notNullValue());
        assertThat(radius.length, Is.is(2));
        assertThat(radius[0], Is.is("25%"));
        assertThat(radius[1], Is.is("40%"));

        try {
            // Error type for radius
            radar.setRadius(new HashMap<>());
            fail();
        } catch (Exception ex) {
            assertThat(ex, instanceOf(IllegalArgumentException.class));
        }
    }

}