package edu.gatech.cs2340.donationtracer;

public class User {

    private String loginName;
    private String password;
    private boolean accountState;
    private String email;
    private static AccountType accountType;

    public User (String loginName, String password, boolean accountState, String email,
                 AccountType accountType) {
        this.loginName = loginName;
        this.password = password;
        this.accountState = accountState;
        this.email = email;
        this.accountType = accountType;
    }

    public String getLoginName() {
        return loginName;
    }
    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }

    public boolean getAccountState() {
        return accountState;
    }
    public void setAccountState(boolean accountState) {
        this.accountState = accountState;
    }

    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }

    public AccountType getAccountType() {
        return accountType;
    }
    public void setAccountType(AccountType accountType) {
        this.accountType = accountType;
    }

}
