package com.icia.githubmemboard.dto;

import lombok.Data;
import org.apache.ibatis.type.Alias;

@Data
@Alias("api")
public class ApiDTO {
    // 지도의 위치를 저장하고 불러오기
    // Q. 지도에서 인천일보 아카데미 주소를 어떻게 찾는가?
    // A. 위도, 경도를 이용해서 찾는다.
    // 우리가 저장한 위치의 이름을 설정, 길찾기 기능 추가
    // ex) 배달거리 시간을 측정

    String storeName;  // 업체명
    double lat;         // 위도
    double lng;         // 경도
}
