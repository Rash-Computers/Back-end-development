/**
 * @author: ntwari egide
 * @description: school repository
 */

package com.rashcomps.rashcomputers.repositories;

import com.rashcomps.rashcomputers.models.School;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SchoolRepository extends JpaRepository<School, Long> {
}
