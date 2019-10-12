package t1708e.eadexam.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import t1708e.eadexam.entity.Catalog;

public interface CatalogRepository extends JpaRepository<Catalog, Integer> {
}
