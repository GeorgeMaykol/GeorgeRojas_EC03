package com.idat.idat_GeorgeRojas_ec03.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.idat.idat_GeorgeRojas_ec03.dto.UsuarioRequestDTO;
import com.idat.idat_GeorgeRojas_ec03.dto.UsuarioResponseDTO;
import com.idat.idat_GeorgeRojas_ec03.model.Usuario;
import com.idat.idat_GeorgeRojas_ec03.repository.UsuarioRepository;

@Service
public class UsuarioServiceImpl implements UsuarioService {

	@Autowired
	private UsuarioRepository repository;

	@Override
	public void guardarUsuario(UsuarioRequestDTO p) {
		Usuario usuario = new Usuario();
		usuario.setIdUsuario(p.getIdRequest());
		usuario.setUsuario(p.getUsuarioRequest());
		usuario.setPassword(p.getPasswordRequest());
		usuario.setRol(p.getRolRequest());
		repository.save(usuario);

	}

	@Override
	public void eliminarUsuario(Integer id) {
		repository.deleteById(id);

	}

	@Override
	public void editarUsuario(UsuarioRequestDTO p) {
		Usuario usuario = new Usuario();
		usuario.setIdUsuario(p.getIdRequest());
		usuario.setUsuario(p.getUsuarioRequest());
		usuario.setPassword(p.getPasswordRequest());
		usuario.setRol(p.getRolRequest());
		repository.saveAndFlush(usuario);

	}

	@Override
	public List<UsuarioResponseDTO> listarUsuario() {
		List<Usuario> usuario = repository.findAll();
		List<UsuarioResponseDTO> dto = new ArrayList<UsuarioResponseDTO>();
		UsuarioResponseDTO usuarioDTO = null;

		for (Usuario usuarios : usuario) {
			usuarioDTO = new UsuarioResponseDTO();
			usuarioDTO.setIdResponse(usuarios.getIdUsuario());
			usuarioDTO.setUsuarioResponse(usuarios.getUsuario());
			usuarioDTO.setPasswordResponse(usuarios.getPassword());
			usuarioDTO.setRolResponse(usuarios.getRol());
			dto.add(usuarioDTO);
		}
		return null;
	}

	@Override
	public UsuarioResponseDTO usuarioById(Integer id) {
		Usuario usuario = repository.findById(id).orElse(null);
		UsuarioResponseDTO usuarioDTO = new UsuarioResponseDTO();
		usuarioDTO = new UsuarioResponseDTO();
		usuarioDTO.setIdResponse(usuario.getIdUsuario());
		usuarioDTO.setUsuarioResponse(usuario.getUsuario());
		usuarioDTO.setPasswordResponse(usuario.getPassword());
		usuarioDTO.setRolResponse(usuario.getRol());
		return null;
	}

}
