/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.pawlik.cymes.services.base;

import java.util.List;
import org.springframework.stereotype.Service;
import pl.pawlik.cymes.entities.Block;

/**
 *
 * @author pawlik
 */

@Service
public interface BlockService {
    public String getBlocksHtml(List<Block> blocks);
}
