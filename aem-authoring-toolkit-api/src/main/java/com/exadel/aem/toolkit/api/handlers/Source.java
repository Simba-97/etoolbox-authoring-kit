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

public interface Source {

    Object fromValueMap(String s);

    Object addToValueMap(String s1, String s2);

    <T> T adaptTo(Class<T> t);

    Object getSource();

    Class<?> getProcessedClass();

    void setProcessedClass(Class<?> processedClass);
}
