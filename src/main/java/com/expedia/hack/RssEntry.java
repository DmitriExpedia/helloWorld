/**
 *
 * RssEntry.java
 *
 * Copyright 2014 Expedia, Inc. All rights reserved.
 * EXPEDIA PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

package com.expedia.hack;

/**
 * TODO v-dmelnikov Describe RssEntry
 * 
 * @author <a href="mailto:v-dmelnikov@expedia.com">v-dmelnikov</a>
 * 
 */
public class RssEntry {
    private String title;
    private String id;
    private String published;
    private String updated;
    private DocumentLink link;
    private String description;
    private String ttttttttttttttttttttttt;

    
    
    
    /**
     * @return Returns the description.
     */
    public String getDescription() {
        return description;
    }

    /**
     * @param description The description to set.
     */
    public void setDescription(String description) {
        this.description = description;
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
     * @return Returns the published.
     */
    public String getPublished() {
        return published;
    }

    /**
     * @param published
     *            The published to set.
     */
    public void setPublished(String published) {
        this.published = published;
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

}
