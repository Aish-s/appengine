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

package com.google.appengine.api.modules.dev;

import com.google.appengine.tools.development.testing.LocalServiceTestConfig;
import com.google.appengine.tools.development.testing.LocalServiceTestHelper;

/**
 * {@link LocalServiceTestConfig} for accessing modules service in tests.
 */
public class LocalModulesServiceTestConfig implements LocalServiceTestConfig {
  @Override
  public void setUp() {
  }

  @Override
  public void tearDown() {
  }

  static LocalModulesService getLocalModulesService() {
    return (LocalModulesService) LocalServiceTestHelper.getLocalService(
        LocalModulesService.PACKAGE);
  }
}
