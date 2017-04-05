package pl.pawlik.cymes.blockRenderers;

import org.springframework.stereotype.Service;
import pl.pawlik.cymes.entities.Block;

/**
 * Created by pawlik on 24.03.2017.
 */
@Service
public interface BlockRenderer {
     public String render(Block block);
}
