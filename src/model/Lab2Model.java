//test git Lab2Model.java
package model;
import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import vo.Lab2;
 
import connection.Lab2Connection;
 
public class Lab2Model {
    public ArrayList<Lab2> getList()
    {
        ArrayList<Lab2> list = new ArrayList<Lab2>();
        try
        {
            Lab2Connection connection = new Lab2Connection();
            Connection mycon = connection.getConnection();
            Statement st = mycon.createStatement();
            ResultSet BookSet = st.executeQuery("select * from book");

            while(BookSet.next())
            {
                Lab2 LabTable = new Lab2();              
                LabTable.setISBN(BookSet.getInt("ISBN"));
                LabTable.setPrice(BookSet.getInt("Price"));
                LabTable.setPublishDate(BookSet.getDate("PublishDate"));
                LabTable.setPublisher(BookSet.getString("Publisher"));
                LabTable.setTitle(BookSet.getString("Title"));
//                ResultSet AuthorSet = st.executeQuery("select * from author");
//                while(AuthorSet.next())
//                {
//                	if(LabTable.getAuthorID() == AuthorSet.getInt("AuthorID"))
//                	{
//                        LabTable.setAge(AuthorSet.getInt("Age"));
//                        LabTable.setAuthorID(AuthorSet.getInt("AuthorID"));
//                        LabTable.setCountry(AuthorSet.getString("Country"));
//                        LabTable.setName(AuthorSet.getString("Name"));
//                	}
//                }
                list.add(LabTable);
            }
            
            for (int i = 0; i < list.size(); ++i)
            {
            	ResultSet AuthorSet = st.executeQuery("select * from author");
            	while(AuthorSet.next())
            	{
            		if(list.get(i).getAuthorID() == AuthorSet.getInt("AuthorID"))
            		{
                        list.get(i).setAge(AuthorSet.getInt("Age"));
                        list.get(i).setAuthorID(AuthorSet.getInt("AuthorID"));
                        list.get(i).setCountry(AuthorSet.getString("Country"));
                        list.get(i).setName(AuthorSet.getString("Name"));	
                        break;
            		}
            	}
            }
        }
        catch(Exception e){
        	e.printStackTrace();
        }
        return list;
    }
    public void delete(int ISBN)
    {
            try {
                Lab2Connection connection=new Lab2Connection();
                Connection mycon=connection.getConnection();
                Statement st=mycon.createStatement();
                st.executeUpdate("delete from book where ISBN = '"+ ISBN +"'");
                connection.closeConnection(mycon);
            } catch (Exception e) {
                // TODO: handle exception
            }
    }
    public void save(int ISBN, String Title, int AuthorID, String Publisher, Date PublishDate, int Price, String Name, int Age, String Country)
    {
        try {
            Lab2Connection connection=new Lab2Connection();
            Connection mycon=connection.getConnection();
            Statement st=mycon.createStatement();
            st.executeUpdate("insert into book (ISBN, Title, AuthorID, Publisher, PublishDate, Price) values ('" + ISBN + "','" + Title + "','" + AuthorID + "','" + Publisher + "','" + PublishDate + "','" + Price + "')");
            st.executeUpdate("insert into author (AuthorID, Name, Age, Country) values ('" + AuthorID + "','" + Name + "','" + Age + "','" + Country + "')");
            connection.closeConnection(mycon);
        } catch (Exception e) {
            // TODO: handle exception
        }
    }
    public void update(int ISBN, String Title, int AuthorID, String Publisher, Date PublishDate, int Price, String Name, int Age, String Country)
    {
        try {
            Lab2Connection connection=new Lab2Connection();
            Connection mycon=connection.getConnection();
            Statement st=mycon.createStatement();
            st.executeUpdate("update book set ISBN ='" + ISBN + "', Title = '" + Title + "', AuthorID = '" + AuthorID + "', Publisher = '" + Publisher + "', PublishDate = '" + PublishDate + "', Price = '" + Price + "' where ISBN = " + ISBN);
            st.executeUpdate("update author set AuthorID ='" + AuthorID + "', Name = '" + Name + "', Age = '" + Age + "', Country = '" + Country + "' where AuthorID = " + AuthorID);
            connection.closeConnection(mycon);
        } catch (Exception e) {
            // TODO: handle exception
        }
    }
    public Lab2 get_one(int ISBN_var)
    {
        Lab2 stu=new Lab2();
        try{
        Lab2Connection con=new Lab2Connection();
        java.sql.Connection mycon=con.getConnection();
        Statement st=mycon.createStatement();
         
        ResultSet BookSet = st.executeQuery("select * from book where ISBN = " + ISBN_var);
        if(BookSet.next())
        {
            int ISBN = BookSet.getInt("ISBN");
            String Title = BookSet.getString("Title");
            int AuthorID = BookSet.getInt("AuthorID");
            String Publisher = BookSet.getString("Publisher");
            Date PublishDate = BookSet.getDate("PublishDate");
            int Price = BookSet.getInt("Price");
            ResultSet AuthorSet = st.executeQuery("select * from book where AuthorID = " + AuthorID);
            String Name = AuthorSet.getString("Name");
            int Age = AuthorSet.getInt("Age");
            String Country = AuthorSet.getString("Country");
            
            stu.setAge(Age);
            stu.setAuthorID(AuthorID);
            stu.setCountry(Country);
            stu.setISBN(ISBN);
            stu.setName(Name);
            stu.setPrice(Price);
            stu.setPublishDate(PublishDate);
            stu.setPublisher(Publisher);
            stu.setTitle(Title);
        }
        con.closeConnection(mycon);
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        return stu;
    }
}