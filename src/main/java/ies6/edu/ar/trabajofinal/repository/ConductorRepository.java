package ies6.edu.ar.trabajofinal.repository;

import java.util.List;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ies6.edu.ar.trabajofinal.model.Conductor;

@Repository
public interface ConductorRepository extends CrudRepository<Conductor, Integer> {

    public List<Conductor> findByEstado (Boolean estado); 
}
