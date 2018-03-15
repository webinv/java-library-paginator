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

/**
 * @author Krzysztof Kardasz
 */
public class Pagination implements io.webinv.paginator.Pagination {
    private String urlPattern = "?page={{ page }}";
    private Integer last;
    private Integer current;
    private Integer numItemsPerPage;
    private Integer first;
    private Integer pageCount;
    private Long totalCount;
    private Integer previous;
    private Integer next;
    /**
     * @return
     */
    public String getUrlPattern() {
        return urlPattern;
    }

    /**
     * Define url pattern with {{ page }} placeholder
     * @param urlPattern example http://example.com/page/{{ page }}
     */
    public Pagination setUrlPattern(String urlPattern) {
        this.urlPattern = urlPattern;
        return this;
    }

    public Integer getLast() {
        return last;
    }

    public Pagination setLast(Integer last) {
        this.last = last;
        return this;
    }

    public Integer getCurrent() {
        return current;
    }

    public Pagination setCurrent(Integer current) {
        this.current = current;
        return this;
    }

    public Integer getNumItemsPerPage() {
        return numItemsPerPage;
    }

    public Pagination setNumItemsPerPage(Integer numItemsPerPage) {
        this.numItemsPerPage = numItemsPerPage;
        return this;
    }

    public Integer getFirst() {
        return first;
    }

    public Pagination setFirst(Integer first) {
        this.first = first;
        return this;
    }

    public Integer getPageCount() {
        return pageCount;
    }

    public Pagination setPageCount(Integer pageCount) {
        this.pageCount = pageCount;
        return this;
    }

    public Long getTotalCount() {
        return totalCount;
    }

    public Pagination setTotalCount(Long totalCount) {
        this.totalCount = totalCount;
        return this;
    }

    public Integer getPrevious() {
        return previous;
    }

    public Pagination setPrevious(Integer previous) {
        this.previous = previous;
        return this;
    }

    public Integer getNext() {
        return next;
    }

    public Pagination setNext(Integer next) {
        this.next = next;
        return this;
    }

    public String renderUrl(String urlPattern, Integer page, Integer defaultVal)
    {
        if (page == null) {
            return renderUrl(urlPattern, defaultVal);
        }
        return renderUrl(urlPattern, page);
    }

    public String renderUrl(Integer page, Integer defaultVal)
    {
        if (page == null) {
            return renderUrl(defaultVal);
        }
        return renderUrl(page);
    }

    public String renderUrl(Integer page)
    {
        if (page == null || urlPattern == null) {
            return "";
        }
        return urlPattern.replaceAll("\\{\\{\\s*page\\s*}}", page.toString());
    }

    public String renderUrl(String urlPattern, Integer page)
    {
        if (page == null || urlPattern == null) {
            return "";
        }
        return urlPattern.replaceAll("\\{\\{\\s*page\\s*}}", page.toString());
    }
}
