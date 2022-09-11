package idv.cpl.springboot.repository;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

import idv.cpl.springboot.dto.NameRefDTO;

@Repository
public interface NameRefRepository extends JpaRepository<NameRefDTO, Long> {

}
