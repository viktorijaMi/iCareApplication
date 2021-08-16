package mk.ukim.finki.icareapp.repository;

import mk.ukim.finki.icareapp.model.DiaryRecord;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface DiaryRecordJpaRepository extends JpaRepository<DiaryRecord, Long> {

    @Query(value = "select * from DiaryRecord d where d.user.username=:username", nativeQuery = true)
    List<DiaryRecord> findAllByUserUsername(String username);
}
