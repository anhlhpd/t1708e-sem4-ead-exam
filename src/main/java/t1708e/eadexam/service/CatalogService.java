package t1708e.eadexam.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import t1708e.eadexam.entity.Catalog;
import t1708e.eadexam.repository.CatalogRepository;

import java.util.List;

@Service
public class CatalogService {
    @Autowired
    @Qualifier("catalogRepository")
    CatalogRepository catalogRepository;

    public List<Catalog> catalogs() {
        //catalogRepository.findAll(PageRequest.of(1, 3));
        return catalogRepository.findAll();
    }

    public Catalog getById(int id) {
        return catalogRepository.findById(id).orElse(null);
    }

    public Catalog create(Catalog catalog) {
        return catalogRepository.save(catalog);
    }

}
