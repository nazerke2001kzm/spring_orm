package bitlab.jpa.spring_orm.services;

import bitlab.jpa.spring_orm.models.Folder;
import org.springframework.stereotype.Service;

import java.util.List;


public interface FolderService {
    List<Folder> findAll();
    void addFolder(Folder folder);
    Folder findById(Long id);
}
