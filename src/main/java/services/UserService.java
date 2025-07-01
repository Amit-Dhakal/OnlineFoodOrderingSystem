package services;

import java.util.List;

import model.Feedback;
import model.Items;
import model.User;

public interface UserService {
	
	public void addUser(User user);
	public void addUserFeedback(Feedback feedBack);
	public List<Feedback> retrieveAllUserFeedbackData();
	public List<User> retrieveAllUserData();	
    public void addRestaurants(Items items);
    public Items getRestaurantsItems(int id);
    public void deleteRestaurantById(int id); 
    public void addUserOrders(Items items,String user);
//public void deleteItemById(int id);	
// public Items ItemsById(int id);
//public Items vegItemsById(int id);
//public Items getKFCItemsById(int id);
//public void deleteKFCItemById(int id);
//public void deleteVegItemById(int id);
//public void addKFCItems(Items items);
//public void addVegWorldItems(Items items);
//public void addNonVegDelightsItems(Items items);

}
