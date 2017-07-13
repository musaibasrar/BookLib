package com.bookan.book.DAO;

import com.bookan.book.domain.User;

public interface UserDAO {

	User readUniqueObject(User user);
}
