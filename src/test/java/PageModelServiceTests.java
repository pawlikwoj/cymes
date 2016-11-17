
import java.util.ArrayList;
import java.util.Map;
import org.junit.Assert;
import org.junit.Test;
import static org.mockito.Mockito.*;
import org.springframework.ui.Model;
import pl.pawlik.cymes.consts.Settings;
import pl.pawlik.cymes.entities.Block;
import pl.pawlik.cymes.entities.Page;
import pl.pawlik.cymes.entities.Template;
import pl.pawlik.cymes.entities.Tile;
import pl.pawlik.cymes.repositories.BlockRepository;
import pl.pawlik.cymes.services.base.BlockService;
import pl.pawlik.cymes.services.base.PageModelService;
import pl.pawlik.cymes.services.base.SettingsService;
import pl.pawlik.cymes.services.impl.PageModelServiceImpl;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author pawlik
 */
public class PageModelServiceTests {
    
    @Test
    public void shouldGetModelByPage(){
        Page page = mock(Page.class);
        BlockService blockService=mock(BlockService.class);
        SettingsService settingsService = mock(SettingsService.class);
        BlockRepository blockRepository = mock(BlockRepository.class);
        ArrayList<Block> blocks = new ArrayList<>();
        
        when(page.getBlocks()).thenReturn(blocks);
        when(blockService.getBlocksHtml(blocks)).thenReturn("<p>tresc strony</p>");
       
        when(settingsService.getString(Settings.PAGE_NAME)).thenReturn("Serwis Testowy");
        ArrayList<Block> blocksSiteWide = new ArrayList<>();
        Block b = new Block();
        Template t = new Template();
        t.setBody("${html}");
        Tile tile = new Tile();
        tile.setName("html");
        tile.setContent("&copy; Cymes 2016");
        ArrayList<Tile> tiles = new ArrayList<>();
        tiles.add(tile);
        b.setName("footerBlock");
        b.setTemplate(t);
        b.setTiles(tiles);
        blocksSiteWide.add(b);
        when(blockRepository.findBySiteWide(Boolean.TRUE)).thenReturn(blocksSiteWide);
        when(blockService.getBlockHtml(b)).thenReturn("&copy; Cymes 2016");
        PageModelService modelService = new PageModelServiceImpl(blockService,settingsService,blockRepository);
        
        Model m = modelService.getPageModel(page);
        String sitewideHtml = ( (Map<String,String>) m.asMap().get("siteWideBlock")).get("footerBlock");
       
        Assert.assertEquals("<p>tresc strony</p>",m.asMap().get("content"));
        Assert.assertEquals("Serwis Testowy",m.asMap().get("pageName"));
        Assert.assertEquals("&copy; Cymes 2016",sitewideHtml);
    }
}
