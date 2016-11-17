/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.pawlik.cymes.repositories;

import java.util.List;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pl.pawlik.cymes.entities.Block;

/**
 *
 * @author pawlik
 */
@Repository
public interface BlockRepository extends CrudRepository<Block, Long> {
    public List<Block> findBySiteWide(Boolean siteWide);
}
