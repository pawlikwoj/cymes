/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.pawlik.cymes.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.pawlik.cymes.consts.Settings;
import pl.pawlik.cymes.dto.ThemeDTO;
import pl.pawlik.cymes.entities.Page;
import pl.pawlik.cymes.services.base.SettingsService;
import pl.pawlik.cymes.services.base.ThemeService;

import javax.servlet.ServletContext;

/**
 *
 * @author pawlik
 */
@Service
public class ThemeServiceImpl implements ThemeService{


    private SettingsService settingsService;
    private ServletContext servletContext;

    @Autowired
    public ThemeServiceImpl(SettingsService settingsService, ServletContext servletContext) {
        this.settingsService = settingsService;
        this.servletContext = servletContext;
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

    @Override
    public ThemeDTO getThemeForModel(Page page) {
        String theme = this.getTheme(page);
        ThemeDTO dto = new ThemeDTO();
        dto.setName(theme);
        dto.setPath(servletContext.getContextPath()+"/resources/"+theme);
        return dto;
    }
    
}
