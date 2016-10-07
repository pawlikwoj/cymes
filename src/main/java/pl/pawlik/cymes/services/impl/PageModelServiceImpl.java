/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.pawlik.cymes.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.ExtendedModelMap;
import org.springframework.ui.Model;
import pl.pawlik.cymes.entities.Page;
import pl.pawlik.cymes.repositories.PageRepository;
import pl.pawlik.cymes.services.base.BlockService;
import pl.pawlik.cymes.services.base.PageModelService;
import pl.pawlik.cymes.services.base.TemplatEngineService;

/**
 *
 * @author pawlik
 */
@Service
public class PageModelServiceImpl implements PageModelService {
    @Autowired
    PageRepository pageRepository;
    @Autowired
    BlockService blockService;
    
    @Override
    @Transactional
    public Model getPageModel(String pageUrl) {
        Model model = new ExtendedModelMap();
        Page page = pageRepository.findByUrl(pageUrl);
        String content = blockService.getBlocksHtml(page.getBlocks());
        model.addAttribute("content", content);
        return model;
    }
}
