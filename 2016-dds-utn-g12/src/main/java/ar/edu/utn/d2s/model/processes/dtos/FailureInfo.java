package ar.edu.utn.d2s.model.processes.dtos;

import ar.edu.utn.d2s.model.processes.SingleProcess;

public class FailureInfo {

    private String adminMail = "";
    private String errorMsg = "";
    private SingleProcess process;

    public FailureInfo(String adminMail, String errorMsg, SingleProcess process) {
        this.adminMail = adminMail;
        this.errorMsg = errorMsg;
        this.process = process;
    }

    public String getAdminMail() {
        return adminMail;
    }

    public void setAdminMail(String adminMail) {
        this.adminMail = adminMail;
    }

    public String getErrorMsg() {
        return errorMsg;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }

    public SingleProcess getProcess() {
        return process;
    }

    public void setProcess(SingleProcess process) {
        this.process = process;
    }
}
