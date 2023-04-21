package com.example.metawater.mapper;

import com.example.metawater.domain.ProductVO;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MypageMapperTest {
    @Autowired
    private MypageMapper mypageMapper;

    @Test
    public void getMyProductListTest() {
//       List<ProductVO> myProductList = mypageMapper.getMyProductList(1L);
//        assertNotNull(myProductList);

//        for (ProductVO product : myProductList) {
//            System.out.println(product);
//        }
    }
}
