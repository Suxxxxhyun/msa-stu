package org.msa.item.org.msa.item.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="ITEM")
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Item {
    @Id
    @Column(name = "ID", length = 30)
    private String id;

    @Column(name = "NAME", length = 30)
    private String name;

    @Column(name = "DESCRIPTION", length = 30)
    private String description;

    @Column(name = "CNT", length = 10)
    private long count;

    @Column(name = "REG_DTS", length = 14)
    private String regDts;

    @Column(name = "UPD_DTS", length = 14)
    private String updDts; //물품의 최종일시
}