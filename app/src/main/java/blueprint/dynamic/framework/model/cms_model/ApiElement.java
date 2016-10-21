package blueprint.dynamic.framework.model.cms_model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Created by Techjini on 10/19/2016.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class ApiElement {
    private String storage_type;

    public void setStorage_type(String storage_type) {
        this.storage_type = storage_type;
    }

    public String getStorage_type() {
        return storage_type;
    }

    private String api_url;

    public void setApi_url(String api_url) {
        this.api_url = api_url;
    }

    public String getApi_url() {
        return api_url;
    }

    private String storage_field_name;

    public void setStorage_field_name(String storage_field_name) {
        this.storage_field_name = storage_field_name;
    }

    public String getStorage_field_name() {
        return storage_field_name;
    }

    private Api_input_parameterElement[] api_input_parameters;

    public void setApi_input_parameters(Api_input_parameterElement[] api_input_parameters) {
        this.api_input_parameters = api_input_parameters;
    }

    public Api_input_parameterElement[] getApi_input_parameters() {
        return api_input_parameters;
    }

    private String api_input_type;

    public void setApi_input_type(String api_input_type) {
        this.api_input_type = api_input_type;
    }

    public String getApi_input_type() {
        return api_input_type;
    }

}