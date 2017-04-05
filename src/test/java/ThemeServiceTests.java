
import static org.junit.Assert.*;
import org.junit.Test;
import static org.mockito.Mockito.*;
import pl.pawlik.cymes.consts.Settings;
import pl.pawlik.cymes.dto.ThemeDTO;
import pl.pawlik.cymes.entities.Page;
import pl.pawlik.cymes.services.base.SettingsService;
import pl.pawlik.cymes.services.base.ThemeService;
import pl.pawlik.cymes.services.impl.ThemeServiceImpl;

import javax.servlet.ServletContext;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author pawlik
 */
public class ThemeServiceTests {
    
    @Test
    public void shouldGetThemeForPage(){
        Page page = new Page();
        page.setTheme("dark");
        Page page2 = new Page();
        SettingsService settingsService = mock(SettingsService.class);
        when(settingsService.getString(Settings.PAGE_THEME)).thenReturn("light");
        ServletContext servletContext = mock(ServletContext.class);
        when(servletContext.getContextPath()).thenReturn("/contextPath");
        ThemeService service = new ThemeServiceImpl(settingsService,servletContext);
        
        String theme = service.getTheme(page);
        String theme2 = service.getTheme(page2);
        
        assertEquals("dark", theme);
        assertEquals("light", theme2);
    }

    @Test
    public void shouldGetThemeForModel(){
        Page page = new Page();
        page.setTheme("dark");

        SettingsService settingsService = mock(SettingsService.class);
        when(settingsService.getString(Settings.PAGE_THEME)).thenReturn("light");
        ServletContext servletContext = mock(ServletContext.class);
        when(servletContext.getContextPath()).thenReturn("/contextPath");

        ThemeService service = new ThemeServiceImpl(settingsService,servletContext);

        ThemeDTO dto = service.getThemeForModel(page);

        assertEquals("/contextPath/resources/dark",dto.getPath());
    }
}
