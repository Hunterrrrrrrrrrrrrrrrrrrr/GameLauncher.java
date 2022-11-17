package Account;

import java.util.Scanner;

public class Player {
    private String account;
    private String password;
    public int win;
    public int lose;

    public Player (String account,int win,int lose) {
        this.account = account;
        this.win = win;
        this.lose = lose;
        this.password = "123456";
    }
    public void login(Scanner in) {

    }
}

