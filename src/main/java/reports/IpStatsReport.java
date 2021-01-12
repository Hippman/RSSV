package reports;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.primefaces.model.chart.BarChartModel;
import org.primefaces.model.chart.ChartSeries;
import org.primefaces.model.chart.HorizontalBarChartModel;
import rows.IpStatsRow;

/**
 *
 * @author Valeriy Surjenko.
 */
public class IpStatsReport {
    private Date datefrom,dateto;
    private List <IpStatsRow> rows;
    private Connection connection;
    private HorizontalBarChartModel barModel;

    public IpStatsReport() {
        connection=ConnectionManager.getConnection();
        rows=new ArrayList<>();
        dateto=Calendar.getInstance().getTime();
        Calendar cal=Calendar.getInstance();
        cal.add(Calendar.DAY_OF_MONTH, -1);
        datefrom=cal.getTime();
        barModel=new HorizontalBarChartModel();
    }
     public void gen_report() {
            String sql;
            rows=new ArrayList<>();
            barModel=new HorizontalBarChartModel();
            ChartSeries ips = new ChartSeries();
            ips.set("a", new Integer(100));
            ips.set("b", new Integer(200));
            ips.set("c", new Integer(300));
            ips.set("d", new Integer(400));
            barModel.addSeries(ips);
          
    
     }

    public Date getDatefrom() {
        return datefrom;
    }

    public void setDatefrom(Date datefrom) {
        this.datefrom = datefrom;
    }

    public Date getDateto() {
        return dateto;
    }

    public void setDateto(Date dateto) {
        this.dateto = dateto;
    }

    public List<IpStatsRow> getRows() {
        return rows;
    }

    public void setRows(List<IpStatsRow> rows) {
        this.rows = rows;
    }

    public BarChartModel getBarModel() {
        return barModel;
    }    
    
}

