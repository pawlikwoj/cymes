/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.pawlik.cymes.services.impl;

import org.springframework.stereotype.Service;
import pl.pawlik.cymes.services.base.PageUrlService;

/**
 *
 * @author pawlik
 */

@Service
public class PageUrlServiceImpl implements PageUrlService{

    @Override
    public String get(String appContext, String requestUri) {
        String pageUri;
        
        if(appContext.equals(requestUri)){
            pageUri = "/";
        } else {
            int uriStart = appContext.length();
            pageUri = requestUri.substring(uriStart);
        }
        
        return pageUri;
    }
    
}
