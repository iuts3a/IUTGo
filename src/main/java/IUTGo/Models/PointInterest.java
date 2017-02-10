package IUTGo.Models;

import IUTGo.Models.Users.User;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;

public class PointInterest implements Serializable
{
    
    private String            name;
    private String            description;
    private PointInterestType type;
    private float             price;
    private boolean           validated;
    private Coordinates       coordinates;
    private User              creator;
    
    private ArrayList<Comment> comments;
    
    public PointInterest (String name, PointInterestType type, float price, Coordinates coordinates, User creator)
    {
        setName(name);
        setType(type);
        setPrice(price);
        setCoordinates(coordinates);
        setValidated(false);
        setDescription("");
        setComments(new ArrayList<Comment>());
        setCreator(creator);
    }
    
    public PointInterest (String name, String description, PointInterestType type, float price, Coordinates coordinates, User creator)
    {
        setName(name);
        setType(type);
        setPrice(price);
        setCoordinates(coordinates);
        setValidated(false);
        setDescription(description);
        setComments(new ArrayList<Comment>());
        setCreator(creator);
    }
    
    @SuppressWarnings("unchecked")
    public static HashMap<String, PointInterest> read () throws IOException, ClassNotFoundException
    {
        File file = new File("./Sauv/PI.ser");
        
        ObjectInputStream ooi = new ObjectInputStream(new FileInputStream(file));
        
        HashMap<String, PointInterest> hashMap;
        hashMap = (HashMap<String, PointInterest>) ooi.readObject();
        return hashMap;
    }
    
    //region Getters and Setters
    
    public String getName ()
    {
        return name;
    }
    
    private void setName (String name)
    {
        this.name = name;
    }
    
    public String getDescription ()
    {
        return description;
    }
    
    private void setDescription (String description)
    {
        this.description = description;
    }
    
    public PointInterestType getType ()
    {
        return type;
    }
    
    private void setType (PointInterestType type)
    {
        this.type = type;
    }
    
    public float getPrice ()
    {
        return price;
    }
    
    private void setPrice (float price)
    {
        this.price = price;
    }
    
    public boolean isValidated ()
    {
        return validated;
    }
    
    private void setValidated (boolean validated)
    {
        this.validated = validated;
    }
    
    public Coordinates getCoordinates ()
    {
        return coordinates;
    }
    
    private void setCoordinates (Coordinates coordinates)
    {
        this.coordinates = coordinates;
    }
    
    public ArrayList<Comment> getComments ()
    {
        return comments;
    }
    
    private void setComments (ArrayList<Comment> comments)
    {
        this.comments = comments;
    }
    
    public User getCreator ()
    {
        return creator;
    }
    
    private void setCreator (User utilisateur)
    {
        this.creator = utilisateur;
    }
    //endregion
    
    public boolean addComment (String message, Integer grade)
    {
        this.comments.add(new Comment(message, grade));
        return true;
    }
    
    public float getGrade ()
    {
        float grade = 0;
        
        for (Comment comment : comments)
        {
            grade += comment.getGrade();
        }
        
        return grade / comments.size();
    }
    
    @Override
    public String toString ()
    {
        return "PointInterest{" + "name='" + name + '\'' + ", description='" + description + '\'' + ", type='" + getType() + '\'' + ", price=" + price + ", note=" + getGrade() + '}';
    }
    
    public void createSaveFile () throws IOException
    {
        File file = new File("./Sauv/PI.ser");
        
        HashMap<String, PointInterest> hashMap = new HashMap<String, PointInterest>();
        
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file));
        oos.writeObject(hashMap);
        
    }
    
    public void save () throws IOException, ClassNotFoundException
    {
        
        File file = new File("./Sauv/PI.ser");
        
        ObjectInputStream ooi = new ObjectInputStream(new FileInputStream(file));
        
        HashMap<String, PointInterest> hashMap;
        hashMap = (HashMap<String, PointInterest>) ooi.readObject();
        hashMap.put(this.getName(), this);
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file));
        oos.writeObject(hashMap);
        
    }
}
