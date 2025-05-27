package org.example.imfutures.service.Impl;

import org.example.imfutures.mapper.NavigationMapper;
import org.example.imfutures.pojo.Nav;
import org.example.imfutures.service.NavigationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NavigationServiceImpl implements NavigationService {

    @Autowired
    NavigationMapper mapper;

    /**
     * 查询历史导航
     * @param uid
     * @return
     */
    @Override
    public List<Nav> findByUid(Integer uid) {
        return mapper.findByUid(uid);
    }

    /**
     * 添加历史导航
     * @param nav
     */
    @Override
    public void insert(Nav nav) {
        mapper.insert(nav);
    }

    /**
     * 删除历史导航
     * @param uid
     */
    @Override
    public void delete(Integer uid) {
        mapper.delete(uid);
    }
}
