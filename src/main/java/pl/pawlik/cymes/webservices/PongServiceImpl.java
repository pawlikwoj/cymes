/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.pawlik.cymes.webservices;

import javax.jws.WebService;

/**
 *
 * @author pawlik
 */
@WebService(endpointInterface="pl.pawlik.cymes.webservices.PongServiceInterface", serviceName="PongService")
public class PongServiceImpl implements PongServiceInterface{
    @Override
    public String ping() {
        return "pong";
    }
}
