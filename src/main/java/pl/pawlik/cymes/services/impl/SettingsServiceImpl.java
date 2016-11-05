/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.pawlik.cymes.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.pawlik.cymes.entities.Setting;
import pl.pawlik.cymes.repositories.SettingsRepository;
import pl.pawlik.cymes.services.base.SettingsService;

/**
 *
 * @author pawlik
 */

@Service
public class SettingsServiceImpl implements SettingsService{
    private SettingsRepository repository;
    
    @Autowired
    public SettingsServiceImpl(SettingsRepository repository){
        this.repository = repository;
    }
    
    @Override
    public String getString(String name) {
        return repository.findByNameAndScopeClassIsNull(name).getValue();
    }

    @Override
    public String getString(String name, String scopeClass, Long scopeId) {
        Setting setting = repository.findByNameAndScopeClassAndScopeId(name, scopeClass, scopeId);
        if(setting == null){
            setting = repository.findByNameAndScopeClassIsNull(name);
        }
        
        return setting == null ? null : setting.getValue();
    }
}
