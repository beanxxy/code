package alarm.app.user; 

import java.util.List;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.annotations.Delete;

@Mapper
public interface UserMapper{
	
	@Select("SELECT * FROM user WHERE name = #{user} and password=#{password} LIMIT 0,1")
    User login(@Param("user") String user,@Param("password") String password);
	
	@Select("SELECT * FROM user")
	List<User> all();

	@Select("SELECT COUNT(*) FROM user")
	int count();

	@Select("SELECT COUNT(*) FROM user where name like #{name}")
	int countByName(@Param("name")String name);

	@Select("SELECT * FROM user LIMIT #{start},#{length}")
	List<User> page(@Param("start") int start,@Param("length") int length);
	
	@Select("SELECT * FROM user where name like #{name} LIMIT #{start},#{length}")
	List<User> pageByName(@Param("start") int start,@Param("length") int length,@Param("name")String name);

    @Select("SELECT * FROM user WHERE ID = #{id}")
    User findUserById(@Param("id") String id);

    @Delete("delete from user WHERE ID = #{id}")
    void delete(@Param("id") String id);

    @Insert("INSERT INTO user (NAME,PASSWORD)VALUE(#{name},#{password})")
    int insert(@Param("name")String name,@Param("password")String password);

    @Update("update user set name=#{name},password=#{password} where id=#{id}")
    int update(@Param("name")String name,@Param("password")String password,@Param("id")String id);
}
