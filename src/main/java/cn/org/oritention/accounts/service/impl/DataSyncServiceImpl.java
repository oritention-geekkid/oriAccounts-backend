package cn.org.oritention.accounts.service.impl;

import cn.org.oritention.accounts.dao.DataSyncDao;
import cn.org.oritention.accounts.dao.InvitationCardDao;
import cn.org.oritention.accounts.pojo.DataObj;
import cn.org.oritention.accounts.pojo.InvitationCard;
import cn.org.oritention.accounts.pojo.Result;
import cn.org.oritention.accounts.service.DataSyncService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DataSyncServiceImpl implements DataSyncService {
    @Autowired
    private InvitationCardDao invitationCardDao;
    @Autowired
    private DataSyncDao dataSyncDao;

    @Override
    public Result dataSync(DataObj dataObj) {
        switch (invitationCardDao.invitationCardValidation(dataObj.getInvitationCard())) {
            case 0 -> {
                if (dataObj.getVersion()>dataSyncDao.getVersion(dataObj.getInvitationCard())) {
                    if (storeData(dataObj)) {
                        return new Result(20001, "数据版本大于云端，数据上传成功", null);
                    } else {
                        return new Result(20000, "数据上传失败，请联系管理员", null);
                    }
                } else {
                    return new Result(20002,"数据版本小于或等于云端，数据同步成功",getData(dataObj.getInvitationCard()));
                }
            }
            case -1 -> {
                return new Result(20000,"邀请卡不存在",null);
            }
            case -2 -> {
                return new Result(20000,"邀请卡密码不正确",null);
            }
        }
        return null;
    }

    @Override
    public boolean storeData(DataObj dataObj) {
        return dataSyncDao.storeData(dataObj);
    }

    @Override
    public DataObj getData(InvitationCard invitationCard) {
        return dataSyncDao.getData(invitationCard);
    }
}
