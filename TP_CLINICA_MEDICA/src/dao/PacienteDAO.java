package dao;

import java.util.List;

import dominio.Paciente;

public interface PacienteDAO {
	
	boolean insert(Paciente paciente);
    boolean update(Paciente paciente);
    boolean delete(Paciente paciente_a_eliminar);
    List<Paciente> readAll();
    
}
