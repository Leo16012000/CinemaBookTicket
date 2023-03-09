package controllers;

import dao.UserDao;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.util.Collections;
import java.util.HashMap;

import main.SessionManager;
import models.User;
import views.CustomerHomeView;
import views.HomeView;
import views.LoginView;

public class LoginController {

    private LoginView view;
    UserDao userDao = new UserDao();

    public LoginController(LoginView view) {
        this.view = view;
        view.setVisible(true);
        addEvent();
    }

    public LoginView getView() {
        return view;
    }

    public void setView(LoginView view) {
        this.view = view;
        view.setVisible(true);
    }

    public void login() {
        String username = view.getTxtUsername().getText();
        String password = new String(view.getTxtPassword().getPassword());
        try {
            User user = userDao.getByUsername(username);
            if (user == null) {
                view.showError("Không tồn tại tài khoản!");
                return;
            }
            if (!user.checkPassword(password)) {
                view.showError("Mật khẩu sai");
                return;
            }
            SessionManager.create(user);//Khởi tạo session

            switch (user.getPermission()) {
//                case MANAGER:
//                    //Admin controller
//                    AdminDashboardController controller = new AdminDashboardController(new AdminDashboardView());
//                    controller.getView().setPanel(new HomeView());
//                    view.dispose();// Tắt form đăng nhập
//                    break;
                case USER:
                    CustomerHomeController controller1 = new CustomerHomeController(new CustomerHomeView());
                    controller1.getView().setPanel(new HomeView());
                    view.dispose();// Tắt form đăng nhập                    
                    break;
                case GUEST:
                    SessionManager.update();
                    view.dispose();
                    break;
                default:
                    view.showError("Vui lòng liên hệ admin để biết thêm chi tiết");
                    SessionManager.update();
                    view.dispose();
                    break;
            }
        } catch (Exception e) {
            view.showError(e);
        }
    }

    // Tạo sự kiện
    public void addEvent() {
        //Sự kiện login
        view.getTxtPassword().addKeyListener(new java.awt.event.KeyAdapter() {
            @Override
            public void keyPressed(java.awt.event.KeyEvent evt) {
                if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
                    view.getBtnLogin().doClick();
                }
            }
        });
        view.getBtnLogin().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                login();
            }
        });
        view.getLblForgotPassword().addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                view.showMessage("Chưa hỗ trợ!");
            }
        });
        view.getLblRegister().addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                view.showMessage("Chưa hỗ trợ!");
            }
        });
    }

}
