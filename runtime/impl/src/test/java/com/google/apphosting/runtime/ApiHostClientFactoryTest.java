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

package com.google.apphosting.runtime;

import com.google.common.truth.Expect;
import java.util.OptionalInt;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class ApiHostClientFactoryTest {
  @Rule public Expect expect = Expect.create();

  @Test
  public void trustedHostSyntax() {
    String[] wrongTrustedHosts = {"localhost:", "localhost:notanumber", ":12345"};
    for (String trustedHost : wrongTrustedHosts) {
      ApiHostClientFactory factory = new ApiHostClientFactory();
      try {
        factory.newAPIHost(trustedHost, OptionalInt.empty());
        expect.withMessage("Did not get expected exception for %s", trustedHost).fail();
      } catch (IllegalArgumentException | IllegalStateException expected) {
        expect.that(expected.getMessage()).contains(trustedHost);
      }
    }
  }
}
