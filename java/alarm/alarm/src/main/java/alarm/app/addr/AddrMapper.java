package alarm.app.addr;
 
import java.util.List;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.annotations.Delete;

@Mapper
public interface AddrMapper{
	
 
	@Select("SELECT * FROM addr")
	List<Addr> all();

	@Select("SELECT COUNT(*) FROM addr")
	int count();

	@Select("SELECT COUNT(*) FROM addr where name like #{name}")
	int countByName(@Param("name")String name);

	@Select("SELECT * FROM addr LIMIT #{start},#{length}")
	List<Addr> page(@Param("start") int start,@Param("length") int length);
	
	@Select("SELECT * FROM addr where name like #{name} LIMIT #{start},#{length}")
	List<Addr> pageByName(@Param("start") int start,@Param("length") int length,@Param("name")String name);

    @Select("SELECT * FROM addr WHERE ID = #{id}")
    Addr findById(@Param("id") String id);

    @Delete("delete from addr WHERE ID = #{id}")
    void delete(@Param("id") String id);

    @Insert("INSERT INTO addr (name,phone,dep)VALUE(#{name},#{phone},#{dep})")
    int insert(
    	@Param("name")String name,
    	@Param("phone")String phone,
    	@Param("dep")String dep 
    );

    @Update("update addr set name=#{name},phone=#{phone},dep=#{dep} where id=#{id}")
    int update(
		@Param("name")String name,
    	@Param("phone")String phone,
    	@Param("dep")String dep,
    	@Param("id")String id);
}
