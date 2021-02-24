package proxy;

public class UserServiceImpl implements UserService {
    @Override
    public void addUser(String name) {
        System.out.println("addUser: " + name);
    }

    @Override
    public void deleteUser(int id) {
        System.out.println("deleteUser: " + id);
    }

    @Override
    public void updateUser() {
        System.out.println("updateUser");
    }

    @Override
    public void selectUser() {
        System.out.println("selectUser");
    }

    public void transfer() {
        System.out.println("a减钱");
        System.out.println("b加钱");
    }
}
