import org.junit.Assert;
import org.junit.Test;
import pl.pawlik.cymes.services.base.PageUrlService;
import pl.pawlik.cymes.services.impl.PageUrlServiceImpl;

/**
 *
 * @author pawlik
 */
public class PageUrlServiceTests {
    PageUrlService service = new PageUrlServiceImpl();
    
    @Test
    public void shouldGeneratePageUrl(){
        String context = "/cymes";
        String uri = "/cumes/web/url/sample/page";
        
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

    @Test
    public void shouldReturnRootOnContextUriAndWeb(){
        String context = "/cymes";
        String uri = "/cymes/web";

        String out = service.get(context, uri);
        Assert.assertEquals("/", out);
    }
}
