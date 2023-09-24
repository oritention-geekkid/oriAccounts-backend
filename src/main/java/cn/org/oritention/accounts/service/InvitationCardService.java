package cn.org.oritention.accounts.service;

import cn.org.oritention.accounts.pojo.InvitationCard;
import cn.org.oritention.accounts.pojo.Result;

import java.io.IOException;

public interface InvitationCardService {
    Result genAndGetInvitationCard() throws IOException;
    int invitationCardValidation(InvitationCard invitationCard);
}
