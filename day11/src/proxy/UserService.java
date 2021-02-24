package proxy;

public interface UserService {
    void addUser(String name);
    void deleteUser(int id);
    void updateUser();
    void selectUser();
    void transfer();
}
