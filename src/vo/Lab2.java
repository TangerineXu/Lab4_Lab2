package vo;

import java.sql.*;
 
public class Lab2 {
        private int AuthorID;
        private String Name;
        private int Age;
        private String Country;
        private int ISBN;
        private String Title;
        private String Publisher;
        private Date PublishDate;
        private int Price;
        
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
}