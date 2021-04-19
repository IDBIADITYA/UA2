package com.sjp.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sjp.Model.*;

@Repository
public interface AuthorRepo extends JpaRepository<Author, Long> {

}
