/*
 * Copyright 2019-2023 the original author or authors.
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

package org.vividus.saucelabs;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.saucelabs.saucerest.DataCenter;

import org.junit.jupiter.api.Test;
import org.vividus.selenium.cloud.AbstractCloudTestLinkPublisher.GetCloudTestUrlException;

class SauceLabsTestLinkPublisherTests
{
    @Test
    void shouldReturnSessionUrl() throws GetCloudTestUrlException
    {
        SauceLabsTestLinkPublisher linkPublisher = new SauceLabsTestLinkPublisher(DataCenter.EU_CENTRAL, null, null,
                null);
        assertEquals("https://app.eu-central-1.saucelabs.com/tests/session-id",
                linkPublisher.getCloudTestUrl("session-id"));
    }
}
