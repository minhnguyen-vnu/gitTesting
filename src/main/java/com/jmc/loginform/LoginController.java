package com.jmc.loginform;


import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ResourceBundle;

import java.sql.ResultSet;

public class LoginController implements Initializable {
    public ChoiceBox acc_selector;
    public Label payee_address_lbl;
    public TextField payee_address_fld;
    public TextField password_fld;
    public Button login_btn;
    public Label error_lbl;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        login_btn.setOnAction(e -> login());
    }

    public void login(){
        PreparedStatement preparedStatement = null;
        ResultSet resultset = null;
        Connection con = DBUtlis.getConnection();
        try {
            preparedStatement = con.prepareStatement("SELECT * FROM users WHERE username = ? AND password = ?");
            preparedStatement.setString(1, payee_address_fld.getText());
            preparedStatement.setString(2, password_fld.getText());
            resultset = preparedStatement.executeQuery();
            if(resultset.next()){
                error_lbl.setText("Login Success");
                error_lbl.setStyle("-fx-text-fill: green;");
            }
            else{
                error_lbl.setText("Login Failed");
                error_lbl.setStyle("-fx-text-fill: red;");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


    }
}
