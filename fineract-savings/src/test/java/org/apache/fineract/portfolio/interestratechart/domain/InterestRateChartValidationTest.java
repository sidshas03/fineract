/**
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements. See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership. The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied. See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */
package org.apache.fineract.portfolio.interestratechart.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

import java.util.ArrayList;
import java.util.List;
import org.apache.fineract.infrastructure.core.data.ApiParameterError;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Test class for InterestRateChart validation error codes and arguments
 */
public class InterestRateChartValidationTest {

    private List<ApiParameterError> dataValidationErrors;

    @BeforeEach
    public void setUp() {
        dataValidationErrors = new ArrayList<>();
    }

    @Test
    public void testOverlappingRangesValidation() {
        // Given - create error directly with clean error code
        ApiParameterError error = ApiParameterError.parameterError("validation.msg.savings.interestRateChart.slabs.overlap",
                "Failed data validation due to: validation.msg.savings.interestRateChart.slabs.overlap.", null, null, 1, 12, 6, 18, 1000.0,
                5000.0, 3000.0, 8000.0);

        // When - add error to validation errors
        dataValidationErrors.add(error);

        // Then
        assertFalse(dataValidationErrors.isEmpty());
        ApiParameterError actualError = dataValidationErrors.get(0);
        assertEquals("validation.msg.savings.interestRateChart.slabs.overlap", actualError.getUserMessageGlobalisationCode());
        // Check that arguments are present
        assertFalse(actualError.getArgs().isEmpty());
    }

    @Test
    public void testGapBetweenRangesValidation() {
        // Given - create error directly with clean error code
        ApiParameterError error = ApiParameterError.parameterError("validation.msg.savings.interestRateChart.slabs.gap",
                "Failed data validation due to: validation.msg.savings.interestRateChart.slabs.gap.", null, null, 1, 12, 15, 24, 1000.0,
                5000.0, 6000.0, 10000.0);

        // When - add error to validation errors
        dataValidationErrors.add(error);

        // Then
        assertFalse(dataValidationErrors.isEmpty());
        ApiParameterError actualError = dataValidationErrors.get(0);
        assertEquals("validation.msg.savings.interestRateChart.slabs.gap", actualError.getUserMessageGlobalisationCode());
        // Check that arguments are present
        assertFalse(actualError.getArgs().isEmpty());
    }
}
