package cn.org.oritention.accounts.dao;

import cn.org.oritention.accounts.pojo.DataObj;
import cn.org.oritention.accounts.pojo.InvitationCard;
import org.springframework.stereotype.Repository;

import java.io.*;

@Repository
public class DataSyncDao {
    public boolean storeData(DataObj dataObj) {
        File path = new File("data"+File.separator+dataObj.getInvitationCard().getCard()+File.separator+dataObj.getInvitationCard().getPwd());

        try (FileWriter fileWriter = new FileWriter(path)) {
             fileWriter.write("version: "+dataObj.getVersion()+"\n");
             fileWriter.write("accounts: "+dataObj.getAccounts()+"\n");
             fileWriter.write("details: "+dataObj.getDetails()+"\n");
        } catch (IOException e) {
            return false;
        }
        return true;
    }

    public int getVersion(InvitationCard invitationCard) {
        File path = new File("data"+File.separator+invitationCard.getCard()+File.separator+invitationCard.getPwd());

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(path))) {
            String versionLine = bufferedReader.readLine();
            if (versionLine==null) return -1;
            return Integer.parseInt(versionLine.substring(versionLine.indexOf(' ')+1));
        } catch (IOException e) {
            return -1;
        }
    }

    public DataObj getData(InvitationCard invitationCard) {
        File path = new File("data"+File.separator+invitationCard.getCard()+File.separator+invitationCard.getPwd());

        DataObj d = new DataObj();
        d.setInvitationCard(invitationCard);
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(path))) {
            String versionLine = bufferedReader.readLine();
            d.setVersion(Integer.parseInt(versionLine.substring(versionLine.indexOf(' ')+1)));
            String accountsLine = bufferedReader.readLine();
            d.setAccounts(accountsLine.substring(accountsLine.indexOf(": ")+2));
            String detailsLine = bufferedReader.readLine();
            d.setDetails(detailsLine.substring(detailsLine.indexOf(": ")+2));

            return d;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
