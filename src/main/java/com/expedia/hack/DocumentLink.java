/**
 *
 * DocumentLink.java
 *
 * Copyright 2014 Expedia, Inc. All rights reserved.
 * EXPEDIA PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

package com.expedia.hack;

/**
 * TODO v-dmelnikov Describe DocumentLink
 * 
 * @author <a href="mailto:v-dmelnikov@expedia.com">v-dmelnikov</a>
 * 
 */
public class DocumentLink {
    private String type;
    private String href;
    private String rel;

    /**
     * @return Returns the type.
     */
    public String getType() {
        return type;
    }

    /**
     * @param type
     *            The type to set.
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     * @return Returns the href.
     */
    public String getHref() {
        return href;
    }

    /**
     * @param href
     *            The href to set.
     */
    public void setHref(String href) {
        this.href = href;
    }

    /**
     * @return Returns the rel.
     */
    public String getRel() {
        return rel;
    }

    /**
     * @param rel
     *            The rel to set.
     */
    public void setRel(String rel) {
        this.rel = rel;
    }

}
