/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import java.sql.SQLException;

import javax.swing.JOptionPane;
import javax.swing.JPanel;

import main.SessionManager;
import models.User;
import views.CustomerHomeView;
import views.HomeView;
import views.LoginView;

public class CustomerHomeController {

    private CustomerHomeView view;
    HomeView homeView = new HomeView();
    JPanel[] cards = {homeView};
    public CustomerHomeController(CustomerHomeView view) {
        this.view = view;
        view.setVisible(true);
        addEvent();
        User session = SessionManager.getSession().getUser();
        if (session != null) {
            view.getLbName().setText(session.getName());
        }
        view.setCards(cards);
        view.setPanel(homeView);
    }

    private void addEvent() {
        view.getBtnLogout().addActionListener(evt -> {
            int confirm = JOptionPane.showConfirmDialog(view, "Bạn thực sự muốn đăng xuất?");
            if (confirm != JOptionPane.YES_OPTION) {
                return;
            }
            try {
                SessionManager.update();// Đăng xuất
            } catch (SQLException ex) {
                view.showError(ex);
            }
            view.dispose();
            new LoginController(new LoginView());
        });
    }
//    ------------------------------------------------------------------------------
    public CustomerHomeView getView() {
        return view;
    }

    public void setView(CustomerHomeView view) {
        this.view = view;
    }
}
