package ${packagename};

import java.util.Set;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.snimay.hibernate.Annotation.*;

/**   
 * @title      : Entity.java
 * @package    : com.snimay.app.entity.vo
 * : TODO 
 * @author     : xxy
 * @date       : 2018年5月29日 下午12:03:56
 * @version    : V1.0   
 */
@table(query = "${query_}", name = "${name}",size=10,sever= "${sever_}")
@javax.persistence.Entity
@Table(name = "SYS_${name?lower_case}")
public class ${name} {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@field(text = "ID")
	public Long id;
}