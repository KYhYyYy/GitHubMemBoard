package com.icia.githubmemboard.dto;

import lombok.Data;
import org.apache.ibatis.type.Alias;
import org.springframework.web.multipart.MultipartFile;

@Data
@Alias("member")
public class MEMBER {
    String mId;
    String mPw;
    String mName;
    String mEmail;
    String mAge;
    MultipartFile mProfile;
    String mProfileName;
}
