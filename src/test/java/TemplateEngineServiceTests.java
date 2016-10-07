
import java.util.ArrayList;
import java.util.List;
import org.junit.Assert;
import org.junit.Test;
import pl.pawlik.cymes.entities.Tile;
import pl.pawlik.cymes.services.base.TemplatEngineService;
import pl.pawlik.cymes.services.impl.TemplatEngineServiceImpl;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author pawlik
 */
public class TemplateEngineServiceTests {
    TemplatEngineService service = new TemplatEngineServiceImpl();
    
    @Test
    public void shouldProcesTemplates(){
        String template = "<p>${html}</p>";
        List<Tile> list = new ArrayList<>();
        Tile tile = new Tile();
        tile.setName("html");
        tile.setContent("Strona <b>testowa</b>");
        list.add(tile);
        
        String out = service.procesTemplate(template, list);
        
        Assert.assertEquals("<p>Strona <b>testowa</b></p>", out);
        
    }
    
   
    
    
    
}
