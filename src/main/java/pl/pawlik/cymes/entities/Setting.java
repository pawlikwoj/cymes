/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.pawlik.cymes.entities;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 *
 * @author pawlik
 */
@Entity
public class Setting {
    @Id
    private long settingId;
    
    private String name;
    private String scopeClass;
    private long scopeId;
    
    private String val;

    public long getSettingId() {
        return settingId;
    }

    public void setSettingId(long settingId) {
        this.settingId = settingId;
    }

    public String getKey() {
        return name;
    }

    public void setKey(String key) {
        this.name = key;
    }

    public String getScopeClass() {
        return scopeClass;
    }

    public void setScopeClass(String scopeClass) {
        this.scopeClass = scopeClass;
    }

    public long getScopeId() {
        return scopeId;
    }

    public void setScopeId(long scopeId) {
        this.scopeId = scopeId;
    }

    public String getValue() {
        return val;
    }

    public void setValue(String value) {
        this.val = value;
    }
    
    
}
