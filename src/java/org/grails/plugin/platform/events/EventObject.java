/* Copyright 2011-2012 the original author or authors:
 *
 *    Marc Palmer (marc@grailsrocks.com)
 *    Stéphane Maldini (stephane.maldini@gmail.com)
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
package org.grails.plugin.platform.events;

import org.grails.plugin.platform.events.dispatcher.GormTopicSupport;

import java.io.Serializable;

/**
 * @author Stephane Maldini <smaldini@doc4web.com>
 * @version 1.0
 * @file
 * @date 30/12/11
 * @section DESCRIPTION
 * <p/>
 * [Does stuff]
 */
public class EventObject implements Serializable {
    private String scope = null;
    private String event = null;
    private Object data = null;
    private long timeout = -1;
    private boolean gormSession = true;

    public EventObject(String event, Object data) {
        this(event, data, null);
    }

    public EventObject(String event, Object data, String scope) {
        this(event, data, scope, scope == null || !scope.equals(GormTopicSupport.GORM_SOURCE));
    }

    public EventObject(String event, Object data, String scope, boolean gormSession) {
        this.event = event;
        this.data = data;
        this.scope = scope;
        this.gormSession = gormSession;
    }


    public long getTimeout() {
        return timeout;
    }

    public void setTimeout(long timeout) {
        this.timeout = timeout;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public String getScope() {
        return scope;
    }

    public void setScope(String scope) {
        this.scope = scope;
    }

    public String getEvent() {
        return event;
    }

    public void setEvent(String event) {
        this.event = event;
    }

    public boolean isGormSession() {
        return gormSession;
    }

    public void setGormSession(boolean gormSession) {
        this.gormSession = gormSession;
    }
}
