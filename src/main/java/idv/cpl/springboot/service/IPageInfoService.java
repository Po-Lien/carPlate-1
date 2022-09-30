package idv.cpl.springboot.service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import idv.cpl.springboot.entity.PageInfo;

public interface IPageInfoService {
	public PageInfo save(PageInfo PageInfo);

	public void delete(PageInfo PageInfo);

	public void deleteAll();

	public Optional<PageInfo> findById(Long id);

	public List<PageInfo> findAll();
	
	public List<PageInfo> findAll(Example arg0);

	public Page<PageInfo> findAllByPageable(Pageable pageable);

	public void saveAuto() throws Exception;

	public List<PageInfo> autoFind(String[] deptValues, String plateNo) throws Exception;
}
