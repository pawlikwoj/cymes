/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.pawlik.cymes.controllers;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import pl.pawlik.cymes.entities.Page;
import pl.pawlik.cymes.repositories.PageRepository;
import pl.pawlik.cymes.services.base.PageModelService;
import pl.pawlik.cymes.services.base.PageUrlService;
import pl.pawlik.cymes.services.base.ThemeService;

/**
 *
 * @author pawlik
 */
@Controller
@RequestMapping("/")
public class PageController {
    @Autowired
    public PageRepository pageRepository;
    @Autowired
    public PageModelService pageModelService;
    @Autowired
    public PageUrlService pageUrlService;
    @Autowired
    public ThemeService themeService;
    
    @Transactional
    @RequestMapping(value="/**",method=RequestMethod.GET)
    public String indexPage(Model model,HttpServletRequest webRequest){
        Logger.getGlobal().log(Level.SEVERE, webRequest.getRequestURI());
        String uri = pageUrlService.get(webRequest.getContextPath(), webRequest.getRequestURI());
        Page page = pageRepository.findByUrl(uri);
        
        Model pageModel = pageModelService.getPageModel(page);
        model.addAllAttributes(pageModel.asMap());
        
        String theme = themeService.getTheme(page);
        
        return theme+"/views/default";
    }
}
