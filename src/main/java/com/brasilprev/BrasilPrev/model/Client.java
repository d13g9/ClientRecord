package com.brasilprev.BrasilPrev.model;

import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class Client {
	
	private @Id @GeneratedValue Long id;
	@Size(min=11, max=11,message="Cpf is too short!")
	private String cpf;
	@NotNull(message="Name is mandatory!")
	private String name;
	@NotNull(message="Address is mandatory!")
	private String address;
	
	
	public Client(Long id, String cpf, String name, String address) {
		super();
		this.id = id;
		this.cpf = cpf;
		this.name = name;
		this.address = address;
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getCpf() {
		return cpf;
	}


	public void setCpf(String cpf) {
		this.cpf = cpf;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getAddress() {
		return address;
	}


	public void setEndereco(String address) {
		this.address = address;
	}
	
	
	@Override
	  public boolean equals(Object o) {
	    if (this == o)
	      return true;
	    if (!(o instanceof Client))
	      return false;
	    Client client = (Client) o;
	    return Objects.equals(this.id, client.id) && Objects.equals(this.name, client.name)
	        && Objects.equals(this.address, client.address);
	  }

	  @Override
	  public int hashCode() {
	    return Objects.hash(this.id, this.name, this.address);
	  }
	
}
