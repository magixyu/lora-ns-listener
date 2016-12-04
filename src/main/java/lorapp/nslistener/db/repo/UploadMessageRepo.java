package lorapp.nslistener.db.repo;

import org.springframework.data.repository.CrudRepository;

import lorapp.nslistener.db.entity.UploadMessage;

public interface UploadMessageRepo extends CrudRepository<UploadMessage, Long> {

}
