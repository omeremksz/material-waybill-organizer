package kalemyazilim.materialapp.materialwaybillorganizer.service;

import kalemyazilim.materialapp.materialwaybillorganizer.model.RayonModel;
import kalemyazilim.materialapp.materialwaybillorganizer.repository.RayonRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Date;
import java.util.List;

@Service
public class RayonService {
    @Autowired
    RayonRepo rayonRepo;
    public List<RayonModel> getAll() {
        return rayonRepo.findAll();
    }

    public List<RayonModel> getRayonById(Long rayonId) {
        return rayonRepo.getRayonsById(rayonId);
    }

    public RayonModel saveRayon(RayonModel rayonModel) {
        rayonModel.setCreateDate(new Date());
        return rayonRepo.save(rayonModel);
    }

    public void deleteRayon(Long rayonId) {
        boolean isRayonExists = rayonRepo.existsById(rayonId);
        if (!isRayonExists) {
            throw new IllegalStateException("Rayon with id " + rayonId + " does not exists.");
        }
        rayonRepo.deleteById(rayonId);
    }
    @Transactional
    public void updateRayon(Long rayonId, RayonModel updatedRayonModel) {
        RayonModel rayonModel = rayonRepo.findById(rayonId).orElseThrow(() -> new IllegalStateException("Rayon not found for this id: " + rayonId));
        rayonModel.setUpdateDate(new Date());
        rayonModel.setCode(updatedRayonModel.getCode());
        rayonModel.setDescription(updatedRayonModel.getDescription());
    }
}
