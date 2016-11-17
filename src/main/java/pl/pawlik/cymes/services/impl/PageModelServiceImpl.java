/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.pawlik.cymes.services.impl;

import java.util.HashMap;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.ExtendedModelMap;
import org.springframework.ui.Model;
import pl.pawlik.cymes.consts.Settings;
import pl.pawlik.cymes.entities.Block;
import pl.pawlik.cymes.entities.Page;
import pl.pawlik.cymes.entities.Setting;
import pl.pawlik.cymes.repositories.BlockRepository;
import pl.pawlik.cymes.repositories.PageRepository;
import pl.pawlik.cymes.services.base.BlockService;
import pl.pawlik.cymes.services.base.PageModelService;
import pl.pawlik.cymes.services.base.SettingsService;

/**
 *
 * @author pawlik
 */
@Service
public class PageModelServiceImpl implements PageModelService {
    private BlockService blockService;
    private SettingsService settingsService;
    private BlockRepository blockRepository;
    
    @Autowired
    public PageModelServiceImpl(BlockService blockService,SettingsService settingsService,BlockRepository blockRepository) {
        this.blockService = blockService;
        this.settingsService = settingsService;
        this.blockRepository = blockRepository;
    }
    
    @Override
    public Model getPageModel(Page page) {
        Model model = new ExtendedModelMap();
        String content = blockService.getBlocksHtml(page.getBlocks());
        model.addAttribute("content", content);
        
        addPortalSettings(model);
        addSiteWideBlocks(model);
        return model;
    }
    
    private void addPortalSettings(Model model){
        String pageName = settingsService.getString(Settings.PAGE_NAME);
        String pageLogo = settingsService.getString(Settings.PAGE_LOGO);
        model.addAttribute("pageName", pageName);
        model.addAttribute("pageLogo",pageLogo);
    }

    private void addSiteWideBlocks(Model model) {
        List<Block> siteWideBlocks = blockRepository.findBySiteWide(Boolean.TRUE);
        HashMap<String,String> siteWideHash = new HashMap<>();
        for (Block block : siteWideBlocks) {
            String blockHtml = blockService.getBlockHtml(block);
            siteWideHash.put(block.getName(),blockHtml );
            System.out.println(block.getName()+" - "+blockHtml);
        }
        model.addAttribute("siteWideBlock",siteWideHash);
    }
    
    
}
