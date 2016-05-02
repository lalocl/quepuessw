/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.appsandroidsite.quepues.modeloPojo;

import java.util.Date;

/**
 *
 * @author laura
 */
public class Url {
     private Integer id;
     private String categoria;
     private String test;
     private String subCategoria;
     private String url;
     private String ultimaMod;
     
      public Url() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getTest() {
        return test;
    }

    public void setTest(String test) {
        this.test = test;
    }

    public String getSubCategoria() {
        return subCategoria;
    }

    public void setSubCategoria(String subCategoria) {
        this.subCategoria = subCategoria;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUltimaMod() {
        return ultimaMod;
    }

    public void setUltimaMod(String ultimaMod) {
        this.ultimaMod = ultimaMod;
    }

    
    
}
