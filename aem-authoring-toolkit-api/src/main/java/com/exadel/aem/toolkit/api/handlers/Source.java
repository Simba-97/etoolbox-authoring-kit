/*
 * Licensed under the Apache License, Version 2.0 (the "License").
 * You may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.exadel.aem.toolkit.api.handlers;

import java.util.Optional;

public interface Source {

    String getName();

    Class<?> getDeclaringClass();

    Class<?> getReportingClass();

    Class<?> getValueType();

    boolean isValid();

    <T> T adaptTo(Class<T> adaptation);

    default <T> Optional<T> tryAdaptTo(Class<T> adaptation) {
        return Optional.ofNullable(adaptTo(adaptation));
    }
}