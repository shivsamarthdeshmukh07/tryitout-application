package com.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.entity.User;
import com.example.utility.UserProfileDto;

@Repository
public interface GenericUserRepository extends JpaRepository<User,Integer > {
	
	public User findByEmailAndPassword(String email , String pass);
	
	@Query(value = "select user_table.user_id as Id,user_table.first_name as FirstName, user_table.last_name as LastName, user_table.mobile as Mobile,"
			+ " user_address.postal_code as PostCode, user_address.add_line1 as AddressLine1, "
			+ "user_address.add_line2 as AddressLine2, user_address.state as State,user_table.email as Email,"
			+ "user_address.country as Country, user_address.city as City, user_table.image as UserImg,user_address.address_id as AddId"
			+ " from user_table join user_address on user_table.user_id = user_address.user_id where user_table.user_id=:uid and user_address.is_default=true",nativeQuery = true)
	public UserProfileDto getUserProfileInfo(@Param("uid") int userId);
	
}
