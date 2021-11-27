/**
 * @author: ntwari egide
 * @description: school outline repository
 */

package com.rashcomps.rashcomputers.repositories;

import com.rashcomps.rashcomputers.models.SchoolOutline;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SchoolOutlineRepository extends JpaRepository<SchoolOutline, Long> {
}
