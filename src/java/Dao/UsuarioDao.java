/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Model.Usuario;
import java.util.List;

/**
 *
 * @author thayseonofrio
 */
public interface UsuarioDao {

    public void save(Usuario usuario);

    public Usuario getUsuario(long id);

    public List<Usuario> list();

    public void remove(Usuario usuario);

    public void update(Usuario usuario);

}
