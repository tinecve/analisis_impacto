package co.edu.ufps.ingsistemas.analisis_impacto.services;

import co.edu.ufps.ingsistemas.analisis_impacto.dto.request.UsuarioRequestDTO;
import co.edu.ufps.ingsistemas.analisis_impacto.dto.response.UsuarioResponseDTO;
import co.edu.ufps.ingsistemas.analisis_impacto.model.Usuario;

import java.util.List;

public interface UsuarioService {

    UsuarioResponseDTO crearUsuario(UsuarioRequestDTO dto);
    List<UsuarioResponseDTO> listarUsuarios();
    UsuarioResponseDTO obtenerUsuario(Long id);
    Usuario actualizarUsuario(Long id, UsuarioRequestDTO usuarioRequestDTO);
    void eliminarUsuario(Long id);

}
