package b_autoLogin;

public interface UserDao {
    User findUserByUsernameAndPwd(String username, String password);
}
