package b_autoLogin;

public class UserServiceImpl implements UserService {
    @Override
    public User login(String username, String password) {
        UserDao userDao = new UserDaoImpl();
        return userDao.findUserByUsernameAndPwd(username, password);
    }
}
