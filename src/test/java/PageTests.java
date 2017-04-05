
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import pl.pawlik.cymes.repositories.PageRepository;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author pawlik
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/applicationContextTestAll.xml","file:src/main/webapp/WEB-INF/applicationContext.xml"})
@WebAppConfiguration
public class PageTests {
    @Autowired
    PageRepository pageRepository;
    @Test
    public void test1(){
        Assert.assertEquals(2, pageRepository.count());
    }
}
