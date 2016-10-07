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
public class Tile {
    @Id
    long tileId;
    int type;
    String name;
    String content;
    
    @ManyToOne
    @JoinColumn(name = "block_id")
    Block block;
            
    @ManyToOne
    @JoinColumn(name = "parent_id")
    Tile parent;
    
    @OneToMany(mappedBy = "parent")
    List<Tile> childrens;

    public long getTileId() {
        return tileId;
    }

    public void setTileId(long tileId) {
        this.tileId = tileId;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Tile getParent() {
        return parent;
    }

    public void setParent(Tile parent) {
        this.parent = parent;
    }

    public List<Tile> getChildrens() {
        return childrens;
    }

    public void setChildrens(List<Tile> childrens) {
        this.childrens = childrens;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Block getBlock() {
        return block;
    }

    public void setBlock(Block block) {
        this.block = block;
    }
    
    
}
