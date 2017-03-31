package com.fheebiy.repo;

import com.fheebiy.domain.UserChip;
import org.springframework.stereotype.Repository;

/**
 * Created by cm on 2017/3/30.
 *
 */
@Repository
public interface UserChipRepo extends IRepo<UserChip>{

    @Override
    void save(UserChip obj);
}
