
package com.gpost.sprongmongo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gpost.sprongmongo.domain.User;
import com.gpost.sprongmongo.dto.UserDTO;
import com.gpost.sprongmongo.repository.UserRepository;
import com.gpost.sprongmongo.services.exception.ObjectNotFoundException;

@Service
public class UserService {

	@Autowired
	private UserRepository repository;

	public List<User> findAll() {
		return repository.findAll();
	}

	public User findById(String id) {
		// Usar Optional para tratar a ausência do usuário
		Optional<User> user = repository.findById(id);
		// Se o usuário não for encontrado, lançar exceção
		return user.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado! Id: " + id));
	}

	public User insert(User obj) {
		return repository.insert(obj);
	}
	
	public void delete(String id) {	
		findById(id);
		repository.deleteById(id);	
	}
	
	public User update(User obj) {
	    User newObj = repository.findById(obj.getId()).orElse(new User());
	    updateData(newObj, obj);  // Atualiza os campos do usuário existente com os novos dados
	    return repository.save(newObj);  // Salva o usuário atualizado no banco de dados
	}


	private void updateData(User newObj, User obj) {
	    newObj.setName(obj.getName());  // Update the name
	    newObj.setEmail(obj.getEmail());  // Update the email
	}

	public User fromDTO(UserDTO objdto) {
		return new User(objdto.getId(), objdto.getName(), objdto.getEmail());
	}
	
	

}
