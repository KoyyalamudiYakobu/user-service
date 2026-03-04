package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.demo.Utils.ResponseBean;
import com.example.demo.dto.UserDto;
import com.example.demo.entity.User;
import com.example.demo.repository.UserRepository;

@Service
public class UserService {
	
	@Autowired
	private UserRepository repo;	

	public ResponseEntity<ResponseBean> saveUser(UserDto dto) {
		ResponseBean bean= new ResponseBean();
		bean.setStatus(HttpStatus.OK);
		try {
			
			User entity=this.getUserObject(dto);
			entity=repo.save(entity);
			if(entity!=null)
			{
				bean.setData(entity);
				bean.setMessage("Registration done");
				bean.setStatus(HttpStatus.CREATED);
			}
			
		}catch(Exception e)
		{
			e.printStackTrace();
			bean.setMessage(" something went wrong");
			bean.setStatus(HttpStatus.EXPECTATION_FAILED);
			
		}
            return new ResponseEntity(bean,HttpStatus.OK);
		
	}

	private User getUserObject(UserDto dto) {
		User obj=new User();
        obj.setEmail(dto.getEmail());
        obj.setName(dto.getName());
        obj.setPassword(dto.getPassword());
		return obj;
	}

	
}
