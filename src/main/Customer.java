package main;

import controllers.CustomerHomeController;
import dao.UserDao;
import models.User;
import views.CustomerHomeView;

public class Customer {

//    public static void main(String[] args) {
//        UserDao userDao = new UserDao();
//        try {
//            javax.swing.UIManager.setLookAndFeel("com.formdev.flatlaf.FlatIntelliJLaf");
//            System.out.println("Khởi tạo look and feel thành công!");
//            User u = userDao.get(2);
//            SessionManager.create(u);
//            new CustomerHomeController(new CustomerHomeView()).getView();
//            Runtime.getRuntime().addShutdownHook(new Thread());
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
	
	public static void main(String[] args) {
      UserDao userDao = new UserDao();
      try {
          javax.swing.UIManager.setLookAndFeel("com.formdev.flatlaf.FlatIntelliJLaf");
          System.out.println("Khởi tạo look and feel thành công!");
          User u = userDao.get(2);
          SessionManager.create(u);
          new CustomerHomeController(new CustomerHomeView()).getView();
          Runtime.getRuntime().addShutdownHook(new Thread());
      } catch (Exception e) {
          e.printStackTrace();
      }
  }

}
