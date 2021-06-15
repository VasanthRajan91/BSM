package com.bsm.user.repository;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.bsm.user.model.Registration;

public interface RegistrationRepository extends CrudRepository<Registration, Integer> {

	@Query("SELECT count(*) AS id FROM Registration WHERE username = :username AND password= :password")
    public int checkUserAuth(@Param("username") String username, @Param("password") String password);
	
	@Modifying
	@Transactional
	@Query("UPDATE Registration set token = :token  WHERE username = :username AND password= :password")
    public int updateToken(@Param("token") String token, @Param("username") String username, @Param("password") String password);
	
	@Query("SELECT count(*) AS id FROM Registration WHERE token = :token")
    public int checkUserToken(@Param("token") String token);

	@Query("SELECT customerid FROM Registration WHERE token = :token")
	public String getCustID(String token);
	
	@Query("SELECT r FROM Registration r WHERE token = :token")
	public Registration getAccountDetails(String token);
}
