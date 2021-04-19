

package com.sjp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import javax.persistence.*;
import com.sjp.Repository.AuthorRepo;
import com.sjp.Model.*;
import java.util.*;
import com.sjp.Exception.ResourceNotFound;
import com.sjp.Model.Author;
@RestController
@RequestMapping("/myapi/v1")
public class AuthorController {
	@Autowired
	private AuthorRepo authrepo;
	@GetMapping("/Author")
	public List<Author>getAll()
	{
		return authrepo.findAll();
		
	}
	
	@PostMapping("/Author")
	public Author createAuthor(@RequestBody Author author)
	{
		return authrepo.save(author);
	}
	
	@GetMapping("/Author/{Id}")
	public ResponseEntity<Author>getbyAuthorId(@PathVariable Long Id)
	{
		Author author=authrepo.findById(Id).orElseThrow(()->new ResourceNotFound("Author not found"));
		return ResponseEntity.ok(author);
	}
	
	@PutMapping("/Author/{Id}")
	public ResponseEntity<Author>updateAuthor(@PathVariable Long Id,@RequestBody Author authordetails)
	{
		Author author=authrepo.findById(Id).orElseThrow(()->new ResourceNotFound("Author not found"));
		author.setF_Name(authordetails.getF_Name());
		author.setL_Name(authordetails.getL_Name());
		author.setE_mail(authordetails.getE_mail());
		Author updatedetails =authrepo.save(author);
		return ResponseEntity.ok(updatedetails);
		
	}
	
	@DeleteMapping("/Author/{Id}")
	public ResponseEntity<Map<String, Boolean>>deleteAuthor(@PathVariable Long Id)
	{
		Author author=authrepo.findById(Id).orElseThrow(()->new ResourceNotFound("Author not found"));
authrepo.delete(author);
Map<String,Boolean>response=new HashMap<>();
response.put("Deleted", true);
return ResponseEntity.ok(response);
	
	
	}

}
