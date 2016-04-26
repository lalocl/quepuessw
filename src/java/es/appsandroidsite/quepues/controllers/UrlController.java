/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.appsandroidsite.quepues.controllers;

import es.appsandroidsite.quepues.json.JsonTransformer;
import es.appsandroidsite.quepues.modelo.Categoria;
import java.io.IOException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author laura
 */
public class UrlController {
    
     @Autowired
    private JsonTransformer jsonTransformer;
     
     @RequestMapping(value = {"/Categoria"})
    public void prueba(HttpServletRequest httpRequest, HttpServletResponse httpServletResponse) 
            throws IOException {
      
        
          
            Categoria c = new Categoria();
            c.setCodigo("M");
            c.setNombre("Marketing");
            String jsonCategoria = jsonTransformer.toJson(c);
            httpServletResponse.getWriter().println(jsonCategoria);
    
}
}
