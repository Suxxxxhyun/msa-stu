package org.msa.item.org.msa.item.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.msa.item.org.msa.item.dto.ItemDTO;
import org.msa.item.org.msa.item.dto.ResponseDTO;
import org.msa.item.org.msa.item.service.ItemService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "v1/item")
@Slf4j //로깅 처리를 위한 어노테이션
@RequiredArgsConstructor
public class ItemController {

    private final ItemService itemService;

    @RequestMapping(value="/add", method=RequestMethod.POST)
    public ResponseEntity<ResponseDTO> add(@Valid @RequestBody ItemDTO itemDTO){
        ResponseDTO.ResponseDTOBuilder responseBuilder = ResponseDTO.builder();

        itemService.insertItem(itemDTO);
        log.debug("request add item id = {}", itemDTO.getId());

        responseBuilder.code("200").message("success");
        return ResponseEntity.ok(responseBuilder.build());
    }
}
