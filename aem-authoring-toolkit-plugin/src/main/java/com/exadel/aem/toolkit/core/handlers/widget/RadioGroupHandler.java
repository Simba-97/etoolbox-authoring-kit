/*
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
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
package com.exadel.aem.toolkit.core.handlers.widget;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.function.BiConsumer;

import org.apache.commons.lang3.ArrayUtils;
import org.w3c.dom.Element;

import com.exadel.aem.toolkit.api.annotations.widgets.radio.RadioGroup;
import com.exadel.aem.toolkit.core.handlers.Handler;
import com.exadel.aem.toolkit.core.util.DialogConstants;

public class RadioGroupHandler implements Handler, BiConsumer<Element, Field> {
    @Override
    public void accept(Element element, Field field) {
        RadioGroup radioGroup = field.getDeclaredAnnotation(RadioGroup.class);
        if(ArrayUtils.isNotEmpty(radioGroup.buttons())){
            Element items = (Element) element.appendChild(getXmlUtil().createNodeElement(DialogConstants.NN_ITEMS));
            Arrays.stream(radioGroup.buttons()).forEach(button -> {
                Element item = (Element) items.appendChild(getXmlUtil().createNodeElement(getXmlUtil().getUniqueName(button.value(), items)));
                getXmlUtil().mapProperties(item, button);
            });
        }
        getXmlUtil().appendAcsCommonsList(element, radioGroup.acsListPath(), radioGroup.acsListResourceType());
    }
}
