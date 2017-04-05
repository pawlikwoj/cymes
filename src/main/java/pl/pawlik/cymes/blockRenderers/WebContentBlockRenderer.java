package pl.pawlik.cymes.blockRenderers;

import org.omg.CosNaming._NamingContextExtStub;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.pawlik.cymes.entities.Block;
import pl.pawlik.cymes.services.base.TemplatEngineService;

/**
 * Created by pawlik on 24.03.2017.
 */

@Service("webContentBlockRenderer")
public class WebContentBlockRenderer implements BlockRenderer {

    TemplatEngineService templatEngineService;

    @Autowired
    public WebContentBlockRenderer(TemplatEngineService templatEngineService) {
        this.templatEngineService = templatEngineService;
    }

    @Override
    public String render(Block block) {
        return templatEngineService.procesTemplate(block.getTemplate().getBody(), block.getTiles());
    }
}
