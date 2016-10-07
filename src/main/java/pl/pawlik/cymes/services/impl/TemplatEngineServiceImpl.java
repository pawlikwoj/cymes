/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.pawlik.cymes.services.impl;

import freemarker.cache.StringTemplateLoader;
import freemarker.core.ParseException;
import freemarker.template.Configuration;
import freemarker.template.MalformedTemplateNameException;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import freemarker.template.Version;
import java.io.IOException;
import java.io.StringWriter;
import java.util.HashMap;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.stereotype.Service;
import pl.pawlik.cymes.entities.Tile;
import pl.pawlik.cymes.services.base.TemplatEngineService;

/**
 *
 * @author pawlik
 */
@Service
public class TemplatEngineServiceImpl implements TemplatEngineService{

    @Override
    public String procesTemplate(String template, List<Tile> tiles) {
        StringTemplateLoader stringLoader = new StringTemplateLoader();
        String firstTemplate = "firstTemplate";
        stringLoader.putTemplate(firstTemplate, template);
        
        Configuration cfg = new Configuration(Configuration.VERSION_2_3_23);
        cfg.setTemplateLoader(stringLoader);

        HashMap<String,Object> data = new HashMap<>();
        tiles.stream().forEach( t -> data.put(t.getName(), t.getContent()));
        
        StringWriter writer = new StringWriter();
        try {
            Template fmTemplate = cfg.getTemplate(firstTemplate);
            fmTemplate.process(data, writer);
        } catch ( IOException | TemplateException ex) {
            Logger.getLogger(TemplatEngineServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
            return "[ERROR] "+ex.getMessage();
        }
        return writer.toString();
    }
}
