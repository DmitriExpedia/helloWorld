/**
 *
 * RssLine.java
 *
 * Copyright 2014 Expedia, Inc. All rights reserved.
 * EXPEDIA PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

package com.expedia.hack;

import java.util.List;

/**
 * RssLine
 * 
 * @author <a href="mailto:v-dmelnikov@expedia.com">v-dmelnikov</a>
 * 
 */
public class RssLine {
    private List<RssEntry> entries;
    private String authorName;
    private String updated;
    private String id;
    private DocumentLink link;
    private String title;

    /**
     * @return Returns the entries.
     */
    public List<RssEntry> getEntries() {
        return entries;
    }

    /**
     * @param entries
     *            The entries to set.
     */
    public void setEntries(List<RssEntry> entries) {
        this.entries = entries;
    }

    /**
     * @return Returns the authorName.
     */
    public String getAuthorName() {
        return authorName;
    }

    /**
     * @param authorName
     *            The authorName to set.
     */
    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    /**
     * @return Returns the updated.
     */
    public String getUpdated() {
        return updated;
    }

    /**
     * @param updated
     *            The updated to set.
     */
    public void setUpdated(String updated) {
        this.updated = updated;
    }

    /**
     * @return Returns the id.
     */
    public String getId() {
        return id;
    }

    /**
     * @param id
     *            The id to set.
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * @return Returns the link.
     */
    public DocumentLink getLink() {
        return link;
    }

    /**
     * @param link
     *            The link to set.
     */
    public void setLink(DocumentLink link) {
        this.link = link;
    }

    /**
     * @return Returns the title.
     */
    public String getTitle() {
        return title;
    }

    /**
     * @param title
     *            The title to set.
     */
    public void setTitle(String title) {
        this.title = title;
    }

}
