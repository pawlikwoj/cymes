/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this theme file, choose Tools | Templates
 * and open the theme in the editor.
 */

import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import pl.pawlik.cymes.repositories.SettingsRepository;
import pl.pawlik.cymes.services.base.SettingsService;
import pl.pawlik.cymes.services.impl.SettingsServiceImpl;

/**
 *
 * @author pawlik
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/applicationContextTestAll.xml","file:src/main/webapp/WEB-INF/applicationContext.xml"})
@WebAppConfiguration
public class SettingsServiceTests {
    @Autowired
    SettingsRepository settingsRepository;
    
    public SettingsServiceTests() {
    }

    @Test
    public void shouldGetPageSettings(){
        SettingsService settings = new SettingsServiceImpl(settingsRepository);
        
        String theme = settings.getString("PAGE_THEME");
        
        assertEquals("light", theme);
    }
    
    @Test
    public void shouldGetPageSettingForConcreteObject(){
        SettingsService settings = new SettingsServiceImpl(settingsRepository);
        
        String theme1 = settings.getString("PAGE_THEME","pl.pawlik.cymes.entities.Page",1l);
        String theme2 = settings.getString("PAGE_THEME","pl.pawlik.cymes.entities.Page",2l);
        String nullout = settings.getString("PAGE_THEME_TRALALA","pl.pawlik.cymes.entities.Page",2l);
        
        assertEquals("light", theme1);
        assertEquals("dark", theme2);
        assertNull(nullout);
    } 
    
    @Test
    public void shoudGetSettingFromRepository(){
        String value = settingsRepository.findByNameAndScopeClassIsNull("PAGE_THEME").getValue();
        String value1 = settingsRepository.findByNameAndScopeClassAndScopeId("PAGE_THEME","pl.pawlik.cymes.entities.Page",2).getValue();
       
        assertEquals("light", value);
        assertEquals("dark", value1);
    }
}
