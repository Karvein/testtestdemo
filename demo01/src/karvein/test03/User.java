package karvein.test03;

public class User {
    public String user_name;
    protected int user_id;
    private String user_password;

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    protected void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    private void setUser_password(String user_password) {
        this.user_password = user_password;
    }
}
