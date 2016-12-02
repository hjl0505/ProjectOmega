/*
   For step-by-step instructions on connecting your Android application to this backend module,
   see "App Engine Java Endpoints Module" template documentation at
   https://github.com/GoogleCloudPlatform/gradle-appengine-templates/tree/master/HelloEndpoints
*/

package com.example.admin.myapplication.backend;

import com.google.api.server.spi.config.Api;
import com.google.api.server.spi.config.ApiMethod;
import com.google.api.server.spi.config.ApiNamespace;

import javax.inject.Named;

import com.google.api.server.spi.config.Api;
import com.google.api.server.spi.config.ApiMethod;
import com.google.api.server.spi.config.ApiNamespace;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

import javax.inject.Named;
import javax.servlet.ServletException;

// An endpoint class we are exposing
@Api(
        name = "myApi",
        version = "v1",
        namespace = @ApiNamespace(
                ownerDomain = "backend.myapplication.admin.example.com",
                ownerName = "backend.myapplication.admin.example.com",
                packagePath = ""
        )
)
public class MyEndpoint {
    @ApiMethod(name = "getExerciseList")
    public ExerciseListData getExerciseList (@Named("bpList") List<String> bpList) throws ServletException {
        ExerciseListData exerciseList = new ExerciseListData();

        final String selectSql = listQueryHelper(bpList);

        String url;
        if (System.getProperty("com.google.appengine.runtime.version").startsWith("Google App Engine/")) {
            url = System.getProperty("ae-cloudsql.cloudsql-database-url");
            try {
                Class.forName("com.mysql.jdbc.GoogleDriver");
            } catch (ClassNotFoundException e) {
                throw new ServletException("Error loading Google JDBC Driver", e);
            }
        } else {
            // Set the url with the local MySQL database connection url when running locally
            url = System.getProperty("ae-cloudsql.local-database-url");
        }

        try {
            Connection conn = DriverManager.getConnection(url);
            ResultSet rs = conn.prepareStatement(selectSql).executeQuery();
            while (rs.next()) {
                String exerciseName = rs.getString("ExerciseName");
                exerciseList.setData(exerciseName);
            }

        } catch (SQLException e) {
            throw new ServletException("SQL error", e);
        }
        return exerciseList;
    }

    private String listQueryHelper(List<String> bpList) {
        String query = "SELECT DISTINCT ExerciseName FROM Exercise INNER JOIN BodyPart ON Exercise.BodyPartID = BodyPart.BodyPartID ";
        query += "WHERE BodyPart.name = '" + bpList.get(0) + "'";

        // add more bodyparts to the query
        for (int i = 1; i < bpList.size(); i++) {
            query += " OR BodyPart.name = '" + bpList.get(i)+ "'";
        }

        System.out.println(query);

        return query;
    }

    @ApiMethod(name = "getExerciseDetail")
    public ExerciseDetailData getExerciseDetail (@Named("exerciseName") String exerciseName) throws ServletException {
        ExerciseDetailData detail = new ExerciseDetailData();

        final String selectSql = "SELECT  Ex.ExerciseName, Ex.Difficulty, Ex.Warning, Ex.Link, Ex.Description, Ex.Direction, Equipment.EquipmentName, bodypart.name AS BodyPart, injury.name FROM Exercise Ex " +
                "JOIN Equipment ON Equipment.EquipmentID = Ex.EquipmentID " +
                "JOIN BodyPart bodypart ON bodypart.BodyPartID = Ex.BodyPartID " +
                "LEFT JOIN BodyPart injury ON injury.BodyPartID = Ex.InjuryID " +
                "WHERE Ex.ExerciseName = '" + exerciseName + "'";

        String url;
        if (System.getProperty("com.google.appengine.runtime.version").startsWith("Google App Engine/")) {
            url = System.getProperty("ae-cloudsql.cloudsql-database-url");
            try {
                Class.forName("com.mysql.jdbc.GoogleDriver");
            } catch (ClassNotFoundException e) {
                throw new ServletException("Error loading Google JDBC Driver", e);
            }
        } else {
            // Set the url with the local MySQL database connection url when running locally
            url = System.getProperty("ae-cloudsql.local-database-url");
        }

        try {
            Connection conn = DriverManager.getConnection(url);
            ResultSet rs = conn.prepareStatement(selectSql).executeQuery();
            while (rs.next()) {
                String exName = rs.getString("ExerciseName");
                int difficulty = rs.getInt("Difficulty");
                String exWarning = rs.getString("Warning");
                String exLink = rs.getString("Link");
                String description = rs.getString("Description");
                String direction = rs.getString("Direction");
                String equipName = rs.getString("EquipmentName");
                String bodyPart = rs.getString("BodyPart");
                String injury = rs.getString("name");


                detail.setData(exName, difficulty, exWarning, exLink, description, direction, equipName, bodyPart, injury);
            }

        } catch (SQLException e) {
            throw new ServletException("SQL error", e);
        }
        return detail;
    }
}

