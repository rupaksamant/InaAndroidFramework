package blueprint.dynamic.framework.model.cms_model;

/**
 * Created by Techjini on 10/19/2016.
 */
public class ApiElement {
    private java.lang.String storage_type;

    public void setStorage_type(java.lang.String storage_type) {
        this.storage_type = storage_type;
    }

    public java.lang.String getStorage_type() {
        return storage_type;
    }

    private java.lang.String api_url;

    public void setApi_url(java.lang.String api_url) {
        this.api_url = api_url;
    }

    public java.lang.String getApi_url() {
        return api_url;
    }

    private java.lang.String storage_field_name;

    public void setStorage_field_name(java.lang.String storage_field_name) {
        this.storage_field_name = storage_field_name;
    }

    public java.lang.String getStorage_field_name() {
        return storage_field_name;
    }

    private Api_input_parameterElement[] api_input_parameters;

    public void setApi_input_parameters(Api_input_parameterElement[] api_input_parameters) {
        this.api_input_parameters = api_input_parameters;
    }

    public Api_input_parameterElement[] getApi_input_parameters() {
        return api_input_parameters;
    }

}