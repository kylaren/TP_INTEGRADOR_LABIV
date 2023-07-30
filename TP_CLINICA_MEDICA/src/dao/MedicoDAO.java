package dao;

import java.util.ArrayList;

import dominio.Medico;

public interface MedicoDAO {

	boolean insertarMedico(Medico medico);
    boolean actualizarMedico(Medico medico);
    boolean borrarMedico(int idEliminar);
    
    ArrayList<Medico> listarMedicos();
    Medico buscarMedico(int idBusqueda);
	Medico login(String usuario, String contrasena);
}
