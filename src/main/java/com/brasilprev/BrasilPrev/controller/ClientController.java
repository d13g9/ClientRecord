package com.brasilprev.BrasilPrev.controller;

import java.net.URI;
import java.util.List;


import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.brasilprev.BrasilPrev.model.Client;
import com.brasilprev.BrasilPrev.model.ClientRepository;

@RestController
public class ClientController {
	
	private final ClientRepository clientRepo;
	
	 public ClientController(ClientRepository clientRepo) {
		super();
		this.clientRepo = clientRepo;
	}

	 @GetMapping("/clients")
	  List<Client> all() {
	    return clientRepo.findAll();
	  }

	 @PostMapping("/addclient")
	  ResponseEntity<Object> newClient(@Valid @RequestBody Client newClient) {
		 Client client = clientRepo.save(newClient);
		 
		 URI location = ServletUriComponentsBuilder
				 			.fromCurrentRequest()
				 			.path("/{id}")
				 			.buildAndExpand(client.getId())
				 			.toUri();
		 
	     	return ResponseEntity.created(location).build();
	  }
	 
	 @GetMapping("/client/{id}")	
	  Client one(@PathVariable Long id) throws ClientNotFoundException {

		 return clientRepo.findById(id)
			      .orElseThrow(() -> new ClientNotFoundException(id));
	  }
	 
	  @PutMapping("/updateclient/{id}")
	  Client UpdateClient(@Valid @RequestBody Client clientupdated, @PathVariable Long id) {

	    return clientRepo.findById(id)
	      .map(client -> {
	    	  client.setName(clientupdated.getName());
	    	  client.setCpf(clientupdated.getCpf());
	    	  client.setEndereco(clientupdated.getAddress());
	    	  return clientRepo.save(client);
	      })
	      .orElseGet(() -> {
	    	  clientupdated.setId(id);
	        return clientRepo.save(clientupdated);
	      });
	  }
	  
	  @DeleteMapping("/client/{id}")
	  void deleteClient(@PathVariable Long id) {
		  clientRepo.deleteById(id);
	  }

}
