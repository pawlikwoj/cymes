/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.pawlik.cymes.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pl.pawlik.cymes.entities.Page;

/**
 *
 * @author pawlik
 */
@Repository
public interface PageRepository  extends CrudRepository<Page, String> {
    public Page findByPageId(String pageId);
    public Page findByUrl(String url);
}
