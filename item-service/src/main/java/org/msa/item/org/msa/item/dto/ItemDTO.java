package org.msa.item.org.msa.item.dto;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;

@Data
public class ItemDTO {
    private String id;
    private String name;
    private String description;
    private long count;
    private String regDts;
    private String updDts; //물품의 최종수정일시
}
