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
package com.exadel.aem.toolkit.plugin.handlers.widget;

import java.util.function.BiConsumer;

import org.apache.commons.lang3.StringUtils;

import com.exadel.aem.toolkit.api.annotations.widgets.imageupload.ImageUpload;
import com.exadel.aem.toolkit.api.handlers.Source;
import com.exadel.aem.toolkit.api.handlers.Target;
import com.exadel.aem.toolkit.plugin.util.DialogConstants;

/**
 * {@code BiConsumer<Source, Target>} implementation used to create markup responsible for Granite UI {@code ColorField} widget functionality
 * within the {@code cq:dialog} node
 */
class ImageUploadHandler implements BiConsumer<Source, Target> {
    /**
     * Processes the user-defined data and writes it to {@link Target}
     * @param source Current {@link Source} instance
     * @param target Current {@link Target} instance
     */
    @Override
    @SuppressWarnings({"deprecation", "squid:S1874"}) // the "clas" property is to remain for compatibility reasons until v.2.0.0
    public void accept(Source source, Target target) {
        ImageUpload imageUpload = source.adaptTo(ImageUpload.class);
        if (StringUtils.isNotBlank(imageUpload.clas())) {
            target.attribute(DialogConstants.PN_CLASS, imageUpload.clas());
        }
        String fileRef = target.getAttribute(DialogConstants.PN_FILE_REFERENCE_PARAMETER);
        if (StringUtils.isNotBlank(fileRef) && !StringUtils.startsWith(fileRef, DialogConstants.RELATIVE_PATH_PREFIX)) {
            target.attribute(DialogConstants.PN_FILE_REFERENCE_PARAMETER, DialogConstants.RELATIVE_PATH_PREFIX + fileRef);
        }
    }
}