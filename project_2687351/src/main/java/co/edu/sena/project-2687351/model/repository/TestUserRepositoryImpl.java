package co.edu.sena.project2687351.model.repository;

import co.edu.sena.project2687351.model.User;

import java.sql.SQLException;

public class TestUserRepositoryImpl {

    public static  void main(String[] args) throws SQLException{
        Repository<User> repository = new UserRepositoryImpl();

        System.out.println("==========  saveObj Insert ==========");  //  insert
        User userInsert = new User();
        userInsert.setUser_firstname("Jhoan");
        userInsert.setUser_lastname("Zamudio");
        userInsert.setUser_email("jhoanse@gmail.com");
        userInsert.setUser_password("aimbot256");
        repository.saveObj(userInsert);
        userInsert.setUser_firstname("Sebastian");
        userInsert.setUser_lastname("Marulanda");
        userInsert.setUser_email("maiqui@hotmail.com");
        userInsert.setUser_password("mareilei276");
        repository.saveObj(userInsert);

        System.out.println("==========  listAllObj ==========");
        repository.listAllObj().forEach(System.out::println);
        System.out.println();

        System.out.println("==========  byIdObj ==========");
        System.out.println(repository.byIdObj(1));
        System.out.println();

        System.out.println("==========  saveObj =========="); // update
        User userUpdate = new User();
        userUpdate.setUser_id(2);
        userUpdate.setUser_firstname("maicol");
        userUpdate.setUser_lastname("pelaez");
        userUpdate.setUser_email("maikolpz@gmail.com");
        userUpdate.setUser_password("wertyuiopñlkjhgfdsa");
        repository.saveObj(userInsert);
        repository.listAllObj().forEach(System.out::println);
        System.out.println();

        System.out.println("==========  deleteObj ==========");
        repository.deleteObj(2);
        repository.listAllObj().forEach(System.out::println);

    }
}  // TestUserRepositoryImpl
