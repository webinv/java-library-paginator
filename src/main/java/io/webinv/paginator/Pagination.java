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

/**
 * @author Krzysztof Kardasz
 */
public interface Pagination {
    String getUrlPattern();

    /**
     * Define url pattern with {{ page }} placeholder
     * @param urlPattern example http://example.com/page/{{ page }}
     */
    Pagination setUrlPattern(String urlPattern);

    Integer getLast();

    Pagination setLast(Integer last);

    Integer getCurrent();

    Pagination setCurrent(Integer current);

    Integer getNumItemsPerPage();

    Pagination setNumItemsPerPage(Integer numItemsPerPage);

    Integer getFirst();

    Pagination setFirst(Integer first);

    Integer getPageCount();

    Pagination setPageCount(Integer pageCount);

    Long getTotalCount();

    Pagination setTotalCount(Long totalCount);

    Integer getPrevious();

    Pagination setPrevious(Integer previous);

    Integer getNext();

    Pagination setNext(Integer next);

    String renderUrl(String urlPattern, Integer page, Integer defaultVal);

    String renderUrl(Integer page, Integer defaultVal);

    String renderUrl(Integer page);

    String renderUrl(String urlPattern, Integer page);
}
