package kalemyazilim.materialapp.materialwaybillorganizer.base;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;
import javax.persistence.*;
import java.util.Date;
@Getter
@Setter
@NoArgsConstructor
@MappedSuperclass
public abstract class EntityAbstractClass {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long Id;
    @Column(name = "create_user_id")
    private Integer createUserId;
    @Column(name = "update_user_id")
    private Integer updateUserId;
    @JsonFormat(pattern = "yyyy/MM/dd")
    @Column(name = "create_date")
    private Date createDate;
    @JsonFormat(pattern = "yyyy/MM/dd")
    @Column(name = "update_date")
    private Date updateDate;

    public EntityAbstractClass(Integer createUserId, Integer updateUserId, Date createDate, Date updateDate) {
        this.createUserId = createUserId;
        this.updateUserId = updateUserId;
        this.createDate = createDate;
        this.updateDate = updateDate;
    }
}
