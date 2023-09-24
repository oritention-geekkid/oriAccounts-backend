package cn.org.oritention.accounts.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class InvitationCard {
    private String card;
    private String pwd;

    public static InvitationCard makeInvitationCard() {
        InvitationCard ret = new InvitationCard();
        ret.card = UUID.randomUUID().toString();
        ret.pwd = UUID.randomUUID().toString().substring(0,8);

        return ret;
    }
}
