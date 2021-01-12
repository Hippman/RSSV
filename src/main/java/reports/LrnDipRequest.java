
package reports;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.json.JSONException;
import org.json.JSONObject;

/**
 *
 * @author Valeriy Surjenko.
 */
public class LrnDipRequest {
    public static rows.JSONLrn Dip(String tn) {
        rows.JSONLrn row=new rows.JSONLrn();
       
        row.setTn(tn);
        return (row);
    }
}
