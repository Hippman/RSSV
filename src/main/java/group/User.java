/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package group;


import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import java.util.logging.Level;
import java.util.logging.Logger;
import java.security.*;
import java.util.ArrayList;
import java.util.HashMap;
import javax.faces.context.FacesContext;
import reports.ConnectionManager;
import reports.Statistics;
import sun.misc.BASE64Encoder;


/**
 *
 * @author VSurjenko
 */
public class User 
{
  
    private String Login;
    private String Password;
    private Boolean logined;
    private String oldLogin;
    private String oldPassword;
    private String description;
    private String oldDescription;
    private String errorMessage;
    private ArrayList<String> rules;
    
    public void logout()
    {
        logined=false;
        Login="";
        Password="";
        description="";
        oldLogin="";
        oldDescription="";
        oldPassword="";
        rules=new ArrayList<>();
        try {
            FacesContext.getCurrentInstance().getExternalContext().redirect("/RSSV/faces/index.xhtml");
        } catch (IOException ex) {
            Logger.getLogger(User.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
          
    public String go_to_stats()
    {
        Statistics stat=new Statistics();
        if(logined==true)
        {
            return "/pages/statistics.xhtml";
        }
        return "";
    }
    public String go_to_customers()
    {
        Statistics stat=new Statistics();
        if(logined==true)
        {
            return "/pages/customers.xhtml";
        }
        return "";
    }
    public String go_to_conf()
    {
        
        if(logined==true)
        {
            return "/pages/config.xhtml";
        }
        return "";
    }
    public String go_to_reports()
    {
        
        if(logined==true)
        {
            return "/pages/report.xhtml";
        }
        return "";
    }
    public User() 
    {
     
        logined=false;
        Login="";
        Password="";
        description="";
        oldLogin="";
        oldDescription="";
        oldPassword="";
        rules=new ArrayList<>();
    }

    public User(String Login, String Password, String description) 
    {
        this.Login = Login;
        this.Password = Password;
        logined=false;
        this.description=description;
        oldLogin="";
        oldDescription="";
        oldPassword="";
        rules=new ArrayList<>();
    }

  

    public String getLogin() {
        return Login;
    }

    public void setLogin(String Login) {
        this.Login = Login;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String Password) {
        this.Password = Password;
    }

    public Boolean getLogined() {
        return logined;
    }
    public void redirectToLogin() {
        try {
            if(!logined)
            FacesContext.getCurrentInstance().getExternalContext().redirect("/RSSV/faces/login.xhtml");
        } catch (IOException ex) {
            Logger.getLogger(User.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public Boolean authDlg() {
        return !logined;
    }

    public void setLogined(Boolean logined) {
        this.logined = logined;
    }

    public String getOldLogin() {
        return oldLogin;
    }

    public void setOldLogin(String oldLogin) {
        this.oldLogin = oldLogin;
    }

    public String getOldPassword() {
        return oldPassword;
    }

    public void setOldPassword(String oldPassword) {
        this.oldPassword = oldPassword;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getOldDescription() {
        return oldDescription;
    }

    public void setOldDescription(String oldDescription) {
        this.oldDescription = oldDescription;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public ArrayList<String> getRules() {
        return rules;
    }

    public void setRules(ArrayList<String> rules) {
        this.rules = rules;
    }
    
    public boolean checkRule(String rule){
        return true;
        /*for (int a=0;a<rules.size();a++){
            if (rules.get(a).equals(rule) || rules.get(a).equals("all")){
                return true;
            }
        }
        return false;*/
    }

    public String tryToLogin()
    {
        
        if(Login.length()>0 && Password.length()>0)
        {
            logined=true;
            return  "/pages/dashboard.xhtml";
        }
        if(logined==true)  return  "/pages/dashboard.xhtml";
        else return "";
    }
    
         
    
}
