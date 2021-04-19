package com.sjp.Model;
import javax.persistence.*;

@Entity
@Table(name="Author_Table")
public class Author {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long Id;
	
	@Column(name="First_Name")
	private String F_Name;
	

	@Column(name="Last_Name")
	private String L_Name;
	

	@Column(name="E_Mail")
	private String e_mail;
	
	
	
	
	public Author() {
		
	}
	public Author(long id, String f_Name, String l_Name, String e_mail) {
		super();
		Id = id;
		F_Name = f_Name;
		L_Name = l_Name;
		this.e_mail = e_mail;
	}
	public long getId() {
		return Id;
	}
	public void setId(long id) {
		Id = id;
	}
	public String getF_Name() {
		return F_Name;
	}
	public void setF_Name(String f_Name) {
		F_Name = f_Name;
	}
	public String getL_Name() {
		return L_Name;
	}
	public void setL_Name(String l_Name) {
		L_Name = l_Name;
	}
	public String getE_mail() {
		return e_mail;
	}
	public void setE_mail(String e_mail) {
		this.e_mail = e_mail;
	}
	
	
	
	

}
