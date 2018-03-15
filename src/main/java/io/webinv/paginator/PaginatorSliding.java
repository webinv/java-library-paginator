/*
 * Copyright 2002-2018 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package io.webinv.paginator;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

/**
 * Paginator class
 *
 * @author Krzysztof Kardasz
 */
public class PaginatorSliding implements Paginator {
    private final Logger logger = LogManager.getLogger(this.getClass());

    private int range = 5;

    private int currentPageNumber = 1;
    private int numItemsPerPage = 24;
    private long totalCount = 0L;


    public int getCurrentPageNumber() {
        return currentPageNumber;
    }

    public PaginatorSliding setCurrentPageNumber(int currentPageNumber) {
        if (currentPageNumber < 1) {
            currentPageNumber = 1;
        }
        this.currentPageNumber = currentPageNumber;
        return this;
    }

    public int getNumItemsPerPage() {
        return numItemsPerPage;
    }

    public PaginatorSliding setNumItemsPerPage(int numItemsPerPage) {
        this.numItemsPerPage = numItemsPerPage;
        return this;
    }

    public long getTotalCount() {
        return totalCount;
    }

    public PaginatorSliding setTotalCount(long totalCount) {
        this.totalCount = totalCount;
        return this;
    }

    public int getRange() {
        return range;
    }

    public PaginatorSliding setRange(int range) {
        this.range = range;
        return this;
    }
    
    private List<Integer> range(int start, int end) {
        int count = Math.abs(end-start);
        List<Integer> range = new ArrayList<>();
        for (int i = 0; i <= count; i++) {
            range.add(i, start + i);
        }
        return range;
    }

    public PaginationSliding getPagination () {
        int pageCount = (int)Math.ceil((double)totalCount / (double)numItemsPerPage);
        int current = currentPageNumber;

        if (range > pageCount) {
            range = pageCount;
        }

        int delta = (int)Math.ceil((double)range / 2.0);

        int firstPageInRange;
        int lastPageInRange;

        if (current - delta > pageCount - range) {
            firstPageInRange = pageCount - range + 1;
            lastPageInRange = pageCount;
        } else {
            if (current - delta < 0) {
                delta = current;
            }
            int offset = current - delta;

            firstPageInRange = offset + 1;
            lastPageInRange = offset + range;
        }

        PaginationSliding pagination = new io.webinv.paginator.domain.PaginationSliding();

        pagination.setLast(pageCount);
        pagination.setCurrent(current);
        pagination.setNumItemsPerPage(numItemsPerPage);
        pagination.setFirst(1);
        pagination.setPageCount(pageCount);
        pagination.setTotalCount(totalCount);
        pagination.setPagesInRange(range(firstPageInRange, lastPageInRange));
        pagination.setFirstPageInRange(firstPageInRange);
        pagination.setLastPageInRange(lastPageInRange);

        if (current - 1 > 0) {
            pagination.setPrevious(current - 1);
        }

        if (current + 1 <= pageCount) {
            pagination.setNext(current + 1);
        }

        return pagination;
    }
}