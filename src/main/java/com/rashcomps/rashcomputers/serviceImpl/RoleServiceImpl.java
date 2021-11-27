/**
 * @author: Ntezirizaza Erneste
 * @description:  Role service implementation
 */

package com.rashcomps.rashcomputers.serviceImpl;

import com.rashcomps.rashcomputers.exceptions.RoleNotFoundException;
import com.rashcomps.rashcomputers.models.Role;
import com.rashcomps.rashcomputers.repositories.RoleRepository;
import com.rashcomps.rashcomputers.services.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleRepository roleRepository;

    @Override
    public List<Role> findAll() {
        return roleRepository.findAll();
    }

    public Role checkExistence(Long id) {

        Optional<Role> roleOptional = roleRepository.findById(id);

        if(! roleOptional.isPresent()) throw new RoleNotFoundException("Role is not found");

        return roleOptional.get();

    }

    @Override
    public Role findById(Long id) throws RoleNotFoundException {
        return checkExistence(id);
    }

    @Override
    public Role add(Role newRole) throws RoleNotFoundException {
        return roleRepository.save(newRole);
    }

    @Override
    public Role update(Role updates, Long id) throws RoleNotFoundException {

        checkExistence(id);

        updates.setId(id);

        return roleRepository.save(updates);
    }

    @Override
    public Boolean delete(Long id) throws RoleNotFoundException {

        checkExistence(id);

        roleRepository.deleteById(id);

        return true;
    }
}
