package cn.org.oritention.accounts.dao;

import cn.org.oritention.accounts.pojo.InvitationCard;
import org.springframework.stereotype.Repository;

import java.io.File;
import java.io.IOException;

@Repository
public class InvitationCardDao {
    private static final String dataPath = "."+File.separator+"data"+File.separator;
    public boolean createNewUserFolder(InvitationCard i) throws IOException {
        if (!new File(dataPath).exists()) {
            new File(dataPath).mkdir();
        }

        File f = new File(dataPath+i.getCard());
        File pwdF = new File(dataPath+i.getCard()+File.separator+i.getPwd());
        if (f.mkdir()) {
            return pwdF.createNewFile();
        } else {
            return false;
        }
    }

    public int invitationCardValidation(InvitationCard invitationCard) {
        if (!new File(dataPath+invitationCard.getCard()).exists()) {
            return -1;  // 邀请卡号不存在
        }
        if (!new File(dataPath+invitationCard.getCard()+File.separator+invitationCard.getPwd()).exists()) {
            return -2;  // 邀请卡密码错误
        }
        return 0;
    }
}
