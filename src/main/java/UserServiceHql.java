import java.util.List;

public class UserServiceHql {
    private UserDaoHql userDaoHql = new UserDaoHql();

    public UserServiceHql() {
    }

    public User findUserById(int id) {
        return userDaoHql.findById(id);
    }

    public void deleteById(int id){
        userDaoHql.deleteById(id);
    }

    public void addUser(User user) {
        userDaoHql.add(user);
    }

    public void deleteUser(User user) {
        userDaoHql.delete(user);
    }

    public void updateUser(User user) {
        userDaoHql.update(user);
    }

    public List<User> findAllUsers() {
        return userDaoHql.findAll();
    }

    public  List<User> findAllFilterAndPang(String filter1, String filter2, int firstResult, int maxResult){
        return userDaoHql.findAllFilter(filter1, filter2, firstResult, maxResult);
    }


}
