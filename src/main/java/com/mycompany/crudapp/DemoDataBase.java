/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.crudapp;

/**
 *
 * @author Ibrahim.Medhat
 */
import java.sql.SQLException;
import java.util.Locale;
import java.util.Scanner;

public class DemoDataBase {

    public void CrudOperations() {

        String cotinuedata = "";
        System.out.println("Wellcome");
        String connectionUrl
                = "jbdc:sqlserver://DESKTOP-JHQBC5Q:1433;"
                + "database=studentDB;"
                + "user=sa;"
                + "password=password@1;";

        do {
            System.out.println("Select option from below menu:");
            System.out.println("Press 1 to select data\npress 2 to insert data\npress 3 to delete data");
            Scanner sc = new Scanner(System.in);
            var DataInput = sc.nextLine();

            switch (DataInput) {
                case "1":
                    ResultSet resultset = null;
                    try ((Connection connection =   DriverManger.getConnection(connectionUrl);
                            Statement statemanet = connection.CreatStatement();) {
                        String selectSql = "SELECT* from Student_Record";
                        resultset = statemanet.excuateQuery(selectSql);

                        while (resultSet.next()) {
                            var str = String.format("%s %s %s %s %s %s %s %s", resultset.getString(1), resultset.getString(2),
                                    resultset.getString(3), resultset.getString(4), resultset.getString(5), resultset.getString(6), resultset.getString(7),
                                    resultset.getString(8));
                            System.out.println(str);
                        }
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                    break;
                case "2":
                    try (Connection connection = DriverManger.getConnection(connectionUrl)) {
                    System.out.println("Enter Frist Name:");
                    var fname = sc.nextLine();
                    System.out.println(fname);
                    System.out.println("Enter Last Name:");
                    var lname = sc.nextLine();
                    System.out.println(lname);
                    System.out.println("Enter E-Mail ID");
                    var email = sc.nextLine();
                    System.out.println(email);
                    System.out.println("Enter Gender:");
                    var gen = sc.nextLine();
                    System.out.println(gen);
                    System.out.println("Enter Date Of Birth:");
                    var dob = sc.nextLine();
                    System.out.println(dob);
                    System.out.println("Enter Adhar No:");
                    var adharno = sc.nextLine();
                    System.out.println(adharno);
                    System.out.println("Enter Driving Licence Number:");
                    var driving = sc.nextLine();
                    System.out.println(driving);

                    PreparedStatement stmt = connection.prepaerdStatment("insert into Student_Record" + "(first_name,last_name,email,gender,date_of_birth,adhar_no,driving)" + "(?,?,?,?,?,?,?)");
                    stmt.setString(1, fname);
                    stmt.setString(2, lname);
                    stmt.setString(3, email);
                    stmt.setString(4, gen);
                    stmt.setString(5, dob);
                    stmt.setString(6, adharno);
                    stmt.setString(7, driving);
                    stmt.excuteUpdate();

                    System.out.println("Date Entered Successfully");

                } catch (SQLException e) {
                    e.printStackTrace();
                }
                break;
                case "3":
                    try (Connection connection = DriverManger.getConnection(connectionUrl); Statement stmt = connection.creatStatement();) {
                    System.out.println("Enter an ID you want to delet");
                    var ID = sc.nextLine();
                    String Delquery = "delet from Student_Record where student_id=" + ID;
                    stmt.excuateUpdate(Delquery);
                    System.out.println("Data Deleted Successfully");
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                break;
                default:
                    System.out.println("You have selected wrong input!!!!");
                    break;
            }
            System.out.println("Enter y to continue : else press any other key to exit the program");
            continuedata = sc.nextLine();
            if (cotinuedata.equals("y")) {
                System.out.println("You Have Selected To Continue");
            }
        } while (continuedata.equals("y"));
        System.out.println("You Have Exited the Program");
    }
}
