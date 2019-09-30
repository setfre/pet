package petshop.ssm.mapper;

import java.util.List;
import java.util.Map;

import petshop.ssm.pojo.Master;

public interface MasterMapper extends BaseMapper<Master>{

	Master retrieveByUsercode(Master user);

	Integer retrieveSize();

	List<Master> pagination(Map<String, Integer> range);

}
