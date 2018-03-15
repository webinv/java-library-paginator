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

package io.webinv.paginator.domain;

import java.util.List;

/**
 * @author Krzysztof Kardasz
 */
public class PaginationSliding extends Pagination implements io.webinv.paginator.PaginationSliding  {
    private List<Integer> pagesInRange;
    private Integer firstPageInRange;
    private Integer lastPageInRange;

    public List<Integer> getPagesInRange() {
        return pagesInRange;
    }

    public PaginationSliding setPagesInRange(List<Integer> pagesInRange) {
        this.pagesInRange = pagesInRange;
        return this;
    }

    public Integer getFirstPageInRange() {
        return firstPageInRange;
    }

    public PaginationSliding setFirstPageInRange(Integer firstPageInRange) {
        this.firstPageInRange = firstPageInRange;
        return this;
    }

    public Integer getLastPageInRange() {
        return lastPageInRange;
    }

    public PaginationSliding setLastPageInRange(Integer lastPageInRange) {
        this.lastPageInRange = lastPageInRange;
        return this;
    }
}
