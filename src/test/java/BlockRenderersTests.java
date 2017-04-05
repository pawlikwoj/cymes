import org.junit.Assert;
import org.junit.Test;
import pl.pawlik.cymes.blockRenderers.WebContentBlockRenderer;
import pl.pawlik.cymes.entities.Block;
import pl.pawlik.cymes.entities.Template;
import pl.pawlik.cymes.entities.Tile;
import pl.pawlik.cymes.services.base.TemplatEngineService;
import pl.pawlik.cymes.services.impl.TemplatEngineServiceImpl;

import java.util.ArrayList;

/**
 * Created by pawlik on 24.03.2017.
 */
public class BlockRenderersTests {

    @Test
    public void shouldRenderWebContent(){
        TemplatEngineService templatEngineService = new TemplatEngineServiceImpl();
        WebContentBlockRenderer renderer = new WebContentBlockRenderer(templatEngineService);

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

        String html = renderer.render(b);

        Assert.assertEquals("<b>Nazwa towaru</b>",html);
    }
}
