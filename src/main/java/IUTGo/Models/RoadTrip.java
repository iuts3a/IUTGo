package IUTGo.Models;

import IUTGo.Models.Users.User;

import java.io.*;
import java.util.HashMap;

public class RoadTrip implements Serializable
{
    private String                         name;
    private HashMap<String, PointInterest> pointInterests;
    private HashMap<String, User>          participants;
    
    public RoadTrip (String name, User createur)
    {
        this.pointInterests = new HashMap<String, PointInterest>();
        this.participants = new HashMap<String, User>();
        this.participants.put(createur.getEmail(), createur);
        this.name = name;
    }
    
    @SuppressWarnings("unchecked")
    public static HashMap<String, RoadTrip> read () throws IOException, ClassNotFoundException
    {
        File file = new File("./Sauv/RoadTrip.ser");
        
        ObjectInputStream ooi = new ObjectInputStream(new FileInputStream(file));
        
        HashMap<String, RoadTrip> hashMap;
        hashMap = (HashMap<String, RoadTrip>) ooi.readObject();
        return hashMap;
    }
    
    //region Getters and Setters
    public HashMap<String, PointInterest> getPointInterests ()
    {
        return pointInterests;
    }
    
    public String getName ()
    {
        return name;
    }
    
    public float getPrice ()
    {
        float totalPrice = 0;
        
        for (PointInterest pointInterest : pointInterests.values())
        {
            totalPrice += pointInterest.getPrice();
        }
        
        return totalPrice;
    }
    
    public float getGrade ()
    {
        float totalGrade = 0;
        
        for (PointInterest pointInterest : pointInterests.values())
        {
            totalGrade += pointInterest.getGrade();
        }
        
        return totalGrade / pointInterests.size();
    }
    
    public HashMap<String, User> getParticipants ()
    {
        return participants;
    }
    //endregion
    
    public boolean addPointInterest (PointInterest pointInterest)
    {
        if(pointInterests.containsKey(pointInterest.getName())) return false;
        if(pointInterests.containsValue(pointInterest)) return false;
        
        pointInterests.put(pointInterest.getName(), pointInterest);
        return true;
    }
    
    public boolean deletePointInterest (String name)
    {
        if(!pointInterests.containsKey(name)) return false;
        
        pointInterests.remove(name);
        return true;
    }
    
    public boolean addParticipants (User participant)
    {
        if(participants.containsValue(participant)) return false;
        
        participants.put(participant.getEmail(), participant);
        return true;
    }
    
    public boolean deleteParticipants (String name)
    {
        if(!participants.containsKey(name)) return false;
    
        participants.remove(name);
        return true;
    }
    
    @Override
    public String toString ()
    {
        return "RoadTrip{" + "name='" + name + '\'' + ", pointInterests=" + pointInterests.toString() + ", prix Itinéraire=" + getPrice() + '}';
    }
    
    public void createSaveFile () throws IOException
    {
        File file = new File("./Sauv/RoadTrip.ser");
        
        HashMap<String, RoadTrip> hashMap = new HashMap<String, RoadTrip>();
        
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file));
        oos.writeObject(hashMap);
    }
    
    @SuppressWarnings("unchecked")
    public void save () throws IOException, ClassNotFoundException
    {
        File file = new File("./Sauv/RoadTrip.ser");
        
        ObjectInputStream ooi = new ObjectInputStream(new FileInputStream(file));
        
        HashMap<String, RoadTrip> hashMap;
        hashMap = (HashMap<String, RoadTrip>) ooi.readObject();
        hashMap.put(this.getName(), this);
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file));
        oos.writeObject(hashMap);
        
    }
    
    
}
