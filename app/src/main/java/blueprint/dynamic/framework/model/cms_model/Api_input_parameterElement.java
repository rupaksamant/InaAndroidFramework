package blueprint.dynamic.framework.model.cms_model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Created by Techjini on 10/19/2016.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Api_input_parameterElement {
    private String value_from;

    public void setValue_from(String value_from) {
        this.value_from = value_from;
    }

    public String getValue_from() {
        return value_from;
    }

    private String key_name;

    public void setKey_name(String key_name) {
        this.key_name = key_name;
    }

    public String getKey_name() {
        return key_name;
    }

}