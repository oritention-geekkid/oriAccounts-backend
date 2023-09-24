package cn.org.oritention.accounts.service.impl;

import cn.org.oritention.accounts.dao.InvitationCardDao;
import cn.org.oritention.accounts.pojo.InvitationCard;
import cn.org.oritention.accounts.pojo.Result;
import cn.org.oritention.accounts.service.InvitationCardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class InvitationCardServiceImpl implements InvitationCardService {
    @Autowired
    private InvitationCardDao invitationCardDao;

    @Override
    public Result genAndGetInvitationCard() throws IOException {
        InvitationCard newCard = InvitationCard.makeInvitationCard();

        if (invitationCardDao.createNewUserFolder(newCard)) {
            return new Result(10001,"成功生成并获取邀请码",newCard);
        } else {
            return new Result(10000,"生成并获取邀请码失败，请联系管理员",null);
        }


    }

    @Override
    public int invitationCardValidation(InvitationCard invitationCard) {
        return invitationCardDao.invitationCardValidation(invitationCard);
    }
}
