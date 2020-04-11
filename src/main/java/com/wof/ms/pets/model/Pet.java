package com.wof.ms.pets.model;

import com.wof.ms.pets.model.interfaces.IDTO;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.repository.Query;

@Document
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Pet implements IDTO {

  @Id
  private String id;
  @Indexed
  private Integer ownerId;
  private String name;
  private String breed;
  private String sex;
  private Integer age;
  private boolean vaccine;

}
