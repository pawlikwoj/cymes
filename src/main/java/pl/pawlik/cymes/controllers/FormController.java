/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.pawlik.cymes.controllers;

import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3Client;
import com.amazonaws.services.s3.model.GetObjectRequest;
import com.amazonaws.services.s3.model.ObjectMetadata;
import com.amazonaws.services.s3.model.PutObjectRequest;
import com.amazonaws.services.s3.model.S3Object;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.BufferedOutputStream;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.UUID;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import pl.pawlik.cymes.entities.User;
import pl.pawlik.cymes.dto.FormularzDTO;
import pl.pawlik.cymes.repositories.PageRepository;

/**
 *
 * @author pawlik
 */
@Controller
public class FormController {
    @Autowired
    public PageRepository pageRepository;
    
    @RequestMapping(value="/login", method=RequestMethod.GET)
    public String login() {
       
        return "login";
    }
    
    @RequestMapping(value="/formularz", method=RequestMethod.GET)
    public String formularz(Model model) {
        model.addAttribute("form",new FormularzDTO());
        return "widok.formularz";
    }
    
   @RequestMapping(value="/formularz", method=RequestMethod.POST)
    public String obsformularz (@ModelAttribute("form") @Valid FormularzDTO form, BindingResult result){
        if (result.hasErrors()) {
            return "widok.formularz";
        } else {
            System.out.println("name: "+form.getName() );
            System.out.println("ownerName: "+pageRepository.findOne("1").getOwner().getName());
            return "redirect:/poFormularzu";
        }
    }
    
    @RequestMapping(value="/poFormularzu", method=RequestMethod.GET)
    public String poFormularzu() {
        return "poFormularzu";
    }
    
    
    @RequestMapping(value="/upload", method=RequestMethod.GET)
    public String handleFileUpload(Model model) {
        model.addAttribute("form",new FormularzDTO());
        return "upload";
    }
    
    @RequestMapping(value="/upload", method=RequestMethod.POST)
    public String handleFileUpload(@RequestParam("plik") MultipartFile file){
        if (!file.isEmpty()) {
            try {
          
               //myObject.getClass().getProtectionDomain().getCodeSource()
               System.out.println("------------"+ ObjectMapper.class.getProtectionDomain().getCodeSource());
                Logger.getLogger("FormController").log(Level.SEVERE,"------------"+ ObjectMapper.class.getProtectionDomain().getCodeSource() );
                UUID uuid = UUID.randomUUID();
            String filename = "/uploads/upload_"+uuid.toString();
            String bucketName = "pawliktest";
            String accessKey = "xx";
            String secretKey = "xx";
            byte[] bytes = file.getBytes();
            InputStream inputStream = new ByteArrayInputStream(bytes);
            AmazonS3 s3client = new AmazonS3Client(new BasicAWSCredentials(accessKey, secretKey));
            s3client.putObject(new PutObjectRequest(
                                     bucketName, filename, inputStream, new ObjectMetadata()));
                

                System.out.println("File {} has been successfully uploaded as ");
            } catch (Exception e) {
               e.printStackTrace();
            }
        } else {
            System.out.println("Uploaded file is empty");
        }
        return "redirect:/cymes/upload";
    }
    
    
    
    @RequestMapping(value = "/plik/{nazwa_pliku}", method = RequestMethod.GET)
    public void getFile(@PathVariable("nazwa_pliku") String nazwaPliku, HttpServletResponse response) {
        try {
            AmazonS3 s3client = new AmazonS3Client(new BasicAWSCredentials("AKIAJJ4WVVITDZF4SU4A", "oTNfuCbjK/Q/BnBEdQCAs6ogIpoRmbvROAjtdtXV"));
            S3Object object = s3client.getObject(new GetObjectRequest("pawliktest", "/uploads/upload_2d6303ef-a714-4fa6-9137-fc8b22412730"));
            InputStream is = object.getObjectContent();
            response.setContentType("image/jpeg");

            org.apache.commons.io.IOUtils.copy(is, response.getOutputStream());
            response.flushBuffer();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    
    @RequestMapping(value="/rest", method=RequestMethod.GET)
    public ResponseEntity<User> get() {
        User kot = new User();
        kot.setName("pawlik");
        kot.setUserId(3);
        return new ResponseEntity<User>(kot, new HttpHeaders(), HttpStatus.OK);
    }
}
