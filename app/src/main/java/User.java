public class User {

    //User class fields

    private String loginName;
    private String password;
    private boolean accountState;
    private String contactInfo;
    private AccountType accountType;


    //User constructor w/ parameters

    public User (String loginName, String password, boolean accountState, String contactInfo,
                 AccountType accountType) {
        this.loginName = loginName;
        this.password = password;
        this.accountState = accountState;
        this.contactInfo = contactInfo;
        this.accountType = accountType;
    }


    //loginName getter and setter methods

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }


    //password getter and setter methods

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


    //accountName getter and setter methods

    public boolean getAccountState() {
        return accountState;
    }

    public void setAccountState(boolean accountState) {
        this.accountState = accountState;
    }


    //contactInfo getter and setter methods

    public String getContactInfo() {
        return contactInfo;
    }

    public void setContactInfo(String contactInfo) {
        this.contactInfo = contactInfo;
    }


    //accountType getter and setter methods

    public AccountType getAccountType() {
        return accountType;
    }

    public void setAccountType(AccountType accountType) {
        this.accountType = accountType;
    }

}
