package action;
import java.sql.Date;
import java.util.*;

import vo.Lab2;
import model.*;
import com.opensymphony.xwork2.ActionContext;
public class Lab2Action {
    private int AuthorID;
    private String Name;
    private int Age;
    private String Country;
    private int ISBN;
    private String Title;
    private String Publisher;
    private Date PublishDate;
    private int Price;
    private ArrayList<Lab2> list;
    
    public ArrayList<Lab2> getlist()
    {
    	return list;
    }
    
    public void setlist()
    {
    	Lab2Model Model = new Lab2Model();
    	ArrayList<Lab2> list = Model.getList();
    	this.list = list;
    }
    
    public int getAuthorID() {
        return AuthorID;
    }
    public void setAuthorID(int AuthorID) {
        this.AuthorID = AuthorID;
    }
    public String getName() {
        return Name;
    }
    public void setName(String Name) {
        this.Name = Name;
    }
    public int getAge() {
        return Age;
    }
    public void setAge(int Age) {
        this.Age = Age;
    }
    public String getCountry() {
        return Country;
    }
    public void setCountry(String Country) {
        this.Country = Country;
    }     
    public int getISBN()
    {
    	return ISBN;
    }        
    public void setISBN(int ISBN)
    {
    	this.ISBN = ISBN;
    }
    public String getTitle()
    {
    	return Title;
    }
    public void setTitle(String Title)
    {
    	this.Title = Title;
    }
    public String getPublisher()
    {
    	return Publisher;
    }
    public void setPublisher(String Publisher)
    {
    	this.Publisher = Publisher;
    }
    public Date getPublishDate()
    {
    	return PublishDate;
    }
    public void setPublishDate(Date PublishDate)
    {
    	this.PublishDate = PublishDate;
    }
    public int getPrice()
    {
    	return Price;
    }
    public void setPrice(int Price)
    {
    	this.Price = Price;
    }

    public String add()
    {
        Lab2Model model=new Lab2Model();
        model.save(ISBN, Title, AuthorID, Publisher, PublishDate, Price, Name, Age, Country);
        return "add";
    }
    public String select()
    {
        Lab2Model Model = new Lab2Model();
        ArrayList<Lab2> list = Model.getList();
        
        ActionContext.getContext().put("list", list);
        return "list";
    }
    public String delete()
    {
        Lab2Model model=new Lab2Model();
        model.delete(ISBN);
        return this.select();
    }
    //这个update只是取值
    public String update()
    {
        Lab2Model model = new Lab2Model();
        Lab2 Lab2Table = model.get_one(ISBN);
        this.Age = Lab2Table.getAge();
        this.AuthorID = Lab2Table.getAuthorID();
        this.Country = Lab2Table.getCountry();
        this.ISBN = Lab2Table.getISBN();
        this.Name = Lab2Table.getName();
        this.Price = Lab2Table.getPrice();
        this.PublishDate = Lab2Table.getPublishDate();
        this.Publisher = Lab2Table.getPublisher();
        this.Title = Lab2Table.getTitle();
        
        return "update";
    }
    public String updateOne()
    {
        Lab2Model model = new Lab2Model();
        model.update(ISBN, Title, AuthorID, Publisher, PublishDate, Price, Name, Age, Country);
        return this.select();
    }
}