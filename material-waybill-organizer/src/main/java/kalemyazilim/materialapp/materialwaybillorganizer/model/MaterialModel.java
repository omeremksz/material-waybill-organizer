package kalemyazilim.materialapp.materialwaybillorganizer.model;

import kalemyazilim.materialapp.materialwaybillorganizer.base.EntityAbstractClass;
import lombok.*;

import javax.persistence.*;
import java.util.Collection;
import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name = "material_table")
public class MaterialModel extends EntityAbstractClass {
    @Column(name = "code", length = 20)
    private String code;
    @Column(name = "description", length = 100)
    private String description;
    @Column(name = "material_type")
    private MaterialType type;
    @OneToOne(targetEntity = BrandModel.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "brand_id")
    private BrandModel brand;
    @OneToOne(targetEntity = RayonModel.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "rayon_id")
    private RayonModel rayon;
    @OneToMany(targetEntity = MaterialBarcodeModel.class, cascade = CascadeType.ALL, mappedBy = "materialModel")
    private Collection<MaterialBarcodeModel>materialBarcodes;

    public MaterialModel(Integer createUserId,
                         Integer updateUserId,
                         Date createDate,
                         Date updateDate,
                         String code,
                         String description,
                         MaterialType type,
                         BrandModel brand,
                         RayonModel rayon,
                         Collection<MaterialBarcodeModel> materialBarcodes) {
        super(createUserId, updateUserId, createDate, updateDate);
        this.code = code;
        this.description = description;
        this.type = type;
        this.brand = brand;
        this.rayon = rayon;
        this.materialBarcodes = materialBarcodes;
    }
}
