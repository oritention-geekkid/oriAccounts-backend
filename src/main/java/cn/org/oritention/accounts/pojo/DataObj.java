package cn.org.oritention.accounts.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DataObj {
    private InvitationCard invitationCard;
    private int version = 0;
    private String accounts;
    private String details;
}
