package uk.co.certait.spring.web.utils;

import java.util.Iterator;
import java.util.List;

import org.displaytag.pagination.PaginatedList;
import org.displaytag.properties.SortOrderEnum;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;

public class PaginatedListWrapper implements PaginatedList {

	private Page<?> page;

	public PaginatedListWrapper(Page<?> page) {
		this.page = page;
	}

	@Override
	public int getFullListSize() {
		return (int) page.getTotalElements();
	}

	@Override
	public List<?> getList() {
		return page.getContent();
	}

	@Override
	public int getObjectsPerPage() {
		return page.getSize();
	}

	@Override
	public int getPageNumber() {
		return page.getNumber() + 1;
	}

	@Override
	public String getSearchId() {
		return null;
	}

	@Override
	public String getSortCriterion() {
		return null;//"surname, forename";//page.getSort() != null ? page.getSort().toString() : null;
	}

	@Override
	public SortOrderEnum getSortDirection() {
		SortOrderEnum sortOrder = SortOrderEnum.DESCENDING;

		if (page.getSort() != null) {
			Sort sort = page.getSort();

			for (Iterator<Sort.Order> orders = sort.iterator(); orders.hasNext();) {
				if (orders.next().isAscending()) {
					sortOrder = SortOrderEnum.ASCENDING;
				}
			}
		}

		return sortOrder;
	}
}
