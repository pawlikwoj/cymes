
import static org.junit.Assert.*;
import org.junit.Test;
import static org.mockito.Mockito.*;
import pl.pawlik.cymes.consts.Settings;
import pl.pawlik.cymes.entities.Page;
import pl.pawlik.cymes.services.base.SettingsService;
import pl.pawlik.cymes.services.base.ThemeService;
import pl.pawlik.cymes.services.impl.ThemeServiceImpl;

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
        ThemeService service = new ThemeServiceImpl(settingsService);
        
        String theme = service.getTheme(page);
        String theme2 = service.getTheme(page2);
        
        assertEquals("dark", theme);
        assertEquals("light", theme2);
    }
}
