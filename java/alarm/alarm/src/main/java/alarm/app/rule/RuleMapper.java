package alarm.app.rule;
 
import java.util.List;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.annotations.Delete;

@Mapper
public interface RuleMapper{ 
 
	@Select("SELECT * FROM `rule`")
	List<Rule> all();

	@Select("SELECT COUNT(*) FROM `rule`")
	int count();

	@Select("SELECT COUNT(*) FROM `rule` where name like #{name}")
	int countByName(@Param("name")String name);

	@Select("SELECT * FROM rule LIMIT #{start},#{length}")
	List<Rule> page(@Param("start") int start,@Param("length") int length);
	
	@Select("SELECT * FROM `rule` where name like #{name} LIMIT #{start},#{length}")
	List<Rule> pageByName(@Param("start") int start,@Param("length") int length,@Param("name")String name);

    @Select("SELECT * FROM `rule` WHERE ID = #{id}")
    Rule findById(@Param("id") String id);

    @Delete("delete from `rule` WHERE ID = #{id}")
    void delete(@Param("id") String id);

    @Insert("INSERT INTO `rule` ("
    		+ "`name`,"
    		+ "`sql`,"
    		+ "`state`,"
    		+ "`dep`,"
    		+ "`timecell`,"
    		+ "`msg`,"
    		+ "`nexttime`,"
    		+ "`alarmtime`,"
    		+ "`maxvalue`,"
    		+ "`minvalue`,"
    		+ "`model`,"
    		+ "`sign`,"
    		+ "`standard`"
    		
    	+ ")VALUES("
	    	+ "#{name},"
	    	+ "#{sql},"
	    	+ "#{state},"
	    	+ "#{dep},"
	    	+ "#{timecell},"
	    	+ "#{msg},"
	    	+ "#{nexttime},"
	    	+ "#{alarmtime}," 
	    	+ "#{maxvalue},"
	    	+ "#{minvalue}," 
	    	
			+ "#{model}," 
			+ "#{sign},"
			+ "#{standard}" 
    + ")")
    int insert(
    	@Param("name")String name,
    	@Param("sql")String sql,
    	@Param("state")String state,
    	@Param("dep")String dep,
    	@Param("timecell")String timecell,
    	@Param("msg")String msg,
    	@Param("nexttime")String nexttime,
    	@Param("alarmtime")String alarmtime,
    	@Param("maxvalue")String maxvalue,
    	@Param("minvalue")String minvalue,
    	
    	@Param("model")String model,
    	@Param("sign")String sign,
    	@Param("standard")String standard
    	
    );

    @Update("update `rule` set "
        + "`name`=#{name},"
        + "`sql`=#{sql},"
        + "`state`=#{state},"
        + "`dep`=#{dep},"
        + "`timecell`=#{timecell},"
        + "`msg`=#{msg},"
        + "`nexttime`=#{nexttime},"
        + "`alarmtime`=#{alarmtime},"
        + "`maxvalue`=#{maxvalue},"
        + "`minvalue`=#{minvalue}, " 
	     + "`model`=#{model},"
	     + "`sign`=#{sign},"
	     + "`standard`=#{standard} "
        + ""
    + "where id=#{id}")
    int update(
		@Param("name")String name,
    	@Param("sql")String sql,
    	@Param("state")String state,
    	@Param("dep")String dep,
    	@Param("timecell")String timecell,
    	@Param("msg")String msg,
    	@Param("nexttime")String nexttime,
    	@Param("alarmtime")String alarmtime, 
    	@Param("maxvalue")String maxvalue,
    	@Param("minvalue")String minvalue,
     	@Param("model")String model,
    	@Param("sign")String sign,
    	@Param("standard")String standard,
    	@Param("id")String id);
    
    
    @Update("update `rule` set " 
            + "`state`=#{state} " 
            + ""
        + "where id=#{id}")
    int start (@Param("state")String state,  @Param("id")String id);
}
