package com.exadel.aem.toolkit;

import com.exadel.aem.toolkit.api.annotations.widgets.Checkbox;
import com.exadel.aem.toolkit.api.annotations.widgets.DialogField;
import com.exadel.aem.toolkit.api.annotations.widgets.PathField;
import com.exadel.aem.toolkit.api.annotations.widgets.Switch;
import com.exadel.aem.toolkit.api.annotations.widgets.TextField;
import com.exadel.aem.toolkit.api.annotations.widgets.radio.RadioButton;
import com.exadel.aem.toolkit.api.annotations.widgets.radio.RadioGroup;
import com.exadel.aem.toolkit.api.annotations.widgets.rte.RichTextEditor;
import com.exadel.aem.toolkit.api.annotations.widgets.rte.RteFeatures;

@SuppressWarnings("unused")
class SampleDialog {
    private static final String FIELD_TITLE = "title";
    private static final String FIELD_DESCRIPTION = "description";

    private static final String NAME_REFERENCE = "reference_name";
    private static final String LABEL_REFERENCE_FIELD = "reference name";
    private static final String DESCRIPTION_REFERENCE_FIELD = "Description for the reference field.";

    private static final String BASIC_REF_TYPE = "basic";
    private static final String DETAILED_REF_TYPE = "detailed";
    private static final String FIRST_FIELD_NAME = "first_field";
    private static final String SECOND_FIELD = "second_field";
    private static final String THIRD_FIELD = "third_field";

    @DialogField(
            name = FIELD_TITLE,
            label = "title's label",
            description = "title's description",
            required = true,
            ranking = 10
    )
    @TextField
    private String title;

    @DialogField(
            name = FIELD_DESCRIPTION,
            label = "Description's label",
            description = "Description",
            required = true,
            ranking = 20
    )
    @RichTextEditor(
            features = {
                    RteFeatures.LINKS_MODIFYLINK,
                    RteFeatures.LINKS_UNLINK,
                    RteFeatures.SUBSUPERSCRIPT_SUBSCRIPT,
                    RteFeatures.SUBSUPERSCRIPT_SUPERSCRIPT
            }
    )
    private String description;

    @DialogField(
            name = "Field enable",
            label = "Field enable label",
            description = "Field enable description",
            ranking = 30
    )
    @Switch
    private boolean fieldEnabled;

    @DialogField(
            name = NAME_REFERENCE,
            label = LABEL_REFERENCE_FIELD,
            description = DESCRIPTION_REFERENCE_FIELD,
            ranking = 40,
            required = true
    )
    @RadioGroup(buttons = {
            @RadioButton(text = "Basic", value = BASIC_REF_TYPE, checked = true),
            @RadioButton(text = "Detailed", value = DETAILED_REF_TYPE)
    })
    private String reference;

    @DialogField(
            name = FIRST_FIELD_NAME,
            label = "Label to first field",
            description = "Description for first field",
            required = true,
            ranking = 50
    )
    @TextField
    private String firstField;

    @DialogField(
            name = SECOND_FIELD,
            label = "Label to second field",
            description = "Description for second field",
            required = true,
            ranking = 60
    )
    @PathField
    private String secondField;

    @DialogField(
            name = THIRD_FIELD,
            label = "Label to third field",
            description = "Description for third field",
            ranking = 70
    )
    @Checkbox
    private boolean thirdField;
}
