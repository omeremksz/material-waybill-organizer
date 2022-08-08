package kalemyazilim.materialapp.materialwaybillorganizer.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import kalemyazilim.materialapp.materialwaybillorganizer.base.EntityAbstractClass;
import lombok.*;
import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name = "material_barcode_table")
public class MaterialBarcodeModel extends EntityAbstractClass {
    @Column(name = "barcode", length = 20)
    private String barcode;
    @ManyToOne
    @JoinColumn(name = "material_id")
    @JsonIgnore
    private MaterialModel materialModel;

    public MaterialBarcodeModel(Integer createUserId,
                                Integer updateUserId,
                                Date createDate,
                                Date updateDate,
                                String barcode,
                                MaterialModel materialModel) {
        super(createUserId, updateUserId, createDate, updateDate);
        this.barcode = barcode;
        this.materialModel = materialModel;
    }
}
