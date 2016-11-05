/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.pawlik.cymes.services.base;

import org.springframework.stereotype.Service;
import pl.pawlik.cymes.entities.Page;

/**
 *
 * @author pawlik
 */
@Service
public interface ThemeService {

    public String getTheme(Page page);
    
}
