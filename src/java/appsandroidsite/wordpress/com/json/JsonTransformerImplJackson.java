/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package appsandroidsite.wordpress.com.json;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;

/**
 *
 * @author laura
 */
public class JsonTransformerImplJackson implements JsonTransformer{

    /*
    * Pasamos un objecto y el método nos devuelve un String Json con los campos de ese Objecto
    */
    @Override
    public String toJson(Object data) {
        ObjectMapper objectmapper = new ObjectMapper();
        try {
            return objectmapper.writeValueAsString(data);
        } catch (JsonProcessingException ex) {
          //  Logger.getLogger(JsonTransformerImplJackson.class.getName()).log(Level.SEVERE, null, ex);
            throw new RuntimeException(ex);
        }
    }

    /*
    *Pasamos un Json y el nombre de una clase, y el método devuelve un Objeto de esa clase.
    */
    @Override
    public Object fromJson(String json, Class clazz) {
         ObjectMapper objectMapper = new ObjectMapper();
        try {
            return objectMapper.readValue(json, clazz);
        } catch (IOException ex) {
          //  Logger.getLogger(JsonTransformerImplJackson.class.getName()).log(Level.SEVERE, null, ex);
            throw new RuntimeException(ex);
        }
       
        
        
    }
    
}
