package kalemyazilim.materialapp.materialwaybillorganizer.model;

import kalemyazilim.materialapp.materialwaybillorganizer.base.EntityAbstractClass;
import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name = "rayon_table")
public class RayonModel extends EntityAbstractClass {
    @Column(name = "code", length = 20)
    private String code;
    @Column(name = "description", length = 100)
    private String description;

    public RayonModel(Integer createUserId,
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
