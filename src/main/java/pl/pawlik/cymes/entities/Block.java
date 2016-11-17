/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.pawlik.cymes.entities;

import java.util.List;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

/**
 *
 * @author pawlik
 */

@Entity
public class Block {
    @Id
    private long blockId;
    private String name;
    private Boolean siteWide;
    
    @ManyToOne
    @JoinColumn(name = "template_id")
    private Template template;
    
    @OneToMany(mappedBy = "block")
    private List<Tile> tiles;
    
    @ManyToOne
    @JoinColumn(name="page_id")
    private Page page;

    public long getBlockId() {
        return blockId;
    }

    public void setBlockId(long blockId) {
        this.blockId = blockId;
    }

    public Template getTemplate() {
        return template;
    }

    public void setTemplate(Template template) {
        this.template = template;
    }

    public List<Tile> getTiles() {
        return tiles;
    }

    public void setTiles(List<Tile> tiles) {
        this.tiles = tiles;
    }

    public Page getPage() {
        return page;
    }

    public void setPage(Page page) {
        this.page = page;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Boolean getSiteWide() {
        return siteWide;
    }

    public void setSiteWide(Boolean siteWide) {
        this.siteWide = siteWide;
    }
    
}
