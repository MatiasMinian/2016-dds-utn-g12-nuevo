package ar.edu.utn.d2s.model.processes.failurestrategies;

import ar.edu.utn.d2s.model.processes.dtos.FailureInfo;
import ar.edu.utn.d2s.utils.mail.MailService;

public class SendMailFailureStrategy implements FailureStrategy {

    private MailService mailService = MailService.getInstance();

    @Override
    public void handleFailure(FailureInfo failureInfo) {
        mailService.sendMail(failureInfo.getAdminMail(), "Process Failure", failureInfo.getErrorMsg());
    }
}
