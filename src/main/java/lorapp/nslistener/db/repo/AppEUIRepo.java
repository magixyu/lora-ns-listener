package lorapp.nslistener.db.repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import lorapp.nslistener.db.entity.AppEUI;

@Transactional

public interface AppEUIRepo extends CrudRepository<AppEUI, Long>{
}
