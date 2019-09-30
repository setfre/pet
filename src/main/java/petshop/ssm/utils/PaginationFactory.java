package petshop.ssm.utils;

import petshop.ssm.pojo.Master;
import petshop.ssm.pojo.Pagination;

public class PaginationFactory {

	private Pagination<Master> users = new Pagination<Master>();
	public Pagination<Master> getUsersPagination() {
		return users;
	}
}
