package b_autoLogin;

public class UserDaoImpl implements UserDao {

    @Override
    public User findUserByUsernameAndPwd(String username, String password) {
        return new User(1, username, password, "张三");
    }
}
