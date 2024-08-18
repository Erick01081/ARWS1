package edu.eci.arsw.blacklistvalidator;
import edu.eci.arsw.spamkeywordsdatasource.HostBlacklistsDataSourceFacade;

import java.lang.annotation.Documented;
import java.util.ArrayList;

public class BlackListThread extends Thread {
    private int a;
    private int b;
    private String ipAddress;
    //private HostBlackListsValidator hblv;
    private static int ocurrencesCount;
    private ArrayList<Integer> indexReport = new ArrayList<Integer>();
    private boolean endSearch;

    public BlackListThread(int a, int b, String ip) {
        this.a = a;
        this.b = b;
        this.ipAddress = ip;
        //this.hblv = hblv;
        this.ocurrencesCount = 0;
        endSearch = false;
    }

    public boolean endByBlackListCount(){
        if (ocurrencesCount == HostBlackListsValidator.BLACK_LIST_ALARM_COUNT){
            return true;
        }
        return false;
    }
    
    public void findReports(String ipAdrress, int a, int b){
        int i;
        HostBlacklistsDataSourceFacade skds=HostBlacklistsDataSourceFacade.getInstance();
        for (i = a; i < b && !endByBlackListCount(); i++){
            if(skds.isInBlackListServer(i, ipAdrress)){
                ocurrencesCount++;
                indexReport.add(i);
            }
        }
        endSearch = true;
    }

    @Override
    public void run(){
        while(!endByBlackListCount() && !endSearch){
            findReports(ipAddress, a, b);
        }
    }

    public ArrayList<Integer> getHosts(){
        return indexReport;
    }
    
}
