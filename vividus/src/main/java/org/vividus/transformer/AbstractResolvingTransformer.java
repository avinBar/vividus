/*
 * Copyright 2019-2024 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.vividus.transformer;

import java.util.List;
import java.util.function.UnaryOperator;

import org.jbehave.core.model.ExamplesTable.TableProperties;
import org.jbehave.core.model.ExamplesTable.TableRows;
import org.jbehave.core.model.TableParsers;
import org.vividus.util.ExamplesTableProcessor;

abstract class AbstractResolvingTransformer implements ExtendedTableTransformer
{
    private final UnaryOperator<String> resolver;

    AbstractResolvingTransformer(UnaryOperator<String> resolver)
    {
        this.resolver = resolver;
    }

    @Override
    public String transform(String tableAsString, TableParsers tableParsers, TableProperties properties)
    {
        TableRows tableRows = tableParsers.parseRows(tableAsString, properties);
        List<List<String>> rows = tableRows.getRows();
        rows.forEach(row -> row.replaceAll(resolver::apply));
        return ExamplesTableProcessor.buildExamplesTable(tableRows.getHeaders(), rows, properties);
    }
}
