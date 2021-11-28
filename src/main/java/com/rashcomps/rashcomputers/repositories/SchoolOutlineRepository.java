/**
 * @author: ntwari egide
 * @description: school outline repository
 */

package com.rashcomps.rashcomputers.repositories;

import com.rashcomps.rashcomputers.models.School;
import com.rashcomps.rashcomputers.models.SchoolOutline;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SchoolOutlineRepository extends JpaRepository<SchoolOutline, Long> {
    List<SchoolOutline> findBySchool(School school);
}
