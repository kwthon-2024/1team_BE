package kwthon_1team.kwthon.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import kwthon_1team.kwthon.domian.entity.Mail;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Page;


public interface MailRepository extends JpaRepository<Mail,Long> {

    @Query("SELECT m FROM Mail m JOIN m.sender s WHERE  m.isPublic = true AND s.studentId =: memberId")
    Page<Mail> findAllByFriendId(@Param("memberId") Long memberId, Pageable pageable);
}