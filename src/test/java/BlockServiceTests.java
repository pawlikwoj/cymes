import java.util.ArrayList;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import pl.pawlik.cymes.entities.Block;
import pl.pawlik.cymes.entities.Template;
import pl.pawlik.cymes.entities.Tile;
import pl.pawlik.cymes.services.base.BlockService;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author pawlik
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/applicationContextTestAll.xml","file:src/main/webapp/WEB-INF/applicationContext.xml"})
public class BlockServiceTests {
    @Autowired
    BlockService blockService;
    
    @Test
    public void shouldGenerateHtml(){
        ArrayList<Block> list = new ArrayList<>(); 
        Block b = new Block();
        
        Template t = new Template();
        t.setBody("<b>${tilestr}</b>");
        
        Tile tile = new Tile();
        tile.setName("tilestr");
        tile.setContent("Nazwa towaru");
        
        ArrayList<Tile> tiles = new ArrayList<>();
        tiles.add(tile);
        
        b.setTemplate(t);
        b.setTiles(tiles);
        list.add(b);
        
        String out = blockService.getBlocksHtml(list);
        
        Assert.assertEquals("<b>Nazwa towaru</b>", out);
    }
}
