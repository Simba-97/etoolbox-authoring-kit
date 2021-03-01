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
package com.exadel.aem.toolkit.api.annotations.meta;

/**
 * Contains possible values of {@link com.exadel.aem.toolkit.api.annotations.meta.Scope} annotation
 */
@SuppressWarnings("unused")
public enum Scope {
    COMPONENT {
        @Override
        public String toString() {
            return ".content.xml";
        }
    },
    CQ_DIALOG {
        @Override
        public String toString() {
            return "_cq_dialog.xml";
        }
    },
    CQ_DESIGN_DIALOG {
        @Override
        public String toString() {
            return "_cq_design_dialog.xml";
        }
    },
    CQ_EDIT_CONFIG {
        @Override
        public String toString() {
            return "_cq_editConfig.xml";
        }
    },
    CQ_CHILD_EDIT_CONFIG {
        @Override
        public String toString() {
            return "_cq_childEditConfig.xml";
        }
    },
    CQ_HTML_TAG {
        @Override
        public String toString() {
            return "_cq_htmlTag.xml";
        }
    }
}