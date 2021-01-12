
package reports;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.primefaces.model.DashboardModel;
import org.primefaces.model.DualListModel;
import rows.cdrRow;
import rows.cdrViewerCondition;
import rows.cdrViewerNewRow;
/**
 *
 * @author Valeriy Surjenko.
 */
public class cdrViewerReport {
    //private List<rows.CDRViewerConfField> SelectedOutRows2;
    private List<String> SelectedOutRows2;
    private HashMap<String,String> NameToField;
    private HashMap<String,String> NameToType;
    //private List<rows.CDRViewerConfField> SelectedOutRows;
    //private List<rows.CDRViewerConfField> OutRowsList;
    
    private List<String> SelectedOutRows;
    private List<String> OutRowsList;
    
    private DualListModel<String> fieldmodel;
    
    //private DualListModel<rows.CDRViewerConfField> fieldmodel;
    private boolean calltypeEnabled;
    private String calltypeVal;
    private Date cdrdateFrom;
    private Date cdrdateTo;
    private boolean durationEnabled;
    private float durationFrom;
    private float durationTo;
    private boolean ms_durationEnabled;
    private float ms_durationFrom;
    private float ms_durationTo;
    private boolean setuptimeEnabled;
    private float setuptimeFrom;
    private float setuptimeTo;
    private boolean methodEnabled;
    private String methodVal;
    private boolean from_tagEnabled;
    private String from_tagVal;
    private boolean to_tagEnabled;
    private String to_tagVal;
    private boolean callidEnabled;
    private String callidVal;
    private boolean codeEnabled;
    private String codeVal;
    private boolean reasonEnabled;
    private String reasonVal;
    private boolean custipEnabled;
    private String custipVal;
    private boolean egressfromuriEnabled;
    private String egressfromuriVal;
    private boolean requriEnabled;
    private String requriVal;
    private boolean desturiEnabled;
    private String desturiVal;
    private boolean sendpchargeEnabled;        
    private boolean sendchargeVal;
    private boolean pchargeheaderEnabled;         
    private String pchargerVal;
    private boolean egressvendoridEnabled;
    private String egressvendoridVal;
    private boolean hostnameEnabled;
    private String hostnameVal;
    private boolean origcallingEnabled;
    private String origcallingVal;
    private boolean callingEnabled;
    private String callingVal;
    private boolean dialedEnabled;
    private String dialedeVal;
    private boolean resporgEnabled;                                            
    private String resporgVal;
    private boolean egressvendorrateEnabled;
    private Double egressvendorrateFrom;
    private Double egressvendorrateTo;
    private boolean vendoripEnabled;
    private String vendoripeVal;
    private boolean vendorportEnabled; 
    private String vendorportVal;
    private org.primefaces.model.DashboardModel model;
    private List <rows.cdrRow> rows;
    private List <rows.cdrViewerNewRow> rows2;
    
    private String custIpOperation;
    private String egressvendoridOperation;
    private String origcallingOperation;
    private String callingOperation;
    private String dialedOperation;
    private String resporgOperation;
    private String calltypeOperation;
 
    private String conditionOperation;
    private String conditionValue;
    private String conditionField;
    private ArrayList<cdrViewerCondition> conditions;
    private String selectedCondition;
    
    public void genReport(){

            Calendar calfrom,calto;
            calfrom=Calendar.getInstance();
            calto=Calendar.getInstance();
            calfrom.setTime(cdrdateFrom);
            calto.setTime(cdrdateTo);
            SimpleDateFormat df=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            SimpleDateFormat df2=new SimpleDateFormat("yyyy-MM-dd 00:00:00");
            SimpleDateFormat tableDf=new SimpleDateFormat("yyyyMMdd");
            rows=new ArrayList<rows.cdrRow>();
            rows2=new ArrayList<>();

            SelectedOutRows2=new ArrayList<>();
            
    }
    public void addCondition(){
        cdrViewerCondition cnd=new cdrViewerCondition(conditionOperation, conditionField, conditionValue, NameToType.get(conditionField));
        conditions.add(cnd);
    }
    public String getWidth(){
        if (SelectedOutRows2==null || SelectedOutRows2.size()==0){
            return "256px";
        }else {
            return String.valueOf(SelectedOutRows2.size()*256)+"px";
        }
    }
    public void parseSelectedCondition(){
        for (int a=0;a<conditions.size();a++){
            if (conditions.get(a).getDispText().equals(selectedCondition)){
                conditionOperation=conditions.get(a).getOperation();
                conditionField=conditions.get(a).getFieldName();
                conditionValue=conditions.get(a).getValue();
                conditions.remove(a);
                a=conditions.size()+1;
            }
        }
    }
    
    public void rmCondition(){
        for (int a=0;a<conditions.size();a++){
            if (conditions.get(a).getDispText().equals(selectedCondition)){
                conditions.remove(a);
                a=conditions.size()+1;
            }
        }
    }
    
    public cdrViewerReport() {
        conditions=new ArrayList<>();
        OutRowsList=new ArrayList<String>();
        SelectedOutRows=new ArrayList<String>();
        SelectedOutRows2=new ArrayList<String>();
        //sSelectedOutRows2=new ArrayList<rows.CDRViewerConfField>();
        rows2=new ArrayList<>();
        cdrdateTo=Calendar.getInstance().getTime();
        Calendar cal=Calendar.getInstance();
        cal.add(Calendar.DAY_OF_MONTH, -1);
        cdrdateFrom=cal.getTime();
        calltypeOperation="!=";

        
        NameToField=new HashMap<String,String>();
        NameToField.put("Call Type", "calltype");
        NameToField.put("CDR Date", "cdrdate");
        NameToField.put("Duration", "duration");
        NameToField.put("MS Duration", "ms_duration");
        NameToField.put("Setup Time", "setuptime");
        NameToField.put("Code", "code");
        NameToField.put("Cust IP", "custip");
        NameToField.put("Egress Vendor ID", "egressvendorid");
        NameToField.put("Orig Calling", "origcalling");
        NameToField.put("Calling", "calling");
        NameToField.put("Dialed", "dialed");
        NameToField.put("Resporg", "resporg");
        NameToField.put("Egress Vendor Rate", "egressvendorrate");
        NameToField.put("Vendor IP", "vendorip");
        NameToField.put("Hostname", "hostname");
        NameToField.put("Method", "method");
        NameToField.put("From Tag", "from_tag");
        NameToField.put("To Tag", "to_tag");
        NameToField.put("Call ID", "callid");
        NameToField.put("Reason", "reason");
        NameToField.put("Egress From URI", "egressfromuri");
        NameToField.put("Req URI", "requri");
        NameToField.put("Dest URI", "desturi");
        NameToField.put("Send PCharge", "sendpcharge");
        NameToField.put("PCharge Header", "pchargeheader");
        NameToField.put("Vendor Port", "vendorport");

        OutRowsList.add("Call Type");
        OutRowsList.add("CDR Date");
        OutRowsList.add("Duration");
        OutRowsList.add("MS Duration");
        OutRowsList.add("Setup Time");
        OutRowsList.add("Code");
        OutRowsList.add("Cust IP");
        OutRowsList.add("Egress Vendor ID");
        OutRowsList.add("Orig Calling");
        OutRowsList.add("Calling");
        OutRowsList.add("Dialed");
        OutRowsList.add("Resporg");
        OutRowsList.add("Egress Vendor Rate");
        OutRowsList.add("Vendor IP");
        
        SelectedOutRows.add("Hostname");
        SelectedOutRows.add("Method");
        SelectedOutRows.add("From Tag");
        SelectedOutRows.add("To Tag");
        SelectedOutRows.add("Call ID");
        SelectedOutRows.add("Reason");
        SelectedOutRows.add("Egress From URI");
        SelectedOutRows.add("Req URI");
        SelectedOutRows.add("Dest URI");
        SelectedOutRows.add("Send PCharge");
        SelectedOutRows.add("PCharge Header");
        SelectedOutRows.add("Vendor Port");
        
        
        NameToType=new HashMap<String,String>();
        NameToType.put("Call Type", "num");
        NameToType.put("CDR Date", "date");
        NameToType.put("Duration", "num");
        NameToType.put("MS Duration", "num");
        NameToType.put("Setup Time", "num");
        NameToType.put("Code", "num");
        NameToType.put("Cust IP", "str");
        NameToType.put("Egress Vendor ID", "str");
        NameToType.put("Orig Calling", "str");
        NameToType.put("Calling", "str");
        NameToType.put("Dialed", "str");
        NameToType.put("Resporg", "str");
        NameToType.put("Egress Vendor Rate", "num");
        NameToType.put("Vendor IP", "str");
        NameToType.put("Hostname", "str");
        NameToType.put("Method", "str");
        NameToType.put("From Tag", "str");
        NameToType.put("To Tag", "str");
        NameToType.put("Call ID", "str");
        NameToType.put("Reason", "str");
        NameToType.put("Egress From URI", "str");
        NameToType.put("Req URI", "str");
        NameToType.put("Dest URI", "str");
        NameToType.put("Send PCharge", "num");
        NameToType.put("PCharge Header", "str");
        NameToType.put("Vendor Port", "num");

        fieldmodel = new DualListModel<String>(OutRowsList, SelectedOutRows);


    }

    public boolean isCalltypeEnabled() {
        return calltypeEnabled;
    }

    public void setCalltypeEnabled(boolean calltypeEnabled) {
        this.calltypeEnabled = calltypeEnabled;
    }

    public Date getCdrdateFrom() {
        return cdrdateFrom;
    }

    public void setCdrdateFrom(Date cdrdateFrom) {
        this.cdrdateFrom = cdrdateFrom;
    }

    public Date getCdrdateTo() {
        return cdrdateTo;
    }

    public void setCdrdateTo(Date cdrdateTo) {
        this.cdrdateTo = cdrdateTo;
    }

    public boolean isDurationEnabled() {
        return durationEnabled;
    }

    public void setDurationEnabled(boolean durationEnabled) {
        this.durationEnabled = durationEnabled;
    }

    public float getDurationFrom() {
        return durationFrom;
    }

    public void setDurationFrom(float durationFrom) {
        this.durationFrom = durationFrom;
    }

    public float getDurationTo() {
        return durationTo;
    }

    public void setDurationTo(float durationTo) {
        this.durationTo = durationTo;
    }

    public boolean isMs_durationEnabled() {
        return ms_durationEnabled;
    }

    public void setMs_durationEnabled(boolean ms_durationEnabled) {
        this.ms_durationEnabled = ms_durationEnabled;
    }

    public float getMs_durationFrom() {
        return ms_durationFrom;
    }

    public void setMs_durationFrom(float ms_durationFrom) {
        this.ms_durationFrom = ms_durationFrom;
    }

    public float getMs_durationTo() {
        return ms_durationTo;
    }

    public void setMs_durationTo(float ms_durationTo) {
        this.ms_durationTo = ms_durationTo;
    }

    public boolean isSetuptimeEnabled() {
        return setuptimeEnabled;
    }

    public void setSetuptimeEnabled(boolean setuptimeEnabled) {
        this.setuptimeEnabled = setuptimeEnabled;
    }

    public float getSetuptimeFrom() {
        return setuptimeFrom;
    }

    public void setSetuptimeFrom(float setuptimeFrom) {
        this.setuptimeFrom = setuptimeFrom;
    }

    public float getSetuptimeTo() {
        return setuptimeTo;
    }

    public void setSetuptimeTo(float setuptimeTo) {
        this.setuptimeTo = setuptimeTo;
    }

    public boolean isMethodEnabled() {
        return methodEnabled;
    }

    public void setMethodEnabled(boolean methodEnabled) {
        this.methodEnabled = methodEnabled;
    }

    public boolean isFrom_tagEnabled() {
        return from_tagEnabled;
    }

    public void setFrom_tagEnabled(boolean from_tagEnabled) {
        this.from_tagEnabled = from_tagEnabled;
    }

    public boolean isTo_tagEnabled() {
        return to_tagEnabled;
    }

    public void setTo_tagEnabled(boolean to_tagEnabled) {
        this.to_tagEnabled = to_tagEnabled;
    }

    public boolean isCallidEnabled() {
        return callidEnabled;
    }

    public void setCallidEnabled(boolean callidEnabled) {
        this.callidEnabled = callidEnabled;
    }

    public boolean isCodeEnabled() {
        return codeEnabled;
    }

    public void setCodeEnabled(boolean codeEnabled) {
        this.codeEnabled = codeEnabled;
    }

    public boolean isReasonEnabled() {
        return reasonEnabled;
    }

    public void setReasonEnabled(boolean reasonEnabled) {
        this.reasonEnabled = reasonEnabled;
    }

    public boolean isCustipEnabled() {
        return custipEnabled;
    }

    public void setCustipEnabled(boolean custipEnabled) {
        this.custipEnabled = custipEnabled;
    }

    public boolean isEgressfromuriEnabled() {
        return egressfromuriEnabled;
    }

    public void setEgressfromuriEnabled(boolean egressfromuriEnabled) {
        this.egressfromuriEnabled = egressfromuriEnabled;
    }

    public boolean isRequriEnabled() {
        return requriEnabled;
    }

    public void setRequriEnabled(boolean requriEnabled) {
        this.requriEnabled = requriEnabled;
    }

    public boolean isDesturiEnabled() {
        return desturiEnabled;
    }

    public void setDesturiEnabled(boolean desturiEnabled) {
        this.desturiEnabled = desturiEnabled;
    }

    public boolean isSendpchargeEnabled() {
        return sendpchargeEnabled;
    }

    public void setSendpchargeEnabled(boolean sendpchargeEnabled) {
        this.sendpchargeEnabled = sendpchargeEnabled;
    }

    public boolean isPchargeheaderEnabled() {
        return pchargeheaderEnabled;
    }

    public void setPchargeheaderEnabled(boolean pchargeheaderEnabled) {
        this.pchargeheaderEnabled = pchargeheaderEnabled;
    }

    public boolean isEgressvendoridEnabled() {
        return egressvendoridEnabled;
    }

    public void setEgressvendoridEnabled(boolean egressvendoridEnabled) {
        this.egressvendoridEnabled = egressvendoridEnabled;
    }

    public boolean isHostnameEnabled() {
        return hostnameEnabled;
    }

    public void setHostnameEnabled(boolean hostnameEnabled) {
        this.hostnameEnabled = hostnameEnabled;
    }

    public boolean isOrigcallingEnabled() {
        return origcallingEnabled;
    }

    public void setOrigcallingEnabled(boolean origcallingEnabled) {
        this.origcallingEnabled = origcallingEnabled;
    }

    public boolean isCallingEnabled() {
        return callingEnabled;
    }

    public void setCallingEnabled(boolean callingEnabled) {
        this.callingEnabled = callingEnabled;
    }

    public boolean isDialedEnabled() {
        return dialedEnabled;
    }

    public void setDialedEnabled(boolean dialedEnabled) {
        this.dialedEnabled = dialedEnabled;
    }

    public boolean isResporgEnabled() {
        return resporgEnabled;
    }

    public void setResporgEnabled(boolean resporgEnabled) {
        this.resporgEnabled = resporgEnabled;
    }

    public boolean isEgressvendorrateEnabled() {
        return egressvendorrateEnabled;
    }

    public void setEgressvendorrateEnabled(boolean egressvendorrateEnabled) {
        this.egressvendorrateEnabled = egressvendorrateEnabled;
    }

    public boolean isVendoripEnabled() {
        return vendoripEnabled;
    }

    public void setVendoripEnabled(boolean vendoripEnabled) {
        this.vendoripEnabled = vendoripEnabled;
    }

    public boolean isVendorportEnabled() {
        return vendorportEnabled;
    }

    public void setVendorportEnabled(boolean vendorportEnabled) {
        this.vendorportEnabled = vendorportEnabled;
    }

    public String getCalltypeVal() {
        return calltypeVal;
    }

    public void setCalltypeVal(String calltypeVal) {
        this.calltypeVal = calltypeVal;
    }

    public String getMethodVal() {
        return methodVal;
    }

    public void setMethodVal(String methodVal) {
        this.methodVal = methodVal;
    }

    public String getFrom_tagVal() {
        return from_tagVal;
    }

    public void setFrom_tagVal(String from_tagVal) {
        this.from_tagVal = from_tagVal;
    }

    public String getTo_tagVal() {
        return to_tagVal;
    }

    public void setTo_tagVal(String to_tagVal) {
        this.to_tagVal = to_tagVal;
    }

    public String getCallidVal() {
        return callidVal;
    }

    public void setCallidVal(String calledVal) {
        this.callidVal = calledVal;
    }

    public String getCodeVal() {
        return codeVal;
    }

    public void setCodeVal(String codeVal) {
        this.codeVal = codeVal;
    }

    public String getReasonVal() {
        return reasonVal;
    }

    public void setReasonVal(String reasonVal) {
        this.reasonVal = reasonVal;
    }

    public String getCustipVal() {
        return custipVal;
    }

    public void setCustipVal(String custipVal) {
        this.custipVal = custipVal;
    }

    public String getEgressfromuriVal() {
        return egressfromuriVal;
    }

    public void setEgressfromuriVal(String egressfromuriVal) {
        this.egressfromuriVal = egressfromuriVal;
    }

    public String getRequriVal() {
        return requriVal;
    }

    public void setRequriVal(String requriVal) {
        this.requriVal = requriVal;
    }

    public String getDesturiVal() {
        return desturiVal;
    }

    public void setDesturiVal(String desturiVal) {
        this.desturiVal = desturiVal;
    }

    public boolean getSendchargeVal() {
        return sendchargeVal;
    }

    public void setSendchargeVal(boolean sendchargeVal) {
        this.sendchargeVal = sendchargeVal;
    }

    public String getPchargerVal() {
        return pchargerVal;
    }

    public void setPchargerVal(String pchargerVal) {
        this.pchargerVal = pchargerVal;
    }

    public String getEgressvendoridVal() {
        return egressvendoridVal;
    }

    public void setEgressvendoridVal(String egressvendoridVal) {
        this.egressvendoridVal = egressvendoridVal;
    }

    public String getHostnameVal() {
        return hostnameVal;
    }

    public void setHostnameVal(String hostnameVal) {
        this.hostnameVal = hostnameVal;
    }

    public String getOrigcallingVal() {
        return origcallingVal;
    }

    public void setOrigcallingVal(String origcallingVal) {
        this.origcallingVal = origcallingVal;
    }

    public String getCallingVal() {
        return callingVal;
    }

    public void setCallingVal(String callingVal) {
        this.callingVal = callingVal;
    }

    public String getDialedeVal() {
        return dialedeVal;
    }

    public void setDialedeVal(String dialedeVal) {
        this.dialedeVal = dialedeVal;
    }

    public String getResporgVal() {
        return resporgVal;
    }

    public void setResporgVal(String resporgVal) {
        this.resporgVal = resporgVal;
    }

    public Double getEgressvendorrateFrom() {
        return egressvendorrateFrom;
    }

    public void setEgressvendorrateFrom(Double egressvendorrateFrom) {
        this.egressvendorrateFrom = egressvendorrateFrom;
    }

    public Double getEgressvendorrateTo() {
        return egressvendorrateTo;
    }

    public void setEgressvendorrateTo(Double egressvendorrateTo) {
        this.egressvendorrateTo = egressvendorrateTo;
    }

    

    public String getVendoripeVal() {
        return vendoripeVal;
    }

    public void setVendoripeVal(String vendoripeVal) {
        this.vendoripeVal = vendoripeVal;
    }

    public String getVendorportVal() {
        return vendorportVal;
    }

    public void setVendorportVal(String vendorportVal) {
        this.vendorportVal = vendorportVal;
    }

    public List<cdrRow> getRows() {
        return rows;
    }

    public void setRows(List<cdrRow> rows) {
        this.rows = rows;
    }

    public String getCustIpOperation() {
        return custIpOperation;
    }

    public void setCustIpOperation(String custIpOperation) {
        this.custIpOperation = custIpOperation;
    }

    public String getEgressvendoridOperation() {
        return egressvendoridOperation;
    }

    public void setEgressvendoridOperation(String egressvendoridOperation) {
        this.egressvendoridOperation = egressvendoridOperation;
    }

    public String getOrigcallingOperation() {
        return origcallingOperation;
    }

    public void setOrigcallingOperation(String origcallingOperation) {
        this.origcallingOperation = origcallingOperation;
    }

    public String getCallingOperation() {
        return callingOperation;
    }

    public void setCallingOperation(String callingOperation) {
        this.callingOperation = callingOperation;
    }

    public String getDialedOperation() {
        return dialedOperation;
    }

    public void setDialedOperation(String dialedOperation) {
        this.dialedOperation = dialedOperation;
    }

    public String getResporgOperation() {
        return resporgOperation;
    }

    public void setResporgOperation(String resporgOperation) {
        this.resporgOperation = resporgOperation;
    }

    public String getCalltypeOperation() {
        return calltypeOperation;
    }

    public void setCalltypeOperation(String calltypeOperation) {
        this.calltypeOperation = calltypeOperation;
    }

    public List<String> getSelectedOutRows() {
        return SelectedOutRows;
    }

    public void setSelectedOutRows(List<String> SelectedOutRows) {
        this.SelectedOutRows = SelectedOutRows;
    }

    public List<String> getOutRowsList() {
        return OutRowsList;
    }

    public void setOutRowsList(List<String> OutRowsList) {
        this.OutRowsList = OutRowsList;
    }

    public DualListModel<String> getFieldmodel() {
        return fieldmodel;
    }

    public void setFieldmodel(DualListModel<String> fieldmodel) {
        this.fieldmodel = fieldmodel;
    }

    

    public List<cdrViewerNewRow> getRows2() {
        return rows2;
    }

    public void setRows2(List<cdrViewerNewRow> rows2) {
        this.rows2 = rows2;
    }

    public DashboardModel getModel() {
        return model;
    }

    public void setModel(DashboardModel model) {
        this.model = model;
    }

    public List<String> getSelectedOutRows2() {
        return SelectedOutRows2;
    }

    public void setSelectedOutRows2(List<String> SelectedOutRows2) {
        this.SelectedOutRows2 = SelectedOutRows2;
    }

    public HashMap<String, String> getNameToField() {
        return NameToField;
    }

    public void setNameToField(HashMap<String, String> NameToField) {
        this.NameToField = NameToField;
    }

    public String getConditionOperation() {
        return conditionOperation;
    }

    public void setConditionOperation(String conditionOperation) {
        this.conditionOperation = conditionOperation;
    }

    public String getConditionValue() {
        return conditionValue;
    }

    public void setConditionValue(String conditionValue) {
        this.conditionValue = conditionValue;
    }

    public String getConditionField() {
        return conditionField;
    }

    public void setConditionField(String conditionField) {
        this.conditionField = conditionField;
    }

    public ArrayList<cdrViewerCondition> getConditions() {
        return conditions;
    }

    public void setConditions(ArrayList<cdrViewerCondition> conditions) {
        this.conditions = conditions;
    }

    public String getSelectedCondition() {
        return selectedCondition;
    }

    public void setSelectedCondition(String selectedCondition) {
        this.selectedCondition = selectedCondition;
    }

}
