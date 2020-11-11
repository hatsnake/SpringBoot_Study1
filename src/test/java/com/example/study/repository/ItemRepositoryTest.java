package com.example.study.repository;


import com.example.study.StudyApplicationTests;
import com.example.study.model.entity.Item;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Optional;

public class ItemRepositoryTest extends StudyApplicationTests {

    @Autowired
    private ItemRepository itemRepository;

    @Test
    public void create() {
        String status = "UNREGISTERED";
        String name = "삼성 노트북";
        String title = "삼성 노트북 A100";
        String content = "2019년형 노트북입니다";
        BigDecimal price = BigDecimal.valueOf(900000);
        String brandName = "삼성";
        LocalDateTime registeredAt = LocalDateTime.now();
        LocalDateTime createdAt = LocalDateTime.now();
        String createdBy = "Partner01";
        Long partnerId = 1L;

        Item item = new Item();
        item.setStatus(status);
        item.setName(name);
        item.setTitle(title);
        item.setContent(content);
        item.setPrice(price);
        item.setBrandName(brandName);
        item.setRegisteredAt(registeredAt);
        item.setCreatedAt(createdAt);
        item.setCreatedBy(createdBy);
        //item.setPartnerId(partnerId);

        Item newItem = itemRepository.save(item);

        Assert.assertNotNull(newItem);
        Assert.assertEquals(newItem.getBrandName(), brandName);

    }

    @Test
    public void read() {
        Long id = 1L;
        Optional<Item> optionalItem = itemRepository.findById(id);
        optionalItem.ifPresent(i->{
            Assert.assertEquals(i.getId(), id);
            System.out.println(i.getName());
        });
    }
}
