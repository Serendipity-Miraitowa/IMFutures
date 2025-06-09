package org.example.imfutures.mapper;


import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.example.imfutures.pojo.Nav;

import java.util.List;

@Mapper
public interface NavigationMapper {

    /**
     * 查询历史导航
     * @param uid
     * @return
     */
    @Select("select * from nav where user_id = #{uid}")
    List<Nav> findByUid(Integer uid);

    /**
     * 添加历史导航
     * @param nav
     */
    @Insert("insert into nav(address, date, user_id) values (#{address}, #{date}, #{userId})")
    void insert(Nav nav);

    /**
     * 删除历史导航
     * @param uid
     */
    @Delete("delete from nav where user_id = #{uid}")
    void delete(Integer uid);
}
