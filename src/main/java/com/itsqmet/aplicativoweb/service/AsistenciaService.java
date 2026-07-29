package com.itsqmet.aplicativoweb.service;
import com.itsqmet.aplicativoweb.model.Asistencia;
import com.itsqmet.aplicativoweb.repository.AsistenciaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class AsistenciaService {

    @Autowired

    private AsistenciaRepository asistenciaRepository;

    public List<Asistencia> obtenerTodas(){
        return asistenciaRepository.findAll();
    }

    //Buscar por id
    public Optional <Asistencia> obtenerPorId(Long id){
        return asistenciaRepository.findById(id);
    }

    //Registrar asistencia
    public Asistencia guardarAsistencia(Asistencia asistencia ){
        return asistenciaRepository.save(asistencia);
    }

    //Eliminar asistencia
    public void eliminarAsistencia (Long id){
        asistenciaRepository.deleteById(id);
    }


}