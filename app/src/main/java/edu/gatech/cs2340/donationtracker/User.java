package edu.gatech.cs2340.donationtracker;

public class User {

    private String loginName;
    private String password;
    private boolean accountState;
    private String email;
    private AccountType accountType;

    /**
     * This method creates a user with the given parameters
     *
     * @param loginName the loginName of the user
     * @param password the password of the user
     * @param accountState the accountState of the user
     * @param email the email of the user
     * @param accountType the accountType of the user
     */
    public User (String loginName, String password, boolean accountState, String email,
                 AccountType accountType) {
        this.loginName = loginName;
        this.password = password;
        this.accountState = accountState;
        this.email = email;
        this.accountType = accountType;
    }

    /**
     * This method gets and returns the loginName
     * of each user
     *
     * @return loginName the loginName of the user
     */
    public String getLoginName() {
        return loginName;
    }

    /**
     * This method sets the loginName of each user
     *
     * @param loginName the loginName of the user
     */
    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    /**
     * This method gets and returns the password
     * of each user
     *
     * @return password the password of the user
     */
    public String getPassword() {
        return password;
    }

    /**
     * This method sets the password of each user
     *
     * @param password the password of the user
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * This method gets and returns the account
     * state of each user
     *
     * @return accountState the accountState of the user
     */
    public boolean getAccountState() {
        return accountState;
    }

    /**
     * This method sets the accountState of each user
     *
     * @param accountState the accountState of the user
     */
    public void setAccountState(boolean accountState) {
        this.accountState = accountState;
    }

    /**
     * This method gets and returns the email
     * of each user
     *
     * @return email the email of the user
     */
    public String getEmail() {
        return email;
    }

    /**
     * This method sets the email of each user
     *
     * @param email the email of the user
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * This method gets and returns the account type
     * of each user
     *
     * @return account type the account type of the user
     */
    public AccountType getAccountType() {
        return accountType;
    }

    /**
     * This method sets the accountType of each user
     *
     * @param accountType the accountType of the user
     */
    public void setAccountType(AccountType accountType) {
        this.accountType = accountType;
    }

}