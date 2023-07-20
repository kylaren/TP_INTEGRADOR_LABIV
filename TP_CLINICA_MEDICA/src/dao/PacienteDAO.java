package dao;

import java.util.List;

import dominio.Paciente;

public interface PacienteDAO {
	
	boolean insert(Paciente paciente);
    boolean update(Paciente paciente);
    boolean delete(int aEliminar);
    
    List<Paciente> readAll();
    Paciente buscarPaciente(int idBusqueda);
    
}
