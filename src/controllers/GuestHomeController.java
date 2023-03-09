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
import views.LoginView;
import views.guest.GuestHomeView;
import views.guest.HomeView;
import views.user.UserHomeView;

public class GuestHomeController {

    private GuestHomeView view;
    HomeView homeView = new HomeView();
    JPanel[] cards = {homeView};
    public GuestHomeController(GuestHomeView view) {
        this.view = view;
        view.setVisible(true);
        addEvent();
        view.getLbName().setText("Guest");
        view.setCards(cards);
        view.setPanel(homeView);
    }

    private void addEvent() {
        view.getBtnLogin().addActionListener(evt -> {
            view.dispose();
            new LoginController(new LoginView());
        });
    }
//    ------------------------------------------------------------------------------
    public GuestHomeView getView() {
        return view;
    }

    public void setView(GuestHomeView view) {
        this.view = view;
    }
}
