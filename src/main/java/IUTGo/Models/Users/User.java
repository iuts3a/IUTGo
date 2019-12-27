package IUTGo.Models.Users;

import IUTGo.Models.Coordinates;
import IUTGo.Models.PointInterest;
import IUTGo.Models.PointInterestType;
import IUTGo.Models.RoadTrip;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;

public class User implements Serializable {
    private String lastName;
    private String firstName;
    private String userName;
    private String email;
    private String password;
    private Coordinates address;
    private Boolean isAdmin;

    private HashMap<String, RoadTrip> favoriteRoadTrips;

    public User(String lastName, String firstName, String userName, String email, String password, Coordinates coordinates) {
        setLastName(lastName.toUpperCase());
        setFirstName(firstName.substring(0, 1).toUpperCase() + firstName.substring(1).toLowerCase());
        setUserName(userName);
        setEmail(email);
        setPassword(password);
        setAddress(coordinates);
        setFavoriteRoadTrips(new HashMap<String, RoadTrip>());
        setAdmin(false);
    }

    public static HashMap<String, User> read() throws IOException, ClassNotFoundException {
        File file = new File("./Sauv/User.ser");

        ObjectInputStream ooi;

        try {
            ooi = new ObjectInputStream(new FileInputStream(file));
        } catch (IOException e) {
            ooi = new ObjectInputStream(new FileInputStream(file));
        }

        return (HashMap<String, User>) ooi.readObject();
    }

    public static void createSaveFile() throws IOException {
        File file = new File("./Sauv/User.ser");
        HashMap<String, User> hashMap = new HashMap<>();

        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file));
        oos.writeObject(hashMap);
    }

    //region Getters and Setters
    public String getLastName() {
        return lastName;
    }

    private void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    private void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getUserName() {
        return userName;
    }

    private void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    private void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    private void setEmail(String email) {
        this.email = email;
    }

    public Coordinates getAddress() {
        return address;
    }

    private void setAddress(Coordinates adresse) {
        this.address = adresse;
    }

    public Boolean getAdmin() {
        return isAdmin;
    }

    public void setAdmin(Boolean admin) {
        isAdmin = admin;
    }

    public HashMap<String, RoadTrip> getFavoriteRoadTrips() {
        return favoriteRoadTrips;
    }

    private void setFavoriteRoadTrips(HashMap<String, RoadTrip> favoriteRoadTrips) {
        this.favoriteRoadTrips = favoriteRoadTrips;
    }

    //endregion

    public boolean suggestPointInteret(String poinInterestName, PointInterestType type, float price, Coordinates coordinates) {
        PointInterest newPointInterest = new PointInterest(poinInterestName, type, price, coordinates, this);

        try {
            newPointInterest.save();
            return true;
        }
        //region catch
        catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
            return false;
        }
        //endregion
    }

    public boolean suggestPointInteret(String poinInterestName, String comment, PointInterestType type, float price, Coordinates coordinates) {
        PointInterest newPointInterest = new PointInterest(poinInterestName, comment, type, price, coordinates, this);

        try {
            newPointInterest.save();
            return true;
        }
        //region catch
        catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
            return false;
        }
        //endregion
    }

    public boolean commentPointInteret(String poinInterestName, String comment, Integer grade) {
        try {
            PointInterest.read().get(poinInterestName).addComment(comment, grade);
            return true;
        }
        //region catch
        catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
            return false;
        }
        //endregion
    }

    public boolean createRoadTrip(String roadTripName) {
        RoadTrip newRoadTrip = new RoadTrip(roadTripName, this);

        try {
            newRoadTrip.save();
            addRoadTripToFavorite(newRoadTrip.getName());
            return true;
        }
        //region catch
        catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
            return false;
        }
        //endregion
    }

    public boolean createRoadTrip(String roadTripName, String pointInterestName) {
        RoadTrip newRoadTrip = new RoadTrip(roadTripName, pointInterestName, this);

        try {
            newRoadTrip.save();
            addRoadTripToFavorite(newRoadTrip.getName());
            return true;
        }
        //region catch
        catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
            return false;
        }
        //endregion
    }

    public boolean deleteRoadTrip(String roadTripName) {
        try {
            RoadTrip roadTrip = RoadTrip.read().get(roadTripName);
            roadTrip.delete();
            return true;
        }
        //region catch
        catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
            return false;
        }
        //endregion
    }

    public void signIn(String roadTripName) {
        try {
            RoadTrip roadTrip = RoadTrip.read().get(roadTripName);
            roadTrip.addParticipants(this);
            roadTrip.save();
        }
        //region catch
        catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        //endregion
    }

    public void signOut(String roadTripName) {
        try {
            RoadTrip roadTrip = RoadTrip.read().get(roadTripName);
            roadTrip.deleteParticipants(this.getEmail());
            roadTrip.save();
        }
        //region catch
        catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        //endregion
    }

    public boolean addPointInteretToRoadTrip(String roadTripName, String pointInterestName) {
        try {
            PointInterest pointInterest = PointInterest.read().get(pointInterestName);
            RoadTrip.read().get(roadTripName).addPointInterest(pointInterest);
            return true;
        }
        //region catch
        catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
            return false;
        }
        //endregion
    }

    public boolean deletePointInteretFromRoadTrip(String roadTripName, String pointInteretName) {
        try {
            RoadTrip roadTrip = new RoadTrip(RoadTrip.read().get(roadTripName).getName(), this);
            RoadTrip.read().get(roadTripName).deletePointInterest(pointInteretName);
            roadTrip.save();
            return true;
        }
        //region catch
        catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
            return false;
        }
        //endregion
    }

    public boolean addRoadTripToFavorite(String roadTripName) {
        try {
            if (!RoadTrip.read().containsKey(roadTripName)) return false;

            RoadTrip RT = RoadTrip.read().get(roadTripName);

            favoriteRoadTrips.put(RT.getName(), RT);
            return true;
        }
        //region catch
        catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
            return false;
        }
        //endregion
    }

    public float getRoadTripPrice(String roadTripName) {
        try {
            return RoadTrip.read().get(roadTripName).getPrice();
        }
        //region catch
        catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
            return -1;
        }
        //endregion
    }

    public ArrayList<RoadTrip> getRoadTripByGrade(float grade) {
        ArrayList<RoadTrip> listResult = new ArrayList<RoadTrip>();

        try {
            for (RoadTrip roadTrip : RoadTrip.read().values()) {
                if (roadTrip.getGrade() >= grade) {
                    listResult.add(roadTrip);
                }
            }
            return listResult;
        }
        //region catch
        catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
            return listResult;
        }
        //endregion
    }

    @SuppressWarnings("unchecked")
    public void save() throws IOException, ClassNotFoundException {
        File file = new File("./Sauv/User.ser");

        ObjectInputStream ooi = new ObjectInputStream(new FileInputStream(file));

        HashMap<String, User> hashMap;

        hashMap = (HashMap<String, User>) ooi.readObject();
        hashMap.put(this.getEmail(), this);
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file));

        oos.writeObject(hashMap);
    }

    @Override
    public String toString() {
        return getUserName() + " (" + getLastName() + " " + getFirstName() + ")";
    }
}