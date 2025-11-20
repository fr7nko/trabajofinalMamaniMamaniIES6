package ies6.edu.ar.trabajofinal.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import ies6.edu.ar.trabajofinal.model.Viaje;

@Repository
public interface ViajeRepository extends JpaRepository <Viaje, Integer>{
    public List<Viaje> findByUsuarioEstado(Boolean estado);
    public List<Viaje> findByVehiculoEstado(Boolean estado);

}
