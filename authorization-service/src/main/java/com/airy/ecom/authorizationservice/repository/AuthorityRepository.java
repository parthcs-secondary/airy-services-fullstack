package com.airy.ecom.authorizationservice.repository;

import com.airy.ecom.authorizationservice.entity.Authority;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorityRepository extends JpaRepository<Authority, Integer> {

}
