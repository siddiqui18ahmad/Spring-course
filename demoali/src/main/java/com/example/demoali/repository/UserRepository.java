package com.example.demoali.repository;



import com.example.demoali.model.User;
import com.microsoft.azure.spring.data.cosmosdb.repository.DocumentDbRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends DocumentDbRepository<User, String> {

}

