public class User {

    //User class fields

    private String loginName;
    private String password;
    private AccountState accountState;
    private String contactInfo;


    //User constructor w/ parameters

    public User (String loginName, String password, AccountState accountState, String contactInfo) {
        this.loginName = loginName;
        this.password = password;
        this.accountState = accountState;
        this.contactInfo = contactInfo;
    }


    //loginName getter and setter methods

    public String getLoginName() {
        return this.loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }


    //password getter and setter methods

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


    //accountName getter and setter methods

    public AccountState getAccountState() {
        return this.accountState;
    }

    public void setAccountState(AccountState accountState) {
        this.accountState = accountState;
    }


    //contactInfo getter and setter methods

    public String getContactInfo() {
        return this.contactInfo;
    }

    public void setContactInfo(String contactInfo) {
        this.contactInfo = contactInfo;
    }

}
