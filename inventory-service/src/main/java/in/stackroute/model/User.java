package in.stackroute.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class User {

    private String userName;
    private String password;

    public User() {

    }

    public User(String userName, String password) {
        this.userName = userName;
        this.password = password;
    }

    public static UserBuilder builder() {
        return new UserBuilder();
    }

    public static class UserBuilder {
        private String userName;
        private String password;

        UserBuilder() {
        }

        public User.UserBuilder userName(String userName) {
            this.userName = userName;
            return this;
        }

        public User.UserBuilder password(String password) {
            this.password = password;
            return this;
        }

        public User build() {
            return new User(this.userName, this.password);
        }
    }
}

class Test {
    public Test() {
        var users = User
                         .builder()
                         .userName("test")
                         .password("test")
                         .build();
    }



}


