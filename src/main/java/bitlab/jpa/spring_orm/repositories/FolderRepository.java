package bitlab.jpa.spring_orm.repositories;

import bitlab.jpa.spring_orm.models.Folder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FolderRepository extends JpaRepository<Folder,Long>{

}
