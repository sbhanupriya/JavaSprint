package jdbc;
import java.sql.*;

public class DemoJdbc {
    public static void main(String[] args) throws Exception {
        /*
            import the pacakge - java.sql
            load and register drivers
            create connection
            create statement
            execute statement
            process the results
            close
         */

        String url = "jdbc:postgresql://localhost:5432/demo";
        String uname = "postgres";
        String password = "postgres";
        String query = "select * from student;";

        //Class.forName("org.postgresql.Driver");
        Connection connection = DriverManager.getConnection(url,uname,password);
        System.out.println("Connection Established");
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(query);
        while(resultSet.next()){
            System.out.println(resultSet.getInt(1) + ":" + resultSet.getString(2)+ ":" + resultSet.getInt(3));
        }

        //CRUD - insert query - execute command returns true only for query which return resultSet
        query = "INSERT into student(name,marks) values('John', 48);";
        boolean status = statement.execute(query);
        System.out.println("Record Inserted " + status);

        //CRUD - update query
        query = "UPDATE student set marks = 50 where name = 'John';";
        status = statement.execute(query);
        System.out.println("Record Updated " + status);


        //CRUD - delete query
        query = "delete from student where name = 'John';";
        status = statement.execute(query);
        System.out.println("Record Deleted " + status);


        //Prepared Statement
        query = "insert into student(name, marks) values(?,?);";
        String name = "Jasmine";
        int marks = 52;
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setInt(2,marks);
        preparedStatement.setString(1,name);
        status = preparedStatement.execute();
        System.out.println("PreparedStatement Added " + status);

        connection.close();
        System.out.println("Connection Closed");
    }
}
