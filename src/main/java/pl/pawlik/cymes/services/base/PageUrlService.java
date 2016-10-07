/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.pawlik.cymes.services.base;

import org.springframework.stereotype.Service;

/**
 *
 * @author pawlik
 */
@Service
public interface PageUrlService {
    public String get(String appContext, String requestUri);
}
