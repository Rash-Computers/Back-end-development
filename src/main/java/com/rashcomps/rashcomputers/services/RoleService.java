/**
 * @author: ntwari egide
 * @desciption: role services interface
 */

package com.rashcomps.rashcomputers.services;

import com.rashcomps.rashcomputers.exceptions.RoleNotFoundException;
import com.rashcomps.rashcomputers.models.Role;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface RoleService {

    public List<Role> findAll();

    public Role findById(Long id) throws RoleNotFoundException;

    public Role add(Role newRole) throws RoleNotFoundException;

    public Role update(Role updates, Long id)  throws RoleNotFoundException;

    public Boolean delete(Long id)  throws RoleNotFoundException;

}
