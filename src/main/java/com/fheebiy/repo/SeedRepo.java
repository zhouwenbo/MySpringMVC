package com.fheebiy.repo;

import com.fheebiy.domain.Seed;
import org.springframework.stereotype.Repository;

/**
 * Created by cm on 2017/4/3.
 */
@Repository
public interface SeedRepo {

    void save(Seed seed);
}
