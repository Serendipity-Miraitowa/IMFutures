package org.example.imfutures.service;


import org.example.imfutures.pojo.Nav;
import java.util.List;

public interface NavigationService {

    /**
     * 查询历史导航
     * @param uid
     * @return
     */
    List<Nav> findByUid(Integer uid);

    /**
     * 添加历史导航
     * @param nav
     */
    void insert(Nav nav);

    /**
     * 删除历史导航
     * @param uid
     */
    void delete(Integer uid);
}
