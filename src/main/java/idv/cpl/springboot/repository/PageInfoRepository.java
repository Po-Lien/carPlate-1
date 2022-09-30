package idv.cpl.springboot.repository;

import org.springframework.stereotype.Repository;

import idv.cpl.springboot.entity.PageInfo;

import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface PageInfoRepository extends JpaRepository<PageInfo, Long> {

}
