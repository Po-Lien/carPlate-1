package idv.cpl.springboot.repository;

import org.springframework.stereotype.Repository;

import idv.cpl.springboot.entity.CarType;

import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface CarTypeRepository extends JpaRepository<CarType, Long> {

}
