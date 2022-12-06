/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package com.mycompany.todoapp;

import java.sql.Connection;
import util.ConnectionFactory;

/**
 *
 * @author User
 */
public class ToDoApp {

    public static void main(String[] args) {
     Connection c = ConnectionFactory.getConnection(); 
     
     ConnectionFactory.closeConnection(c); 
    }
}
