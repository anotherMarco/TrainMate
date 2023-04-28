package de.oninek.trainmate.api.persistance.repository;

import de.oninek.trainmate.api.persistance.entity.BaseEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.data.repository.PagingAndSortingRepository;

@NoRepositoryBean
public interface TrainMateRepository<T extends BaseEntity> extends CrudRepository<T,Long >, PagingAndSortingRepository<T, Long> {
}
