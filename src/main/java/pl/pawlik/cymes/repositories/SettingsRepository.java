/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.pawlik.cymes.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pl.pawlik.cymes.entities.Setting;

/**
 *
 * @author pawlik
 */
@Repository
public interface SettingsRepository extends CrudRepository<Setting, Long> {
    public Setting findByNameAndScopeClassIsNull(String name);
    public Setting findByNameAndScopeClassAndScopeId(String name, String scopeClass, long scopeId);
}

