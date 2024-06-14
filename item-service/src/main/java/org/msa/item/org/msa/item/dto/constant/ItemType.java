package org.msa.item.org.msa.item.dto.constant;

public enum ItemType {
    FOOD("F", "음식"),
    CLOTHES("C", "옷");

    private String cd; //코드값
    private String desc; //코드에 대한 설명

    ItemType(String cd, String desc) {
        this.cd = cd;
        this.desc = desc;
    }

    public String getCd(){
        return this.cd;
    }

    //해당 코드가 존재하는지 확인
    public boolean hasItemCd(String cd) {
        return this.cd.equals(cd);
    }
}
