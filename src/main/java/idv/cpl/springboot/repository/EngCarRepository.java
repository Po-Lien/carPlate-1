package idv.cpl.springboot.repository;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

import idv.cpl.springboot.dto.EngCarDTO;

@Repository
public interface EngCarRepository extends JpaRepository<EngCarDTO, Long> {

}
