/* This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this file,
 * You can obtain one at http://mozilla.org/MPL/2.0/. */

package pt.webdetails.cdf.dd.model.inst.writer.cdfrunjs.dashboard;

import java.io.Serializable;
import java.util.Date;
import java.util.regex.Matcher;
import org.apache.commons.lang.StringUtils;

/**
 * @author dcleao
 */
public final class CdfRunJsDashboardWriteResult implements Serializable
{
  private static final long serialVersionUID = 1L;
  
  // --------------
  
  private final Date _loadedDate;
  private final String _template, _header, _layout, _components, _content, _footer;
  
  protected CdfRunJsDashboardWriteResult(Builder builder)
  {
    assert builder != null;
    
    this._loadedDate = builder._loadedDate != null ? builder._loadedDate : new Date();
    this._template   = StringUtils.defaultIfEmpty(builder._template,   "");
    this._header     = StringUtils.defaultIfEmpty(builder._header,     "");
    this._layout     = StringUtils.defaultIfEmpty(builder._layout,     "");
    this._components = StringUtils.defaultIfEmpty(builder._components, "");
    this._content    = StringUtils.defaultIfEmpty(builder._content,    "");
    this._footer     = StringUtils.defaultIfEmpty(builder._footer,     "");
  }
  
  public Date getLoadedDate()
  {
    return this._loadedDate;
  }
  
  public String getTemplate()
  {
    return this._template;
  }

  public String getHeader()
  {
    return this._header;
  }

  public String getLayout()
  {
    return this._layout;
  }

  public String getComponents()
  {
    return this._components;
  }

  public String getContent()
  {
    return this._content;
  }

  public String getFooter()
  {
    return this._footer;
  }

  public String render(String dashboardContext)
  {
    return this._template.replaceAll(
                CdfRunJsDashboardWriter.DASHBOARD_HEADER_TAG, 
                Matcher.quoteReplacement(dashboardContext));
  }
  
  // --------------
  
  public static class Builder
  {
    private String _template, _header, _layout, _components, _content, _footer;
    private Date _loadedDate;
    
    public String getTemplate()
    {
      return this._template;
    }

    public Builder setTemplate(String template)
    {
      this._template = template;
      return this;
    }
    
    public String getHeader()
    {
      return this._header;
    }

    public Builder setHeader(String header)
    {
      this._header = header;
      return this;
    }
    
    public String getLayout()
    {
      return this._layout;
    }

    public Builder setLayout(String layout)
    {
      this._layout = layout;
      return this;
    }
    
    public String getComponents()
    {
      return this._components;
    }

    public Builder setComponents(String components)
    {
      this._components = components;
      return this;
    }
    
    public String getContent()
    {
      return this._content;
    }

    public Builder setContent(String content)
    {
      this._content = content;
      return this;
    }
    
    public String getFooter()
    {
      return this._footer;
    }

    public Builder setFooter(String footer)
    {
      this._footer = footer;
      return this;
    }
    
    public Date getLoadedDate()
    {
      return this._loadedDate;
    }

    public Builder setLoadedDate(Date loadedDate)
    {
      this._loadedDate = loadedDate;
      return this;
    }
    
    public CdfRunJsDashboardWriteResult build()
    {
      return new CdfRunJsDashboardWriteResult(this);
    }
  }
}
