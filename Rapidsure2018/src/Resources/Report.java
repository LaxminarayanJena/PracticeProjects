package Resources;

import java.util.HashMap;

/**
 * Created by agarwalp on 5/28/2017.
 */
public class Report {

    private HashMap<String, String> resultMap = new HashMap<>();
    private String reportPath;
    private String transactionType;

    public Report(String reportPath) {
        this.reportPath = reportPath;
        this.transactionType = "NB";
    }

    public Report(String reportPath, String transactionType) {
        this.reportPath = reportPath;
        this.transactionType = transactionType;
    }

    /**
     * FUNCTION NAME        : addResult
     * DESCRIPTION          : adds key and value data to the map
     * INPUT PARAMETERS     : key   ;   value
     * OUTPUT               : None
     * AUTHOR               : Priyal Agarwal
     */
    public void addResult(String key, String value) {
        resultMap.put(key, value);
    }

    /**
     * FUNCTION NAME        : updateReportFile
     * DESCRIPTION          : selects the reporting function depending upon the transaction type
     * INPUT PARAMETERS     : None
     * OUTPUT               : None
     * AUTHOR               : Priyal Agarwal
     */
    public void updateReportFile() {
        ReportWriter reportWriter = ReportWriter.getInstance();
        switch (transactionType.toLowerCase()) {
            case "nb":
                reportWriter.updateReportFile(reportPath, resultMap);
                break;
            case "endorsement":
                reportWriter.updateEndorsementReportFile(reportPath, resultMap);
                break;
            case "renew":
                reportWriter.updateRenewalReportFile(reportPath, resultMap);
                break;
            case "cancel":
                reportWriter.updateCancellationReportFile(reportPath, resultMap);
                break;
            case "reinstate":
                reportWriter.updateReinstateReportFile(reportPath, resultMap);
                break;
            case "renewal_payment_portal":
                reportWriter.updateRenewalPaymentReportFile(reportPath, resultMap);
                break;
            default:
                throw new IllegalArgumentException("Does not support transaction type=" + transactionType);
        }
    }

}
