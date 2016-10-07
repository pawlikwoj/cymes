
import org.junit.Assert;
import org.junit.Test;
import pl.pawlik.cymes.services.base.PageUrlService;
import pl.pawlik.cymes.services.impl.PageUrlServiceImpl;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author pawlik
 */
public class PageUrlServiceTests {
    PageUrlService service = new PageUrlServiceImpl();
    
    @Test
    public void shouldGeneratePageUrl(){
        String context = "/cymes";
        String uri = "/cumes/url/sample/page";
        
        String out = service.get(context, uri);
        
        Assert.assertEquals("/url/sample/page", out);
    }
    
    @Test
    public void shouldReturnRootOnContextUri(){
        String context = "/cymes";
        String uri = "/cymes";
        
        String out = service.get(context, uri);
        
        Assert.assertEquals("/", out);
    }
}
