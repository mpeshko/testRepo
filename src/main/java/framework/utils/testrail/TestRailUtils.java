package framework.utils.testrail;

import framework.utils.testrail.api.APIException;
import framework.utils.testrail.models.Reporter;
import org.json.simple.JSONObject;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class TestRailUtils {
    private final Reporter REPORTER = Reporter.getReporter();
    private final int PASSED_CODE = 1;
    private final int BLOCKED_CODE = 2;
    private final int UNTESTED_CODE = 3;
    private final int RETESTED_CODE = 4;
    private final int FAILED_CODE = 5;


    private String createRun() {
        Map<String, Object> data = new HashMap();
        data.put("name", String.format("Run%s", new Random().nextInt(100)));
        data.put("include_all", true);
        try {
            JSONObject response = (JSONObject) REPORTER.getApiClient().sendPost(String.format("add_run/%s", REPORTER.getProjectId()), data);
            return (response.get("id").toString());
        } catch (IOException | APIException e) {
            e.printStackTrace();
            return null;
        }
    }

    public void addResultForTestCase(String testRunId, String testCaseId, int status) throws IOException, APIException {
        Map<String, Object> data = new HashMap();
        data.put("status_id", status);
        data.put("comment", "Automation Test Executed.");
        REPORTER.getApiClient().sendPost("add_result_for_case/"+testRunId+"/"+testCaseId+"", data);
    }

    public int convertTestNGtoTestRail(int statusCode){
        switch (statusCode){
            case 1:
                return PASSED_CODE;
            case 2:
                return FAILED_CODE;
            case 3:
                return UNTESTED_CODE;
        }
        return BLOCKED_CODE;
    }

    public String insertTestRunId(){
        if (REPORTER.getTestRunID().isEmpty()){
            REPORTER.setTestRunID(createRun());
        }
        return (REPORTER.getTestRunID());
    }
}
