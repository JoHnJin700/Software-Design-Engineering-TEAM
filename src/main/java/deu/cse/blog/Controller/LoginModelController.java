/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package deu.cse.blog.Controller;

import deu.cse.blog.Model.LoginModel;

/**
 * 전략 패턴의 구상 클래스
 * @author 강대한
 * @
 * 2023.5.15 "생성" 강대한
 */
public class LoginModelController implements UserModelController{
    private LoginModel loginModel = new LoginModel();
    @Override
    public String action(String id, String pw, String name, boolean gender) {
        String user = loginModel.authenticate(id, pw);
        return user;
    }
}