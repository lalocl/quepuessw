/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.appsandroidsite.quepues.persistencia;

//import es.appsandroidsite.quepues.modelo.Url;
import es.appsandroidsite.quepues.modeloPojo.Url;
import java.util.List;
import java.util.Map;

/**
 *
 * @author laura
 */
public interface UrlDAO {
    
    void insert(Url url) throws BussinessException;
            
    void update(int idSeguroMedico,Url url) throws BussinessException;

    Url get(int idUrl) throws BussinessException;

    void delete(int idUrl) throws BussinessException;

    List<Url> findAll() throws BussinessException;
    
    List<Url> findFilter(Map<String, String> filtro) throws BussinessException;
    
}
