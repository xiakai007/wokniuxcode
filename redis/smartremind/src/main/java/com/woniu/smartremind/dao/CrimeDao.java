package com.woniu.smartremind.dao;

import com.woniu.smartremind.mbg.model.Crime;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CrimeDao {
    List<Crime> searchCrime(@Param("crime") String crime);
}
