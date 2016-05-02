/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.appsandroidsite.quepues.persistencia;

//import es.appsandroidsite.quepues.modelo.Url;
import es.appsandroidsite.quepues.modeloPojo.Url;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

/**
 *
 * @author laura
 */
public class UrlDAOImplJDBC implements UrlDAO{
    
    private String query;
     Connection connection=null;
  
    
    private Connection getConnection() {
        try {
            InitialContext initCtx = new InitialContext();
            Context envCtx = (Context) initCtx.lookup("java:comp/env");
            DataSource dataSource = (DataSource) envCtx.lookup("jdbc/tests");

            return dataSource.getConnection();
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }

    @Override
    public void insert(Url url) throws BussinessException {
        
       
        PreparedStatement preparedStatement;
        
       try{
            
       connection = getConnection();
       
       query="INSERT INTO `url`(`sub_categoria`,`url`,`codigo_categoria`,`codigo_test`,`ultima_mod`)VALUES (?,?,?,?,?)";
       preparedStatement = connection.prepareStatement(query,Statement.RETURN_GENERATED_KEYS);
      preparedStatement.setString(1,url.getSubCategoria());
       preparedStatement.setString(2,url.getUrl());
      preparedStatement.setString(3,url.getCategoria());
       preparedStatement.setString(4,url.getTest());
        preparedStatement.setString(5,url.getUltimaMod());
       
       preparedStatement.executeUpdate();
       ResultSet rs= preparedStatement.getGeneratedKeys();
       if(rs.next()){
           url.setId(rs.getInt(1));
       }
       rs.close();
      
      }catch (SQLException ex) {
            throw new RuntimeException(ex);
        }catch(UnsupportedOperationException uoe){
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
   
        } finally {
           
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException ex) {

                }
            }
        }
        
     }

    @Override
    public void update(int idSeguroMedico, Url url) throws BussinessException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Url get(int idUrl) throws BussinessException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(int idUrl) throws BussinessException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Url> findAll() throws BussinessException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
