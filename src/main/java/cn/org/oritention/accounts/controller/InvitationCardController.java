package cn.org.oritention.accounts.controller;

import cn.org.oritention.accounts.config.Config;
import cn.org.oritention.accounts.pojo.Result;
import cn.org.oritention.accounts.service.InvitationCardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
@CrossOrigin
public class InvitationCardController {
    @Autowired
    private InvitationCardService invitationCardService;

    @GetMapping("/getNewCard")
    public Result genAndGetInvitationCard() throws IOException {
        if (Config.canGenNewCard()) {
            return invitationCardService.genAndGetInvitationCard();
        } else {
            return new Result(10000,"暂未开放申请新验证码功能",null);
        }
    }
}
