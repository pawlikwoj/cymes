/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.pawlik.cymes.webservices;

import javax.jws.WebMethod;
import javax.jws.WebService;

/**
 *
 * @author pawlik
 */
@WebService
public interface PongServiceInterface {
    @WebMethod(operationName="ping")
    public String ping();
}
