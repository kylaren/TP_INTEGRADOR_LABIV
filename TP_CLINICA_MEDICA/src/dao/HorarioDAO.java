package dao;

import java.util.ArrayList;

import dominio.Horario;


public interface HorarioDAO {
	
	boolean insertarHorario(Horario horario);
    boolean borrarHorario(int idEliminar);
    ArrayList<Horario> listarHorariosPorMedico(int idMedico);
    

	
	
}
