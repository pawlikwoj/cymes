/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.pawlik.cymes.services.base;

import java.util.List;
import org.springframework.stereotype.Service;
import pl.pawlik.cymes.entities.Tile;

/**
 *
 * @author pawlik
 */
@Service
public interface TemplatEngineService {
    public String procesTemplate(String template, List<Tile> tiles);
}
