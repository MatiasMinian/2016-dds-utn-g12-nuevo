package ar.edu.utn.d2s.model.processes;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class ProcessResult {

    public static final int RESULT_OK = 1;
    public static final int RESULT_ERROR = 0;
    // TODO Check where this list should be. Is it OK here ? Should we persist this ?
    public static List<ProcessResult> processResults = new ArrayList<>();

    private Calendar startTime;
    private Calendar endTime;
    private String processName;
    private String userName;
    private int result;
    private String errorMessage;

    public static void saveProcessResult(ProcessResult processResult) {
        processResults.add(processResult);
    }
    public static void removeProcessResult(ProcessResult processResult) {
        processResults.remove(processResult);
    }

    public Calendar getStartTime() {
        return startTime;
    }

    public void setStartTime(Calendar startTime) {
        this.startTime = startTime;
    }

    public Calendar getEndTime() {
        return endTime;
    }

    public void setEndTime(Calendar endTime) {
        this.endTime = endTime;
    }

    public String getProcessName() {
        return processName;
    }

    public void setProcessName(String processName) {
        this.processName = processName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public int getResult() {
        return result;
    }

    public void setResult(int result) {
        this.result = result;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }
}
