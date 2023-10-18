import java.util.List;

public class UserServiceCriterialApi {
    private UserDaoCriteriaAPI userDaoCriteriaAPI = new UserDaoCriteriaAPI();

    public UserServiceCriterialApi() {
    }

    public List findUserById(int id) {
        return userDaoCriteriaAPI.findById(id);
    }

    public void addUser(User user) {
        userDaoCriteriaAPI.add(user);
    }

    public void deleteUser(int id) {
        userDaoCriteriaAPI.deleteById(id);
    }

    public void updateUser(User user) {
        userDaoCriteriaAPI.update(user);
    }

    public List<User> findAllUsers() {
        return userDaoCriteriaAPI.findAll();
    }

    public  List<User> findAllFilterAndPang(int firstResult, int maxResult, String filter1, String filter2){
        return userDaoCriteriaAPI.findAllPagingAndFilter( firstResult,  maxResult,  filter1,  filter2);
    }


}
