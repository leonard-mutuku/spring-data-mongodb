/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mongodb.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.IndexDirection;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 *
 * @author leonard
 */
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "user_collection")
public class User {
    
    @Id
    private String id;
//    @Indexed(name = "name_index", direction = IndexDirection.DESCENDING)
    private String name;
    
    @JsonIgnore
    @CreatedDate
//    @Indexed(name = "expiration_after_index", expireAfter = "#{@applicationProperties.documentExpiry + @applicationProperties.documentExpiryUnit}")
    private Date expire = new Date();
    
}
