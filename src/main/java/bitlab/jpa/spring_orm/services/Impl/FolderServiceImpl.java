package bitlab.jpa.spring_orm.services;

import bitlab.jpa.spring_orm.models.Folder;
import bitlab.jpa.spring_orm.repositories.FolderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class FolderServiceImpl implements FolderService{

    @Autowired
    FolderRepository folderRepository;
    @Override
    public List<Folder> findAll() {
        List<Folder> folders = folderRepository.findAll();
        return folders;
    }

    @Override
    public void addFolder(Folder folder) {
        folderRepository.save(folder);
    }

    @Override
    public Folder findById(Long id) {
        return folderRepository.findById(id).orElseThrow();
    }
}
