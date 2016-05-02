
import es.appsandroidsite.quepues.modeloPojo.Url;
import es.appsandroidsite.quepues.persistencia.BussinessException;
import es.appsandroidsite.quepues.persistencia.UrlDAO;
import es.appsandroidsite.quepues.persistencia.UrlDAOImplJDBC;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author laura
 */
public class main {
    
    public static void main(String[] args) throws BussinessException {
        
      
            Url url = new Url();
       
            url.setCategoria("H");
            url.setSubCategoria("Hosteleria y Turismo");
    
            url.setTest("a10");
            url.setUrl("http://aula10formacion.com/cursos-de/idiomas/");
            url.setUltimaMod(null);
            
            UrlDAOImplJDBC urlDAO= new UrlDAOImplJDBC();
            urlDAO.insert(url);
    }
    
}
