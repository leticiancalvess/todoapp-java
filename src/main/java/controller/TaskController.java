/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import model.Task;
import util.ConnectionFactory;

/**
 *
 * @author User
 */
public class TaskController {
    
    public void save(Task task){
        String sql = "INSERT INTO tasks (idProject"
                +"name,"
                +"description,"
                +"completed,"
                +"notes,"
                +"deadline,"
                +"createdAt,"
                +"updatedAt) VALUES(?, ?, ?, ?, ?, ?, ?, ?)";
        Connection connection = null;
        PreparedStatement statement = null;
        
        try {
            connection = ConnectionFactory.getConnection();
            statement = connection.prepareStatement(sql);
            statement.setInt(1, task.getIdProject());
            statement.setString(2, task.getName());
            statement.setString(3, task.getDescription());
            statement.setBoolean(4, task.isIsCompleted());
            statement.setString(5, task.getNotes());
            statement.setDate(6, new Date(task.getCreatedAt().getTime()));
            statement.setDate(7, new Date(task.getCreatedAt().getTime()));
            statement.setDate(8, new Date(task.getUpdatedAt().getTime()));
            
            statement.execute();     
            
        } catch (Exception ex) {
            throw new RuntimeException("Erro ao salvar a tarefa" + ex.getMessage(), ex);
        } finally {
            ConnectionFactory.closeConnection(connection, statement);
             
             }
               
    }
    
    public void update(Task task){
        
        String sql = "UPDATE tasks SET" 
                + "idProject = ?," 
                + "name = ?,"
                +"description = ?,"
                + "notes = ?,"
                + "completed = ?,"
                + "deadline = ?,"
                + "createdAT = ?,"
                + "updatedAt = ?,"
                + "WHERE id = ?";
        
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            connection = ConnectionFactory.getConnection();
            statement = connection.prepareStatement(sql);
            
            statement.setInt(1, task.getIdProject());
            statement.setString(2, task.getName());
            statement.setString(3, task.getDescription());
            statement.setString(4, task.getNotes());
            statement.setBoolean(5, task.isIsCompleted());
            statement.setDate(6, new Date(task.getDeadline().getTime()));
             statement.setDate(7, new Date(task.getCreatedAt().getTime()));
              statement.setDate(8, new Date(task.getUpdatedAt().getTime()));
              
              statement.execute();
            
            
            
        } catch (Exception ex) { 
            throw new RuntimeException("Erro ao salvar a tarefa" + ex.getMessage(), ex);
        } 
        
    }
     public void removeByid(int taskId) throws SQLException{
         String sql = "DELETE FROM tasks WHERE ID = ?";
         Connection connection = null;
         PreparedStatement statement = null; 
         try {
             connection = ConnectionFactory.getConnection();
             statement = connection.prepareStatement(sql); //objeto que ajuda a preparar o comando sql q vai ser executado no BD
             
            statement = setInt(1, taskId); //seta um valor, mudando o primeiro ? para o valor do taskId
            statement.execute();
            
         } catch (Exception ex) {
            throw new RuntimeException("Erro ao salvar a tarefa" + ex.getMessage(), ex);
             
         } finally {
             ConnectionFactory.closeConnection(connection, statement);
            
         }
        
    }
     public List<Task> getAll(int idProject) { //pega todas as tarefas do projeto X
         return null;
     
     }
    
}
