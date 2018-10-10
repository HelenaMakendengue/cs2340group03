public class User {

    private String loginName;
    private String password;
    private boolean accountState;
    private String contactInfo;
    private AccountType accountType;

    public User (String loginName, String password, boolean accountState, String contactInfo,
                 AccountType accountType) {
        this.loginName = loginName;
        this.password = password;
        this.accountState = accountState;
        this.contactInfo = contactInfo;
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

    public String getContactInfo() {
        return contactInfo;
    }
    public void setContactInfo(String contactInfo) {
        this.contactInfo = contactInfo;
    }

    public AccountType getAccountType() {
        return accountType;
    }
    public void setAccountType(AccountType accountType) {
        this.accountType = accountType;
    }

}
