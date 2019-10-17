package framework.utils.testrail.models;

import framework.utils.testrail.api.APIClient;
import framework.utils.properties.PropertiesResourceManager;

public class Reporter {

    private static PropertiesResourceManager manager = new PropertiesResourceManager("testrail");

    private APIClient apiClient;
    private String projectId;
    private String testRunID;

    private static Reporter reporter;

    private Reporter() {
        this.apiClient = new APIClient(manager.getProperty("link"));
        this.projectId = manager.getProperty("projectid");
        this.apiClient.setUser(manager.getProperty("email"));
        this.apiClient.setPassword(manager.getProperty("password"));
    }

    public static Reporter getReporter() {
        if (reporter == null) {
            reporter = new Reporter();
        }
        return reporter;
    }

    public APIClient getApiClient() {
        return apiClient;
    }

    public String getProjectId() {
        return projectId;
    }

    public String getTestRunID() {
        return manager.getProperty("testrun");
    }

    public void setTestRunID(String testRunId) {
        manager.setProperty("testrun", testRunId);
    }
}
