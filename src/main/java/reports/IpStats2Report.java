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
import org.primefaces.model.chart.AxisType;
import org.primefaces.model.chart.BarChartModel;
import org.primefaces.model.chart.ChartSeries;
import org.primefaces.model.chart.DateAxis;
import org.primefaces.model.chart.HorizontalBarChartModel;
import org.primefaces.model.chart.LineChartModel;
import rows.IpStats2Row;

/**
 *
 * @author Valeriy Surjenko.
 */
public class IpStats2Report {
    private Date datefrom,dateto;
    private List <IpStats2Row> rows;
    private Connection connection;
    private LineChartModel lineModel;

    public IpStats2Report() {
        connection=ConnectionManager.getConnection();
        rows=new ArrayList<>();
        dateto=Calendar.getInstance().getTime();
        Calendar cal=Calendar.getInstance();
        cal.add(Calendar.DAY_OF_MONTH, -1);
        datefrom=cal.getTime();
        lineModel=new LineChartModel();
    }
     public void gen_report() {
            String sql;
            ResultSet res;
         
            rows=new ArrayList<>();
            lineModel=new LineChartModel();
            ChartSeries ips = new ChartSeries();
            ips.set("2021-01-01", new Integer(100));
            ips.set("2021-01-02", new Integer(200));
            ips.set("2021-01-03", new Integer(300));
            ips.set("2021-01-04", new Integer(400));
            lineModel.addSeries(ips);
            lineModel.setTitle("Zoom for Details");
            lineModel.setZoom(true);
            lineModel.getAxis(AxisType.Y).setLabel("Traffic(kb)");
            DateAxis axis = new DateAxis("Dates");
            axis.setTickAngle(-60);
            axis.setTickCount(20);
            axis.setTickFormat("%d-%m-%Y %H:%M");
            lineModel.getAxes().put(AxisType.X, axis);
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

    public LineChartModel getLineModel() {
        return lineModel;
    }

    public List<IpStats2Row> getRows() {
        return rows;
    }

    public void setRows(List<IpStats2Row> rows) {
        this.rows = rows;
    }
    
    
}

