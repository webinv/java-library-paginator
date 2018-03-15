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

import java.util.List;

/**
 * @author Krzysztof Kardasz
 */
public interface PaginationSliding extends Pagination {
    List<Integer> getPagesInRange();

    PaginationSliding setPagesInRange(List<Integer> pagesInRange);

    Integer getFirstPageInRange();

    PaginationSliding setFirstPageInRange(Integer firstPageInRange);

    Integer getLastPageInRange();

    PaginationSliding setLastPageInRange(Integer lastPageInRange);
}
