package br.com.vinicius.model;

import java.sql.Date;

//import javax.persistence.Column;
//import javax.persistence.Entity;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
//import javax.persistence.Id;
//import javax.persistence.Table;

//@Entity
//@Table(name = "tbg_cliente")
public class Cliente {

//	@Id
//	@GeneratedValue(strategy = GenerationType.AUTO)
//	@Column(name = "id_cliente", unique = true, nullable = false)
	private Long id;
	
//	@Column(name = "first_name")
	private String firstName;
	
//	@Column(name = "second_name")
	private String secondName;
	
//	@Column(name = "birthday")
	private Date birthday;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getSecondName() {
		return secondName;
	}
	public void setSecondName(String secondName) {
		this.secondName = secondName;
	}
	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
}
