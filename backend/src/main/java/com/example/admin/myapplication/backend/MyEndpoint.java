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

import javax.inject.Named;
import javax.servlet.ServletException;

/**
 * An endpoint class we are exposing
 */
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

    /**
     * A simple endpoint method that takes a name and says Hi back
     */

    @ApiMethod(name = "sayHi")
    public MyBean sayHi(@Named("name") String name) throws ServletException {
        MyBean response = new MyBean();
        //response.setData("Hi, " + name);

        final String selectSql = "SELECT * FROM exercise";

        String url;
        if (System
                .getProperty("com.google.appengine.runtime.version").startsWith("Google App Engine/")) {
            // Check the System properties to determine if we are running on appengine or not
            // Google App Engine sets a few system properties that will reliably be present on a remote
            // instance.
            url = System.getProperty("ae-cloudsql.cloudsql-database-url");
            try {
                // Load the class that provides the new "jdbc:google:mysql://" prefix.
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
                String exerciseName = rs.getString("exerciseName");
                String bodypartName = rs.getString("bodypartName");
                int exerciseID = rs.getInt("exerciseID");

                response.setData(exerciseName,bodypartName,exerciseID);
            }

        } catch (SQLException e) {
            throw new ServletException("SQL error", e);
        }
        return response;
    }

  /*  @ApiMethod(name = "sayHi")
    public MyBean sayHi(@Named("name") String name) {
        MyBean response = new MyBean();
        response.setData("Hi, " + name);

        return response;
    }*/
}

