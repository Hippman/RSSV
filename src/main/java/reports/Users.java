package reports;

import group.User;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.inject.Inject;
import rows.UserRow;

/**
 *
 * @author Valeriy Surjenko.
 */
public class Users {
    @Inject 
    private User user;
    public static void ClearUsers(Connection con,List <String> users, String login)
    {
        List <String> ausers=new ArrayList<>();
        List <String> ids=new ArrayList<>();
    }
    public static List <String> FillUsers(Connection con, String Login)
    {
        
        List <String> users=new ArrayList<>();
        List <String> alowedusers=new ArrayList<>();
    
        
        users=new ArrayList<>();
          
        return users;
    }
    public static List <UserRow> FillUsersObj(Connection con)
    {
        List <UserRow> users=new ArrayList<>();
        return users;
    }
    
}
