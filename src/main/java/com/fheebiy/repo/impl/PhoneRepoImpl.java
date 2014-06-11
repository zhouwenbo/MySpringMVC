package com.fheebiy.repo.impl;

import com.fheebiy.domain.Phone;
import com.fheebiy.repo.PhoneRepo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * Created by bob zhou on 14-6-11.
 */
public class PhoneRepoImpl implements PhoneRepo{


    @Override
    public Phone findById(long phone_id) {
        return null;
    }

    @Override
    public List<Phone> findByPrice(double price) {
        return null;
    }

    @Override
    public List<Phone> getPhoneList(String name, long phone_id, double price) {
        return null;
    }

    @Override
    public Phone save(Phone phone) {
        return null;
    }

    @Override
    public List<Phone> save(Iterable<? extends Phone> phones) {
        return null;
    }

    @Override
    public Phone findOne(String s) {
        return null;
    }

    @Override
    public boolean exists(String s) {
        return false;
    }

    @Override
    public List<Phone> findAll() {
        return null;
    }

    @Override
    public long count() {
        return 0;
    }

    @Override
    public void delete(String s) {

    }

    @Override
    public void delete(Phone phone) {

    }

    @Override
    public void delete(Iterable<? extends Phone> phones) {

    }

    @Override
    public void deleteAll() {
    }

    @Override
    public List<Phone> findAll(Sort orders) {
        return null;
    }

    @Override
    public Page<Phone> findAll(Pageable pageable) {
        return null;
    }
}
