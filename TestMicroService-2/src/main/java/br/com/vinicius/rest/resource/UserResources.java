package br.com.vinicius.rest.resource;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import br.com.vinicius.model.User;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@Api(tags = "Api para obter informações do usuário")
public interface UserResources {

	@ApiResponses( value = {
			@ApiResponse(code = 201, message = "Created", response = User.class),
			@ApiResponse(code = 400, message = "Bad Request"),
			@ApiResponse(code = 404, message = "Not Found"),
			@ApiResponse(code = 500, message = "Internal Server Error")
	})
	@ApiOperation(value = "Recupera os dados dos usuários.")
	@RequestMapping(value = "/user", 
		method = RequestMethod.GET)
	ResponseEntity<User> getUserInfo();
}
