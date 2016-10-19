package blueprint.dynamic.framework.model.cms_model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Created by Techjini on 10/19/2016.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Api_input_parameterElement {
    private java.lang.String value_from;

    public void setValue_from(java.lang.String value_from) {
        this.value_from = value_from;
    }

    public java.lang.String getValue_from() {
        return value_from;
    }

    private java.lang.String key_name;

    public void setKey_name(java.lang.String key_name) {
        this.key_name = key_name;
    }

    public java.lang.String getKey_name() {
        return key_name;
    }

}