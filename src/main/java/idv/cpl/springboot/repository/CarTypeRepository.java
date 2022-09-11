package idv.cpl.springboot.repository;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

import idv.cpl.springboot.dto.CarTypeDTO;

@Repository
public interface CarTypeRepository extends JpaRepository<CarTypeDTO, Long> {

}
