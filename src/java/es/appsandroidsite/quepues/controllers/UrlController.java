/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.appsandroidsite.quepues.controllers;

import es.appsandroidsite.quepues.json.JsonTransformer;
//import es.appsandroidsite.quepues.modelo.Categoria;
//import es.appsandroidsite.quepues.modelo.Test;
//import es.appsandroidsite.quepues.modelo.Url
import es.appsandroidsite.quepues.modeloPojo.Url;
import es.appsandroidsite.quepues.persistencia.BussinessException;
import es.appsandroidsite.quepues.persistencia.BussinessMessage;
import es.appsandroidsite.quepues.persistencia.UrlDAO;
import es.appsandroidsite.quepues.persistencia.UrlDAOImplJDBC;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author laura
 */
@Controller
public class UrlController {
    
     @Autowired
    private JsonTransformer jsonTransformer;
      @Autowired
    private UrlDAO urlDAO;
      
      
    @RequestMapping(value = {"/Urls"})
     public void prueba(HttpServletRequest httpRequest, HttpServletResponse httpServletResponse) throws Exception {
    
         
       //  Url url = urlDAO.get(1);
            Url url = new Url();
       //     url.setCategoria(new Categoria("H"));
            url.setCategoria("H");
            url.setSubCategoria("Hosteleria y Turismo");
       //   url.setTest(new Test("a10"));
            url.setTest("a10");
            url.setUrl("http://aula10formacion.com/cursos-de/idiomas/");
            url.setUltimaMod(null);
        
         String jsonUrl=jsonTransformer.toJson(url);
   
        //Url url=(Url)jsonTransformer.fromJson(jsonUrl,Url.class);
       
             
         
         httpServletResponse.getWriter().println(jsonUrl);
        
        
      }
    
    
     
     @RequestMapping(value = "/Url", method = RequestMethod.POST, consumes = "application/json",produces = "application/json")
    public void insert(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, @RequestBody String jsonEntrada) {
        try {
            Url urls = (Url) jsonTransformer.fromJson(jsonEntrada, Url.class);
          
            urlDAO.insert(urls);
            String jsonSalida = jsonTransformer.toJson(urls);
            
            httpServletResponse.setStatus(HttpServletResponse.SC_OK);
            httpServletResponse.setContentType("application/json; charset=UTF-8");
          
                httpServletResponse.getWriter().println(jsonSalida);
        } catch (IOException ex) {
                Logger.getLogger(UrlController.class.getName()).log(Level.SEVERE, null, ex);
            
            
        } catch (BussinessException ex) {
            List<BussinessMessage> bussinessMessage=ex.getBussinessMessages();
            String jsonSalida = jsonTransformer.toJson(bussinessMessage);
            
            httpServletResponse.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            httpServletResponse.setContentType("application/json; charset=UTF-8");
            try {
                httpServletResponse.getWriter().println(jsonSalida);
            } catch (IOException ex1) {
                Logger.getLogger(UrlController.class.getName()).log(Level.SEVERE, null, ex1);
            }

            
        
    }
    
}
}
