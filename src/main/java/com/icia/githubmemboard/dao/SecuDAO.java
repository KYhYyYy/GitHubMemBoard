package com.icia.githubmemboard.dao;

import com.icia.githubmemboard.dto.SecuDTO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface SecuDAO {
    // void는 return값이 없음

    // int secuJoin(SecuDTO secu);
    // service로 int타입의 값을 반환
    void secuJoin(SecuDTO secu);

    SecuDTO secuLogin(SecuDTO secu);


}
