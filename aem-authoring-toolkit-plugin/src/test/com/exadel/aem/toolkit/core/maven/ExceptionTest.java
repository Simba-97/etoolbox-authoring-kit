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

package com.exadel.aem.toolkit.core.maven;

import com.exadel.aem.toolkit.core.exceptions.PluginException;
import com.exadel.aem.toolkit.test.component.ComplexComponent1;
import com.exadel.aem.toolkit.test.component.ComplexComponent2;
import com.exadel.aem.toolkit.test.component.ComponentWithTabsAndInnerClass;
import com.exadel.aem.toolkit.test.dependson.DependsOnTabAnnotation;
import org.junit.Test;

public class ExceptionTest extends ExceptionTestBase {

    @Test(expected = PluginException.class)
    public void testComponentWithTabsAndInnerClass() {
        testComponent(ComponentWithTabsAndInnerClass.class);
    }

    @Test(expected = PluginException.class)
    public void testComplexComponent1(){
        testComponent(ComplexComponent1.class);
    }

    @Test(expected = PluginException.class)
    public void testComplexComponent2(){
        testComponent(ComplexComponent2.class);
    }

    @Test(expected = PluginException.class)
    public void testDependsOnTabAnnotation(){
        testComponent(DependsOnTabAnnotation.class);
    }
}