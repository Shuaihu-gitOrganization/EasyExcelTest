package com.atxiaohu.vip.pojo;

import lombok.*;
import org.springframework.stereotype.Component;

import java.math.BigInteger;

/**
 * @Date 2023/4/21
 * @Author XiaoHu
 * @Description
 **/
@Component
@AllArgsConstructor
@Data
@Getter
@Setter
@NoArgsConstructor
@Builder
public class User {
    private String name;
    private String password;
    private BigInteger id;
    private Integer status;
}
