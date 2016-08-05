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

package org.aying.echarts.base;

import org.jetbrains.annotations.Contract;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.regex.Pattern;

/**
 * @author Fuchun
 * @since 1.0
 */
public class JsFunction implements Serializable {

    protected static final Pattern FUNC_PATTERN = Pattern.compile("^function\\s*\\(");

    private static final long serialVersionUID = -3010962153138396348L;

    @Contract("null -> null")
    public static JsFunction withRaw(Object raw) {
        if (raw == null) return null;
        return new JsFunction(raw);
    }

    private final Object raw;

    /* function parameters */
    private List<String> params;
    /* function body */
    private String body;

    public JsFunction(Object raw) {
        this.raw = raw;
        init();
    }

    protected void init() {
        if (raw == null || !(raw instanceof String)) return;
        String func = ((String) raw).trim();
        if (func.isEmpty()) return;
        if (FUNC_PATTERN.matcher(func).lookingAt()) {
            int i = 0, bl = func.indexOf("("), br = func.indexOf(")"),
                    bpl = func.indexOf("{"), bpr = func.lastIndexOf("}");
            if (br - bl > 1) {
                String[] parts = func.substring(bl + 1, br).split(",");
                params = new ArrayList<>(parts.length);
                for (String part : parts) {
                    if (part.length() > 0)
                        params.add(i++, part);
                }
            }
            if (bpr - bpl > 1) {
                body = func.substring(bpl + 1, bpr).trim();
            }
        }
    }

    public Object getRaw() {
        return raw;
    }

    public List<String> getParams() {
        return params;
    }

    public void setParams(List<String> params) {
        this.params = params;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String toRawString() {
        if (raw == null) return null;
        // Not a function
        if (body == null) {
            if (raw instanceof String) {
                return String.format("\"%s\"", raw);
            } else {
                return String.valueOf(raw);
            }
        }
        StringBuilder builder = new StringBuilder(32)
                .append("function(");
        if (params != null && params.size() > 0) {
            int i = 0;
            for (String param : params) {
                builder.append(param);
                if (i < params.size() - 1) {
                    builder.append(",");
                }
                i++;
            }
        }
        builder.append(") {");
        builder.append(body);
        builder.append("}");
        return builder.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof JsFunction)) return false;
        JsFunction function = (JsFunction) o;
        return Objects.equals(raw, function.raw) &&
                Objects.equals(params, function.params) &&
                Objects.equals(body, function.body);
    }

    @Override
    public int hashCode() {
        return Objects.hash(raw, params, body);
    }

    @Override
    public String toString() {
        return String.format("org.aying.echarts.base.JsFunction{raw=%s}", raw);
    }
}
