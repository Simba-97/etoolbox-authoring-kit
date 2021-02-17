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
package com.exadel.aem.toolkit.api.annotations.layouts;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import com.exadel.aem.toolkit.api.annotations.meta.PropertyMapping;
import com.exadel.aem.toolkit.api.annotations.meta.PropertyRendering;
import com.exadel.aem.toolkit.api.annotations.meta.ResourceType;
import com.exadel.aem.toolkit.api.annotations.meta.ResourceTypes;
import com.exadel.aem.toolkit.api.annotations.meta.StringTransformation;

/**
 * Used to define tabbed layout for a TouchUI dialog and/or to set up
 * a <a href="https://helpx.adobe.com/experience-manager/6-5/sites/developing/using/reference-materials/granite-ui/api/jcr_root/libs/granite/ui/components/coral/foundation/tabs/index.html">
 * Tabs</a> widget inside dialog
 */
@Target({ElementType.FIELD, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@ResourceType(ResourceTypes.TABS)
@PropertyMapping
public @interface Tabs {

    /**
     * Enumerates the tabs to be rendered within this container
     * @return One or more {@link Tab} annotations
     */
    Tab[] tabs();

    /**
     * Determines the orientation of {@code tabs} when used as a dialog widget.
     * <p>Note that the property is effective for <i>Tabs widget</i> and not the tabbed layout</p>
     * @return One of {@link TabsOrientation} values
     */
    @PropertyRendering(transform = StringTransformation.LOWERCASE)
    TabsOrientation orientation() default TabsOrientation.HORIZONTAL;

    /**
     * Determines the size of the tabs.
     * <p>Note that the property is effective for <i>Tabs widget</i> and not the tabbed layout</p>
     * @return One of {@link TabsSize} values
     */
    TabsSize size() default TabsSize.M;

    /**
     * Determines whether to put vertical margin to the root element.
     * <p>Note that the property is effective for <i>Tabs widget</i> and not the tabbed layout</p>
     * @return True or false
     */
    boolean margin() default false;

    /**
     * Make the element maximized to fill the available space.
     * <p>Note that the property is effective for <i>Tabs widget</i> and not the tabbed layout</p>
     * @return True or false
     */
    boolean maximized() default false;

    /**
     * Determines the name of the feature responsible for interaction. See
     * <a href="https://helpx.adobe.com/experience-manager/6-5/sites/developing/using/reference-materials/granite-ui/api/jcr_root/libs/granite/ui/components/coral/foundation/clientlibs/foundation/js/tracking/index.html">
     * Foundation tracking</a> for detail.
     * <p>Note that the property is effective for <i>Tabs widget</i> and not the tabbed layout</p>
     * @return String value (optional)
     */
    String trackingFeature() default "";

    /**
     * Determines the name of the widget responsible for interaction. See
     * <a href="https://helpx.adobe.com/experience-manager/6-5/sites/developing/using/reference-materials/granite-ui/api/jcr_root/libs/granite/ui/components/coral/foundation/clientlibs/foundation/js/tracking/index.html">
     * Foundation tracking</a> for detail.
     * <p>Note that the property is effective for <i>Tabs widget</i> and not the tabbed layout</p>
     * @return String value (optional)
     */
    String trackingWidgetName() default "";

    /**
     * Determines the layout mode of this tabs collection.
     * <p>Note that the property is effective for <i>Tabs layout</i> and not the widget</p>
     * @return One of {@link LayoutType} values
     */
    @PropertyRendering(
        transform = StringTransformation.LOWERCASE,
        ignoreValues = "default"
    )
    LayoutType type() default LayoutType.DEFAULT;


    /**
     * Determines whether to add padding to each panel.
     * <p>Note that the property is effective for <i>Tabs layout</i> and not the widget</p>
     * @return True or false
     */
    @PropertyRendering(ignoreValues = "true")
    boolean padding() default true;
}
