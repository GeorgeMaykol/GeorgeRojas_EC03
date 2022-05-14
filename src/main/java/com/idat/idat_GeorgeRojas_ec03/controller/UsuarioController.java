package com.idat.idat_GeorgeRojas_ec03.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.idat.idat_GeorgeRojas_ec03.dto.UsuarioRequestDTO;
import com.idat.idat_GeorgeRojas_ec03.dto.UsuarioResponseDTO;
import com.idat.idat_GeorgeRojas_ec03.service.UsuarioService;


@RestController
@RequestMapping("/usuario/v1")
public class UsuarioController {
	
	@Autowired
	private UsuarioService service;
	
	@RequestMapping(method= RequestMethod.GET, path="/listar")
	public ResponseEntity<List<UsuarioResponseDTO>> listar(){
		return new ResponseEntity<List<UsuarioResponseDTO>>(service.listarUsuario(),HttpStatus.OK);
	}
	
	@RequestMapping(method= RequestMethod.POST, path="/guardar")
	public ResponseEntity<Void> guardar(@RequestBody UsuarioRequestDTO usuario){
		service.guardarUsuario(usuario);
		return new ResponseEntity<Void>(HttpStatus.CREATED);
	}
	
	@RequestMapping(method= RequestMethod.GET, path="/listar/{id}")
	public @ResponseBody ResponseEntity<UsuarioResponseDTO> productById(@PathVariable Integer id){
		UsuarioResponseDTO usuario = service.usuarioById(id);
		
		if(usuario != null) {
			return new ResponseEntity<UsuarioResponseDTO>(usuario,HttpStatus.OK);
		}
		return new ResponseEntity<UsuarioResponseDTO>(HttpStatus.NOT_FOUND);
	}
	
	@RequestMapping(method= RequestMethod.DELETE, path="/eliminar/{id}")
	public ResponseEntity<Void> eliminar(@PathVariable Integer id){
		UsuarioResponseDTO usuario = service.usuarioById(id);
		if(usuario != null) {
			service.eliminarUsuario(id);
			return new ResponseEntity<Void>(HttpStatus.OK);
		}
		return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
	}
	
	@RequestMapping(method= RequestMethod.PUT, path="/editar")
	public ResponseEntity<Void> editar(@RequestBody UsuarioRequestDTO usuario){
		UsuarioResponseDTO usuari = service.usuarioById(usuario.getIdRequest());
		if(usuari != null) {
			service.editarUsuario(usuario);
			return new ResponseEntity<Void>(HttpStatus.OK);
		}
		return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		
	}

}
