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

import idv.cpl.springboot.dto.PageInfoDTO;
import idv.cpl.springboot.service.PageInfoService;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

@RestController
@RequestMapping("/api")
public class pageInfoController {

    private PageInfoService pageInfoService;

    public pageInfoController(PageInfoService pageInfoService) {
        this.pageInfoService = pageInfoService;
    }

    @PostMapping("/pageInfo")
    @ApiResponses({ @ApiResponse(responseCode = "200", description = "pageInfo added successful"),
            @ApiResponse(responseCode = "400", description = "cannot contain id") })
    public ResponseEntity<PageInfoDTO> createpageInfo(@RequestBody PageInfoDTO PageInfoDTO) {
        if (PageInfoDTO.getId() != null) {
            return ResponseEntity.status(400).header("err-msg", "A new pageInfo cannot already have an id").build();
        }
        return ResponseEntity.ok().body(pageInfoService.save(PageInfoDTO));
    }

    @PutMapping("/pageInfo")
    @ApiResponses({ @ApiResponse(responseCode = "200", description = "pageInfo added successful"),
            @ApiResponse(responseCode = "400", description = "must have an id"),
            @ApiResponse(responseCode = "404", description = "not existed id") })
    public ResponseEntity<PageInfoDTO> updatepageInfo(@RequestBody PageInfoDTO PageInfoDTO) {
        if (PageInfoDTO.getId() == null) {
            return ResponseEntity.status(400).header("err-msg", "An update pageInfo must have an id").build();
        } else if (!pageInfoService.findById(PageInfoDTO.getId()).isPresent()) {
            return ResponseEntity.status(404).header("err-msg", "Not existed id.").build();
        }
        return ResponseEntity.ok().body(pageInfoService.save(PageInfoDTO));
    }

    @DeleteMapping("/pageInfo/{id}")
    public void deletepageInfoById(@PathVariable Long id) {
        pageInfoService.deleteById(id);
    }

    @DeleteMapping("/pageInfo")
    public void deletepageInfoByEntityInBatch(@RequestBody List<PageInfoDTO> PageInfoDTOs) {
        pageInfoService.deleteInBatch(PageInfoDTOs);
    }

    @GetMapping("/pageInfo/{id}")
    public Optional<PageInfoDTO> getpageInfoById(@PathVariable Long id) {
        return pageInfoService.findById(id);
    }

    @GetMapping("/pageInfo/bySortParams")
    public ResponseEntity<List<PageInfoDTO>> findAllBySortParams(
            @RequestParam(value = "sortby", defaultValue = "id") String sortBy,
            @RequestParam(value = "direction", defaultValue = "ASC") Direction direction) {
        // 暫時不考慮排序的目標欄位是某存在，但如果搜尋的欄位名稱不存在時，則會報錯:
        // org.springframework.data.mapping.PropertyReferenceException
        return ResponseEntity.ok().body(pageInfoService.findAll(Sort.by(direction, sortBy)));
    }

    @GetMapping("/pageInfo/byPageParams")
    public ResponseEntity<Page<PageInfoDTO>> findAllByPageRequestParams(
            @RequestParam(value = "sortby", defaultValue = "id") String sortBy,
            @RequestParam(value = "direction", defaultValue = "ASC") Direction direction,
            @RequestParam(value = "page", defaultValue = "0") int page,
            @RequestParam(value = "size", defaultValue = "10") int size) {
        return ResponseEntity.ok()
                .body(pageInfoService.findAll(PageRequest.of(page, size, Sort.by(direction, sortBy))));
    }

    @GetMapping("/pageInfo/bySort")
    public ResponseEntity<List<PageInfoDTO>> findAllBySort(Sort sort) {
        return ResponseEntity.ok().body(pageInfoService.findAll(sort));
    }

    @GetMapping("/pageInfo/byPageable")
    public ResponseEntity<Page<PageInfoDTO>> findAllByPageable(Pageable pageable) {
        return ResponseEntity.ok().body(pageInfoService.findAll(pageable));
    }
}
