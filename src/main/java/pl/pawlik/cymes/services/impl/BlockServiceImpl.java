/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.pawlik.cymes.services.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.pawlik.cymes.entities.Block;
import pl.pawlik.cymes.services.base.BlockService;
import pl.pawlik.cymes.services.base.TemplatEngineService;

/**
 *
 * @author pawlik
 */
@Service
public class BlockServiceImpl implements BlockService{
    @Autowired
    TemplatEngineService templatEngineService;
    
    @Override
    public String getBlocksHtml(List<Block> blocks) {
        String html="";
        
        html = blocks
                .stream()
                .map((block) -> templatEngineService.procesTemplate(block.getTemplate().getBody(), block.getTiles()))
                .reduce(html, String::concat);
        return html;
    }
    
}
