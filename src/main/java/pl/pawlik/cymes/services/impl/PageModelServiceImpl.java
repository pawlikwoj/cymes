/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.pawlik.cymes.services.impl;

import java.util.HashMap;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.ui.ExtendedModelMap;
import org.springframework.ui.Model;
import pl.pawlik.cymes.consts.Settings;
import pl.pawlik.cymes.dto.ThemeDTO;
import pl.pawlik.cymes.entities.Block;
import pl.pawlik.cymes.entities.Page;
import pl.pawlik.cymes.repositories.BlockRepository;
import pl.pawlik.cymes.services.base.BlockService;
import pl.pawlik.cymes.services.base.PageModelService;
import pl.pawlik.cymes.services.base.SettingsService;
import pl.pawlik.cymes.services.base.ThemeService;

/**
 *
 * @author pawlik
 */
@Service
public class PageModelServiceImpl implements PageModelService {
    private BlockService blockService;
    private SettingsService settingsService;
    private BlockRepository blockRepository;
    private ThemeService themeService;
    
    @Autowired
    public PageModelServiceImpl(BlockService blockService,SettingsService settingsService,BlockRepository blockRepository,ThemeService themeService) {
        this.blockService = blockService;
        this.settingsService = settingsService;
        this.blockRepository = blockRepository;
        this.themeService = themeService;
    }
    
    @Override
    public Model getPageModel(Page page) {
        Model model = new ExtendedModelMap();
        
        addPageSpecificElements(model,page);
        addPortalSettings(model);
        addSiteWideBlocks(model);
        addUserInfo(model);
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
        }
        model.addAttribute("siteWideBlock",siteWideHash);
    }

    private void addPageSpecificElements(Model model, Page page) {
        String content = blockService.getBlocksHtml(page.getBlocks());
        model.addAttribute("content", content);
        
        ThemeDTO theme = themeService.getThemeForModel(page);
        model.addAttribute("theme",theme);
    }

    private void addUserInfo(Model model){
       if(SecurityContextHolder.getContext().getAuthentication()!= null && !SecurityContextHolder.getContext().getAuthentication().getPrincipal().toString().equals("anonymousUser")){
           model.addAttribute("user",SecurityContextHolder.getContext().getAuthentication().getPrincipal());
       } else {
           model.addAttribute("user",null);
       }
    }
    
    
}
