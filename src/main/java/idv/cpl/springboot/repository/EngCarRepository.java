package idv.cpl.springboot.repository;

import org.springframework.stereotype.Repository;

import idv.cpl.springboot.entity.EngCar;

import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface EngCarRepository extends JpaRepository<EngCar, Long> {

}
