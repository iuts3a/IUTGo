package IUTGo.Models.Users;

import IUTGo.Models.Coordinates;
import IUTGo.Models.PointInterest;
import IUTGo.Models.PointInterestType;
import IUTGo.Models.RoadTrip;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;

public class User implements Serializable
{
    private String      lastName;
    private String      firstName;
    private String      userName;
    private String      email;
    private String      password;
    private Coordinates adresse;
    
    private ArrayList<RoadTrip> favoriteRoadTrips;
    
    public User (String lastName, String firstName, String userName, String email, String password, Coordinates coordinates)
    {
        setLastName(lastName);
        setFirstName(firstName);
        setUserName(userName);
        setEmail(email);
        setPassword(password);
        setAddress(coordinates);
        favoriteRoadTrips = new ArrayList<RoadTrip>();
    }
    
    @SuppressWarnings("unchecked")
    public static HashMap<String, User> read () throws IOException, ClassNotFoundException
    {
        File file = new File("./Sauv/User.ser");
    
        ObjectInputStream ooi;
        
        try
        {
            ooi = new ObjectInputStream(new FileInputStream(file));
        }
        catch (IOException e)
        {
            ooi = new ObjectInputStream(new FileInputStream(file));
        }
    
        return (HashMap<String, User>) ooi.readObject();
    }
    
    //region Getters and Setters
    public String getLastName ()
    {
        return lastName;
    }
    
    public void setLastName (String lastName)
    {
        this.lastName = lastName;
    }
    
    public String getFirstName ()
    {
        return firstName;
    }
    
    private void setFirstName (String firstName)
    {
        this.firstName = firstName;
    }
    
    public String getUserName ()
    {
        return userName;
    }
    
    private void setUserName (String userName)
    {
        this.userName = userName;
    }
    
    public Coordinates getAddress ()
    {
        return adresse;
    }
    
    private void setAddress (Coordinates adresse)
    {
        this.adresse = adresse;
    }
    
    public String getPassword ()
    {
        return password;
    }
    
    private void setPassword (String password)
    {
        this.password = password;
    }
    
    public String getEmail ()
    {
        return email;
    }
    
    private void setEmail (String email)
    {
        this.email = email;
    }
    
    public ArrayList<RoadTrip> getFavoriteRoadTrips ()
    {
        return favoriteRoadTrips;
    }
    
    //endregion
    
    public boolean suggestPointInteret (String namePointInterest, PointInterestType type, float price, Coordinates coordinates)
    {
        PointInterest newPointInterest = new PointInterest(namePointInterest, type, price, coordinates, this);
        
        try
        {
            newPointInterest.save();
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
    
    public boolean suggestPointInteret (String namePointInterest, String comment, PointInterestType type, float price, Coordinates coordinates)
    {
        PointInterest newPointInterest = new PointInterest(namePointInterest, comment, type, price, coordinates, this);
        
        try
        {
            newPointInterest.save();
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
    
    public boolean commentPointInteret (String namePointInterest, String comment, Integer grade)
    {
        try
        {
            PointInterest.read().get(namePointInterest).addComment(comment, grade);
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
    
    public boolean createRoadTrip (String roadTripName)
    {
        RoadTrip newRoadTrip = new RoadTrip(roadTripName, this);
        
        try
        {
            newRoadTrip.save();
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
    
    public boolean deleteRoadTrip (String roadTripName)
    {
        try
        {
            RoadTrip.read().remove(roadTripName);
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
    
    public boolean addPointInteretToRoadTrip (String roadTripName, String name, PointInterestType type, float price, Coordinates coordinates)
    {
        PointInterest pointInterest = new PointInterest(name, type, price, coordinates, this);
        try
        {
            pointInterest.save();
            RoadTrip.read().get(roadTripName).addPointInterest(pointInterest);
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
    
    public boolean addPointInteretToRoadTrip (String roadTripName, String name, String description, PointInterestType type, float price, Coordinates coordinates)
    {
        PointInterest pointInterest = new PointInterest(name, description, type, price, coordinates, this);
        try
        {
            if(!(PointInterest.read().containsKey(pointInterest.getName()))) return false;
            if(!(RoadTrip.read().containsKey(roadTripName))) return false;
            if(RoadTrip.read().get(roadTripName).getPointInterests().containsKey(pointInterest.getName())) return false;
            pointInterest.save();
            RoadTrip roadTrip= new RoadTrip(RoadTrip.read().get(roadTripName).getName(),this);
            roadTrip.addPointInterest(pointInterest);
            roadTrip.save();
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
    
    public boolean deletePointInteretFromRoadTrip (String roadTripName, String pointInteretName)
    {
        try
        {
            RoadTrip roadTrip= new RoadTrip(RoadTrip.read().get(roadTripName).getName(),this);
            RoadTrip.read().get(roadTripName).deletePointInterest(pointInteretName);
            roadTrip.save();
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
    
    public boolean addRoadTripToFavorite (String name)
    {
        try
        {
            if(RoadTrip.read().containsKey(name)) favoriteRoadTrips.add(RoadTrip.read().get(name));
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


    
    public float getRoadTripPrice (String roadTripName)
    {
        try
        {
            return RoadTrip.read().get(roadTripName).getPrice();
        }
        //region catch
        catch (IOException e)
        {
            e.printStackTrace();
            return -1;
        }
        catch (ClassNotFoundException e)
        {
            e.printStackTrace();
            return -1;
        }
        //endregion
    }
    
    public ArrayList<RoadTrip> getRoadTripByScore (float score)
    {
        ArrayList<RoadTrip> listResult = new ArrayList<RoadTrip>();
        
        try
        {
            for (RoadTrip roadTrip : RoadTrip.read().values())
            {
                if(roadTrip.getGrade() >= score)
                {
                    listResult.add(roadTrip);
                }
            }
            return listResult;
        }
        //region catch
        catch (IOException e)
        {
            e.printStackTrace();
            return listResult;
        }
        catch (ClassNotFoundException e)
        {
            e.printStackTrace();
            return listResult;
        }
        //endregion
    }
    
    public static void createSaveFile () throws IOException
    {
        File file = new File("./Sauv/User.ser");
        HashMap<String, User> hashMap = new HashMap<String, User>();
        
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file));
        oos.writeObject(hashMap);
    }
    
    @SuppressWarnings("unchecked")
    public void save () throws IOException, ClassNotFoundException
    {
        File file = new File("./Sauv/User.ser");
        
        ObjectInputStream ooi = new ObjectInputStream(new FileInputStream(file));
        
        HashMap<String, User> hashMap;
        
        hashMap = (HashMap<String, User>) ooi.readObject();
        hashMap.put(this.getEmail(), this);
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file));
        
        oos.writeObject(hashMap);
    }
    
}