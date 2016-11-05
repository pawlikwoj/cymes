/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.pawlik.cymes.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.pawlik.cymes.consts.Settings;
import pl.pawlik.cymes.entities.Page;
import pl.pawlik.cymes.services.base.SettingsService;
import pl.pawlik.cymes.services.base.ThemeService;

/**
 *
 * @author pawlik
 */
@Service
public class ThemeServiceImpl implements ThemeService{
    private SettingsService settingsService;

    @Autowired
    public ThemeServiceImpl(SettingsService settingsService) {
        this.settingsService = settingsService;
    }

    @Override
    public String getTheme(Page page) {
        String theme;
        if(page.getTheme() != null) {
            theme = page.getTheme();
        } else {
            theme = settingsService.getString(Settings.PAGE_THEME);
        }
        
        return theme;
    }
    
}
