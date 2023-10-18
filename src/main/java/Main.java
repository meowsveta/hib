
public class Main {
    public static void main(String[] args) {
        UserServiceHql userServiceHql = new UserServiceHql();
        UserServiceCriterialApi userServiceCriterialApi = new UserServiceCriterialApi();

        User user = new User("Masha", "Msk", 26, "Russia");


        System.out.println("---------HQL------");
        System.out.println("---------addHQL------");
        userServiceHql.addUser(user);
        System.out.println("---------deleteHQL------");
        userServiceHql.deleteById(127);
        System.out.println("---------findUserByIdHQL------");
        System.out.println(userServiceHql.findUserById(118));
        System.out.println("---------updateByIdHQL------");
        user.setCity("Omsk");
        userServiceHql.updateUser(user);
        System.out.println("---------findAllUsersIdHQL------");
        System.out.println(userServiceHql.findAllUsers());
        System.out.println("---------findAllFilterAndPang------");
        System.out.println(userServiceHql.findAllFilterAndPang("name", "kolya", 3, 5));


        System.out.println("---------criteriaAPI------");
        System.out.println("---------findAllUsers------");
        System.out.println(userServiceCriterialApi.findAllUsers());
        System.out.println("---------findById------");
        System.out.println(userServiceCriterialApi.findUserById(41));
        System.out.println("---------Delete------");
        userServiceCriterialApi.deleteUser(122);
        System.out.println("---------findAllFilterAndPang------");
        System.out.println(userServiceCriterialApi.findAllFilterAndPang(3,5, "name", "kolya"));
        System.out.println("---------Update------");
        user.setAge(15);
        userServiceCriterialApi.updateUser(user);
    }
}
