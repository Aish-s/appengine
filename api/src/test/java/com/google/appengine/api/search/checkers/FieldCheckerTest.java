/*
 * Copyright 2021 Google LLC
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

package com.google.appengine.api.search.checkers;

import static com.google.common.truth.Truth.assertThat;
import static org.junit.Assert.assertThrows;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

/** Tests for {@link FieldChecker}. */
@RunWith(JUnit4.class)
public class FieldCheckerTest {
  @Test
  public void testSortExpression() {
    FieldChecker.checkExpression("distance(foo, geopoint(13.02,0))");
    IllegalArgumentException e =
        assertThrows(
            IllegalArgumentException.class,
            () -> FieldChecker.checkSortExpression("distance(foo,, geopoint(13.02,0))"));
    assertThat(e)
        .hasMessageThat()
        .isEqualTo(
            "Failed to parse sort expression 'distance(foo,, geopoint(13.02,0))': parse error at"
                + " line 1 position 13");
  }
}
