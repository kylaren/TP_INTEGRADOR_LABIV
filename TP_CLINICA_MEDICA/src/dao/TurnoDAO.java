package dao;

import java.util.ArrayList;
import dominio.Turno;


public interface TurnoDAO {
	boolean registrarTurno(Turno turno);
	boolean actualizarTurno(int estado, int id);
	ArrayList<Turno> listarTurnos();
	
}
