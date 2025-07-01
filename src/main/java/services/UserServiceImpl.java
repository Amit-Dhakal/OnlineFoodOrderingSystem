package services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpSession;

import connection.DbConnection;
import model.Feedback;
import model.Items;
import model.User;

public class UserServiceImpl implements UserService {
	Connection conn=null;
	PreparedStatement ps;
	ResultSet rs=null;
	Statement statement = null;
	@Override
	public void addUser(User user) {
		// TODO Auto-generated method stub		
		try {
			conn=DbConnection.getDbConnection();
			
			String sql="insert into user(USERNAME,PASSWORD,EMAIL,ADDRESS,PHONE) "+" values(?,?,?,?,?)";		
			ps=(PreparedStatement) conn.prepareStatement(sql);		
			ps.setString(1,user.getUsername());		
			ps.setString(2,user.getPassword());
			ps.setString(3,user.getEmail()); 
			ps.setString(4,user.getAddress());			
			ps.setString(5,user.getPhone());			
			int i=ps.executeUpdate();
			System.out.println("Data inserted successfully with"+i);		
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@Override
	public List<Feedback> retrieveAllUserFeedbackData() {
		// TODO Auto-generated method stub
		List<Feedback> listAllUser=new ArrayList<Feedback>();
		
		try {
			conn=DbConnection.getDbConnection();
			 statement = conn.createStatement();
			 
		     String sql="select * from feedback";
		     rs = statement.executeQuery(sql);
		      
		      while(rs.next()) {   	  
		    	Feedback feedback=new Feedback();   	  
		    	feedback.setUsername(rs.getString("USERNAME"));
		    	feedback.setEmail(rs.getString("EMAIL"));	
		    	feedback.setFeedback(rs.getString("FEEDBACK"));	
			      listAllUser.add(feedback);
			      
		      }
				
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
		return listAllUser;
	}

	
	@Override 
	public List<User> retrieveAllUserData() {
		// TODO Auto-generated method stub
			
		List<User> userData=new ArrayList<User>();
		try {
			conn=DbConnection.getDbConnection();
			statement = conn.createStatement();
			 
		     String sql="select * from user ";
		     rs = statement.executeQuery(sql);
		      
		      while(rs.next()) {   	  
		    	User user=new User();   	  
		    	  user.setUsername(rs.getString("USERNAME"));
		    	  user.setPassword(rs.getString("PASSWORD"));
		    	  user.setEmail(rs.getString("EMAIL"));	
		    	  user.setAddress(rs.getString("ADDRESS"));
		    	  user.setPhone(rs.getString("PHONE"));
		    	  userData.add(user);
		      }
				
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		return userData;
	}

	@Override
	public void addUserFeedback(Feedback feedBack) {
		// TODO Auto-generated method stub	
		try {
			conn=DbConnection.getDbConnection();
			
			String sql="insert into feedback(username,email,feedback)"+"values(?,?,?)";
			ps=(PreparedStatement) conn.prepareStatement(sql);
			
			ps.setString(1,feedBack.getUsername());
			ps.setString(2,feedBack.getEmail());
			ps.setString(3,feedBack.getFeedback());
	  		
			int i=ps.executeUpdate();
			
			System.out.println("feedback data update sucessfully!!!");
			
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
			
		} catch (SQLException e) {
			
			e.printStackTrace();
			
			
			
			
		}
		
		
		
		
	}

	/*

	
	@Override
	public void deleteItemById(int id) {
		// TODO Auto-generated method stub
		
		
		try {
			conn=DbConnection.getDbConnection();		
			String sql="Delete from nonvegdelights where id=?";			
			ps=(PreparedStatement) conn.prepareStatement(sql);
			ps.setInt(1,id);
			ps.executeUpdate();
			System.out.println("Data deleted successfully with :"+id);
						
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
	}

*/
/*
	@Override
	public Items ItemsById(int id) {
		// TODO Auto-generated method stub
		Items items = null;

		try {
			conn=DbConnection.getDbConnection();
			String sql="select * from nonvegdelights where id=?";
			ps=(PreparedStatement) conn.prepareStatement(sql);
            ps.setInt(1,id);			  				
			ResultSet rs=(ResultSet) ps.executeQuery();		
			while(rs.next()) {			
				 items=new Items();
				items.setId(rs.getInt("id"));		
				items.setItemnames(rs.getString("itemname"));
				items.setPrice(rs.getDouble("price"));
			} 
			
				
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return items;
		
		
	}

*/	

	

/*	
	@Override
	public void deleteKFCItemById(int id) {
		// TODO Auto-generated method stub
		Connection conn;	
		PreparedStatement ps;
		ResultSet rs;
		try {
			conn=DbConnection.getDbConnection();
			String sql="delete from kfc where id=?";
			ps=conn.prepareStatement(sql);
			ps.setInt(1,id);

			ps.executeUpdate();
			System.out.println("Data deleted successfully by:"+id);
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
			
	}
	
	
	

	@Override
	public void deleteVegItemById(int id) {
		// TODO Auto-generated method stub
		Connection conn;	
		PreparedStatement ps;
		ResultSet rs;
		try {
			conn=DbConnection.getDbConnection();
			String sql="delete from vegworld where id=?";
			ps=conn.prepareStatement(sql);
			ps.setInt(1,id);

			ps.executeUpdate();
			System.out.println("Data deleted successfully by:"+id);
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
			
	}
	
	
	*/
	
	@Override
	public void addUserOrders(Items items,String user) {
		// TODO Auto-generated method stub		
		Connection conn=null;
		PreparedStatement ps;
		ResultSet rs;
		try {
			conn=DbConnection.getDbConnection();
			String sql="insert into orderitem(itemname,price,username) "+" values(?,?,?)";			
			ps=(PreparedStatement) conn.prepareStatement(sql);			
			ps.setString(1,items.getItemnames());
			ps.setDouble(2,items.getPrice());
			ps.setString(3,user);			
			int i=ps.executeUpdate();		
			System.out.println("data inserted successfully with "+i);										
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
				
	}

	
	
	
	
	/*
	
	@Override
	public Items vegItemsById(int id) {
		// TODO Auto-generated method stub
		Connection conn=null;
		PreparedStatement ps;
		ResultSet rs=null;
		Items items = null;

		try {
			conn=DbConnection.getDbConnection();
			String sql="select * from vegworld where id=?";		
			ps=conn.prepareStatement(sql);
			ps.setInt(1,id);
			rs=ps.executeQuery();		
			while(rs.next()) {
				
			 items=new Items();
				items.setId(rs.getInt("id"));
				items.setItemnames(rs.getString("ITEMNAME"));
				items.setHotelname(rs.getString("HOTELNAME"));
				items.setPrice(rs.getDouble("PRICE"));
			}
				
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		return items;
	}

	@Override
	public Items getKFCItemsById(int id) {
		// TODO Auto-generated method stub
		Items items = null;
		Connection conn=null;
		PreparedStatement ps;
		ResultSet rs;
		
		try {
			try {
				conn=DbConnection.getDbConnection();
				String sql="select * from kfc where id=?";
				ps=conn.prepareStatement(sql);		
				ps.setInt(1,id);
				rs=ps.executeQuery();
				
				while(rs.next()) {
				items=new Items();
				items.setId(rs.getInt("id"));
				items.setItemnames(rs.getString("ITEMNAME"));
				items.setPrice(rs.getDouble("PRICE"));
				}		
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		return items;
	}

*/
	
	/*
	@Override
	public void addVegWorldItems(Items items) {
		// TODO Auto-generated method stub
		
		Connection conn=null;
		PreparedStatement ps;
		ResultSet rs=null;
		
		
		try {
			conn=DbConnection.getDbConnection();
			String sql="insert into vegworld(itemname,price,hotelname)"+"values(?,?,?)";
			 ps=conn.prepareStatement(sql);
			 
			 ps.setString(1,items.getItemnames());
			 ps.setDouble(2,items.getPrice());
			 ps.setString(3,items.getHotelname());
              int i=ps.executeUpdate();	 
			 System.out.println("Data inserted Successfully with"+i);
					 
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	}
	
	
	@Override
	public void addKFCItems(Items items) {
		// TODO Auto-generated method stub
		
		Connection conn;
	PreparedStatement ps;
	ResultSet rs=null;
	
		
		try {
			conn=DbConnection.getDbConnection();
			String sql="insert into kfc(itemname,price,hotelname)"+"values(?,?,?)";
			ps=(PreparedStatement) conn.prepareStatement(sql);
					
			ps.setString(1,items.getItemnames());
			ps.setDouble(2,items.getPrice());
			ps.setString(3,items.getHotelname());						
			int i=ps.executeUpdate();		
			System.out.println("Data inserted successfully with"+i);
			
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
	}

	@Override
	public void addNonVegDelightsItems(Items items) {
		// TODO Auto-generated method stub
		
		try {
			conn=DbConnection.getDbConnection();
			String sql="insert into nonvegdelights(itemname,price,hotelname)"+" VALUES(?,?,?)";	
			ps=(PreparedStatement) conn.prepareStatement(sql);
				
			ps.setString(1,items.getItemnames());
			ps.setDouble(2,items.getPrice());
			ps.setString(3,items.getHotelname());
			
			int i=ps.executeUpdate();
			System.out.println("items inserted successfully");
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
	}
	*/
	
	@Override
	public Items getRestaurantsItems(int id) {
		// TODO Auto-generated method stub
		Items items = null;
		Connection conn=null;
		PreparedStatement ps;
		ResultSet rs;
		
		try {
			try {
				conn=DbConnection.getDbConnection();
				String sql="select * from restaurant where id=?";
				ps=conn.prepareStatement(sql);		
				ps.setInt(1,id);
				rs=ps.executeQuery();
				
				while(rs.next()) {
				items=new Items();
				items.setId(rs.getInt("id"));
				items.setItemnames(rs.getString("ITEMNAME"));
				items.setPrice(rs.getDouble("PRICE"));
				}		
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		return items;
	}

	
	

	@Override
	public void addRestaurants(Items items) {
		// TODO Auto-generated method stub	
		Connection conn=null;
		PreparedStatement ps;
		ResultSet rs=null;	
		try {
			conn=DbConnection.getDbConnection();
			String sql="insert into restaurant(itemname,price,hotelname)"+"values(?,?,?)";
			 ps=conn.prepareStatement(sql);
			 ps.setString(1,items.getItemnames());
			 ps.setDouble(2,items.getPrice());
			 ps.setString(3,items.getHotelname());
              int i=ps.executeUpdate();	 
			 System.out.println("Data inserted Successfully with"+i);
					  
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	
	@Override
	public void deleteRestaurantById(int id) {
		// TODO Auto-generated method stub
		Connection conn;	
		PreparedStatement ps;
		ResultSet rs;
		try {
			conn=DbConnection.getDbConnection();
			String sql="delete from restaurant where id=?";
			ps=conn.prepareStatement(sql);
			ps.setInt(1,id);

			ps.executeUpdate();
			System.out.println("Data deleted successfully by:"+id);
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
			
	}
		
		
}
