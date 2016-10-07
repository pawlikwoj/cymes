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
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.context.request.WebRequest;
import pl.pawlik.cymes.repositories.PageRepository;
import pl.pawlik.cymes.services.base.PageModelService;
import pl.pawlik.cymes.services.base.PageUrlService;

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
    
 
    @RequestMapping(value="/**",method=RequestMethod.GET)
    public String indexPage(Model model,HttpServletRequest webRequest){
        Logger.getGlobal().log(Level.SEVERE, webRequest.getRequestURI());
        String uri = pageUrlService.get(webRequest.getContextPath(), webRequest.getRequestURI());
        Model pageModel = pageModelService.getPageModel(uri);
        model.addAllAttributes(pageModel.asMap());
        return "default";
    }
}
