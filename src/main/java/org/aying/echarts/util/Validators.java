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

package org.aying.echarts.util;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author Fuchun
 * @since 1.0
 */
public class Validators {

    private static final Pattern PERCENT_PATTERN = Pattern.compile("([\\d\\.]+)%");

    @SuppressWarnings("unchecked")
    public static <T> T checkNumber(T n, String name) {
        Objects.requireNonNull(n, name);
        if (n instanceof Number) {
            return n;
        } else if (n instanceof String) {
            String s = ((String) n).trim();
            if (s.isEmpty()) {
                throw new IllegalArgumentException(
                        "The given [" + name + "] value must be not empty");
            }
            return (T) checkPercent(s);
        } else {
            throw new IllegalArgumentException("The given [" + name + "] value is not string or number");
        }
    }

    public static String checkPercent(String input) {
        if (input == null || (input = input.trim()).isEmpty()) {
            return null;
        }
        Matcher m = PERCENT_PATTERN.matcher(input);
        if (m.find()) {
            String numStr = m.group(1);
            try {
                BigDecimal d = new BigDecimal(numStr).setScale(0, RoundingMode.HALF_UP);

                return d.toPlainString().concat("%");
            } catch (NumberFormatException ex) {
                // number error
                return null;
            }
        } else {  // the string number: '100', '12.5'
            try {
                int d = Integer.parseInt(input);

                return String.valueOf(d);
            } catch (NumberFormatException ex) {
                return null;
            }
        }
    }
}
