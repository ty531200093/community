package tangyuan.majiang.community.community.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;
import tangyuan.majiang.community.community.mode.User;
//ctrl+alt+o自动删除多余的引用文件
/*
 * @author:ty
 * @create:2019-07-14 15:54
 * */
@Mapper
@Component
public interface UserMapper {
    @Insert("insert into user (name,account_id,token,gmt_create,gmt_modified) values (#{name},#{accountId},#{token},#{gmtCreate},#{gmtModified})")
    void insert(User user);
}
