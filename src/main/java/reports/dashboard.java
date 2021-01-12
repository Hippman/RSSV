package reports;

import org.primefaces.model.DashboardColumn;
import org.primefaces.model.DashboardModel;
import org.primefaces.model.DefaultDashboardColumn;
import org.primefaces.model.DefaultDashboardModel;

/**
 *
 * @author Valeriy Surjenko.
 */
public class dashboard {
    private DashboardModel model;

    public dashboard() {
        model = new DefaultDashboardModel();
        DashboardColumn column1 = new DefaultDashboardColumn();
        column1.addWidget("LRNLookup");
        column1.addWidget("ResporgLookup");
        model.addColumn(column1);
    }

    public DashboardModel getModel() {
        return model;
    }

    public void setModel(DashboardModel model) {
        this.model = model;
    }
    
}
