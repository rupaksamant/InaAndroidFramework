package blueprint.dynamic.framework.model.cms_model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Created by Techjini on 10/21/2016.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Application {

    private ApiElement[] apis;

    public void setApis(ApiElement[] apis) {
        this.apis = apis;
    }

    public ApiElement[] getApis() {
        return apis;
    }

    private Object[] keys;

    public void setKeys(Object[] keys) {
        this.keys = keys;
    }

    public Object[] getKeys() {
        return keys;
    }

    private Database_tablElement[] database_tables;

    public void setDatabase_tables(Database_tablElement[] database_tables) {
        this.database_tables = database_tables;
    }

    public Database_tablElement[] getDatabase_tables() {
        return database_tables;
    }

    private Object[] status_messages;

    public void setStatus_messages(Object[] status_messages) {
        this.status_messages = status_messages;
    }

    public Object[] getStatus_messages() {
        return status_messages;
    }

    private ScreenElement[] screens;

    public void setScreens(ScreenElement[] screens) {
        this.screens = screens;
    }

    public ScreenElement[] getScreens() {
        return screens;
    }

    private Object[] data_status_code;

    public void setData_status_code(Object[] data_status_code) {
        this.data_status_code = data_status_code;
    }

    public Object[] getData_status_code() {
        return data_status_code;
    }

}
