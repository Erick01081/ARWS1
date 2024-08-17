package edu.eci.arsw.blacklistvalidator;

public class BlackListThread extends Thread {
    private int a;
    private int b;
    private String ip;
    private HostBlackListsValidator hblv;
    private int ocurrencesCount;
    private static void int

    public BlackListThread(int a, int b, String ip, HostBlackListsValidator hblv) {
        this.a = a;
        this.b = b;
        this.ip = ip;
        this.hblv = hblv;
        this.ocurrencesCount = 0;
    }

    public boolean blackListCount(){
        if (){
            return true;
        }
        return false;
    }


}
