package kalemyazilim.materialapp.materialwaybillorganizer.model;

import kalemyazilim.materialapp.materialwaybillorganizer.base.EntityAbstractClass;
import lombok.*;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@DynamicUpdate
@Table(name = "brand_table")
public class BrandModel extends EntityAbstractClass {
    @Column(name = "code", length = 20)
    private String code;
    @Column(name = "description", length = 100)
    private String description;

    public BrandModel(Integer createUserId,
                      Integer updateUserId,
                      Date createDate,
                      Date updateDate,
                      String code,
                      String description) {
        super(createUserId, updateUserId, createDate, updateDate);
        this.code = code;
        this.description = description;
    }
}
