package com.cj.caojun.lastmvp.modle.bean;

/**
 * Created by caojun on 2017/10/16.
 */

public class LoginBean {

    /**
     * code : 200
     * user : {"userHead":"打开疯狂的","userId":6,"userName":"小明","userPassword":"111","userPhone":"13011196165","userSex":"男"}
     */

    private String code;
    private UserBean user;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public UserBean getUser() {
        return user;
    }

    public void setUser(UserBean user) {
        this.user = user;
    }

    public static class UserBean {
        /**
         * userHead : 打开疯狂的
         * userId : 6
         * userName : 小明
         * userPassword : 111
         * userPhone : 13011196165
         * userSex : 男
         */

        private String userHead;
        private int userId;
        private String userName;
        private String userPassword;
        private String userPhone;
        private String userSex;

        public String getUserHead() {
            return userHead;
        }

        public void setUserHead(String userHead) {
            this.userHead = userHead;
        }

        public int getUserId() {
            return userId;
        }

        public void setUserId(int userId) {
            this.userId = userId;
        }

        public String getUserName() {
            return userName;
        }

        public void setUserName(String userName) {
            this.userName = userName;
        }

        public String getUserPassword() {
            return userPassword;
        }

        public void setUserPassword(String userPassword) {
            this.userPassword = userPassword;
        }

        public String getUserPhone() {
            return userPhone;
        }

        public void setUserPhone(String userPhone) {
            this.userPhone = userPhone;
        }

        public String getUserSex() {
            return userSex;
        }

        public void setUserSex(String userSex) {
            this.userSex = userSex;
        }
    }
}
