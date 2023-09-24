package cn.org.oritention.accounts.service;

import cn.org.oritention.accounts.pojo.DataObj;
import cn.org.oritention.accounts.pojo.InvitationCard;
import cn.org.oritention.accounts.pojo.Result;

public interface DataSyncService {
    Result dataSync(DataObj dataObj);

    boolean storeData(DataObj dataObj);
    DataObj getData(InvitationCard invitationCard);

}
