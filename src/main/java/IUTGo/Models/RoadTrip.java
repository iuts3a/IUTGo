package IUTGo.Models;

import IUTGo.Models.Users.User;

import java.io.*;
import java.util.HashMap;

public class RoadTrip implements Serializable
{
    private String name;
    
    private HashMap<String, PointInterest> pointInterests;
    private HashMap<String, User>          participants;
    
    public RoadTrip (String name, User createur)
    {
        this.pointInterests = new HashMap<String, PointInterest>();
        this.participants = new HashMap<String, User>();
        this.participants.put(createur.getEmail(), createur);
        this.name = name;
    }
    
    public RoadTrip (String name, String pointInterestName, User createur)
    {
        try
        {
            PointInterest PI = PointInterest.read().get(pointInterestName);
            
            this.pointInterests = new HashMap<String, PointInterest>();
            this.pointInterests.put(PI.getName(), PI);
            
            this.participants = new HashMap<String, User>();
            this.participants.put(createur.getUserName(), createur);
            
            this.name = name;
        }
        //region catch
        catch (IOException e)
        {
            e.printStackTrace();
        }
        catch (ClassNotFoundException e)
        {
            e.printStackTrace();
        }
        //endregion
        
    }
    
    @SuppressWarnings("unchecked")
    public static HashMap<String, RoadTrip> read () throws IOException, ClassNotFoundException
    {
        File file = new File("./Sauv/RoadTrip.ser");
        
        ObjectInputStream ooi;
        try
        {
            ooi = new ObjectInputStream(new FileInputStream(file));
        }
        catch (IOException e)
        {
            RoadTrip.createSaveFile();
            ooi = new ObjectInputStream(new FileInputStream(file));
        }
        
        return (HashMap<String, RoadTrip>) ooi.readObject();
    }
    
    public static void createSaveFile () throws IOException
    {
        File file = new File("./Sauv/RoadTrip.ser");
        
        HashMap<String, RoadTrip> hashMap = new HashMap<String, RoadTrip>();
        
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file));
        oos.writeObject(hashMap);
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
    
    public HashMap<String, User> getParticipants ()
    {
        return participants;
    }
    
    public float getGrade ()
    {
        float totalGrade = 0;
        
        for (PointInterest pointInterest : pointInterests.values())
        {
            totalGrade += pointInterest.getGrade();
        }
        
        return pointInterests.size() > 0 ? totalGrade / pointInterests.size() : totalGrade;
    }
    //endregion
    
    public boolean addPointInterest (PointInterest pointInterest)
    {
        if(pointInterests.containsKey(pointInterest.getName())) return false;
        if(pointInterests.containsValue(pointInterest)) return false;
        
        pointInterests.put(pointInterest.getName(), pointInterest);
        try
        {
            this.save();
            return true;
        }
        catch (IOException e)
        {
            e.printStackTrace();
            return false;
        }
        catch (ClassNotFoundException e)
        {
            e.printStackTrace();
            return false;
        }
    }
    
    public boolean deletePointInterest (String name)
    {
        if(!pointInterests.containsKey(name)) return false;
        
        pointInterests.remove(name);
        try
        {
            this.save();
            return true;
        }
        catch (IOException e)
        {
            e.printStackTrace();
            return false;
        }
        catch (ClassNotFoundException e)
        {
            e.printStackTrace();
            return false;
        }
    }
    
    public boolean addParticipants (User participant)
    {
        if(participants.containsValue(participant)) return false;
    
        participants.put(participant.getUserName(), participant);
        try
        {
            this.save();
            return true;
        }
        //region catch
        catch (IOException e)
        {
            e.printStackTrace();
            return false;
        }
        catch (ClassNotFoundException e)
        {
            e.printStackTrace();
            return false;
        }
        //endregion
    }
    
    public boolean deleteParticipants (String name)
    {
        try
        {
            if(!participants.containsKey(name)) return false;
        
            participants.remove(name);
            
            this.save();
            return true;
        }
        //region catch
        catch (IOException e)
        {
            e.printStackTrace();
            return false;
        }
        catch (ClassNotFoundException e)
        {
            e.printStackTrace();
            return false;
        }
        //endregion
    }
    
    @SuppressWarnings("unchecked")
    public void save () throws IOException, ClassNotFoundException
    {
        File file = new File("./Sauv/RoadTrip.ser");
        
        ObjectInputStream ooi = new ObjectInputStream(new FileInputStream(file));
        
        HashMap<String, RoadTrip> hashMap;
        hashMap = (HashMap<String, RoadTrip>) ooi.readObject();
        
        if(hashMap.containsKey(this.getName()))
        {
            hashMap.remove(this.getName());
        }
        hashMap.put(this.getName(), this);
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file));
        oos.writeObject(hashMap);
    }
    
    public void delete () throws IOException, ClassNotFoundException
    {
        File file = new File("./Sauv/RoadTrip.ser");
        
        ObjectInputStream ooi = new ObjectInputStream(new FileInputStream(file));
        
        HashMap<String, RoadTrip> hashMap;
        hashMap = (HashMap<String, RoadTrip>) ooi.readObject();
        hashMap.remove(this.getName());
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file));
        oos.writeObject(hashMap);
    }
    
    @Override
    public String toString ()
    {
        String pointInterestToString = "";
        String participantsToString = "";
        
        for (PointInterest p : getPointInterests().values())
        {
            pointInterestToString += "\n\t\t" + p;
        }
        
        for (User u : getParticipants().values())
        {
            participantsToString += "\n\t\t" + u;
        }
        
        return getName() + " :\tprice : " + getPrice() + "€\tgrade : " + getGrade() + "/5\n\tpointInterests : " + pointInterestToString + "\n\tparticipants : " + participantsToString;
    }
}
