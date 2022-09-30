package idv.cpl.springboot.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import idv.cpl.springboot.entity.PageInfo;
import idv.cpl.springboot.repository.PageInfoRepository;
import idv.cpl.springboot.service.PageInfoService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

@RestController
@RequestMapping("/api")
public class pageInfoController {

	private PageInfoRepository pageInfoRepository;

	private PageInfoService pageInfoService;

	public pageInfoController(PageInfoRepository pageInfoRepository, PageInfoService pageInfoService) {
		this.pageInfoRepository = pageInfoRepository;
		this.pageInfoService = pageInfoService;
	}

	@ApiOperation(value="新增頁面資訊", notes="加入頁面資訊到資料庫")
	@ApiResponses({ @ApiResponse(responseCode = "200", description = "成功新增"),
			@ApiResponse(responseCode = "400", description = "新增出現異常") })
	@PostMapping("/pageInfo")
	public ResponseEntity<PageInfo> createpageInfo(@ApiParam("頁面資訊") @RequestBody PageInfo PageInfo) {
		if (PageInfo.getId() != null) {
			return ResponseEntity.status(400).header("err-msg", "ID已存在").build();
		}
		return ResponseEntity.ok().body(pageInfoService.save(PageInfo));
	}

	@PutMapping("/pageInfo")
	@ApiResponses({ @ApiResponse(responseCode = "200", description = "pageInfo added successful"),
			@ApiResponse(responseCode = "400", description = "must have an id"),
			@ApiResponse(responseCode = "404", description = "not existed id") })
	public ResponseEntity<PageInfo> updatepageInfo(@RequestBody PageInfo PageInfo) {
		if (PageInfo.getId() == null) {
			return ResponseEntity.status(400).header("err-msg", "An update pageInfo must have an id").build();
		} else if (!pageInfoRepository.findById(PageInfo.getId()).isPresent()) {
			return ResponseEntity.status(404).header("err-msg", "Not existed id.").build();
		}
		return ResponseEntity.ok().body(pageInfoService.save(PageInfo));
	}

	@DeleteMapping("/pageInfo/{id}")
	public void deletepageInfoById(@PathVariable Long id) {
		pageInfoRepository.deleteById(id);
	}

	@DeleteMapping("/pageInfo")
	public void deletepageInfoByEntityInBatch(@RequestBody List<PageInfo> PageInfos) {
		pageInfoRepository.deleteAllInBatch(PageInfos);
	}

	@GetMapping("/pageInfo/{id}")
	public Optional<PageInfo> getpageInfoById(@PathVariable Long id) {
		return pageInfoService.findById(id);
	}

	@GetMapping("/pageInfo/bySortParams")
	public ResponseEntity<List<PageInfo>> findAllBySortParams(
			@RequestParam(value = "sortby", defaultValue = "id") String sortBy,
			@RequestParam(value = "direction", defaultValue = "ASC") Direction direction) {
		// 暫時不考慮排序的目標欄位是某存在，但如果搜尋的欄位名稱不存在時，則會報錯:
		// org.springframework.data.mapping.PropertyReferenceException
		return ResponseEntity.ok().body(pageInfoRepository.findAll(Sort.by(direction, sortBy)));
	}

	@GetMapping("/pageInfo/byPageParams")
	public ResponseEntity<Page<PageInfo>> findAllByPageRequestParams(
			@RequestParam(value = "sortby", defaultValue = "id") String sortBy,
			@RequestParam(value = "direction", defaultValue = "ASC") Direction direction,
			@RequestParam(value = "page", defaultValue = "0") int page,
			@RequestParam(value = "size", defaultValue = "10") int size) {
		return ResponseEntity.ok()
				.body(pageInfoRepository.findAll(PageRequest.of(page, size, Sort.by(direction, sortBy))));
	}

	@GetMapping("/pageInfo/bySort")
	public ResponseEntity<List<PageInfo>> findAllBySort(Sort sort) {
		return ResponseEntity.ok().body(pageInfoRepository.findAll(sort));
	}

	@GetMapping("/pageInfo/byPageable")
	public ResponseEntity<Page<PageInfo>> findAllByPageable(Pageable pageable) {
		return ResponseEntity.ok().body(pageInfoService.findAllByPageable(pageable));
	}
}
