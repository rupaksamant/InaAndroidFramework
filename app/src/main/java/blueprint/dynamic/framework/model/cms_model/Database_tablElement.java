/* Generated by JavaFromJSON */
/*http://javafromjson.dashingrocket.com*/

package blueprint.dynamic.framework.model.cms_model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Database_tablElement {
	private Object[] fields;

 	public void setFields(Object[] fields) {
		this.fields = fields;
	}

	public Object[] getFields() {
		return fields;
	}

	private String table_name;

 	public void setTable_name(String table_name) {
		this.table_name = table_name;
	}

	public String getTable_name() {
		return table_name;
	}

}