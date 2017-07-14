package com.niit.dao;

import java.util.List;

import com.niit.model.Friend;
import com.niit.model.Users;

public interface FriendDao {

	List<Users> listOfSuggestedUsers(String Username);
	void friendRequest(String fromUsername, String toUsername);
	List<Friend> listOfPendingRequest(String loggedInUsername);
	void updatePendingRequest(String fromId,String toId,char status);
	List<Friend> listOfFriends(String Username);
}
