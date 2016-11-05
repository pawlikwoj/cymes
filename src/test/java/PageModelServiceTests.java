
import java.util.ArrayList;
import org.junit.Assert;
import org.junit.Test;
import static org.mockito.Mockito.*;
import org.springframework.ui.Model;
import pl.pawlik.cymes.entities.Block;
import pl.pawlik.cymes.entities.Page;
import pl.pawlik.cymes.services.base.BlockService;
import pl.pawlik.cymes.services.base.PageModelService;
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
        ArrayList<Block> blocks = new ArrayList<>();
        
        when(page.getBlocks()).thenReturn(blocks);
        when(blockService.getBlocksHtml(blocks)).thenReturn("<p>tresc strony</p>");
        PageModelService modelService = new PageModelServiceImpl(blockService);
        
        Model m = modelService.getPageModel(page);
        
        Assert.assertEquals("<p>tresc strony</p>",m.asMap().get("content"));
    }
}
